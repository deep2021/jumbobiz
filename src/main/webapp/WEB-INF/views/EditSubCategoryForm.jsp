
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%> 
<% boolean no_visable_elements = false; %>
<%@ page isELIgnored="false" %>
<%@include file="header.jsp" %>

 <h1>Edit SubCategory</h1>  
       <form:form method="POST" action="../editSave123" >    
        <table >    
        <tr>  
        <td></td>    
         <td></td>  
         </tr> 
           <tr>    
      
          <td><form:hidden path="id"  /></td>  
         </tr>    
         <tr>    
          <td>Name : </td>   
          <td><form:input path="name"  /></td>  
         </tr>    
         <tr>    
          <td>Description :</td>    
          <td><form:textarea path="description" /></td>  
         </tr>   
            
           
         <tr>    
          <td><form:button>Register</form:button> </td>    
           
         </tr>    
        </table>    
       </form:form>    
	<%@include file="footer.jsp" %>	
