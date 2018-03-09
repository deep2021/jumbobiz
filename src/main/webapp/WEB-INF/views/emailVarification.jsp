<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<html>

    <head>

        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">

        <title>Spring MVC Email Example</title>

       <!--  <style type="text/css">

            #sendEmailBtn {

                float: left;

                margin-top: 22px;

            }

        </style>
 -->
    </head>
 

    <body>

   

            <h2> Varification</h2>

            <form  method="post" action="mailVerification" >

                <table  border="0" width="80%" >

                    <tr>

                        <td >Varification Code:

                        <input type="text" name="verificationcode" size="10" /></td>

                    </tr>

       <!--              <tr>

                        <td>Subject: </td>

                        <td><input id="mailSubject" type="text" name="subject" size="65" /></td>

                    </tr>

                    <tr>

                        <td>Message: </td>

                        <td><textarea id="mailMessage" cols="50" rows="10" name="message"></textarea></td>

                    </tr>

                    <tr>

                        <td>Attachment: </td>

                        <td><input id="mailAttachment" type="file" name="attachFileObj" size="60" /></td>

                    </tr>
 -->
                    <tr>

                        <td ><input  type="submit" value="Send Email" /></td>

                    </tr>

                </table>

            </form>



    </body>

</html>
