
	package com.striker.DTO;

import java.util.Date;
import org.springframework.web.multipart.MultipartFile;

public class ProductDTO {
	private int id;
		private String name;
		private long price;
	    private String category;
	    private String subCategory;
	    private String supplier;
	    private String description;
	    private MultipartFile  image;
	    private String imagepath;
	    private int weight;
	    private int height;
	    private String colors;
	    private int size;
	    private int  count;
	    private Date date;
		public String getName() {
			return name;
		}
		public void setName(String name) {
			this.name = name;
		}
		public long getPrice() {
			return price;
		}
		public void setPrice(long price) {
			this.price = price;
		}
		public String getCategory() {
			return category;
		}
		public void setCategory(String category) {
			this.category = category;
		}
		public String getSubCategory() {
			return subCategory;
		}
		public void setSubCategory(String subCategory) {
			this.subCategory = subCategory;
		}
		public String getDescription() {
			return description;
		}
		public void setDescription(String description) {
			this.description = description;
		}
		
		public int getWeight() {
			return weight;
		}
		public void setWeight(int weight) {
			this.weight = weight;
		}
		public int getHeight() {
			return height;
		}
		public void setHeight(int height) {
			this.height = height;
		}
		public String getColors() {
			return colors;
		}
		public void setColors(String colors) {
			this.colors = colors;
		}
		public int getSize() {
			return size;
		}
		public void setSize(int size) {
			this.size = size;
		}
		public String getSupplier() {
			return supplier;
		}
		public void setSupplier(String supplier) {
			this.supplier = supplier;
		}
		public Date getDate() {
			return date;
		}
		public void setDate(Date date) {
			this.date = date;
		}
		public int getId() {
			return id;
		}
		public void setId(int id) {
			this.id = id;
		}
		public MultipartFile getImage() {
			return image;
		}
		public void setImage(MultipartFile image) {
			this.image = image;
		}
		public String getImagepath() {
			return imagepath;
		}
		public void setImagepath(String imagepath) {
			this.imagepath = imagepath;
		}
		public int getCount() {
			return count;
		}
		public void setCount(int count) {
			this.count = count;
		}
	}	