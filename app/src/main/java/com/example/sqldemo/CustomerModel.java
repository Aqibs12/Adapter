package com.example.sqldemo;

public class CustomerModel {

    private int id;
    private String name;
    private int Age;
    private boolean isActive;

    // create constructors


    public CustomerModel(int id, String name, int age, boolean isActive) {
        this.id = id;
        this.name = name;
        Age = age;
        this.isActive = isActive;
    }

    public CustomerModel() {
    }
    // toString is necessary for printing the content of a class object

    @Override
    public String toString() {
        return "CustomerModel{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", Age=" + Age +
                ", isActive=" + isActive +
                '}';
    }


    // create getter setter


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return Age;
    }

    public void setAge(int age) {
        Age = age;
    }

    public String isActive() {
        final boolean isActive = this.isActive;
        if (isActive) {
            return "Active" ;
        } else {
            return "Not Active";
        }
    }

    public void setActive(boolean active) {
        isActive = active;
    }
}
