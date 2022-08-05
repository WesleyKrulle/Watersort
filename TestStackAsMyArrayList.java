import java.util.Random;
import java.util.Scanner;

class WaterSort {
	Character top = null;
	// create constants for colors
	static Character red= Character.valueOf('r');
	static Character blue = Character.valueOf('b');
	static Character yellow= Character.valueOf('y');
	static Character green= Character.valueOf('g');
	// Bottles declaration
	
	
	public static void showAll( StackAsMyArrayList bottles[])
	{
		for (int i = 0; i<=4; i++)
		 {
			 System.out.println("Bottle "+ i+ ": " + bottles[i]);
		 }
	}

	public static boolean solved (StackAsMyArrayList bottles[])
	{
		boolean  solve = false;
		Scanner scan = new Scanner(System.in);
		
		while(solve == false)
		{
			System.out.println("Enter bottle you want to pour");
			int bot = scan.nextInt();
			System.out.println("Enter bottle you want to pour into:");
			int poured = scan.nextInt();
			bottles[bot].peek();


			bottles[poured].push(bottles[bot].peek());
			bottles[bot].pop();
			showAll(bottles);
			
			if(bottles[0].checkStackUniForm() == true || bottles[0].getStackSize() == 0) 
			{
				if(bottles[1].checkStackUniForm() == true || bottles[1].getStackSize() == 0)
				{
					if(bottles[2].checkStackUniForm() == true || bottles[2].getStackSize() == 0)
					{
						if(bottles[3].checkStackUniForm() == true || bottles[3].getStackSize() == 0)
						{
							if(bottles[4].checkStackUniForm() == true || bottles[4].getStackSize() == 0)
							{
								solve = true;
				                    System.out.println("Congratulations, level completed!!!");
							}
						}
					}
				}
			}
			
		}
		
		return solve;

	}
	
    public static void main(String args[])
    {
		 StackAsMyArrayList bottles[] = new StackAsMyArrayList[5];
		 
		 bottles[0] = new StackAsMyArrayList<Character>();
		 bottles[1] = new StackAsMyArrayList<Character>();
		 bottles[2] = new StackAsMyArrayList<Character>();
		 bottles[3] = new StackAsMyArrayList<Character>();
		 bottles[4] = new StackAsMyArrayList<Character>();
		 
		 // Fill 4 bottles with specific colors
		 

		 Random rand = new Random();
		 int n = rand.nextInt(3);
		 int iRed = 0;
		 int iBlue = 0;
		 int iGreen = 0;
		 boolean bool = false;


		 while ( bool == false )
		 {
			for (int i = 0; i<3; i++)
			{
				n = rand.nextInt(3) +1;
				//n += 1;

				if (n ==1 && iRed != 4 && bottles[i].getStackSize() != 4)
				{
					bottles[i].push(red);
					iRed ++;
					n = rand.nextInt(3);
				}
				if (n ==2 && iBlue != 4 && bottles[i].getStackSize() != 4)
				{
					bottles[i].push(blue);
					iBlue ++;
					n = rand.nextInt(3);
				}
				if (n ==3 && iGreen != 4 && bottles[i].getStackSize() != 4)
				{
					bottles[i].push(green);
					iGreen ++;
					n = rand.nextInt(3);
				}

				if (iRed ==4 && iBlue ==4 && iGreen == 4)
				{
					bool = true;
				}
			}
			//showAll(bottles);

		 }
		 showAll(bottles); //show all the bottles
		 solved(bottles);


		 
		 

    }
}