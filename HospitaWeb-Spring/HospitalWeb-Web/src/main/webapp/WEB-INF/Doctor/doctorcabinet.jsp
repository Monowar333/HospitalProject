<%-- 
    Document   : doctorscabinet
    Created on : 22.09.2016, 21:39:20
    Author     : Жека
--%>

<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <%@include file="/WEB-INF/AllUsers/Menu.jspf"%>
        <meta http-equiv="Content-Type" content="text/html;charset=UTF-8">
        <title>AllBase</title>
    
    </head>
    <h3> 
        Личный кабинет администратора
    </h3>
     <body>
        <script type="text/javascript" src="https://code.jquery.com/jquery-3.0.0.js"></script>
        <script> 
            function btn1(idb){
               var button = document.getElementById(idb);
                var act = document.getElementById("Action");

              if(button.id == 'b3'){
                act.action =  "addreception";
              } else  if(button.id == 'b4'){
                  act.action =  "listreception";
              }
                   act.submit();              
            }
        </script>

        <form id = "Action" action="" method="POST">
            <input type="submit" id ="b3" value="Новый прием" onclick = "btn1(this.id)">
                <input type="submit" id ="b4" value="Мои пациенты" onclick = "btn1(this.id)">

            </form>
        
        <table border="1">
            <thead>
                <tr>
                    
                </tr>
            </thead>
            <tbody>
                <tr>
                    <td>Имя</td>
                  
                    <td>
                        <input type="text" name="firstname" value="${user.name}" />
                    </td>
                </tr>
                <tr>
                    <td>Фамилия</td>
                    <td>
                        <input type="text" name="LastName" value="${user.snme}" />
                     
                    </td>
                </tr>
                <tr>
                    <td>Стаж</td>
                    <td>
                         <input type="text" id="Exp" name="Exp" value="${user.exp}" />
                    </td>
                </tr>
                <tr>
                    <td>Отделение</td>
                    <td>
                        <select name="Sprcia" >
                             <option value="${user.idspecialization.id}">${user.idspecialization.name}</option>
                        </select>
                      
                    </td>
                </tr>

                <tr>
                    <td>Фото</td>
                    <td>
                         <input type="text" id ="Foto" name="Foto" value="${Foto}" />
                    </td>
                </tr>
                <tr>
                    <td>Телефон</td>         
                    <td>
                         <input type="text" id="Telephon" name="Telephon" value="${user.telephone}" />
                    </td>
                </tr>
                <tr>
                    <td>е-mail</td>
                    <td>
                         <input type="text" id="Email" name="Email" value="${user.email}" />
                    </td>
                </tr>
        
            </tbody>
        </table>
    </body>
</html>
