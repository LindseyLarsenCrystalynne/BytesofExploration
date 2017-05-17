public class Enemies
{
	private int maxHealth;
	private int curHealth;
	private int maxMana;
	private int curMana;
	private int defense;
	private int magicResistence;
	private int attack;
	private int magic;
	private int dexterity;
	private int exp;
	private String name;
	private int lvl;
	private int money;
	

	
	public Enemies()
	{
		maxHealth = 10;
		curHealth = 10;
		maxMana = 10;
		curMana = 10;
		defense = 4;
		magicResistence = 4;
		attack = 4;
		magic = 4;
		dexterity = 1;
		exp = 5;
		name = "Default";
		lvl = 1;
		money = 3;
	}

	public Enemies(String n, int mHealth, int mMana,int def,int mR,int attk,int mag,int dex,int exp,int lvl,int mon)
	{
		maxHealth = mHealth;
		curHealth = mHealth;
		maxMana = mMana; 
		curMana = mMana;
		defense = def;
		magicResistence = mR; 
		attack = attk;
		magic = mag;
		dexterity = dex;
		this.exp = exp;
		name = n;
		this.lvl = lvl;
		money = mon; 
	}

	public int getMaxHealth()
	{
		return maxHealth;
	}

	public void setMaxHealth(int maxHealth)
	{
		this.maxHealth = maxHealth;
	}

	public int getCurHealth()
	{
		return curHealth;
	}

	public void setCurHealth(int curHealth)
	{
		this.curHealth = curHealth;
	}

	public int getMaxMana()
	{
		return maxMana;
	}

	public void setMaxMana(int maxMana)
	{
		this.maxMana = maxMana;
	}

	public int getCurMana()
	{
		return curMana;
	}

	public void setCurMana(int curMana)
	{
		this.curMana = curMana;
	}

	public int getDefense()
	{
		return defense;
	}

	public void setDefense(int defense)
	{
		this.defense = defense;
	}

	public int getMagicResistence()
	{
		return magicResistence;
	}

	public void setMagicResistence(int magicResistence)
	{
		this.magicResistence = magicResistence;
	}

	public int getAttack()
	{
		return attack;
	}

	public void setAttack(int attack)
	{
		this.attack = attack;
	}

	public int getMagic()
	{
		return magic;
	}

	public void setMagic(int magic)
	{
		this.magic = magic;
	}

	public int getDexterity()
	{
		return dexterity;
	}

	public void setDexterity(int dexterity)
	{
		this.dexterity = dexterity;
	}

	public int getExp()
	{
		return exp;
	}

	public void setExp(int exp)
	{
		this.exp = exp;
	}

	public String getName()
	{
		return name;
	}

	public void setName(String name)
	{
		this.name = name;
	}

	public int getLvl()
	{
		return lvl;
	}

	public void setLvl(int lvl)
	{
		this.lvl = lvl;
	}

	public int getMoney()
	{
		return money;
	}

	public void setMoney(int money)
	{
		this.money = money;
	}
}
