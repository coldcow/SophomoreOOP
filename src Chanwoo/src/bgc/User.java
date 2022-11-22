package bgc;

import java.io.*;
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
		mileage = scanner.nextInt();
	}

	@Override
	public void write(File file) {
		try {
			BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(file, true));

			if (file.isFile() && file.canWrite()) {
				bufferedWriter.write(identifier + " ");
				bufferedWriter.write(password + " ");
				bufferedWriter.write(age + " ");
				bufferedWriter.write(mileage + "");
				bufferedWriter.newLine();
				bufferedWriter.close();
			}
		}

		catch (IOException exception) {
			System.out.println(exception);
		}
	}

	public void read(String identifier, String password, int age) {
		this.identifier = identifier;
		this.password = password;
		this.age = age;
	}

	@Override
	public void print() {
		System.out.printf("%s(%d세): %dPoint 보유\n", identifier, age, mileage);
	}

	@Override
	public boolean matches(String keyword) {
		return identifier.equals(keyword);
	}
	
	public String getUserID() {
		return identifier;
	}
}