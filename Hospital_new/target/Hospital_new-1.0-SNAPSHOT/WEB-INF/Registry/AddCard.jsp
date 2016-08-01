<%-- 
    Document   : AddCard
    Created on : 23.07.2016, 18:10:52
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
       <title>JSP Page</title>
    </head>
    <body>
        <input type ="hidden" name = "id" value="${user.id}">
        <form id="loginform" action="AddCard" method="POST">
            <ul>
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
                    <td>Номеp карты</td>
                    <td>
                         <input type="text" name="number" value="<c:out value="${number}"/>" />
                    </td>
                </tr>
                <tr>
                    <td>Дата регистрации</td>
                    <td>
                         <input type="text" name="dateRegistr" value="<c:out value="${dateRegistr}"/>" />
                    </td>
                </tr>
                <tr>
                    <td>Имя</td>
                    <td>
                        <input type="text" name="name" value="${name}" />
                    </td>
                </tr>
                <tr>
                    <td>Фамилия</td>
                    <td>
                        <input type="text" name="sname" value="${sname}" />
                     
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
                         <input type="text" id="address" name="address" value="${address}" />
                    </td>
                </tr>
 
                <tr>
                    <td>Телефон</td>         
                    <td>
                         <input type="text" id="telephone" name="telephone" value="${telephone}" />
                    </td>
                </tr>
                <tr>
                    <td>е-mail</td>
                    <td>
                         <input type="text" id="email" name="email" value="${email}" />
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
