<!DOCTYPE html>
<html lang="en" class="no-js">

    <head>
        <title>${companyName} - Login</title>
        <meta charset="utf-8" />

        <meta name="viewport" content="width=device-width, initial-scale=1.0, user-scalable=0, minimum-scale=1.0, maximum-scale=1.0">
        <meta name="apple-mobile-web-app-capable" content="yes">
        <meta name="apple-mobile-web-app-status-bar-style" content="black">
        <meta content="" name="description" />
        <meta content="" name="author" />

        <link rel="stylesheet" type="text/css" href="/static/js/plugins/bootstrap/css/bootstrap.min.css"/>
        <link rel="stylesheet" type="text/css" href="/static/js/plugins/font-awesome/css/font-awesome.min.css"/>
        <link rel="stylesheet" type="text/css" href="/static/css/fonts/style.css"/>
        <link rel="stylesheet" type="text/css" href="/static/css/main.css"/>
        <link rel="stylesheet" type="text/css" href="/static/css/css/main-responsive.css"/>
        <link rel="stylesheet" type="text/css" href="/static/js/plugins/iCheck/skins/all.css"/>
        <link rel="stylesheet" type="text/css" href="/static/js/plugins/bootstrap-colorpalette/css/bootstrap-colorpalette.css"/>
        <link rel="stylesheet" type="text/css" href="/static/js/plugins/perfect-scrollbar/src/perfect-scrollbar.css"/>
        <link rel="stylesheet" type="text/css" href="/static/css/css/theme_light.css"/>
        <link rel="stylesheet" type="text/css" href="/static/css/css/print.css" media="print"/>

    </head>
    <body class="login example2">
    <div class="main-login col-sm-4 col-sm-offset-4" style="display: block;">
        <div class="logo">${applicationName}<i class="clip-clip"></i></div>
        <div class="box-login">
            <h3>Sign in to your account</h3>
            <p>
                Please enter your name and password to log in.
            </p>
            <form name="loginform" action="authenticateUser" method="post" class="form-login">
                <fieldset>
                    <div class="form-group">
                                <span class="input-icon">
                                    <input type="text" class="form-control" placeholder="Username" name="userCode">
                                    <i class="fa fa-user"></i> </span>
                    </div>
                    <div class="form-group form-actions">
                                <span class="input-icon">
                                    <input type="password" class="form-control" placeholder="Password" name="password">
                                    <i class="fa fa-lock"></i>
                                    <a class="forgot" href="#">
                                        I forgot my password
                                    </a> </span>
                    </div>
                    <div class="form-actions">
                        <label for="remember" class="checkbox-inline">
                            <input type="checkbox" class="grey remember" id="remember" name="remember">
                            Keep me signed in
                        </label>
                        <button type="submit" class="btn btn-bricky pull-right">
                            Login <i class="fa fa-arrow-circle-right"></i>
                        </button>
                    </div>
                </fieldset>
            </form>
        </div>

        <div class="copyright">
            ${copyRightText}
        </div>
    </div>
    <script src="/static/js/jquery-2.2.0.min.js"></script>

    <script src="/static/js/jquery.wizard.min.js"></script>

    <script src="/static/js/plugins/jquery-ui/jquery-ui-1.10.2.custom.min.js"></script>
    <script src="/static/js/plugins/bootstrap/js/bootstrap.min.js"></script>
    <script src="/static/js/plugins/bootstrap-hover-dropdown/bootstrap-hover-dropdown.min.js"></script>
    <script src="/static/js/plugins/blockUI/jquery.blockUI.js"></script>
    <script src="/static/js/plugins/iCheck/jquery.icheck.min.js"></script>
    <script src="/static/js/plugins/perfect-scrollbar/src/jquery.mousewheel.js"></script>
    <script src="/static/js/plugins/perfect-scrollbar/src/perfect-scrollbar.js"></script>
    <script src="/static/js/plugins/less/less-1.5.0.min.js"></script>
    <script src="/static/js/plugins/jquery-cookie/jquery.cookie.js"></script>
    <script src="/static/js/plugins/bootstrap-colorpalette/js/bootstrap-colorpalette.js"></script>
    <script src="/static/js/js/main.js"></script>
    <script src="/static/js/plugins/flot/jquery.flot.js"></script>
    <script src="/static/js/plugins/flot/query.flot.resize.min.js"></script>
    <script src="/static/js/plugins/flot/jquery.flot.resize.min.js"></script>
    <script src="/static/js/plugins/jquery.sparkline/jquery.sparkline.js"></script>
    <script src="/static/js/plugins/jquery-easy-pie-chart/jquery.easy-pie-chart.js"></script>
    <script src="/static/js/plugins/jquery-ui-touch-punch/jquery.ui.touch-punch.min.js"></script>

    <script>
        jQuery(document).ready(function(){

            Main.init();
            //Index.init();

        });
    </script>
    </body>

</html>