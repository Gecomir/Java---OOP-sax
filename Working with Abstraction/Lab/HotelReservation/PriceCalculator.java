package WorkingWithAbstraction.HotelReservation;

public class PriceCalculator {
    private double pricePerDay;
    private int days;
    private Season season;
    private Discount discount;

    public PriceCalculator(double pricePerDay, int days, Season season, Discount discount) {
        this.pricePerDay = pricePerDay;
        this.days = days;
        this.season = season;
        this.discount = discount;
    }

    public double priceCalculate() {
        return pricePerDay * days * season.getMultiply() * discount.getPriceReduction();
    }
}
