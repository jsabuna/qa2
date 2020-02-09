import org.junit.jupiter.api.Test;

import java.text.DateFormatSymbols;

public class FirstHomework {
    @Test
    public void firstHomework() {
        carAdvertisement("BMW", "46.500", "10.000");
        priceForFuel(20, 200);
        personalCode(24, 4, 1990);
        calculateDistance(52.76, 1.19, 52.76, 1.20);

    }

    public void carAdvertisement(String carMake, String mileage, String price) {
        System.out.println("The car for sale:");
        System.out.println(carMake + " " + "Mileage - " + mileage + " " + " price - " + price + " ");
    }

    public void priceForFuel(int consumptionPer100Km, int distance) {
        double priceForLitre = 3.57;
        double litreQuantity = 0;
        double totalPrice = 0;
        litreQuantity = (distance * consumptionPer100Km) / 100;
        totalPrice = litreQuantity * priceForLitre;
        System.out.println("Total price for the fuel:" + totalPrice);

    }

    public void personalCode(int day, int month, int year) {
        String convertedMonth = "january";
        DateFormatSymbols df = new DateFormatSymbols();
        convertedMonth = df.getMonths()[month - 1];
        System.out.println("Your date of birth:" + Integer.toString(day) + " " + convertedMonth + " " + Integer.toString(year));

    }

    public void calculateDistance(double longitude1, double latitude1, double longitude2, double latitude2) {
        int scale = 200;
        double distanceX = 0;
        double distanceY = 0;
        distanceX = longitude2 - longitude1;
        distanceY = latitude2 - latitude1;
        distanceX = distanceX * scale;
        distanceY = distanceY * scale;
        System.out.println("The X distance is:" + Double.toString(distanceX) );
        System.out.println("The Y distance is:" + Double.toString(distanceY));

    }
}

