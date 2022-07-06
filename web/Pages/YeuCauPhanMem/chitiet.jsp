<%-- 
    Document   : xoa
    Created on : Jun 17, 2022, 9:07:05 PM
    Author     : ACER
--%>

<%@page import="Dao.GiaoVienDAO"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/functions" prefix = "fn" %>
<%@ page language="java" contentType="text/html; charset=utf-8"
         pageEncoding="utf-8"%>
<div class="col-lg-12">
    <section class="panel">
        <header class="panel-heading " style="background: white;padding-left: 30px">
            <img src="public/web/images/logo-truong-250.png" alt="" style="max-width: 50px;max-height: 50px;display: inline-block;">
            <span style="font-weight: 700;">Phiếu yêu cầu cập nhật phần mềm</span>
        </header>

        <div class="panel-body">
            <div class="form-group">
                <label class="col-sm-3 control-label col-lg-3">Ngày gửi : </label>
                <span>${dateNowConv}</span>
            </div>

            <div class="form-group">
                <label class="col-sm-3 control-label col-lg-3">Người gửi : </label>
                <c:set var="maGV" value="${phieuyeucau.maGV}"/>
                <%
                    String id = (String) pageContext.getAttribute("maGV");
                    GiaoVienDAO daoGV = new GiaoVienDAO();
                    String ten = daoGV.getGiaoVien(id).tenGV;

                    request.setAttribute("tengv", ten);
                %>
                <span>${tengv}</span>
            </div>

            <div class="form-group">
                <label class="col-sm-3 control-label col-lg-3">Phòng học : </label>
                <span>${phieuyeucau.maPhongMay}</span>
            </div>

            <div class="form-group">
                <label class="col-sm-3 control-label col-lg-3">Ghi chú : </label>
                <span>${phieuyeucau.ghiChu}</span>
            </div>
            <div class="col-lg-10">
                <table class="table col-lg-10">
                    <thead>
                        <tr style="background: #eee">
                            <th>STT</th>
                            <th>Tên Phần Mềm</th>
                            <th>Đường Link Tới File Cài Đặt</th>
                            <th>Tình Trạng</th>
                        </tr>
                    </thead>
                    <tbody>
                        <c:forEach items="${listYC}" var="o" varStatus="loop">
                            <tr>
                                <td>${loop.index + 1}</td>
                                <td>${o.tenPhanMem}</td>
                                <td>${o.linkFile}</td>
                                <td>
                                    <c:if test="${o.trangThai == 1}">
                                        Đã duyệt
                                    </c:if>
                                    <c:if test="${o.trangThai == 0}">
                                        Chưa duyệt
                                    </c:if>
                                    <c:if test="${o.trangThai == 2}">
                                        Từ chối
                                    </c:if>
                                </td>
                            </tr>
                        </c:forEach>
                    </tbody>
                </table>
            </div>
            <div class="form-group col-lg-10">
                <button type="submit" class="btn btn-danger " style="float: right;background: red" onclick="window.opener = null; window.close(); return false;">Đóng</button>
            </div>
    </section>

</div>
