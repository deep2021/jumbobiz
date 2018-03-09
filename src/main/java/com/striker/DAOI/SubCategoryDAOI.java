package com.striker.DAOI;

import java.util.List;

import com.striker.DTO.SubCategoryDTO;

public interface SubCategoryDAOI {
	public List<SubCategoryDTO> getSubCategory();
	public int addSubCategory(String name, String description,String category);
	public SubCategoryDTO editSubCategory(int id);
	public int updateSubCategory(SubCategoryDTO dto);
	public int deleteSubCategory(int id);
	
}
