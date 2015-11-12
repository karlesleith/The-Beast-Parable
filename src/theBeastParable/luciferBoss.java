package theBeastParable;

import java.util.Random;
import java.util.Scanner;

public class luciferBoss {
	
	public static void main(String[] args) {
	// System objects
	Scanner in = new Scanner(System.in);
	Random rand = new Random();

	// Game Variables
	String[] enemies = { "Zombie", "Skeleton", "Rat", "Raider" };
	int maxEnemieHealth = 200;
	int maxAttackDamage = 70;
	

	// Player Varables
	String playerName = "N/A";
	int playerHealth = 500;
	int playerAttackDamage = 70;
	int numHealingPotion = 3;
	int healingPotionAmount = 33;
	int healingPotionDropChance = 20;// Percentage rate of drop

	boolean running = true;


	GAME:
	while(running) {
		System.out.println("-------------------------------------------");

		int enemyHealth = 500;
		String enemy = "Lucifer";
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
				playerHealth -= damageTaken;

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
			break;
		}//survival message
		else if (playerHealth < 1) {
			break;
			}//death message

		

}
}
}
