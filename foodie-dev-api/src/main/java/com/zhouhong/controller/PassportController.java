package com.zhouhong.controller;

import com.zhouhong.pojo.Users;
import com.zhouhong.pojo.bo.UserBO;
import com.zhouhong.service.UserService;
import com.zhouhong.utils.CookieUtils;
import com.zhouhong.utils.JSONResult;
import com.zhouhong.utils.JsonUtils;
import com.zhouhong.utils.MD5Utils;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

/**
 * @ClassName: HelloController
 * @Description:
 * @Author: 周红
 * @NickName: Tom-shuhu
 * @Date: Created in 2020/12/7
 **/
//@Controller

@Api(value = "注册登录",tags = "用于注册登录的相关接口")
@RestController
@RequestMapping("passport")
public class PassportController {
    @Autowired
    private UserService userService;
    /**
     * 判断用户名是否存在、为空
     * @param username
     * @return
     */
    @ApiOperation(value = "用户名是否存在",notes = "用户名是否存在",httpMethod = "GET")
    @GetMapping("/usernameIsExist")
    public JSONResult usernameIsExist(@RequestParam String username) {
        //1.判断用户名不能为空
        if (StringUtils.isBlank(username)){
            return JSONResult.errorMsg("用户名不能为空");
        }
        //2.查找注册的用户是否存在
        boolean isExist = userService.queryUsernameIsExist(username);
        if (isExist){
            return JSONResult.errorMsg("用户名已经存在");
        }
        //3.请求成功，用户名没有重复
        return JSONResult.ok();
    }

    /**
     * 注册
     * @param userBO
     * @return
     */
    @ApiOperation(value = "用户注册",notes = "用户名注册",httpMethod = "POST")
    @PostMapping("/regist")
    public JSONResult regist(@RequestBody UserBO userBO , HttpServletRequest request ,
                             HttpServletResponse response) {
        String username = userBO.getUsername();
        String password = userBO.getPassword();
        String confirmPwd = userBO.getConfirmPassword();
        //0.判断用户名和密码不为空
        if (StringUtils.isBlank(username) ||
                StringUtils.isBlank(password) ||
                StringUtils.isBlank(confirmPwd)){
            return JSONResult.errorMsg("用户名或密码不能为空");
        }
        //1.查询用户名是否存在
        boolean isExist = userService.queryUsernameIsExist(username);
        if (isExist){
            return JSONResult.errorMsg("用户名已经存在");
        }
        //2.密码长度不能少于6位
        if (password.length() < 6){
            return JSONResult.errorMsg("密码长度不能小于6");
        }
        //3.判断两次密码是否一致
        if (!password.equals(confirmPwd)){
            return JSONResult.errorMsg("两次密码输入不一致");
        }
        //4.实现注册
        Users usersResult = userService.createUser(userBO);

        usersResult = setNullProperty(usersResult);
        CookieUtils.setCookie(request , response , "user" ,
                JsonUtils.objectToJson(usersResult) , true);
        // TODO 生成用户token，存入redis会话
        // TODO 同步购物车数据

        return JSONResult.ok();
    }

    /**
     * 用户登录
     * @param userBO
     * @return
     */
    @ApiOperation(value = "用户登录",notes = "用户登录",httpMethod = "POST")
    @PostMapping("/login")
    public JSONResult login(@RequestBody UserBO userBO , HttpServletRequest request ,
                            HttpServletResponse response) throws Exception{
        String username = userBO.getUsername();
        String password = userBO.getPassword();
        //0.判断用户名和密码不为空
        if (StringUtils.isBlank(username) ||
                StringUtils.isBlank(password)){
            return JSONResult.errorMsg("用户名或密码不能为空");
        }
        //1.实现登录
        Users usersResult = userService.queryUserForLogin(username,
                MD5Utils.getMD5Str(password));
        if (usersResult == null){
            return JSONResult.errorMsg("用户名或密码错误");
        }

        usersResult = setNullProperty(usersResult);
        CookieUtils.setCookie(request , response , "user" ,
                JsonUtils.objectToJson(usersResult) , true);

        // TODO 生成用户token，存入redis会话
        // TODO 同步购物车数据

        return JSONResult.ok(usersResult);
    }
    private Users setNullProperty(Users usersResult){
        usersResult.setPassword(null);
        usersResult.setMobile(null);
        usersResult.setEmail(null);
        usersResult.setCreatedTime(null);
        usersResult.setUpdatedTime(null);
        usersResult.setBirthday(null);
        return usersResult;
    }

    @ApiOperation(value = "用户退出登录",notes = "用户退出登录",httpMethod = "POST")
    @PostMapping("/logout")
    public JSONResult logout(@RequestParam String userId ,
                             HttpServletRequest request ,
                             HttpServletResponse response){
        //清除用户相关的信息的cookie
        CookieUtils.deleteCookie(request , response , "user");
        //TODO  用户退出登录，需要清空购物车
        //TODO  在分布式会话中需要清空用户数据
        return JSONResult.ok();
    }
}
