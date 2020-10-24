package com.example.plantdelivery.model;

import javax.persistence.Entity;

@Entity
public class Shrub extends Plant {
    private Float height;
    private Float width;

    public Shrub() {
    }

    public Float getHeight() {
        return height;
    }

    public void setHeight(Float height) {
        this.height = height;
    }

    public Float getWidth() {
        return width;
    }

    public void setWidth(Float width) {
        this.width = width;
    }
}
