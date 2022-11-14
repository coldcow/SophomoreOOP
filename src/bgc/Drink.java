package bgc;

import java.util.Scanner;

import mng.Manageable;

public class Drink implements Manageable {
    String type;
    String name;
    int price;

    @Override
    public void read(Scanner scanner) {
        type = scanner.next();
        name = scanner.next();
        price = scanner.nextInt();
    }

    @Override
    public void print() {
        System.out.format("[%s]\t <%s>\t %d원\n", type, name, price);
    }

    @Override
    public boolean matches(String keyword) {
        return (type.contains(keyword)
                || name.contains(keyword)
                || (price + "").contains(keyword));
    }
}