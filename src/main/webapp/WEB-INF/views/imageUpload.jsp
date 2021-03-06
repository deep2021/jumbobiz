
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
   <%--  <%@ page isELIgnored="false" %> --%>
    <%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<style>
body {font-family: Arial, Helvetica, sans-serif;}
* {box-sizing: border-box}

/* Full-width input fields */
input[type=text], input[type=password],input[type=date] {
    width: 100%;
    padding: 15px;
    margin: 5px 0 22px 0;
    display: inline-block;
    border: none;
    background: #f1f1f1;
}
select{
 width: 100%;
    padding: 15px;
    margin: 5px 0 22px 0;
    display: inline-block;
    border: none;
    background: #f1f1f1;

}
 
input[type=text]:focus, input[type=password]:focus {
    background-color: #ddd;
    outline: none;
}

hr {
    border: 1px solid #f1f1f1;
    margin-bottom: 25px;
}

/* Set a style for all buttons */
button {
    background-color: #4CAF50;
    color: white;
    padding: 14px 20px;
    margin: 8px 0;
    border: none;
    cursor: pointer;
    width: 100%;
    opacity: 0.9;
}

button:hover {
    opacity:1;
}

/* Extra styles for the cancel button */
.cancelbtn {
    padding: 14px 20px;
    background-color: #f44336;
}

/* Float cancel and signup buttons and add an equal width */
.cancelbtn, .signupbtn {
  float: left;
  width: 50%;
}

/* Add padding to container elements */
.container {
    padding: 16px;
}

/* Clear floats */
.clearfix::after {
    content: "";
    clear: both;
    display: table;
}

/* Change styles for cancel button and signup button on extra small screens */
@media screen and (max-width: 300px) {
    .cancelbtn, .signupbtn {
       width: 100%;
    }
}
</style>
<body>

<form action="./savefile" method="post" enctype="multipart/form-data"><div class="container">
    <h1 align="center"> Add New Product</h1>
    <p align="center">Please fill in this form to add Product.</p>
    <hr>
 <label for="name"><b> Name</b></label>
 <input type="text" name="name"  />
 <label for="price"><b>Price</b></label>
     <input type="number" name="price" />
     <label for="category"><b>Category</b></label>
           <select name="category">
             <option value="">Select</option>
              <c:forEach var="list1" items="${categoryList}">
                            
                             <option value="${list1.categoryName}">${list1.categoryName}</option>
                                     </c:forEach>
 						</select>
 						 <label for="subCategory"><b>SubCategory</b></label>
    <select name="subCategory">
    <option value="">Select</option>
    <c:forEach var="list2" items="${subcategoryList}">
                           
                             <option value="${list2.name}">${list2.name}</option>
                                     </c:forEach>
 						</select>
<label for="supplier"><b>Supplier</b></label>
<select name="supplier">
 <option value="">Select</option>
 <c:forEach var="list3" items="${supplier123}">
                            
                             <option value="${list3.fname}">${list3.fname}</option>
                                     </c:forEach>
 						</select>
<label for="description"><b>Description</b></label><br>
     <textarea name="description"></textarea>  <br>
     
     
  <label for="image"><b>Image</b></label>
    <input type="file" name="image" /><br>
   

    <label for="weight"><b>Weight</b></label>
   <input type="number" name="weight" />

    <label for="height"><b>Height</b></label>
     <input type="number" name="height"   />
         <label for="colors"><b>Color</b></label>
     <input type="text" name="colors"  />
     <label for="size"><b>Size</b></label>
     <input type="number" name="size"  />
   
    <div class="clearfix">
      <button type="button" class="cancelbtn">Cancel</button>
      <button type="submit" class="signupbtn">ADD</button>
    </div>
  </div>
</form>

</body>
</html>

