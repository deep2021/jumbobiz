package com.striker.DAOIMP;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Types;
import java.util.List;
import javax.sql.DataSource;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import com.striker.DAOI.SubCategoryDAOI;
import com.striker.DTO.SubCategoryDTO;

public class SubCategoryDAOIMP implements SubCategoryDAOI {

	private JdbcTemplate template;  
	  
    public SubCategoryDAOIMP(DataSource dataSource){
			template=new JdbcTemplate(dataSource);
	}

	public List<SubCategoryDTO> getSubCategory() {
		
		String query="select * from sub_category  ";
		List<SubCategoryDTO> category = template.query(query, new RowMapper<SubCategoryDTO>() {
	        
			public SubCategoryDTO mapRow(ResultSet rs, int rowNum) throws SQLException {
			SubCategoryDTO dto=new SubCategoryDTO();
			dto.setId(rs.getInt(1));
		    dto.setName(rs.getString(2));
		    dto.setDescription(rs.getString(3));
		    dto.setCategory(rs.getString(4));
			
			return dto;
				
			}
			
		   });
	return category;
	
	}

	public int addSubCategory(String name, String description, String category) {
		final String query="insert into sub_category (Name,Description,category) values(?,?,?)";
        // define query arguments
		
		        Object[] params = new Object[] { name, description ,category};
	
		  // define SQL types of the arguments
	
		        int[] types = new int[] { Types.VARCHAR, Types.VARCHAR ,Types.VARCHAR};
	      // execute insert query to insert the data

		  // return number of row / rows processed by the executed query
		
		        int row = template.update(query, params, types);
		
		        return  row;
		
	}

	public int deleteSubCategory(int id) {
		String deleteQuery="delete from sub_category where id='"+id+"' ";
		return template.update(deleteQuery); 	
	}
	public SubCategoryDTO editSubCategory(int id) {
		String sql="select * from sub_category where id=?";  
	    return template.queryForObject(sql, new Object[]{id},new BeanPropertyRowMapper<SubCategoryDTO>(SubCategoryDTO.class));  
	}
	public int updateSubCategory(SubCategoryDTO dto) {
		String sql="update sub_category set Name='"+dto.getName()+"', Description='"+dto.getDescription()+"'where id='"+dto.getId()+"'";  
		    return template.update(sql);  
	}
}