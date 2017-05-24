import java.util.*;
import java.io.*;

public class RPG
{
	public class Items
	{
		private ArrayList list = new ArrayList();
		private int price;

		public int getPrice()
		{
			return price;
		}

		public void setPrice(int price)
		{
			this.price = price;
		}
	}

	public String Name()
	{
		Scanner n = new Scanner(System.in);
		System.out.print("What's your name? Type 'random' for a random name: ");
		String name = n.nextLine();

		String username = "";

		if (name.equalsIgnoreCase("random") || name.equals("")) {
			String likeName = "";

			while (!likeName.equals("y")) {
				String[] randomNames = { "Aaron", "Abbie", "Abby", "Alex", "Amanda", "Amy", "Andy", "Anna", "Annie",
						"Ashley", "Bill", "Bob", "Brandon", "Brittany", "Carl", "Carson", "Casey", "Charlie", "Chase",
						"Chris", "Christa", "Cindy", "Corrine", "Courtney", "Crystal", "Dan", "Daniel", "Danny", "DJ",
						"Earl", "Eduardo", "Emily", "Emma", "Eric", "Eriko", "Frodo", "Gandalf", "Gino", "Grant",
						"Haley", "Harley", "Jack", "Jake", "James", "Jared", "Jessie", "Jillian", "John", "Johnny",
						"Jonathan", "Julie", "Juro", "Justin", "Kane", "Karen", "Kate", "Katie", "Kelly", "Ken",
						"Kennedy", "Kimmiy", "Kimmy", "Kyle", "Lance", "Lauren", "Lillian", "Lily", "Luke", "Mallory",
						"Matt", "Matthew", "Maxwell", "Michael", "Natalie", "Nicholas", "Nicole", "Owen", "Paige",
						"Pam", "Patrick", "Paul", "Phillip", "Quinn", "Rachel", "Raymond", "Richard", "Ronald", "Ryan",
						"Sean", "Stephanie", "Steve", "Tim", "Tyler", "Valarie", "Vincent", "Vivian", "Will", "Xavier",
						"Zachery", "Zack" };

				username = randomNames[(int) (Math.random() * 100)];

				System.out.print("This name has been chosen for you: " + username + " - do you want to use it? (y/n) ");

				likeName = n.nextLine();
			}
		}

		else if (name.equalsIgnoreCase("Lindsey") || name.equalsIgnoreCase("Larsen")
				|| name.equalsIgnoreCase("Crystalynne")) {
			System.out.println("Hmm... I wonder if you're trying to pretend to be one of the developers...");
			;
			username = name;
		}

		else {
			username = name;
		}

		return username;
	}

	public String playerClass()
	{
		Scanner n = new Scanner(System.in);
		System.out.println("What class do you want? Type 'random' for a random class: \n");
		System.out.println("                [Archer] [Beserker]");
		System.out.println("                [Knight] [Mage]");
		System.out.print("Choose Your Selection: ");

		String playerClass = n.nextLine();

		if (playerClass.equalsIgnoreCase("random") || playerClass.equalsIgnoreCase("")
				&& !(playerClass.equalsIgnoreCase("Archer")) && !(playerClass.equalsIgnoreCase("Beserker"))
				&& !(playerClass.equalsIgnoreCase("Knight")) && !(playerClass.equalsIgnoreCase("Mage"))) {
			String likePlayerClass = "";

			while (!likePlayerClass.equals("y")) {
				String[] randomPlayerClasses = { "Archer", "Beserker", "Knight", "Mage" };

				playerClass = randomPlayerClasses[(int) (Math.random() * 4)];

				System.out.print(
						"This class has been chosen for you: " + playerClass + " - do you want to use it? (y/n) ");

				likePlayerClass = n.nextLine();
			}
		}

		return playerClass;
	}

	public void optionsMenu() throws InterruptedException
	{
		Scanner s = new Scanner(System.in);

		System.out.println("=====Options Menu=====\n");
		System.out.println("1. Change Name");
		System.out.println("2. Change Class");
		System.out.println("3. Return to Main Menu\n");
		System.out.print("Choose Your Selection: ");

		Save save = new Save();

		int selection = s.nextInt();

		switch (selection)
		{
		case 1: {
			save.setName(Name());
			break;
		}
		case 2: {
			save.setPlayerClass(playerClass());
			break;
		}
		case 3: {
			mainMenu();
			break;
		}
		case 99: {
			int i = 1;
			while (i < 1000) {
				System.out.println("CONGRATULATIONS! YOU HAVE ENTERED A SECRET MODE!");
				i += 1;
			}
			System.out.println("\n");
			mainMenu();
			break;
		}
		default: {
			System.err.println("Invalid selection.\n");
			mainMenu();
			break;
		}
		}
	}

	public void mainMenu() throws InterruptedException
	{
		Scanner s = new Scanner(System.in);
		
		Save save = new Save();
		
		boolean first = false;
		
		save.Load();
		
		if (first = save.getName().equals(""))
		{
			System.out.println("Looks like this is your first time playing this game! Welcome!");
			save.setName(Name());
			save.setPlayerClass(playerClass());
			save.setAttack(1);
			save.setMagic(1);
			save.setCurHealth(5);
			save.setMaxHealth(5);
			save.setCurMana(0);
			save.setMaxMana(0);
			save.setDefense(0);
			save.setMagicResistance(0);
			save.setDexterity(1);
			save.setLevelUpExp(5);
			save.setMoney(0);
			save.setStatus(0);
			save.FileSave();
			save.setEnemy(0);
		}
		switch (mainMenuSelection())
		{
			case 1:
			{
				if(first)
				{
					Cutscene c = new Cutscene(0);
				}
				Player p = new Player();
				p.setName(save.getName());
				p.setAttack(save.getAttack());
				p.setCurHealth(save.getCurHealth());
				p.setCurMana(save.getCurMana());
				p.setMaxHealth(save.getMaxHealth());
				p.setMaxMana(save.getMaxMana());
				p.setDefense(save.getDefense());
				p.setDexterity(save.getDexterity());
				p.setLevelUpExp(save.getLevelUpExp());
				p.setStatus(save.getStatus());
				p.setMagicResistence(save.getMagicResistance());
				p.setMagic(save.getMagic());
				p.setMoney(save.getMoney());
				Battle b = new Battle(save.getEnemy());
				b.start();
				break;
			}
			case 2:
			{
				Scanner s2 = new Scanner(System.in);
				System.out.println("=====Stats=====");
				System.out.println(save);
				System.out.print("Type in anything to continue: ");
				s2.nextLine();
				System.out.println("\n");
				mainMenu();
				break;
			}
			case 3:
			{
				optionsMenu();
				break;
			}
			case 4:
			{
				break;
			}
			case 5:		
			{		
				Shop shop = new Shop();		
				shop.sh();		
			}
			case 99:
			{
				int i = 1;
				while (i < 1000)
				{
					System.out.println("CONGRATULATIONS! YOU HAVE ENTERED A SECRET MODE!");
					i += 1;
				}
				System.out.println("\n");
				mainMenu();
				break;
			}
			default:
			{
				System.err.println("Invalid selection.\n");
				mainMenu();
				break;
			}
		}
	}

	public int mainMenuSelection() throws InterruptedException
	{
		Scanner s = new Scanner(System.in);
		int selection = 0;
		System.out.println("=====Main Menu=====\n");
		System.out.println("1. Start Game");
		System.out.println("2: Stats");
		System.out.println("3: Options Menu");
		System.out.println("4: Exit");	
		System.out.println("5: Shop\n");
		System.out.print("Choose Your Selection: ");
		try
		{
			selection = s.nextInt();
		}
		catch(InputMismatchException e)
		{
			System.out.println("\nPlease use 1, 2  3, 4 or 5 for your selection.");
			mainMenu();
		}
		return selection;
	}

	public void battleWon(int i, int mHealth, int cHealth, int mMana, int cMana, int def, int mR, int attk, int mag,
			int dex, int lvlUpExp, int xp, String n, int lvl, int status, int money)
	{
		int x = xp;
		int l = lvl;
		int lUpE = lvlUpExp;
		if(xp >= lvlUpExp)
		{
			l = lvl + 1;
			x = (xp -= lvlUpExp);
			lUpE = (lvlUpExp += 3);
			mag += 1;
			attk += 1;
			def += 1;
			cHealth += 2;
			cMana += 2;
			mR += 1;
			mMana += 2;
			mHealth += 2;
			dex += 1;
			
		}
		Save save = new Save();
		save.setMagic(mag);
		save.setAttack(attk);
		save.setDefense(def);
		save.setCurHealth(cHealth);
		save.setCurMana(cMana);
		save.setMagicResistance(mR);
		save.setMaxMana(mMana);
		save.setMaxHealth(mHealth);
		save.setDexterity(dex);
		save.setLevelUpExp(lUpE);
		save.setExp(x);
		save.setName(n);
		save.setLvl(l);
		save.setStatus(status);
		save.setMoney(money);
		save.setEnemy(i);
		save.FileSave();
		save.Load();

	}

}
