package com.example.lambda.demo;

import java.util.ArrayList;

public class PalletWar {
	
	private ArrayList<String> results = new ArrayList<String>(); 
	private ArrayList<String> realOrder = new ArrayList<String>(); 
	private ArrayList<String> midFight = new ArrayList<String>(); 	
	private ArrayList<String> Fights = new ArrayList<String>(); 	
	private boolean isThereChaos;
	
	public PalletWar ( ArrayList<String> resultInput, ArrayList<String> realOrderInput){
		results = resultInput;
		realOrder = realOrderInput;
	}
	
	public void CalculateFights() {		
		int	resultPosition=0;
		int	OriginalPosition=0;
		int	fightsWon = 0;
		int winnerIndex=0;
		int loserIndex=0;
		String loser="";
		String winner="";
		String sbFight="";
		midFight = realOrder;
		
		for (String result : results)
	    {
			resultPosition = results.indexOf(result);
			OriginalPosition = midFight.indexOf(result);
			fightsWon = OriginalPosition - resultPosition;
		/*	System.out.print(" pokemon "+result);
			System.out.print(" Posición resultado "+resultPosition);
			System.out.print(" Posición original "+OriginalPosition);
			System.out.println(" Peleas "+fightsWon);*/
						
			
			if (fightsWon > 2) {
				isThereChaos = true;
				break;
			}else if (fightsWon > 0) {
				for (int i = 1; i <= fightsWon; i++) {
					loserIndex = OriginalPosition - i ;
					winnerIndex = OriginalPosition - i + 1;
					sbFight = "Winner "+midFight.get(winnerIndex)+" VS Loser "+midFight.get(loserIndex);					
					Fights.add(sbFight);					
					loser = midFight.get(loserIndex);
					winner = midFight.get(winnerIndex);
										
					midFight.set(loserIndex, winner);
					midFight.set(winnerIndex, loser);
				}				
			}
	    }				
	}
	
	public int GetFightsNumber()
	{
		return Fights.size();
	}
	
	public boolean isThereChaos()
	{
		return isThereChaos;		
	}
	
	public String GetFights() {
		String output="";
				
		for (String fight : Fights) {
			output = output + fight + " \n";
		}
		
		if (output.isEmpty()) {			
			output = "there were no fights";			
		}
		
		return output;		
	}	
}



