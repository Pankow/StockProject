package com.jpm;

import java.util.Date;

class tradeObject {	
	
	private Date timestamp;
	private int quantity;
	private String bs;
	private float tradePrice;
	
	public void addtrade(Date timestamp, int quantity, String bs, float tradePrice){ 
		this.setTimestamp(timestamp);
		this.setQuantity(quantity);
		this.setBs(bs);
		this.setTradePrice(tradePrice);
	}
	
	public tradeObject() {
	}

	public Date getTimestamp() {
		return timestamp;
	}
	public void setTimestamp(Date timestamp) {
		this.timestamp = timestamp;
	}
	public int getQuantity() {
		return quantity;
	}
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	public String getBs() {
		return bs;
	}
	public void setBs(String bs) {
		this.bs = bs;
	}
	public float getTradePrice() {
		return tradePrice;
	}
	public void setTradePrice(float tradePrice) {
		this.tradePrice = tradePrice;
	}
	
	
	
}
