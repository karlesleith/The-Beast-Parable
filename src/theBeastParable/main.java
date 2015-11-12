package theBeastParable;

import java.util.Random;
import java.util.Scanner;

public class main {
	public static void main(String[] args) {

		// System objects
		Scanner in = new Scanner(System.in);
		Random rand = new Random();

		// Game Variables
		String[] enemies = { "Zombie", "Skeleton", "Rat", "Raider" };
		int maxEnemieHealth = 100;
		int maxAttackDamage = 25;
		int battleCounter=0;

		// Player Varables
		String playerName = "N/A";
		int playerHealth = 100;
		int playerAttackDamage = 30;
		int numHealingPotion = 3;
		int healingPotionAmount = 33;
		int healingPotionDropChance = 20;// Percentage rate of drop

		boolean running = true;

		System.out.println("     The Beast Parable:\nRise\tof\tThe\tLycan");
		System.out.println("-------------------------------------------");

		story.intro();
		playerName = in.nextLine();

		story.startingQuote(playerName);
		
		System.out.println("-------------------------------------------");
		story.chapter1(playerName);

			GAME:
			while(running) {
			System.out.println("-------------------------------------------");

			int enemyHealth = rand.nextInt(maxEnemieHealth);
			String enemy = enemies[rand.nextInt(enemies.length)];
			if (battleCounter >= 5){
				
				enemy = "Demon";
			}
			System.out.println("\t#A wild " + enemy + " appeared! #\n");
			
		

			while (enemyHealth > 0) {
				System.out.println("\tYour HP: " + playerHealth);
				System.out.println("\t" + enemy + "'s HP: " + enemyHealth);
				System.out.println("\n\t#" + playerName + "'s ACTIONS#");
				System.out.println("\t1. Attack");
				System.out.println("\t2. Drink Potion");
				System.out.println("\t3. Run");

				String input = in.nextLine();

				if (input.equals("1")) {
					int damageDealt = rand.nextInt(playerAttackDamage);
					int damageTaken = rand.nextInt(maxAttackDamage);

					enemyHealth -= damageDealt;
					//playerHealth -= damageTaken;

					System.out.println("\t>" + enemy + " took " + damageDealt + " points of damage.");
					System.out
							.println("\t>" + playerName + " took " + damageTaken + " points of damage from backlash.");

					if (playerHealth < 1) {
						break;
					}
				} // If combat option 1

				else if (input.equals("2")) {
					if (numHealingPotion > 0) {
						playerHealth += healingPotionAmount;
						numHealingPotion--;

						System.out.println("\t> You feel refreshed!" + "\n\t> You now have " + playerHealth + " HP. "
								+ "\n\t>You have " + numHealingPotion + " remaining potions.");
					} 
					else {
						System.out.println("You have no potions. Kill enemies for a chance of a potion drop.");
					}
				}//else if combat option 2

				else if (input.equals("3")) {
					System.out.println("\tYou ran away from the " + enemy + "!");
					continue GAME;
				} //else if combat option 3
				
				else {
					System.out.println("\t>Invalid Command");
				}//combat option 4 invalid command
			}

			if (playerHealth > 1) {
				System.out.println("\n\tYou have survived this encounter");
			}//survival message
			else if (playerHealth < 1) {
				System.out.println(
						"\nYou are Dead!\n\nYou have failed this legend, your dead, your friends are dead, your family's dead, and your dog is dead...\nGAME OVER!");
				break;
				}//death message

			System.out.println("-------------------------------------------");
			System.out.println(" # " + enemy + " was defeated # ");
			System.out.println(" # You have " + playerHealth + " HP left # ");
			battleCounter++;
			System.out.println("-------------------------------------------");

			if (rand.nextInt(100) < healingPotionDropChance) {// drop chance with Healing potions																
				numHealingPotion++;
				System.out.println(" The  " + enemy + " dropped a Health Potion ");
			}
			
			if (battleCounter == 3){
				story.chapter2(playerName);
				
			}
			if (battleCounter == 5){
				story.chapter3(playerName);
				lycantropeBoss lycan = new lycantropeBoss();
				lycan.main(args);
				story.chapter3pt2(playerName);
				
				playerHealth = 100;
				battleCounter++;
			
				story.chapter4(playerName);
				
				
				
			}
			
	
			if (battleCounter == 8){
				story.chapter5(playerName);
				luciferBoss lucy = new luciferBoss();
				lucy.main(args);
				story.finale(playerName);
				break;
				
				
	
				
				
			}
			

			System.out.println("-------------------------------------------");
			System.out.println("What would you like to do?");
			System.out.println("1.Venture further onto your adventure");
			System.out.println("2.Abandon Quest");

			String input = in.nextLine();

			while (!input.equals("1") && !input.equals("2")) {
				System.out.println("Invalid command!");
				input = in.nextLine();
			}
			if (input.equals("1")) {
				System.out.println("You continued your quest.");
			} 
			else if (input.equals("2")) {
				System.out.println("You have abandoned your quest.");
				break;
			}
		}
		System.out.println("\n##--------------------------##");
		System.out.println("------Thanks For Playing!-----");
		System.out.println("##--------------------------##");

	}
}
