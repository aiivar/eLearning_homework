package ru.kpfu.itis.j903.cw.minsafin.inf_12;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Regex12_4 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String text = sc.nextLine();
        Pattern pattern = Pattern.compile("^([a-z0-9_-]+\\.)*[a-z0-9_-]+@([a-z0-9_-]+)(\\.[a-z0-9_-]+)*\\.([a-z]{2,})$");
        Matcher matcher = pattern.matcher(text);
        if (matcher.matches()) {
            System.out.println(matcher.group(2));
            System.out.println(matcher.group(4));
        }
    }
}
