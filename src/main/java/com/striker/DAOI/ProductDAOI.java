package com.striker.DAOI;

import java.util.List;

import com.striker.DTO.ProductDTO;

public interface ProductDAOI {
	public void addProduct(ProductDTO dto);
     public List<ProductDTO> viewProduct();
     public int deleteProduct(int id);
}
