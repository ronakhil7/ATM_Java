package atm1844;
import java.util.Scanner;

public class ATM1844 {

	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		startMenu();
	}
	
	private static void startMenu() {
		Single sObj = new Single();
		Multi mObj = new Multi();
		
		System.out.println("Welcome to the ATM");
		System.out.println();
		System.out.println("START MENU");
		System.out.println("0 to quit");
		System.out.println("1 to see multi-cardmenu");
		System.out.println("2 to see single-card menu");
		
		Scanner keyboard = new Scanner(System.in);
		int choose = keyboard.nextInt();
		
		switch (choose) {
		case 0:
			System.exit(0);
			break;
		case 1:
			sObj.Menu();
		case 2:
			mObj.Menu();
		}
		
		
	}
	
	private static void accountMenu() {
		System.out.println("ACCOUNT MENU");
		System.out.println("0 to quit");
		System.out.println("1 to access savings account");
		System.out.println("2 to access cheque account");
		System.out.println("3 to change PIN");
	}

	private static void adminMenu() {
		System.out.println("ADMIN MENU");
		System.out.println("0 to quit");
		System.out.println("1 to list all cards");
		System.out.println("2 to find balance of a single card");
		System.out.println("3 to find details of all accounts");
	}
}