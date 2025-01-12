<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:import url="../fragments/head-fragment.jsp"></c:import>
<body>
    <c:import url="../fragments/header-fragment.jsp"></c:import>
    <c:import url="../fragments/sidemenu-fragment.jsp"></c:import>
    <aside class="side-pc left" style="border: 4px dotted red;">
    </aside>
    <main id="main" style="text-align:center; border: 4px dotted green;">
    </main>
    <aside class="side-pc right" style="border: 4px dotted purple;">
    </aside>
    <footer style="border: 4px dotted yellow; height:20rem">

    </footer>
<script>
window.onload = function(){
  console.log($('.main'))
}
</script>
</body>