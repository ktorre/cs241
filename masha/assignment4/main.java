import java.util.Scanner;

public class main {
    public static void main(String args[]) {
	initiateUI();
    }

    public static void initiateUI() {
	Scanner input = new Scanner( System.in );
	int command = 0;

	while ( command != 1 && command != 2 && command != 3 ) {
	    UIHeader();
	    System.out.println( "\nWhat would you like to do?" );
	    System.out.println( "   (1) Point-to-point Navigation" );
	    System.out.println( "   (2) Find destination" );
	    System.out.println( "   (3) Exit" );
	    System.out.print( ">> " );
	    command = input.nextInt();
	}

	UIHeader();
	switch ( command ) {
	    case 1:
		p2pNav();
		break;
	    case 2:
		findDes();
		break;
	    case 3:
		break;
	}
    }

    public static void p2pNav() {
	Scanner input = new Scanner( System.in );
	String location1;
	String location2;

	System.out.println( "[ Point-to-Point Navigation ]" );
	System.out.print( "Location 1: " );
	location1 = input.nextLine();

	System.out.print( "Location 2: " );
	location2 = input.nextLine();

	System.out.println( location1 + " -> " + location2 );
    }

    public static void findDes() {
	Scanner input = new Scanner( System.in );
	String destination;

	System.out.println( "[ Find Destination ]" );
	System.out.print( "Enter destination: " );
	destination = input.nextLine();

	System.out.println( "Final destination: " + destination );
    }

    public static void UIHeader() {
	clearScreen();
	System.out.print( "City of Los Santos GPS " );
    }

    public static void clearScreen() {
	System.out.print( "\033[2J" );
	System.out.print( "\033[0;0H" );
    }

    public static
}
