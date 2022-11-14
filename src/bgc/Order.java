package bgc;

import java.io.*;
import java.util.*;

public class Order {
    ArrayList<String> orderedName = new ArrayList<>();
    HashMap<String, Integer> userHistory = new HashMap<>();
    String id;

    Order(String id) {
        this.id = id;
    }
    public void addOrderToFile(File file) {
        try{
            BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(file,true));

            if(file.isFile() && file.canWrite()){

                bufferedWriter.write(id + " ");
                for (String item : orderedName) {
                    bufferedWriter.write(item + " ");
                }
                //개행문자쓰기
                bufferedWriter.newLine();

                bufferedWriter.close();
            }
        }catch (IOException e) {
            System.out.println(e);
        }
    }

    public HashMap<String, Integer> getOrderFromFile(Scanner scanner) {
        String trash = null;

        while (scanner.hasNext()) {
            trash = scanner.next();
            if (id.equals(trash)) {
                String[] orderList = scanner.nextLine().split(" ");
                for (String order : orderList) {
                    if (userHistory.containsKey(order)) {
                        userHistory.put(order, userHistory.get(order)+1);
                    }
                    else {
                        userHistory.put(order, 1);
                    }
                }
            } else {
                trash = scanner.nextLine();
            }
        }
        return userHistory;
        }
    }

