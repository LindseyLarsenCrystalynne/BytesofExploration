import java.util.*;

public class Items
{
	int price;
	String name;
	int amount;
	
	public Items(int category, String name, int price, int a, int mR, int ma, int dex, int def) // armor weapon or other. If it isn't armor or a weapon A slot is damage to the enemy  
	{
		switch(category)
		{
		case 0:
		{
			this.name = name;
			this.price = price;
			break;
		}
		case 1:
		{
			this.name = name;
			this.price = price;
			break;
		}
		}
	}
	public String equip(int item)
	{
		
		return "";
	}
	
	public String getName()
	{
		return name;
	}
	
	public void setName(String n)
	{
		name = n;
	}
	public int getPrice()
	{
		return price;
	}
	
	public void setPrice(int p)
	{
		price = p;
	}
	
	public int getAmount()
	{
		return amount;
	}
	
	public void setAmount(int a)
	{
		amount = a;
	}
}
