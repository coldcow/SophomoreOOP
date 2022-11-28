package bgc;

import layout.LoginFrame;
import mng.Factory;
import mng.Manager;

public class Cafe {
    public static Manager<BoardGame> boardGameManager = new Manager<>();
    public static Manager<Drink> drinkManager = new Manager<>();
    public static Manager<Room> roomManager = new Manager<>();
    public static Manager<User> userManager = new Manager<>();
    public static User user = new User();
    static BoardGame boardGame = new BoardGame();
    public static Order order;
    public static String userIdentifier = null;
    public static int cost = 0;

    void run() {
        boardGameManager.readAll(Main.scanFile("boardgame.txt"), new Factory<BoardGame>() {
            public BoardGame create() {
                return new BoardGame();
            }
        });

        drinkManager.readAll(Main.scanFile("drink.txt"), new Factory<Drink>() {
            public Drink create() {
                return new Drink();
            }
        });

        roomManager.readAll(Main.scanFile("room.txt"), new Factory<Room>() {
            public Room create() {
                return new Room();
            }
        });
        // 키오스크 시작
        LoginFrame loginFrame = new LoginFrame();
    }
}