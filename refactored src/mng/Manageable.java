package mng;

import java.util.Scanner;

public interface Manageable {
	void read(Scanner scanner);

	void print();

	boolean matches(String keyword);
}
