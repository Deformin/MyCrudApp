<%@ page contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>Список комплектующих</title>
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/css/bootstrap.min.css">
    <style type="text/css">
        .myrow-container {
            margin: 20px;
        }

        .btn {
            padding: 2px 2px;
            width: 10em;
            height: 2em;
            background-color: #4d3a1e;
            color: #f1f1f1;
            border-radius: 0;
            transition: .2s;
        }

        .btn:hover, .btn:focus {
            border: 1px solid #4d3a1e;
            background-color: #fff;
            color: #000;
        }

        a.aEdit:link, a.aDelete:link {
            color: #a83016;
        }

        a.aEdit:visited, a.aDelete:visited {
            color: #947872;
        }

        a.aEdit:hover, a.aDelete:hover {
            color: #60a870;
        }

        a.aEdit:active, a.aDelete:active {
            color: #ded728;
        }

        a.aCreatePart:link {
            color: #d1cbbc;
        }

        a.aCreatePart:visited {
            color: #c4bba5;
        }

        a.aCreatePart:hover {
            color: #a0cc95;
        }

        .panel-footer a {
            font-size: 1.2em;
        }

        .panel-footer a:link {
            color: #d1cbbc;
        }

        .panel-footer a:visited {
            color: #c4bba5;
        }

        .panel-footer a:hover {
            color: #a0cc95;
        }

        .panel-footer a:active {
            color: #ded728;
        }

    </style>
</head>
<body class=".container-fluid" style="background-color:whitesmoke">
<div class="container myrow-container">
    <div class="panel">
        <div class="panel-heading" style="background-color:#786455">
            <h3 class="panel-title ">
                <div align="left"><a class="aCreatePart" href="createPart">Добавить новую деталь+</a></div>
            </h3>
        </div>
        <div class="panel-body">
            <c:if test="${empty partList}">
                На складе нет деталей
            </c:if>
            <c:if test="${not empty partList}">
                <form action="searchPart">
                    <div class="row">
                        <div class="col-md-3">Искать детали по имени:</div>
                        <div class="col-md-2"><input type="text" name="searchName" id="searchName"
                                                     placeholder="введите текст..."></div>
                        <div class="col-md-2"><input class="btn btn-xs" type='submit' value='Поиск'/></div>
                    </div>
                </form>
                <form action="listNeeded">
                    <div class="row">
                        <div class="col-md-4">Фильтровать детали по необходимости:</div>
                        <div class="col-md-2">
                            <select name="isNeeded" id="isNeeded">
                                <option value="">все</option>
                                <option value="true">необходимые для сборки</option>
                                <option value="false">опциональные</option>
                            </select>
                        </div>
                        <div class="col-md-1"></div>
                        <div class="col-md-2"><input class="btn btn-xs" type='submit' value='Отфильтровать'/></div>
                    </div>
                </form>

                <table class="table table-hover table-bordered" style="text-align:center">
                    <thead style="background-color: #b39b89;">
                    <tr>
                        <th>ID</th>
                        <th>Наименование</th>
                        <th>Необходимость</th>
                        <th>Количество</th>
                        <th>Редактирование</th>
                        <th>Удаление</th>
                    </tr>
                    </thead>
                    <tbody>
                        <c:forEach items="${partList}" var="part">
                            <tr>
                                <th><c:out value='${part.id}'/></th>
                                <th><c:out value='${part.name}'/></th>
                                <th><c:out value='${part.needed == true ? "да" : "нет"}'/></th>
                                <th><c:out value='${part.amount}'/></th>
                                <th><a class="aEdit" href="editPart?id=<c:out value='${part.id}'/>">Редактировать</a>
                                </th>
                                <th><a class="aDelete" href="deletePart?id=<c:out value='${part.id}'/>">Удалить</a></th>
                            </tr>
                        </c:forEach>
                    </tbody>
                </table>
            </c:if>
            <table class="table table-bordered">
                <tbody>
                <tr>
                    <th>Можно собрать</th>
                    <th><c:out value='${computers}'/></th>
                    <th>компьютеров</th>
                </tr>
                </tbody>
            </table>
        </div>
        <div align="center" class="panel-footer" style="background-color:#786455" id="pagination">
            <c:url value="/" var="prev">
                <c:param name="page" value="${page-1}"/>
            </c:url>
            <c:if test="${page > 1}">
                <a href="<c:out value="${prev}" />" class="pn prev">Пред</a>
            </c:if>

            <c:forEach begin="1" end="${maxPages}" step="1" varStatus="i">
                <c:choose>
                    <c:when test="${page == i.index}">
                        <span>${i.index}</span>
                    </c:when>
                    <c:otherwise>
                        <c:url value="/" var="url">
                            <c:param name="page" value="${i.index}"/>
                        </c:url>
                        <a href='<c:out value="${url}" />'>${i.index}</a>
                    </c:otherwise>
                </c:choose>
            </c:forEach>
            <c:url value="/" var="next">
                <c:param name="page" value="${page + 1}"/>
            </c:url>
            <c:if test="${page + 1 <= maxPages}">
                <a href='<c:out value="${next}" />' class="pn next">След</a>
            </c:if>
        </div>
    </div>
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/2.1.3/jquery.min.js"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/js/bootstrap.min.js"></script>
</div>
</body>
</html>