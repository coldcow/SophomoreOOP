package bgc;

import java.util.Scanner;

import mgr.Factory;
import mgr.Manager;

public class Cafe {
	Scanner scanner = new Scanner(System.in);
	Manager<BoardGame> BoardGameManager = new Manager<>();
	Manager<Drink> DrinkManager = new Manager<>();
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
			System.out.print("(1) ���� (2) ���� (3) �˻� => ");
			int menu = sc.nextInt();
			if (menu == 1) {
				RoomMgr.readAll();

				// ��� ������� ���� �����ֱ�
				BoardMgr.printAll();
				while (true) {
					System.out.print("����Ͻ� ��������� �Է����ּ���: ");
					// ������� �Է�
					String n = sc.next();
					// if (������� ���� ���������� ��) ��� ������̸� '���� �������'�� �̹� ������Դϴ�. �ٽ� �Է����ּ���.
					// �� �̷��� �ҰŸ� Room�� ������� ������ӵ� ���� �����ؾ��� ��?
					if (BoardMgr.find(n) == null) {
						System.out.println("�������� �ʴ� ��������Դϴ�. �ٽ� �Է����ּ���.\n");
						continue;
					}
					else break;
				}
				
				// ��� ����� ���� �����ֱ�
				DrinkMgr.printAll();
				System.out.print("�ֹ��Ͻ� ������� ��� �Է��Ͻ� �� 0�� �Է����ּ���: ");
				// ����� �Է�
				int totalprice = 0;
				while(true) {
					String m = sc.next();
					if(m == "0") break;
					int mprice = DrinkMgr.find(m).price;
					totalprice += mprice; 
				}
				// �ݾ� ������ ���
				System.out.println("�����Ͻ� �ݾ��� " + totalprice + "�� �Դϴ�.\n");

				System.out.println("��ſ� �ð� ��������.");
			} else if (menu == 2) {
				RoomMgr.pop();
				// if ������ӵ� �ݳ��ҰŸ� ���� �ݳ� ���ɾ� �����
				// �� (Room�� HashMap���� ���� �� ��� �׳� ���� pop ���ɾ�� ��� �ذ��� �� ���� ��)

				System.out.println("�ȳ��� ������.");
			} else if (menu == 3) {
				System.out.print("(1) ������� �˻� (2) ����� �˻� => ");
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