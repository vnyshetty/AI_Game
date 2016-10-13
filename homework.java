import java.io.*;
import java.util.*;
public class homework {

	public static void main(String[] args) throws FileNotFoundException {
		// TODO Auto-generated method stub

		File file = new File("input.txt");
		Scanner input = new Scanner(file);
		
	    int Board_Size = Integer.valueOf(input.nextLine());
		String Mode = input.nextLine();
	//	System.out.println("Mode " +Mode);
		String You_Play = input.nextLine();
	//	System.out.println("My Play " +You_Play);
		int Depth = Integer.valueOf(input.nextLine());
	//	System.out.println("Depth " +Depth);
	
		int [] [] Cell_Value = new int [Board_Size][Board_Size];
		for(int i=0 ; i<Board_Size ; i++)
		{
			String token [] = input.nextLine().split(" ");
			for(int j=0 ; j<Board_Size;j++)
			{
				Cell_Value[i][j] = Integer.valueOf(token[j]);
			}
		}
		
		// Display the score of board
	/*	for(int i=0 ; i<Board_Size ; i++)
		{
			
			for(int j=0 ; j<Board_Size;j++)
			{
				System.out.print(Cell_Value[i][j] +" ");
			}
			System.out.println();
		} */
		
		
		
		
		//Capturing the current state
	
		String[][] Board_State = new String[Board_Size][Board_Size];
		for (int i =0 ; i<Board_Size ; i++)
		{
			String state = input.nextLine();
			
			for(int j=0 ; j<Board_Size;j++)
			{
				
				Board_State[i][j] = String.valueOf(state.charAt(j));
			}
		}
		
	
		//Displaying the current state
/*		System.out.println();
		System.out.println("Board State");
		
		for (int i =0 ; i<Board_Size ; i++)
		{
			
			for(int j=0 ; j<Board_Size;j++)
			{
				System.out.print(Board_State[i][j] +" ");
			}
			System.out.println();
		}
		
		*/
	
		
		
		input.close();
		 file = new File ("output.txt");
 		FileOutputStream fos;
 		try {
 			fos = new FileOutputStream(file);
 			PrintStream ps = new PrintStream(fos);
 			System.setOut(ps);
 		} catch (FileNotFoundException e) {
 			// TODO Auto-generated catch block
 			e.printStackTrace();
 		}  
 		
//		LinkedHashMap<String,LinkedHashMap<Integer,ArrayList<Integer>>> actions = new LinkedHashMap<String,LinkedHashMap<Integer,ArrayList<Integer>>> ();
		long ST = System.currentTimeMillis();
	//	MiniMax m = new MiniMax(Board_Size,You_Play,Depth,Cell_Value,Board_State);
	//	m.MINIMAX_DECISION(Board_State);
	//	ALPHA_BETA ab = new ALPHA_BETA(Board_Size,You_Play,Depth,Cell_Value,Board_State);
	//	ab.ALPHA_BETA_SEARCH(Board_State);
		long ET = System.currentTimeMillis();
		double sec = (ET-ST)/1000;
	//	System.out.println(sec);
	
		switch(Mode)
		{
		case "MINIMAX" :
			MiniMax m = new MiniMax(Board_Size,You_Play,Depth,Cell_Value,Board_State);
			m.MINIMAX_DECISION(Board_State);
			break;
		case "ALPHABETA" :
			ALPHA_BETA ab = new ALPHA_BETA(Board_Size,You_Play,Depth,Cell_Value,Board_State);
			ab.ALPHA_BETA_SEARCH(Board_State);
			break;
		}
		
		
		/*actions =	m.Actiongen(You_Play,Board_State);
	System.out.println(actions);
	
	//testing apply action
	String[][] Apply_State = new String[Board_Size][Board_Size];
	Apply_State = m.ApplyAction("X", "Raid", 0, 0, Board_State);
	
	System.out.println();
	System.out.println("Board State");   */
	
/*	for (int i =0 ; i<Board_Size ; i++)
	{
		
		for(int j=0 ; j<Board_Size;j++)
		{
			System.out.print(Apply_State[i][j] +" ");
		}
		System.out.println();
		
	}
	System.out.println("Old");   */
	
	
/*	for (int i =0 ; i<Board_Size ; i++)
	{
		
		for(int j=0 ; j<Board_Size;j++)
		{
			System.out.print(Board_State[i][j] +" ");
		}
		System.out.println();
	} */
	
	// Testing Eval function
/*	
	int score = m.Eval(Cell_Value, "X", Apply_State);
	System.out.println(score);
		
		*/
	}

	 
}
