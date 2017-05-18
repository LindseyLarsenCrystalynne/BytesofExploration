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

		if (name.equalsIgnoreCase("random") || name.equals(""))
		{
			String likeName = "";

			while (!likeName.equals("y"))
			{
				String[] randomNames = {"Aaron", "Abbie", "Abby", "Alex", "Amanda", "Amy", "Andy", "Anna", "Annie", "Ashley", "Bill", "Bob", "Brandon", "Brittany", "Carl", "Carson", "Casey", "Charlie", "Chase", "Chris", "Christa", "Cindy", "Corrine", "Courtney", "Crystal", "Dan", "Daniel", "Danny", "DJ", "Earl", "Eduardo", "Emily", "Emma", "Eric", "Eriko", "Frodo", "Gandalf", "Gino", "Grant", "Haley", "Harley", "Jack", "Jake", "James", "Jared", "Jessie", "Jillian", "John", "Johnny", "Jonathan", "Julie", "Juro", "Justin", "Kane", "Karen", "Kate", "Katie", "Kelly", "Ken", "Kennedy", "Kimmiy", "Kimmy", "Kyle", "Lance", "Lauren", "Lillian", "Lily", "Luke", "Mallory", "Matt", "Matthew", "Maxwell", "Michael", "Natalie", "Nicholas", "Nicole", "Owen", "Paige", "Pam", "Patrick", "Paul", "Phillip", "Quinn", "Rachel", "Raymond", "Richard", "Ronald", "Ryan", "Sean", "Stephanie", "Steve", "Tim", "Tyler", "Valarie", "Vincent", "Vivian", "Will", "Xavier", "Zachery", "Zack"};
				
				username = randomNames[(int)(Math.random() * 100)];

				System.out.print("This name has been chosen for you: " + username + " - do you want to use it? (y/n) ");

				likeName = n.nextLine();
			}
		}

		else
		{
			username = name;
		}

		return username;
	}
	
	public String playerClass()
	{
		Scanner n = new Scanner(System.in);
		System.out.println("What class do you want? Type 'random' for a random skill: \n");
		System.out.println("                [Archer] [Beserker]");
		System.out.println("                [Knight] [Mage]");
		System.out.println("                     [Warrior]");
		System.out.print("Choose Your Selection: ");
		
		String playerClass = n.nextLine();
		
		if (playerClass.equalsIgnoreCase("random") || playerClass.equals("") || !(playerClass.equals("Archer") || playerClass.equals("Beserker") || playerClass.equals("Knight") || playerClass.equals("Mage") || playerClass.equals("Warrior")))
		{
			String likePlayerClass = "";
			
			while (!likePlayerClass.equals("y"))
			{
				String[] randomPlayerClasses = {"Archer", "Beserker", "Knight", "Mage", "Warrior"};
				
				playerClass = randomPlayerClasses[(int)(Math.random() * 5)];
				
				System.out.print("This class has been chosen for you: " + playerClass + " - do you want to use it? (y/n) ");
				
				likePlayerClass = n.nextLine();
			}
		}
		
		return playerClass;
	}

	public void optionsMenu()
	{
		Scanner s = new Scanner(System.in);;

		System.out.println("=====Options Menu=====\n");
		System.out.println("1. Change Name");
		System.out.println("2. Change Class");
		System.out.println("3. Format Save Data");
		System.out.println("4. Return to Main Menu");
		System.out.print("Choose Your Selection: ");

		int selection = s.nextInt();

		switch (selection)
		{
			case 1:
			{
				Save save = new Save();
				save.setName(Name());
				break;
			}
			case 2:
			{
				Save save = new Save();
				save.setPlayerClass(playerClass());
				break;
			}
			case 3:
			{
				Save save = new Save();
				System.out.print("Are you sure you want to format the save data? Type yes to format. ");
				String delete = s.nextLine();
				if (delete.equalsIgnoreCase("yes"))
				{
					File f = new File("bytes.sav");
					f.delete();
					System.out.println("Save file deleted.");
					// TimeUnit.SECONDS.sleep(3);
					// Runtime.getRuntime().exec("cls");
					mainMenu();
				}
				break;
			}
			case 4:
			{
				mainMenu();
				break;
			}
			default:
			{
				System.out.println("Invalid selection.");
				// TimeUnit.SECONDS.sleep(3);
				// Runtime.getRuntime().exec("cls");
				mainMenu();
				break;
			}
		}
	}

	public void mainMenu()
	{
		Scanner s = new Scanner(System.in);
		
		Save save = new Save();
		
		save.Load();
		
		if (save.getName().equals(""))
		{
			System.out.println("Looks like this is your first time playing this game! Welcome!");
			save.setName(Name());
			save.setPlayerClass(playerClass());
			save.FileSave();
		}

		System.out.println("=====Main Menu=====\n");
		System.out.println("1. Start Game");
		System.out.println("2: Stats");
		System.out.println("3: Options Menu");
		System.out.println("4: Exit\n");
		System.out.print("Choose Your Selection: ");

		int selection = s.nextInt();

		switch (selection)
		{
			case 1:
			{
				Battle b = new Battle(0);
				b.start();
				break;
			}
			case 2:
			{
				System.out.println(save);
				System.out.println("Press any key to continue...");
				// System.in.read();
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
			default:
			{
				System.out.println("Invalid selection.");
				// TimeUnit.SECONDS.sleep(3);
				// Runtime.getRuntime().exec("cls");
				mainMenu();
				break;
			}
		}
	}
}
