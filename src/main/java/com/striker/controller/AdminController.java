package com.striker.controller;

import java.io.IOException;
import java.util.List;
import java.util.Map;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import com.striker.DAOI.AdminLoginDAOI;
import com.striker.DAOI.AllUserListDAOI;
import com.striker.DAOI.CategoryDAOI;
import com.striker.DAOI.SubCategoryDAOI;
import com.striker.DTO.CategoryDTO;
import com.striker.DTO.SubCategoryDTO;
import com.striker.DTO.UsersListDTO;

@Controller
public class AdminController {
    
	@Autowired
	private AllUserListDAOI dao;
	@Autowired
	private CategoryDAOI dao1;
	@Autowired
	private SubCategoryDAOI dao3;
	@Autowired
	private AdminLoginDAOI dao2;
	HttpSession session=null;
	
	//Display UsersList
	@RequestMapping(value="/userList")
	 public ModelAndView listContact() throws IOException{
    List<UsersListDTO> listContact = dao.allUser();
	    
	    return new ModelAndView("usersList","data",listContact);
	
	 }
	
	//Delete user
	@RequestMapping(value="/deleteuser/{id}",method = RequestMethod.GET)
	 public ModelAndView deleteContact(@PathVariable int id) throws IOException{
			
		 dao.deleteUser(id);
		
		 return new ModelAndView("redirect:/userList");  
		
		 }
	
	//show Category
	 @RequestMapping(value="/showcategory")
		public ModelAndView viewCategory(){
			List<CategoryDTO> listCategory=dao1.getCategory();
			
			  return new ModelAndView("categoryiList","category",listCategory);
		}
	 
	 //Add category form
	 @RequestMapping(value="/showCategoryForm")
	 public ModelAndView showCategoryForm(){
		 return new ModelAndView("CategoryForm");
	 }
	 
	 //Add category
	 @RequestMapping(value="/addCategory")
	 public ModelAndView addCategory(@RequestParam Map<String,String> requestParams){
		 String name=requestParams.get("category");
		   String description=requestParams.get("description");
		  dao1.addCategory(name, description);
		return new ModelAndView("redirect:/showcategory");
	 }
	 
	//Delete category
		@RequestMapping(value="/deletecategory/{id}")
		 public ModelAndView deleteCategory(@PathVariable int id) throws IOException{
				
		    dao1.deleteCategory(id);
			return new ModelAndView("redirect:/showcategory");  
			
			 }
		
		//Edit  category
		@RequestMapping(value="/editformcategory/{id}")
		 public ModelAndView editFormCategory(@PathVariable int id,HttpServletRequest request) throws IOException{
		CategoryDTO dto=dao1.editCategory(id);
		
			   return new ModelAndView("EditCategoryForm","command",dto);  
       	 }
		
		//Edit save category
		@RequestMapping(value="/saveCategory")  
	    public ModelAndView editSaveCategory(@ModelAttribute CategoryDTO dto ,BindingResult result){  
			 if(result.hasErrors()){
			      return new ModelAndView("error");
			   }
			   dao1.updateCategory(dto);
			 return new ModelAndView("redirect:/showcategory");   
		}
	 
	 //Show SubCategory
	 @RequestMapping(value="/subCategory")
		public ModelAndView viewSubCategory(){
			List<SubCategoryDTO> listsubCategory=dao3.getSubCategory();
			  return new ModelAndView("subCategoryList","subcategory",listsubCategory);
		}
	 
	  //Add subcategory form
	 @RequestMapping(value="/showSubCategoryForm")
		 public ModelAndView showsubCategoryForm(){
			 List<CategoryDTO> listCategory=dao1.getCategory();
			 return new ModelAndView("SubCategoryForm","subCategorydata",listCategory);
		 }
	 
		 //Add SubCategory
		 @RequestMapping(value="/addSubCategory")
		 public ModelAndView addSubCategory(@RequestParam Map<String,String> requestParams){
			 String name=requestParams.get("subcategory");
			   String description=requestParams.get("description");
			   String category=requestParams.get("categoryName");
			 dao3.addSubCategory(name, description,category);
			 return new ModelAndView("redirect:/subCategory");
		 }
			//Delete subcategory
				@RequestMapping(value="/deletesubcategory/{id}")
				 public ModelAndView deleteSubCategory(@PathVariable int id) throws IOException{
					dao3.deleteSubCategory(id);
					 return new ModelAndView("redirect:/subCategory");  
					 }
				
				//Edit  subcategory
				@RequestMapping(value="/editformsubcategory/{id}")
				 public ModelAndView editFormSubCategory(@PathVariable int id,HttpServletRequest request) throws IOException{
					 SubCategoryDTO dto=dao3.editSubCategory(id);
					   return new ModelAndView("EditSubCategoryForm","command",dto);  

					 }
				
				//Edit save subcategory
				@RequestMapping(value="/editSave123")  
			    public ModelAndView editSaveSubCategory(@ModelAttribute SubCategoryDTO dto ,BindingResult result){  
					 if(result.hasErrors()){
					      return new ModelAndView("error");
					   }
					    dao3.updateSubCategory(dto);
					return new ModelAndView("redirect:/subCategory");   
				}
			
				//Display SupplierList
				@RequestMapping(value="/supplierList")
				 public ModelAndView listSupplier() throws IOException{
		         List<UsersListDTO> listContact = dao.allSuppliers();
				    return new ModelAndView("SupplierList","data1",listContact);
				
				 }
				
				//Delete Supplier
				@RequestMapping(value="/deleteSuppler/{id}",method = RequestMethod.GET)
				 public ModelAndView deleteSupplier(@PathVariable int id) throws IOException{
						 dao.deleteSupplier(id);
					 return new ModelAndView("redirect:/supplierList");  
					 }
				
				//make supplier
				@RequestMapping(value="/makeSuppler/{id}",method = RequestMethod.GET)
				public ModelAndView makeSupplier(@PathVariable int id)throws IOException{
					dao.makeSupplier(id);
					return new ModelAndView("redirect:/userList");
				}
				/*//Add product Form 
				@RequestMapping(value="/addProductForm")
				public ModelAndView addProductForm(){
					ModelAndView model=new ModelAndView("AddProductForm");
					 List<CategoryDTO> listCategory=dao1.getCategory();
				     model.addObject("categoryList", listCategory);
					 List<SubCategoryDTO> listsubCategory=dao3.getSubCategory();
					 model.addObject("subcategoryList", listsubCategory);
					 List<UsersListDTO> supplier = dao.allSuppliers();
					 model.addObject("supplier123", supplier);
				     model.addObject("product", new ProductDTO());
					   
					return model;
					
				}*/
				//Add product
				   /* @RequestMapping(value="/addProduct")
				    public ModelAndView processRegistration(@ModelAttribute("product") ProductDTO dto,HttpServletResponse response) throws FileNotFoundException {
				    	// response.setContentType("image/jpeg, image/jpg, image/png, image/gif");
				    	Date d=new Date();
				    	dto.setDate(d);
				    	dao4.addProduct(dto);
				    	   return new ModelAndView("redirect:/viewProduct");
				     
				 }
				 */ 	/*@RequestMapping(value = "/addProduct", method = RequestMethod.POST)
			public ModelAndView addProduct( @ModelAttribute(value = "product") ProductDTO product, BindingResult result,HttpServletRequest request) {
					
					MultipartFile image = product.getImage();
					if (image != null && !image.isEmpty()) {
							File file = new File("C:/Users/u.k.com/Desktop/Jumbo/SpringProject/src/main/webapp/assets/uploads/"
										+ product.getName() + ".jpg");
							try {
							image.transferTo(new File(file.toString()));
							System.out.println("transfer done"+image+"path string=="+file.toString());
						} catch (IllegalStateException e) {
							e.printStackTrace();
						} catch (IOException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
							String path="/SpringProject/src/main/webapp/assets/uploads/"+product.getName()+ ".jpg";
						System.out.println("relative path=="+path);
							
							String setpath=product.getName()+".jpg";
							System.out.println("setpath="+setpath);
							product.setImagepath(setpath);
						dao4.addProduct(product);
					}
					
					return new ModelAndView("redirect:/viewProduct");
				}
				
				
				    //view Product
				    @RequestMapping(value="/viewProduct")
				    public ModelAndView viewProduct(HttpServletResponse response){
				    	 
				    	response.setContentType("image/jpeg, image/jpg");
				        

				    	List<ProductDTO> list=dao4.viewProduct();
				    	//response.getOutputStream().write(list);
				    	return new ModelAndView("ViewProduct","product",list);
				    }
				    
				    //delete product
				    @RequestMapping(value="/deleteProduct/{id}",method = RequestMethod.GET)
					 public ModelAndView deleteProduct(@PathVariable int id) throws IOException{
						 dao4.deleteProduct(id);
				     	  return new ModelAndView("redirect:/viewProduct");
						
						 }*/
				  
				    //EditProfile
				    @RequestMapping(value="/adminProfile")
				    public ModelAndView editProfile(){
				    	UsersListDTO dto=dao2.getProfile();
				    	return new ModelAndView("AdminProfile","command",dto);
				    }
				    
				    //Edit Save Profile
				    @RequestMapping(value="/editSaveProfile")
				    public ModelAndView editSaveProfile(@ModelAttribute UsersListDTO dto ,BindingResult result){
				    	dao2.editSaveProfile(dto);
				    	return new ModelAndView("index");
				    }
}