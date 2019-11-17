package com.bhargav.hcms.models.VitaminsModel;

public class ModelDVitamin {

    String image, header, title, description, functions, fundescrp, interactions, interdescrp;

    public ModelDVitamin() {
    }

    public ModelDVitamin(String image, String header, String title, String description, String functions, String fundescrp, String interactions, String interdescrp) {
        this.image = image;
        this.header = header;
        this.title = title;
        this.description = description;
        this.functions = functions;
        this.fundescrp = fundescrp;
        this.interactions = interactions;
        this.interdescrp = interdescrp;
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

    public String getFunctions() {
        return functions;
    }

    public void setFunctions(String functions) {
        this.functions = functions;
    }

    public String getFundescrp() {
        return fundescrp;
    }

    public void setFundescrp(String fundescrp) {
        this.fundescrp = fundescrp;
    }

    public String getInteractions() {
        return interactions;
    }

    public void setInteractions(String interactions) {
        this.interactions = interactions;
    }

    public String getInterdescrp() {
        return interdescrp;
    }

    public void setInterdescrp(String interdescrp) {
        this.interdescrp = interdescrp;
    }
}
