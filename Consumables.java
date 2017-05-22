public class Consumables extends Items
{
	String name;
	int price;
	int heal;
	int damage;
	int mana;

  public Consumables(String n, int p, int h, int d, int m)
  {
	  super(n,p);
  }

  public void heal()
  {
	  Player p = new Player();
	  
	  if((p.getCurHealth() + heal) > p.getMaxHealth())
	  {
		  p.setCurHealth(p.getMaxHealth());
	  }
  }
  
  public void use()
  {
	  
  }
  
  public void damage()
  {
	  
	}

  public void mana()
  {
	  Player p = new Player();
	  
	  if((p.getCurMana() + mana) > p.getMaxMana())
	  {
		  p.setCurMana(p.getMaxMana());
	  }
  }
  
  public void status()
  {
  
  }
}
