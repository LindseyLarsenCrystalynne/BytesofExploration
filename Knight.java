public class Knight extends Player
{
  public int heavySlam()
  {
	  int damage = (int)(getLvl() * (Math.random() * 2) * getMagicResistence());
	  return damage;
  }
}
