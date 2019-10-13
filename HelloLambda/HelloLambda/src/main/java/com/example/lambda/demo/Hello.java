package com.example.lambda.demo;

import java.util.ArrayList;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import com.amazonaws.services.lambda.runtime.Context;
import com.amazonaws.services.lambda.runtime.RequestHandler;

public class Hello implements RequestHandler<Object, String> {

    @Override
    public String handleRequest(Object input, Context context) {
    	context.getLogger().log("Input: " + input);
    	String inputJson = input.toString();    	    
    	String output = "";
    	int nuFights=0;
    	
    	
    	try {
			JSONObject workInput = new JSONObject(inputJson);					
			JSONArray resultsArray = workInput.getJSONArray("results");
			JSONArray OrderArray = workInput.getJSONArray("pokedex");			
			ArrayList<String> results = new ArrayList<String>();
			ArrayList<String> pokedex = new ArrayList<String>();	

			for (int i = 0; i < resultsArray.length(); i++) {
			    String error = resultsArray.getString(i);
			    output = output + " Just Loaded Result " + error + " \n";			    
			    results.add(error);			    			    
			}
			
			for (int i = 0; i < OrderArray.length(); i++) {
			    String error = OrderArray.getString(i);
			    output = output + " Just Loaded pokedex " + error + " \n";
			    pokedex.add(error);			    			    
			}
			
			PalletWar NewTournament = new PalletWar (results,pokedex);
			NewTournament.CalculateFights();
			
			nuFights = NewTournament.GetFightsNumber();
			if (NewTournament.isThereChaos()){
				output = "¡something's wrong! it seems like theres Chaos on the results";
			} else {
				output = "Number of fights: "+nuFights;
			}				
		} catch (JSONException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}      	
    	
    	return output;
    }

}
