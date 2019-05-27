package com.mmall.controller.portal;

import com.github.pagehelper.PageInfo;
import com.mmall.common.ServerResponse;
import com.mmall.pojo.Product;
import com.mmall.service.IProductService;
import com.mmall.vo.ProductDetailVo;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * ProductController
 *
 * @author bay
 * @date 2019-05-24-0024 10:55
 */
@RestController
@RequestMapping("/product/")
public class ProductController {

    @Autowired
    private IProductService iProductService;


    @RequestMapping("detail.do")
    public ServerResponse<ProductDetailVo> detail(Integer id){
        return iProductService.getProductDetail(id);
    }

    @RequestMapping("list.do")
    public ServerResponse<PageInfo> list(@RequestParam(value = "keyword",required = false)String keyword,
                                         @RequestParam(value = "categoryId",required = false)Integer categoryId,
                                         @RequestParam(value = "pageNum",defaultValue = "1") int pageNum,
                                         @RequestParam(value = "pageSize",defaultValue = "10") int pageSize,
                                         @RequestParam(value = "orderBy",defaultValue = "") String orderBy){
        return iProductService.getProductByKeywordCategory(keyword,categoryId,pageNum,pageSize,orderBy);
    }


}
