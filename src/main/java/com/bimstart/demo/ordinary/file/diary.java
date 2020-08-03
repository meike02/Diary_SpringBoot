package com.bimstart.demo.ordinary.file;

public class diary {
    private String title;
    private String text;
    private Imgbase img;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    @Override
    public String toString() {
        return "diary{" +
                "title='" + title + '\'' +
                ", text='" + text + '\'' +
                ", img=" + img +
                '}';
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public Imgbase getImg() {
        return img;
    }

    public void setImg(Imgbase img) {
        this.img = img;
    }
}
