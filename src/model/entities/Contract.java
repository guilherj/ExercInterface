package model.entities;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Contract {

	private Integer number;
	private Date dateContract;
	private Double totalValue;

	private List<Installment> installments = new ArrayList<>();
	
	SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");

	public Contract() {
	}

	public Contract(Integer number, Date dateContract, Double totalValue) {
		this.number = number;
		this.dateContract = dateContract;
		this.totalValue = totalValue;
	}

	public Integer getNumber() {
		return number;
	}

	public void setNumber(Integer number) {
		this.number = number;
	}

	public Date getDateContract() {
		return dateContract;
	}

	public void setDateContract(Date dateContract) {
		this.dateContract = dateContract;
	}

	public Double getTotalValue() {
		return totalValue;
	}

	public void setTotalValue(Double totalValue) {
		this.totalValue = totalValue;
	}

	public List<Installment> getInstallments() {
		return installments;
	}

	public void addInstallment(Installment installment) {
		installments.add(installment);
	}

	public void removeInstallment(Installment installment) {
		installments.remove(installment);
	}
	
	public void sumary() {
		System.out.println();
		System.out.println(".::SUMARY OF CONTRACT::.");
		System.out.println("Number: " + this.number);
		System.out.println("Total value: " + this.totalValue);
		System.out.println("Date of Contract: " + sdf.format(dateContract));
		
		System.out.println();
		System.out.println(">>Installments<<");
		
		for(Installment i: installments) {
		System.out.println(sdf.format(i.getDueDate()) + " - R$" + i.getValue());
		}
	}


}
