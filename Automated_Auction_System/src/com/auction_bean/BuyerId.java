package com.auction_bean;

public class BuyerId {
	private int buyer_id;

	public int getBuyer_id() {
		return buyer_id;
	}

	public void setBuyer_id(int buyer_id) {
		this.buyer_id = buyer_id;
	}

	public BuyerId(int buyer_id) {
		this.buyer_id = buyer_id;
	}

	@Override
	public String toString() {
		return "BuyerId [buyer_id=" + buyer_id + "]";
	}
	
}
