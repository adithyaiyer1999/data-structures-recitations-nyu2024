package currencyexchange.currency;

public class Saturn extends Currency {

    public Saturn(double initialFunds) {
        this.currencyName = "SaturnSilver";
        this.totalFunds = initialFunds;
    }

    @Override
    public double toEarthDollars(double amount) {
        return amount / EARTH_DOLLAR_TO_SATURN_SILVER;
    }

    @Override
    public double fromEarthDollars(double EarthDollars) {
    	double saturnSilver = EarthDollars * EARTH_DOLLAR_TO_SATURN_SILVER;
        this.totalFunds += saturnSilver;
        return saturnSilver;
    }

    @Override
    protected double getTransactionFee(double amount) {
        return 0.0; // Saturn does not charge any fee
    }
}