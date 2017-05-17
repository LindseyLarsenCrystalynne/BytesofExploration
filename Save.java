import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

public class Save
{
	private String name = "";
	private int maxHealth;
	private int curHealth;
	private int maxMana;
	private int curMana;
	private int defense;
	private int magicResistance;
	private int attack;
	private int magic;
	private int dexterity;
	private int levelUpExp;
	private int exp;
	private int lvl;
	private int money;
	private int status;
	private int skill;

	public String getName()
	{
		return name;
	}

	public void setName(String name)
	{
		this.name = name;
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

	public int getMagicResistance()
	{
		return magicResistance;
	}

	public void setMagicResistance(int magicResistance)
	{
		this.magicResistance = magicResistance;
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

	public int getLevelUpExp()
	{
		return levelUpExp;
	}

	public void setLevelUpExp(int levelUpExp)
	{
		this.levelUpExp = levelUpExp;
	}

	public int getExp()
	{
		return exp;
	}

	public void setExp(int exp)
	{
		this.exp = exp;
	}

	public int getLvl()
	{
		return lvl;
	}

	public void setLvl(int lvl)
	{
		this.lvl = lvl;
	}

	public int getStatus()
	{
		return status;
	}

	public void setStatus(int status)
	{
		this.status = status;
	}

	public int getMoney()
	{
		return money;
	}

	public void setMoney(int money)
	{
		this.money = money;
	}

	public int getSkill()
	{
		return skill;
	}

	public void setSkill(int skill)
	{
		this.skill = skill;
	}

	public void FileSave()
	{
		try {
			FileOutputStream saveFile = new FileOutputStream("bytes.sav");

			ObjectOutputStream save = new ObjectOutputStream(saveFile);

			save.writeObject(getName());
			save.writeObject(getMaxHealth());
			save.writeObject(getCurHealth());
			save.writeObject(getMaxMana());
			save.writeObject(getCurMana());
			save.writeObject(getDefense());
			save.writeObject(getMagicResistance());
			save.writeObject(getAttack());
			save.writeObject(getMagic());
			save.writeObject(getDexterity());
			save.writeObject(getLevelUpExp());
			save.writeObject(getExp());
			save.writeObject(getLvl());
			save.writeObject(getStatus());
			save.writeObject(getMagic());
			save.writeObject(getSkill());

			saveFile.close();
		}

		catch (Exception exc) {
			System.out.println("Error saving to the save file.");
		}
	}

	public void Load()
	{
		if (new File("bytes.sav").exists()) {
			try {
				FileInputStream saveFile = new FileInputStream("bytes.sav");

				ObjectInputStream save = new ObjectInputStream(saveFile);

				setName((String) save.readObject());
				setMaxHealth((Integer) save.readObject());
				setCurHealth((Integer) save.readObject());
				setMaxMana((Integer) save.readObject());
				setCurMana((Integer) save.readObject());
				setDefense((Integer) save.readObject());
				setMagicResistance((Integer) save.readObject());
				setAttack((Integer) save.readObject());
				setMagic((Integer) save.readObject());
				setDexterity((Integer) save.readObject());
				setLevelUpExp((Integer) save.readObject());
				setExp((Integer) save.readObject());
				setLvl((Integer) save.readObject());
				setStatus((Integer) save.readObject());
				setMagic((Integer) save.readObject());
				setSkill((Integer) save.readObject());

				saveFile.close();
			}

			catch (Exception exc) {
				System.out.println("Error loading the save file.");
			}
		}
	}

	public String toString()
	{
		String output = "";

		output += "Name: " + getName();
		output += "Max Health: " + getMaxHealth();
		output += "Current Health: " + getCurHealth();
		output += "Max Mana: " + getMaxMana();
		output += "Current Mana: " + getCurMana();
		output += "Defense: " + getDefense();
		output += "Magic Resistance: " + getMagicResistance();
		output += "Attack: " + getAttack();
		output += "Magic: " + getMagic();
		output += "Dexterity: " + getDexterity();
		output += "Level Up Experience: " + getLevelUpExp();
		output += "Experience: " + getExp();
		output += "Level: " + getLvl();
		output += "Status: " + getStatus();
		output += "Magic: " + getMagic();
		output += "Skill: " + getSkill();

		return output;
	}
}