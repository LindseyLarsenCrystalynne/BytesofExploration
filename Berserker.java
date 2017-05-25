public class Berserker extends Player
{
	public int powerSlam()
	{
		int damage = (int) (getLvl() * .95 * getAttack());

		if (getLvl() == 0)
			damage = 2;

		return damage;
	}

	public int charge()
	{
		int damage = (int) (getLvl() * (Math.random() * 2) * getAttack());

		if (getLvl() == 0)
			damage = 2;

		return damage;
	}

	public int rage()
	{
		int damage = (int) ((getLvl() * .55) * 2) * getAttack();

		if (getLvl() == 0)
			damage = 2;

		return damage;
	}
}
