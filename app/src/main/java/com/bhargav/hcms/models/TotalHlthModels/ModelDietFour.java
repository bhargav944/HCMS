package com.bhargav.hcms.models.TotalHlthModels;

public class ModelDietFour {

    String image, header, title, description, last;

    public ModelDietFour() {
    }

    public ModelDietFour(String image, String header, String title, String description, String last) {
        this.image = image;
        this.header = header;
        this.title = title;
        this.description = description;
        this.last = last;
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

    public String getLast() {
        return last;
    }

    public void setLast(String last) {
        this.last = last;
    }
}
