package com.qks.makerSpace.service.Impl;

import com.alibaba.fastjson.JSONObject;
import com.qks.makerSpace.dao.LoginDao;
import com.qks.makerSpace.dao.UserDao;
import com.qks.makerSpace.entity.User;
import com.qks.makerSpace.exception.ServiceException;
import com.qks.makerSpace.service.LoginService;
import com.qks.makerSpace.service.UserService;
import com.qks.makerSpace.util.JWTUtils;
import com.qks.makerSpace.util.MyResponseUtil;
import org.apache.logging.log4j.message.ReusableMessage;
import org.springframework.stereotype.Service;

import java.io.Serializable;
import java.util.*;

@Service
public class LoginServiceImpl implements LoginService, Serializable {

    private final LoginDao loginDao;

    public LoginServiceImpl(LoginDao loginDao) {
        this.loginDao = loginDao;
    }



    /**
     * 领导或管理员登陆
     * @param map
     * @return
     */
    @Override
    public Map<String, Object> AdminOrLeaderLogin(Map<String, Object> map) {

        String name = map.get("name").toString();
        String password = map.get("password").toString();

        Map<String, Object> data = new HashMap<>();

        if (loginDao.AdminOrLeaderLogin(name,password) != null) {

            Map<String, Object> userMap = new HashMap<>();
            userMap.put("name",name);
            userMap.put("password",password);

            String token = JWTUtils.createToken(userMap);
            data.put("token",token);

            return MyResponseUtil.getResultMap(data,0,"success");
        } else {
            return MyResponseUtil.getResultMap(null,-1,"用户不存在或密码错误");
        }

    }

    /**
     * 普通用户登陆
     * @param map
     * @return
     * @throws ServiceException
     */
    @Override
    public Map<String, Object> CommonLogin(JSONObject map) throws ServiceException {

        String username = map.get("name").toString();
        String password = map.get("password").toString();
        String userId = loginDao.commonLogin(username,password);


        Map<String, Object> data = new HashMap<>();

        if (userId != null) {
            Map<String, Object> user = new HashMap<>();

            user.put("name",username);
            user.put("password",password);
            user.put("userId", userId);

            String token = JWTUtils.createToken(user);
            data.put("token",token);
        } else throw new ServiceException("用户不存在或密码错误");

        return MyResponseUtil.getResultMap(data,0,"success");

    }

}

