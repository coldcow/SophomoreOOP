package bgc;

import gui.LoginFrame;
import mng.Factory;
import mng.Manager;

public class Cafe {
	/*static Manager<BoardGame> boardGameManager = new Manager<>();
	static Manager<Drink> drinkManager = new Manager<>();
	static Manager<Room> roomManager = new Manager<>();
	static Manager<User> userManager = new Manager<>();

	static HashMap<String, Integer> orderList = null;

	static User user;
	static Room room;
	static BoardGame boardGame;
	static Drink drink;
	static Order order = new Order(null);

	static String userIdentifier;
	static String userPassword;
	static int userAge;
	static String roomNumber;
	static String boardGameInformation;
	static String drinkName;
	static int mileageToUse = 0;
	static int cost;*/
	
    public static Manager<BoardGame> boardGameManager = new Manager<>();
    public static Manager<Drink> drinkManager = new Manager<>();
    public static Manager<Room> roomManager = new Manager<>();
    public static Manager<User> userManager = new Manager<>();
    
    public static User user = new User();
    public static Room room = new Room();
    public static Order order;
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