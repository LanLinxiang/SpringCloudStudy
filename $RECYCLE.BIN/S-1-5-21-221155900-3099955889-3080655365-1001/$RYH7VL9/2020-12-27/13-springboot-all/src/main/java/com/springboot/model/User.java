package com.springboot.model;

import org.springframework.format.annotation.DateTimeFormat;

import java.io.Serializable;
import java.util.Date;

public class User implements Serializable {
    private Long id;

    private String username;

    private String password;

    private String realName;

    private Integer age;

    private Integer sex;
    /**
     * 指定日期格式，指定后Spring就会将请求中符合这个格式的字符串数据自动转换成日期数据然后封装到这个属性上
     * 这个注解还可以写在控制器的Date类型的方法形参前面完成数据的封装
     */
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date birthday;

    private Integer xl;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
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

    public String getRealName() {
        return realName;
    }

    public void setRealName(String realName) {
        this.realName = realName;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public Integer getSex() {
        return sex;
    }

    public void setSex(Integer sex) {
        this.sex = sex;
    }

    public Date getBirthday() {
        return birthday;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }

    public Integer getXl() {
        return xl;
    }

    public void setXl(Integer xl) {
        this.xl = xl;
    }
}