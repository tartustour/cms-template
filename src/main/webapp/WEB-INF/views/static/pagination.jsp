<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>

<c:set var="pageListLong" value="6" />

<c:choose>
	<c:when test="${not empty param.seo }">
		<c:set var="seo" value="${param.seo}" />
	</c:when>
	<c:otherwise>
		<c:set var="seo" value="true" />
	</c:otherwise>
</c:choose>

<c:choose>
	<c:when test="${!empty param.url }">
		<c:set var="url" value="${param.url}" />
	</c:when>
	<c:otherwise>
		<c:set var="url" value="" />
	</c:otherwise>
</c:choose>

<!-- Tne number of records -->
<c:choose>
	<c:when test="${!empty param.listSize }">
		<c:set var="listSize" value="${param.listSize}" />
	</c:when>
	<c:otherwise>
		<c:set var="listSize" value="0" />
	</c:otherwise>
</c:choose>

<!-- Current page number -->
<c:choose>
	<c:when test="${!empty param.pageIndex}">
		<c:set var="pageIndex" value="${param.pageIndex}" />
	</c:when>
	<c:otherwise>
		<c:set var="pageIndex" value="1" />
	</c:otherwise>
</c:choose>

<!-- The number of records per page -->
<c:choose>
	<c:when test="${!empty param.pageSize}">
		<c:set var="pageSize" value="${param.pageSize}" />
	</c:when>
	<c:otherwise>
		<c:set var="pageSize" value="1" />
	</c:otherwise>
</c:choose>

<c:choose>
	<c:when test="${(listSize mod pageSize)!=0}">
		<c:set var="res" value="${(listSize - (listSize mod pageSize))/pageSize + 1}" />
	</c:when>
	<c:otherwise>
		<c:set var="res" value="${listSize/pageSize}" />
	</c:otherwise>
</c:choose>

<!-- The number of pages -->
<c:set var="pageCount">
	<fmt:formatNumber value="${res}" maxFractionDigits="0" />
</c:set>


<c:choose>
	<c:when test="${pageIndex - pageListLong < 1}">
		<c:set var="startPage" value="1" />
	</c:when>
	<c:otherwise>
		<c:set var="startPage" value="${pageIndex - pageListLong}" />
	</c:otherwise>
</c:choose>

<c:choose>
	<c:when test="${pageIndex + pageListLong >= pageCount}">
		<c:set var="endPage" value="${pageCount}" />
	</c:when>
	<c:otherwise>
		<c:set var="endPage" value="${pageIndex + pageListLong}" />
	</c:otherwise>
</c:choose>


<ul class="paging">
	<c:if test="${pageIndex > pageListLong + 1}">
		<c:choose>
			<c:when test="${seo == true }">
				<li class="btn-prev"><a href="<c:url value="${url}1/" />" class="page">&#8592;</a></li>
			</c:when>
			<c:otherwise>
				<li class="btn-prev"><a href="<c:url value="${url}&pageIndex=1" />"
					class="page">&#8592;</a></li>
			</c:otherwise>
		</c:choose>
	</c:if>

	<c:forEach var="i" begin="${startPage}" end="${endPage}">
		<c:choose>
			<c:when test="${i == pageIndex}">
				<li class="active"><span><c:out value="${i}" /></span></li>
			</c:when>
			<c:otherwise>
				<li><c:choose>
						<c:when test="${seo == true }">
							<a href="<c:url value="${url}${i}/" />" class="page"> <c:out
									value="${i}" />
							</a>
						</c:when>
						<c:otherwise>
							<a href="<c:url value="${url}&pageIndex=${i}" />" class="page"> <c:out
									value="${i}" />
							</a>
						</c:otherwise>
					</c:choose></li>
			</c:otherwise>
		</c:choose>
	</c:forEach>

	<c:if test="${pageIndex < pageCount - pageListLong}">
		<c:choose>
			<c:when test="${seo == true }">
				<li class="btn-next"><a href="<c:url value="${url}${pageCount}/" />"
					class="page"> &#8594; </a></li>
			</c:when>
			<c:otherwise>
				<li class="btn-next"><a
					href="<c:url value="${url}&pageIndex=${pageCount}" />" class="page">
						&#8594; </a></li>
			</c:otherwise>
		</c:choose>
	</c:if>
</ul>