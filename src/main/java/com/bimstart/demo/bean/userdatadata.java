package com.bimstart.demo.bean;

import org.springframework.stereotype.Component;

@Component
public class userdatadata {
    private String eamil ;
    private String name;
    private String img;
    private Integer within;
    private String data;
    private Double money;

    public String getEamil() {
        return eamil;
    }

    public String getName() {
        return name;
    }

    public String getImg() {
        return img;
    }

    public Integer getWithin() {
        return within;
    }

    public String getData() {
        return data;
    }

    public Double getMoney() {
        return money;
    }

    public void setEamil(String eamil) {
        this.eamil = eamil;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setImg(String img) {
        this.img = img;
    }

    public void setWithin(Integer within) {
        this.within = within;
    }

    public void setData(String data) {
        this.data = data;
    }

    public void setMoney(Double money) {
        this.money = money;
    }
}
