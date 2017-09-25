package service;

import dao.UserDao;
import entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by 马东 on 2017/9/24.
 */
@Service
public class UserService {
    @Autowired
    UserDao userDao;
    public User selectUserByUserNumAndPwd(String userNum,String pwd){
        return userDao.selectByNumAndPwd(userNum,pwd);
    }
    public int insertUser(User user){
        return userDao.insertUser(user.getUserName(),user.getUserNum(),user.getPwd());
    }
}
