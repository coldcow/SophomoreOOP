package bgc;

import java.io.File;
import java.util.Scanner;

import mng.Manageable;

public class BoardGame implements Manageable {
    public String name;
    public String level;
    public String genre;
    public String numberOfPlayer;
    public String time;

    @Override
    public void read(Scanner scanner) {
        name = scanner.next();
        level = scanner.next();
        genre = scanner.next();
        numberOfPlayer = scanner.next();
        time = scanner.next();
    }

	@Override
	public void write(File file) {
	}
	
    @Override
    public void print() {
        System.out.format("[%s]  난이도 : %s\t%s\t%s\t%s"
                , name, level, genre, numberOfPlayer, time);
        System.out.println();
    }

    @Override
    public boolean matches(String keyword) {
    	if (keyword.equals("추천")) {
    		for(String kwd : Cafe.order.returnOrders("board")) {
    			if(matches(kwd))
    				return true;
    		}
    		return false;
    	}
        return ("전체".equals(keyword)
        		|| name.contains(keyword)
                || level.contains(keyword)
                || genre.contains(keyword)
                || numberOfPlayer.contains(keyword)
                || time.contains(keyword));
    }

    public String[] getTexts() {
        return new String[] { name, level, genre, numberOfPlayer, time };
    }
}