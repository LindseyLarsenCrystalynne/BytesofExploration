import java.util.*;

public class Battle
{
	public void start()
	{
		boolean fight = true;
		System.out.println("\u001B[31m=====Fight=====");
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
		}
	}

	public String playerAttack()
	{
		Player p = new Player();
		Enemies e = new Enemies();

		int newHP = e.getCurHealth() - p.getAttack();
		e.setCurHealth(newHP);
		return "\nYou attacked the enemy for " + p.getAttack() + " damage! The enemy now has " + newHP + " health.";
	}

	public String enemyAttack()
	{
		Player p = new Player();
		Enemies e = new Enemies();

		int newHP = p.getCurHealth() - e.getAttack();
		p.setCurHealth(newHP);
		return "\nThe enemy attacked you for " + e.getAttack() + " damage! You now have " + newHP + " health.";
	}

	public String playerMAttack()
	{
		Player p = new Player();
		Enemies e = new Enemies();

		int newHP = e.getCurHealth() - p.getMagic();
		e.setCurHealth(newHP);
		return "\nYou attacked the enemy for " + p.getMagic() + " damage! The enemy now has " + newHP + " health.";
	}

	public String enemyMAttack()
	{
		Player p = new Player();
		Enemies e = new Enemies();

		int newHP = p.getCurHealth() - e.getMagic();
		p.setCurHealth(newHP);
		return "\nThe enemy attacked you for " + e.getMagic() + " damage! You now have " + newHP + " health.";
	}

	public void enemyTurn()
	{
		Player p = new Player();

		if (p.getMaxHealth() < 30) {
			if (((double) p.getCurHealth() / p.getMaxHealth()) <= .25)
				enemyAttack();
		} else if ((((double) Math.random()) * 10) > 8) {
			System.out.println("filler for enemy skill");
		} else
			enemyAttack();
	}
}

