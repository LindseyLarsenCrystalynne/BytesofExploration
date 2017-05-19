import java.util.*;

public class Shop
{
	Items[]  iList = new Items[20];
	Scanner scan = new Scanner(System.in);
	
	public Shop()
	{
		System.out.println("Welcome to the shop! Would you like to sell or buy?\n		(Sell / Buy)\n		  Or leave");
		sh();
		
	}
	
	public void setList()
	{
		for(int i = 0; i < iList.length;i++)
		{
			iList[i] = Items()
		}
	}
	
	public void buy()
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
		
		if(p.getMoney() >= iList[item].getPrice()) 
		{
			p.setMoney(p.getMoney() - iList[item].getPrice());
			p.addItem(iList[item]);
		}
	}
	
	public void sell(String name, int amount)
	{
		Player p = new Player();
		
		
	}
	
	public void sh()
	{
		int i = 0;
		int page = 0;
		
		System.out.print("Selection: ");
		switch(scan.nextLine())
		{
		case "Sell":
		{
			System.out.println("Pick an item to sell!");
			System.out.println("Name: ");
			String n = scan.nextLine();
			System.out.println("Quantity: ");
			int q = scan.nextInt();
			sell(n,q);
		}
		case "Buy":
		{
			System.out.println("Pick an item to buy! Put the < or > symbol to change pages");
			while(i != 5 && iList[i] != null)
			{
				System.out.println(iList[i].getPrice());
			}
			if(page < 3)
			i = 0;
			
			System.out.print("Selection: ");
			buy();
		}
		default: 
		{
			System.out.println("This isn't a selection.");
			sh();
		}
		}
	}
}
