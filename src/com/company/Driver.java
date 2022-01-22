package com.company;

public class Driver {
    private int id;
    private String name;

    public static Driver makeDriver(int id, String name) {
        try {
            Driver driver = new Driver();
            driver.id = id;
            driver.name = name;
            return driver;
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return null;
    }

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

    @Override
    public String toString() {
        return  id + "| " +
                name + "         |";
    }
}
