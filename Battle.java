import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;
import java.util.concurrent.TimeUnit;

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
		s.Load();
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
		System.out.println("\n\n=====Fight=====");
		Scanner scan = new Scanner(System.in);
		while (fight)
		{
			turn++;
			System.out.println("Enemy Name : " + enemyList.get(enemy).getName());
			System.out.println("Description : " + enemyList.get(enemy).getLore());
			System.out.println("Health :  " + enemyList.get(enemy).getCurHealth() + " / " + enemyMaxHP);
			System.out.println("Mana : " + enemyList.get(enemy).getCurMana() + " / " + enemyMaxMana);
			System.out.println("\n" + p.getName() + "'s Health: " + p.getCurHealth());
			System.out.println("\nWhat would you like to do?\n");
			System.out.println("    [Fight] ");
			System.out.println(" [Skill] [Item]");
			System.out.println("     [Run]\n");
			System.out.print("Choose Your Selection: ");

			switch (scan.nextLine().toUpperCase())
			{
			case "FIGHT":
			{
				TimeUnit.SECONDS.sleep(1);
				System.out.println("\nWhich type of attack?\n");
				;
				System.out.println("[Physical] [Magic]");
				System.out.println("    [1]      [2]\n");
				System.out.print("Choose Your Selection: ");
				switch (scan.nextLine().toUpperCase())
				{
				case "PHYSICAL":
				case "1":
				{
					System.out.println(playerAttack(1));
					TimeUnit.SECONDS.sleep(1);
					enemyTurn();
					break;
				}

				case "MAGIC":
				case "2":
				{
					System.out.println(playerMAttack(1));
					TimeUnit.SECONDS.sleep(1);
					enemyTurn();
					break;
				}

				default:
				{
					System.err.println("Invalid selection.");
					break;
				}
				}
				break;
			}

			case "SKILL":
			{
				switch (s.getPlayerClass().toLowerCase())
				{
				case "archer":
				{
					Archer a = new Archer();
					System.out.println("\nWhich type of skill?\n");
					System.out.println(" 	[Shatter Arrow]");
					System.out.println("[Fire Arrow] [Arrow Storm]");
					System.out.println("      [Ice Arrow]");
					System.out.print("What is your choice --> ");
					switch (scan.nextLine())
					{
					case "shatter arrow":
					{
						System.out.println(playerSkill(a.shatterArrow(), 0, "Shatter Arrow"));
						TimeUnit.SECONDS.sleep(1);
						enemyTurn();
						break;
					}
					case "fire arrow":
					{
						System.out.println(playerSkill(a.fireArrow(), 1, "Fire Arrow"));
						TimeUnit.SECONDS.sleep(1);
						enemyTurn();
						break;
					}
					case "arrow storm":
					{
						System.out.println(playerSkill(a.arrowStorm(), 1, "Arrow Storm"));
						TimeUnit.SECONDS.sleep(1);
						enemyTurn();
						break;
					}
					case "ice arrow":
					{
						System.out.println(playerSkill(a.shatterArrow(), 4, "Ice Arrow"));
						TimeUnit.SECONDS.sleep(1);
						enemyTurn();
						break;
					}
					default:
					{
						System.err.println("Invalid selection.");
						break;
					}
					}
					break;
				}

				case "berserker":
				{
					Berserker b = new Berserker();
					System.out.println("\nWhich type of skill?\n");
					System.out.println("[Power Slam] [Charge]");
					System.out.println("		 [Rage]");
					System.out.print("What is your choice --> ");
					switch (scan.nextLine())
					{
					case "power slam":
					{
						System.out.println(playerSkill(b.powerSlam(), 5, "Power Slam"));
						TimeUnit.SECONDS.sleep(1);
						enemyTurn();
						break;
					}
					case "charge":
					{
						System.out.println(playerSkill(b.charge(), 5, "Power Slam"));
						TimeUnit.SECONDS.sleep(1);
						enemyTurn();
						break;
					}
					case "rage":
					{
						System.out.println(playerSkill(b.rage(), 5, "Rage"));
						TimeUnit.SECONDS.sleep(1);
						enemyTurn();
						break;
					}
					default:
					{
						System.err.println("Invalid selection.\n");
						break;
					}
					}
					break;
				}

				case "knight":
				{
					Knight k = new Knight();
					System.out.println("\nWhich type of skill?\n");
					System.out.println("[Heavy Slam]");
					System.out.println("[Shield Bash]");
					System.out.print("What is your choice --> ");
					switch (scan.nextLine().toLowerCase())
					{
					case "heavy slam":
					{
						System.out.println(playerSkill(k.heavySlam(), 5, "Heavy Slam"));
						TimeUnit.SECONDS.sleep(1);
						enemyTurn();
						break;
					}
					case "shield bash":
					default:
					{
						System.err.println("Invalid selection.\n");
						System.out.println(playerSkill(k.shieldBash(), 5, "Shield Slam"));
						TimeUnit.SECONDS.sleep(1);
						enemyTurn();
						break;
					}
					}
					break;
				}

				case "mage":
				{
					Mage m = new Mage();
					System.out.println("\nWhich type of skill?\n");
					System.out.println("[Fire Ball] [Hail]");
					System.out.println("[Lightning] [Tsunami]");
					System.out.print("What is your choice --> ");
					switch (scan.nextLine())
					{
					case "fire ball":
					{
						System.out.println(playerSkill(m.fireBall(), 1, "Heavy Slam"));
						TimeUnit.SECONDS.sleep(1);
						enemyTurn();
						break;
					}
					case "hail":
					{
						System.out.println(playerSkill(m.hail(), 4, "Hail"));
						TimeUnit.SECONDS.sleep(1);
						enemyTurn();
						break;
					}
					case "lightning":
					{
						System.out.println(playerSkill(m.lightning(), 1, "Lightning"));
						TimeUnit.SECONDS.sleep(1);
						enemyTurn();
						break;
					}
					case "tsunami":
					{
						System.out.println(playerSkill(m.tsunami(), 3, "Tsunami"));
						TimeUnit.SECONDS.sleep(1);
						enemyTurn();
						break;
					}
					default:
					{
						System.err.println("Invalid selection.\n");
						break;
					}
					}
					break;
				}

				default:
				{
					System.out.println("Invalid selection.\n");
					break;
				}
				}

				break;
			}
			case "RUN":
			{
				System.out.println("\nYou ran away!");
				battleEnd();
				break;
			}
			default:
			{
				System.out.println("\nInvalid selection.\n");
				break;
			}
			}
			if (turn == 0)
			{
				p.setAttack(statA);
				p.setDefense(statDef);
				p.setDexterity(statDex);
				p.setMagic(statM);
				p.setMagicResistence(statMR);
			} else if (turn > 0)
				turn--;

			RPG r = new RPG();
			if (p.getCurHealth() == 0)
			{
				p.setAttack(statA);
				p.setDefense(statDef);
				p.setDexterity(statDex);
				p.setMagic(statM);
				p.setMagicResistence(statMR);
				System.out.println("Player was defeated :(");
				TimeUnit.SECONDS.sleep(1);
				System.out.println("You lost half of your coins");
				p.setMoney(p.getMoney() / 2);
				r.mainMenu();
			} else if (enemyList.get(enemy).getCurHealth() == 0)
			{
				p.setAttack(statA);
				p.setDefense(statDef);
				p.setDexterity(statDex);
				p.setMagic(statM);
				p.setMagicResistence(statMR);
				System.out.println("Player won!");
				TimeUnit.SECONDS.sleep(1);
				System.out.println(p.getName() + " earned " + enemyList.get(enemy).getMoney() + " coins and "
						+ enemyList.get(enemy).getExp() + " experience.\n");
				p.setExp(p.getExp() + enemyList.get(enemy).getExp());
				p.setMoney(p.getMoney() + enemyList.get(enemy).getMoney());

				r.battleWon(enemy + 1, p.getMaxHealth(), p.getMaxHealth(), p.getMaxMana(), p.getMaxMana(),
						p.getDefense(), p.getMagicResistence(), p.getAttack(), p.getMagic(), p.getDexterity(),
						p.getLevelUpExp(), p.getExp(), p.getName(), p.getLvl(), p.getStatus(), p.getMoney(),
						p.getPlayerClass());
				r.mainMenu();

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
		System.out.println("Current Health" + enemyList.get(enemy).getCurHealth() + "   " + damage);
		int newHP = (int) (enemyList.get(enemy).getCurHealth() - damage);
		System.out.println("New hp: " + newHP);
		enemyList.get(enemy).setCurHealth(newHP);
		System.out.println("Current Health after" + enemyList.get(enemy).getCurHealth());
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
		// if (status != 0) //We didn't have the time to fully implement
		// statuses
		// output += "You " + st + " the enemy!";
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
						case 1:
							mMana = Integer.parseInt(b.substring(0, end));
							b = b.substring(end + 1);
							end = ifSpace(b);
							assign++;
						case 2:
							def = Integer.parseInt(b.substring(0, end));
							b = b.substring(end + 1);
							end = ifSpace(b);
							assign++;
						case 3:
							mR = Integer.parseInt(b.substring(0, end));
							b = b.substring(end + 1);
							end = ifSpace(b);
							assign++;
						case 4:
							attk = Integer.parseInt(b.substring(0, end));
							b = b.substring(end + 1);
							end = ifSpace(b);
							assign++;
						case 5:
							mag = Integer.parseInt(b.substring(0, end));
							b = b.substring(end + 1);
							end = ifSpace(b);
							assign++;
						case 6:
							dex = Integer.parseInt(b.substring(0, end));
							b = b.substring(end + 1);
							end = ifSpace(b);
							assign++;
						case 7:
							exp = Integer.parseInt(b.substring(0, end));
							b = b.substring(end + 1);
							end = ifSpace(b);
							assign++;
						case 8:
							n = b.substring(0, end);
							b = b.substring(end + 1);
							end = ifSpace(b);
							assign++;
						case 9:
							lvl = Integer.parseInt(b.substring(0, end));
							b = b.substring(end + 1);
							end = ifSpace(b);
							assign++;
						case 10:
							mon = Integer.parseInt(b.substring(0, end));
							b = b.substring(end + 1);
							end = ifSpace(b);
							assign++;
						case 11:
							lore = b.substring(0);
							b = b.substring(end + 1);
							end = ifSpace(b);
							assign++;

						}
					}
					Enemies e = new Enemies(n, mHealth, mMana, def, mR, attk, mag, dex, exp, lvl, mon, lore);
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
