<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>

<c:set var="pageListLong" value="1" />

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


<c:choose>
	<c:when test="${!empty param.listSize }">
		<c:set var="listSize" value="${param.listSize}" />
	</c:when>
	<c:otherwise>
		<c:set var="listSize" value="0" />
	</c:otherwise>
</c:choose>


<c:choose>
	<c:when test="${!empty param.pageIndex}">
		<c:set var="pageIndex" value="${param.pageIndex}" />
	</c:when>
	<c:otherwise>
		<c:set var="pageIndex" value="1" />
	</c:otherwise>
</c:choose>


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


<c:forEach var="i" begin="${startPage}" end="${endPage}">
	<c:if test="${i < pageIndex}">
		<c:choose>
			<c:when test="${seo == true }">
				<link rel="prev" href="<c:url value="${url}${i}/" />">
			</c:when>
			<c:otherwise>
				<link rel="prev" href="<c:url value="${url}&pageIndex=${i}" />">
			</c:otherwise>
		</c:choose>
	</c:if>
	<c:if test="${i > pageIndex}">
		<c:choose>
			<c:when test="${seo == true }">
				<link rel="next" href="<c:url value="${url}${i}/" />">
			</c:when>
			<c:otherwise>
				<link rel="next" href="<c:url value="${url}&pageIndex=${i}" />">
			</c:otherwise>
		</c:choose>
	</c:if>
</c:forEach>
