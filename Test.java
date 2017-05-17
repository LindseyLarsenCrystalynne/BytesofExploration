public class Test
{
	public static void main(String[] args)
	{
		Player p = new Player();
		Enemies e = new Enemies();
		RPG r = new RPG();
		e.setCurHealth(6);
		p.setAttack(5);
		p.setMaxHealth(10);
		r.mainMenu();
	}
	
}
