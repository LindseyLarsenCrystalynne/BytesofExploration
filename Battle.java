import java.util.*;

public class Battle
{
	public void start()
	{
		boolean fight = true;
		System.out.println("⚔=⚔=⚔=⚔=⚔=Fight=⚔=⚔=⚔=⚔=⚔");
		Scanner scan = new Scanner(System.in);
		while (fight) 
		{
			System.out.println("\nWould you like to : Fight -- Defend -- Skill -- Item -- Run");
			switch (scan.nextLine())
			{
			case "Fight":
				System.out.println("\nWhich type of attack: Physical -- Magic");
				switch (scan.nextLine())
				{
				case "Physical":
					System.out.println(playerAttack());
					break;

				case "Magic":
					System.out.println(playerMAttack());
					break;
				}
				break;

			case "Defend":
				System.out.println("You're defending!");
				// playerDefend();

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


}

