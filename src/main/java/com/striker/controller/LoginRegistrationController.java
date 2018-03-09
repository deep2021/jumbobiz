package com.striker.controller;
import java.util.Date;
import java.util.Properties;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import com.striker.DAOI.AdminLoginDAOI;
import com.striker.DAOI.RegistrationDAOI;
import com.striker.DTO.LoginDTO;
import com.striker.DTO.RegistrationDTO;
import com.striker.randomNumber.RandomNumberGenerator;

//LoginRegistration Controller
@Controller
public class LoginRegistrationController {   
	 static String emailToRecipient, emailSubject, emailMessage;
	 static final String emailFromRecipient = "ishendrapratap@gmail.com";
	 int varificationCode=0;
	   String  msg="";
	@Autowired 
	AdminLoginDAOI dao;
	@Autowired
	RegistrationDAOI dao1;
	HttpSession session=null;
	RandomNumberGenerator random=new RandomNumberGenerator();
	//login form controller
	 @RequestMapping(value = "/login", method = RequestMethod.GET)
	  public ModelAndView showLogin(HttpServletRequest request, HttpServletResponse response) {
	     System.out.println("inside login controller");
		 ModelAndView mav = new ModelAndView("AdminLogin");
	    mav.addObject("login", new LoginDTO());
	    return mav;
	  }
	  //login process controller
	 @RequestMapping(value = "/loginProcess", method = RequestMethod.POST)
	  public ModelAndView loginProcess(HttpServletRequest request, HttpServletResponse response,
	                                                  @ModelAttribute("login") LoginDTO login) {
	          System.out.println("inside login process controller");
		      ModelAndView mav = null;
	          String userName=null;
	          if(login.getUserName()!="" && login.getPassword()!=""){
	          LoginDTO dto=new LoginDTO();
	          
	    	  dto =dao.login(login);
	    	  System.out.println("inside login processcontroller");
	    	  if(login.getPassword().equals(dto.getPassword()) && dto.getRole().equals("ADMIN")){
	    	  mav = new ModelAndView("index");
	    	  System.out.println(dto.getRole());
	  	      mav.addObject("firstname", login.getUserName());
	  	      session=request.getSession(false);
	  	      if(session!=null){
	  	    	  session.setAttribute("login", userName);
	  	    }
	  	      else{
	  	    	  new ModelAndView("redirect:/login");
	  	      }
	    	  }
	    	  else if(login.getPassword().equals(dto.getPassword()) && dto.getRole().equals("User")){
		    	mav = new ModelAndView("Home");
		    	System.out.println(dto.getRole());
		  	    mav.addObject("firstname", login.getUserName());
		  	    session=request.getSession(false);
		  	    if(session!=null){
		  	    	System.out.println("inside user session if");
		  	    	  session.setAttribute("login", userName);
		  	    }
		  	    }
              else if(login.getPassword().equals(dto.getPassword()) && dto.getRole().equals("Supplier")){  
		        mav = new ModelAndView("Home");
		        System.out.println(dto.getRole());
		   	    mav.addObject("firstname", login.getUserName());
		  	    session=request.getSession(false);
		  	    if(session!=null){
		  	  	System.out.println("inside user session if");
		  	    	  session.setAttribute("login", userName);
		  	    }}
	    	  else{
	    		  return new ModelAndView("AdminLogin");
	    	  }
	      }
	      else{
	    	  mav = new ModelAndView("AdminLogin");
	  	      mav.addObject("message", "Username or Password is wrong!!");
	  	  }
	   return mav;
	
	  } 
	//logout controller
	 @RequestMapping(value="/logout")
	 public ModelAndView logout(){

		 if(session!=null){
			 session.invalidate();
		 }
			return new ModelAndView("redirect:/login");
	 }
	 
	 //Registration form controller
	 @RequestMapping(value = "/registration", method = RequestMethod.GET)
	  public ModelAndView registration(HttpServletRequest request, HttpServletResponse response) {
		 ModelAndView mav = new ModelAndView("emailForm");
	     return mav;
	  }
	 
	 //Registration process controller
	 @RequestMapping(value = "/save", method = RequestMethod.POST)
	  public ModelAndView loginProcess(HttpServletRequest request, HttpServletResponse response,
	  @ModelAttribute("register") RegistrationDTO dto) {
		 if(dto.getPassword().equals(dto.getRepassword())){
			 Date date = new Date();
		     dto.setDate(date);
		     String email=(String) session.getAttribute("email");
		      dto.setEmail(email);
			 dao1.registration(dto);
			 return new ModelAndView("redirect:/login");
	     }
		 else{
			 return new ModelAndView("error");
		 }
	 }
	 @RequestMapping(value = "sendEmail123", method = RequestMethod.POST)
     public String sendEmailToClient(HttpServletRequest request) throws AddressException, MessagingException {
         emailToRecipient = request.getParameter("mailTo");
         session=request.getSession();
         session.setAttribute("email", emailToRecipient);
         emailSubject="Varification Code";
         varificationCode=random.generateRandomNumber();    
         String to =emailToRecipient;
         String subject =emailSubject;
         msg =Integer.toString(varificationCode); 
         final String from =emailFromRecipient;
         final  String password ="9897571117";
         Properties props = new Properties();  
         props.setProperty("mail.transport.protocol", "smtp");     
         props.setProperty("mail.host", "smtp.gmail.com");  
         props.put("mail.smtp.auth", "true");  
         props.put("mail.smtp.port", "465");  
         props.put("mail.debug", "true");  
         props.put("mail.smtp.socketFactory.port", "465");  
         props.put("mail.smtp.socketFactory.class","javax.net.ssl.SSLSocketFactory");  
         props.put("mail.smtp.socketFactory.fallback", "false");  
         Session session = Session.getDefaultInstance(props,  
         new javax.mail.Authenticator() {
            protected PasswordAuthentication getPasswordAuthentication() {  
            return new PasswordAuthentication(from,password);  
        }  
        });  
        //session.setDebug(true);  
        Transport transport = session.getTransport();  
        InternetAddress addressFrom = new InternetAddress(from);  
        MimeMessage message = new MimeMessage(session);  
        message.setSender(addressFrom);  
        message.setSubject(subject);  
        message.setContent(msg, "text/plain");  
        message.addRecipient(Message.RecipientType.TO, new InternetAddress(to));  
        transport.connect();  
        Transport.send(message);  
        transport.close();
      return "emailVarification"; 
     }
	 
	 
	 @RequestMapping(value = "mailVerification", method = RequestMethod.POST)
	  public ModelAndView verification(HttpServletRequest request, HttpServletResponse response) {
	     String verificationcode=request.getParameter("verificationcode");
		 if(verificationcode.equals(msg)){
			 ModelAndView mav=new ModelAndView("Registration");
			 mav.addObject("register", new RegistrationDTO());
			  return mav;
		 }
		 else{
	    return new ModelAndView("error");
		 }
	  }
}