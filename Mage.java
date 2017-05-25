public class Mage extends Player
{
	public int fireBall()
	{
		int damage = (int) (getLvl() * 1.25 * getMagic());

		if (getLvl() == 0)
			damage = 2;

		return damage;
	}

	public int hail()
	{
		int damage = (int) (getLvl() * (Math.random() * 1.5) * getMagic());

		if (getLvl() == 0)
			damage = 2;

		return damage;
	}

	public int lightning()
	{
		int damage = (int) (getLvl() * (Math.random() * 2) * getMagic());

		if (getLvl() == 0)
			damage = 2;

		return damage;
	}

	public int tsunami()
	{
		int damage = (int) (getLvl() * 1.50 * getMagic());

		if (getLvl() == 0)
			damage = 2;

		return damage;
	}
}
