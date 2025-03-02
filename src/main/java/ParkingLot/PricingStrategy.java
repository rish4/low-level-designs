package ParkingLot;

import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;

interface PricingStrategy {
    double calculateFee(Ticket ticket);
}

class StandardPricingStrategy implements PricingStrategy{
    private static final double RATE_PER_HOUR= 5.0;

    @Override
    public double calculateFee(Ticket ticket) {
        long hours= ChronoUnit.HOURS.between(ticket.getEntryTime(), LocalDateTime.now());
        return Math.max(hours * RATE_PER_HOUR, RATE_PER_HOUR);
    }

}

class WeekendPricingStrategy implements PricingStrategy{
    private static final double WEEKEND_RATE= 4.0;

    @Override
    public double calculateFee(Ticket ticket) {
        long hours= ChronoUnit.HOURS.between(ticket.getEntryTime(), LocalDateTime.now());
        return Math.max(hours * WEEKEND_RATE, WEEKEND_RATE);
    }

}

class Payment{
    private PricingStrategy pricingStrategy;

    public Payment(PricingStrategy strategy){
        this.pricingStrategy=strategy;
    }

    public double processPayment(Ticket ticket){
        return pricingStrategy.calculateFee(ticket);
    }

}
