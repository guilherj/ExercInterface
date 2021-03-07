package model.services;

public class Paypal implements OnlinePaymentService {

	@Override
	public double taxService(double amount, int portion) {
		
		double monthlyInterest = amount + ((amount * 0.01) * portion);
		
		double tax = monthlyInterest * 0.02;
		
		amount = monthlyInterest + tax;
		
		return amount;
	}

	
	

}
