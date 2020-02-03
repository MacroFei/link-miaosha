package com.xlccc.service.impl;

import com.xlccc.dao.UserDOMapper;
import com.xlccc.dao.userPasswordDOMapper;
import com.xlccc.dataobject.UserDO;
import com.xlccc.dataobject.userPasswordDO;
import com.xlccc.service.UserService;
import com.xlccc.service.model.UserModel;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserDOMapper userDOMapper;
    @Autowired
    private userPasswordDOMapper userPasswordDOMapper;
    @Override
    public UserModel getUserById(Integer id) {
        UserDO userDO = userDOMapper.selectByPrimaryKey(id);
        if (userDO == null ){
            return null ;
        }
        userPasswordDO  userPasswordDO = userPasswordDOMapper.selectByUserId(userDO.getId());
        return convertFromDataObject(userDO,userPasswordDO);
    }

    private UserModel convertFromDataObject(UserDO userDO , userPasswordDO userPasswordDO){
        if(userDO == null ){
            return null ;
        }
        UserModel userModel = new UserModel();
        BeanUtils.copyProperties(userDO , userModel);

        if(userPasswordDO != null ){
            userModel.setEncrptPassword(userPasswordDO.getEncrptPassword());
        }
        return userModel;
    }
}
