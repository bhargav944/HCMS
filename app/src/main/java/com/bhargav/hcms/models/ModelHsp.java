package com.bhargav.hcms.models;

public class ModelHsp {

    String title, description, image, phone, link;

    public ModelHsp() {
    }

    public ModelHsp(String title, String description, String image, String phone, String link) {
        this.title = title;
        this.description = description;
        this.image = image;
        this.phone = phone;
        this.link = link;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getLink() {
        return link;
    }

    public void setLink(String link) {
        this.link = link;
    }
}
