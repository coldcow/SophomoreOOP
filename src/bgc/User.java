package bgc;

import java.io.*;
<<<<<<< Updated upstream
import java.util.ArrayList;
import java.util.Scanner;

import mng.Manageable;
import mng.Manager;

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
    public void print() {
        System.out.printf("%s(%d세): %dPoint 보유\n", identifier, age, mileage);
    }

    @Override
    public boolean matches(String keyword) {
        return identifier.equals(keyword);
    }

    public void createUser(File file, String newId, String newPassword, int newAge) {
        try {
            BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(file, true));

            if (file.isFile() && file.canWrite()) {

                bufferedWriter.write(newId + " ");
                bufferedWriter.write(newPassword + " ");
                bufferedWriter.write(newAge + " ");
                bufferedWriter.write("0");
                bufferedWriter.newLine();

                bufferedWriter.close();
            }
        } catch (IOException e) {
            System.out.println(e);
        }
    }

    void updateUser(Manager<User> userManager, File file) {
        try (BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(file, false))) {
            for (User user : userManager.managees) {
                if (file.isFile() && file.canWrite()) {

                    bufferedWriter.write(user.identifier + " ");
                    bufferedWriter.write(user.password + " ");
                    bufferedWriter.write(user.age + " ");
                    bufferedWriter.write(toString(user.mileage));
                    bufferedWriter.newLine();

                    bufferedWriter.close();
                }
            }
        } catch (IOException e) {
            System.out.println(e);
        }
    }

    private String toString(int mileage) {
        return String.valueOf(mileage);
    }
=======
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

	private String toString(int mileage) {
		return String.valueOf(mileage);
	}
>>>>>>> Stashed changes
}