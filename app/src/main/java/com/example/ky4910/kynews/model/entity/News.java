package com.example.ky4910.kynews.model.entity;

public class News {
    private String id;
    private String title;
    private String content;
    private String channel;
    private int imgsrc;

    public News(String id, String title, String content, String channel, int imgsrc) {
        this.id = id;
        this.title = title;
        this.content = content;
        this.channel = channel;
        this.imgsrc = imgsrc;
    }

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

    public int getImgsrc() {
        return imgsrc;
    }

    public void setImgsrc(int imgsrc) {
        this.imgsrc = imgsrc;
    }
}
