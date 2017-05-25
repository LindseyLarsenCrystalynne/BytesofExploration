public class Knight extends Player
{
	public int heavySlam()
	{
		int damage = (int) (getLvl() * (Math.random() * 2) * getDefense());

		if (getLvl() == 0)
			damage = 2;

		return damage;
	}

	public int shieldBash()
	{
		int damage = (int) ((getLvl() * .75) * getDefense());

		if (getLvl() == 0)
			damage = 2;

		return damage;
	}
}
