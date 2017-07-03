<%-- 
    Document   : formPeriodo
    Created on : 23-jun-2015, 10:23:00
    Author     : SistemasUpeu
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="fm" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/css/bootstrap.min.css">
        <link href="<c:url value='/static/css/app.css' />" rel="stylesheet"></link>        
    </head>
    <body>
        <div>
            <c:url var="saveProveedorx"  value="actualizarProveedor" />
            <fm:form modelAttribute="modeloProveedor" method="post" action="guardarProveedor">
                <table>

                    <tr>
                        <td><fm:label path="nombreEmpresa">Empresa</fm:label> </td>
                        <td><fm:input path="nombreEmpresa" /></td>
                    </tr>
                    <tr>
                        <td><fm:label path="ruc">ruc</fm:label> </td>
                        <td><fm:input path="ruc" size="60" /></td>
                    </tr>  

                    <tr>
                        <td><fm:label path="idDireccion.idDireccion">Direccion</fm:label> </td> 
                            <td>
                            <fm:select path="idDireccion.idDireccion" cssClass="myinput"  >
                                <fm:option value=""><c:out value="--------------------"/> </fm:option>
                                <c:if test="${!empty ListDireccion}">
                                    <c:forEach var="pa"  items="${ListDireccion}">
                                        <fm:option value="${pa.idDireccion}" >
                                            <c:out value="${pa.idProvincia.idDepartamento.idPaies.pais}"/>
                                        </fm:option>
                                    </c:forEach>
                                </c:if>
                            </fm:select> 
                        </td>
                    </tr> 
                    <tr>
                        <td><fm:label path="idPersona.idPersona">Persona</fm:label> </td> 
                            <td>
                            <fm:select path="idPersona.idPersona" cssClass="myinput"  >
                                <fm:option value=""><c:out value="--------------------"/> </fm:option>
                                <c:if test="${!empty ListPersona}">
                                    <c:forEach var="pe"  items="${ListPersona}">
                                        <fm:option value="${pe.idPersona}" >
                                            <c:out value="${pe.idPersona.nombres}"/>
                                        </fm:option>
                                    </c:forEach>
                                </c:if>
                            </fm:select> 
                        </td>
                    </tr>
                    <tr>                        
                        <td colspan="2"><input type="submit" value="Enviar" > </td>
                    </tr>
                </table>                
            </fm:form>         
        </div>
    </body>
</html>
