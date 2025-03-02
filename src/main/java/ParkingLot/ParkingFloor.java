package ParkingLot;

import java.util.ArrayList;
import java.util.List;

import static ParkingLot.VehicleType.*;

 class ParkingFloor {
    private int floorNumber;
    private List<ParkingSpot> spots;

    public ParkingFloor(int floorNumber){
        this.floorNumber=floorNumber;
        this.spots=new ArrayList<>();
    }

    public void addParkingSpot(ParkingSpot spot){
        spots.add(spot);
    }

    //TODO: remove parking spot

    public ParkingSpot findAvailableSpot(VehicleType type){
        for(ParkingSpot spot: spots){
            if(spot.isAvailable() && isSpotSuitable(type, spot.getType())){
                return spot;
            }
        }
        return null;
    }

    private boolean isSpotSuitable(VehicleType vehicleType, ParkingSpotType spotType) {
        switch (vehicleType){
            case MOTORCYCLE:
                return  true;
            case CAR:
                return spotType== ParkingSpotType.MEDIUM ||  spotType==ParkingSpotType.LARGE;
            case TRUCK:
                return spotType==ParkingSpotType.LARGE;
            default:
                return false;
        }
    }
}
