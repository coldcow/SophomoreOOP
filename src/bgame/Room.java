package bgame;

import java.util.ArrayList;
import java.util.Scanner;

public class Room {
    public ArrayList<Integer> roomList = new ArrayList<>();
    Scanner sc = new Scanner(System.in);

    public void readAll() {
        while (true) {
            System.out.print("원하는 방 번호를 입력하세요: ");
            int room = sc.nextInt();
            if (roomList.contains(room)) {
                System.out.println("이미 사용중인 방입니다. 다시 입력해주세요.");
                continue;
            } else {
                roomList.add(room);
                break;
            }
        }
    }

    public void pop() {
        while (true) {
            System.out.print("반납하시려는 방 번호를 입력해주세요: ");
            int room = sc.nextInt();
            if (roomList.contains(room)) {
                roomList.remove(Integer.valueOf(room));
                break;
            } else {
                System.out.println("선택하신 방은 사용중인 방이 아닙니다. 다시 입력해주세요.");
                continue;
            }
        }
    }

}