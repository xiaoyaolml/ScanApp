package com.leo.scanapp;

import cn.bmob.v3.BmobObject;

/**
 * Created by Leo on 2016-11-09.
 *
 */

public class Information extends BmobObject {
    private String barcode;
    private String title;
    private String content;
    private String author;
    private Double price;

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getBarcode() {
        return barcode;
    }

    public void setBarcode(String barcode) {
        this.barcode = barcode;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }
}
