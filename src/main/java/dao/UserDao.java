package dao;

import entity.User;
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
    @Query(value = "insert into User (userName,userNum,pwd) value(userName,userNum,pwd)")
    int insertUser(@Param("userName")String userName,@Param("userNum")String userNum,@Param("pwd") String pwd);
    @Query("select u from User u where u.userNum = :userNum and u.pwd = :pwd")
    User selectByNumAndPwd(@Param("userNum")String userNum,@Param("pwd")String pwd);
}
