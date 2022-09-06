package com.example.raviworldwidemedicines.model;

public class TopBrandsItemDetails {
    String medicines_name,expairy_date,original_price;
    int medicine_image;
    float discount_rate;

    public TopBrandsItemDetails(String medicines_name, String expairy_date, String original_price, int medicine_image,float discount_rate) {
        this.medicines_name = medicines_name;
        this.expairy_date = expairy_date;
        this.original_price = original_price;
        this.medicine_image = medicine_image;
        this.discount_rate = discount_rate;
    }

    public String getExpairy_date() {
        return expairy_date;
    }

    public String getOriginal_price() {
        return original_price;
    }

    public int getMedicine_image() {
        return medicine_image;
    }

    public String getMedicines_name() {
        return medicines_name;
    }

    public float getDiscount_rate() {
        return discount_rate;
    }
}