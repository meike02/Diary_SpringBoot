package com.bimstart.demo.service;

import com.bimstart.demo.mapper.userdataimp;
import com.bimstart.demo.mapper.userdiaryimp;
import com.bimstart.demo.ordinary.file.Diary_books;
import com.bimstart.demo.ordinary.file.Filedata;
import com.bimstart.demo.ordinary.file.Imgbase;
import com.bimstart.demo.ordinary.file.diary;
import org.apache.ibatis.annotations.Select;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import java.io.*;
import java.util.Base64;

@Service
public class FileService {
    //这是保存日记图片时图片的字节数组
    public byte[] insert_diary_img;


    @Autowired
    private userdiaryimp userdiaryimp;
    /**
     * 查询日记本
     * @param eamil 用户的邮箱
     * @return 返回值是String【】 是日记本的名字
     */
    public String[] diary_books(String eamil){
        File diary = new File("src/userfile/"+eamil+"/diary");
        File[] diarylist = diary.listFiles();
        String[] diary_book_name = new String[diarylist.length];
        System.out.println("vvvvvvvvvvvvv");
        for(int i=0;i<diarylist.length;i++){
            if(diarylist[i].isDirectory()){
                diary_book_name[i] = diarylist[i].getName().replaceAll("[.][^.]+$", "");
                System.out.println(diary_book_name[i]);
            }
        }
        return diary_book_name;
    }

    /**
     * 新建一个日记本
     * @param eamil 用户
     * @param diary_book_name 新建日记本的名字
     */
    public void add_diary_book(String eamil,String diary_book_name){
        File diary_book = new File("src/userfile/"+eamil+"/diary/"+diary_book_name);
        if(diary_book.exists()==false){
            diary_book.mkdir();
        }
        File diary_book_img = new File("src/userfile/"+eamil+"/diary/"+diary_book_name+"/img");
        if(diary_book_img.exists()==false){
            diary_book_img.mkdir();
        }
        File diary_book_text = new File("src/userfile/"+eamil+"/diary/"+diary_book_name+"/text");
        if(diary_book_text.exists()==false){
            diary_book_text.mkdir();
        }
    }

    /**
     *
     * @param eamil
     * @param diary_book_name 用户查询哪个日记本下的日记
     * @return diary[]对象 有imgbase64编码 日记正文 和 日记标题
     */
    public diary[] look_diary_book(String eamil,String diary_book_name){
        int p=0;
        File diary_book = new File("src/userfile/"+eamil+"/diary/"+diary_book_name+"/text");
        File[] diarylist = diary_book.listFiles();
        String[] diary_name;
        String[] diary_text;
        Imgbase[] img = new FileService().look_diary_book_img(eamil,diary_book_name);

        diary[] diarys = new diary[diarylist.length];

        try{

            diary_name = new String[diarylist.length];
            diary_text = new String[diarylist.length];
            FileInputStream fileInputStream ;
            byte[] bytes;

            for(int i=0;i<diarylist.length;i++){
                if(diarylist[i].isFile()){
                    diary_name[p] = diarylist[i].getName().replaceAll("[.][^.]+$", "");
//                    System.out.println(diary_name[p]);
                    fileInputStream = new FileInputStream(diarylist[i]);
                    bytes = new byte[(int) diarylist[i].length()];
                    fileInputStream.read(bytes);
                    diary_text[p++]=new String(bytes);
//                    System.out.println(diary_text[p-1]);
//                    System.out.println("------------------------------");
                }
            }
            diarys = new diary[p];
            for(int i=0;i<p;i++){
                diarys[i] = new diary();
                diarys[i].setText(diary_text[i]);
                diarys[i].setTitle(diary_name[i]);
                diarys[i].setImg(img[i]);
//                System.out.println(diarys[i].toString());
//                System.out.println("=======================================");
            }
        }catch (Exception e){
            System.out.println(e);
        }

        return diarys;
    }

    /**
     *
     * @param eamil
     * @param diary_book_name
     * @return 得到该日记本下的图片base64编码字符串数组
     */
    public Imgbase[] look_diary_book_img (String eamil,String diary_book_name){
        File diary_book_img = new File("src/userfile/"+eamil+"/diary/"+diary_book_name+"/img");
        File[] diarylist_img = diary_book_img.listFiles();
        String[] strbase64;
        Imgbase[] img = new Imgbase[diarylist_img.length];
        try{

            FileInputStream inputStream;
            int p=0;
            strbase64 = new String[diarylist_img.length];
            byte[] bytes;
            for(int i=0;i<diarylist_img.length;i++){
                if(diarylist_img[i].isFile()){
                    inputStream = new FileInputStream(diarylist_img[i]);
                    bytes = new byte[(int) diarylist_img[i].length()];

                    inputStream.read(bytes,0, (int) diarylist_img[i].length());
                    strbase64[p++] = "url(data:image/png;base64,"+Base64.getEncoder().encodeToString(bytes)+")";
                    System.out.println(strbase64[p-1]);
//                    System.out.println("=========================");
                }
            }
            for(int i=0;i<p;i++){
                img[i]=new Imgbase();
                img[i].backgroundImage=(String)strbase64[i];
//                System.out.println(img[i].toString());
            }
        }catch (Exception e){
            System.out.println(e);
        }
        return img;
    }

    /**
     *
     * @param eamil
     * @return 加工后的文件夹对象
     */
    public Diary_books[] diary_books_object(String eamil){
        File diary = new File("src/userfile/"+eamil+"/diary");
        File[] diarylist = diary.listFiles();
        String[] diary_book_name = new String[diarylist.length];
        int p=0;
        Diary_books[] diary_books_ob= new Diary_books[diarylist.length];
        for(int i=0;i<diarylist.length;i++){
            if(diarylist[i].isDirectory()){
                diary_book_name[p++] = diarylist[i].getName().replaceAll("[.][^.]+$", "");
            }
        }
        for(int i=0;i<p;i++){
            diary_books_ob[i] = new Diary_books();
            diary_books_ob[i].value=diary_book_name[i];
            diary_books_ob[i].label=diary_book_name[i];
        }
        return diary_books_ob;
    }

    /**
     * 插入日记
     * @param eamil
     * @param within 权限
     * @param diary_book 要插入的日记本
     * @param title 标题
     * @param text 文本
     * @return  boolean
     * @throws IOException
     */
    public boolean insert_diary( String eamil, String within, String diary_book, String title, String text) throws IOException {
        try{
            File diary = new File("src/userfile/"+eamil+"/diary/"+diary_book+"/text/"+title+".txt");
            FileOutputStream fileOutputStream = new FileOutputStream(diary);
            fileOutputStream.write(text.getBytes());
            FileOutputStream fileOutputStream1 = new FileOutputStream("src/userfile/"+eamil+"/diary/"+diary_book+"/img/"+title+".jpg");
            fileOutputStream1.write(insert_diary_img);
            fileOutputStream.close();
            fileOutputStream1.close();
            boolean overt;
            if(within.equals("1"))overt=true;
            overt=false;
            userdiaryimp.insert(eamil,"src/userfile/"+eamil+"/diary/"+diary_book+"/text/"+title+".txt",overt,0);
            return true;
        }catch (Exception e) {
            System.out.println(e);
            return false;
        }
    }

    /**
     *
     * @param eamil
     * @param file_url 以file文件夹为根目录要显示的文件夹路径
     * @return
     */
    public Filedata[] file_url_files(String eamil,String file_url){
        File file = new File("src/userfile/"+eamil+"/file"+file_url);
        File[] filelist = file.listFiles();
        Filedata[] filedata = new Filedata[filelist.length];
        int p=0;
        try{
            File filepjrj = new File("src/userfile/"+eamil+"/file"+file_url+"/file.pjrj");
            FileInputStream fileInputStream = new FileInputStream(filepjrj);
            BufferedReader br = new BufferedReader(new InputStreamReader(fileInputStream));
            int temp=0;
            String[] line = new String[1024];
            while ((line[temp++] = br.readLine()) != null) {
                System.out.println(line);
            }
            filedata = new Filedata[filelist.length+temp-2];
            for(int i=0;i<filelist.length;i++){
                if(filelist[i].isDirectory()){
                    filedata[p] = new Filedata();
                    filedata[p].name=filelist[i].getName();
                    filedata[p++].type="mkdir";
                }
            }

            fileInputStream.close();
            for(int i=0;i<temp;i++){
                filedata[p] = new Filedata();
                for(int j=line[i].length()-1;j>=0;j--){

                    if(line[i].charAt(j)=='.'){
                        filedata[p].type=line[i].substring(j+1,line[i].length());
                        System.out.println(line[i].substring(j+1,line[i].length()));
                    }
                    if(line[i].charAt(j)=='/' || j==0){
                        filedata[p].name=line[i].substring(j+1,line[i].length());
                        System.out.println(line[i].substring(j+1,line[i].length()));
                        break;
                    }

                }
                p++;

            }


        }catch (Exception e){
            System.out.println(e);
        }
        return filedata;
    }

    /**
     *
     * @param eamil
     * @param file_url 以file文件夹为根目录要添加的文件夹路径
     * @param file      文件的二进制文件
     * @param filename 文件名
     * @return
     */
    public boolean file_upload(String eamil, String file_url, MultipartFile file, String filename) {
        File file_pjrj = new File("src/userfile/"+eamil+"/file"+file_url+"/file.pjrj");
        try{
            FileOutputStream fileOutputStream = new FileOutputStream(file_pjrj,true);
            fileOutputStream.write((file_url+"/"+filename+"\n").getBytes());
            fileOutputStream.close();
            String file_name_qu_xiegang ="";
            for(int i=0;i<(file_url+filename).length();i++){
                if((file_url+filename).charAt(i)!='/')file_name_qu_xiegang=file_name_qu_xiegang+(file_url+filename).charAt(i);

            }
            File file_name = new File("src/userfile/"+eamil+"/file_baocun/"+file_name_qu_xiegang);
            FileOutputStream fileOutputStream1 = new FileOutputStream(file_name);
            fileOutputStream1.write(file.getBytes());
            fileOutputStream1.close();
            return true;
        }catch (Exception e){
            System.out.println(e);
        }
        return false;
    }
}
