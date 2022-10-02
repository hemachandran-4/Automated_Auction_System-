package com.auction_bean;

import java.sql.Date;

public class Product {
	private String product_name;
	private int seller_id;
	private int product_price;
	private boolean disputed;
	private Date product_added_date;
	private Date product_last_date;
	private boolean availability;
	private int min_bid_amount;
	private boolean sold;
	private int buyer_id;
	
	
	public Product(String product_name, int seller_id, int product_price, boolean disputed, Date product_added_date,
			Date product_last_date, boolean availability, int min_bid_amount, boolean sold, int buyer_id) {
		super();
		this.product_name = product_name;
		this.seller_id = seller_id;
		this.product_price = product_price;
		this.disputed = disputed;
		this.product_added_date = product_added_date;
		this.product_last_date = product_last_date;
		this.availability = availability;
		this.min_bid_amount = min_bid_amount;
		this.sold = sold;
		this.buyer_id = buyer_id;
	}
	@Override
	public String toString() {
		return "Product [product_name=" + product_name + ", seller_id=" + seller_id + ", product_price=" + product_price
				+ ", disputed=" + disputed + ", product_added_date=" + product_added_date + ", product_last_date="
				+ product_last_date + ", availability=" + availability + ", min_bid_amount=" + min_bid_amount
				+ ", sold=" + sold + ", buyer_id=" + buyer_id + "]";
	}
	public int getSeller_id() {
		return seller_id;
	}
	public void setSeller_id(int seller_id) {
		this.seller_id = seller_id;
	}
	public String getProduct_name() {
		return product_name;
	}
	public void setProduct_name(String product_name) {
		this.product_name = product_name;
	}
	public int getProduct_price() {
		return product_price;
	}
	public void setProduct_price(int product_price) {
		this.product_price = product_price;
	}
	public boolean isDisputed() {
		return disputed;
	}
	public void setDisputed(boolean disputed) {
		this.disputed = disputed;
	}
	public Date getProduct_added_date() {
		return product_added_date;
	}
	public void setProduct_added_date(Date product_added_date) {
		this.product_added_date = product_added_date;
	}
	public Date getProduct_last_date() {
		return product_last_date;
	}
	public void setProduct_last_date(Date product_last_date) {
		this.product_last_date = product_last_date;
	}
	public boolean isAvailability() {
		return availability;
	}
	public void setAvailability(boolean availability) {
		this.availability = availability;
	}
	public int getMin_bid_amount() {
		return min_bid_amount;
	}
	public void setMin_bid_amount(int min_bid_amount) {
		this.min_bid_amount = min_bid_amount;
	}
	public boolean isSold() {
		return sold;
	}
	public void setSold(boolean sold) {
		this.sold = sold;
	}
	public int getBuyer_id() {
		return buyer_id;
	}
	public void setBuyer_id(int buyer_id) {
		this.buyer_id = buyer_id;
	}
}
