package com.striker.controller;

import java.io.File;
import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Date;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;
import com.striker.DAOI.AllUserListDAOI;
import com.striker.DAOI.CategoryDAOI;
import com.striker.DAOI.ProductDAOI;
import com.striker.DAOI.SubCategoryDAOI;
import com.striker.DTO.CategoryDTO;
import com.striker.DTO.ProductDTO;
import com.striker.DTO.SubCategoryDTO;
import com.striker.DTO.UsersListDTO;
//Product Controller
@MultipartConfig(maxFileSize = 16177215)
@Controller
public class ProductController {
	@Autowired
	private ProductDAOI dao4;
	@Autowired
	private AllUserListDAOI dao;
	@Autowired
	private CategoryDAOI dao1;
	@Autowired
	private SubCategoryDAOI dao3;
	private Path path;
	HttpSession session=null;
	/*@Bean
	public MultipartResolver multipartResolver() {
		CommonsMultipartResolver multipartResolver = new CommonsMultipartResolver();
		multipartResolver.setMaxUploadSize(10240000);
		return multipartResolver;
	}*/
        
	// show Add Product form
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
	}
	
	//add Product method
	@RequestMapping(value = "/addProduct", method = RequestMethod.POST)
	public ModelAndView addProduct(@ModelAttribute(value = "product") ProductDTO product, BindingResult result,@RequestParam("image") MultipartFile file,HttpServletRequest request) throws IOException, ServletException{
		
		Date d=new Date();
		product.setDate(d);
    	
	//	userService.saveUser(user);

		// get the provided image from the form
		MultipartFile userImage = product.getImage();
          // System.out.println("multipart file="+userImage);
		// get root directory to store the image
	//	String rootDirectory = request.getSession().getServletContext().getRealPath("/");
     
	// path = Paths.get(rootDirectory + "/WEB-INF/resources/images" +
		// product.getProductId() + ".png");
		/*path = Paths.get(rootDirectory
				+product.getName() + ".jpg");
		
	//path=Paths.get(rootDirectory+product.getName()+".jpg");
		// check whether image exists or not
		if (userImage != null && !userImage.isEmpty()) {
			try {
				userImage.transferTo(new File(path.toString()));
			} catch (IllegalStateException | IOException e) {
				// oops! something did not work as expected
				e.printStackTrace();
				throw new RuntimeException("Saving User image was not successful", e);
			}*/
		if (userImage != null && !userImage.isEmpty()) {
			 path = Paths
					.get("C:/Users/u.k.com/Desktop/Jumbo/SpringProject/src/main/webapp/resources/"
							+ product.getName() + ".jpg");
			try {
				userImage.transferTo(new File(path.toString()));
			} catch (IllegalStateException e) {
				e.printStackTrace();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			product.setImagepath(product.getName()+".jpg");
			dao4.addProduct(product);
		}
		return new ModelAndView("redirect:/viewProduct");
	}
	//view product method
	 @RequestMapping(value="/viewProduct")
	    public ModelAndView viewProduct(HttpServletResponse response){
		    response.setContentType("image/jpeg");
            System.out.println("inside view controller");
	    	List<ProductDTO> list=dao4.viewProduct();
	    	//response.getOutputStream().write(list);
	    	return new ModelAndView("ViewProduct","product",list);
	    }
	  //delete product method
	    @RequestMapping(value="/deleteProduct/{id}",method = RequestMethod.GET)
		 public ModelAndView deleteProduct(@PathVariable int id) throws IOException{
			 dao4.deleteProduct(id);
	     	  return new ModelAndView("redirect:/viewProduct");
			 }
}