public class Mage extends Player
{
	public int fireBall()
	{
		int damage = (int)(getLvl() * 1.25 * getDexterity());
		return damage;
	}

	public int hail()
	{
		int damage = (int)(getLvl() * (Math.random() * 1.5) * getMagicResistence());
		return damage;
	}

	public int lightning()
	{
		int damage = (int)(getLvl() * (Math.random() * 2) * getMagicResistence());
		return damage;
	}

	public int tsunami()
	{
		int damage = (int)(getLvl() * 1.50 * getDexterity());
		return damage;
	}
}