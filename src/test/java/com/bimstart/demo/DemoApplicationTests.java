package com.bimstart.demo;

import com.bimstart.demo.bean.userdatadata;
import com.bimstart.demo.mapper.userdataimp;
import com.bimstart.demo.mapper.userdiaryimp;
import com.bimstart.demo.mapper.userpasswordimp;
import com.bimstart.demo.ordinary.Eamil_verifica;
import com.bimstart.demo.ordinary.file.Filedata;
import com.bimstart.demo.ordinary.file.Imgbase;
import com.bimstart.demo.ordinary.file.diary;
import com.bimstart.demo.service.FileService;
import com.bimstart.demo.service.Userdataservice;
import javafx.beans.property.SimpleMapProperty;
import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSenderImpl;
import org.springframework.mail.javamail.MimeMessageHelper;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;
import javax.xml.ws.soap.Addressing;
import java.io.*;
import java.util.Base64;
import java.util.List;

@SpringBootTest
class DemoApplicationTests {
//    @Autowired
//    private person per;
//    @Autowired
//    JavaMailSenderImpl mailSender;
//    @Autowired
//    private userdataimp userdataimp;
//    @Autowired
//    private userpasswordimp userpasswordimp;
//    @Autowired
//    Userdataservice userdataservice;
//    Logger logger = LoggerFactory.getLogger(getClass());
//
//    @Autowired
//    private com.bimstart.demo.mapper.userdiaryimp userdiaryimp;
//    @Test
//    void contextLoads() throws IOException {
//        File file = new File("src/userfile/"+"2088258541@qq.com"+"/file");
//        System.out.println(file.exists()+"aaaaaaaaaaa");
//        if(!file.exists()){
//            file.mkdirs();
//        }
//        File img = new File("src/userfile/img.jpg");
//        byte[] imgbytes = new byte[1204*2*1024];
//        File user_img = new File("src/userfile/2088258541@qq.com/img.jpg");
//        FileInputStream fis = new FileInputStream(img);
//        FileOutputStream fos = new FileOutputStream(user_img);
//        fos.write(imgbytes,0,fis.read(imgbytes));
//        fis.close();
//        fos.close();
//        userdataimp.insert("2088258541@qq.com","第0名用户","2020-07-28","src/userfile/"+"2088258541@qq.com/img.jpg");
//        userdataimp.insertpassword("2088258541@qq.com","aiwt1314");
//    }
//    @Test
//    public void ssss(){
//       String eamil = "2079137497@qq.com";
//       String diary_book_name = "日记的地方";
//        File diary = new File("src/userfile/"+"2079137497@qq.com"+"/diary");
//        File[] diarylist = diary.listFiles();
//        String[] diarysnamme = new String[diarylist.length];
//        int p=0;
//        for(int i=0;i<diarylist.length;i++){
//            if(diarylist[i].isDirectory()){
//                diarysnamme[i] = diarylist[i].getName();
//                System.out.println(diarysnamme[i]);
//            }
//
//        }
//        File diary_book = new File("src/userfile/"+"2079137497@qq.com"+"/diary/"+"aaaaa");
//        if(diary_book.exists()==false){
//            diary_book.mkdir();
//        }
//        String[] strbase64;
//        Imgbase[] img1 = new Imgbase[1024];
//        try{
//            File diary_book_img = new File("src/userfile/"+eamil+"/diary/"+diary_book_name+"/img");
//            File[] diarylist_img = diary_book_img.listFiles();
//            FileInputStream inputStream;
//            int p=0;
//            strbase64 = new String[diarylist_img.length];
//            byte[] bytes;
//            for(int i=0;i<diarylist_img.length;i++){
//                if(diarylist_img[i].isFile()){
//                    inputStream = new FileInputStream(diarylist_img[i]);
//                    bytes = new byte[(int) diarylist_img[i].length()];
//
//                    inputStream.read(bytes,0, (int) diarylist_img[i].length());
//                    strbase64[p++] = "url(data:image/png;base64,"+Base64.getEncoder().encodeToString(bytes)+")";
//                    System.out.println(strbase64[p-1]);
//                    System.out.println("=========================");
//                }
//            }
//            for(int i=0;i<2;i++){
//                img1[i]=new Imgbase();
//                img1[i].backgroundImage=(String)strbase64[i];
//                System.out.println("bbbbbbbbbb");
//                System.out.println(img1[i].toString());
//            }
//        }catch (Exception e){
//            System.out.println(e);
//        }

//        File diary_book = new File("src/userfile/"+eamil+"/diary/"+diary_book_name);
//        if(diary_book.exists()==false){
//            diary_book.mkdir();
//        }
//        File diary_book_img = new File("src/userfile/"+eamil+"/diary/"+diary_book_name+"/img");
//        if(diary_book_img.exists()==false){
//            diary_book_img.mkdir();
//        }
//        File diary_book_text = new File("src/userfile/"+eamil+"/diary/"+diary_book_name+"/text");
//        if(diary_book_text.exists()==false){
//            diary_book_text.mkdir();
//        }
//        int p=0;
//        File diary_book = new File("src/userfile/"+eamil+"/diary/"+diary_book_name+"/text");
//        File[] diarylist = diary_book.listFiles();
//        String[] diary_name;
//        String[] diary_text;
//        Imgbase[] img = new FileService().look_diary_book_img(eamil,diary_book_name);
//
//        diary[] diarys = new diary[diarylist.length];
//
//        try{
//
//            diary_name = new String[diarylist.length];
//            diary_text = new String[diarylist.length];
//            FileInputStream fileInputStream ;
//            byte[] bytes;
//
//            for(int i=0;i<diarylist.length;i++){
//                if(diarylist[i].isFile()){
//                    diary_name[p] = diarylist[i].getName().replaceAll("[.][^.]+$", "");
//                    System.out.println(diary_name[p]);
//                    fileInputStream = new FileInputStream(diarylist[i]);
//                    bytes = new byte[(int) diarylist[i].length()];
//                    fileInputStream.read(bytes);
//                    diary_text[p++]=new String(bytes);
//                    System.out.println(diary_text[p-1]);
//                    System.out.println("------------------------------");
//                }
//            }
//            diarys = new diary[p];
//            for(int i=0;i<p;i++){
//                diarys[i] = new diary();
//                diarys[i].setText(diary_text[i]);
//                diarys[i].setTitle(diary_name[i]);
//                diarys[i].setImg(img[i]);
//                System.out.println(diarys[i].toString());
//                System.out.println("=======================================");
//            }
//        }catch (Exception e){
//            System.out.println(e);
//        }
//        File diary = new File("src/userfile/"+eamil+"/diary");
//        File[] diarylist = diary.listFiles();
//        String[] diary_book_name = new String[diarylist.length];
//        System.out.println("vvvvvvvvvvvvv");
//        for(int i=0;i<diarylist.length;i++){
//            if(diarylist[i].isDirectory()){
//                diary_book_name[i] = diarylist[i].getName().replaceAll("[.][^.]+$", "");
//                System.out.println(diary_book_name[i]);
//            }
//        }
//        userdiaryimp.insert(eamil,"src/userfile/"+eamil+"/diary/"+diary_book+"/text/"+"啊啊"+".txt",true,0);







//        String[] strbase64;
//        Imgbase[] img1 = new Imgbase[1024];
//        try {
//            File diary_book_img = new File("C:/Users/Lenovo/Desktop/aaaaa");
//            File[] diarylist_img = diary_book_img.listFiles();
//            FileInputStream inputStream;
//            int p = 0;
//            strbase64 = new String[diarylist_img.length];
//            byte[] bytes;
//            for (int i = 0; i < diarylist_img.length; i++) {
//                if (diarylist_img[i].isFile()) {
//                    inputStream = new FileInputStream(diarylist_img[i]);
//                    bytes = new byte[(int) diarylist_img[i].length()];
//
//                    inputStream.read(bytes, 0, (int) diarylist_img[i].length());
//                    strbase64[p++] = "data:image/png;base64," + Base64.getEncoder().encodeToString(bytes);
//                    System.out.println(strbase64[p - 1]);
//                    System.out.println("=========================");
//                }
//            }
//        }catch (Exception e){
//            System.out.println(e);
//        }
//        String file_url="";
//        File file = new File("src/userfile/"+eamil+"/file"+file_url);
//        File[] filelist = file.listFiles();
//        Filedata[] filedata = new Filedata[1024];
//        int p=0;
//        try{
//            for(int i=0;i<filelist.length;i++){
//                if(filelist[i].isDirectory()){
//                    filedata[p] = new Filedata();
//                    filedata[p].name=filelist[i].getName();
//                    filedata[p++].type="mkdir";
//                }
//            }
//            File filepjrj = new File("src/userfile/"+eamil+"/file"+file_url+"/file.pjrj");
//            FileInputStream fileInputStream = new FileInputStream(filepjrj);
//            BufferedReader br = new BufferedReader(new InputStreamReader(fileInputStream));
//            int temp=0;
//            String[] line = new String[1024];
//            while ((line[temp++] = br.readLine()) != null) {
//                System.out.println(line[temp-1]);
//            }
//
//            for(int i=0;i<temp;i++){
//                filedata[p] = new Filedata();
//                for(int j=line[i].length()-1;j>=0;j--){
//
//                    if(line[i].charAt(j)=='.'){
//                        filedata[p].type=line[i].substring(j+1,line[i].length());
//                        System.out.println(line[i].substring(j+1,line[i].length()));
//                    }
//                    if(line[i].charAt(j)=='/' || j==0){
//                        filedata[p].name=line[i].substring(j+1,line[i].length());
//                        System.out.println(line[i].substring(j+1,line[i].length()));
//                    }
//
//                }
//                p++;System.out.println(p);
//
//            }
//            for(int i=0;i<p;i++){
//
//                System.out.println(filedata[i].toString());
//            }
//
//        }catch (Exception e){
//            System.out.println(e);
//        }
//
//    }
//    @Test
//    void aaaa(){
//        String eamil = "2079137497@qq.com";
//        String file_url="/a";
//        String filename="test.txt";
//        File file_pjrj = new File("src/userfile/"+eamil+"/file"+file_url+"/file.pjrj");
//        try{
//            FileOutputStream fileOutputStream = new FileOutputStream(file_pjrj,true);
//            fileOutputStream.write((file_url+"/"+filename+"\n\r").getBytes());
//            String file_name_qu_xiegang ="";
//            for(int i=0;i<(file_url+filename).length();i++){
//                if((file_url+filename).charAt(i)!='/')file_name_qu_xiegang=file_name_qu_xiegang+(file_url+filename).charAt(i);
//
//            }
////            File file_name = new File();
//            System.out.println(file_name_qu_xiegang);
//        }catch (Exception e){
//            System.out.println(e);
//        }
//    }
//    @Test
//    void eamli(){
//        SimpleMailMessage message = new SimpleMailMessage();
//        message.setSubject("测试邮件");
//        message.setText("测试");
//        message.setTo("2079137497@qq.com");
//        message.setFrom("2088258541@qq.com");
//        mailSender.send(message);
//        System.out.println("成功");
//    }
//    @Test
//    void eamli1() throws MessagingException {
//        //使用上面Bean的对象得到一个MimeMessage的对象
//        MimeMessage mimeMessage = mailSender.createMimeMessage();
//        /**
//         * 使用MimeMessageHelper进行帮助邮件的发送
//         * 参数 ：第一个imeMessage对象类型 第二个是是否开启附件传输 类型为boolean
//         */
//        MimeMessageHelper helper = new MimeMessageHelper(mimeMessage,true);
//
//        helper.setSubject("测试邮件");
//        helper.setText("<h1 style='color:red'>测试</h1>",true);
//        helper.setTo("1733531294@qq.com");
//        helper.setFrom("2088258541@qq.com");
//        helper.addAttachment("1.jpg",new File("C:/Users/Lenovo/Pictures/Saved Pictures/1.jpg"));
//        mailSender.send(mimeMessage);
//        System.out.println("成功");
//    }
//    @Test
//    void eamil_ver(){
//        Eamil_verifica aaa = new Eamil_verifica();
//        aaa.setVerifica();
//        System.out.println(aaa.getVerifica());
//    }
}
