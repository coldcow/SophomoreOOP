package bgc;

public class Payment {

    public void giveMileage(User user, int total) {
        user.mileage += (int) (total * 0.03);
    }

    public int useMileage(User user, int total, int usingMileage) {
        int PaymentPrice = 0;
        if (user.mileage < usingMileage) {
            System.out.println("마일리지가 부족합니다");
        } else {
            PaymentPrice = total - usingMileage;
            user.mileage -= usingMileage;
        }
        return PaymentPrice;
    }

    public int showMileage(User user) {
        return user.mileage;
    }
}
