package com.aws.avatar.model;

import java.util.UUID;

public class User {
    private String id;
    private String name;
    private String urlAvatar;

    private User(final String name, final String urlAvatar) {
        this.id = UUID.randomUUID().toString();
        this.name = name;
        this.urlAvatar = urlAvatar;
    }

    public static User from(final String name, final String urlAvatar){
        return new User(name, urlAvatar);
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getUrlAvatar() {
        return urlAvatar;
    }

    public void setUrlAvatar(String urlAvatar) {
        this.urlAvatar = urlAvatar;
    }
}
