package currencyexchange.currency;

import currencyexchange.utility.Exchangeable;

public abstract class Currency implements Exchangeable{
	protected String currencyName;
	protected double totalFunds;
	
	public abstract double toEarthDollars(double amount);
	public abstract double fromEarthDollars(double EarthDollars);
	
	protected abstract double getTransactionFee(double amount);
	
	@Override
	public void exchange(Exchangeable other, double amount) {
		double transactionFee = getTransactionFee(amount);
		double AmountInEarthDollars = toEarthDollars(amount);
		
		if (this.totalFunds >= (amount + transactionFee)) {
			this.totalFunds -= (amount + transactionFee);
			double otherCurrencyAmount = ((Currency) other).fromEarthDollars(AmountInEarthDollars);

			System.out.println("Converting from " + this.currencyName + " to " + 
							   ((Currency) other).currencyName + " and initiating transfer…");
			System.out.println(String.format("%.2f %s = %.2f EarthDollars = %.2f %s", 
											 amount, this.currencyName, AmountInEarthDollars, 
											 otherCurrencyAmount, ((Currency) other).currencyName));
            System.out.println(String.format("%s exchange fee is %.2f %s", 
            								 this.currencyName, transactionFee, this.currencyName));
            System.out.println(String.format("%s has a total of %.2f %s", 
            								 this.currencyName, this.totalFunds, this.currencyName));
            System.out.println(String.format("%s has a total of %.2f %s", 
            								 ((Currency) other).currencyName, 
            								 ((Currency) other).totalFunds, 
            								 ((Currency) other).currencyName));
            
		} else {
			System.err.println(String.format(
					"Uh oh - %s only has an available balance of %.2f, "
					+ "which is less than %.2f!", 
					this.currencyName, this.totalFunds, amount + transactionFee));
		}
		
	}
}


