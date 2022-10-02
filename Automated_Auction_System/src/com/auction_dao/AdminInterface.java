package com.auction_dao;

import java.util.List;

import com.auction_bean.Admin;
import com.auction_bean.BuyerDetails;
import com.auction_bean.SellerDetails;
import com.auction_bean.SoldProducts;
import com.auction_exception.AdminException;
import com.auction_exception.BuyerException;
import com.auction_exception.ProductException;

public interface AdminInterface {
	public  Admin adminLogin(String email,String password) throws AdminException;
	
	public List<BuyerDetails> viewAllBuyers() throws BuyerException;
	
	public List<SellerDetails> viewAllSellers() throws BuyerException;
	
	public String updateProduct();
	
	public List<SoldProducts> dailySellingReport() throws ProductException;
	
	public List<SoldProducts> dailyDisputeReport() throws ProductException;
	
	public String solveDisputes(int id) throws ProductException;
}