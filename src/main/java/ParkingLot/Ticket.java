package ParkingLot;

import java.time.LocalDateTime;

class Ticket {
    private Vehicle vehicle;
    private LocalDateTime entryTime;

    public Ticket(Vehicle vehicle){
        this.vehicle=vehicle;
        this.entryTime= LocalDateTime.now();
    }

    public LocalDateTime getEntryTime(){
        return  entryTime;
    }

    public Vehicle getVehicle(){
        return vehicle;
    }
}
