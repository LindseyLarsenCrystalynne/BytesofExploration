import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;

public class Shop
{
	String st;
	Consumables[] iList = new Consumables[20];
	Scanner scan = new Scanner(System.in);

	public Shop() throws InterruptedException
	{
		try
		{
			setList();
		} catch (ClassNotFoundException e)
		{
			System.err.println("It didn't load the thing");
		}
		sh();

	}

	public void setList() throws ClassNotFoundException
	{
		try
		{
			File file = new File("ItemList");
			FileReader fileReader = new FileReader(file);
			BufferedReader bufferedReader = new BufferedReader(fileReader);
			String line;

			for (int u = 0; u < 2; u++)
			{
				if ((line = bufferedReader.readLine()) != null)
				{
					String a = line;

					if (a.charAt(0) == '1')
					{
						a = a.substring(2);
						String name = "";
						int price = 0;
						int heal = 0;
						int damage = 0;
						int mana = 0;
						int assign = 0;
						int end = 0;

						end = ifSpace(a);

						while (assign < 5)
						{
							switch (assign)
							{

							case 0:
								name = a.substring(0, end);
								a = a.substring(end + 1);
								end = ifSpace(a);
								assign++;

							case 1:

								price = Integer.parseInt(a.substring(0, end));
								a = a.substring(end + 1);
								end = ifSpace(a);
								assign++;

							case 2:
								heal = Integer.parseInt(a.substring(0, end));
								a = a.substring(end + 1);
								end = ifSpace(a);
								assign++;

							case 3:
								damage = Integer.parseInt(a.substring(0, end));
								a = a.substring(end + 1);
								end = ifSpace(a);
								assign++;

							case 4:
								mana = Integer.parseInt(a.substring(0));
								assign++;

							}
						}

						Consumables c = new Consumables(name, price, heal, damage, mana);
						iList[u] = c;
					}

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

	public void buy() throws InterruptedException
	{
		Player p = new Player();
		int item = 0;
		try
		{
			item = scan.nextInt();
		}

		catch (Exception exc)
		{
			System.err.println("Invalid selection. Please pick again");
			buy();
		}
		if (p.getMoney() >= iList[item].getPrice())
		{
			p.setMoney(p.getMoney() - iList[item].getPrice());
			p.addItem(iList[item]);
			System.out.println("You bought a " + iList[item].getName());
			System.out.println("This is now your current inventory");
			for (int h = 0; h < p.getInvSize(); h++)
			{
				System.out.println(p.getItem(h));
			}
		} else
		{
			System.out.println("You don't have the money for that item!");
		}
		scan.nextLine();
		sh();
	}

	public void sh() throws InterruptedException
	{
		int i = 0;
		int page = 0;
		System.out.println(
				"\nWelcome to the shop! Would you like to buy something?\n		(Buy)\n		  Or Leave\n		  (Leave)");
		System.out.print("Selection: ");
		switch (scan.nextLine().toUpperCase())
		{
		/*
		 * case "SELL": { System.out.println("\nPick an item to sell!");
		 * System.out.println("Name: "); String n = scan.nextLine();
		 * System.out.println("Quantity: "); int q = scan.nextInt(); sell(n, q);
		 * break; } yeah we aren't fitting any more items in the list
		 */
		case "BUY":
		{
			Player p = new Player();
			System.out.println("\n\n		Pick an item to buy!");
			System.out.println("Balanace : " + p.getMoney() + " coins\n");
			while (i != 5 && iList[i] != null)
			{
				System.out.println(iList[i].getName() + " costs " + iList[i].getPrice() + " coins.");
				i++;
			}
			if (page < 3)
				i = 0;

			System.out.print("\nSelection: ");
			buy();
			break;
		}
		case "LEAVE":
		{
			System.out.println();
			RPG menu = new RPG();
			menu.mainMenu();
			break;
		}
		default:
		{
			System.out.println("\nThis isn't a selection.");
			sh();
			break;
		}
		}
	}
}
