<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <!-- 上述3个meta标签*必须*放在最前面，任何其他内容都*必须*跟随其后！ -->
    <!--为了确保适当的绘制和触屏缩放，需要在 <head> 之中添加 viewport 元数据标签。-->
    <title>班级开设课程</title>

    <!-- Bootstrap -->
    <link href="css/bootstrap.min.css" rel="stylesheet">
    <link href="css/style.css" rel="stylesheet">

    <!-- jQuery (Bootstrap 的所有 JavaScript 插件都依赖 jQuery，所以必须放在前边) -->
    <script src="js/jquery-3.5.1.min.js"></script>
    <!-- 加载 Bootstrap 的所有 JavaScript 插件。你也可以根据需要只加载单个插件。 -->
    <script src="js/bootstrap.min.js"></script>
    <script src="js/time.js" type="text/javascript"></script>
    <script src="js/panel.js" type="text/javascript"></script>
</head>
<body>
<!--横向导航栏-->
<nav class="navbar navbar-inverse navbar-fixed-top">
    <div class="container-fluid">
        <div class="navbar-header">
            <a class="navbar-brand" href="index.jsp">成绩管理系统(ZJUT GMS)</a>
        </div>
        <div class="collapse navbar-collapse" id="bs-example-navbar-collapse-1">
            <!--时间显示-->
            <ul class="nav navbar-nav navbar-left">
                <li>
                    <div class="nav navbar-nav" id="displaydate"></div>
                </li>
                <li>
                    <div class="nav navbar-nav" id="displaytime"></div>
                </li>
            </ul>
            <ul class="nav navbar-nav navbar-right">
                <form class="navbar-form navbar-left">
                    <div class="form-group">
                        <input type="text" class="form-control" placeholder="搜索">
                    </div>
                    <button type="submit" class="btn btn-default">
                        <span class="glyphicon glyphicon-search" aria-hidden="true"></span>
                    </button>
                </form>
                <li><a href="#">常见问题</a></li>
                <li class="dropdown">
                    <a href="#" class="dropdown-toggle" data-toggle="dropdown" role="button"
                       aria-haspopup="true" aria-expanded="false">简体中文 <span class="caret"></span></a>
                    <ul class="dropdown-menu">
                        <li><a href="#">繁体中文</a></li>
                        <li><a href="#">英文</a></li>
                    </ul>
                </li>
                <li><a href="#"><span class="glyphicon glyphicon-envelope" aria-hidden="true"></span> 消息</a></li>
                <li><a href="#"><span class="glyphicon glyphicon-user" aria-hidden="true"></span> admin</a></li>
                <li><a href="login.html"><span class="glyphicon glyphicon-log-out" aria-hidden="true"></span> 退出</a>
                </li>
            </ul>
        </div><!-- /.navbar-collapse -->
    </div><!-- /.container-fluid -->
</nav>
<!--内容区-->
<div class="container-fluid content">
    <div class="row">
        <!--侧边导航栏-->
        <div class="col-md-2">
            <div class="panel-group" id="panelContainer">
                <c:choose>
                    <c:when test="${'管理员'.equals(param.role)}">
                        <div class="panel panel-default">
                            <div id="header15" class="panel-heading" data-toggle="collapse" data-target="#sub15"
                                 data-parent="#panelContainer">
                                <i class="glyphicon glyphicon-asterisk"></i>
                                <a href="#">系统管理</a>
                                <span class="glyphicon glyphicon-triangle-right pull-right"></span>
                            </div>
                            <div id="sub15" class="collapse panel-collapse">
                                <div class="panel-body">
                                    <ul class="nav">
                                        <li>
                                            <a href="manageServlet?role=${param.role}&manage=classes">
                                                <span class="glyphicon glyphicon-th-list"></span>班级管理</a>
                                        </li>
                                        <li>
                                            <a href="manageServlet?role=${param.role}&manage=major">
                                                <span class="glyphicon glyphicon-th-list"></span>专业管理</a>
                                        </li>
                                        <li>
                                            <a href="manageServlet?role=${param.role}&manage=course">
                                                <span class="glyphicon glyphicon-th-list"></span>课程管理</a>
                                        </li>
                                    </ul>
                                </div>
                            </div>
                        </div>
                        <div class="panel panel-default">
                            <div id="header8" class="panel-heading" data-toggle="collapse" data-target="#sub8"
                                 data-parent="#panelContainer">
                                <i class="glyphicon glyphicon-asterisk"></i>
                                <a href="#">师生管理</a>
                                <span class="glyphicon glyphicon-triangle-right pull-right"></span>
                            </div>
                            <div id="sub8" class="collapse panel-collapse">
                                <div class="panel-body">
                                    <ul class="nav">
                                        <li>
                                            <a href="manageServlet?role=${param.role}&manage=teacher">
                                                <span class="glyphicon glyphicon-th-list"></span>教师管理</a>
                                        </li>
                                        <li>
                                            <a href="manageServlet?role=${param.role}&manage=student">
                                                <span class="glyphicon glyphicon-th-list"></span>学生管理</a>
                                        </li>
                                    </ul>
                                </div>
                            </div>
                        </div>
                    </c:when>
                    <c:when test="${'教师'.equals(param.role)}">
                        <div class="panel panel-default">
                            <div id="header10" class="panel-heading" data-toggle="collapse" data-target="#sub10"
                                 data-parent="#panelContainer">
                                <i class="glyphicon glyphicon-search"></i>
                                <a href="#">信息查询</a>
                                <span class="glyphicon glyphicon-triangle-right pull-right"></span>
                            </div>
                            <div id="sub10" class="collapse panel-collapse">
                                <div class="panel-body">
                                    <ul class="nav">
                                        <li>
                                            <a href="teacherServlet?no=${param.no}&role=${param.role}&query=info"><span
                                                    class="glyphicon glyphicon-qrcode"></span>个人信息</a>
                                        </li>
                                        <li>
                                            <a href="teacherServlet?no=${param.no}&role=${param.role}&query=teach">
                                                <span class="glyphicon glyphicon-leaf"></span>任课信息</a>
                                        </li>
                                    </ul>
                                </div>
                            </div>
                        </div>
                        <div class="panel panel-default">
                            <div id="header23" class="panel-heading" data-toggle="collapse" data-target="#sub23"
                                 data-parent="#panelContainer">
                                <i class="glyphicon glyphicon-plus"></i>
                                <a href="#">学生查询</a>
                                <span class="glyphicon glyphicon-triangle-right pull-right"></span>
                            </div>
                            <div id="sub23" class="collapse panel-collapse">
                                <div class="panel-body">
                                    <ul class="nav">
                                        <li>
                                            <a href="studentListServlet?no=${param.no}&role=${param.role}&query=grade"><span
                                                    class="glyphicon glyphicon-qrcode"></span>成绩统计</a>
                                        </li>
                                        <li>
                                            <a href="studentListServlet?no=${param.no}&role=${param.role}&query=gpa">
                                                <span class="glyphicon glyphicon-upload"></span>GPA统计</a>
                                        </li>
                                    </ul>
                                </div>
                            </div>
                        </div>
                        <div class="panel panel-default">
                            <div id="header22" class="panel-heading" data-toggle="collapse" data-target="#sub22"
                                 data-parent="#panelContainer">
                                <i class="glyphicon glyphicon-search"></i>
                                <a href="#">课程查询</a>
                                <span class="glyphicon glyphicon-triangle-right pull-right"></span>
                            </div>
                            <div id="sub22" class="collapse panel-collapse">
                                <div class="panel-body">
                                    <ul class="nav">
                                        <li>
                                            <a href="studentListServlet?no=${param.no}&role=${param.role}&query=courseAvg">
                                                <span class="glyphicon glyphicon-upload"></span>课程平均成绩</a>
                                        </li>
                                        <li>
                                            <a href="studentListServlet?no=${param.no}&role=${param.role}&query=classCourse">
                                                <span class="glyphicon glyphicon-leaf"></span>班级开设课程</a>
                                        </li>
                                    </ul>
                                </div>
                            </div>
                        </div>
                    </c:when>
                    <c:when test="${'学生'.equals(param.role)}">
                        <div class="panel panel-default">
                            <div id="header14" class="panel-heading" data-toggle="collapse" data-target="#sub14"
                                 data-parent="#panelContainer">
                                <i class="glyphicon glyphicon-plus"></i>
                                <a href="#">信息查询</a>
                                <span class="glyphicon glyphicon-triangle-right pull-right"></span>
                            </div>
                            <div id="sub14" class="collapse panel-collapse">
                                <div class="panel-body">
                                    <ul class="nav">
                                        <li>
                                            <a href="studentServlet?no=${param.no}&role=${param.role}&query=info"><span
                                                    class="glyphicon glyphicon-qrcode"></span>个人信息</a>
                                        </li>
                                        <li>
                                            <a href="studentServlet?no=${param.no}&role=${param.role}&query=grade">
                                                <span class="glyphicon glyphicon-upload"></span>成绩查询</a>
                                        </li>
                                    </ul>
                                </div>
                            </div>
                        </div>
                    </c:when>
                </c:choose>
                <div class="panel panel-default">
                    <div id="header1" class="panel-heading" data-toggle="collapse" data-target="#sub1"
                         data-parent="#panelContainer">
                        <i class="glyphicon glyphicon-education"></i>
                        <a href="#">学生事务</a>
                        <span class="glyphicon glyphicon-triangle-right pull-right"></span>
                    </div>
                    <div id="sub1" class="collapse panel-collapse">
                        <div class="panel-body">
                            <ul class="nav">
                                <li>
                                    <a href=""><span class="glyphicon glyphicon-edit"></span>信息维护</a>
                                </li>
                                <li>
                                    <a href=""><span class="glyphicon glyphicon-th-list"></span>成绩查询</a>
                                </li>
                                <li>
                                    <a href=""><span class="glyphicon glyphicon-th-large">培养计划</span></a>
                                </li>
                            </ul>
                        </div>
                    </div>
                </div>
                <div class="panel panel-default">
                    <div id="header2" class="panel-heading" data-toggle="collapse" data-target="#sub2"
                         data-parent="#panelContainer">
                        <i class="glyphicon glyphicon-list-alt"></i>
                        <a href="#">公共查询</a>
                        <span class="glyphicon glyphicon-triangle-right pull-right"></span>
                    </div>
                    <div id="sub2" class="collapse panel-collapse">
                        <div class="panel-body">
                            <ul class="nav">
                                <li>
                                    <a href=""><span class="glyphicon glyphicon-calendar"></span>校历查询</a>
                                </li>
                                <li>
                                    <a href="#"><span class="glyphicon glyphicon-bed"></span>校车查询</a>
                                </li>
                                <li>
                                    <a href="#"><span class="glyphicon glyphicon-th"></span>教室查询</a>
                                </li>
                            </ul>
                        </div>
                    </div>
                </div>
                <div class="panel panel-default">
                    <div id="header3" class="panel-heading" data-toggle="collapse" data-target="#sub3"
                         data-parent="#panelContainer">
                        <i class="glyphicon glyphicon-off"></i>
                        <a href="#">业务办理</a>
                        <span class="glyphicon glyphicon-triangle-right pull-right"></span>
                    </div>
                    <div id="sub3" class="collapse panel-collapse">
                        <div class="panel-body">
                            <ul class="nav">
                                <li>
                                    <a href=""><span class="glyphicon glyphicon-qrcode"></span>学生缴费</a>
                                </li>
                                <li>
                                    <a href="#"><span class="glyphicon glyphicon-file"></span>学生选课</a>
                                </li>
                                <li>
                                    <a href="#"><span class="glyphicon glyphicon-tags"></span>课程评估</a>
                                </li>
                            </ul>
                        </div>
                    </div>
                </div>
                <div class="panel panel-default">
                    <div id="header4" class="panel-heading" data-toggle="collapse" data-target="#sub4"
                         data-parent="#panelContainer">
                        <i class="glyphicon glyphicon-book"></i>
                        <a href="#">科学研究</a>
                        <span class="glyphicon glyphicon-triangle-right pull-right"></span>
                    </div>
                    <div id="sub4" class="collapse panel-collapse">
                        <div class="panel-body">
                            <ul class="nav">
                                <li>
                                    <a href="#"><span class="glyphicon glyphicon-eye-open"></span>科研项目</a>
                                </li>
                                <li>
                                    <a href="#"><span class="glyphicon glyphicon-leaf"></span>科研合作</a>
                                </li>
                                <li>
                                    <a href="#"><span class="glyphicon glyphicon-comment"></span>学术交流</a>
                                </li>
                            </ul>
                        </div>
                    </div>
                </div>
                <div class="panel panel-default">
                    <div id="header5" class="panel-heading" data-toggle="collapse" data-target="#sub5"
                         data-parent="#panelContainer">
                        <i class="glyphicon glyphicon-gift"></i>
                        <a href="#">生活服务</a>
                        <span class="glyphicon glyphicon-triangle-right pull-right"></span>
                    </div>
                    <div id="sub5" class="collapse panel-collapse">
                        <div class="panel-body">
                            <ul class="nav">
                                <li>
                                    <a href="#"><span class="glyphicon glyphicon-phone"></span>网络服务</a>
                                </li>
                                <li>
                                    <a href="#"><span class="glyphicon glyphicon-queen"></span>文体活动</a>
                                </li>
                                <li>
                                    <a href="#"><span class="glyphicon glyphicon-file"></span>校园卡</a>
                                </li>
                            </ul>
                        </div>
                    </div>
                </div>
                <div class="panel panel-default">
                    <div id="header6" class="panel-heading" data-toggle="collapse" data-target="#sub6"
                         data-parent="#panelContainer">
                        <i class="glyphicon glyphicon-flag"></i>
                        <a href="#">相关部门</a>
                        <span class="glyphicon glyphicon-triangle-right pull-right"></span>
                    </div>
                    <div id="sub6" class="collapse panel-collapse">
                        <div class="panel-body">
                            <ul class="nav">
                                <li>
                                    <a href="#"><span class="glyphicon glyphicon-random"></span>学工部</a>
                                </li>
                                <li>
                                    <a href="#"><span class="glyphicon glyphicon-inbox"></span>团委</a>
                                </li>
                                <li>
                                    <a href="#"><span class="glyphicon glyphicon-bookmark"></span>学生就业指导中心</a>
                                </li>
                            </ul>
                        </div>
                    </div>
                </div>
            </div>
        </div>
        <!--主体内容-->
        <!--路径导航-->
        <div class="col-md-8 col-md-offset-1">
            <ol class="breadcrumb">
                <li><a href=""><label class="breadcrumbFont1">首页</label></a></li>
                <li><a href=""><label class="breadcrumbFont1">课程查询</label></a></li>
                <li class="active"><label class="breadcrumbFont2">班级开设课程</label></li>
            </ol>
        </div>
        <!--信息表格-->
        <div class="col-md-8 col-md-offset-1 table-responsive">
            <form class="form-inline" action="studentListServlet?&role=${param.role}&query=condition"
                  method="post">
                <div class="form-group">
                    <label for="inputClass">班级名称</label>
                    <input type="text" class="form-control" name="cj_ClassNo02" value="${condition.cj_Sname02[0]}"
                           id="inputClass">
                </div>
                <div class="form-group">
                    <label for="inputCourse">课程名称</label>
                    <input type="text" class="form-control" name="cj_Cname02" value="${condition.cj_Cname02[0]}"
                           id="inputCourse">
                </div>
                <button type="submit" class="btn btn-default btn-success">查询</button>
            </form>
            <c:if test="${empty requestScope.classCourseList}">
                <h3 style="margin-top: 20px;text-align: center">未查找到数据</h3>
            </c:if>
            <c:if test="${!empty requestScope.classCourseList}">
                <table class="table table-striped table-hover" class="data-table" style="margin-top: 20px">
                    <tr class="success">
                        <th>班级编号</th>
                        <th>班级名称</th>
                        <th>课程编号</th>
                        <th>课程名称</th>
                        <th>学时</th>
                        <th>考试或考查</th>
                        <th>学分</th>
                    </tr>
                    <c:forEach var="course" items="${requestScope.classCourseList}"
                               varStatus="status">
                        <%--为奇数行和偶数行设置不同的背景颜色--%>
                        <c:if test="${status.count%2==0}">
                            <tr style="background: #eeeeff">
                        </c:if>
                        <c:if test="${status.count%2!=0}">
                            <tr style="background: #dedeff">
                        </c:if>
                        <%--用EL访问作用域变量的成员--%>
                        <td>${course.classNo}</td>
                        <td>${course.className}</td>
                        <td>${course.courseNo}</td>
                        <td>${course.courseName}</td>
                        <td>${course.hour}</td>
                        <td>${course.type}</td>
                        <td>${course.credit}</td>
                        </tr>
                    </c:forEach>
                </table>
            </c:if>
        </div>
        <!--分页-->
        <c:if test="${!empty requestScope.courseList}">
            <nav aria-label="Page navigation" class="pag-right">
                <ul class="pagination">
                    <li class="disabled">
                        <a href="#" aria-label="Previous">
                            <span aria-hidden="true">&laquo;</span>
                        </a>
                    </li>
                    <li class="active"><a href="#">1</a></li>
                    <li><a href="#">2</a></li>
                    <li><a href="#">3</a></li>
                    <li><a href="#">4</a></li>
                    <li><a href="#">5</a></li>
                    <li>
                        <a href="#" aria-label="Next">
                            <span aria-hidden="true">&raquo;</span>
                        </a>
                    </li>
                </ul>
            </nav>
        </c:if>
    </div>
</div>
</body>
</html>