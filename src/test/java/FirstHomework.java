import org.junit.jupiter.api.Test;

import java.text.DateFormatSymbols;

import java.lang.Math;


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

    private void calculateDistance(double lat1, double lon1, double lat2, double lon2) {
        if (((lat1 == lat2) && (lon1 == lon2))) {
            System.out.println("The distance equals 0");
        } else {
            double theta = lon1 - lon2;
            double distance = Math.sin(Math.toRadians(lat1)) * Math.sin(Math.toRadians(lat2)) + Math.cos(Math.toRadians(lat1)) * Math.cos(Math.toRadians(lat2)) * Math.cos(Math.toRadians(theta));
            distance = Math.acos(distance);
            distance = Math.toDegrees(distance);
            distance = distance * 60 * 1.1515;
            distance = distance * 1.609344;
            System.out.printf("The distance equals:%.5f km", distance);
        }
    }
}

