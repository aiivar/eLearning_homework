package ru.kpfu.itis.j903.cw.minsafin.inf_12;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Regex12_2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String text = sc.nextLine();
        Pattern pattern = Pattern.compile("([a-zA-Z0-9\\-_]+\\.)([a-zA-Z0-9\\-_]+\\.?)+");
        Matcher matcher = pattern.matcher(text);
        if (matcher.find()) {
            System.out.println(matcher.group());
        }
    }
}
