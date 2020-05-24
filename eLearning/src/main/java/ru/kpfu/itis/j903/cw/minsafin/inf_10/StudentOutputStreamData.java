package ru.kpfu.itis.j903.cw.minsafin.inf_10;

import ru.kpfu.itis.j903.cw.minsafin.inf_9.student.BirthDate;
import ru.kpfu.itis.j903.cw.minsafin.inf_9.student.Student;

import java.io.DataOutputStream;
import java.io.IOException;
import java.io.OutputStream;

public class StudentOutputStreamData extends OutputStream {
    protected final int BYTES_PER_STUDENT;
    protected DataOutputStream dataOutputStream;

    public StudentOutputStreamData(OutputStream out) {
        BYTES_PER_STUDENT = 48;
        dataOutputStream = new DataOutputStream(out);
    }

    public void writeStudent(Student student) throws IOException {
        writeName(student.getName());
        writeBirthDate(student.getBirthDate());
        writeGroup(student.getGroup());
    }

    private void writeName(String name) throws IOException {
        for (int i = 0; i < 20; i++) {
            if (i < name.length()) {
                dataOutputStream.writeChar(name.charAt(i));
            }else {
                dataOutputStream.writeChar(Character.MIN_VALUE);
            }
        }
    }

    private void writeBirthDate(BirthDate birthDate) throws IOException {
        dataOutputStream.writeByte(birthDate.getDay());
        dataOutputStream.writeByte(birthDate.getMonth());
        dataOutputStream.writeShort(birthDate.getYear());
    }

    private void writeGroup(int group) throws IOException {
        dataOutputStream.writeInt(group);
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

    public int size() {
        return dataOutputStream.size();
    }
}
