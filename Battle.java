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
			 				System.out.println(playerAttack());
			 				break;
			 			}

			 			case "Magic":
			 			{
			 				System.out.println(playerMAttack());
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
			}
			System.out.println("test");
			enemyTurn();
		}
	}

	public String playerAttack()
	{
		Player p = new Player();

		int newHP = enemyList.get(enemy).getCurHealth() - p.getAttack();
		enemyList.get(enemy).setCurHealth(newHP);
		return "\nYou attacked the enemy for " + p.getAttack() + " damage! The enemy now has " + newHP + " health.";
	}

	public String enemyAttack()
	{
		Player p = new Player();

		int newHP = p.getCurHealth() - enemyList.get(enemy).getAttack();
		p.setCurHealth(newHP);
		return "\nThe enemy attacked you for " + enemyList.get(enemy).getAttack() + " damage! You now have " + newHP + " health.";
	}

	public String playerMAttack()
	{
		Player p = new Player();
		
		int newHP = enemyList.get(enemy).getCurHealth() - p.getMagic();
		enemyList.get(enemy).setCurHealth(newHP);
		return "\nYou attacked the enemy for " + p.getMagic() + " damage! The enemy now has " + newHP + " health.";
	}

	public String enemyMAttack()
	{
		Player p = new Player();

		int newHP = p.getCurHealth() - enemyList.get(enemy).getMagic();
		p.setCurHealth(newHP);
		return "\nThe enemy attacked you for " + enemyList.get(enemy).getMagic() + " damage! You now have " + newHP + " health.";
	}

	public void enemyTurn()
	{
		
		Player p = new Player();
		
		if (p.getMaxHealth() < 30) 
		{
			if (((double) p.getCurHealth() / p.getMaxHealth()) <= .25)
				System.out.println(enemyAttack());
			else if ((((double) Math.random()) * 10) > 8) 
				System.out.println("filler for enemy skill");
			else
				System.out.println(enemyAttack());
		}
		else if(((double) p.getCurHealth() / p.getMaxHealth()) <= .1)
			System.out.println(enemyAttack());
		else if ((((double) Math.random()) * 10) > 8) 
			System.out.println("filler for enemy skill");
		else
			System.out.println(enemyAttack());
	}
}

