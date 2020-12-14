package com.zhouhong.service.impl;

import com.zhouhong.enums.Sex;
import com.zhouhong.mapper.UsersMapper;
import com.zhouhong.pojo.Users;
import com.zhouhong.pojo.bo.UserBO;
import com.zhouhong.service.UserService;
import com.zhouhong.utils.DateUtil;
import com.zhouhong.utils.MD5Utils;
import org.n3r.idworker.Sid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import tk.mybatis.mapper.entity.Example;

import java.util.Date;
import java.util.List;

/**
 * @ClassName: UserServiceImpl
 * @Description:
 * @Author: 周红
 * @NickName: Tom-shuhu
 * @Date: Created in 2020/12/10
 **/
@Service
public class UserServiceImpl  implements UserService {
    @Autowired
    public UsersMapper usersMapper;

    @Autowired
    private Sid sid;
    //默认头像
    public static final String USER_FACE = "https://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec=1607973168152&di=6d109364cf0fcd2fa6da1d2e711793cb&imgtype=0&src=http%3A%2F%2Fhbimg.b0.upaiyun.com%2Fb45b1e24b8cd4b040d6571c871220d7975858ebb25ff-udoUSY_fw658";
    /**
     * 登录验证
     * @param username
     * @return
     */
    @Transactional(propagation = Propagation.SUPPORTS )
    @Override
    public boolean queryUsernameIsExist(String username) {
        Example userExample = new Example(Users.class);
        Example.Criteria userCriteria = userExample.createCriteria();
        userCriteria.andEqualTo("username",username);
        Users result = usersMapper.selectOneByExample(userExample);
        return result == null ? false : true;
    }
    /**
     * 用户注册
     * @param userBO
     * @return
     */
    @Transactional(propagation = Propagation.REQUIRED)
    @Override
    public Users createUser(UserBO userBO) {
        String userId = sid.nextShort();
        Users user = new Users();
        user.setId(userId);
        user.setUsername(userBO.getUsername());
        try {
            user.setPassword(MD5Utils.getMD5Str(userBO.getPassword()));
        }catch (Exception e){
            e.printStackTrace();
        }
        //默认用户昵称同用户名
        user.setNickname(userBO.getUsername());
        //默认头像
        user.setFace(USER_FACE);
        //默认生日
        user.setBirthday(DateUtil.stringToDate("2020-01-01"));
        //默认性别为保密
        user.setSex(Sex.secret.type);
        user.setCreatedTime(new Date());
        user.setUpdatedTime(new Date());
        usersMapper.insert(user);
        return user;
    }
}
