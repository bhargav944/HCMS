package com.bhargav.hcms.models.TotalHlthModels;

public class ModelStomachAche_Five {

    String image, header, title, description, description1, description2;

    public ModelStomachAche_Five() {
    }

    public ModelStomachAche_Five(String image, String header, String title, String description, String description1, String description2) {
        this.image = image;
        this.header = header;
        this.title = title;
        this.description = description;
        this.description1 = description1;
        this.description2 = description2;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
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

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getDescription1() {
        return description1;
    }

    public void setDescription1(String description1) {
        this.description1 = description1;
    }

    public String getDescription2() {
        return description2;
    }

    public void setDescription2(String description2) {
        this.description2 = description2;
    }
}
