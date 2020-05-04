package ru.kpfu.itis.j903.cw.minsafin.inf_13.yamldecorator;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.dataformat.yaml.YAMLFactory;

import ru.kpfu.itis.j903.cw.minsafin.inf_9.student.Student;

import java.io.DataOutputStream;
import java.io.IOException;
import java.io.OutputStream;

public class YamlStudentWriter extends OutputStream {
    private DataOutputStream outputStream;

    public YamlStudentWriter(OutputStream outputStream) {
        this.outputStream = new DataOutputStream(outputStream);
    }

    public void writeStudent(Student student) throws IOException {
        ObjectMapper objectMapper = new ObjectMapper(new YAMLFactory());
        objectMapper.writeValue((OutputStream) outputStream, student);
    }

    @Override
    public void write(int b) throws IOException {
        outputStream.write(b);
    }

    @Override
    public void write(byte[] b, int off, int len) throws IOException {
        outputStream.write(b, off, len);
    }

    @Override
    public void flush() throws IOException {
        outputStream.flush();
    }

    public void writeBoolean(boolean v) throws IOException {
        outputStream.writeBoolean(v);
    }

    public void writeByte(int v) throws IOException {
        outputStream.writeByte(v);
    }

    public void writeShort(int v) throws IOException {
        outputStream.writeShort(v);
    }

    public void writeChar(int v) throws IOException {
        outputStream.writeChar(v);
    }

    public void writeInt(int v) throws IOException {
        outputStream.writeInt(v);
    }

    public void writeLong(long v) throws IOException {
        outputStream.writeLong(v);
    }

    public void writeFloat(float v) throws IOException {
        outputStream.writeFloat(v);
    }

    public void writeDouble(double v) throws IOException {
        outputStream.writeDouble(v);
    }

    public void writeBytes(String s) throws IOException {
        outputStream.writeBytes(s);
    }

    public void writeChars(String s) throws IOException {
        outputStream.writeChars(s);
    }

    public void writeUTF(String str) throws IOException {
        outputStream.writeUTF(str);
    }

    public int size() {
        return outputStream.size();
    }

    @Override
    public void write(byte[] b) throws IOException {
        outputStream.write(b);
    }

    @Override
    public void close() throws IOException {
        outputStream.close();
    }
}
