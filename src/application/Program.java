package application;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

import model.entities.Contract;
import model.entities.Installment;
import model.services.InstallmentService;
import model.services.Paypal;

public class Program {

	public static void main(String[] args) {

		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyy");
		Scanner teclado = new Scanner(System.in);

		try {
		System.out.println("Enter contract data");
		System.out.print("Number: ");
		int numberContract = teclado.nextInt();

		System.out.print("Date (dd/mm/yyyy): ");
		teclado.nextLine();
		String dateString = teclado.nextLine();
		Date dateContract = sdf.parse(dateString);

		System.out.print("Contract value: ");

		double totalValue = teclado.nextDouble();

		System.out.print("Enter number of installments: ");
		int plots = teclado.nextInt();

		Contract contract = new Contract(numberContract, dateContract, totalValue);

		InstallmentService installmentService = new InstallmentService(plots, new Paypal());
		installmentService.plotGenerator(contract);

		contract.sumary();
		
		}catch(ParseException e) {
			e.getMessage();
		}

		teclado.close();
	}

}
