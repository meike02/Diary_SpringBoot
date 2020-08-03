package com.bimstart.demo.service;

import com.bimstart.demo.bean.userdatadata;
import com.bimstart.demo.mapper.userdataimp;
import com.bimstart.demo.mapper.userpasswordimp;
import com.bimstart.demo.ordinary.Eamil_verifica;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.io.*;
import java.text.SimpleDateFormat;
import java.util.*;
@Service
public class Userdataservice {
    //注入基本信息数据库的Mapper
    @Autowired
    private userdataimp userdataimp;
    //注入密码表的Mapper
    @Autowired
    private userpasswordimp userpasswordimp;
    public boolean reg(String eamil, String password, String eamil_ver, Eamil_verifica eamil_verifica){
        boolean falg=false;
        try{
            //判断此邮箱是否被注册
            List<userdatadata> eamillist = userdataimp.selecteamil(eamil);
            //没有被注册
            if(eamillist.size()==0){
                falg=true;
            }else{
                falg=false;
            }
            //判断验证码是否正确
            if(eamil_verifica.getVerifica().equals(eamil_ver))falg=true;
            if(falg==true){
                //创建用户的个人文件夹
                File file = new File("src/userfile/"+eamil+"/file");
                if(!file.exists()){
                    file.mkdirs();
                }
                File file1 = new File("src/userfile/"+eamil+"/diary");
                if(!file1.exists()){
                    file1.mkdirs();
                }
                File img = new File("src/userfile/img.jpg");
                byte[] imgbytes = new byte[1204*2*1024];
                File user_img = new File("src/userfile/"+eamil+"/img.jpg");
                FileInputStream fis = new FileInputStream(img);
                FileOutputStream fos = new FileOutputStream(user_img);
                fos.write(imgbytes,0,fis.read(imgbytes));
                fis.close();
                fos.close();


                //用户的个数
                int userdatasize = userdataimp.selectuserdata().size();
                //注册的时间
                Date date = new Date();
                long times = date.getTime();//时间戳
                SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
                String dateString = formatter.format(date);
                String imgurl = "C:/userfil/"+eamil+"/img.jpg";
                userdataimp.insert(eamil,"第"+(userdatasize)+"名用户",dateString,imgurl);
                userdataimp.insertpassword(eamil,password);
            }
        }catch (Exception e){
            return false;
        }
        return true;
    }

    public boolean login(String eamil, String password){
        try {
            List<userdatadata> eamillist = userdataimp.selecteamil(eamil);
            if(eamillist.size()==1){
                if(userpasswordimp.selectuserdataword(eamil,password).size()==1){
                    return true;
                }else{
                    return false;
                }
            }else{
                return false;
            }
        }catch (Exception e){
            return false;
        }
    }
    public userdatadata selectusereamildata(String eamil){
        return userdataimp.selectusereamlidata(eamil);
    }
    public String userimgurl(String eamil){
        return userdataimp.userimgurl(eamil);
    }
}
