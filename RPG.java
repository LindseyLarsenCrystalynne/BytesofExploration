import java.util.*;
import java.util.concurrent.TimeUnit;
import java.io.*;

public class RPG
{
  public class Items
  {
  	private ArrayList list = new ArrayList();
    private int price;
    
    public int getPrice()
  	{
    	return price;
    }
    
    public void setPrice(int price)
    {
    	this.price = price;
    }
  }
  
  public String RandomString(String txtfile)
  {
  	Scanner sc = new Scanner(new File(txtfile));
    List<String> lines = new ArrayList<String>();
	
    while (sc.hasNextLine())
    {
      lines.add(sc.nextLine());
    }

    String[] arr = lines.toArray(new String[0]);
      
    int rnd = new Random().nextInt(arr.length-1);
      
    String str = arr[rnd];
    
    return str;
  }

  public String Name()
  {
	 Scanner n = new Scanner(System.in);
 	 System.out.println("What's your name? Type 'random' for a random name: ");
	 String name = n.nextLine();
    
     String username = "";
    
  	 if (name.equalsIgnoreCase("random") || name.equals(""))
  	 {
    	String likeName = "";
    
    	while (!likeName.equals("y"))
    	{
      	username = RandomString("Names.txt");
        
        System.out.print("This name has been chosen for you: " + username + " - do you want to keep it? (y/n) ");
  		
      	likeName = n.nextLine();
      	}
	 }
      
     else
     {
       username = name;
     }
    
     return username;
  }
  
  public void optionsMenu()
  {
  	Scanner s = new Scanner(System.in);;
    
    System.out.println("Options Menu\n");
    System.out.println("1. Change Name");
    System.out.println("2. Format Save Data");
    System.out.println("3. Return to Main Menu");
    System.out.print("Choose Your Selection: ");
    
    int selection = s.nextInt();
    
    switch (selection)
    {
	  case 1:
      {
        Save save = new Save();
        save.setName(Name());
        break;
      }
      case 2:
      {
      	Save save = new Save();
        System.out.print("Are you sure you want to format the save data? Type yes to format. ");
        String delete = s.nextLine();
        if (delete.equalsIgnoreCase("yes"))
        {
        	File f = new File("bytes.sav");
        	f.delete();
        	System.out.println("Save file deleted.");
            TimeUnit.SECONDS.sleep(3);
            Runtime.getRuntime().exec("cls");
        	mainMenu();
        }
        break;
      }
      case 3:
      {
      	mainMenu();
        break;
      }
      default:
      {
      	System.out.println("Invalid selection.");
        TimeUnit.SECONDS.sleep(3);
        Runtime.getRuntime().exec("cls");
        mainMenu();
        break;
      }
    }
  }
  
  public void mainMenu()
  {
  	Scanner s = new Scanner(System.in);
    
    System.out.println("Main Menu\n");
    System.out.println("1. Start Game");
    System.out.println("2: Stats");
    System.out.println("3: Options Menu");
    System.out.println("4: Exit\n");
    System.out.print("Choose Your Selection: ");
    
    int selection = s.nextInt();
    
    switch (selection)
    {
      case 1:
      {
      	Battle b = new Battle();
        b.start();
      	break;
      }
      case 2:
      {
      	Save save = new Save();
      	System.out.println(save);
        System.out.println("Press any key to continue...");
        System.in.read();
      	break;
      }
      case 3:
      {
      	optionsMenu();
        break;
      }
      case 4:
      {
        break;
      }
      default:
      {
      	System.out.println("Invalid selection.");
        TimeUnit.SECONDS.sleep(3);
        Runtime.getRuntime().exec("cls");
        mainMenu();
        break;
      }
  	  break;
    }
  }
  
  public void startBattle()
  {
  	
  }
}
