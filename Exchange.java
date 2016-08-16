package com.jpm;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;


public class Exchange { 
	public static void main(String[] args) {
		// fill with Sample data from the Global Beverage Corporation Exchange
		ArrayList<exchangeObject> elementsToCalculate = addexchangeObject();

		// create Trades list
		List<tradeObject> operations = new ArrayList<tradeObject>();
		
		String choice = null;
	    Scanner scan = new Scanner(System.in);
	        
	        do {
	        	System.out.println("=======================================\n"
	        			+ "What you want to do: \n"
	        			+ "a - Given a market price as input, calculate the dividend yield and calculate the P/E Ratio \n"	        			
	        			+ "b - Record a trade, with timestamp, quantity of shares, buy or sell indicator and trade price \n"
	        			+ "c - Calculate Volume Weighted Stock Price based on trades in past 15 minutes and \n"
	        			+ "calculate the GBCE All Share Index using the geometric mean of prices for all stocks \n"
	        			+ "q - quit \n");
	            choice = scan.nextLine().toLowerCase();
	            switch (choice) {
	            case "a":{	            	
	            	System.out.println(">> option a: <<");
	            	// add market price
	        		addMarketPrice(elementsToCalculate);
	        		// calculate dividend Yield and P/E ratio 
	        		dividendYieldCalculate(elementsToCalculate);
	        		
	            	};
	            	break;
	            case "b":{
	            	System.out.println(">> option b: <<");
	            	// add new trades	            	
	            	addTrades(operations);
	            	};
	            	break;
	            case "c":{
	            	System.out.println(">> option c: <<");
	            	// get Volume Weighted Stock Price
	            	calculateVolumeWeightedStockPrice(operations);
	            	// get Geometric mean
	            	geometricMean(operations);
	            	};
	            	break;
	            };
	        } while (!choice.equals("q")); 
	        
		
	}

	private static void geometricMean(List<tradeObject> operations) {
		float valueOfMultiP = 1;
		double geometricMean;
		for (tradeObject temp : operations){	
			valueOfMultiP = valueOfMultiP * temp.getTradePrice();
		}
		
		geometricMean = root(valueOfMultiP, operations.size());
		System.out.println(" >> Geometric Mean: " + geometricMean);
		System.out.println(" Press a key");
   	    Scanner in = new Scanner(System.in);
   	    in.nextLine();
	}

	public static double root(float num, int root)
	{
	    return Math.pow(Math.exp (1/root),Math.log(num));
	} 
	
	private static void calculateVolumeWeightedStockPrice(List<tradeObject> operations) {		  
		   float upVolume = 0;
		   float downVolume = 1;
			for (tradeObject temp : operations){				
				Date timestamp2 = new Date();
				int time = (int) (timestamp2.getTime() - temp.getTimestamp().getTime()) ;
	       		

	       		if (time < (60*1000*15)){ //15 min
	       			System.out.println(" >> Found strock from 15 minutes time period \n");
	       			System.out.println(" >> " + temp.getBs() + " " + temp.getQuantity() + " " + temp.getTradePrice() + " " + temp.getTimestamp() + "\n");
	       			upVolume = upVolume + (temp.getTradePrice() * temp.getQuantity());
	       			downVolume = downVolume +  temp.getQuantity();	       			
	       		}else{
	       			System.out.println(" >> No strock to calculate from 15 minutes time period \n");
	       		}
	       		
	       		System.out.println(" >> Volume Weighted Stock Price is: " + (upVolume/downVolume) + "\n");
	       		System.out.println(" Press a key");
	       	    Scanner in = new Scanner(System.in);
	       	    in.nextLine();
			}
		
	}

	private static void addTrades(List<tradeObject> operations) {
		String choice = null;
	    Scanner scan = new Scanner(System.in);
	    
        do {
        	System.out.println("Do you want to enter new trade: \n"
        			+ "y - yes \n"	        			
        			+ "n - no \n"
        			+ "q - quit\n");
            choice = scan.nextLine().toLowerCase();
            switch (choice) {
            case "y":{	            	
            	Scanner dataQuantity = new Scanner(System.in);
            	Scanner dataBs = new Scanner(System.in);
            	Scanner dataTradePrice = new Scanner(System.in).useLocale(Locale.US);
            	
            	System.out.println("== How many?: \n");
       			int quantity = dataQuantity.nextInt();
       			String bs = null;

       				do {
       					System.out.println("== BUY (b) or SELL (s)?: \n");
       					bs = dataBs.nextLine().toLowerCase();
       					System.out.println(">>> " + bs);
       				}while(!bs.equals("b") && !bs.equals("s"));

       	        System.out.println("== Trade Price?: (use '.' dot) \n");
           		float tradePrice = dataTradePrice.nextFloat();
           		System.out.println("== \n");
           		
           		Date timestamp = new Date();
	
           		timestamp.getTime();
            	tradeObject newOperation = new tradeObject();
            	operations.add(newOperation);
            	newOperation.addtrade(timestamp, quantity, bs, tradePrice);
        		
            	
            	};
            	break;
            };
        } while (!choice.equals("q") && !choice.equals("n")); 
        
        
	}


	
	private static void addMarketPrice(ArrayList<exchangeObject> elementsToCalculate) {
		System.out.println(">> addMarketPrice");
		Scanner in = new Scanner(System.in).useLocale(Locale.US);
		double marketPrice;
		for(int i=0; i<elementsToCalculate.size();i++){
			
			System.out.println("Enter a Market Price for " + elementsToCalculate.get(i).getStockSymbol() + " (use '.' (dot))");
			marketPrice = in.nextDouble();			
			System.out.println("> Market Price set to : " + marketPrice);
			elementsToCalculate.get(i).setMarketPrice(marketPrice);
		}
		
	}

	private static ArrayList<exchangeObject> addexchangeObject() {
		exchangeObject TEA = new exchangeObject("TEA", "Common", 0, 100);
		exchangeObject POP = new exchangeObject("POP", "Common", 8, 100);
		exchangeObject ALE = new exchangeObject("ALE", "Common", 23, 60);
		exchangeObject GIN = new exchangeObject("GIN", "Preferred", 8, 0.02 ,100);
		exchangeObject JOE = new exchangeObject("JOE", "Common", 13, 250);
		
		ArrayList<exchangeObject> listOfExchange = new ArrayList<exchangeObject>();
		 listOfExchange.add(TEA);
		 listOfExchange.add(POP);
		 listOfExchange.add(ALE);
		 listOfExchange.add(GIN);
		 listOfExchange.add(JOE); 
		 
		 return listOfExchange;
	}

	private static void dividendYieldCalculate(ArrayList<exchangeObject> elementsToCalculate) {
		System.out.println(">> dividenYieldCalculate");
		double dividend;
		double PEratio;
		for(int i=0; i<elementsToCalculate.size();i++){
			
			if(elementsToCalculate.get(i).getTypeStock().equals("Common")){
				System.out.println("Common");
				dividend = calculateDividend(elementsToCalculate.get(i).getLastDivident(), elementsToCalculate.get(i).getMarketPrice());
				PEratio = calculatePEratio(elementsToCalculate.get(i).getMarketPrice(), dividend);
				System.out.println("For " + elementsToCalculate.get(i).getStockSymbol()
										+ " dividend yield equals: \n"
										+ dividend + "\n" 
										+ "with P/E ratio: \n"
										+ PEratio);
				System.out.println("========");
			}else if(elementsToCalculate.get(i).getTypeStock().equals("Preferred")){
				System.out.println("Preferred");
				dividend = calculateDividend(elementsToCalculate.get(i).getFixedDivident(), elementsToCalculate.get(i).getPerValue(), elementsToCalculate.get(i).getMarketPrice());
				PEratio = calculatePEratio(elementsToCalculate.get(i).getMarketPrice(), dividend);
				System.out.println("For " + elementsToCalculate.get(i).getStockSymbol()
									+ " dividend yield equals: \n"
									+ dividend+ "\n" 
									+ "with P/E ratio: \n"
									+ PEratio);
				System.out.println("========");
			}
			
		}
		
	}

	private static double calculatePEratio(double marketPrice, double dividend) {
		// calculate P/E ratio
		return marketPrice/dividend;
	}

	private static double calculateDividend(int lastDivident, double marketPrice) {
		// calculateDividend for 'Common'
		return lastDivident/marketPrice;
	}

	private static double calculateDividend(double fixedDivident, int perValue, double marketPrice) {	
		// calculateDividend for 'Preferred'
		return (fixedDivident*perValue)/marketPrice;
	}

}
