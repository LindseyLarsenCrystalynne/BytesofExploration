import java.util.*;

public class Battle
{
	ArrayList<Enemies> enemyList = new ArrayList<Enemies>();

	int enemy;

	public Battle(int enemyNumber)
	{
		enemy = enemyNumber;
	}

	public void start()
	{
		enemyList.add(new Enemies());
		boolean fight = true;
		System.out.println("⚔=⚔=⚔=⚔=⚔=Fight=⚔=⚔=⚔=⚔=⚔");
		Scanner scan = new Scanner(System.in);
		while (fight) 
		{
			System.out.println("\nWhat would you like to do?\n");
			System.out.println("[Fight] [Defend]");
			System.out.println("[Skill] [Item]");
			System.out.println("     [Run]\n");
			System.out.print("Choose Your Selection: ");
			
			switch (scan.nextLine())
			{
				case "Fight":
			 	{
			 		System.out.println("\nWhich type of attack?\n");;
			 		System.out.println("[Physical] [Magic]\n");
					System.out.print("Choose Your Selection: ");
			 		switch (scan.nextLine())
			 		{
			 			case "Physical":
			 			{
			 				System.out.println(playerAttack(1));
			 				break;
			 			}

			 			case "Magic":
			 			{
			 				System.out.println(playerMAttack(1));
			 				break;
			 			}
			 		}
			 		break;
			 	}

			 	case "Defend":
			 	{
			 		System.out.println("You're defending!");
			 		// playerDefend();
			 		break;
			 	}
			 	
			 	case "Skill":
			 	{
			 		Player p = new Player();
			 		switch(p.getRole())
			 		{
			 		case "Archer":
			 		{
			 			Archer a = new Archer();
			 			System.out.println("\nWhich type of skill?\n");
			 			System.out.println(" [Shatter Arrow] [Sprint]");
			 			System.out.println("[Fire Arrow] [Arrow Storm]");
			 			System.out.println("      [Ice Arrow]");
			 			System.out.print("What is your choice --> ");
			 			switch(scan.nextLine())
			 			{
			 			case "Shatter Arrow":
			 			{
			 				playerSkill(a.shatterArrow(),"Shatter Arrow");
			 			}
			 			}
			 			break;
			 		}

			 		case "Berserker":
			 		{
			 			Berserker b = new Berserker();
			 			System.out.println("\nWhich type of skill?\n");
			 			System.out.println("[Power Slam] [Charge]");
			 			System.out.println(" [Rage] [Blood Lust]");
			 			System.out.print("What is your choice --> ");
			 			switch(scan.nextLine())
			 			{
			 			case "Power Slam":
			 			{
			 				
			 			}
			 			
			 			}
			 			break;
			 		}
			 		
			 		case "Knight":
			 		{
			 			Knight k = new Knight();
			 			System.out.println("\nWhich type of skill?\n");
			 			System.out.println("[Heavy Slam] [Call Horse]");
			 			System.out.println("       [Bulk Up]");
			 			System.out.print("What is your choice --> ");
			 			break;
			 		}
			 		
			 		case "Mage":
			 		{
			 			Mage m = new Mage();
			 			System.out.println("\nWhich type of skill?\n");
			 			System.out.println("[Fire Ball] [Hail]");
			 			System.out.println("[Lightning] [Tsunami]");
			 			System.out.println("[Boulder]");
			 			break;
			 		}
			 		
			 		case "Warrior":
			 		{
			 			Warrior w = new Warrior
			 			System.out.println("\nWhich type of skill?\n");
			 			System.out.println("[Strike] [Strength]");
			 			break;
			 		}
			 		
			 		default:
			 		{
			 			System.out.println("Invalid selection.");
			 			break;
			 		}
			 	}
			 	}
			 	default:
		 		{
		 			System.out.println("Invalid selection.");
		 			break;
		 		}
			}
			enemyTurn();
		}
	}
	
	public String playerSkill(int damage, String skill)
	{
		Player p = new Player();

		int newHP = (int) (enemyList.get(enemy).getCurHealth() - damage);
		enemyList.get(enemy).setCurHealth(newHP);
		return "\nYou attacked the enemy with " + skill + " for " + p.getAttack() + " damage! The enemy now has " + newHP + " health.";
	}

	public String playerAttack(double scale)
	{
		Player p = new Player();

		int newHP = (int) (enemyList.get(enemy).getCurHealth() - (p.getAttack() * scale));
		enemyList.get(enemy).setCurHealth(newHP);
		return "\nYou attacked the enemy for " + p.getAttack() + " damage! The enemy now has " + newHP + " health.";
	}

	public String enemyAttack(double scale)
	{
		Player p = new Player();

		int newHP = (int) (p.getCurHealth() - (enemyList.get(enemy).getAttack() * scale));
		p.setCurHealth(newHP);
		return "\nThe enemy attacked you for " + enemyList.get(enemy).getAttack() + " damage! You now have " + newHP
				+ " health.";
	}

	public String playerMAttack(double scale)
	{
		Player p = new Player();

		int newHP = (int) (enemyList.get(enemy).getCurHealth() - (p.getMagic() * scale));
		enemyList.get(enemy).setCurHealth(newHP);
		return "\nYou attacked the enemy for " + p.getMagic() + " damage! The enemy now has " + newHP + " health.";
	}

	public String enemyMAttack(double scale)
	{
		Player p = new Player();

		int newHP = (int) (p.getCurHealth() - (enemyList.get(enemy).getMagic() * scale));
		p.setCurHealth(newHP);
		return "\nThe enemy attacked you for " + enemyList.get(enemy).getMagic() + " damage! You now have " + newHP
				+ " health.";
	}

	public void enemyTurn()
	{

		Player p = new Player();

		if (p.getMaxHealth() < 30) // if the player has less than 30 maximum
									// health
		{
			if (((double) p.getCurHealth() / p.getMaxHealth()) <= .25) // 
				System.out.println(enemyAttack(1)); // a basic attack will be
													// used
			else if ((((double) Math.random()) * 25) > 24) // else at a 1/25
															// chance the enemy
															// will hit a crit
				System.out.println("It was a critical strike!" + enemyAttack(1.5));
			else
				System.out.println(enemyAttack(1));
		} else if (((double) p.getCurHealth() / p.getMaxHealth()) <= .1)
			System.out.println(enemyAttack(1));
		else if ((((double) Math.random()) * 10) > 8)
			System.out.println("It was a critical strike!" + enemyAttack(1.5));
		else
			System.out.println(enemyAttack(1));
	}
}
