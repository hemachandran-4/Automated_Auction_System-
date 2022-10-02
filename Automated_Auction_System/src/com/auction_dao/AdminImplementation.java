package com.auction_dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import com.auction_bean.Admin;
import com.auction_bean.BuyerDetails;
import com.auction_bean.SellerDetails;
import com.auction_bean.SoldProducts;
import com.auction_exception.AdminException;
import com.auction_exception.BuyerException;
import com.auction_exception.ProductException;
import com.auction_utility.DBUtil;

public class AdminImplementation implements AdminInterface{

	@Override
	public Admin adminLogin(String email, String password) throws AdminException {
		
		
		try(Connection conn=DBUtil.provideConnection();) {
			PreparedStatement ps=conn.prepareStatement("select * from admin where admin_email=? AND admin_password=?");
			ps.setString(1, email);
			ps.setString(2, password);
			
			ResultSet rs=ps.executeQuery();
			if(rs.next()) {
				int id=rs.getInt("admin_id");
				String name=rs.getString("admin_name");
				Admin a1=new Admin(id,name,email,password);
				return a1;
			}
			else throw new AdminException("Invalid Input");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			throw new AdminException(e.getMessage());
		}
	}

	
	@Override
	public List<BuyerDetails> viewAllBuyers() throws BuyerException {
		List<BuyerDetails> blist=new ArrayList<>();
		try(Connection conn=DBUtil.provideConnection()){
			PreparedStatement ps=conn.prepareStatement("select * from buyer");
			ResultSet rs=ps.executeQuery();
			
			while(rs.next()) {
				int b_id=rs.getInt("buyer_id");
				String b_name=rs.getString("buyer_name");
				String b_email=rs.getString("buyer_email");
				String b_password=rs.getString("buyer_password");
				Date b_signup_date=rs.getDate("buyer_signup_date");
				
				BuyerDetails bd1=new BuyerDetails(b_id, b_name, b_email, b_password, b_signup_date);
				blist.add(bd1);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			System.out.println(e.getMessage());
		}
		if(blist.size()==0) throw new BuyerException("No Buyer available");
		return blist;
	}

	@Override
	public List<SellerDetails> viewAllSellers() throws BuyerException {
		List<SellerDetails> slist=new ArrayList<>();
		try(Connection conn=DBUtil.provideConnection()){
			PreparedStatement ps=conn.prepareStatement("select * from seller");
			ResultSet rs=ps.executeQuery();
			
			while(rs.next()) {
				int b_id=rs.getInt("seller_id");
				String b_name=rs.getString("seller_name");
				String b_email=rs.getString("seller_email");
				String b_password=rs.getString("seller_password");
				Date b_signup_date=rs.getDate("seller_signup_date");
				
				SellerDetails bd1=new SellerDetails(b_id, b_name, b_email, b_password, b_signup_date);
				slist.add(bd1);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			System.out.println(e.getMessage());
		}
		if(slist.size()==0) throw new BuyerException("No Seller available");
		return slist;
	}

	@Override
	public String updateProduct() {
		String message="no product to updated";
		try(Connection conn=DBUtil.provideConnection()){
			PreparedStatement ps=conn.prepareStatement("update product SET sold=?, availability=? where product_time_limit=?");
			ps.setBoolean(1, true);
			ps.setBoolean(2, false);
			ps.setDate(3, Date.valueOf(LocalDate.now()));
			
			int x=ps.executeUpdate();
			message=x+" products updated";
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			message=e.getMessage();
		}
		return message;
	}


	
	@Override
	public List<SoldProducts> dailySellingReport() throws ProductException {
		List<SoldProducts> splist=new ArrayList<>();
		try(Connection conn=DBUtil.provideConnection()){
			PreparedStatement ps=conn.prepareStatement("select * from product where product_time_limit=? AND sold=?");
			ps.setDate(1, Date.valueOf(LocalDate.now()));
			ps.setBoolean(2, true);
			ResultSet rs=ps.executeQuery();
			while(rs.next()) {
				int seller_id=rs.getInt("seller_id");
				boolean disputed=rs.getBoolean("disputed");
				Date product_added_date=rs.getDate("product_added_date");
				boolean availability=rs.getBoolean("availability");
				String product_name=rs.getString("product_name");
				Date product_time_limit=rs.getDate("product_time_limit");
				int product_price=rs.getInt("product_price");
				int product_selling_price=rs.getInt("product_selling_price");
				int buyer_id=rs.getInt("buyer_id");
				boolean sold=rs.getBoolean("sold");
				int product_minimum_bid=rs.getInt("product_minimum_bid");
				
				SoldProducts p1=new SoldProducts(product_name, seller_id, product_price, disputed, product_added_date, product_time_limit, availability, product_minimum_bid, sold, buyer_id,product_selling_price);
				splist.add(p1);
			}
		}catch(SQLException e) {
			System.out.println(e.getMessage());
		}
		if(splist.size()==0) throw new ProductException("No product sold today");
		return splist;
	}


	@Override
	public List<SoldProducts> dailyDisputeReport() throws ProductException {
		List<SoldProducts> splist=new ArrayList<>();
		try(Connection conn=DBUtil.provideConnection()){
			PreparedStatement ps=conn.prepareStatement("select * from product where product_time_limit=? AND disputed=?");
			ps.setDate(1, Date.valueOf(LocalDate.now()));
			ps.setBoolean(2, true);
			ResultSet rs=ps.executeQuery();
			while(rs.next()) {
				int seller_id=rs.getInt("seller_id");
				boolean disputed=rs.getBoolean("disputed");
				Date product_added_date=rs.getDate("product_added_date");
				boolean availability=rs.getBoolean("availability");
				String product_name=rs.getString("product_name");
				Date product_time_limit=rs.getDate("product_time_limit");
				int product_price=rs.getInt("product_price");
				int product_selling_price=rs.getInt("product_selling_price");
				int buyer_id=rs.getInt("buyer_id");
				boolean sold=rs.getBoolean("sold");
				int product_minimum_bid=rs.getInt("product_minimum_bid");
				
				SoldProducts p1=new SoldProducts(product_name, seller_id, product_price, disputed, product_added_date, product_time_limit, availability, product_minimum_bid, sold, buyer_id,product_selling_price);
				splist.add(p1);
			}
		}catch(SQLException e) {
			System.out.println(e.getMessage());
		}
		if(splist.size()==0) throw new ProductException("No disputes reported today");
		return splist;
	}


	
	@Override
	public String solveDisputes(int p_id) throws ProductException {
		String message="Dispute not solved";
		try(Connection conn=DBUtil.provideConnection()){
			PreparedStatement ps=conn.prepareStatement("update product SET disputed=?,availability=? where product_id=? AND product_time_limit>?");
			ps.setBoolean(1, false);
			ps.setBoolean(2, true);
			ps.setInt(3, p_id);
			ps.setDate(4, Date.valueOf(LocalDate.now()));
			
			int x=ps.executeUpdate();
			if(x>0)message="Dispute resolved";
			else throw new ProductException("No product have issues");
		}
		catch(SQLException e) {
			message=e.getMessage();
		}
		return message;
	}

	 
}
