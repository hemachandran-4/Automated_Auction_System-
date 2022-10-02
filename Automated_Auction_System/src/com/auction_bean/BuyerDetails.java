package com.auction_bean;

import java.sql.Date;

public class BuyerDetails {
	private int buyer_id;
	private String buyer_name;
	private String buyer_email;
	private String buyer_password;
	private Date buyer_signup_date;
	public int getBuyer_id() {
		return buyer_id;
	}
	@Override
	public String toString() {
		return "BuyerDetails [buyer_id=" + buyer_id + ", buyer_name=" + buyer_name + ", buyer_email=" + buyer_email
				+ ", buyer_password=" + buyer_password + ", buyer_signup_date=" + buyer_signup_date + "]";
	}
	public BuyerDetails(int buyer_id, String buyer_name, String buyer_email, String buyer_password,
			Date buyer_signup_date) {
		super();
		this.buyer_id = buyer_id;
		this.buyer_name = buyer_name;
		this.buyer_email = buyer_email;
		this.buyer_password = buyer_password;
		this.buyer_signup_date = buyer_signup_date;
	}
	public void setBuyer_id(int buyer_id) {
		this.buyer_id = buyer_id;
	}
	public String getBuyer_name() {
		return buyer_name;
	}
	public void setBuyer_name(String buyer_name) {
		this.buyer_name = buyer_name;
	}
	public String getBuyer_email() {
		return buyer_email;
	}
	public void setBuyer_email(String buyer_email) {
		this.buyer_email = buyer_email;
	}
	public String getBuyer_password() {
		return buyer_password;
	}
	public void setBuyer_password(String buyer_password) {
		this.buyer_password = buyer_password;
	}
	public Date getBuyer_signup_date() {
		return buyer_signup_date;
	}
	public void setBuyer_signup_date(Date buyer_signup_date) {
		this.buyer_signup_date = buyer_signup_date;
	}
}
