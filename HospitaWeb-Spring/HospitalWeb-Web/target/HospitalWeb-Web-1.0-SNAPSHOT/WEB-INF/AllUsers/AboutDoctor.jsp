
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <%@include file="Menu.jspf"%>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <style>
            <%@include  file="content.css" %>
        </style>
    </head>
    <body>
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
