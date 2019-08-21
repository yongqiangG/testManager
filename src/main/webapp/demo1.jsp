<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<!-- 导入css -->
<link rel="stylesheet"
    href="/upload/kindeditor/themes/default/default.css" />
<link rel="stylesheet" href="js/editor/themes/default/default.css" />
    <script src="js/editor/kindeditor-all-min.js"></script>
    <script src="js/editor/lang/zh-CN.js"></script>
<script type="text/javascript">
    //初始化kindeditor组件
    KindEditor.ready(function(K) {
        var editor = K.editor({
            allowFileManager : true,
            uploadJson : 'http://localhost:8885/johnnyBlog/upload/uploadController.do',//后台文件上传处理的路径
            filePostName : 'file'//文件的字段名，一会看到后台代码时会解释怎么使用
        });

        K('#image3').click(//为文件上传按钮绑定事件
                function() {
                    editor.loadPlugin('image', function() {//加载文件上传插件
                        editor.plugin.imageDialog({
                            showRemote : false,
                            imageUrl : K('#url3').val(),//获取本地文件路径:如:c:/doc/ccc.png文件
                            clickFn : function(url, title, width, height,
                                    border, align) {//当上传文件成功时的回调函数
                                K('#url3').val(url);//将路径回显
                                editor.hideDialog();//隐藏文件上传kuang
                            }
                        });
                    });
                });
    });
</script>
</head>
<body>
    <p>
        <input type="text" id="url3" value="" /> <input type="button"
            id="image3" value="选择文件" />
    </p>
</body>
</html>