package ru.kpfu.itis.j903.cw.minsafin.inf_10;

import ru.kpfu.itis.j903.cw.minsafin.inf_9.student.BirthDate;
import ru.kpfu.itis.j903.cw.minsafin.inf_9.student.Student;

import java.io.DataInput;
import java.io.DataInputStream;
import java.io.IOException;
import java.io.InputStream;

public class StudentInputStreamData extends InputStream {
    protected final int bytesPerStudent;
    protected DataInputStream dataInputStream;

    public StudentInputStreamData(InputStream in) {
        bytesPerStudent = 48;
        dataInputStream = new DataInputStream(in);
    }

    public Student readStudent() throws IOException {
        String name = readName();
        BirthDate birthDate = readBirthDate();
        int group = readGroup();
        return new Student(birthDate, name, group);
    }

    private String readName() throws IOException {
        String name = "";
        for (int i = 0; i < 20; i++) {
            name = name.concat(String.valueOf(dataInputStream.readChar()));
        }
        return name.trim();
    }

    private BirthDate readBirthDate() throws IOException {
        byte day = dataInputStream.readByte();
        byte month = dataInputStream.readByte();
        short year = dataInputStream.readShort();
       return new BirthDate(day, month, year);
    }

    private int readGroup() throws IOException {
        return dataInputStream.readInt();
    }

    @Override
    public int read() throws IOException {
       return dataInputStream.read();
    }

    public void readFully(byte[] b) throws IOException {
        dataInputStream.readFully(b);
    }

    public void readFully(byte[] b, int off, int len) throws IOException {
        dataInputStream.readFully(b, off, len);
    }

    public int skipBytes(int n) throws IOException {
        return dataInputStream.skipBytes(n);
    }

    public boolean readBoolean() throws IOException {
        return dataInputStream.readBoolean();
    }

    public byte readByte() throws IOException {
        return dataInputStream.readByte();
    }

    public int readUnsignedByte() throws IOException {
        return dataInputStream.readUnsignedByte();
    }

    public short readShort() throws IOException {
        return dataInputStream.readShort();
    }

    public int readUnsignedShort() throws IOException {
        return dataInputStream.readUnsignedShort();
    }

    public char readChar() throws IOException {
        return dataInputStream.readChar();
    }

    public int readInt() throws IOException {
        return dataInputStream.readInt();
    }

    public long readLong() throws IOException {
        return dataInputStream.readLong();
    }

    public float readFloat() throws IOException {
        return dataInputStream.readFloat();
    }

    public double readDouble() throws IOException {
        return dataInputStream.readDouble();
    }

    @Deprecated
    public String readLine() throws IOException {
        return dataInputStream.readLine();
    }

    public String readUTF() throws IOException {
        return dataInputStream.readUTF();
    }

    public static String readUTF(DataInput in) throws IOException {
        return DataInputStream.readUTF(in);
    }
}
