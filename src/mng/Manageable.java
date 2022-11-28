package mng;

import java.io.File;
import java.util.Scanner;

public interface Manageable {
    void read(Scanner scanner);

	void write(File file);
	
    void print();

    boolean matches(String keyword);
}