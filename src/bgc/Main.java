package bgc;

import java.io.*;
import java.util.Scanner;

public class Main {
    public static Scanner scanner = new Scanner(System.in);

    public static Scanner openFile(File file) {
        try {
            return new Scanner(file);
        }

        catch (FileNotFoundException exception) {
            System.out.println(exception);
            System.exit(0);
        }

        return null;
    }

    public static Scanner openFile (String fileName) {
        return openFile(new File(fileName));
    }

    public static File openJustFile (String fileName) {
        return new File(fileName);
    }

    public static void main(String[] args) {
        Cafe cafe = new Cafe();
        cafe.run();
    }
}