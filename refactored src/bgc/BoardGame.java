package bgc;

import java.util.Scanner;

import mng.Manageable;

public class BoardGame implements Manageable {
	String name;
	String level;
	String genre;
	String numberOfPlayer;
	String time;

	@Override
	public void read(Scanner scanner) {
		name = scanner.next();
		level = scanner.next();
		genre = scanner.next();
		numberOfPlayer = scanner.next();
		time = scanner.next();
	}

	@Override
	public void print() {
		System.out.format("[%s]  난이도 : %s\t%s\t%s\t%s"
				, name, level, genre, numberOfPlayer, time);
		System.out.println();
	}

	@Override
	public boolean matches(String keyword) {
		return (name.contains(keyword) 
				|| level.contains(keyword) 
				|| genre.contains(keyword)
				|| numberOfPlayer.contains(keyword) 
				|| time.contains(keyword));
	}
}
