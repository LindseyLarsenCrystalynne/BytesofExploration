public class Mage extends Player
{
	public int fireBall()
	{
		int damage = (int)(getLvl() * 1.25 * getMagic());
		return damage;
	}

	public int hail()
	{
		int damage = (int)(getLvl() * (Math.random() * 1.5) * getMagic());
		return damage;
	}

	public int lightning()
	{
		int damage = (int)(getLvl() * (Math.random() * 2) * getMagic());
		return damage;
	}

	public int tsunami()
	{
		int damage = (int)(getLvl() * 1.50 * getMagic());
		return damage;
	}
}
