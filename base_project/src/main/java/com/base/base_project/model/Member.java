package com.base.base_project.model;

public class Member {
    int id;
    String name;
    String phone;

    public Member() {
    }

    public Member(int id, String name, String phone) {
        this.id = id;
        this.name = name;
        this.phone =phone;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getPhone() {
        return phone;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }
    
}
