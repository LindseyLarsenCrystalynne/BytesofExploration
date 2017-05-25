import java.util.concurrent.TimeUnit;

public class Cutscene
{
	public Cutscene(int whichCutscene) throws InterruptedException
	{
		switch (whichCutscene)
		{
		case 0:
			CutsceneZero();
			break;
		case 1:

		}
	}

	public void CutsceneZero() throws InterruptedException
	{
		String dia0 = "You \"wake up\" dazed and confused to where you currently were.\n";
		String dia1 = "Looking around it was just... pure black.";
		String dia2 = "\nSquinting your eyes you tried to make out anything in the darkness.";
		String dia3 = "\nNothing.";
		String dia4 = "\nYou decide to try and backtrack through the memories of how you ended up here.";
		String dia5 = "\nAlso a lot of nothing.";
		String dia6 = "\nContemplating your actions you narrowly missed a voice coming from...inside your head?";
		String dia7 = "\n\"Finally! I found you!\" The voice seemed to resonate from inside your head";
		String dia8 = "\n\"Don't worry about the missing memories you agreed to do this before hand\"";
		String dia9 = "\n\"The word 'this' was disconcerting to say the least\" was the last thing you thought before..";
		String dia10 = "\neverything...";
		String dia11 = "\nfaded....\n";

		System.out.println(dia0);
		TimeUnit.SECONDS.sleep(4);
		System.out.println(dia1);
		TimeUnit.SECONDS.sleep(4);
		System.out.println(dia2);
		TimeUnit.SECONDS.sleep(4);
		System.out.println(dia3);
		TimeUnit.SECONDS.sleep(2);
		System.out.println(dia4);
		TimeUnit.SECONDS.sleep(4);
		System.out.println(dia5);
		TimeUnit.SECONDS.sleep(2);
		System.out.println(dia6);
		TimeUnit.SECONDS.sleep(4);
		System.out.println(dia7);
		TimeUnit.SECONDS.sleep(4);
		System.out.println(dia8);
		TimeUnit.SECONDS.sleep(4);
		System.out.println(dia9);
		TimeUnit.SECONDS.sleep(5);
		System.out.println(dia10);
		TimeUnit.SECONDS.sleep(1);
		System.out.println(dia11);
		TimeUnit.SECONDS.sleep(1);

		Player p = new Player();
		p.setAttack(1);
		p.setMagic(1);
		p.setCurHealth(5);
		p.setMaxHealth(5);
		p.setCurMana(0);
		p.setMaxMana(0);
		p.setDefense(0);
		p.setMagicResistence(0);
		p.setDexterity(1);
		p.setLevelUpExp(5);
		p.setMoney(0);
		p.setStatus(0);

	}
}
