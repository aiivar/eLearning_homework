package ru.kpfu.itis.j903.cw.minsafin.inf_10;

import java.io.*;

public class StudentInputStreamObject extends InputStream {
    private ObjectInputStream objectInputStream;

    public StudentInputStreamObject(InputStream inputStream) throws IOException {
        objectInputStream = new ObjectInputStream(inputStream);
    }

    public Object readObject() throws IOException, ClassNotFoundException {
        return objectInputStream.readObject();
    }

    public Object readUnshared() throws IOException, ClassNotFoundException {
        return objectInputStream.readUnshared();
    }

    public void defaultReadObject() throws IOException, ClassNotFoundException {
        objectInputStream.defaultReadObject();
    }

    public ObjectInputStream.GetField readFields() throws IOException, ClassNotFoundException {
        return objectInputStream.readFields();
    }

    public void registerValidation(ObjectInputValidation obj, int prio) throws NotActiveException, InvalidObjectException {
        objectInputStream.registerValidation(obj, prio);
    }

    @Override
    public int read() throws IOException {
        return objectInputStream.read();
    }

    @Override
    public int read(byte[] buf, int off, int len) throws IOException {
        return objectInputStream.read(buf, off, len);
    }

    @Override
    public int available() throws IOException {
        return objectInputStream.available();
    }

    @Override
    public void close() throws IOException {
        objectInputStream.close();
    }

    public boolean readBoolean() throws IOException {
        return objectInputStream.readBoolean();
    }

    public byte readByte() throws IOException {
        return objectInputStream.readByte();
    }

    public int readUnsignedByte() throws IOException {
        return objectInputStream.readUnsignedByte();
    }

    public char readChar() throws IOException {
        return objectInputStream.readChar();
    }

    public short readShort() throws IOException {
        return objectInputStream.readShort();
    }

    public int readUnsignedShort() throws IOException {
        return objectInputStream.readUnsignedShort();
    }

    public int readInt() throws IOException {
        return objectInputStream.readInt();
    }

    public long readLong() throws IOException {
        return objectInputStream.readLong();
    }

    public float readFloat() throws IOException {
        return objectInputStream.readFloat();
    }

    public double readDouble() throws IOException {
        return objectInputStream.readDouble();
    }

    public void readFully(byte[] buf) throws IOException {
        objectInputStream.readFully(buf);
    }

    public void readFully(byte[] buf, int off, int len) throws IOException {
        objectInputStream.readFully(buf, off, len);
    }

    public int skipBytes(int len) throws IOException {
        return objectInputStream.skipBytes(len);
    }

    @Deprecated
    public String readLine() throws IOException {
        return objectInputStream.readLine();
    }

    public String readUTF() throws IOException {
        return objectInputStream.readUTF();
    }
}
