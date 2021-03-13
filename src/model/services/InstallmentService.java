package model.services;

import java.util.Calendar;
import java.util.Date;

import model.entities.Contract;
import model.entities.Installment;

public class InstallmentService {

	private Integer numberInstallment;
	
	private OnlinePaymentService onlinePayment;

	
	public InstallmentService(Integer numberInstallment, OnlinePaymentService onlinePayment) {
		this.numberInstallment = numberInstallment;
		this.onlinePayment = onlinePayment;

	}

	public void plotGenerator(Contract contract) {
		double parcelValue = contract.getTotalValue() / numberInstallment;

		for(int i = 1; i <= numberInstallment; i++) {
			Date date = contract.getDateContract();

			Calendar cal = Calendar.getInstance();
			cal.setTime(date);
			cal.add(Calendar.MONTH, i);
			date = cal.getTime();
			
								
			Installment installment = new Installment(date, onlinePayment.taxService(parcelValue, i));
			contract.addInstallment(installment);

		}
	}

}
