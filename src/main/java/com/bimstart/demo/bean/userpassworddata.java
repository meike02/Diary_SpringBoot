package com.bimstart.demo.bean;

import org.springframework.stereotype.Component;

@Component
public class userpassworddata {
    private String eamil;
    private String password;

    public String getEamil() {
        return eamil;
    }

    public void setEamil(String eamil) {
        this.eamil = eamil;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
