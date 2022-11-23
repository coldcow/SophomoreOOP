package bgc;

import java.io.File;
import java.util.Scanner;

import mng.Manageable;

public class Room implements Manageable {
	String number;
	boolean availability;
	
	@Override
	public void read(Scanner scanner) {
		number = scanner.next();
		availability = scanner.nextBoolean();
	}

	@Override
	public void write(File file) {		
	}
	
	@Override
	public void print() {
		System.out.printf("%s번 방\n", number);
	}
	
	@Override
	public boolean matches(String keyword) {
		return (number + "").equals(keyword);
	}
}
