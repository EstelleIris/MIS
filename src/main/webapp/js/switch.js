$(function () {
    $('#teacher').click(function(){
        $('#teacher').removeClass("student").addClass('teacher');
    });
    $('#student').click(function(){
        $('#student').removeClass("teacher").addClass('student');
    });
});