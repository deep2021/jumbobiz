<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
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

 <form:form id="RegistrationForm" modelAttribute="register" action="save" method="post" style="border:1px solid #ccc"  >
  <div class="container">
    <h1 align="center">Registration</h1>
    <p align="center">Please fill in this form to create an account.</p>
    <hr>
 <label for="fname"><b>First Name</b></label>
 <form:input path="fname" placeholder="Enter First Name"  />
 <label for="lname"><b>LastName</b></label>
     <form:input path="lname" placeholder="Enter last Name"  name="lname"   />
     <%-- <label for="email"><b>Email</b></label>
     <form:input path="email" placeholder="Enter Email" name="email"  />
   --%><label for="mobile"><b>Mobile</b></label>
    <form:input path="mobile" placeholder="Enter mobile" name="mobile"  />
    <label for="psw"><b>Password</b></label>
   <form:password path="password" placeholder="Enter Password" name="password" />
    <label for="psw-repeat"><b>Confirm Password</b></label>
     <form:password path="repassword" placeholder="Repeat Password" name="repassword"  />
   <%--  <label for="date"><b>Date</b></label>
    <form:input path="date" placeholder="date" name="date" /><br>
    --%><label for="Role"><b>Role</b></label>
    <form:select path="role" name="role">
    <option value="User">User</option>
    <option value="Supplier">Supplier</option>
     
    </form:select>
     <%-- <label for="city"><b>City</b></label>
    <form:input path="city" placeholder="city" name="city"  />
    <label for="state"><b>State</b></label>
    <form:input path="state" placeholder="state" name="state"  />
    <label for="country"><b>Country</b></label>
   <form:input path="country" placeholder="country" name="country"  />
  
    <label>
      <input type="checkbox" checked="checked" name="remember" style="margin-bottom:15px"> Remember me
    </label> --%>
    <h5>Allready has an account:<a href="./login">Login</a></h5>
    <p>By creating an account you agree to our <a href="#" style="color:dodgerblue">Terms & Privacy</a>.</p>

    <div class="clearfix">
      <form:button type="button" class="cancelbtn">Cancel</form:button>
      <form:button type="submit" class="signupbtn">Sign Up</form:button>
    </div>
  </div>
</form:form>

</body>
</html>
