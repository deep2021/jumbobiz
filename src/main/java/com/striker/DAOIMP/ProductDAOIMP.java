package com.striker.DAOIMP;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import javax.sql.DataSource;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import com.striker.DAOI.ProductDAOI;
import com.striker.DTO.ProductDTO;

//product class 
public class ProductDAOIMP implements ProductDAOI {

	
	private JdbcTemplate template;
	                                                                                                                                                                                                                                                                          
	public ProductDAOIMP(DataSource dataSource){
		template=new JdbcTemplate(dataSource);
		
	}
		
	//add product method
	public void addProduct(ProductDTO dto) {
	String query="insert into product(Name,Price,Category,SubCategory,Supplier,Description,Images,weight,Height,Colors,Sizes,Count,Date) values (?,?,?,?,?,?,?,?,?,?,?,?,?)";
	template.update(query, new Object[] { dto.getName(),dto.getPrice(), dto.getCategory(),
			dto.getSubCategory(), dto.getSupplier(), dto.getDescription(),dto.getImagepath(), dto.getWeight(),dto.getHeight(),dto.getColors(),dto.getSize(),dto.getCount(),dto.getDate() });
	
	}

	//view product method
    public List<ProductDTO> viewProduct() {
		 String selectQuery="select id, Name,Price,Category,SubCategory,Supplier,Images,weight,Height,Colors,Sizes,Count from product";
		 
		  List<ProductDTO> listContact = template.query(selectQuery, new RowMapper<ProductDTO>() {
                
				public ProductDTO mapRow(ResultSet rs, int rowNum) throws SQLException {
				
					ProductDTO dto = new ProductDTO();
				      dto.setId(rs.getInt(1));
				      dto.setName(rs.getString(2));
				      dto.setPrice(rs.getLong(3));
				      dto.setCategory(rs.getString(4));
				      dto.setSubCategory(rs.getString(5));
				      dto.setSupplier(rs.getString(6));
				      dto.setImagepath(rs.getString(7));
				      dto.setWeight(rs.getInt(8));
				      dto.setHeight(rs.getInt(9));
				      dto.setColors(rs.getString(10));
				      dto.setSize(rs.getInt(11));
				      dto.setCount(rs.getInt(12));
					return dto;
				}		
		    });
		    return listContact;
	}
        
    //delete product method
       	public int deleteProduct(int id) {
	 	 String deleteQuery="delete from product where id='"+id+"' ";
			    return template.update(deleteQuery);  
		}
}