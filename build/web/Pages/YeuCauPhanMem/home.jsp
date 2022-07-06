<%-- 
    Document   : home
    Created on : Jun 17, 2022, 8:35:39 PM
    Author     : ACER
--%>
<%@page import="Dao.PhieuYeuCauPhanMemDAO"%>
<%@page import="java.util.ArrayList"%>
<%@page import="java.sql.Array"%>
<%@page import="java.util.List"%>
<%@page import="Dao.ChiTietYeuCauDAO"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/functions" prefix = "fn" %>
<%@ page language="java" contentType="text/html; charset=utf-8"
         pageEncoding="utf-8"%>
<!-- page start-->

<div class="row">

    <div class="col-sm-12">
        <div style="float: right;margin-top: 10px" >
            <a id="editable-sample_new" class="btn btn-primary"  href="./yeu-cau-phan-mem?action=dang-ky">
                Đăng ký mới <i class="fa fa-plus"></i>
            </a>
        </div>
        <section class="panel">

            <header class="panel-heading">
                <span >Danh sách yêu cầu phần mềm </span>


            </header>
            <div class="panel-body">
                <section id="unseen">
                    <table class="table table-bordered table-striped table-condensed">
                        <thead>
                            <tr>
                                <th>STT</th>
                                <th>NGÀY GỬI</th>
                                <th>NGƯỜI GỬI</th>
                                <th>MÃ PHÒNG MÁY</th>
                                <th>GHI CHÚ</th>
                                <th>THAO TÁC</th>
                            </tr>
                        </thead>
                        <tbody>
                            <c:if test = "${fn:length(data) == 0}">
                                <tr><td colspan="6">Bạn chưa gửi yêu cầu nào</td></tr>
                            </c:if>
                            <c:forEach items="${data}" var="o" varStatus="loop">
                                <tr>
                                    <td scope="row">${loop.index + 1}</th>
                                    <td>${o.ngayGui}</td>
                                    <td>${taikhoan.tenTK}</td>
                                    <td>${o.maPhongMay}</td>
                                    <td>${o.ghiChu}</td>
                                    <td>
                                        <form class="col-lg-3" method="post" action="./yeu-cau-phan-mem?action=chi-tiet" target="_blank">
                                            <input class="hidden" name="maPhieuYC" value="${o.maPhieuYC}"/>
                                            <button class="btn btn-light px-2 mr-2"><i class="fa fa-eye"></i> Xem Chi Tiết</button> 
                                        </form>
                                        <c:set var="maPhieu" value="${o.maPhieuYC}"/>

                                        <%
                                            String id = (String) pageContext.getAttribute("maPhieu");
                                            PhieuYeuCauPhanMemDAO daoYCPM = new PhieuYeuCauPhanMemDAO();
                                            int ck = daoYCPM.checkEdit(id);
                                            request.setAttribute("ck", ck);
                                        %>
                                        <c:if test="${ck == 0 }">
                                            <form class="col-lg-2" method="post" action="./yeu-cau-phan-mem?action=sua">
                                                <input class="hidden" name="maPhieuYC" value="${o.maPhieuYC}"/>
                                                <button class="btn btn-light px-2 mr-2"><i class="fa fa-edit"></i> Sửa</button> 
                                            </form>
                                            <form class="col-lg-2" method="post" action="./yeu-cau-phan-mem?action=xoa">
                                                <input class="hidden" name="maPhieuYC" value="${o.maPhieuYC}"/>
                                                <button class="btn btn-danger px-2 mr-2"><i class="fa  fa-trash-o"></i> Xóa</button> 
                                            </form>
                                        </c:if>
                                    </td>
                                </tr>
                            </c:forEach>
                        </tbody>
                    </table>
                </section>
            </div>
        </section>

    </div> 
</div>
<!-- page end-->
