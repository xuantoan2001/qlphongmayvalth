<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
    <head>
        <title>Đăng nhập</title>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <!--===============================================================================================-->	
        <link rel="icon" type="image/png" href="public/login/images/icons/favicon.ico"/>
        <!--===============================================================================================-->
        <link rel="stylesheet" type="text/css" href="public/login/vendor/bootstrap/css/bootstrap.min.css">
        <!--===============================================================================================-->
        <link rel="stylesheet" type="text/css" href="public/login/fonts/font-awesome-4.7.0/css/font-awesome.min.css">
        <!--===============================================================================================-->
        <link rel="stylesheet" type="text/css" href="public/login/fonts/Linearicons-Free-v1.0.0/icon-font.min.css">
        <!--===============================================================================================-->
        <link rel="stylesheet" type="text/css" href="public/login/vendor/animate/animate.css">
        <!--===============================================================================================-->	
        <link rel="stylesheet" type="text/css" href="public/login/vendor/css-hamburgers/hamburgers.min.css">
        <!--===============================================================================================-->
        <link rel="stylesheet" type="text/css" href="public/login/vendor/animsition/css/animsition.min.css">
        <!--===============================================================================================-->
        <link rel="stylesheet" type="text/css" href="public/login/vendor/select2/select2.min.css">
        <!--===============================================================================================-->	
        <link rel="stylesheet" type="text/css" href="public/login/vendor/daterangepicker/daterangepicker.css">
        <!--===============================================================================================-->
        <link rel="stylesheet" type="text/css" href="public/login/css/util.css">
        <link rel="stylesheet" type="text/css" href="public/login/css/main.css">
        <!--===============================================================================================-->
    </head>
    <body style="background-color: #666666;">

        <div class="limiter" style="max-height: 1000px;max-with: 1000px">
            <div class="container-login100">
                <div class="wrap-login100">

                    <form class="login100-form validate-form" method="post">

                        <img id="logo" src="public/login/images/logo-truong-250.png"/>

                        <span class="login100-form-title p-b-43">
                            <h3 style="font-family: arial">Quản lý phòng máy và lịch thực hành</h3>
                        </span>


                        <div class="wrap-input100 validate-input" data-validate = "Email phải có dạng: ex@abc.xyz">
                            <input class="input100" type="text" name="email">
                            <span class="focus-input100"></span>
                            <span class="label-input100">Email</span>
                        </div>


                        <div class="wrap-input100 validate-input" data-validate="Mật khẩu không được để trống">
                            <input class="input100" type="password" name="password">
                            <span class="focus-input100"></span>
                            <span class="label-input100">Mật khẩu</span>
                        </div>

                        <div class="flex-sb-m w-full p-t-3 p-b-32">
                            <div class="contact100-form-checkbox">
                                <input class="input-checkbox100" id="ckb1" type="checkbox" name="remember-me">

                            </div>
                        </div>

                        <div class="container-login100-form-btn">
                            <button class="login100-form-btn" type="submit">
                                Đăng nhập
                            </button>
                        </div>
                    </form>

                    <div class="login100-more" style="background-image: url('public/login/images/background1.jpg');">
                    </div>
                </div>
            </div>
        </div>
        <!--===============================================================================================-->
        <script src="public/login/vendor/jquery/jquery-3.2.1.min.js"></script>
        <!--===============================================================================================-->
        <script src="public/login/vendor/animsition/js/animsition.min.js"></script>
        <!--===============================================================================================-->
        <script src="public/login/vendor/bootstrap/js/popper.js"></script>
        <script src="public/login/vendor/bootstrap/js/bootstrap.min.js"></script>
        <!--===============================================================================================-->
        <script src="public/login/vendor/select2/select2.min.js"></script>
        <!--===============================================================================================-->
        <script src="public/login/vendor/daterangepicker/moment.min.js"></script>
        <script src="public/login/vendor/daterangepicker/daterangepicker.js"></script>
        <!--===============================================================================================-->
        <script src="public/login/vendor/countdowntime/countdowntime.js"></script>
        <!--===============================================================================================-->
        <script src="public/login/js/main.js"></script>
        <script>
            if ("${Message}" != "")
                alert('${Message}');
            if ("${Message}" == "Đăng nhập thành công")
                window.location.href = "./home";
        </script>
    </body>
</html>