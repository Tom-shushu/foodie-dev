package com.zhouhong.service;

import com.zhouhong.pojo.Users;
import com.zhouhong.pojo.bo.UserBO;
/**
 * @ClassName: UserService
 * @Description:
 * @Author: 周红
 * @NickName: Tom-shuhu
 * @Date: Created in 2020/12/10
 **/
public interface UserService {

    /**
     * 判断用户名是否存在
     * @param username
     * @return
     */
    public boolean queryUsernameIsExist(String username);

    /**
     * 接受前端的参数
     * @param userBO
     * @return
     */
    public Users createUser(UserBO userBO);

    /**
     * 检索用户名和密码是否匹配，用于登录
     * @param username
     * @param password
     * @return
     */
    public Users queryUserForLogin(String username ,String password);
}