<%-- 
    Document   : EditUsers
    Created on : 24.07.2016, 15:55:08
    Author     : Жека
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
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
       <title>EditUsers</title>
    </head>
    <body>
        <form id="loginform" action="EditCard" method="POST">

            <ul>
                <c:forEach var="item" items="${error}">
                    <li>${item}</li>                
                </c:forEach>
            </ul>
             <input type ="hidden" name = "id" value="${cardch.id}">
         <table border="1">
          <thead>
                <tr>
                    
                </tr>
            </thead>
            <tbody>
                  <tr>
                    <td>Номеp карты</td>
                    <td>
                         <input type="text" name="number" value="${cardch.number}" />
                    </td>
                </tr>
                <tr>
                    <td>Дата регистрации</td>
                    <td>
                         <input type="text" name="dateRegistr" value="${cardch.dateRegistr}" />
                    </td>
                </tr>
                <tr>
                    <td>Имя</td>
                    <td>
                        <input type="text" name="name" value="${cardch.name}" />
                    </td>
                </tr>
                <tr>
                    <td>Фамилия</td>
                    <td>
                        <input type="text" name="sname" value="${cardch.sname}" />
                     
                    </td>
                </tr>
              
                <tr>
                    <td>Дата рождения</td>
                    <td>
                    <select name="day" >
                    <c:forEach var="item" items="${date.getDay()}">
                    <option><c:out value="${item}"/></option>
                    </c:forEach>
                    </select>
                    <select name="month" >
                    <c:forEach var="item" items="${date.getMonth()}">
                     <option><c:out value="${item}"/></option>
                     </c:forEach>
                    </select>
                   <select name="year" >
                    <c:forEach var="item" items="${date.getYear()}">
                    <option> <c:out value="${item}"/></option>
                     </c:forEach>
                    </select>
                      
                    </td>
                </tr>
               
                <tr>
                    <td>Адресс</td>         
                    <td>
                         <input type="text" id="address" name="address" value="${cardch.address}" />
                    </td>
                </tr>
 
                <tr>
                    <td>Телефон</td>         
                    <td>
                         <input type="text" id="telephone" name="telephone" value="${cardch.telephone}" />
                    </td>
                </tr>
                <tr>
                    <td>е-mail</td>
                    <td>
                         <input type="text" id="email" name="email" value="${cardch.email}" />
                    </td>
                </tr>
            </tbody>
        </table>
            <div class="send">
             <input type="submit"  value=" Сохранть">
             </div>
        </form>
    </body>
</html>
