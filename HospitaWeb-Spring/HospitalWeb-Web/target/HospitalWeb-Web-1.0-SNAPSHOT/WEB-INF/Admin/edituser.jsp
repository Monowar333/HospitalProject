<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%-- 
    Document   : EditUser
    Created on : 07.07.2016, 19:38:29
    Author     : Жека
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
    <head>
        <%@include file="/WEB-INF/AllUsers/Menu.jspf"%>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
       <form id="loginform" action="saveuser/${user.id}" method="POST">
           <input type ="hidden" name = "id" value="${user.id}">
            <ul >
                <c:forEach var="item" items="${error}">
                    <li>${item}</li>                
                </c:forEach>
            </ul>
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
                             <option value="    ${user.idspecialization.id}">${user.idspecialization.name}</option>
                            <c:forEach var="item" items="${Specialalization}">
                                <option value="${item.id}">${item.name}</option>
                            </c:forEach>
<!--                            <option>Гастроэнтерология</option>
                                <option>Гинекология</option>
                            <option>Дерматология</option>
                            <option>Кардиология</option>
                            <option>ЛОР</option>
                            <option>Неврология</option>
                            <option>Стоматология</option>-->
                        </select>
                      
                    </td>
                </tr>
                <tr>
                    <td>Группа пользователей</td>
                  
                    <td>
                        <select name="Group" >
                           
                            <option>doctors</option>
                            <%--<%=com.hospital.DAO.User_status.doctors%>--%>
                           <option>registry</option>
                           <%--<%=com.hospital.DAO.User_status.registry%>--%>
                        </select>
                    </td>
                
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
    
            <div class="send">
             <input type="submit" name = "save" value="Сохранить">
             </div>
        </form>
    </body>
</html>
