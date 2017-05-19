import java.util.*;

public class Battle
{
	ArrayList<Enemies> enemyList = new ArrayList<Enemies>();
	
	Scanner ene = new Scanner(File);
	int enemy;

	public Battle(int enemyNumber)
	{
		enemy = enemyNumber;
	}

	public void start()
	{
		Player p = new Player();
		int statM = p.getMagic();
		int statA = p.getAttack();
		int statDef = p.getDefense();
		int statDex = p.getDexterity();
		int statMR = p.getMagicResistence();
		
		int turn = 0;
		enemyList.add(new Enemies());
		boolean fight = true;
		System.out.println("⚔=⚔=⚔=⚔=⚔=Fight=⚔=⚔=⚔=⚔=⚔");
		Scanner scan = new Scanner(System.in);
		while (fight) 
		{
			turn++;
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
			 				playerSkill(a.shatterArrow(),0,"Shatter Arrow");
			 			}
			 			case "Sprint":
			 			{
			 				turn = 2;
			 				playerSelfSkill("Dexterity",1.5, "Sprint" ,"You run faster for 2 turns!");
			 				
			 			}
			 			case "Fire Arrow":
			 			{
			 				
			 			}
			 			case "Arrow Storm":
			 			{
			 				
			 			}
			 			case "Ice Arrow":
			 			{
			 				
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
			 			case "Charge":
			 			{
			 				
			 			}
			 			case "Rage":
			 			{
			 				
			 			}
			 			case "Blood Lust":
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
			 			switch(scan.nextLine())
			 			{
			 			case "Heavy Slam":
			 			{
			 				
			 			}
			 			case "Call Horse":
			 			{
			 				
			 			}
			 			case "Bulk Up":
			 			{
			 				
			 			}
			 			}
			 			break;
			 		}
			 		
			 		case "Mage":
			 		{
			 			Mage m = new Mage();
			 			System.out.println("\nWhich type of skill?\n");
			 			System.out.println("[Fire Ball] [Hail]");
			 			System.out.println("[Lightning] [Tsunami]");
			 			System.out.println("[Boulder]");
			 			System.out.print("What is your choice --> ");
			 			switch(scan.nextLine())
			 			{
			 			case "Fire Ball":
			 			{
			 				
			 			}
			 			case "Hail":
			 			{
			 				
			 			}
			 			case "Lightning":
			 			{
			 				
			 			}
			 			case "Tsunami":
			 			{
			 				
			 			}
			 			case "Boulder":
			 			{
			 				
			 			}
			 			}
			 			break;
			 		}
			 		
			 		case "Warrior":
			 		{
			 			Warrior w = new Warrior();
			 			System.out.println("\nWhich type of skill?\n");
			 			System.out.println("[Strike] [Strength]");
			 			System.out.print("What is your choice --> ");
			 			switch(scan.nextLine())
			 			{
			 			
			 			}
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
			if(turn == 0)
			{
				p.setAttack(statA);
				p.setDefense(statDef);
				p.setDexterity(statDex);
				p.setMagic(statM);
				p.setMagicResistence(statMR);
			}
			else if(turn > 0)
				turn--;
		}
	}
	
	public String playerSkill(int damage,int status, String skill)
	{
		Player p = new Player();
		String output = "";
		String st;
		int newHP = (int) (enemyList.get(enemy).getCurHealth() - damage);
		enemyList.get(enemy).setCurHealth(newHP);
		
		switch(status) // 0 = normal 1 = burned 2 = poisoned 3 = slowed 4 = frozen
		{
		case 1:
		{
			st = "burned";
		}
		case 2:
		{
			
		}
		case 3:
		{
			
		}
		case 4:
		{
			
		}
		default:
		{
			
		}
		}
		
		output += "\nYou attacked the enemy with " + skill + " for " + p.getAttack() + " damage! The enemy now has " + newHP + " health.";
		if(status != 0)
			output += "You inflicted " + 
	}
	
	public String playerSelfSkill(String stat, double scale, String skill,String message)
	{
		
		Player p = new Player();
		switch(stat)
		{
		case "Dexterity":
		{
			p.setDexterity((int)(p.getDexterity() * scale));
		}
		case "Magic Resistance":
		{
			p.setMagicResistence((int)(p.getMagicResistence() * scale));
		}
		case "Defense":
		{
			p.setDefense((int)(p.getDefense() * scale));
		}
		case "Attack":
		{
			
		}
		case "Magic":
		{
			
		}
		}
		return "\nYou used " + skill + "! " + message;
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
