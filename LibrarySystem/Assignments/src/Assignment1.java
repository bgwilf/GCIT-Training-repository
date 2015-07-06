package src;
import java.util.Random;
import java.util.Scanner;

/**
 * Assignment1.java
 * @author Gilles W Bassole <gilles_bassole@gcitsolutions.com>
 * created on June 23,2015
 *
 */

public class Assignment1 {

	static Scanner input = new Scanner(System.in);

	public static void main(String[] args) {

		Random randNumb= new Random();
		int xTry=0;
		boolean check = false;
		System.out.println("##################GAME 1########################");
		System.out.println("Welcome to our number guessing game!");
		System.out.println("To play this game enter an integer number.\n");

		do{

			int n =randNumb.nextInt(1000);

			System.out.print  ("Please make a number guess: " );
			int a= input.nextInt();

			if (a >= n - 10 && a <= n + 10 || a == n ){
				System.out.println("Great!! your guess is within 10 numbers plus or minus");
				System.out.println("random number generated was "+ n);				
			}
			else {
				xTry++;
				System.out.println("Try again!! Random number was :" + n);
				System.out.println();
				if(xTry <5)
					check = true;
				else{
					System.out.println("Sorry! Good bye");
					check= false;
				}
			}

		}while(check);

		System.out.println("##################GAME 2########################");
		System.out.println("Lets Play another of game with a friend, maybe.");
		

		boolean flag = true;

		do{
			Scanner in =new Scanner(System.in);
			System.out.println("What is the name of the first player? ");
			String player1= in.nextLine();

			System.out.println("What is the name of the second player? ");
			String player2= in.nextLine();

			while( player1.equalsIgnoreCase(player2) ){
				System.out.print("Both players cannot be named: "+ player1 +". Enter a different name: ");
				player2=in.nextLine();
				System.out.println();
			}

			System.out.println("How many Chips does the initial pile contain?");
			int p1_Chips=0, p2_Chips=0, initChips=0;
			int pileOfChips= in.nextInt();

			while(pileOfChips<=1){
				System.out.print("You have to start with at least 3 Chips. Choose another number: ");
				pileOfChips=in.nextInt();
				System.out.println();
			}

			while( pileOfChips % 2 == 0){
				System.out.print("You have to start with an odd number of chips. Choose another number: ");
				pileOfChips=in.nextInt();
				System.out.println();
			}
			initChips= pileOfChips;
			System.out.println("You enter: "+ pileOfChips);//----->
			
			System.out.println(player1+" has "+ p1_Chips+" chips.");
			System.out.println(player2+" has "+ p2_Chips+" chips.");

			System.out.println("Its your turn, "+player1);
			System.out.println("There are "+ pileOfChips +" chips remaining.");
			System.out.println("You may take any number of chips from 1 to "+ (pileOfChips-1)/2 +".");
			System.out.println("How many will you take, "+ player1+ " ?");
			p1_Chips = in.nextInt();

			while( p1_Chips < 1 ){
				System.out.println("Illegal move: you must take at least 1 chip.");
				System.out.println("How many will you take, "+ player1+ "?");
				p1_Chips = in.nextInt();
			}

			while( p1_Chips > ( pileOfChips - 1 ) / 2 ){
				System.out.println("Illegal Move: you may not take more than "+ (pileOfChips-1)/2 );
				System.out.println("How many will you take, "+ player1+ "?");
				p1_Chips = in.nextInt();
			}

			pileOfChips= pileOfChips - p1_Chips;
			//System.out.println("Chips available:" + pileOfChips);
			

			do{

				while(pileOfChips>0)
					{
					System.out.println(player2+" has "+ p2_Chips+" chips.");
					
				System.out.println(player1+" has "+ p1_Chips+" chips.");

				System.out.println("Its your turn, "+player2);
				System.out.println("There are "+ pileOfChips +" chips remaining.");
				System.out.println("You may take any number of chips from 1 to "+ pileOfChips/2 +".");
				System.out.println("How many will you take, "+ player2+ " ?");
				int chips_P2 = in.nextInt();

				while( chips_P2 < 1 ){
					System.out.println("Illegal move: you must take at least 1 chip.");
					System.out.println("How many will you take, "+ player2+ "?");
					chips_P2 = in.nextInt();
				}
				
				while( chips_P2 >  pileOfChips / 2 && pileOfChips <= 0 ){
					System.out.println("Illegal Move: you may not take more than "+ pileOfChips/2 );
					System.out.println("How many will you take, "+ player2+ "?");
					chips_P2 = in.nextInt();
				}

				p2_Chips = p2_Chips + chips_P2;
				pileOfChips = pileOfChips- chips_P2;
				//System.out.println("Chips available:" + pileOfChips);
				}

				while(pileOfChips > 06){
				System.out.println(player1+" has "+ p1_Chips+" chips.");
				System.out.println(player2+" has "+ p2_Chips+" chips.");

				System.out.println("Its your turn, "+player1);
				System.out.println("There are "+ pileOfChips +" chips remaining.");
				System.out.println("You may take any number of chips from 1 to "+ pileOfChips/2 +".");
				System.out.println("How many will you take, "+ player1+ " ?");
				int chips_P1 = in.nextInt();

				while( chips_P1 < 1 ){
					System.out.println("Illegal move: you must take at least 1 chip.");
					System.out.println("How many will you take, "+ player1+ "?");
					chips_P1 = in.nextInt();
				}

				while( chips_P1 > pileOfChips/ 2 && pileOfChips<=0)
				{		
					System.out.println("Illegal Move: you may not take more than "+ pileOfChips/2 );
					System.out.println("How many will you take, "+ player1+ "?");
					chips_P1 = in.nextInt();
				}
				//System.out.println("Chips available:" + pileOfChips);
				p1_Chips= p1_Chips+ chips_P1;
				pileOfChips = pileOfChips-chips_P1;
				//System.out.println("Chips available:" + pileOfChips);
				}



			}while(initChips > p1_Chips + p2_Chips);
			
			
			System.out.println(player1+ " has "+ p1_Chips+ " chips.");
			System.out.println(player2+ " has "+ p2_Chips+ " chips.");
			if(p1_Chips % 2 ==0 && p2_Chips % 2 !=0){
				System.out.println(player1+ " wins!");
			}else if(p2_Chips % 2 ==0 && p1_Chips % 2 !=0){
				System.out.println(player2+ " wins!");	
			}
			
			System.out.println();
			System.out.print("Play another game? (y/n)");
			Scanner kb= new Scanner(System.in);
			String ans = kb.next();
			
			System.out.println("game replay? :"+ ans);			
			if (ans.equalsIgnoreCase("y")|| ans.equalsIgnoreCase("yes"))
			{
				System.out.println("Great! Lets play this again\n");
			}
			else if(ans.equalsIgnoreCase("n")|| ans.equalsIgnoreCase("no")){
				flag= false;
				System.out.println("Good bye!");
	
			}

		}while(flag);
	
	
	}


}// end class
