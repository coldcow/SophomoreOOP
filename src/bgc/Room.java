package bgc;

import java.util.Scanner;

import mng.Manageable;

public class Room implements Manageable {
	String number;
	int availability;
	
	@Override
	public void read(Scanner scanner) {
		number = scanner.next();
		availability = scanner.nextInt();
	}
	
	@Override
	public void print() {
		System.out.printf("[%s]\n", number);
	}
	
	@Override
	public boolean matches(String keyword) {
		return number.contains(keyword);
	}
}
