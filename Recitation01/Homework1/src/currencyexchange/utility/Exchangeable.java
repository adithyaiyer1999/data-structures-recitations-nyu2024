package currencyexchange.utility;

public interface Exchangeable {
	double EARTH_DOLLAR_TO_MARS_MONEY = 1.3;
	double EARTH_DOLLAR_TO_SATURN_SILVER = 0.87;
	double EARTH_DOLLAR_TO_NEPTUNE_NUGGET = 2.0;
	
	void exchange(Exchangeable other, double amount);

}



