<%-- 
    Document   : home
    Created on : Jun 23, 2022, 9:32:11 PM
    Author     : ACER
--%>


<%@page import="Dao.LichThucHanhDAO"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/functions" prefix = "fn" %>
<%@ page language="java" contentType="text/html; charset=utf-8"
         pageEncoding="utf-8"%>

<div class="row">

    <div class="col-sm-12">
        <section class="panel">

            <header class="panel-heading">
                <span >Lịch thực hành của giảng viên: <span style="color: #009be3">${taikhoan.tenTK}</span></span>
            </header>
            <div class="panel-body">
                <section id="unseen">
                    <table class="table table-bordered table-striped table-condensed">
                        <thead>
                            <tr>
                                <th>Lớp</th>
                                <th>Môn Học</th>
                                <th>Thứ</th>
                                <th>Từ tiết</th>
                                <th>Đến tiết</th>
                                <th>Phòng</th>
                            </tr>
                        </thead>
                        <tbody>
                            <c:if test = "${fn:length(data) == 0}">
                                <tr><td colspan="6">Không tìm thấy!</td></tr>
                            </c:if>
                            <c:forEach items="${data}" var="o" varStatus="loop">
                                <tr>
                                    <td>${o.maLHP}</td>
                                    <c:set var="maLHP" value="${o.maLHP}"/>
                                    <td>
                                        <% 
                                            String id = (String) pageContext.getAttribute("maLHP");
                                            LichThucHanhDAO daoLTH = new LichThucHanhDAO();
                                            String tenmh = daoLTH.selectMHBYLHP(id);
                                            request.setAttribute("tenmh", tenmh);
                                        %>
                                        ${tenmh}
                                    </td>
                                    <td>${o.thu}</td>
                                    <td>${o.tietBatDau}</td>
                                    <td>${o.tietKetThuc}</td>
                                    <td>${o.maPhongMay}</td>
                                </tr>
                            </c:forEach>
                        </tbody>
                    </table>
                </section>
            </div>
        </section>

    </div> 
</div>
