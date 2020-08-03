package com.bimstart.demo.controller;

import com.bimstart.demo.ordinary.Eamil_send;
import com.bimstart.demo.ordinary.Eamil_verifica;
import com.bimstart.demo.ordinary.file.Diary_books;
import com.bimstart.demo.ordinary.file.Filedata;
import com.bimstart.demo.ordinary.file.diary;
import com.bimstart.demo.service.FileService;
import com.bimstart.demo.service.Userdataservice;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.*;
import java.util.Base64;

@RestController
public class Diary_web {
    @Autowired
    private Eamil_send eamil_send;
    @Autowired
    private Eamil_verifica eamil_verifica;


    //注入userdata数据操作持久层bean
    @Autowired
    private Userdataservice userdataservice;
    //注入FileService的容器
    @Autowired
    private FileService fileService;
//    邮箱激活
    @GetMapping("/eamil_verification")
    public boolean eamil_verification(@RequestParam String eamil){
        eamil_verifica.setVerifica();
        try{
            eamil_send.send(eamil_verifica.getVerifica(),eamil);
            return true;
        }catch (Exception e){
            return false;
        }

    }
    @PostMapping("/reg")
    public boolean reg(@RequestParam String eamil,@RequestParam String password,@RequestParam String yanzheng){
        boolean falg=false;
        if(userdataservice.reg(eamil,password,yanzheng,eamil_verifica)==true)
            return true;
        return false;
    }
    @PostMapping("/login")
    public boolean login(@RequestParam String eamil,@RequestParam String password){
        boolean falg=false;
        if(userdataservice.login(eamil,password)==true)return true;
        return false;
    }
//    用户的照片
    @PostMapping("/userimg")
    public String userimg(@RequestParam String eamil){
//        System.out.println(userdataservice.userimgurl(eamil));
        try{

            File file = new File(userdataservice.userimgurl(eamil));
//            System.out.println(userdataservice.userimgurl(eamil));
            FileInputStream inputStream = new FileInputStream(file);
            byte[] bytes = new byte[(int) file.length()];

            inputStream.read(bytes,0, (int) file.length());
            String strbase64 = Base64.getEncoder().encodeToString(bytes);
            return strbase64;
        }catch (Exception e){
            System.out.println("sb");
        }


        return "wu";
    }
//    查询日记本
    @PostMapping("/diary_books")
    public String[] diary_books(@RequestParam String eamil){
        return fileService.diary_books(eamil);
    }
//    新建一个日记本
    @PostMapping("/add_diary_book")
    public void add_diary_book(@RequestParam String eamil,@RequestParam String diary_book_name){
        fileService.add_diary_book(eamil,diary_book_name);
    }
//    查看日记本中的日记图片和文字
    @PostMapping("/look_diary_book")
    public diary[] diary_book_name(@RequestParam String eamil, @RequestParam String diary_book_name){
        return fileService.look_diary_book(eamil,diary_book_name);
    }
//    得到日记本加工后的对象
    @PostMapping("/diary_books_object")
    public Diary_books[] diary_books_object(@RequestParam String eamil){
        return fileService.diary_books_object(eamil);
    }
//    保存发布的日记
    @PostMapping("/insert_diary")
    public boolean insert_diary(
            @RequestParam String eamil,
            @RequestParam String within,
            @RequestParam String diary_book,
            @RequestParam String title,
            @RequestParam String text) throws IOException {
        fileService.insert_diary(eamil,within,diary_book,title,text);

        return true;
    }
//    保存发布的日记的背景图片
    @PostMapping("/insert_diary_img")
    public void insert_diary_img(@RequestParam("file") MultipartFile file) throws IOException {
        fileService.insert_diary_img = file.getBytes();
    }
    @PostMapping("/file_url_files")
    public Filedata[] file_url_files(@RequestParam String eamil,@RequestParam String file_url){
        return fileService.file_url_files(eamil,file_url);

    }
    @PostMapping("/file_upload")
    public boolean file_upload(@RequestParam String eamil,@RequestParam String file_url,@RequestParam MultipartFile file,@RequestParam String filename){
        return fileService.file_upload(eamil,file_url,file,filename);
    }
}
