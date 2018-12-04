package com.example.ky4910.kynews.model.entity;

public class News {
    private String id;
    private String title;
    private String content;
    private String channel;
    private String imgstc;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getChannel() {
        return channel;
    }

    public void setChannel(String channel) {
        this.channel = channel;
    }

    public String getImgstc() {
        return imgstc;
    }

    public void setImgstc(String imgstc) {
        this.imgstc = imgstc;
    }
}
