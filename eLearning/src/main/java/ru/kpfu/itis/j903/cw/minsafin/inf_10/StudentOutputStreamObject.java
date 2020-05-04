package ru.kpfu.itis.j903.cw.minsafin.inf_10;

import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.OutputStream;

public class StudentOutputStreamObject extends OutputStream {
    private ObjectOutputStream objectOutputStream;

    public StudentOutputStreamObject(OutputStream out) throws IOException {
        this.objectOutputStream = new ObjectOutputStream(out);
    }

    public void useProtocolVersion(int version) throws IOException {
        objectOutputStream.useProtocolVersion(version);
    }

    public void writeObject(Object obj) throws IOException {
        objectOutputStream.writeObject(obj);
    }

    public void writeUnshared(Object obj) throws IOException {
        objectOutputStream.writeUnshared(obj);
    }

    public void defaultWriteObject() throws IOException {
        objectOutputStream.defaultWriteObject();
    }

    public ObjectOutputStream.PutField putFields() throws IOException {
        return objectOutputStream.putFields();
    }

    public void writeFields() throws IOException {
        objectOutputStream.writeFields();
    }

    public void reset() throws IOException {
        objectOutputStream.reset();
    }

    @Override
    public void write(int val) throws IOException {
        objectOutputStream.write(val);
    }

    @Override
    public void write(byte[] buf) throws IOException {
        objectOutputStream.write(buf);
    }

    @Override
    public void write(byte[] buf, int off, int len) throws IOException {
        objectOutputStream.write(buf, off, len);
    }

    @Override
    public void flush() throws IOException {
        objectOutputStream.flush();
    }

    @Override
    public void close() throws IOException {
        objectOutputStream.close();
    }

    public void writeBoolean(boolean val) throws IOException {
        objectOutputStream.writeBoolean(val);
    }

    public void writeByte(int val) throws IOException {
        objectOutputStream.writeByte(val);
    }

    public void writeShort(int val) throws IOException {
        objectOutputStream.writeShort(val);
    }

    public void writeChar(int val) throws IOException {
        objectOutputStream.writeChar(val);
    }

    public void writeInt(int val) throws IOException {
        objectOutputStream.writeInt(val);
    }

    public void writeLong(long val) throws IOException {
        objectOutputStream.writeLong(val);
    }

    public void writeFloat(float val) throws IOException {
        objectOutputStream.writeFloat(val);
    }

    public void writeDouble(double val) throws IOException {
        objectOutputStream.writeDouble(val);
    }

    public void writeBytes(String str) throws IOException {
        objectOutputStream.writeBytes(str);
    }

    public void writeChars(String str) throws IOException {
        objectOutputStream.writeChars(str);
    }

    public void writeUTF(String str) throws IOException {
        objectOutputStream.writeUTF(str);
    }
}
