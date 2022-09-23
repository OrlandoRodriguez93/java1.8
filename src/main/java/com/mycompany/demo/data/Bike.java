package com.mycompany.demo.data;

public class Bike {

    private String name;
    private String model;

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getModel() {
        return this.model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    @Override
    public String toString() {
        return "{" +
                " name='" + getName() + "'" +
                ", model='" + getModel() + "'" +
                "}";
    }

}
