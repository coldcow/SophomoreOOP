package mng;

<<<<<<< Updated upstream
=======
import java.io.File;
>>>>>>> Stashed changes
import java.util.Scanner;

public interface Manageable {
    void read(Scanner scanner);

<<<<<<< Updated upstream
=======
	void write(File file);
	
>>>>>>> Stashed changes
    void print();

    boolean matches(String keyword);
}