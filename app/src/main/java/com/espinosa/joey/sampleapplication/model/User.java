package com.espinosa.joey.sampleapplication.model;

public class User {

    public long id;
    public String name;
    public String url;
    public String email;
    public String login;
    public String location;
    public String avatar_url;

    public User() {
    }

    public User(long id, String name, String url, String email, String login, String location, String avatar_url) {
        this.id = id;
        this.name = name;
        this.url = url;
        this.email = email;
        this.login = login;
        this.location = location;
        this.avatar_url = avatar_url;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getAvatar_url() {
        return avatar_url;
    }

    public void setAvatar_url(String avatar_url) {
        this.avatar_url = avatar_url;
    }
}