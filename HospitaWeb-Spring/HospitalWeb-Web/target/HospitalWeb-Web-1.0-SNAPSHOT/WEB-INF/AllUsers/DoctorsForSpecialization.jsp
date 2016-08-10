
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
        
         <h1>Список сотрудников</h1>

         
         <div class="inner">
            <div class="main">
                <section id="content">
                    <div class="indent">
                    	<div class="wrapper">
                        	<article class="col-1">
                                <div class="bg">
                                    <div class="padding">
                                    	<h3 class="p5">Специалисты</h3>
                                         <c:forEach var="item" items="${users}">
                                        <div class="wrapper p5">
                                        	<figure class="img-indent"><img src="images/page5-img1.jpg" alt="" /></figure>
                                            <div class="extra-wrap">
                                            	<h3>${item.name} ${item.snme}</h3>
                                                <p class="p">
                                                    Более подробную информацию можно узнать перейдя по ссылке
                                                </p>
                                                <a class="button-2" href="SelectDoctors/${item.id}">Подробнее</a>
                                            </div>
                                        </div>
                                       </c:forEach>
                                    </div>
                                </div>
                            </article>
                        </div>
                    </div>
                </section>
                <div class="block"></div>
            </div>
        </div>
    

    </body>
</html>
