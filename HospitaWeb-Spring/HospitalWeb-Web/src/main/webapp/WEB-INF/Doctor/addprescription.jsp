<%-- 
    Document   : addprescription
    Created on : 02.10.2016, 18:36:00
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
        <script type="text/javascript" src="https://code.jquery.com/jquery-3.1.0.min.js"></script>
        <script>
            function addmedications(){
                
                var d = document;
                var url = 'addmedication';
                var medications;
                var indicationsforuse;
                var prescriptionid;
                medications = d.getElementById('medications').value;
                indicationsforuse = d.getElementById('indicationsforuse').value;
                $.ajax({
                    type: "POST",
                    url: 'doctors/addmedication',
                    data: {medications:medications,indicationsforuse:indicationsforuse},
                    success: function(data,status){
                        medications = $("#medications option:selected").text();
                        indicationsforuse = d.getElementById('indicationsforuse').value;
//                         // Считываем значения с формы
                        // Находим нужную таблицу
                        var tbody = d.getElementById('tab1').getElementsByTagName('TBODY')[0];

                        // Создаем строку таблицы и добавляем ее
                        var row = d.createElement("TR");
                        tbody.appendChild(row);

                        // Создаем ячейки в вышесозданной строке
                        // и добавляем тх
                        var td1 = d.createElement("TD");
                        var td2 = d.createElement("TD");

                        row.appendChild(td1);
                        row.appendChild(td2);

                        // Наполняем ячейки
                        td1.innerHTML = medications;
                        td2.innerHTML = indicationsforuse;
                        d.getElementById('indicationsforuse').value = "";
                    },
                    error:function(data,status){
                       
                        //alert
                    }
                  });
             
            }
        </script>      
        <form method="post" id="Action" action="/downloadPDF" >
                    <table>
                            <tr>
                                    <td>Ваше Id:</td>
                                    <td><input name="idUsers1" value="${user.id}" readonly=""/></td>

                            </tr>                         
                              <tr>
                                     <td>Препарат:</td>
                                     <td>
                                        <select name = "medications" id = "medications">
                                            <c:forEach var="item" items="${medications}">
                                                <option value="${item.id}" >${item.tradename}</option>
                                            </c:forEach>
                                        </select>
                                     </td>
                            </tr>
                            
                            <tr>
                                    <td>Предписание к употреблению:</td>
                                    <td><textarea  name="indicationsforuse" id="indicationsforuse"/></textarea></td>
                            </tr>
                         
                            <tr>
                                <td colspan="1"><input type="button" id ="b3" value="Добавить" onclick="addmedications()"/></td>
   
                            </tr>
                    </table>
            </form>
   <input type="submit"  value="Добавить"/>
                                    
                     <table id="tab1" class="sortable">
                        <thead>
                            <tr>
                                <th>Препарат</th>
                                <th>Предписание к применению</th>
                            </tr>
                        </thead>
                        <tbody>
                        </tbody>
                    </table>
                     <a href="downloadPDF" >Сохранить и расспечатать</a>
    </body>
</html>

