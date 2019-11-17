package com.bhargav.hcms.models;

public class ModelContactUs {

    String header, title, developed, name, email, emailid, phone, number;

    public ModelContactUs() {
    }

    public ModelContactUs(String header, String title, String developed, String name, String email, String emailid, String phone, String number) {
        this.header = header;
        this.title = title;
        this.developed = developed;
        this.name = name;
        this.email = email;
        this.emailid = emailid;
        this.phone = phone;
        this.number = number;
    }

    public String getHeader() {
        return header;
    }

    public void setHeader(String header) {
        this.header = header;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDeveloped() {
        return developed;
    }

    public void setDeveloped(String developed) {
        this.developed = developed;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getEmailid() {
        return emailid;
    }

    public void setEmailid(String emailid) {
        this.emailid = emailid;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }
}
