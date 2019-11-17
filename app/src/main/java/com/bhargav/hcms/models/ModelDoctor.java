package com.bhargav.hcms.models;

public class ModelDoctor {

    String image, name, gender, hspname, designation, email, phone;

    public ModelDoctor() {
    }

    public ModelDoctor(String image, String name, String gender, String hspname, String designation, String email, String phone) {
        this.image = image;
        this.name = name;
        this.gender = gender;
        this.hspname = hspname;
        this.designation = designation;
        this.email = email;
        this.phone = phone;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getHspname() {
        return hspname;
    }

    public void setHspname(String hspname) {
        this.hspname = hspname;
    }

    public String getDesignation() {
        return designation;
    }

    public void setDesignation(String designation) {
        this.designation = designation;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }
}
