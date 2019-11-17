package com.bhargav.hcms.models.TotalHlthModels;

public class ModelRoutineMaker {

    String header, title, description, quads, quadsdescrp, functions, fundescrp;

    public ModelRoutineMaker() {
    }

    public ModelRoutineMaker(String header, String title, String description, String quads, String quadsdescrp, String functions, String fundescrp) {
        this.header = header;
        this.title = title;
        this.description = description;
        this.quads = quads;
        this.quadsdescrp = quadsdescrp;
        this.functions = functions;
        this.fundescrp = fundescrp;
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

    public String getQuads() {
        return quads;
    }

    public void setQuads(String quads) {
        this.quads = quads;
    }

    public String getQuadsdescrp() {
        return quadsdescrp;
    }

    public void setQuadsdescrp(String quadsdescrp) {
        this.quadsdescrp = quadsdescrp;
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
}
