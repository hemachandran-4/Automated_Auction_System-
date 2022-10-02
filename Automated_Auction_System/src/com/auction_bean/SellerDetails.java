package com.auction_bean;

import java.sql.Date;

public class SellerDetails {
	private int seller_id;;
	private String seller_name;
	private String seller_email;
	private String seller_password;
	private Date seller_signup_date;
	public int getSeller_id() {
		return seller_id;
	}
	public void setSeller_id(int seller_id) {
		this.seller_id = seller_id;
	}
	public String getSeller_name() {
		return seller_name;
	}
	@Override
	public String toString() {
		return "SellerDetails [seller_id=" + seller_id + ", seller_name=" + seller_name + ", seller_email="
				+ seller_email + ", seller_password=" + seller_password + ", seller_signup_date=" + seller_signup_date
				+ "]";
	}
	public SellerDetails(int seller_id, String seller_name, String seller_email, String seller_password,
			Date seller_signup_date) {
		super();
		this.seller_id = seller_id;
		this.seller_name = seller_name;
		this.seller_email = seller_email;
		this.seller_password = seller_password;
		this.seller_signup_date = seller_signup_date;
	}
	public void setSeller_name(String seller_name) {
		this.seller_name = seller_name;
	}
	public String getSeller_email() {
		return seller_email;
	}
	public void setSeller_email(String seller_email) {
		this.seller_email = seller_email;
	}
	public String getSeller_password() {
		return seller_password;
	}
	public void setSeller_password(String seller_password) {
		this.seller_password = seller_password;
	}
	public Date getSeller_signup_date() {
		return seller_signup_date;
	}
	public void setSeller_signup_date(Date seller_signup_date) {
		this.seller_signup_date = seller_signup_date;
	}
}
