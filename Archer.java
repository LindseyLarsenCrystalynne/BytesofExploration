public class Archer extends Player
{
	public int shatterArrow()
	{
		int damage = (int) (getLvl() * .75 * getDexterity());

		if (getLvl() == 0)
			damage = 2;

		return damage;
	}

	public int fireArrow()
	{
		int damage = (int) (getLvl() * (Math.random() * 2) * getDexterity());

		if (getLvl() == 0)
			damage = 2;

		return damage;
	}

	public int arrowStorm()
	{
		int damage = (int) (getLvl() * .55 * getDexterity());

		if (getLvl() == 0)
			damage = 2;

		return damage;
	}

	public int iceArrow()
	{
		int damage = (int) (getLvl() * (Math.random() * 1.75) * getDexterity());

		if (getLvl() == 0)
			damage = 2;

		return damage;
	}
}
