package bgc;

public class Payment {
	public static void giveMileage(User user, int total) {
		user.mileage += (int) (total * 0.03);
	}

	public static int useMileage(User user, int cost, int mileageToUse) {
		user.mileage -= mileageToUse;
		return cost - mileageToUse;
	}
}
