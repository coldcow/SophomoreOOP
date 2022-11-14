package bgc;

import java.io.*;
import java.util.Scanner;

import mng.Manageable;

public class User implements Manageable {
    String identifier;
    String password;
    int age;
    int mileage = 0;
    @Override
    public void read(Scanner scanner) {
        identifier = scanner.next();
        password = scanner.next();
        age = scanner.nextInt();
        mileage = scanner.nextInt();
    }

    @Override
    public void print() {
        System.out.printf("%s(%d세): %dPoint 보유\n", identifier, age, mileage);
    }

    @Override
    public boolean matches(String keyword) {
        return identifier.equals(keyword);
    }

    public void signUp(File file, String newId, String newPassword, int newAge) {
        try{
            BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(file,true));

            if(file.isFile() && file.canWrite()){

                bufferedWriter.write(newId + " ");
                bufferedWriter.write(newPassword + " ");
                bufferedWriter.write(newAge + " ");
                bufferedWriter.write("0");
                bufferedWriter.newLine();

                bufferedWriter.close();
            }
        }catch (IOException e) {
            System.out.println(e);
        }
    }
}