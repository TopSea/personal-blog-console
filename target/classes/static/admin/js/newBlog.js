var E = window.wangEditor
var editor = new E('#editor')
var blogId=document.getElementById("blogId");
var blogTitle=document.getElementById("blogTitle");
var blogTags=document.getElementById("blogTags");
var the_method=document.getElementById("the_method");
var show_blog_content=document.getElementById("show_blog_content");
// 或者 var editor = new E( document.getElementById('#editor') )
editor.create()
editor.txt.html(show_blog_content.value)


document.getElementById('get_blog_content').addEventListener('click', function () {
    // 读取 html
    $.ajax({
        type: "post",
        url: "/admin/newB",
        contentType:"application/x-www-form-urlencoded",
        data: {
            _method:the_method.value,
            "blogId":blogId.value,
            "blogTitle":blogTitle.value,
            "blogTags":blogTags.value,
            "blogContent":editor.txt.html()
        },
        success: function (){
            alert("发表成功！");
            window.location.href = "/admin/tables";
        }
    });

}, false)