package com.bhargav.hcms.detail;

public class DonateDetail {

    public String name;
    public String email;
    public String phone;
    public String blood;

    public DonateDetail() {
    }

    public DonateDetail(String name, String email, String phone, String blood) {
        this.name = name;
        this.email = email;
        this.phone = phone;
        this.blood = blood;
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

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getBlood() {
        return blood;
    }

    public void setBlood(String blood) {
        this.blood = blood;
    }
}
