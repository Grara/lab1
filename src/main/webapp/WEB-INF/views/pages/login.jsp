<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:import url="../fragments/head-fragment.jsp"></c:import>
<style>
input:invalid {
  border-color: red;
}
</style>
<body>
    <c:import url="../fragments/header-fragment.jsp"></c:import>
    <c:import url="../fragments/sidemenu-fragment.jsp"></c:import>
    <aside class="side-pc left" style="border: 4px dotted red;">
    </aside>
    <main id="main" style="text-align:center; border: 4px dotted green;">
      <span>ID</span>
      <input type="text" id="id" required/>
      <span>비밀번호</span>
      <input type="text" id="pwd" required/>
      <button type="button" id="loginBtn">로그인</button>
    </main>
    <aside class="side-pc right" style="border: 4px dotted purple;">
    </aside>
    <footer style="border: 4px dotted yellow; height:20rem">
    </footer>
<script>
window.onload = function(){
  $('#loginBtn').on('click', function(){
    login()
  })

  function login(){
    const param = {
      ID: $('#id').val(),
      PWD: $('#pwd').val(),
    }

    console.log(param)

    fetch('/login/process',
      {
        method: "POST",
        headers: {
          "Content-Type": "application/json"
        },
        body: JSON.stringify(param),
      }
    ).then(function(res){
      if(res.status == 200) {
        location.href = '/'
      } else {
        throw new Error('로그인 실패')
      }
    })
    .catch((error) => console.log(error))
  }
}
</script>
</body>