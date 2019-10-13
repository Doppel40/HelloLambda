package com.example.lambda.demo;

import java.util.ArrayList;

public class TestPalletWar {

	public static void main(String[] args) {
		ArrayList<String> results = new ArrayList<String>();
		ArrayList<String> pokedex = new ArrayList<String>();			
		
		results.add("Charmander");		
		results.add("Squirtle");
		results.add("Caterpie");
		results.add("Pidgey");		
		results.add("Bulbasaur");				
		
		pokedex.add("Bulbasaur");
		pokedex.add("Charmander");		
		pokedex.add("Squirtle");
		pokedex.add("Caterpie");
		pokedex.add("Pidgey");		
		
		PalletWar NewTournament = new PalletWar (results,pokedex);
		NewTournament.CalculateFights();
		System.out.println(NewTournament.GetFightsNumber());
		System.out.println(NewTournament.GetFights());				
	}

}
