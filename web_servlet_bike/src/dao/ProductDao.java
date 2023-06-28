package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import common.DBConnection;
import dto.ProductDto;
import oracle.net.aso.s;

public class ProductDao {
	
	Connection con = null;
	PreparedStatement ps = null;
	ResultSet rs = null;

	public int productSave(ProductDto dto) {


		int result = 0;
		
		String query="insert into bike_신진환_product\r\n" + 
				"(hit, priority, attach, product_name, detail, product_size, price, reg_date, reg_company, reg_id)\r\n" + 
				"values\r\n" + 
				"("+dto.getHit()+", '"+dto.getPriority()+"', '"+dto.getAttach()+"', '"+dto.getProduct_name()+"', '"+dto.getDetail()+"', '"+dto.getProduct_size()+"', "+dto.getPrice()+", to_date('"+dto.getReg_date()+"', 'yyyy-mm-dd hh:mi:ss'), '"+dto.getReg_company()+"', '"+dto.getReg_id()+"')\r\n" + 
				"";
		System.out.println("jk"+query);
		try {
			con = DBConnection.getConnection();
			ps  = con.prepareStatement(query);
			result = ps.executeUpdate();
			
			
		}catch(Exception e) {
			System.out.println("productSave()오류 :"+query);
			e.printStackTrace();
		}finally {
			DBConnection.closeDB(con, ps, rs);
		}
		return result;
		
	}
	
	public int getTotalCount(String select, String search) {
		int count = 0;
		String query ="select count(*) as count \r\n" + 
				" from bike_신진환_product\r\n" + 
				" where "+select+" like '%"+search+"%' ";
		System.out.println("ak"+query);
		try {
			con = DBConnection.getConnection();
			ps  = con.prepareStatement(query);
			rs  = ps.executeQuery();
			if(rs.next()){
				count = rs.getInt("count");
			}
		}catch(Exception e) {
			System.out.println("getTotalCount()오류 :"+query);
			e.printStackTrace();
		}finally {
			DBConnection.closeDB(con, ps, rs);
		}		
		return count;
	}	
	
	//목록조회
	public ArrayList<ProductDto> getProductList(String select,String search,
											int start, int end){
		ArrayList<ProductDto> dtos = new ArrayList<>();
		String query ="select * from (select rownum as rnum, tbl.*\r\n" + 
				"from(select * from bike_신진환_product\r\n" + 
				"where "+select+" like '%"+search+"%'\r\n" + 
				"order by reg_date desc) tbl)\r\n" + 
				"where rnum >="+start+" and rnum <="+end+";";
		System.out.println("sk"+query);
		
		try {
			con = DBConnection.getConnection();
			ps  = con.prepareStatement(query);
			rs  = ps.executeQuery();
			while(rs.next()){
				String detail 		= rs.getString("detail");
				String priority 	= rs.getString("priority");
				String attach = rs.getString("attach");
				String product_name = rs.getString("product_name");
				int    hit      = rs.getInt("hit");
				String product_size = rs.getString("product_size");
				int    price      = rs.getInt("price");
				String reg_date = rs.getString("reg_date");
				String reg_company = rs.getString("reg_company");
				String reg_id = rs.getString("reg_id");
				ProductDto dto = new ProductDto(product_name, detail, product_size,  reg_company, priority, attach, reg_id, reg_date, price, hit);
				dtos.add(dto);
			}
		}catch(Exception e) {
			System.out.println("getProductsList()오류 :"+query);
			e.printStackTrace();
		}finally {
			DBConnection.closeDB(con, ps, rs);
		}		
		return dtos;
	}


	public ProductDto getProductView(String product_name) {
		int count = 0;
		String query = "select * from bike_신진환_product\r\n" + 
				"where product_name like '"+product_name+"';";
		ProductDto dto = null;
		try {
			con = DBConnection.getConnection();
			ps = con.prepareStatement(query);
			rs = ps.executeQuery();
			if(rs.next()) {
				String detail = rs.getString("detail");
				String priority = rs.getString("priority");
				String attach = rs.getString("attach");
				int hit = rs.getInt("hit");
				String product_size = rs.getString("product_size");
				int price = rs.getInt("price");
				String reg_date = rs.getString("reg_date");
				String reg_company = rs.getString("reg_company");
				String reg_id = rs.getString("reg_id");
				dto = new ProductDto(product_name, detail, product_size, reg_company, priority, attach, reg_id, reg_date, price, hit);
			}
		}catch(Exception e) {
			System.out.println("getProductView()오류 :"+query);
			e.printStackTrace();
		}finally {
			DBConnection.closeDB(con, ps, rs);
		}
		return dto;
	}
			
	 // 인덱스 제품 목록
/*	   public ArrayList<ProductDto> getProductIndex() {
	      ArrayList<ProductDto> dtos = new ArrayList<ProductDto>();
	      String query ="select * from(\r\n" + 
	                  "select tbl.*, rownum as rnum\r\n" + 
	                  "from\r\n" + 
	                  "(" +
	                  "select no, attach, product_name , to_char(price,'999,999') as price " + 
	                  "from bike_홍길동_product \r\n" + 
	                  " order by to_number(sort) desc, no desc"+
	                  ") tbl) \r\n" + 
	                  "where rnum >=1 and rnum <=6" ;
	      try {
	         con = DBConnection.getConnection();
	         ps  = con.prepareStatement(query);
	         rs  = ps.executeQuery();
	         while(rs.next()) {      
	            String no       = rs.getString("no");
	            String attach    = rs.getString("attach");
	            String product_name = rs.getString("product_name");
	            String price    = rs.getString("price");
	            
	            ProductDto dto = new ProductDto(no, product_name, attach,  price);
	            dtos.add(dto);
	         }
	      }catch(Exception e) {
	         System.out.println(" getProductIndex() 오류 : "+query);
	         e.printStackTrace();
	      }finally {
	         DBConnection.closeDB(con, ps, rs);
	      }         
	      return dtos;
	   }   */
}
