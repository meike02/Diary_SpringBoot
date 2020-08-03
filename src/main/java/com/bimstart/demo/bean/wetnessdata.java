package com.bimstart.demo.bean;

import org.springframework.stereotype.Component;

@Component
public class wetnessdata {
    private String password;
    private String phone;
    private String email;
    private String nickname;
    private Integer within;
    private Integer temp;
    private String text;
    private String img;
    private String name;

    public String getPassword() {
        return password;
    }

    public String getPhone() {
        return phone;
    }

    public String getEmail() {
        return email;
    }

    public String getNickname() {
        return nickname;
    }

    public Integer getWithin() {
        return within;
    }

    public Integer getTemp() {
        return temp;
    }

    public String getText() {
        return text;
    }

    public String getImg() {
        return img;
    }

    public String getName() {
        return name;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    public void setWithin(Integer within) {
        this.within = within;
    }

    public void setTemp(Integer temp) {
        this.temp = temp;
    }

    public void setText(String text) {
        this.text = text;
    }

    public void setImg(String img) {
        this.img = img;
    }

    public void setName(String name) {
        this.name = name;
    }
}
