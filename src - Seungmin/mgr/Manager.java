package mgr;

import java.io.File;
import java.io.FileNotFoundException;

import java.util.ArrayList;
import java.util.Scanner;

public class Manager<T extends Manageable> {
	static public Scanner consoleScanner = new Scanner(System.in);
	
	public static Scanner openFile(String fileName) {
		try {
			return new Scanner(new File(fileName));
		}
		
		catch (FileNotFoundException exception) {
			System.out.println(exception);
			System.exit(0);
			return null;
		}
	}
	
	public ArrayList<T> managees = new ArrayList<>();

	public T find(String keyword) {
		for (T managee : managees) {
			if (managee.matches(keyword))
				return managee;
		}
		
		return null;
	}

	public void readAll(Scanner scanner, Factory<T> fac) {
		
		while (filein.hasNext()) {
			T managee = fac.create();
			managee.read(filein);
			managees.add(managee);
		}
		
		filein.close();
	}

	public void printAll() {
		for (T managee : managees) managee.print();
	}

	public void search() {
		String searchWord = null;
		
		while (true) {
			System.out.print("검색어: ");
			searchWord = scanner.next();
			
			if (searchWord.contentEquals("end"))
				break;
			
			for (T managee : managees) {
				if (managee.matches(searchWord))
					managee.print();	
			}
		}
	}
}
