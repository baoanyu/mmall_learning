package com.mmall.controller.backend;

import com.mmall.common.Const;
import com.mmall.common.ResponseCode;
import com.mmall.common.ServerResponse;
import com.mmall.pojo.User;
import com.mmall.service.ICategoryService;
import com.mmall.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpSession;

/**
 * CategoryManagerController
 *
 * @author bay
 * @date 2019-05-21-0021 13:47
 */

@RestController
@RequestMapping("/manage/category/")
public class CategoryManageController {

    @Autowired
    private IUserService iUserService;

    @Autowired
    private ICategoryService iCategoryService;

    @RequestMapping(value = "add_category.do")
    public ServerResponse addCategory(HttpSession session, String categoryName, @RequestParam(value = "parentId", defaultValue = "0") int parentId) {
        User user = (User) session.getAttribute(Const.CURRENT_USER);
        if (user == null) {
            return ServerResponse.createByErrorCodeMessage(ResponseCode.NEED_LOGIN.getCode(), "您没有登录！请登录！");
        }
        //校验是否是管理员
        if (iUserService.checkAdminRole(user).isSuccess()) {
            //管理员
            //增加处理分类的逻辑
            return iCategoryService.addCategory(categoryName, parentId);
        } else {
            return ServerResponse.createByErrorMessage("无权限操作！需要权限！");
        }
    }

    @RequestMapping(value = "set_category_name.do")
    public ServerResponse setCategoryName(HttpSession session, Integer categoryId, String categoryName) {
        User user = (User) session.getAttribute(Const.CURRENT_USER);
        if (user == null) {
            return ServerResponse.createByErrorCodeMessage(ResponseCode.NEED_LOGIN.getCode(), "您没有登录！请登录！");
        }
        //校验是否是管理员
        if (iUserService.checkAdminRole(user).isSuccess()) {
            //更新categoryName
            return iCategoryService.updateCategoryName(categoryId, categoryName);
        } else {
            return ServerResponse.createByErrorMessage("无权限操作！需要权限！");
        }
    }

    @RequestMapping(value = "get_category.do")
    public ServerResponse getChildrenParalleCategory(HttpSession session, @RequestParam(value = "categoryId", defaultValue = "0") Integer categoryId) {
        User user = (User) session.getAttribute(Const.CURRENT_USER);
        if (user == null) {
            return ServerResponse.createByErrorCodeMessage(ResponseCode.NEED_LOGIN.getCode(), "您没有登录！请登录！");
        }
        //校验是否是管理员
        if (iUserService.checkAdminRole(user).isSuccess()) {
            //查询子节点的category信息，并且不递归，保持评级
            return iCategoryService.getChildrenParalleCategory(categoryId);
        } else {
            return ServerResponse.createByErrorMessage("无权限操作！需要权限！");
        }
    }

    @RequestMapping(value = "get_deep_category.do")
    public ServerResponse getCategoryAndDeepChildrenCategory(HttpSession session, @RequestParam(value = "categoryId", defaultValue = "0") Integer categoryId) {
        User user = (User) session.getAttribute(Const.CURRENT_USER);
        if (user == null) {
            return ServerResponse.createByErrorCodeMessage(ResponseCode.NEED_LOGIN.getCode(), "您没有登录！请登录！");
        }
        //校验是否是管理员
        if (iUserService.checkAdminRole(user).isSuccess()) {
            //查询当前节点的id 和递归子节点的id
            return iCategoryService.selectCategoryAndChildrenById(categoryId);
        } else {
            return ServerResponse.createByErrorMessage("无权限操作！需要权限！");
        }
    }
}
