package entity;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;


import javax.persistence.*;
import java.io.Serializable;

/**
 * Created by 马东 on 2017/9/23.
 */
@Entity
@Table(name = "m_user")
public class User implements Serializable{
    private static final long serialVersionUID = 8127035730921338189L;
    @Id
    private Integer id;
    @Column(nullable = false,name = "USER_NUM")
    private String userNum;
    @Column(nullable = false,name = "PWD")
    private String pwd;
    @Column(nullable = false,name = "USER_NAME")
    private String userName;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getUserNum() {
        return userNum;
    }

    public void setUserNum(String userNum) {
        this.userNum = userNum;
    }

    public String getPwd() {
        return pwd;
    }

    public void setPwd(String pwd) {
        this.pwd = pwd;
    }
    public static String toJson(String userNum, String pwd){
        User user = new User();
        user.setUserNum(userNum);
        user.setPwd(pwd);
        return JSON.toJSONString(user);
    }
    public static User toUser(String userJson){
        JSONObject object = JSON.parseObject(userJson);
        String userNum = object.getString("userNum");
        String pwd = object.getString("pwd");
        User user = new User();
        user.setUserNum(userNum);
        user.setPwd(pwd);
        return user;
    }
}
