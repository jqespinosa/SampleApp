package com.espinosa.joey.sampleapplication.model;

public class Repository{
    public long id;
    public String name;
    public String description;
    public int forks;
    public int watchers;
    public int stargazers_count;
    public String language;
    public String homepage;
    public User owner;
    public boolean fork;

    public Repository() {
    }

    public Repository(long id, String name, String description, int forks, int watchers, int stargazers_count, String language, String homepage, User owner, boolean fork) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.forks = forks;
        this.watchers = watchers;
        this.stargazers_count = stargazers_count;
        this.language = language;
        this.homepage = homepage;
        this.owner = owner;
        this.fork = fork;
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

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getForks() {
        return forks;
    }

    public void setForks(int forks) {
        this.forks = forks;
    }

    public int getWatchers() {
        return watchers;
    }

    public void setWatchers(int watchers) {
        this.watchers = watchers;
    }

    public int getStargazers_count() {
        return stargazers_count;
    }

    public void setStargazers_count(int stargazers_count) {
        this.stargazers_count = stargazers_count;
    }

    public String getLanguage() {
        return language;
    }

    public void setLanguage(String language) {
        this.language = language;
    }

    public String getHomepage() {
        return homepage;
    }

    public void setHomepage(String homepage) {
        this.homepage = homepage;
    }

    public User getOwner() {
        return owner;
    }

    public void setOwner(User owner) {
        this.owner = owner;
    }

    public boolean isFork() {
        return fork;
    }

    public void setFork(boolean fork) {
        this.fork = fork;
    }
}