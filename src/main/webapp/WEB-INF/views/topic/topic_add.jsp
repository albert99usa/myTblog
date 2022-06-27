<%@ page language="java" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<jsp:include page="../inc/header.jsp"></jsp:include>
<link href="${contextPath}/static/js/dropzone/dist/min/dropzone.min.css" rel="stylesheet">
<script src="${contextPath}/static/js/dropzone/dist/min/dropzone.min.js"></script>
<div class='container main'>
    <div class='col-md-9'>
        <ul class='breadcrumb'>
            <li><a href='${contextPath}/'>主頁</a><span class='divider'></span></li>
            <li><a href='${contextPath}/topic/list'>帖子管理</a><span class='divider'></span></li>
            <li class='active'>新建帖子</li>
        </ul>
        <div class='panel'>
            <div class='inner'>
                <div class="topic_content">
                    <div class="markdown-text">
                        <h3>新建帖子</h3>
                        <div class="row">
                            <jsp:include page="../inc/msgbox.jsp"></jsp:include>
                            <form method="post" action="${contextPath}/topic/create">
                                <input type="hidden" name="thumbURL" id="thumbURL" value="${topicVo.thumbURL}">
                                <div class="form-group">
                                    <div class="input-group">
                                        <div class="input-group-addon">欄目:</div>
                                        <select id="catId" name="catId" class="form-control">
                                            <option value="" selected=""></option>
                                            <c:forEach items="${catList}" var="cat">
                                                <%--                                                <option value="${cat.id}">${cat.catName}</option>--%>
                                                <option value="${cat.id}">${cat.name}</option>
                                            </c:forEach>
                                        </select>
                                    </div>
                                </div>
                                <div class="form-group">
                                    <div class="input-group">
                                        <div class="input-group-addon">標題*:</div>
                                        <input type="text" name="title" class="form-control" placeholder="輸入帖子標題" value="${topicVo.title}">
                                    </div>
                                </div>

                                <div class="form-group">
                                    <div class="input-group">
                                        <div class="input-group-addon">摘要:</div>
                                        <textarea name="desc" class="form-control" rows="3" placeholder="輸入摘要">${topicVo.desc}</textarea>
                                    </div>
                                </div>


                                <div class="form-group">
                                    <div class="input-group">
                                        <div class="input-group-addon">標籤:</div>
                                        <input type="text" name="tags" class="form-control" placeholder="輸入標籤" value="${topicVo.tags}">
                                    </div>
                                    <span class="label-info">注意：標籤使用英文逗號分隔</span>
                                </div>

                                <div class="form-group">
                                    <%--<div class="input-group">--%>
                                    <%--<div class="input-group-addon">內容:</div>--%>
                                    <%--<textarea name="content" class="form-control" rows="12" placeholder="請輸入帖子內容">${topicVo.content}</textarea>--%>
                                    <%--</div>--%>
                                    <div id="editormd">
                                        <textarea class="editormd-markdown-textarea" name="contentMD" id="contentMD">${topicVo.contentMD}</textarea>
                                        <textarea class="editormd-html-textarea" name="contentHTML" id="contentHTML">${topicVo.contentHTML}</textarea>
                                    </div>
                                </div>
                                <div class="checkbox">
                                    <label>
                                        <input type="checkbox" name="contentIsHTML" value="true"> 是否網頁？
                                    </label>
                                    <label>
                                        <input type="checkbox" name="top" value="true"> 置頂帖？
                                    </label>
                                    <label>
                                        <input type="checkbox" name="good" value="true"> 精華帖？
                                    </label>
                                </div>

                                <div class="form-group">
                                    <div class="text-center">
                                        <input type="hidden" name="authorId" value="${loginUser.id}">
                                        <input type="hidden" name="authorName" value="${loginUser.username}">
                                        <button class="btn btn-success" id="submit" type="submit">新建</button>
                                        <button class="btn btn-default" type="reset">清空</button>
                                    </div>
                                </div>
                            </form>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </div>
    <div class='col-md-3'>
        <div class='panel'>
            <div class='header'>
                <span class='col_fade'>帖子縮略圖</span>
            </div>
            <div class='inner'>
                <style>
                    .dropzone {
                        border: 2px dashed #0087F7;
                        border-radius: 5px;
                        background: white;
                    }
                </style>
                <div class="row" id="dropzoneWrapper">
                    <form id="uploadForm" action="" class="dropzone needsclick dz-clickable" id="demo-upload">
                        <div class="dz-message needsclick">
                            點擊或者拖拽上傳<br>
                            <span class="note needsclick">(<strong>文章縮略圖</strong>)</span>
                        </div>
                    </form>
                </div>
            </div>
        </div>
        <div class='panel'>
            <div class='header'>
                <span class='col_fade'>關於</span>
            </div>
            <div class='inner'>
                <p>TBlog：tblog開源博客</p>

                <p>在這裡你可以：</p>
                <ul>
                    <li>提出由建設性的建議</li>
                    <li>隨意修改代碼，修改成您需要的風格</li>
                    <li>分享給您的朋友</li>
                </ul>
            </div>
        </div>
    </div>
</div>
<jsp:include page="../inc/footer.jsp"></jsp:include>
<script>

    Dropzone.autoDiscover = false;//這個一定要放在最前面，否則

    $(function() {

        var myDropzone = new Dropzone("#uploadForm",{
            url:"${contextPath}/upload/thumbnail",
            paramName:"thumbImage",
            maxFilesize:2,//2M
            acceptedFiles:"image/png,image/jpg,image/jpeg",
            maxFiles:1,
            complete:function(file){
            },
            success:function(file,resp){
                var jsonData=$.parseJSON(resp);
                if(jsonData.success===1){
                    $('#thumbURL').val(jsonData.url);
                    $('#uploadForm').attr("style",'background-image: url("${contextPath}/upload/getImage/'+jsonData.url+'"); background-size: cover;');
                    myDropzone.removeFile(file);
                }
            }
        });

        createEditorMd("editormd", "#submit");

    });


    /**
     * 創建Markdown編輯器封裝方法
     * @param divId
     * @param submitId
     * @param markdown
     * @returns {*}
     */
    function createEditorMd(divId, submitId, markdown) {
        var editor = editormd(divId, {
            height           : 500,
            markdown         : markdown,
            tex              : true,
            tocm             : true,
            emoji            : true,
            taskList         : true,
            codeFold         : true,
            searchReplace    : true,
            htmlDecode       : "style,script,iframe",
            flowChart        : true,
            sequenceDiagram  : true,
            autoFocus: false,
            path: "${contextPath}/static/js/editormd/lib/",
            placeholder: "Markdown，提交前請查看預覽格式是否正確",
            saveHTMLToTextarea: true,
            imageUpload: true,
            imageFormats: ["jpg", "jpeg", "gif", "png"],
            imageUploadURL: "${contextPath}/upload/image",
            toolbarIcons: function() {
                return ["undo", "redo", "|", "bold", "italic", "quote", "|",
                    "h1", "h2", "h3", "h4", "h5", "h6", "|",
                    "list-ul", "list-ol", "hr", "|",
                    "link", "reference-link", "image", "code", "preformatted-text", "code-block", "|",
                    "goto-line", "watch", "preview", "fullscreen", "|",
                    "help", "info"]
            },
            onfullscreen : function() {
                this.editor.css("border-radius", 0).css("z-index", 120);
            },
            onfullscreenExit : function() {
                this.editor.css({
                    zIndex : 10,
                    border : "none",
                    "border-radius" : "5px"
                });

                this.resize();
            },
            onchange: function() {
                //$('#contentHTML').html(this.getPreviewedHTML());
                $(submitId).attr('disabled', this.getMarkdown().trim() == "");
                //console.log(this.getHTML());
                //console.log("====================");
                //console.log(this.getPreviewedHTML());
            }
        });

        return editor;
    }
</script>

