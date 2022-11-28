package bgc;

import java.io.*;
import java.util.*;
import java.util.Map.Entry;

public class Order {
    ArrayList<String> orderedName = new ArrayList<>();
    HashMap<String, Integer> userHistory = new HashMap<>();
    String id;

    public Order(String id) {
        this.id = id;
    }

    public void addOrderToFile(File file) {
        try {
            BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(file, true));

            if (file.isFile() && file.canWrite()) {

                bufferedWriter.write(id + " ");
                for (String item : orderedName) {
                    bufferedWriter.write(item + " ");
                }
                //개행문자쓰기
                bufferedWriter.newLine();
                bufferedWriter.close();
            }
        } catch (IOException e) {
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
                    if (order.equals("")) {
                        continue;
                    }
                    else if (userHistory.containsKey(order)){
                        userHistory.put(order, userHistory.get(order) + 1);
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

    public void recomand(List<Entry<String, Integer>> list) {
        int i = 3;
        if (list.size() < 3) {
            System.out.println("데이터가 부족하여 추천이 어렵습니다.");
        }
        else {
            for (Entry<String, Integer> entry : list.subList(list.size() - 3, list.size())) {
                System.out.println(i +" : " + entry.getKey());
                i--;
            }
        }
    }
}

