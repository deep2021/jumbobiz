
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%> 
<% boolean no_visable_elements = false; %>
<%@ page isELIgnored="false" %>
<%@include file="header.jsp" %>

 <h1>Edit Profile</h1>  
       <form:form method="POST" action="./editSaveProfile">    
        <table >    
        <tr>  
        <td></td>    
         <td></td>  
         </tr> 
           <tr>    
      
          <td><form:hidden path="id"/></td>  
         </tr>
           
         <tr>    
          <td>FirstName : </td>   
          <td><form:input path="fname"  /></td>  
         </tr>    
         <tr>    
          <td>LastName :</td>    
          <td><form:input path="lname" /></td>  
         </tr> 
          <tr> 
              <td>Email :</td>    
          <td><form:input path="email" /></td>  
         </tr>
           <tr> 
         
              <td>Mobile :</td>    
          <td><form:input path="mobile" /></td>  
         </tr>   
                <tr> 
         
             <%--  <td>City :</td>    
          <td><form:input path="city" /></td>  
         </tr>   
                <tr> 
         
              <td>State :</td>    
          <td><form:input path="state" /></td>  
         </tr>   
                <tr> 
         
              <td>Country :</td>    
          <td><form:input path="country" /></td>  
         </tr>    --%>
            
           
         <tr>    
          <td><form:button>Update</form:button> </td>    
           
         </tr>    
        </table>    
       </form:form>    
	<%@include file="footer.jsp" %>	
