package com.example.demo.dao;

import com.example.demo.entity.User;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import javax.transaction.Transactional;

/**
 * Created by 马东 on 2017/9/24.
 */
public interface UserDao extends CrudRepository<User,Integer> {
    @Transactional
    @Modifying
    @Query(value = "insert into m_user(user_name,user_num,pwd) value(?1,?2,?3)", nativeQuery = true)
    int insertUser(String userName,String userNum,String pwd);
    @Query("select u from User u where u.userNum = :Usernum and u.pwd = :pwd")
    User selectByNumAndPwd(@Param("Usernum") String userNum, @Param("pwd") String pwd);
    @Query("select u from User u where u.userNum = :Usernum")
    User selectByNum(@Param("Usernum") String userNum);
}
