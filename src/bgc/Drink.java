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
		if (keyword.equals("추천")) {
			for (String kwd : Cafe.order.returnOrders("")) {
				if (matches(kwd))
					return true;
			}
			return false;
		}
		return ("전체".equals(keyword) 
				|| type.contains(keyword) 
				|| name.contains(keyword) 
				|| (price + "").contains(keyword));
	}

	public String[] getTexts() {
		return new String[] { type, name, "" + price };
	}
}