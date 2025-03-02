package ParkingLot;

class ParkingSpot {
    private int spotNumber;
    private boolean isOccupied;
    private ParkingSpotType type;

    public ParkingSpot(int spotNumber, ParkingSpotType parkingSpotType){
        this.spotNumber=spotNumber;
        this.isOccupied=false;
        this.type=parkingSpotType;
    }

    public boolean isAvailable(){
        return !isOccupied;
    }

    public void park(){
        isOccupied=true;
    }

    public void leave(){
        isOccupied=false;
    }

    public ParkingSpotType getType(){
        return type;
    }
}
