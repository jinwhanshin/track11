<%@ page pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
	<P>NOTICE & NEWS</P>
	 <ul>	
		<li><a href="Notice"><c:if test="${t_nowPage eq 'notice'}"><span class="fnt"><i class="fas fa-apple-alt"></i></span></c:if>NOTICE</a></li>
		<li><a href="News"><c:if test="${t_nowPage eq 'news'}"><span class="fnt"><i class="fas fa-apple-alt"></i></span></c:if>NEWS</a></li>
		<li><a href="Qna"><c:if test="${t_nowPage eq 'nqna'}"><span class="fnt"><i class="fas fa-apple-alt"></i></span></c:if>QNA</a></li>
		<li><a href="Freeboard"><c:if test="${t_nowPage eq 'freeboard'}"><span class="fnt"><i class="fas fa-apple-alt"></i></span></c:if>FREEBOARD</a></li>
		<li><a href="Etc"><c:if test="${t_nowPage eq 'etc'}"><span class="fnt"><i class="fas fa-apple-alt"></i></span></c:if></a>ETC</li>
