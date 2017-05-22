import java.io.File;
import java.util.*;

public class Items
{
	int price;
	String name;
	int amount;
	
	public Items(String n, int p) // armor weapon or other. If it isn't armor or a weapon A slot is damage to the enemy  
	{
		name = n;
		price = p;
		
		
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
