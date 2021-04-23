package com.study.domain;

import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;

/**
 * 用户
 */
@DynamicUpdate
@DynamicInsert
@Entity
@Table(name = "T_USER")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")//, columnDefinition = "自增主键"
    private int id;
    @Column(name = "username",unique = true)//, columnDefinition = "用户名"
    private String username;//用户名
    @Column(name = "password")//, columnDefinition = "密码"
    @NotEmpty
    private String password;//密码
    @Column(name = "email")
    //, columnDefinition = "邮箱"
    private String email;
    @Column(name = "phone_num")
    //, columnDefinition = "电话号码"
    private String phoneNum;
    @Column(name = "role_type")
    //, columnDefinition = "角色，0为管理员，1为用户"
    private String roleType;


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhoneNum() {
        return phoneNum;
    }

    public void setPhoneNum(String phoneNum) {
        this.phoneNum = phoneNum;
    }

    public String getRoleType() {
        return roleType;
    }

    public void setRoleType(String roleType) {
        this.roleType = roleType;
    }


    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", email='" + email + '\'' +
                ", phoneNum='" + phoneNum + '\'' +
                ", roleType='" + roleType + '\'' +
                '}';
    }
}
