<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%-- 
    Document   : AddDoctors
    Created on : 06.01.2016, 8:46:33
    Author     : Жека
--%>

<%@page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8"%>


    
<!DOCTYPE html>
<html>
   <head>
       <%@include file="/WEB-INF/AllUsers/Menu.jspf"%>
       <style type="text/css">
        input[type="text"] {
            
            border: 1px solid #D4E2F7;
        }
        input {
            margin: 3px 0px 3px 30px;
        }

        
    </style>
            <meta http-equiv="Content-Type" content="text/html;charset=utf-8">
        <title>JSP Page</title>
        <script type="text/javascript" src = "https://code.jquery.com/jquery-3.0.0.js"></script>
        <script type="text/javascript" src = "/js/jsmy.js"></script>
    </head>
    <body>
         
 
        <form id="loginform" action="/Hospital_new/Registrpage" method="POST">
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
                        <input type="text" name="firstname" value="${firstname}" />
                    </td>
                </tr>
                <tr>
                    <td>Фамилия</td>
                    <td>
                        <input type="text" name="LastName" value="${LastName}" />
                     
                    </td>
                </tr>
                <tr>
                    <td>Стаж</td>
                    <td>
                         <input type="text" id="Exp" name="Exp" value="${Exp}" />
                    </td>
                </tr>
                <tr>
                    <td>Отделение</td>
                    <td>
                        <select name="Sprcia" >
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
                           
                            <option><%=com.hospital.DAO.User_status.doctors%></option>
                           <option><%=com.hospital.DAO.User_status.registry%></option>
                        </select>
                    </td>
                </tr>
                <tr>
                    <td>Логин</td>
                    <td>
                         <input type="text" id="NickName" name="NickName" value="${NickName}" />
                    </td>
                </tr>
                <tr>
                    <td>Пароль</td>
                    <td>
                        <input type="password" id="Pasw" name="Pasw" value="${Pasw}" />
                    </td>
                </tr>
                <tr>
                    <td>Повторите пароль</td>
                    <td>
                         <input type="text" id="Pasw2" name="Pasw2" value="${Pasw2}" />
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
                         <input type="text" id="Telephon" name="Telephon" value="${Telephon}" />
                    </td>
                </tr>
                <tr>
                    <td>е-mail</td>
                    <td>
                         <input type="text" id="Email" name="Email" value="${Email}" />
                    </td>
                </tr>
        
            </tbody>
        </table>
    
            <div class="send">
             <input type="submit"  value="Добавить">
             </div>
        </form>
    
    </body>
</html>

