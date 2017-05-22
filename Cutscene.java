
public class Cutscene
{
	public Cutscene(int whichCutscene)
	{
		switch(whichCutscene)
		{
		case 0: 
			System.out.println("filler");
			Player p = new Player();
			p.setAttack(1);
			p.setCurHealth(5);
			p.setCurMana(0);
			p.setMaxHealth(5);
			p.setMaxMana(0);
			p.setDefense(0);
			p.setDexterity(1);
			p.setLevelUpExp(5);
			p.setStatus(0);
			p.setMagicResistence(0);
			p.setMoney(0);
			break;
		}
	}
}
