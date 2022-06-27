package com.tangzq.service.impl;

import com.tangzq.model.User_me;
import com.tangzq.repository.UserRepository;
import com.tangzq.service.UserService;
import com.tangzq.utils.GravatarUtils;
import com.tangzq.vo.RegisterUserVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.DigestUtils;
import org.springframework.util.StringUtils;

import java.sql.Timestamp;
import java.util.Date;
import java.util.Optional;

/**
 * @author tangzhiqiang
 */
@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    @Override
    public User_me  createUser(RegisterUserVo vo) {
        if(null==vo){
            return null;
        }
        User_me user = new User_me();
        user.setUsername(vo.getUsername());
        user.setPassword(DigestUtils.md5DigestAsHex(vo.getPassword().getBytes()));
        user.setDateCreated((Timestamp) new Date());
        user.setisactive(true);
        /*
        user.setEmail(vo.getEmail());
        user.setAvatarURL(GravatarUtils.makeGravatar(vo.getEmail()));
        user.setCreateAt(new Date());
        user.setUpdateAt(new Date());
        */
        return userRepository.save(user);
    }

    @Override
    public User_me  getUser(int uid) {
      User_me optional=userRepository.findById(uid);
 //       Optional<User_me> optional=userRepository.findById(Integer.toString(uid));
    //    return optional.isPresent()?optional.get():null;
        return optional.getUsername().isEmpty() ? null:optional ;
    }

    @Override
    public User_me  findUser(String username, String password) {
      //  String encrypedPwd= DigestUtils.md5DigestAsHex(password.getBytes());
      // return userRepository.findByUsernameAndPassword(username,encrypedPwd);
       return userRepository.findByUsernameAndPassword(username,password);
       //return null;
    }

    @Override
    public boolean isUserValid(String username, String password) {
        if(StringUtils.isEmpty(username)|| StringUtils.isEmpty(password)){
            return false;
        }

        User_me  user = findUser(username,password);
        if(null!=user){
            return true;
        }
        return false;
    }

    @Override
    public User_me  findByUsername(String username) {
        return userRepository.findByUserName(username);
    }
/*

    @Override
    public User_me  findUserByEmail(String email) {
        return userRepository.findByEmail(email);
    }
*/

    @Override
    public User_me  updateUserInfo(User_me user) {
        if((null==user) || (user.getId() <0 ) ){
            return null;
        }
        User_me userInDB=this.getUser((user.getId()) );
        if(null==userInDB){
            return null;
        }
        user.setUsername(userInDB.getUsername());
        user.setPassword(userInDB.getPassword());
        /*
        user.setAvatarURL(userInDB.getAvatarURL());
        if(null==user.getEmail()){
            user.setEmail(userInDB.getEmail());
        }
        user.setCreateAt(userInDB.getCreateAt());
        user.setUpdateAt(new Date());
        */
        return userRepository.save(user);
    }

    @Override
    public User_me  updatePwd(int userId, String newPwd) {
        User_me  userInDb=getUser(userId);
        if(null==userInDb){
            return null;
        }
        String encrypedNewPwd= DigestUtils.md5DigestAsHex(newPwd.getBytes());
        userInDb.setPassword(encrypedNewPwd);
        return userRepository.save(userInDb);
    }

    @Override
    public User_me  updateAvatar(int userId, String avatarURL, boolean isUploaded) {
        User_me  userInDb=getUser(userId);
        if(null==userInDb){
            return null;
        }
        /*
        userInDb.setAvatarURL(avatarURL);
        userInDb.setAvatarURLByUploaded(isUploaded);
        */
        return userRepository.save(userInDb);
    }
}
