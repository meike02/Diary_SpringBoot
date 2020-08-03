package com.bimstart.demo.ordinary;
import org.springframework.stereotype.Component;

import java.util.*;
@Component
public class Eamil_verifica {
    public String verifica;

    public void setVerifica() {
        String ver="";
        int shuzi=0;
        for(int i=0;i<6;i++){
            shuzi=(new Random().nextInt(10));
            ver=ver+String.valueOf(shuzi);
        }
        this.verifica = ver;
    }

    public String getVerifica() {
        return verifica;
    }
}
