<%-- 
    Document   : them
    Created on : Jun 17, 2022, 9:06:44 PM
    Author     : ACER
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<div class="col-lg-12">
    <section class="panel">
        <header class="panel-heading " style="background: white;padding-left: 30px">
            <img src="public/web/images/logo-truong-250.png" alt="" style="max-width: 50px;max-height: 50px;display: inline-block;">
            <span style="font-weight: 700;"> Đăng ký cập nhật phần mềm</span>
        </header>

        <div class="panel-body">
            <div class="">
                <form role="form" method="post" action="./yeu-cau-phan-mem?action=them">

                    <div class="form-group">
                        <label class="col-sm-3 control-label col-lg-3">Ngày đăng ký : </label>
                        <span>${dateNowConv}</span>
                        <input type="text" class="form-control hide" name="ngayGui" value="${dateNow}">
                    </div>
                    <input class="hidden" name="maGV" value="${taikhoan.IDTK}"/>
                    <div class="form-group">
                        <label class="col-sm-3 control-label col-lg-3">Phòng học : </label>
                        <select id="maPM" name="maPhongMay" class=" col-lg-2" onchange="myFunction(event)">
                            <c:forEach items="${listPhongMay}" var="i" varStatus="loop">

                                <option class="" value="${i.maPhongMay}">${i.maPhongMay}</option>
                            </c:forEach>
                        </select>
                        <input id="phongmay" type="text" class="form-control hide" name="phongMay" value="PMT1">
                    </div>

                    <label class="control-label col-lg-12" style="display: block;padding: 15px">Phần mềm yêu cầu: </label>

                    <div id="pmyc" class="panel-body col-lg-10" style="background: #fafafa;padding: 15px;overflow: auto;display: block">
                        <div class="col-lg-12 form-group " id="pm1">
                            <div class=" col-lg-5"">
                                <label class="" for="" >Tên phần mềm: </label>
                                <input name="tenPM"  class="form-control" id="exampleInputEmail2"  placeholder="Nhập tên phần mềm" required>
                            </div>
                            <div class=" col-lg-5" >
                                <label class="" for="">Đường Link tới file cài đặt(Nếu có): </label>
                                <input name="linkCaiDat"  class="form-control" id="exampleInputPassword2" placeholder="Link tới file cài đặt">
                            </div>
                        </div>

                        <div class=" col-lg-10" style="padding-right: 30px">
                            <button id="add_pm" class="btn btn-primary " style="float: right;" >
                                Thêm phần mềm <i class="fa fa-plus"></i>
                            </button>
                        </div>
                    </div>


                    <div class="form-group col-lg-12" style="padding: 15px">
                        <label class="col-sm-3 control-label col-lg-3" style="padding: 15px">Ghi chú :</label>
                        <textarea class="col-lg-5 " rows="3" name="ghiChu"></textarea>
                    </div>
                    <div class="form-group col-lg-8">
                        <button type="submit" class="btn btn-info " style="float: right;background: #3782f5">Đăng ký</button>
                    </div>
                </form>
            </div>

        </div>
    </section>

</div>
<div class="pm hide">
    <div class="col-lg-12 form-group new-pm">
        <div class=" col-lg-5"">
            <label class="" for="" >Tên phần mềm: </label>
            <input name="tenPM"  class="form-control" id="exampleInputEmail2" placeholder="Nhập tên phần mềm" required>
            
        </div>
        <div class=" col-lg-5" >
            <label class="" for="">Đường Link tới file cài đặt(Nếu có): </label>
            <input name="linkCaiDat"  class="form-control" id="exampleInputPassword2"  placeholder="Link tới file cài đặt">
        </div>
        <div class=" col-lg-2" >
            <label class="" for=""> </label>
            <button  type="button" class="form-control btn btn-round btn-danger" style="background: red" onclick="this.parentElement.parentElement.remove()">Xóa</button>
        </div>
    </div>
</div>
<script>

    function myFunction(e) {

        document.getElementById("phongmay").value = e.target.value
    }
</script>
