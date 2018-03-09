package com.striker.DAOIMP;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Types;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;


import com.striker.DAOI.CategoryDAOI;
import com.striker.DTO.CategoryDTO;
import com.striker.connection.GetConnection123;

//category daoimplementation class
public class CategoryDAOIMP implements CategoryDAOI {
  	
	private static  String selectQuery ="select * from category";
	private JdbcTemplate template;  
	  
    public CategoryDAOIMP(DataSource dataSource){
		   	template=new JdbcTemplate(dataSource);
	}

    //display all category list on screen
    public List<CategoryDTO> getCategory() {
		
    	List<CategoryDTO> category = template.query(selectQuery, new RowMapper<CategoryDTO>() {
           public CategoryDTO mapRow(ResultSet rs, int rowNum) throws SQLException {
			CategoryDTO dto=new CategoryDTO();
			dto.setId(rs.getInt(1));
			dto.setCategoryName(rs.getString(2));
			
			dto.setDescription(rs.getString(3));
				return dto;
				
			}
			
		   });
	return category;
	}

     //Add category method
	public int addCategory(String name, String description) {
		
		final String query="insert into category (Name,Description) values(?,?)";
          // define query arguments
		
		  Object[] params = new Object[] { name, description };
	
		  // define SQL types of the arguments
	
		        int[] types = new int[] { Types.VARCHAR, Types.VARCHAR };
	      // execute insert query to insert the data

		  // return number of row / rows processed by the executed query
		
		        int row = template.update(query, params, types);
		        System.out.println("row=="+row);
		return  row;
	}

    //delete category method
	public int deleteCategory(int id) {
		String deleteQuery="delete from category where id='"+id+"' ";
		return template.update(deleteQuery); 
}
    //Edit category get data based on id
	public CategoryDTO editCategory(int id) {
		String sql="select category.id,category.Name,category.Description from category where id=?";  
	   // return template.queryForObject(sql, new Object[]{id},new BeanPropertyRowMapper<CategoryDTO>(CategoryDTO.class));  
		 CategoryDTO dto=new CategoryDTO();
		try{
		Connection connection=GetConnection123.gettingConnection();
	  PreparedStatement ps=connection.prepareStatement(sql);
	  ps.setInt(1, id);
	  ResultSet rs=ps.executeQuery();
	  if(rs.next()){
	      dto.setId(rs.getInt(1));
	      dto.setCategoryName(rs.getString(2));
	      dto.setDescription(rs.getString(3));
	  }
	
	 }catch (Exception e) {
	
	 }
	return dto;
	
	}

     //updadate category data based on id
	public int updateCategory(CategoryDTO dto) {
		String sql="update category set Name='"+dto.getCategoryName()+"', Description='"+dto.getDescription()+"'where id='"+dto.getId()+"'";  
	    return template.update(sql); 
	}
}
