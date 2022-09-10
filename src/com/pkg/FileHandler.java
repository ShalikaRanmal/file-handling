package com.pkg;

import java.io.IOException;
import java.lang.reflect.Array;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class FileHandler {
    public FileHandler(String filePath){
        this.filePath= Paths.get(filePath);
    }
    private Path filePath;

    public void WrietFile(Student student) throws IOException {
        String fileContent= Files.readString(filePath);
        System.out.println(fileContent);
        String out=fileContent+student.toFileFormat();
        Files.writeString(this.filePath,out);

    }
    public List<Student> ReadFile() throws IOException {
        String fileContent=Files.readString(filePath);
        System.out.println(fileContent);
        fileContent=fileContent.substring(0,fileContent.length()-3);
        String[] students = fileContent.split("<%>");
        List<Student> studs = new ArrayList<Student>();
        for(String std:students){
            String name=std.split("<%%>")[0].split("=")[1];
            int age = Integer.parseInt(std.split("<%%>")[1].split("=")[1]);
            studs.add(new Student(name,age));
        }
        return studs;
    }
    public Student getStudentByName(String name) throws IOException {
        for (Student student: ReadFile()
             ) {
            if(student.getName().equals(name)){
                System.out.println(student.getName()+"ok");
                return student;
            }
        }
        return null;
    }
    public Path getFilePath(){
        return filePath;
    }
}
