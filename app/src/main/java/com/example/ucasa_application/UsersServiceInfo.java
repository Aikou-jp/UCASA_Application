package com.example.ucasa_application;

public class UsersServiceInfo {
    private String name;
    private String context;
    private String service;

    public UsersServiceInfo(){
        this.name = "　　";
    }

    public String getName() {
        return name;
    }

    public String getContext() {
        return context;
    }

    public String getService() {
        return service;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setContext(String context) {
        this.context = context;
    }

    public void setService(String service) {
        this.service = service;
    }
}
