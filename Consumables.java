public class Consumables extends Items
{
	String name;
	int price;
	int heal;
	int damage;
	int mana;

	public Consumables()
	{
		super(null, 0);
	}

	public Consumables(String n, int p, int h, int d, int m)
	{
		super(n, p);
		heal = h;
		damage = d;
		mana = m;
	}

	public int heal()
	{
		int hp = 0;
		Save s = new Save();
		Player p = new Player();
		s.Load();
		

		if ((p.getCurHealth() + heal) > p.getMaxHealth())
		{
			hp = p.getMaxHealth();
		} else
		{
			hp = p.getCurHealth() + heal;
		}
		
		return hp;

	}

	public void use()
	{

	}

	public void damage()
	{

	}

	public int mana()
	{
		int mana = 0;
		Save s = new Save();
		Player p = new Player();
		s.Load();
		

		if ((p.getCurHealth() + heal) > p.getMaxHealth())
		{
			mana = p.getMaxHealth();
		} else
		{
			mana = p.getCurHealth() + heal;
		}
		
		return mana;

	}
	public void status()
	{

	}
}
