import java.util.*;

public class Player
{
	private static int maxHealth;
	private static int curHealth;
	private static int maxMana;
	private static int curMana;
	private static int defense;
	private static int magicResistence;
	private static int attack;
	private static int magic;
	private static int dexterity;
	private static int levelUpExp;
	private static int exp;
	private static String name;
	private static int lvl;
	private static int status;
	private static int money;
	private int enemy;
	private String playerClass;
	
	public String getPlayerClass()
	{
		return playerClass;
	}
	
	public void setPlayerClass(String p)
	{
		playerClass = p;
	}


	public int getEnemy()
	{
		return enemy;
	}

	public void setEnemy(int enemy)
	{
		this.enemy = enemy;
	}

	private static ArrayList<Items> inv = new ArrayList<Items>();

	public int getMaxHealth()
	{
		return maxHealth;
	}

	public void setMaxHealth(int maxHealth)
	{
		Player.maxHealth = maxHealth;
	}

	public int getCurHealth()
	{
		return curHealth;
	}

	public void setCurHealth(int curHealth)
	{
		Player.curHealth = curHealth;
	}

	public int getMaxMana()
	{
		return maxMana;
	}

	public void setMaxMana(int maxMana)
	{
		Player.maxMana = maxMana;
	}

	public int getCurMana()
	{
		return curMana;
	}

	public void setCurMana(int curMana)
	{
		Player.curMana = curMana;
	}

	public int getDefense()
	{
		return defense;
	}

	public void setDefense(int defense)
	{
		Player.defense = defense;
	}

	public int getMagicResistence()
	{
		return magicResistence;
	}

	public void setMagicResistence(int magicResistence)
	{
		Player.magicResistence = magicResistence;
	}

	public int getAttack()
	{
		return attack;
	}

	public void setAttack(int attack)
	{
		Player.attack = attack;
	}

	public int getMagic()
	{
		return magic;
	}

	public void setMagic(int magic)
	{
		Player.magic = magic;
	}

	public int getDexterity()
	{
		return dexterity;
	}

	public void setDexterity(int dexterity)
	{
		Player.dexterity = dexterity;
	}

	public int getLevelUpExp()
	{
		return levelUpExp;
	}

	public void setLevelUpExp(int levelUpExp)
	{
		Player.levelUpExp = levelUpExp;
	}

	public int getExp()
	{
		return exp;
	}

	public void setExp(int exp)
	{
		Player.exp = exp;
	}

	public String getName()
	{
		return name;
	}

	public void setName(String name)
	{
		Player.name = name;
	}

	public int getLvl()
	{
		return lvl;
	}

	public void setLvl(int lvl)
	{
		Player.lvl = lvl;
	}

	public int getStatus()
	{
		return status;
	}

	public void setStatus(int status)
	{
		Player.status = status;
	}

	public int getMoney()
	{
		return money;
	}

	public void setMoney(int money)
	{
		Player.money = money;
	}

	public void addItem(Items i)
	{
		inv.add(i);
	}
	
	public Items removeItem(int i)
	{
		return inv.remove(i);
	}
	
	public Items getItem(int i)
	{
		return inv.get(i);
	}
	
	public int getInvSize()
	{
		return inv.size();
	}
}
