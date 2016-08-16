package com.jpm;

import java.sql.Timestamp;
import java.util.ArrayList;

class exchangeObject{
	private String stockSymbol;
	private String typeStock;
	private int lastDivident;
	private double fixedDivident; //percantage
	private int perValue;
	private double marketPrice;
	private double tradePrice;
	private int quantity;
	private Timestamp timestamp;
	
	public exchangeObject(String stockSymbol, String typeStock, int lastDivident, double fixedDivident, int perValue){
		this.setStockSymbol(stockSymbol);
		this.setTypeStock(typeStock);
		this.setLastDivident(lastDivident);
		this.setFixedDivident(fixedDivident);
		this.setPerValue(perValue);		
	}

	public exchangeObject(String stockSymbol, String typeStock, int lastDivident, int perValue){
		this.setStockSymbol(stockSymbol);
		this.setTypeStock(typeStock);
		this.setLastDivident(lastDivident);	
		this.setPerValue(perValue);		
	}
	
	public String getStockSymbol() {
		return stockSymbol;
	}

	public void setStockSymbol(String stockSymbol) {
		this.stockSymbol = stockSymbol;
	}

	public String getTypeStock() {
		return typeStock;
	}

	public void setTypeStock(String typeStock) {
		this.typeStock = typeStock;
	}

	public int getLastDivident() {
		return lastDivident;
	}

	public void setLastDivident(int lastDivident) {
		this.lastDivident = lastDivident;
	}

	public double getFixedDivident() {
		return fixedDivident;
	}

	public void setFixedDivident(double fixedDivident) {
		this.fixedDivident = fixedDivident;
	}

	public int getPerValue() {
		return perValue;
	}

	public void setPerValue(int perValue) {
		this.perValue = perValue;
	}

	public double getMarketPrice() {
		return marketPrice;
	}

	public void setMarketPrice(double marketPrice) {
		this.marketPrice = marketPrice;
	}

	public double getTradePrice() {
		return tradePrice;
	}

	public void setTradePrice(double tradePrice) {
		this.tradePrice = tradePrice;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public Timestamp getTimestamp() {
		return timestamp;
	}

	public void setTimestamp(Timestamp timestamp) {
		this.timestamp = timestamp;
	}
	
} 
