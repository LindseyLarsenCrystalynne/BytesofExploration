import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;

public class Battle
{
	ArrayList<Enemies> enemyList = new ArrayList<Enemies>();

	int enemy;

	public Battle(int enemyNumber)
	{
		enemy = enemyNumber;
		try
		{
			setEList();
		} catch (ClassNotFoundException e)
		{
			System.err.println("It didn't work.");
		}
	}

	public void start() throws InterruptedException
	{
		Save s = new Save();
		Player p = new Player();
		int statM = p.getMagic();
		int statA = p.getAttack();
		int statDef = p.getDefense();
		int statDex = p.getDexterity();
		int statMR = p.getMagicResistence();
		int enemyMaxHP = enemyList.get(enemy).getCurHealth();
		int enemyMaxMana = enemyList.get(enemy).getCurMana();
		int turn = 0;
		enemyList.add(new Enemies());
		boolean fight = true;
		System.out.println("=====Fight=====");
		Scanner scan = new Scanner(System.in);
		while (fight) 
		{
			turn++;
			System.out.println("Enemy Name : " + enemyList.get(enemy).getName());
			System.out.println("Health :  " + enemyList.get(enemy).getCurHealth() +" / "+ enemyMaxHP);
			System.out.println("Mana : " + enemyList.get(enemy).getCurMana() +  " / " + enemyMaxMana);
			
			System.out.println("\nWhat would you like to do?\n");
			System.out.println("[Fight] [Defend]");
			System.out.println("[Skill] [Item]");
			System.out.println("     [Run]\n");
			System.out.print("Choose Your Selection: ");
			
			switch (scan.nextLine().toUpperCase())
			{
				case "FIGHT":
			 	{
			 		System.out.println("\nWhich type of attack?\n");;
			 		System.out.println("[Physical] [Magic]\n");
					System.out.print("Choose Your Selection: ");
			 		switch (scan.nextLine().toUpperCase())
			 		{
			 			case "PHYSICAL":
			 			{
			 				System.out.println(playerAttack(1));
			 				break;
			 			}

			 			case "MAGIC":
			 			{
			 				System.out.println(playerMAttack(1));
			 				break;
			 			}
			 		}
			 		break;
			 	}

			 	case "DEFEND":
			 	{
			 		System.out.println("You're defending!");
			 		// playerDefend();
			 		break;
			 	}
			 	
			 	case "SKILL":
			 	{
			 		switch(s.getPlayerClass())
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
					 				playerSelfSkill("Dexterity",1.5,"Sprint","You run faster for 2 turns!");
					 			}
					 			case "Fire Arrow":
					 			{
					 				playerSkill(a.fireArrow(),1,"Fire Arrow");
					 			}
					 			case "Arrow Storm":
					 			{
					 				playerSkill(a.arrowStorm(),1,"Arrow Storm");
					 			}
					 			case "Ice Arrow":
					 			{
					 				playerSkill(a.shatterArrow(),4,"Ice Arrow");
					 			}
			 					default:
			 					{
			 						System.err.println("Invalid selection.");
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
					 				playerSkill(b.powerSlam(),5,"Power Slam");
				 				}
				 				case "Charge":
				 				{
					 				playerSkill(b.charge(),5,"Power Slam");
				 				}
					 			case "Rage":
						 		{
					 				playerSkill(b.rage(),5,"Rage");
					 			}
					 			case "Exercise":
					 			{
					 				turn = 2;
					 				playerSelfSkill("Magic Resistance",1.5,"Exercise","You exercised a bit and now have 2 more turns!");
					 			}
			 					default:
			 					{
			 						System.err.println("Invalid selection.");
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
					 				playerSkill(k.heavySlam(),5,"Heavy Slam");
				 				}
				 				case "Call Horse":
				 				{
					 				turn = 2;
					 				playerSelfSkill("Dexterity",1,"Call Horse","You called a horse! Now you have 2 more turns!");
				 				}
				 				case "Bulk Up":
				 				{
					 				turn = 2;
					 				playerSelfSkill("Defense",2,"Bulk Up","You've bulked up! Have 2 more turns!");
				 				}
			 					default:
			 					{
			 						System.err.println("Invalid selection.");
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
					 				playerSkill(m.fireBall(),1,"Heavy Slam");
				 				}
				 				case "Hail":
				 				{
					 				playerSkill(m.hail(),4,"Hail");
				 				}
				 				case "Lightning":
				 				{
					 				playerSkill(m.lightning(),1,"Lightning");
				 				}
				 				case "Tsunami":
				 				{
					 				playerSkill(m.tsunami(),3,"Tsunami");
				 				}
				 				case "Call Mother Nature":
				 				{
					 				turn = 2;
					 				playerSelfSkill("Magic Resistance",1.5,"Call Mother Nature","You called Mother Nature and she gave you 2 more turns!");
				 				}
				 				default:
				 				{
				 					System.err.println("Invalid selection.");
				 				}
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
			 	case "RUN":
				 		{
				 			System.out.println("\nYou ran away!");
				 			battleEnd();
				 		}
			 	default:
		 		{
		 			System.out.println("\nInvalid selection.");
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
			
			if(p.getCurHealth() == 0)
			{
				p.setAttack(statA);
				p.setDefense(statDef);
				p.setDexterity(statDex);
				p.setMagic(statM);
				p.setMagicResistence(statMR);
				System.out.println("Player was defeated :(");
				System.out.println("You lost half of your coins");
				p.setMoney(p.getMoney()/2);
			}
			else if(enemyList.get(enemy).getCurHealth() == 0)
			{
				p.setAttack(statA);
				p.setDefense(statDef);
				p.setDexterity(statDex);
				p.setMagic(statM);
				p.setMagicResistence(statMR);
				System.out.println("Player won!");
				System.out.println("Player earned " + enemyList.get(enemy).getMoney() + " coins");
				System.out.println("and " + enemyList.get(enemy).getExp() + " experience.");
				p.setExp(p.getExp() +enemyList.get(enemy).getExp());
				p.setMoney(p.getMoney() + enemyList.get(enemy).getMoney());
			}
		}
	}

	private void battleEnd() throws InterruptedException
	{
		RPG r = new RPG();
		r.mainMenu();
	}

	public String playerSkill(int damage, int status, String skill)
	{
		Player p = new Player();
		String output = "";
		String st = "";
		int newHP = (int) (enemyList.get(enemy).getCurHealth() - damage);
		enemyList.get(enemy).setCurHealth(newHP);

		switch (status)
		{
		case 0:
		{
			st = "did nothing";
		}
		case 1:
		{
			st = "burned";
		}
		case 2:
		{
			st = "poisoned";
		}
		case 3:
		{
			st = "slowed";
		}
		case 4:
		{
			st = "froze";
		}
		case 5:
		{
			st = "punched";
		}
		}

		output += "\nYou attacked the enemy with " + skill + " for " + p.getAttack() + " damage! The enemy now has "
				+ newHP + " health.";
		if (status != 0)
			output += "You " + st + " the enemy!";
		return output;
	}

	public String playerSelfSkill(String stat, double scale, String skill, String message)
	{

		Player p = new Player();
		switch (stat)
		{
		case "Dexterity":
		{
			p.setDexterity((int) (p.getDexterity() * scale));
		}
		case "Magic Resistance":
		{
			p.setMagicResistence((int) (p.getMagicResistence() * scale));
		}
		case "Defense":
		{
			p.setDefense((int) (p.getDefense() * scale));
		}
		default:
		{
			System.err.println("Invalid selection.");
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

	public void setEList() throws ClassNotFoundException
	{
		try
		{
			File file = new File("Enemies");
			FileReader fileReader = new FileReader(file);
			BufferedReader bufferedReader = new BufferedReader(fileReader);
			String line;
			for (int i = 0; i < 100; i++) // Runs through the creation process
											// 100 times
			{
				if ((line = bufferedReader.readLine()) != null)
				{
					String b = line;
					int mHealth = 0;
					int mMana = 0;
					int def = 0;
					int mR = 0;
					int attk = 0;
					int mag = 0;
					int dex = 0;
					int exp = 0;
					String n = "";
					int lvl = 0;
					int mon = 0;
					String lore = "";
					int assign = 0;
					int end = 0;

					end = ifSpace(b);

					while (assign < 11)
					{
						switch (assign)
						{
						case 0:
							mHealth = Integer.parseInt(b.substring(0, end));
							b = b.substring(end + 1);
							end = ifSpace(b);
							assign++;
							break;
						case 1:
							mMana = Integer.parseInt(b.substring(0, end));
							b = b.substring(end + 1);
							end = ifSpace(b);
							assign++;
							break;
						case 2:
							def = Integer.parseInt(b.substring(0, end));
							b = b.substring(end + 1);
							end = ifSpace(b);
							assign++;
							break;
						case 3:
							mR = Integer.parseInt(b.substring(0, end));
							b = b.substring(end + 1);
							end = ifSpace(b);
							assign++;
							break;
						case 4:
							attk = Integer.parseInt(b.substring(0, end));
							b = b.substring(end + 1);
							end = ifSpace(b);
							assign++;
							break;
						case 5:
							mag = Integer.parseInt(b.substring(0, end));
							b = b.substring(end + 1);
							end = ifSpace(b);
							assign++;
							break;
						case 6:
							dex = Integer.parseInt(b.substring(0, end));
							b = b.substring(end + 1);
							end = ifSpace(b);
							assign++;
							break;
						case 7:
							exp = Integer.parseInt(b.substring(0, end));
							b = b.substring(end + 1);
							end = ifSpace(b);
							assign++;
							break;
						case 8:
							n = b.substring(0, end);
							b = b.substring(end + 1);
							end = ifSpace(b);
							assign++;
							break;
						case 9:
							lvl = Integer.parseInt(b.substring(0, end));
							b = b.substring(end + 1);
							end = ifSpace(b);
							assign++;
							break;
						case 10:
							mon = Integer.parseInt(b.substring(0, end));
							b = b.substring(end + 1);
							end = ifSpace(b);
							assign++;
							break;
						case 11:
							lore = b.substring(0);
							b = b.substring(end + 1);
							end = ifSpace(b);
							assign++;
							break;

						}
					}
					Enemies e = new Enemies(n, mHealth, mMana, def, mR, attk, mag, dex, exp, lvl, mon,lore);
					enemyList.add(e);
				}

			}
			bufferedReader.close();
		} catch (IOException e)
		{

			System.err.println("It didn't work");
		}
	}

	public int ifSpace(String a)
	{
		int end = 0;
		for (int i = 0; i < a.length(); i++)
		{
			if (a.charAt(i) == ' ')
			{

				end = i;
				break;
			}
		}
		return end;
	}
}
