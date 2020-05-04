package ru.kpfu.itis.j903.cw.minsafin.inf_9;

import ru.kpfu.itis.j903.cw.minsafin.inf_9.student.BirthDate;
import ru.kpfu.itis.j903.cw.minsafin.inf_9.student.Student;

import java.io.*;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.Collection;

public class StudentByteBufferReaderWriter {
    public static final String path = "src\\ru\\kpfu\\itis\\j903\\cw\\minsafin\\inf_9\\filepath\\students.txt";
    private static final int bytesPerStudent = 48;
    private static ByteBuffer byteBuffer = ByteBuffer.allocateDirect(bytesPerStudent);

    public static void write(Collection<? extends Student> collection) {
        File students = new File(path);
        try (FileOutputStream out = new FileOutputStream(students)) {
            for (Student s : collection) {
                putDate(s);
                putGroup(s);
                putName(s);
                byteBuffer.rewind();
                for (int i = 0; i < bytesPerStudent; i++) {
                    out.write(byteBuffer.get());
                }
                byteBuffer.rewind();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static Collection<Student> read(File students){
        Collection<Student> studentsColl= new ArrayList<>();
        try (FileInputStream in = new FileInputStream(students)){
            while (getBytesForStudent(in)){
                byteBuffer.rewind();
                BirthDate birthDate = getBirthDateFromBytes();
                int group = getGroupFromBytes();
                String name = getNameFromBytes();
                Student s = new Student(birthDate, name, group);
                studentsColl.add(s);
                byteBuffer.rewind();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return studentsColl;
    }

    private static boolean getBytesForStudent(FileInputStream in) throws IOException {
        byte toPut;
        for (int i = 0; i < bytesPerStudent; i++) {
            if((toPut = (byte) in.read()) != -1) {
                byteBuffer.put(toPut);
            }else {
                return false;
            }
        }
        return true;
    }

    private static BirthDate getBirthDateFromBytes(){
        short year = byteBuffer.getShort();
        byte month = byteBuffer.get();
        byte day =  byteBuffer.get();
        return new BirthDate(day,month,year);
    }

    private static String getNameFromBytes(){
        String str = "";
        char toGet;
        int count = 0;
        while (count != 20){
            str = str.concat(String.valueOf(byteBuffer.getChar()));
            count++;
        }
        return str;
    }

    private static int getGroupFromBytes(){
        return byteBuffer.getInt();
    }

    private static void putDate(Student s) {
        byteBuffer.putShort(s.getBirthDate().getYear());
        byteBuffer.put(s.getBirthDate().getMonth());
        byteBuffer.put(s.getBirthDate().getDay());
    }

    private static void putGroup(Student s) {
        byteBuffer.putInt(s.getGroup());
    }

    private static void putName(Student s) {
        for (int i = 0; i < 20; i++) {
            if (i < s.getName().length()) {
                byteBuffer.putChar(s.getName().charAt(i));
            } else {
                byteBuffer.putChar(Character.MIN_VALUE);
            }
        }
    }
}
