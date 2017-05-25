public class Knight extends Player
{
  public int heavySlam()
  {
	  int damage = (int)(getLvl() * (Math.random() * 2) * getDefense());
	  
	  return damage;
  }
  
  public int shieldBash()
  {
	  int damage = (int)((getLvl() * .75) * getDefense());
	 
	  return damage;
  }
}
