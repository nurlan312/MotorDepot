package com.company;

public class Avtobaza {
    private int id;
    private String name;
    private String driver;
    private String status;

   public static Avtobaza makeAvtobaza(int id, String name, String driver, String status) {
       try {
           Avtobaza avtobaza = new Avtobaza();
           avtobaza.id = id;
           avtobaza.name = name;
           avtobaza.driver = driver;
           avtobaza.status = status;
           return avtobaza;
       } catch (Exception e) {
           System.out.println(e.getMessage());
       }
       return null;
   }

   public static Avtobaza makeAvtobaza(int id, String driver) {
      try{
          Avtobaza avtobaza = new Avtobaza();
          avtobaza.id = id;
          avtobaza.driver = driver;
          return avtobaza;
      } catch (Exception e) {
          System.out.println(e.getMessage());
      }
       return null;
   }

    public int getId() {
        return id;
    }
    public void setId(int id) {
        try {
            this.id = id;
        } catch (RuntimeException e) {
            e.getMessage();
        }
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
       try {
           this.name = name;
       } catch (RuntimeException e) {
           e.getMessage();
       }
    }
    public String getDriver() {
        return driver;
    }
    public void setDriver(String driver) {
       try {
           this.driver = driver;
       } catch (RuntimeException e) {
           e.getMessage();
       }
    }
    public String getStatus() {
        return status;
    }
    public void setStatus(String status) {
       try {
           this.status = status;
       } catch (RuntimeException e) {
           e.getMessage();
       }
    }

    @Override
    public String toString() {
        return  id + "| " +
                name + "| " +
                driver + "| " +
                status;
    }
}
