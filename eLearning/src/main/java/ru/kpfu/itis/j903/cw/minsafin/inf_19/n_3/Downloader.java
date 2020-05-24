package ru.kpfu.itis.j903.cw.minsafin.inf_19.n_3;

import java.io.*;
import java.net.URI;
import java.net.URLConnection;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Properties;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Downloader implements Runnable {
    private String propertiesPath = "src\\main\\resources\\homework19_3.properties";
    private Properties properties = new Properties();
    private String link;
    private StringBuilder existingUrls = new StringBuilder();
    private Path downloadingPath;
    private int sitescount;

    public Downloader(String link) {
        this.link = link;
        sitescount = 0;
        try {
            FileInputStream fileInputStream = new FileInputStream(propertiesPath);
            properties.load(fileInputStream);
        } catch (IOException e) {
            e.printStackTrace();
        }
        setDownloadingPath();
    }

    private void setDownloadingPath() {
        downloadingPath = Paths.get(properties.getProperty("downloading.path"));
    }

    private void downloadSite(String root) {
        root = findRoot(root);
        setRoot(root);
        if (!new File(downloadingPath.toString()).exists()) {
            try {
                Files.createDirectory(downloadingPath);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        existingUrls.append(root + "\n");
        downloadCurrentSite(root, null);
    }

    private void downloadCurrentSite(String uri, String filename) {
        try {
            StringBuilder text = downloading(URI.create(uri), filename);
            try {
                Thread.sleep(300);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            Pattern pattern = Pattern.compile("href=\\\"(/[-a-zA-Z0-9+&@#/%=~_|]+)\\\"");
            Matcher matcher = pattern.matcher(text);
            while (matcher.find()) {
                if (!existingUrls.toString().contains(properties.getProperty("root.site") + matcher.group(1))) {
                    existingUrls.append(properties.getProperty("root.site")).append(matcher.group(1)).append("\n");
                    System.out.println(properties.getProperty("root.site") + matcher.group(1));
                    downloadCurrentSite(properties.getProperty("root.site") + matcher.group(1), matcher.group(1));
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private StringBuilder downloading(URI uri, String pathname) throws IOException {
        URLConnection connection = uri.toURL().openConnection();
        connection.setRequestProperty("User-Agent", "Mozilla/5.0 (Windows NT 6.1; WOW64) AppleWebKit/537.11 (KHTML, like Gecko) Chrome/23.0.1271.95 Safari/537.11");
        BufferedReader in = new BufferedReader(new InputStreamReader(connection.getInputStream()));
        String filename = "sitepage-" + sitescount + ".html";
        File newSite;
        if (pathname != null) {
            newSite = new File(String.valueOf(downloadingPath.resolve(pathname.substring(1)).resolve(filename)));
        } else {
            newSite = new File(String.valueOf(downloadingPath.resolve(filename)));
        }
        if (!newSite.exists()) {
            while (!newSite.getParentFile().exists()){
                File temp = newSite.getParentFile();
                while (!temp.getParentFile().exists()){
                    temp = temp.getParentFile();
                }
                temp.mkdir();
            }
            if (!newSite.createNewFile()) {
                throw new IOException("Creating exception");
            }
        }
        FileWriter fileWriter = new FileWriter(newSite);
        String str;
        StringBuilder text = new StringBuilder();
        while ((str = in.readLine()) != null) {
            fileWriter.write(str + "\n");
            text.append(str);
        }
        fileWriter.flush();
        fileWriter.close();
        sitescount++;
        return text;
    }



    private String findRoot(String root) {
        Pattern pattern = Pattern.compile("^(https?|ftp|file)://[-a-zA-Z0-9+&@#%?=~_|!:,.;]*");
        Matcher matcher = pattern.matcher(root);
        if (matcher.find()) {
            return matcher.group();
        }
        return root;
    }

    private void setRoot(String root) {
        properties.setProperty("root.site", root);
    }

    @Override
    public void run() {
        downloadSite(link);
    }
}
