package com.auction_client;

import java.sql.Date;
import java.time.LocalDate;
import java.util.List;
import java.util.Scanner;

import com.auction_bean.Admin;
import com.auction_bean.Bid;
import com.auction_bean.Buyer;
import com.auction_bean.BuyerDetails;
import com.auction_bean.Product;
import com.auction_bean.ProductFull;
import com.auction_bean.Seller;
import com.auction_bean.SellerDetails;
import com.auction_bean.SellerId;
import com.auction_bean.SoldProducts;
import com.auction_dao.AdminImplementation;
import com.auction_dao.AdminInterface;
import com.auction_dao.BuyerImplementation;
import com.auction_dao.BuyerInterface;
import com.auction_dao.SellerImplementation;
import com.auction_dao.SellerInterface;
import com.auction_exception.AdminException;
import com.auction_exception.BuyerException;
import com.auction_exception.ProductException;
import com.auction_exception.SellerException;

public class Main {

	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		System.out.println("Welcome Automate Auction");
		System.out.println("Press 1)Admin 2)Buyer 3)Seller 4)Exit");
		int choice=sc.nextInt();
		while(choice!=4) {
			switch(choice) {
				case 1:{
					//admin
					System.out.println("Enter admin email :");
					String aemail=sc.next();
					System.out.println("Enter admin password :");
					String apassword=sc.next();
					AdminInterface a1=new AdminImplementation();
					try {
						Admin admin=a1.adminLogin(aemail, apassword);
						System.out.println("Hello "+admin.getAdmin_name()+"..!");
						System.out.println(admin);
						System.out.println("Select from following options");
						System.out.println("1) View registered buyer  list");
						System.out.println("2) View registered seller list ");
						System.out.println("3) View daily dispute report");
						System.out.println("4) View the daily selling report");
						System.out.println("5) Solve the disputed reportd");
						System.out.println("6) Exit");
						int choice3=sc.nextInt();
						while(choice3!=6) {
							switch(choice3){
									case 1:{
										//View registered buyer list
										try {
											List<BuyerDetails> blist=a1.viewAllBuyers();
											blist.forEach(s->System.out.println(s));
										} catch (BuyerException e) {
											// TODO Auto-generated catch block
											System.out.println(e.getMessage());
										}
										break;
									}
									case 2:{
										//View registered seller list
										List<SellerDetails> slist;
										try {
											slist = a1.viewAllSellers();
											slist.forEach(s->System.out.println(s));
										} catch (BuyerException e) {
											// TODO Auto-generated catch block
											System.out.println(e.getMessage());
										}
										break;
									}
									case 3:{
										//View daily dispute report
										try {
											List<SoldProducts> dlist=a1.dailyDisputeReport();
											dlist.forEach(s->System.out.println(s));
										} catch (ProductException e) {
											System.out.println(e.getMessage());
										}
										break;
									}
									case 4:{
										a1.updateProduct();
										try {
											List<SoldProducts> splist=a1.dailySellingReport();
											splist.forEach(s->System.out.println(s));
										} catch (ProductException e) {
											System.out.println(e.getMessage());
										}
										break;
									}
									case 5:{
										//Solve the disputed reports
										System.out.println("Enter product id to resolve disputes");
										int p_id=sc.nextInt();
										try {
											String message=a1.solveDisputes(p_id);
											System.out.println(message);
										} catch (ProductException e) {
											// TODO Auto-generated catch block
											System.out.println(e.getMessage());
										}
										break;
									}
									default:System.out.println("Invalid Option");
							}
							System.out.println("Select from following options");
							System.out.println("1) View registered buyer  list");
							System.out.println("2) View registered seller list ");
							System.out.println("3) View daily dispute report");
							System.out.println("4) View the daily selling report");
							System.out.println("5) Solve the disputed reportd");
							System.out.println("6) Exit");
						}
					} catch (AdminException e) {
						System.out.println(e.getMessage());
					}
					break;
				}
				case 2:{
					//buyer
					System.out.println("Press 1)Login as Buyer  2)Register as Buyer  3) Exit");
					int bchoice=sc.nextInt();
					while(bchoice!=3) {
						switch(bchoice) {
							case 1:{
								System.out.println("Enter your email :");
								String bemail=sc.next();
								System.out.println("Enter your password :");
								String bpass=sc.next();
								BuyerInterface b1=new BuyerImplementation();
								
								try {
									Buyer buyer=b1.loginBuyer(bemail, bpass);
									System.out.println("Hi "+buyer.getBuyer_name()+"..!");
									System.out.println(buyer);
									
									//****************************************
									//view all products
									//bid on a product
									//mark disputed
									System.out.println("Select from following options");
									System.out.println("1)View all products");
									System.out.println("2)Bid on a product");
									System.out.println("3)Mark dispute");
									System.out.println("4)Exit");
									int choice2=sc.nextInt();
									while(choice2!=4) {
										switch(choice2) {
											case 1:{
												//view all products
												try {
													List<ProductFull> plist=b1.viewAllProdcut();
													plist.forEach(s->System.out.println(s));
												} catch (ProductException e) {
													// TODO Auto-generated catch block
													System.out.println(e.getMessage());
												}
												
												break;
											}
											case 2:{
												//bid on a product by id
												System.out.println("Enter product id :");
												int pid=sc.nextInt();
												System.out.println("Enter your bid (should be more than minimum bidding amount):");
												int min_b_amount=sc.nextInt();
												int buyerId=b1.getBuyerId(buyer.getBuyer_name()).getBuyer_id();
												try {
													Bid bid1=b1.bidOnProduct(min_b_amount, pid, buyerId);
													System.out.println(bid1);
												} catch (ProductException e) {
													// TODO Auto-generated catch block
													System.out.println(e.getMessage());
												}
												break;
											}
											case 3:{
												//mark a product disputed by id
												System.out.println("Enter product id to mark as disputed");
												int p_id=sc.nextInt();
												try {
													String message=b1.markDisputed(p_id);
													System.out.println(message);
												} catch (ProductException e) {
													// TODO Auto-generated catch block
													System.out.println(e.getMessage());
												}
												break;
											}
											default:System.out.println("Invalid option");
										}
										System.out.println("1)View all products");
										System.out.println("2)Bid on a product");
										System.out.println("3)Mark dispute");
										System.out.println("4)Exit");
										choice2=sc.nextInt();
									}
								} catch (BuyerException e) {
									// TODO Auto-generated catch block
									System.out.println(e.getMessage());
								}
								
								break;
							}
							case 2:{
								BuyerInterface b1=new BuyerImplementation();
								System.out.println("Enter buyer name :");
								String bname=sc.next();
								System.out.println("Enter buyer email :");
								String bemail=sc.next();
								System.out.println("Enter buyer password :");
								String bpass=sc.next();
								Date date=Date.valueOf(LocalDate.now());
								
								Buyer buyer1=new Buyer(bname, bemail, bpass, date);
								
								try {
									String message=b1.registerBuyer(buyer1);
									System.out.println(message);
								} catch (BuyerException e) {
									// TODO Auto-generated catch block
									System.out.println(e.getMessage());
								}
								
								break;
							}
							default:System.out.println("Invalid Option");
						}
						System.out.println("Press 1)Login as Buyer  2)Register as Buyer  3) Exit");
						bchoice=sc.nextInt();
					}
					break;
				}
				case 3:{
					//seller
					System.out.println("Press 1)Login as Seller  2)Register as Seller  3) Exit");
					int schoice=sc.nextInt();
					while(schoice!=3) {
						switch(schoice) {
							case 1:{
								//login
								SellerInterface s1=new SellerImplementation();
								System.out.println("Enter your email :");
								String semail=sc.next();
								System.out.println("Enter your password :");
								String spass=sc.next();
								try {
									Seller seller=s1.sellerLogin(semail, spass);
									System.out.println(seller);
									//*******************************************************
									//add product;
									//update product
									//remove product
									//view all sold product
									//mark disputed******************************************
									//view history of sold product***************************
									System.out.println("Select from following options");
									System.out.println("1) Add a product");
									System.out.println("2) Update a Product");
									System.out.println("3) Remove a Product");
									System.out.println("4) View all sold products");
									System.out.println("5) Mark disputed");
									System.out.println("6) Exit");
									int choice2=sc.nextInt();
									while(choice2!=6) {
										switch(choice2) {
											case 1:{
												//add a product
												System.out.println("Enter name of the product");
												String product_name=sc.next();
												System.out.println("Enter price of the product :");
												int product_price=sc.nextInt();
												System.out.println("Enter minimum bid amount");
												int min_bid=sc.nextInt();
												System.out.println("Set time limit for the product (in days)");
												int days=sc.nextInt();
												
												LocalDate ld=LocalDate.now().plusDays(days);
												Date lastDate=Date.valueOf(ld);
												SellerId sellerId=s1.getSellerId(seller.getSeller_name());
												Product p1=new Product(product_name,sellerId.getSeller_id(),product_price,false,Date.valueOf(LocalDate.now()),lastDate,true,min_bid,false,-1);
												try {
													String message=s1.sellerAddProduct(p1);
													System.out.println(message);
												} catch (ProductException e) {
													// TODO Auto-generated catch block
													System.out.println(e.getMessage());
												}
												break;
											}
											case 2:{
												// update a product
												System.out.println("Enter product id to change it's details :");
												int pid=sc.nextInt();
												System.out.println("Enter name of the product");
												String product_name=sc.next();
												System.out.println("Enter price of the product :");
												int product_price=sc.nextInt();
												System.out.println("Enter minimum bid amount");
												int min_bid=sc.nextInt();
												System.out.println("Set time limit for the product (in days)");
												int days=sc.nextInt();
												
												LocalDate ld=LocalDate.now().plusDays(days);
												Date lastDate=Date.valueOf(ld);
												SellerId sellerId=s1.getSellerId(seller.getSeller_name());
												Product p1=new Product(product_name,sellerId.getSeller_id(),product_price,false,Date.valueOf(LocalDate.now()),lastDate,true,min_bid,false,-1);
												try {
													String message=s1.updateProductDetails(pid, p1);
													System.out.println(message);
												} catch (ProductException e) {
													// TODO Auto-generated catch block
													System.out.println(e.getMessage());
												}
												break;
											}
											case 3:{
												// remove a product
												System.out.println("Enter product id of the product you want to remove");
												int pid=sc.nextInt();
												try {
													String message=s1.deleteProduct(pid);
													System.out.println(message);
												} catch (ProductException e) {
													// TODO Auto-generated catch block
													System.out.println(e.getMessage());
												}
												break;
											}
											case 4:{
												//view all product
												try {
													List<SoldProducts> plist=s1.showAllProduct();
													plist.forEach(s->System.out.println(s));
												} catch (ProductException e) {
													// TODO Auto-generated catch block
													System.out.println(e.getMessage());
												}
												break;
											}
											case 5:{
												//mark disputed
												System.out.println("Enter product id to mark as disputed");
												int p_id=sc.nextInt();
												try {
													String message=s1.markDisputed(p_id);
													System.out.println(message);
												} catch (ProductException e) {
													// TODO Auto-generated catch block
													System.out.println(e.getMessage());
												}
												break;
											}
											default:System.out.println("Invalid Input");
										}
										System.out.println("1) Add a product");
										System.out.println("2) Update a Product");
										System.out.println("3) Remove a Product");
										System.out.println("4) View all sold products");
										System.out.println("5) Mark disputed");
										System.out.println("6) Exit");
										choice2=sc.nextInt();
									}
								} catch (SellerException e) {
									System.out.println(e.getMessage());
								}
								break;
							}
							case 2:{
								//register
								SellerInterface s1=new SellerImplementation();
								System.out.println("Enter seller name :");
								String sname=sc.next();
								System.out.println("Enter seller email :");
								String semail=sc.next();
								System.out.println("Enter seller possword :");
								String spass=sc.next();
								Date date=Date.valueOf(LocalDate.now());
								Seller seller=new Seller(sname,semail,spass,date);
								String message=s1.sellerRegistration(seller);
								System.out.println(message);
								break;
							}
							default:System.out.println("Invalid input");
						}
						System.out.println("Press 1)Login as Seller  2)Register as Seller  3) Exit");
						schoice=sc.nextInt();
					}
					break;
				}
				default:System.out.println("Invalid Option");
			}
			System.out.println("Press 1)Admin 2)Buyer 3)Seller 4)Exit");
			choice=sc.nextInt();
		}
		System.out.println("Thank you for using Automated Auction System. ");

	}

}
