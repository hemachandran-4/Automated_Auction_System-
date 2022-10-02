package com.auction_bean;

public class SellerId {
	private int seller_id;

	public int getSeller_id() {
		return seller_id;
	}

	public void setSeller_id(int seller_id) {
		this.seller_id = seller_id;
	}

	public SellerId(int seller_id) {
		super();
		this.seller_id = seller_id;
	}

	@Override
	public String toString() {
		return "SellerId [seller_id=" + seller_id + "]";
	}
}
