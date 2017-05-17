public class Reusables extends Items
{
  public void heal(int hpAdd)
  {
     Player p = new Player();
     if((p.getCurHealth + hpAdd) > p.getMaxHealth)
        p.setCurHealth = p.getMaxHealth;
    else p.setCurHealth += hpAdd;
  }
  
  public void use()
  {
  }
  
  public void damage()
  {
  }

  public void mana()
  {
  }
  
  public void status()
  {
  
  }
  
  
}
