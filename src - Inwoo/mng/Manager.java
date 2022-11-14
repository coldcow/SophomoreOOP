package mng;

import java.util.ArrayList;
import java.util.Scanner;

import bgc.Main;

public class Manager<T extends Manageable> {
	public ArrayList<T> managees = new ArrayList<>();

	public void readAll(Scanner scanner, Factory<T> factory) {
		while (scanner.hasNext()) {
			T managee = factory.create();
			managee.read(scanner);
			managees.add(managee);
		}
	}

	public void printAll() {
		for (T managee : managees)
			managee.print();
	}

	public void search() {
		String searchWord = null;

		while (true) {
			System.out.print("검색어: ");
			searchWord = Main.scanner.next();

			if (searchWord.equals("end"))
				break;

			for (T managee : managees) {
				if (managee.matches(searchWord))
					managee.print();
			}
		}
	}

	public T find(String keyword) {
		for (T managee : managees) {
			if (managee.matches(keyword))
				return managee;
		}

		return null;
	}

}
