package ru.kpfu.itis.j903.cw.minsafin.inf_11;

import java.io.*;

public class IniOutputStream extends OutputStream {
    private DataOutputStream dataOutputStream;

    public IniOutputStream(OutputStream out) {
        dataOutputStream = new DataOutputStream(out);
    }

    public void writeEntry(String key, String value) throws IOException {
        writeChars(key + " = " + value + '\n');
    }

    @Override
    public void write(int b) throws IOException {
        dataOutputStream.write(b);
    }

    @Override
    public void write(byte[] b, int off, int len) throws IOException {
        dataOutputStream.write(b, off, len);
    }

    @Override
    public void flush() throws IOException {
        dataOutputStream.flush();
    }

    public void writeBoolean(boolean v) throws IOException {
        dataOutputStream.writeBoolean(v);
    }

    public void writeByte(int v) throws IOException {
        dataOutputStream.writeByte(v);
    }

    public void writeShort(int v) throws IOException {
        dataOutputStream.writeShort(v);
    }

    public void writeChar(int v) throws IOException {
        dataOutputStream.writeChar(v);
    }

    public void writeInt(int v) throws IOException {
        dataOutputStream.writeInt(v);
    }

    public void writeLong(long v) throws IOException {
        dataOutputStream.writeLong(v);
    }

    public void writeFloat(float v) throws IOException {
        dataOutputStream.writeFloat(v);
    }

    public void writeDouble(double v) throws IOException {
        dataOutputStream.writeDouble(v);
    }

    public void writeBytes(String s) throws IOException {
        dataOutputStream.writeBytes(s);
    }

    public void writeChars(String s) throws IOException {
        dataOutputStream.writeChars(s);
    }

    public void writeUTF(String str) throws IOException {
        dataOutputStream.writeUTF(str);
    }
}
