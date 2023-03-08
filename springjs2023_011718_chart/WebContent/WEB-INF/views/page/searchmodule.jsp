<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
   <c:set var="pageurl" value="?searchType=${searchType}&searchValue=${searchValue}&cPage" />

                  <form class="d-flex" method="post" action="boardList">
                     <select class="form-control btn-mini" name="searchType" id="searchType"
                        style="margin-left: 120px;">
                        <option value="3">검색</option>
                        <option value="1">제목</option>
                        <option value="2">이름</option>
                     </select> <input class="form-control me-2" type="text"
                        style="width: 300px" name="searchValue" id="searchValue">
                     <button class="btn btn-outline-secondary" type="submit">Search</button>
                  </form>

       