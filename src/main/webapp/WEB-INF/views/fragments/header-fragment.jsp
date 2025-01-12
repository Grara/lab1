<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:import url="../fragments/head-fragment.jsp"></c:import>

<header style="text-align:center; border: 4px dotted blue;">
  <a class="contrast" href="/">This is just lab</a>
  <nav class="main-nav" style="padding-inline: 100px">
    <ul style="align-items: baseline">
      <c:forEach var="m1" items="${userSession.menu}">
        <li class="menu-lv1 contrast">${m1.name}
          <c:if test = "${m1.children.size() > 0}">
          <div class="menu-dropdown">
            <ul>
              <c:forEach var="m2" items="${m1.children}">
              <c:choose>
                <c:when test = "${m2.children.size() == 0}">
                <li><a href="${m2.url}">${m2.name}</a></li>
                </c:when>
                <c:otherwise>
                <li>
                  <details>
                    <summary>${m2.name}</summary>
                    <ul>
                      <c:forEach var="m3" items="${m2.children}">
                      <li><a href="${m3.url}">${m3.name}</a></li>
                      </c:forEach> <!--m3-->
                    </ul>
                  </details>
                </li>
                </c:otherwise>
              </c:choose>
              </c:forEach> <!--m2-->
            </ul>
          </div>
          </c:if>
        </li>
      </c:forEach> <!--m1-->
    </ul>
  </nav>
</header>
