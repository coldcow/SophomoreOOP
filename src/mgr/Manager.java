package mgr;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class Manager<T extends Manageable> {
    static public Scanner sc = new Scanner(System.in);
    public ArrayList<T> mList = new ArrayList<>();

    public T find(String name) {
        for (T p : mList) {
            if (p.matches(name))
                return p;
        }
        return null;
    }

    public void readAll(String filename, Factory<T> fac) {
        Scanner filein = null;
        try {
            filein = new Scanner(new File(filename));
        } catch (FileNotFoundException e) {
            System.out.println(e);
            System.exit(0);
        }
        while (filein.hasNext()) {
            T m = fac.create();
            m.read(filein);
            mList.add(m);
            // m.print();
        }
        filein.close();
    }

    public void printAll() {
        for (T p : mList)
            p.print();
    }

    public void search() {
        String kwd = null;
        while (true) {
            System.out.print("검색어: ");
            kwd = sc.next();
            if (kwd.contentEquals("end"))
                break;
            for (T m : mList) {
                if (m.matches(kwd))
                    m.print();
            }
        }
    }

}