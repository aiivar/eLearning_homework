package ru.kpfu.itis.j903.cw.minsafin.inf_8;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.util.Scanner;

public class InputOutputTest {
    private final String path = "D:\\IdeaProjects\\1_Course\\2_Sem\\eLearning\\src\\ru\\kpfu\\itis\\j903\\cw\\minsafin\\inf_8\\filepath\\test.txt";

    public void execute() {
        File file = new File(path);
        Scanner sc = new Scanner(System.in);
        int integer = Integer.parseInt(sc.nextLine());
        String str = sc.nextLine();

        try (FileOutputStream outputStream = new FileOutputStream(file)) {
            writeInt(outputStream, integer);
            writeChar(outputStream, str.charAt(0));
        } catch (IOException e) {
            e.printStackTrace();
        }
        try (FileInputStream in = new FileInputStream(file)) {
            System.out.println(readInt(in));
            System.out.println((char) readChar(in));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void writeInt(FileOutputStream out, int i) throws IOException {
        out.write(i >> 24);
        out.write(i >> 16);
        out.write(i >> 8);
        out.write(i);
    }

    private int readInt(FileInputStream in) throws IOException {
        int i = 0;
        for (int j = 0; j < 3; j++) {
            i = i | in.read();
            i = i << 8;
        }
        i = i | in.read();
        return i;
    }

    private void writeChar(FileOutputStream out, char c) throws IOException {
        short i = (short) c;
        out.write(i >> 8);
        out.write(i);
    }

    private int readChar(FileInputStream in) throws IOException {
        int i = 0;
        i = i | in.read();
        i = i << 8;
        i = i | in.read();
        return i;
    }
}
