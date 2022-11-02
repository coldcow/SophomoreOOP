package bgame;

import java.util.Scanner;

import mgr.Manageable;

public class Room implements Manageable {
    int number;
    boolean availability = true;

    @Override
    public void read(Scanner scanner) {
        number = scanner.nextInt();
    }

    @Override
    public void print() {
        System.out.printf("[%d번 방]\n", number);
    }

    @Override
    public boolean matches(String keyword) {
        return (number + "").contentEquals(keyword);
    }
}