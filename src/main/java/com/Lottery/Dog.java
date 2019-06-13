package com.Lottery;

public class Dog implements Animal {

    @Dai(name = "tony")
    private String name;

    private String lname;

    @Dai(name = "phiona")
    public void setLName(String lname) {
        this.lname = lname;
    }

    public String getLName() {
        return this.lname;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return this.name;
    }

}
