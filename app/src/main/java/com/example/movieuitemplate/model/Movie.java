package com.example.movieuitemplate.model;

import androidx.annotation.Nullable;

public class Movie {
    private int id;
    private String title;
    private String description;
    private int thumbnail;
    private int coverImage;
    private String studio;
    private String rating;
    private String streamingLink;



    public Movie(int id, String title, String description, int thumbnail, int coverImage, String studio, String rating, String streamingLink) {
        this.id = id;
        this.title = title;
        this.description = description;
        this.thumbnail = thumbnail;
        this.coverImage = coverImage;
        this.studio = studio;
        this.rating = rating;
        this.streamingLink = streamingLink;
    }

    public Movie(int id, String title, int thumbnail, int coverImage, String description, String streamingLink) {
        this.id = id;
        this.title = title;
        this.thumbnail = thumbnail;
        this.coverImage = coverImage;
        this.description = description;
        this.streamingLink = streamingLink;
    }

    public int getCoverImage() {
        return coverImage;
    }

    public void setCoverImage(int coverImage) {
        this.coverImage = coverImage;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getThumbnail() {
        return thumbnail;
    }

    public void setThumbnail(int thumbnail) {
        this.thumbnail = thumbnail;
    }

    public String getStudio() {
        return studio;
    }

    public void setStudio(String studio) {
        this.studio = studio;
    }

    public String getRating() {
        return rating;
    }

    public void setRating(String rating) {
        this.rating = rating;
    }

    public String getStreamingLink() {
        return streamingLink;
    }

    public void setStreamingLink(String streamingLink) {
        this.streamingLink = streamingLink;
    }
}
