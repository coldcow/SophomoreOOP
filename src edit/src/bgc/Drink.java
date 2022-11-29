package bgc;

import java.io.File;
import java.util.Scanner;

import mng.Manageable;

public class Drink implements Manageable {
	public String type;
	public String name;
	public int price;

	@Override
	public void read(Scanner scanner) {
		type = scanner.next();
		name = scanner.next();
		price = scanner.nextInt();
	}

	@Override
	public void write(File file) {
	}

	@Override
	public void print() {
		System.out.format("[%s]\t <%s>\t %d원\n", type, name, price);
	}

	@Override
	public boolean matches(String keyword) {
		return (type.contains(keyword) || name.contains(keyword) || (price + "").contains(keyword));
	}

	public String[] getTexts() {
		return new String[] { type, name, "" + price };
	}
}