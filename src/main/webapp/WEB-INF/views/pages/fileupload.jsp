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
      <form id="form1">
        <span>내용1</span>
        <input type="text" name="con1" required/>
        <span>내용2</span>
        <input type="text" name="con2" required/>
        <input name="uploadImg" type="file" accept="image/*"/>
        <button type="button" id="upload"></button>
      </form>
    </main>
    <aside class="side-pc right" style="border: 4px dotted purple;">
    </aside>
    <footer style="border: 4px dotted yellow; height:20rem">
    </footer>
<script>
window.onload = function(){
  $('#upload').on('click', function(){
    upload()
  })

  function upload(){
    const formEl = document.getElementById("form1")
    const param = new FormData(formEl)
    param.append('abc', 'abc')
    console.log(param.has('sddd'))

    fetch('/upload/process',
      {
        method: "POST",
        body: param,
      }
    ).then(function(res){
      if(res.status == 200) {
        console.log('성공')
      } else {
        throw new Error('업로드 실패')
      }
    })
    .catch((error) => console.log(error))
  }
}
</script>
</body>