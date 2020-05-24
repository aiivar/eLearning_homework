package ru.kpfu.itis.j903.cw.minsafin.inf_11;

import ru.kpfu.itis.j903.cw.minsafin.inf_6.MyMap;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.AbstractMap;
import java.util.Map;
import java.util.Scanner;

public class Main_11 {
    static Path path = Paths.get("src\\ru\\kpfu\\itis\\j903\\cw\\minsafin\\inf_11\\filepath\\file.ini");
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        MyMap<String, String> myMap = new MyMap<>();
        System.out.println("Enter n");
        int n = Integer.parseInt(sc.nextLine());
        for (int i = 0; i < n; i++) {
            System.out.println(i+1 + " entry");
            System.out.println("Enter key");
            String key = sc.nextLine();
            System.out.println("Enter value");
            String value = sc.nextLine();
            myMap.put(key, value);
        }
        try(IniOutputStream out = new IniOutputStream(new FileOutputStream(path.toString()))) {
            for (Map.Entry<String, String> s: myMap.entrySet()) {
                out.writeEntry(s.getKey(),s.getValue());
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        try(IniInputStream in = new IniInputStream(new FileInputStream(path.toString()))) {
            for (int i = 0; i < n; i++) {
                System.out.println(in.readEntry());
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
