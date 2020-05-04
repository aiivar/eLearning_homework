package ru.kpfu.itis.j903.cw.minsafin.inf_16;

import java.io.*;
import java.net.URI;
import java.net.URL;
import java.nio.file.Path;
import java.nio.file.Paths;

public class MyURI {
    private URI uri;
    private Path path;

    public MyURI(String str, Path path) {
        this.uri = URI.create(str);
        this.path = path;
    }

    public void saveContent() throws IOException {
        URL url = uri.toURL();
        BufferedReader in = new BufferedReader(new InputStreamReader(url.openConnection().getInputStream()));
        FileWriter fileWriter = new FileWriter(path.toFile());
        String str;
        while ((str = in.readLine()) != null) {
            fileWriter.write(str + "\n");
        }
        fileWriter.flush();
        fileWriter.close();
    }

    public URI getUri() {
        return uri;
    }

    public String getPath() {
        return path.toString();
    }
}
