package bgame;

import java.util.Scanner;

import mgr.Factory;
import mgr.Manager;

public class Main {
    Scanner sc = new Scanner(System.in);
    Manager<BoardGame> BoardMgr = new Manager<>();
    Manager<Drink> DrinkMgr = new Manager<>();
    Room RoomMgr = new Room();

    public static void main(String[] args) {
        Main b = new Main();
        b.run();
    }

    void run() {
        BoardMgr.readAll("boardgame.txt", new Factory<BoardGame>() {
            public BoardGame create() {
                return new BoardGame();
            }
        });
        DrinkMgr.readAll("drink.txt", new Factory<Drink>() {
            public Drink create() {
                return new Drink();
            }
        });
        while (true) {
            System.out.print("(1) 입장 (2) 퇴장 (3) 검색 => ");
            int menu = sc.nextInt();
            if (menu == 1) {
                RoomMgr.readAll();

                // 모든 보드게임 종류 보여주기
                BoardMgr.printAll();
                while (true) {
                    System.out.print("사용하실 보드게임을 입력해주세요: ");
                    // 보드게임 입력
                    String n = sc.next();
                    // if (보드게임 개수 정해져있을 때) 모두 사용중이면 '무슨 보드게임'은 이미 사용중입니다. 다시 입력해주세요.
                    // ㄴ 이렇게 할거면 Room에 사용중인 보드게임도 같이 저장해야할 듯?
                    if (BoardMgr.find(n) == null) {
                        System.out.println("존재하지 않는 보드게임입니다. 다시 입력해주세요.\n");
                        continue;
                    }
                    else break;
                }

                // 모든 음료수 종류 보여주기
                DrinkMgr.printAll();
                System.out.print("주문하실 음료수를 모두 입력하신 후 0을 입력해주세요: ");
                // 음료수 입력
                int totalprice = 0;
                while(true) {
                    String m = sc.next();
                    if(m == "0") break;
                    int mprice = DrinkMgr.find(m).price;
                    totalprice += mprice;
                }
                // 금액 얼마인지 출력
                System.out.println("지불하실 금액은 " + totalprice + "원 입니다.\n");

                System.out.println("즐거운 시간 보내세요.");
            } else if (menu == 2) {
                RoomMgr.pop();
                // if 보드게임도 반납할거면 여기 반납 명령어 만들기
                // ㄴ (Room에 HashMap으로 만들어서 할 경우 그냥 위의 pop 명령어로 모두 해결할 수 있을 듯)

                System.out.println("안녕히 가세요.");
            } else if (menu == 3) {
                System.out.print("(1) 보드게임 검색 (2) 음료수 검색 => ");
                int find = sc.nextInt();
                if (find == 1) {
                    BoardMgr.search();
                } else if (find == 2) {
                    DrinkMgr.search();
                } else
                    break;
            } else
                break;
        }

    }

}