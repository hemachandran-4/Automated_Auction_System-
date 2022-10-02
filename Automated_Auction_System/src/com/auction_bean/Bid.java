package com.auction_bean;

import java.sql.Date;

public class Bid {
	private int product_id;
	private int buyer_id;
	private Date bid_date;
	private int bid_amount;
	private int price_before_bid;
	private int price_after_bid;
	@Override
	public String toString() {
		return "Bid [product_id=" + product_id + ", buyer_id=" + buyer_id + ", bid_date=" + bid_date + ", bid_amount="
				+ bid_amount + ", price_before_bid=" + price_before_bid + ", price_after_bid=" + price_after_bid + "]";
	}
	public Bid(int product_id, int buyer_id, Date bid_date, int bid_amount, int price_before_bid, int price_after_bid) {
		super();
		this.product_id = product_id;
		this.buyer_id = buyer_id;
		this.bid_date = bid_date;
		this.bid_amount = bid_amount;
		this.price_before_bid = price_before_bid;
		this.price_after_bid = price_after_bid;
	}
	public int getProduct_id() {
		return product_id;
	}
	public void setProduct_id(int product_id) {
		this.product_id = product_id;
	}
	public int getBuyer_id() {
		return buyer_id;
	}
	public void setBuyer_id(int buyer_id) {
		this.buyer_id = buyer_id;
	}
	public Date getBid_date() {
		return bid_date;
	}
	public void setBid_date(Date bid_date) {
		this.bid_date = bid_date;
	}
	public int getBid_amount() {
		return bid_amount;
	}
	public void setBid_amount(int bid_amount) {
		this.bid_amount = bid_amount;
	}
	public int getPrice_before_bid() {
		return price_before_bid;
	}
	public void setPrice_before_bid(int price_before_bid) {
		this.price_before_bid = price_before_bid;
	}
	public int getPrice_after_bid() {
		return price_after_bid;
	}
	public void setPrice_after_bid(int price_after_bid) {
		this.price_after_bid = price_after_bid;
	}
	
}
