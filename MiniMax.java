import java.util.*;

public class MiniMax {
	int Board_Size;
	String You_Play;
	int Depth;
	int [] [] Cell_Value;
	String [] [] Board_State;
	String Opponent;
	MiniMax(int Board,String You_Play,int Depth, int[][] Cell_Value,String [][] Board_State){
		this.Board_Size = Board;
		this.You_Play= You_Play;
		this.Depth = Depth;
		this.Cell_Value = Cell_Value;
		this.Board_State = Board_State;
		if(You_Play.equals("X"))
			Opponent= "O";
		else
			Opponent = "X";
		
	}
	
	
		
	
	
	

	// Start of Actiongen
	public LinkedHashMap<String,LinkedHashMap<Integer,ArrayList<Integer>>> Actiongen (String player , String [][] current_state){
		LinkedHashMap<String,LinkedHashMap<Integer,ArrayList<Integer>>> actions = new LinkedHashMap<String,LinkedHashMap<Integer,ArrayList<Integer>>> ();
		String Opponent = new String();
		if (player.equals("X"))
			Opponent = "O";
		else
			Opponent = "X";
		actions.put("Raid",new LinkedHashMap<Integer,ArrayList<Integer>>() );
		
			for(int i=0 ; i<Board_Size;i++)
			{
				for(int j=0 ; j<Board_Size;j++)
				{
				//	System.out.print(current_state[i][j]);
					if(current_state[i][j].equals("."))
					{
							
							if(!actions.containsKey("Stake"))
							actions.put("Stake", new LinkedHashMap<Integer,ArrayList<Integer>>());
							if(!actions.get("Stake").containsKey(i))
								actions.get("Stake").put(i,new ArrayList<Integer>());
							if(!actions.get("Stake").get(i).contains(j))
							  actions.get("Stake").get(i).add(j);
							
							
							
							
							// Raid 
							// Check if left exist and is occupied with player
							if(j-1 >=0 && current_state[i][j-1].equals(player))
							{
								if(j+1< Board_Size && current_state[i][j+1].equals(Opponent))
								{
									if(!actions.get("Raid").containsKey(i))
										actions.get("Raid").put(i, new ArrayList<Integer>());
									if(!actions.get("Raid").get(i).contains(j))
									actions.get("Raid").get(i).add(j);
								}
								else if (i-1 >=0 && current_state[i-1][j].equals(Opponent) )
								{
									if(!actions.get("Raid").containsKey(i))
										actions.get("Raid").put(i, new ArrayList<Integer>());
									if(!actions.get("Raid").get(i).contains(j))
									actions.get("Raid").get(i).add(j);
								
								}
								else if (i+1<Board_Size && current_state[i+1][j].equals(Opponent))
								{
									if(!actions.get("Raid").containsKey(i))
										actions.get("Raid").put(i, new ArrayList<Integer>());
									if(!actions.get("Raid").get(i).contains(j))
									actions.get("Raid").get(i).add(j);
								}
							}
							
							
							
							if(j+1<Board_Size && current_state[i][j+1].equals(player))
							{
								if(j-1>= 0 && current_state[i][j-1].equals(Opponent))
								{
									if(!actions.get("Raid").containsKey(i))
										actions.get("Raid").put(i, new ArrayList<Integer>());
									if(!actions.get("Raid").get(i).contains(j))
									actions.get("Raid").get(i).add(j);
								}
								else if (i-1 >=0 && current_state[i-1][j].equals(Opponent) )
								{
									if(!actions.get("Raid").containsKey(i))
										actions.get("Raid").put(i, new ArrayList<Integer>());
									if(!actions.get("Raid").get(i).contains(j))
									actions.get("Raid").get(i).add(j);
								
								}
								else if (i+1<Board_Size && current_state[i+1][j].equals(Opponent))
								{
									if(!actions.get("Raid").containsKey(i))
										actions.get("Raid").put(i, new ArrayList<Integer>());
									if(!actions.get("Raid").get(i).contains(j))
									actions.get("Raid").get(i).add(j);
								}
							}
							
							
							if (i-1>=0 && current_state[i-1][j].equals(player))
							{
								if(j-1>= 0 && current_state[i][j-1].equals(Opponent))
								{
									if(!actions.get("Raid").containsKey(i))
										actions.get("Raid").put(i, new ArrayList<Integer>());
									if(!actions.get("Raid").get(i).contains(j))
									actions.get("Raid").get(i).add(j);
								}
								else if (j+1 < Board_Size && current_state[i][j+1].equals(Opponent) )
								{
									if(!actions.get("Raid").containsKey(i))
										actions.get("Raid").put(i, new ArrayList<Integer>());
									if(!actions.get("Raid").get(i).contains(j))
									actions.get("Raid").get(i).add(j);
								
								}
								else if (i+1<Board_Size && current_state[i+1][j].equals(Opponent))
								{
									if(!actions.get("Raid").containsKey(i))
										actions.get("Raid").put(i, new ArrayList<Integer>());
									if(!actions.get("Raid").get(i).contains(j))
									actions.get("Raid").get(i).add(j);
								}
							}
							
							
							if (i+1 < Board_Size && current_state[i+1][j].equals(player) )
							{
								if(j-1>=0 && current_state[i][j-1].equals(Opponent))
								{
									if(!actions.get("Raid").containsKey(i))
										actions.get("Raid").put(i, new ArrayList<Integer>());
									if(!actions.get("Raid").get(i).contains(j))
									actions.get("Raid").get(i).add(j);
								}
								else if (j+1 < Board_Size && current_state[i][j+1].equals(Opponent) )
								{
									if(!actions.get("Raid").containsKey(i))
										actions.get("Raid").put(i, new ArrayList<Integer>());
									if(!actions.get("Raid").get(i).contains(j))
									actions.get("Raid").get(i).add(j);
								
								}
								else if (i-1>=0 && current_state[i-1][j].equals(Opponent))
								{
									if(!actions.get("Raid").containsKey(i))
										actions.get("Raid").put(i, new ArrayList<Integer>());
									if(!actions.get("Raid").get(i).contains(j))
									actions.get("Raid").get(i).add(j);
								}
								
							}
											
							
					}
				}
			//	System.out.print("\n");
			}
		
		return actions;
	}
	//End of Actiongen function
	
	// Start of ApplyAction function which returns the board state
	public String [][] ApplyAction(String player,String type , int row , int column , String [][] current_board) {
		
		String[][] Board_State = new String[Board_Size][Board_Size];
		String Opp;
		if (player.equals("X"))
			Opp = "O";
		else
			Opp = "X";
		for (int i =0 ; i<Board_Size ; i++)
		{
			
			for(int j=0 ; j<Board_Size;j++)
			{
				
				Board_State[i][j] = current_board[i][j];
			}
		}
	//	System.out.print("Row "+row +"Column "+column);
		Board_State[row][column]=player;
		if (type.equals("Raid"))
		{
			if(column-1 >=0 && Board_State[row][column-1].equals(Opp))
				Board_State[row][column-1] = player;
			
			if(column+1 < Board_Size  && Board_State[row][column+1].equals(Opp))
				Board_State[row][column+1] = player;
			
			if(row-1 >= 0  && Board_State[row-1][column].equals(Opp))
				Board_State[row-1][column] = player;
			
			if(row+1 < Board_Size  && Board_State[row+1][column].equals(Opp))
				Board_State[row+1][column] = player;
			
		}
	//	System.out.println("inside appact");
		for (int i =0 ;i <Board_Size;i++)
		{
			for (int j=0;j<Board_Size;j++)
			{
			//	System.out.print(Board_State[i][j]);
				/*if(Board_State[i][j].equals(You_Play))
					you_play_score = you_play_score + Cell_Value[i][j];
				else if (Board_State[i][j].equals(Opponent))
					opponent_score = opponent_score + Cell_Value[i][j];*/
			}
	//		System.out.print("\n");
		}
		return Board_State;
	}
	
	// End of ApplyAction function
	
	//Start of eval function
	public int Eval(String [][] Board_State ){
		
		int you_play_score =0;
		int opponent_score = 0;
		int total_score =0;
		
		for (int i =0 ;i <Board_Size;i++)
		{
			for (int j=0;j<Board_Size;j++)
			{
				//System.out.print(Board_State[i][j]);
				if(Board_State[i][j].equals(You_Play))
					you_play_score = you_play_score + Cell_Value[i][j];
				else if (Board_State[i][j].equals(Opponent))
					opponent_score = opponent_score + Cell_Value[i][j];
			}
		//	System.out.print("\n");
		}
		total_score = you_play_score - opponent_score;
		return total_score;
	}
	//End of eval function
	
	
	public void MINIMAX_DECISION(String [][] Board_State )
	{
		int Max_value =-9999999 ;
		int value;
		String Max_Action="";
		int r_row=-1;
		int r_column=-1;
		LinkedHashMap<String,LinkedHashMap<Integer,ArrayList<Integer>>> actions;
	    actions =Actiongen(You_Play,Board_State);
	 //   System.out.println("Inside +MINIMAX_DECISION "+actions);
	    for(String action : actions.keySet())
	    {
	    	for (int row : actions.get(action).keySet())
	    	{
	    		//value = Min_Value(ApplyAction(You_Play,action,row,actions.get(action).get(row),Board_State));
	    		//for (int values : actions.get(action).get(row).iterator())
	    		int len;
	    		len = actions.get(action).get(row).size();
	    		for (int i=0; i<len;i++)
	    		{
	    			value= Min_Value(ApplyAction(You_Play,action,row,actions.get(action).get(row).get(i),Board_State),Depth-1);
	    		//	System.out.println("row, col : "+ row + "," + actions.get(action).get(row).get(i) + " == " + value );
	    			if (Max_value < value)
	    			{
	    				Max_value = value;
	    				Max_Action = action;
	    				r_row = row;
	    				r_column = actions.get(action).get(row).get(i);
	    			}
	    		}
	    			
	    		
	    			
	    		
	    	}
	    	
	    }
	    System.out.println(Max_Action + " " + r_row +" " + r_column);
	    
	  }
	
	public int MAX_VALUE(String [][]Board_State, int D )
	{
		int v;
		if (TERMINAL_TEST(Board_State,D))
			return Eval(Board_State);
		v = -9999999;
		LinkedHashMap<String,LinkedHashMap<Integer,ArrayList<Integer>>> actions;
		actions = Actiongen (You_Play,Board_State);
		
		for (String action : actions.keySet())
		{
			for (int row : actions.get(action).keySet())
			{
				int len;
				len = actions.get(action).get(row).size();
				for (int i=0;i<len;i++)
					v = Max(v,Min_Value(ApplyAction(You_Play,action,row,actions.get(action).get(row).get(i),Board_State),D-1));
				
			}
		}
		return v;
		
	}
	
	public int Min_Value(String [][]Board_State, int D )
	{
		int v;
		if (TERMINAL_TEST(Board_State,D)){
		//	System.out.println("here");
			return Eval(Board_State);
		}
			
		v = 9999999;
		LinkedHashMap<String,LinkedHashMap<Integer,ArrayList<Integer>>> actions;
		actions = Actiongen (Opponent,Board_State);
		//System.out.println("Inside +MIN_DECISION "+actions);
		for (String action : actions.keySet())
		{
			//System.out.println(action);
			for (int row : actions.get(action).keySet())
			{
			//	System.out.println(actions.get(action));
				int len;
				len = actions.get(action).get(row).size();
			//	System.out.print("Length "+len);
				for (int i=0;i<len;i++)
				{
				//	System.out.println("Column "+actions.get(action).get(row).get(i));
					v = Min(v,MAX_VALUE(ApplyAction(Opponent,action,row,actions.get(action).get(row).get(i),Board_State),D-1));
				}
			}
		}
		return v;
	}
	
	public boolean TERMINAL_TEST(String [][]Board_State, int D){
		
		if (D ==0)
			return true;
		else 
		{
			for (int i =0; i<Board_Size;i++)
			{
				for (int j=0; j< Board_Size;j++)
				{
					if(Board_State[i][j].equals("."))
						return false;
				}
			}
		}
		return true;
	}
	
	public int Max(int a, int b){
		if (a>b)
			return a;
		else
			return b;
	}
	
	public int Min(int a, int b){
		if (a<b)
			return a;
		else
			return b;
	}
}
