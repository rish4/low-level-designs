package ParkingLot;

import static ParkingLot.ParkingSpotType.*;

public class ParkingLotMain {
    public static void main(String[] args) {
        ParkingLot parkingLot=ParkingLot.getInstance();
        ParkingFloor floor1= new ParkingFloor(1);

        floor1.addParkingSpot(new ParkingSpot(1, SMALL));
        floor1.addParkingSpot(new ParkingSpot(2, MEDIUM));
        floor1.addParkingSpot(new ParkingSpot(3, LARGE));

        parkingLot.addFloor(floor1);

        Vehicle car= new Car("ABC-123");
        Ticket ticket= parkingLot.parkVehicle(car);

        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        double fee= parkingLot.exitVehicle(car.getLicensePlate(), new StandardPricingStrategy());

        System.out.println("Total parking fee: "+ fee);
    }

}
