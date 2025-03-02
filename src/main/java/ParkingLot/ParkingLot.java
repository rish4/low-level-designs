package ParkingLot;


import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

class ParkingLot {
    private static ParkingLot instance;
    private List<ParkingFloor> floors;
    private Map<String, Ticket> activeTickets;

    private ParkingLot(){    //singleton pattern
        this.floors= new ArrayList<>();
        this.activeTickets= new HashMap<>();
    }

    public static synchronized ParkingLot getInstance(){
        if(instance==null){
            instance= new ParkingLot();
        }
        return instance;
    }

    public void addFloor(ParkingFloor floor){
        floors.add(floor);
    }

    //TODO: removeFloor

    public Ticket parkVehicle(Vehicle vehicle){
        for(ParkingFloor floor: floors){
            ParkingSpot spot= floor.findAvailableSpot(vehicle.getVehicleType());
            if(spot!=null){
                spot.park();
                Ticket ticket= new Ticket(vehicle);
                activeTickets.put(vehicle.getLicensePlate(),ticket);
                return ticket;
            }
        }
        return null;
    }

    public double exitVehicle(String licensePlate, PricingStrategy pricingStrategy){
        Ticket ticket= activeTickets.remove(licensePlate);
        if(ticket!=null){
            return new Payment(pricingStrategy).processPayment(ticket);
        }
        return 0;
    }
}
