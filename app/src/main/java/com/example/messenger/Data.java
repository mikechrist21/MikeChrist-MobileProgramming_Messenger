package com.example.messenger;

public class Data {
    private int id;
    private String name;
    private String chat;
    private String image_url;

    public Data(int id, String name, String chat, String image_url){
        this.id = id;
        this.name = name;
        this.chat = chat;
        this.image_url = image_url;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getChat() {
        return chat;
    }

    public void setChat(String chat) {
        this.chat = chat;
    }

    public String getImageURL() {
        return image_url;
    }

    public void setImageURL(String image_url) {
        this.image_url = image_url;
    }
}

