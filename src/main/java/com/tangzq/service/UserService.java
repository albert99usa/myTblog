package com.tangzq.service;

import com.tangzq.model.User_me;
import com.tangzq.vo.RegisterUserVo;

/**
 * @author tangzhiqiang
 */
public interface UserService {


    /**
     * 創建用戶
     * @param vo
     * @return
     */
    User_me createUser(RegisterUserVo vo);


    /**
     * 獲取用戶
     * @param uid
     * @return
     */
    User_me getUser(int uid);

    /**
     * 根據用戶名和密碼查找使用者
     * @param username
     * @param password
     * @return
     */
    User_me findUser(String username, String password);

    /**
     * 判斷用戶是否有效
     * @param username
     * @param password
     * @return
     */
    boolean isUserValid(String username, String password);


    /**
     * 使用用戶名查找用戶
     * @param username
     * @return
     */
    User_me findByUsername(String username);

    /**
     * 使用郵箱查找用戶
     * @param email
     * @return
     */
    //  User_me findUserByEmail(String email);

    /**
     * 更新使用者資訊
     * @param user
     * @return
     */
    User_me updateUserInfo(User_me user);


    /**
     * 修改使用者密碼
     * @param userId
     * @param newPwd
     * @return
     */
//    User_me updatePwd(String userId, String newPwd);
    User_me updatePwd(int userId, String newPwd);

    /**
     * 更新頭像
     * @param userId
     * @param avatarURL
     * @param isUploaded 是否通過上傳更新的頭像圖片
     * @return
     */
//    User_me updateAvatar(String userId, String avatarURL, boolean isUploaded);
    User_me updateAvatar(int userId, String avatarURL, boolean isUploaded);

}

