package ru.kpfu.itis.j903.cw.minsafin.inf_12;

import ru.kpfu.itis.j903.cw.minsafin.inf_16.MyURI;

import java.io.*;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Regex12_3 {
    static Path path = Paths.get("src\\ru\\kpfu\\itis\\j903\\cw\\minsafin\\inf_12\\filepath\\file.html");
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        BufferedReader bf = null;
        try {
            bf = new BufferedReader(new InputStreamReader(new FileInputStream(path.toString())));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        StringBuilder str = new StringBuilder();
        try {
            String line;
            while ((line = bf.readLine()) != null) {
                str.append(line);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        Pattern pattern = Pattern.compile("([a-zA-Z0-9\\-_]+\\.)([a-zA-Z0-9\\-_]+\\.?)+");
        Matcher matcher = pattern.matcher(str);
        while (matcher.find()){
            System.out.println(matcher.group());
        }
    }
}
