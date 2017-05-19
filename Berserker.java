public class Berserker extends Player
{
	public int powerSlam() 
	{
		int damage = (int)(getLvl() * .95 * getDexterity());
		return damage;
	}

	public int charge()
	{
		int damage = (int)(getLvl() * (Math.random() * 2) * getMagicResistence());
		return damage;
	}

	public int rage()
	{
		int damage = (int)(getLvl() * .55 * 2);
		return damage;
	}
}
