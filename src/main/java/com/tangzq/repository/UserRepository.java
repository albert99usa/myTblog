package com.tangzq.repository;

import com.tangzq.model.User_me;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;



/**
 * User文檔操作類
 * @author tangzhiqiang
 */
@Repository
public interface UserRepository extends CrudRepository<User_me, String> {

    /**
     * 用戶名查找用戶
     *
     * @param username
     * @return
     */
    @Query( "SELECT u FROM User_me u WHERE u.username=?1")
//    User findByUsername(String username);
    User_me findByUserName(String userName);



    /**
     * 郵件查找用戶
     *
     * @param email
     * @return
     */
    //  User_me findByEmail(String email);

    /**
     * 用戶名就、密碼查找
     *
     * @param username
     * @param password
     * @return
     */
    @Query("select u from User_me u  where u.username=?1 and u.password=?2")
    User_me findByUsernameAndPassword(String username, String password);

    @Query("select  u from User_me u where u.id=?1")
    User_me findById(int id);
}

