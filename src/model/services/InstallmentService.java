package model.services;

import java.util.Calendar;
import java.util.Date;

import model.entities.Contract;
import model.entities.Installment;

public class InstallmentService {

	private Integer numberInstallment;

	
	public InstallmentService(Integer numberInstallment) {
		this.numberInstallment = numberInstallment;

	}

	public void plotGenerator(Contract contract) {
		double parcelValue = contract.getTotalValue() / numberInstallment;

		for(int i = 1; i <= numberInstallment; i++) {
			Date date = contract.getDateContract();

			Calendar cal = Calendar.getInstance();
			cal.setTime(date);
			cal.add(Calendar.MONTH, i);
			date = cal.getTime();
			
			OnlinePaymentService onlinePayment = new Paypal();
					
			Installment installment = new Installment(date, onlinePayment.taxService(parcelValue, i));
			contract.addInstallment(installment);

		}
	}

}
