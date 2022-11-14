package bgc;

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
	}

	@Override
	public void print() {
		System.out.printf("%s(%d세): %dPoint 보유\n", identifier, age, mileage);
	}

	@Override
	public boolean matches(String keyword) {
		return identifier.equals(keyword);
	}
}
