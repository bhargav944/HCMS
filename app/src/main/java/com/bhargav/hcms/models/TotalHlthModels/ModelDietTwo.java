package com.bhargav.hcms.models.TotalHlthModels;

public class ModelDietTwo {

    String image, header, title, description, breakfast, breaskfastdescrp, lunch, lunchdescrp, dinner, dinnerdescrp, descrpdinner;

    public ModelDietTwo() {
    }

    public ModelDietTwo(String image, String header, String title, String description, String breakfast, String breaskfastdescrp, String lunch, String lunchdescrp, String dinner, String dinnerdescrp, String descrpdinner) {
        this.image = image;
        this.header = header;
        this.title = title;
        this.description = description;
        this.breakfast = breakfast;
        this.breaskfastdescrp = breaskfastdescrp;
        this.lunch = lunch;
        this.lunchdescrp = lunchdescrp;
        this.dinner = dinner;
        this.dinnerdescrp = dinnerdescrp;
        this.descrpdinner = descrpdinner;
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

    public String getBreakfast() {
        return breakfast;
    }

    public void setBreakfast(String breakfast) {
        this.breakfast = breakfast;
    }

    public String getBreaskfastdescrp() {
        return breaskfastdescrp;
    }

    public void setBreaskfastdescrp(String breaskfastdescrp) {
        this.breaskfastdescrp = breaskfastdescrp;
    }

    public String getLunch() {
        return lunch;
    }

    public void setLunch(String lunch) {
        this.lunch = lunch;
    }

    public String getLunchdescrp() {
        return lunchdescrp;
    }

    public void setLunchdescrp(String lunchdescrp) {
        this.lunchdescrp = lunchdescrp;
    }

    public String getDinner() {
        return dinner;
    }

    public void setDinner(String dinner) {
        this.dinner = dinner;
    }

    public String getDinnerdescrp() {
        return dinnerdescrp;
    }

    public void setDinnerdescrp(String dinnerdescrp) {
        this.dinnerdescrp = dinnerdescrp;
    }

    public String getDescrpdinner() {
        return descrpdinner;
    }

    public void setDescrpdinner(String descrpdinner) {
        this.descrpdinner = descrpdinner;
    }
}
