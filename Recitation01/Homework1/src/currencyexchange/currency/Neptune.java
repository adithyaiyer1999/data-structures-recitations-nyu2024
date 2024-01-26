package currencyexchange.currency;

public class Neptune extends Currency {

    public Neptune(double initialFunds) {
        this.currencyName = "NeptuneNuggets";
        this.totalFunds = initialFunds;
    }

    @Override
    public double toEarthDollars(double amount) {
        return amount / EARTH_DOLLAR_TO_NEPTUNE_NUGGET;
    }

    @Override
    public double fromEarthDollars(double EarthDollars) {
    	double neptuneNugget = EarthDollars * EARTH_DOLLAR_TO_NEPTUNE_NUGGET;
        this.totalFunds += neptuneNugget;
        return neptuneNugget;
    }

    @Override
    protected double getTransactionFee(double amount) {
        return 5.0; // flat rate of 5 NeptuneNuggets per transaction
    }
}