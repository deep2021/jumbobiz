package com.striker.DAOI;

import java.util.List;

import com.striker.DTO.CategoryDTO;
import com.striker.DTO.SubCategoryDTO;

public interface CategoryDAOI {
	
	//public int addCategory(String category);
	public List<CategoryDTO> getCategory();
	public int addCategory(String name,String description);
	public int deleteCategory(int id);
	public CategoryDTO editCategory(int id);
	public int updateCategory(CategoryDTO dto);

}
