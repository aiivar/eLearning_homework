package ru.kpfu.itis.j903.cw.minsafin.inf_16;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;


public class RegexForImg {
    private String link;

    public RegexForImg(String link) {
        this.link = link;
    }

    public void execute() throws IOException {
        MyURI myURI = new MyURI(link, null);
        myURI.saveContent();
        BufferedReader bf = new BufferedReader(new InputStreamReader(new FileInputStream(myURI.getPath())));
        String line;
        StringBuilder str = new StringBuilder();
        while ((line = bf.readLine()) != null){
            str.append(line);
        }
        Pattern pattern = Pattern.compile("<img.+?>");
        Matcher matcher = pattern.matcher(str);
        int i = 0;
        while (matcher.find()){
            i++;
        }
        System.out.println(i);
    }
}
