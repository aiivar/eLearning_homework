package ru.kpfu.itis.j903.cw.minsafin.inf_13;

import ru.kpfu.itis.j903.cw.minsafin.inf_13.jsondecorator.JsonStudentReader;
import ru.kpfu.itis.j903.cw.minsafin.inf_13.jsondecorator.JsonStudentWriter;
import ru.kpfu.itis.j903.cw.minsafin.inf_13.yamldecorator.YamlStudentReader;
import ru.kpfu.itis.j903.cw.minsafin.inf_13.yamldecorator.YamlStudentWriter;
import ru.kpfu.itis.j903.cw.minsafin.inf_9.student.BirthDate;
import ru.kpfu.itis.j903.cw.minsafin.inf_9.student.Student;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;

public class Main_13 {
    static Path path = Paths.get("src\\main\\java\\ru\\kpfu\\itis\\j903\\cw\\minsafin\\inf_13\\filepath\\file.json");
    static Path pathYaml = Paths.get("src\\main\\java\\ru\\kpfu\\itis\\j903\\cw\\minsafin\\inf_13\\filepath\\yamlfile.yaml");
    public static void main(String[] args) {
        Student student = new Student(new BirthDate(2,2,2021),"SANOHFSAHLK",11804);
        try {
            JsonStudentWriter jsonStudentWriter = new JsonStudentWriter(new FileOutputStream(path.toString()));
            jsonStudentWriter.writeStudent(student);
            JsonStudentReader jsonStudentReader = new JsonStudentReader(new FileInputStream(path.toString()));
            System.out.println(jsonStudentReader.readStudent());
        } catch (IOException e) {
            e.printStackTrace();
        }
        try {
            YamlStudentWriter yamlStudentWriter = new YamlStudentWriter(new FileOutputStream(pathYaml.toString()));
            yamlStudentWriter.writeStudent(student);
            YamlStudentReader yamlStudentReader = new YamlStudentReader(new FileInputStream(pathYaml.toString()));
            System.out.println(yamlStudentReader.readStudent());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
