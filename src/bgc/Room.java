package bgc;

import java.io.File;
import java.util.Scanner;

import mng.Manageable;

public class Room implements Manageable {
	public int number;
	public boolean availability;

	@Override
	public void read(Scanner scanner) {
		number = scanner.nextInt();
		availability = scanner.nextBoolean();
	}

	@Override
	public void write(File file) {
	}

	@Override
	public void print() {
		System.out.printf("%d번 방\n", number);
	}

	@Override
	public boolean matches(String keyword) {
		return (number + "").equals(keyword);
	}
}
