import java.util.*;

public class uc8_ParkingLotManagement {

    static String[] parking = new String[10];

    public static int parkVehicle(String plate) {

        int index = Math.abs(plate.hashCode()) % parking.length;

        while (parking[index] != null) {
            index = (index + 1) % parking.length;
        }

        parking[index] = plate;
        return index;
    }

    public static void main(String[] args) {

        System.out.println("Vehicle parked at spot: " + parkVehicle("ABC1234"));
        System.out.println("Vehicle parked at spot: " + parkVehicle("XYZ9999"));
    }
}