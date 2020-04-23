package com.playsafe.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;
import java.util.Random;
import java.util.Scanner;

import com.playsafe.model.Player;

public class MainRoulette {
	public static void main(String[] args) throws IOException 
	   {
		System.out.println("     =====WELCOME TO PLAYSAFE ROULETTE GAME======");
		Properties prop = PlaySafeCasino.readPropertiesFile("names.properties");
		
		Scanner keyboard = new Scanner(System.in);
	       Random generator = new Random();
	       double total = 500;
	       double amount;
	       int choice, win = 0, lose = 0, spin = 0;
	       int number;
	       int rouletteNum;
	       int result;
	       char response = 'y';
	       int resultArr[] = new int[36];
	       List<Player> player = new ArrayList<Player>();
	       String name = prop.getProperty("name") ;
        String outcome = null;


	     
	       while (response == 'y' || response == 'Y' && total <= 0)
	       {
	           System.out.print("Enter your bet amount: ");
	           amount = keyboard.nextDouble();
	           System.out.print("0 - Even\n1 - Odd\n2 - Number\n");
	           choice = -1;
	           while (choice < 0 || choice > 2)
	           {
	               System.out.print("Place your bet on: ");
	               choice = keyboard.nextInt();
	           }
	           number = 0;
	           if (choice == 2)  
	           {
	               while (number < 1 || number > 36)
	               {
	                   System.out.print("Place your bet on number(1-36): ");
	                   number = keyboard.nextInt();
	               }
	           }
	           rouletteNum = generator.nextInt(37);
	           spin++;
	           System.out.println("Roulette number: " + rouletteNum);
	           
	           if (choice == 2)
	           {
	               if (rouletteNum == number)
	                   result = 35;
	               else
	                   result = 0;
	           }
	           else
	           {
	               if (rouletteNum == 0 || rouletteNum % 2 != choice)
	                   result = 0;
	               else
	                   result = 1;
	           }

	           //Print out game result, win/lose amount
	           if (result > 0)
	           {
	        	   outcome = "WIN";
	               System.out.println("Congratulatons!!! You win!");
	               System.out.printf("You have won R%.2f \n", result * amount);
	               System.out.printf("Here's your money back: R%.2f \n",
	                       (result + 1) * amount);
	               total = (result + 1) * amount + total;
	               win ++;
	               resultArr[rouletteNum]++;
	               
	           }
	           else
	           {
	        	   outcome = "LOSE";
	               System.out.println("You lose. Better luck next time!");
	               System.out.printf("You have lost R%.2f \n",
	                       (result + 1) * amount);
	               total = total - (result + 1) * (amount);
	               lose ++;
	               resultArr[rouletteNum]++;
	               
	               if (total <= 0) {
	            	   break;
	               }

	           }

	           //Ask for another game
	           for (int totals=1; totals<36; totals++) {
	        		if( resultArr[totals] > 0 ) {
	        			System.out.println("The number " + totals + " won " + resultArr[totals] + " times.");
	        		}
	        	}
	           
	           //Accumulate total number of bets  
	           player.add(new Player(name,choice, outcome, win));
	           System.out.println("Number: " + rouletteNum + "       OUTPUT1");
	           System.out.println("-----------------------------------------------------------------------------");
	           System.out.printf("%10s %15s %15s %15s ", "PLAYER", "BET", "OUTCOME","WINNINGS");
	           System.out.println();
	           System.out.println("-----------------------------------------------------------------------------");
	           for(Player players: player){
	               System.out.format("%10s %15s %15s %15d ",
	            		   players.getName(), players.getBet(), players.getOutcone(), players.getWinnings());
	               System.out.println();
	           }
	           System.out.println("-----------------------------------------------------------------------------");
	           
	           System.out.println("You have R" + total + " remaining." );
	           System.out.println("You have won " + win + " games.");
	           System.out.println("You have lost " + lose + " games.");
	           System.out.println("The wheel has been spun " + spin + " times.");          
	           System.out.print("\nWould you like to play another game? (y/n) ");
	           response = keyboard.next().charAt(0);
	   }

}

}
