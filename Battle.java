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
			System.out.println("Would you like to : Fight -- Defend -- Skill -- Item -- Run");
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
					// playerMAttack();
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
		//need to set which enemy here

		int newHP = e.getCurHealth() - p.getAttack();
		e.setCurHealth(newHP);
		return "\nYou attacked the enemy for " + p.getAttack() + " damage! The enemy now has " + newHP + " health.";
	}
}
