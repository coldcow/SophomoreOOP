package bgc;

import java.io.*;
import java.util.Scanner;

public class Main {
    public static Scanner scanner = new Scanner(System.in);

<<<<<<< Updated upstream
    public static Scanner openFile(File file) {
=======
    public static Scanner scanFile(File file) {
>>>>>>> Stashed changes
        try {
            return new Scanner(file);
        }

        catch (FileNotFoundException exception) {
            System.out.println(exception);
            System.exit(0);
        }

        return null;
    }

<<<<<<< Updated upstream
    public static Scanner openFile (String fileName) {
        return openFile(new File(fileName));
    }

    public static File openJustFile (String fileName) {
=======
    public static Scanner scanFile (String fileName) {
        return scanFile(new File(fileName));
    }

    public static File openFile (String fileName) {
>>>>>>> Stashed changes
        return new File(fileName);
    }

    public static void main(String[] args) {
        Cafe cafe = new Cafe();
        cafe.run();
    }
}