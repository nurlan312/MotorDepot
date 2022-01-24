package com.company;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.beans.beancontext.BeanContextServiceRevokedEvent;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.Scanner;

public class Main {
    private static final GsonBuilder BUILDER = new GsonBuilder();
    private static final Gson GSON = BUILDER.setPrettyPrinting().create();
    private static final Path WRITE_PATH = Paths.get("./avtobaza.gson");

    public static void main(String[] args) {
        //-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-* 1 этап *-*-*-*-*-*-*-*-*-*-*-
        Avtobaza[] avtobazas = {
                Avtobaza.makeAvtobaza(1, "Renault", "       ", "On Base"),
                Avtobaza.makeAvtobaza(2, "Volvo", "       ", "On Base"),
                Avtobaza.makeAvtobaza(3, "DAF XT", "       ", "On Base"),
        };

//        String avtobaza = GSON.toJson(avtobazas);
//        writeAvtobaza(avtobaza);
//        System.out.println(avtobaza);
//
//        String readAvtob = readAvtobaza();
//        System.out.println(readAvtob);

        System.out.println("\n1 этап: ");
        System.out.println("# | Bus    | Driver | Status \n" +
                "--+--------+--------+------- ");
        Avtobaza[] avtobazas1 = GSON.fromJson(readAvtobaza(), Avtobaza[].class);
        for (Avtobaza a : avtobazas1) {
            System.out.println(a);
        }

        //-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-* 2 этап *-*-*-*-*-*-*-*-*-*-*-*-*-
        Driver[] drivers = {
                Driver.makeDriver(1, "Саша"),
                Driver.makeDriver(2, "Коля"),
                Driver.makeDriver(3, "Женя")
        };

//        String driver = GSON.toJson(drivers);
//        writeDriver(driver);
//        System.out.println(driver);
//
//        String readDriv = readDriver();
//        System.out.println(readDriv);

        System.out.println("\n2 этап: ");
        System.out.println("# | Driver  | Bus  \n" +
                "--+---------+------+");
        Driver[] drivers1 = GSON.fromJson(readDriver(), Driver[].class);
        for (Driver d : drivers1) {
            System.out.println(d);
        }

        Avtobaza[] avtobazas3 = {
                Avtobaza.makeAvtobaza(1, "Renault", "Саша", String.valueOf(Condition.BASE)),
                Avtobaza.makeAvtobaza(2, "Volvo", "Коля", String.valueOf(Condition.ROUTE)),
                Avtobaza.makeAvtobaza(3, "DAF XT", "Женя", String.valueOf(Condition.BASE))
        };

//        String avtobaza3 = GSON.toJson(avtobazas3);
//        writeAvtobaza3(avtobaza3);
//        System.out.println(avtobaza3);
//
//        String readAvto3 = readAvtobaza3();
//        System.out.println(readAvto3);

        System.out.println("\n3 этап: ");
        System.out.println("# | Bus   | Driver | Status \n" +
                "--+-------+--------+--------");
        Avtobaza[] avtobazas2 = GSON.fromJson(readAvtobaza3(), Avtobaza[].class);
        for (Avtobaza a : avtobazas2) {
            System.out.println(a);
        }
//        TruckCondition.changeDriver(new Avtobaza(), new Driver());
//        TruckCondition.startDriving(new Avtobaza());
//        TruckCondition.startRepair(new Avtobaza());
        System.out.println("Комментарийдеги 3 метод мен куткондой иштебей калды.\n");


        System.out.println("4 этап: ");
        while (true) {
            Scanner sc = new Scanner(System.in);
            System.out.print("\nВведите id номер грузовика с 1 до 3, так как у нас всего 3 грузовик есть: ");
            int value = sc.nextInt();
            for (Avtobaza info : avtobazas3) {
                if (value == info.getId()) {
                System.out.println("Информация o грузовике с id: " + info);
                }
            }
        }
    }

    //-*-*-*-*-*-*-*-*-*-*-*-*-*-*-* 3 этап *-*-*-*-*-*-*-*-*-*-*-*-
    private static void writeAvtobaza3(String obj) {
        Path write = Paths.get("./avtobaza3.gson");
        try {
            Files.writeString(write, obj, StandardOpenOption.CREATE,
                              StandardOpenOption.WRITE);
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }

    private static String readAvtobaza3() {
        StringBuilder gson = new StringBuilder();
        try {
            FileReader fr = new FileReader("./avtobaza3.gson");
            int a;
            while ((a = fr.read()) != -1) {
                gson.append((char) a);
            }
            return gson.toString();
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
        return gson.toString();
    }

    //-*-*-*-*-*-*-*-*-*-*-*-*-*-*-* 2 этап *-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-
    private static void writeDriver(String obj) {
        Path write = Paths.get("./driver.gson");
        try {
            Files.writeString(write, obj, StandardOpenOption.CREATE,
                              StandardOpenOption.WRITE);
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }

    private static String readDriver() {
        StringBuilder gson = new StringBuilder();
        try {
            FileReader fr = new FileReader("./driver.gson");
            int a;
            while ((a = fr.read()) != -1) {
                gson.append((char) a);
            }
            return gson.toString();
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
        return gson.toString();
    }

    //-*-*-*-*-*-*-*-*-*-*-*-*-*-* 1 этап-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*
    private static void writeAvtobaza(String obj) {
        Path write1 = Paths.get(String.valueOf(WRITE_PATH));
        try {
            Files.writeString(write1, obj, StandardOpenOption.CREATE,
                              StandardOpenOption.WRITE);
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }

    private static String readAvtobaza() {
        StringBuilder json = new StringBuilder();
        try {
            FileReader fr = new FileReader(String.valueOf(WRITE_PATH));
            int a;
            while ((a = fr.read()) != -1) {
                json.append((char) a);
            }
            return json.toString();
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
        return json.toString();
    }
}