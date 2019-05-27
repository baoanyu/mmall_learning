package com.mmall.service;

import com.github.pagehelper.PageInfo;
import com.mmall.common.ServerResponse;
import com.mmall.pojo.Product;
import com.mmall.vo.ProductDetailVo;

/**
 * IProductService
 *
 * @author bay
 * @date 2019-05-22-0022 14:09
 */
public interface IProductService {
    /**
     * 新增或更新商品
     *
     * @param product
     * @return
     */
    ServerResponse saveOrUpdateProduct(Product product);


    /**
     * 修改商品状态
     *
     * @param productId
     * @param status
     * @return
     */
    ServerResponse setSaleStatus(Integer productId, Integer status);


    /**
     * 商品详情页
     *
     * @param productId
     * @return
     */
    ServerResponse<ProductDetailVo> manageProductDetail(Integer productId);


    /**
     * 分页查询商品
     *
     * @param pageNum
     * @param pageSize
     * @return
     */
    ServerResponse<PageInfo> getProductList(int pageNum, int pageSize);


    /**
     * 查询商品分页
     *
     * @param productName
     * @param productId
     * @param pageNum
     * @param pageSize
     * @return
     */
    ServerResponse<PageInfo> searchProduct(String productName, Integer productId, int pageNum, int pageSize);


    /**
     * 商品上下架
     * @param id
     * @return
     */
    ServerResponse<ProductDetailVo> getProductDetail(Integer id);


    /**
     *
     * @param keyword
     * @param categoryId
     * @param pageNum
     * @param pageSize
     * @param orderBy
     * @return
     */
    ServerResponse<PageInfo> getProductByKeywordCategory(String keyword,Integer categoryId,int pageNum,int pageSize,String orderBy);

}
