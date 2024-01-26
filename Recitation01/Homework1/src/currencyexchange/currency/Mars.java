package currencyexchange.currency;

public class Mars extends Currency {

    public Mars(double initialFunds) {
        this.currencyName = "MarsMoney";
        this.totalFunds = initialFunds;
    }

    @Override
    public double toEarthDollars(double amount) {
        return amount / EARTH_DOLLAR_TO_MARS_MONEY;
    }

    @Override
    public double fromEarthDollars(double EarthDollars) {
        double marsMoney = EarthDollars * EARTH_DOLLAR_TO_MARS_MONEY;
        this.totalFunds += marsMoney;
        return marsMoney;
        
    }

    @Override
    protected double getTransactionFee(double amount) {
        return amount * 0.1; 
    }
}


