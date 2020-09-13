package CISC181.TaxLab.Package1;

import java.util.Scanner;

public class CMain {

	public static void main(String [] args) {
		Scanner input = new Scanner(System.in); //create scanner
		System.out.println("What is your filing status? \n Enter " 
				+ "0 for Single, 1 for Head of Household, 2 for Married filing jointly or qualified widow, and 3 for Married filing separately");
		int status = input.nextInt();
		if(status > 3 || status <0) { //checks to make sure status is in range
			System.out.println("Choose a valid number between 0 and 3");
			status = input.nextInt();
		}
		System.out.println("What is your taxable income?");
		double income = input.nextDouble();
		double taxes = 0; 
		double [] taxRates = {0.10,0.12,0.22,0.24,0.32,0.35,0.37};
		int [] brackets = new int[6];

		//assigns brackets array depending on status
		if(status == 0) {  //single filers, sets ranges for each tax bracket
			int [] temp = {9700,39475,84200,160725,204100,510300};
			brackets = temp.clone();
		}
		if(status == 1) { //head of household, sets ranges for each tax bracket
			int [] temp = {13850,52850,84200,160700,204100,510300};
			brackets = temp.clone();
		}
		if(status == 2) { //married filing jointly or qualified widow
			int [] temp = {19400,78950,168400,321450,408200,612350};
			brackets = temp.clone();
		}
		if(status == 3) { //married filing separately
			int [] temp = {9700,39475,84200,160725,204100,306175};
			brackets = temp.clone();
		}
		//goes from largest to smallest bracket, taxing only the amount in that
		//range and subtracting from income. adds to taxes in each bracket
		if(income > brackets[5]) { //seventh bracket
			taxes += (income-brackets[5]) *  taxRates[6];
			income= brackets[5];}
		if(income > brackets[4]) { //sixth bracket
			taxes += (income-brackets[4]) * taxRates[5];
			income = brackets[4];}
		if(income > brackets[3]) { //fifth bracket
			taxes += (income-brackets[3]) * taxRates[4];
			income = brackets[3];}
		if(income > brackets[2]) { //fourth bracket
			taxes += (income-brackets[2]) * taxRates[3];
			income = brackets[2];}
		if(income > brackets[1]) { //third bracket
			taxes += (income - brackets[1]) * taxRates[2];
			income = brackets[1];}
		if(income > brackets[0]) { //second bracket
			taxes += (income-brackets[0]) * taxRates[1];
			income =  brackets[0];}
		if(income <= brackets[0]) { //if in smallest bracket
			taxes += income * taxRates[0];
			}
			
		System.out.println("Your taxes due are: " + taxes);	
		}
	
}
