package com.example.movieuitemplate.model;

public class Slider {
    private int Id;
    private int Image;
    private String Title;
    private String Url;


    public Slider(int id, int image, String title,String url) {
        Id = id;
        Image = image;
        Title = title;
        Url = url;
    }
    public String getUrl() {
        return Url;
    }

    public void setUrl(String url) {
        Url = url;
    }


    public int getImage() {
        return Image;
    }

    public void setImage(int image) {
        Image = image;
    }

    public String getTitle() {
        return Title;
    }

    public void setTitle(String title) {
        Title = title;
    }

    public int getId() {
        return Id;
    }

    public void setId(int id) {
        Id = id;
    }
}
