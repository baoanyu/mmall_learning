package com.mmall.service;

import com.mmall.common.ServerResponse;
import com.mmall.pojo.User;

/**
 * IUserService
 *
 * @author bay
 * @date 2019-05-16-0016 14:06
 */
public interface IUserService {

    /**
     * 登陆接口
     *
     * @param username
     * @param password
     * @return
     */
    ServerResponse<User> login(String username, String password);

    /**
     * 用户注册
     *
     * @param user
     * @return
     */
    ServerResponse<String> register(User user);

    /**
     * 用户校验
     *
     * @param str
     * @param type
     * @return
     */
    ServerResponse<String> checkValid(String str, String type);

    /**
     * 选择问题提示答案
     *
     * @param username
     * @return
     */
    ServerResponse selectQuestion(String username);


    /**
     * 验证问题答案是否正确
     *
     * @param username
     * @param question
     * @param answer
     * @return
     */
    ServerResponse<String> checkAnswer(String username, String question, String answer);


    /**
     * 修改密码
     *
     * @param username
     * @param passwordNew
     * @param forGetToken
     * @return
     */
    ServerResponse<String> forGetRestPassWord(String username, String passwordNew, String forGetToken);


    /**
     * 登陆状态修改密码
     *
     * @param passwordOld
     * @param passwordNew
     * @param user
     * @return
     */
    ServerResponse<String> restPassword(String passwordOld, String passwordNew, User user);


    /**
     * 更新部分信息
     *
     * @param user
     * @return
     */
    ServerResponse<User> updateInformation(User user);


    /**
     * 获取用户信息
     *
     * @param userId
     * @return
     */
    ServerResponse<User> getInformation(Integer userId);


    /**
     * 校验是否是管理员
     *
     * @param user
     * @return
     */
    ServerResponse checkAdminRole(User user);
}
