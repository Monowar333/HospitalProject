<%-- 
    Document   : addreception
    Created on : 23.09.2016, 22:48:01
    Author     : Жека
--%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
       <%@include file="/WEB-INF/AllUsers/Menu.jspf"%>
        <meta http-equiv="Content-Type" content="text/html;charset=UTF-8">
        <title>newreception</title>
         <style>
            select {
             width: 300px; /* Ширина списка в пикселах */
            }
            TEXTAREA {
                width: 300px; /* Ширина в процентах */
                height: 300px; /* Высота в пикселах */
               }
           </style>
    </head>
    <body>
        <script> 
            function btn1(idb){
               var button = document.getElementById(idb);
                var act = document.getElementById("Action");

              if(button.id == 'b3'){
                act.action =  "savereception";
              } else  if(button.id == 'b4'){
                    act.action =  "savereceptionandprescription";
              }
                   act.submit();              
            }
        </script>         
        <form:form method="post" id="Action" action="savereception" commandName="reception">
                    <table>
                            <tr>
                                    <td>Ваше Id:</td>
                                    <td><input name="idUsers1" value="${reception.idUsers.id}" readonly=""/></td>

                            </tr>
                            <tr>
                                   <td>Номер карты:</td>
                                     <td>
                                        <select name="idcard1" >
                                            <c:forEach var="item" items="${idcard1}">
                                                <option value="${item.id}">${item.id} ${item.name} ${item.sname} ${item.number}</option>
                                            </c:forEach>
                                        </select>
                                     </td>  
                            </tr>
                         
                              <tr>
                                  <td>Дата регистрации:</td>
                                  <td><input type="text" name="time1" value="${date.getDateregistr()}" readonly="" /><td>
                     
                              </tr>
                            
                             
                            <tr>

                                    <td>Статус приема:</td>
                                    <td>
                                        <select <form:input path="status"/> >
                                            <option>new</option>
                                           <option>repeat</option>
                                           <option>close</option>
                                        </select>
                                    </td>
                            </tr>

                            <!--<tr>-->
                                    <!--<td>Фото:</td>-->
                                    <!--<td></td>-->
                                    <!--<td><span class="error"></span></td>-->
                            <!--</tr>-->
                            <tr>
                                    <td>Симптомы:</td>
                                    <td><form:textarea path="complaints" /></td>
                                    <td><span class="error"><form:errors path="complaints" /></span></td>
                            </tr>
                              <tr>
                                     <td>Диагнос:</td>
                                     <td>
                                        <select name = "provisionaldiagnosis" >
                                            <c:forEach var="item" items="${provisionaldiagnosis}">
                                                <option value="${item.id}">${item.name}</option>
                                            </c:forEach>
                                        </select>
                                     </td>
                            </tr>
                         
                            <tr>
                                <td colspan="1"><input type="submit" id ="b3" value="Добавить" onclick="btn1(this.id)"/></td>
                                     <td colspan="2"><input type="submit" id ="b4" value="Добавить и выписать рецепт" onclick="btn1(this.id)"/></td>
                            </tr>
                    </table>
            </form:form>     
    </body>
</html>
