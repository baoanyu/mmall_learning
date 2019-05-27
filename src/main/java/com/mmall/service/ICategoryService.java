package com.mmall.service;

import com.mmall.common.ServerResponse;
import com.mmall.pojo.Category;

import java.util.List;

/**
 * ICategoryService
 *
 * @author bay
 * @date 2019-05-21-0021 14:03
 */
public interface ICategoryService {


    /**
     * 添加品类
     *
     * @param categoryName
     * @param parentId
     * @return
     */
    ServerResponse addCategory(String categoryName, Integer parentId);


    /**
     * 更新品类
     *
     * @param categoryId
     * @param categoryName
     * @return
     */
    ServerResponse updateCategoryName(Integer categoryId, String categoryName);


    /**
     * 查询子节点的category信息，并且不递归，保持评级
     *
     * @param categoryId
     * @return
     */
    ServerResponse<List<Category>> getChildrenParalleCategory(Integer categoryId);


    /**
     * 递归查询本节点的id及孩子节点的id
     *
     * @param categoryId
     * @return
     */
    ServerResponse<List<Integer>> selectCategoryAndChildrenById(Integer categoryId);
}
