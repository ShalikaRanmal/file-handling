import com.pkg.FileHandler;
import com.pkg.Student;

import java.io.IOException;

public class Main {
    public static void main(String[] args) {

        try {
            FileHandler fileHandler = new FileHandler("F:\\Java\\Projects\\untitled\\src\\myfile.txt");
            Student student = new Student("Vimukthi H",30);
            Student std2 = new Student("Kasun",27);
            fileHandler.WrietFile(student);
            fileHandler.WrietFile(std2);
            System.out.println(fileHandler.ReadFile());
            Student get_by_id =fileHandler.getStudentByName("Ka");
            System.out.println("Studnet found"+get_by_id);
        }catch (IOException e){
            e.printStackTrace();
        }
    }
}