package mng;

import java.io.File;
import java.util.*;
import java.util.Map.Entry;

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

	public void writeAll(File file) {
		for (T managee : managees)
			managee.write(file);
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
			if (managee.matches(keyword)) {
				return managee;
			}
		}

		return null;
	}
<<<<<<< Updated upstream
=======
	
	public ArrayList<T> findAll(String keyword) {
		ArrayList<T> result = new ArrayList<>();
		
		for (T managee : managees) {
			if (managee.matches(keyword))
				result.add(managee);
		}
		
		return result;
	}
>>>>>>> Stashed changes

	public List<Entry<String, Integer>> sortMap(HashMap<String, Integer> map) {
		List<Entry<String, Integer>> list_entries = new ArrayList<Entry<String, Integer>>(map.entrySet());

		// 비교함수 Comparator를 사용하여 오름차순으로 정렬
		Collections.sort(list_entries, new Comparator<Entry<String, Integer>>() {
			// compare로 값을 비교
			public int compare(Entry<String, Integer> obj1, Entry<String, Integer> obj2) {
				// 오름 차순 정렬
				return obj1.getValue().compareTo(obj2.getValue());
			}
		});
		return list_entries;
	}
}