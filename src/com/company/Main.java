package com.company;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;

public class Main {
    private static final GsonBuilder BUILDER = new GsonBuilder();
    private static final Gson GSON = BUILDER.setPrettyPrinting().create();
    private static final Path WRITE_PATH = Paths.get("./avtobaza.gson");

    public static void main(String[] args) {
        Avtobaza[] avtobazas = {
                Avtobaza.makeAvtobaza(1, "Renault", "       ", "On Base"),
                Avtobaza.makeAvtobaza(2, "Volvo", "       ", "On Base"),
                Avtobaza.makeAvtobaza(3, "DAF XT", "       ", "On Base"),
        };

//        String avtobaza = GSON.toJson(avtobazas);
//        write(avtobaza);
//        System.out.println(avtobaza);
//        String read = readFile();
//        System.out.println(read);
        System.out.println("1 этап: ");
        System.out.println("# | Bus    | Driver | Status \n" +
                "--+--------+--------+------- ");
        Avtobaza[] avtobazas1 = GSON.fromJson(readFile(), Avtobaza[].class);
        for (Avtobaza a : avtobazas) {
            System.out.println(a);
        }
    }

    private static void write(String obj) {
        Path write = Paths.get(String.valueOf(WRITE_PATH));
        try {
            Files.writeString(write, obj, StandardOpenOption.CREATE,
                              StandardOpenOption.WRITE);
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }

     private static String readFile() {
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
