package com.example.pillminderapp.Model;

import androidx.annotation.NonNull;
public class Prescription implements Comparable<Prescription> {
    private String name;
    private int isAfterMeal;
    private int quantity;
    private String description;
    private String imgURL;
    private Long endDaysDate;
    private int hour;
    private int minute;

    public Prescription() {
    }

    public Prescription(String name,String description ,int isAfterMeal, int quantity, String imgURL, int hour, int minute, long endDaysDate) {
        this.name = name;
        this.description = description;
        this.isAfterMeal = isAfterMeal;
        this.quantity = quantity;
        this.imgURL = imgURL;
        this.hour = hour;
        this.minute = minute;
        this.endDaysDate = endDaysDate;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAfterMeal() {
        return isAfterMeal;
    }

    public void setAfterMeal(int afterMeal) {
        isAfterMeal = afterMeal;
    }

    public String getImgURL() {
        return imgURL;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getDescription() {
        return description;
    }

    public void setImgURL(String imgURL) {
        this.imgURL = imgURL;
    }

    public int getHour() {
        return hour;
    }

    public void setHour(int hour) {
        this.hour = hour;
    }

    public int getMinute() {
        return minute;
    }

    public void setMinute(int minute) {
        this.minute = minute;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }


    public long getEndDaysDate() {
        return endDaysDate;
    }

    public void setEndDate(long endDaysDate) {
        this.endDaysDate = endDaysDate;
    }



    public String getTime() {
        return hour + ":" + String.format("%02d",minute);
    }


    // Implementing compareTo method for comparing pills based on time
    @Override
    public int compareTo(Prescription otherPrescription) {
        // Compare based on hour
        int hourComparison = Integer.compare(this.hour, otherPrescription.getHour());
        if (hourComparison != 0) {
            return hourComparison;
        }
        // If hours are same, compare based on minute
        return Integer.compare(this.minute, otherPrescription.getMinute());
    }

    public String getMeal() {
        if (this.getAfterMeal() == 2) {
            return "After Meal";
        } else if (this.getAfterMeal() == 1)
            return "Before Meal";

        return "Not Specified";
    }


    @NonNull
    @Override
    public String toString() {
        return "Prescription{" +
                "name='" + name + '\'' +
                ", isAfterMeal=" + isAfterMeal +
                ", quantity=" + quantity +
                ", imgURL='" + imgURL + '\'' +
                ", endDateDays=" + endDaysDate +
                ", hour=" + hour +
                ", minute=" + minute +
                '}';
    }
}
