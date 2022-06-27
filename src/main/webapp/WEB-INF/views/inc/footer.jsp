<%@ page contentType="text/html;charset=UTF-8" language="java" %>
    <%@ taglib prefix="fns" uri="WEB-INF/tlds/fns.tld" %>
        <div id='footer'>
            <div id='footer_main'>
                <div class="links">
                    <a class='dark' href='${contextPath}/rss'>RSS</a>

                </div>

                <div class='col_fade'>
                    <p>TBlog使用Java技術，結合流行框架開發個人博客系統。</p>
                    <p>如果感覺系統比錯，請不要吝嗇您的星星，只需要輕輕的戳一下，謝謝！ </p>
                </div>
            </div>
        </div>
        <!-- scripts -->
        <script src="https://cdn.bootcss.com/jquery/3.2.1/jquery.min.js"></script>
        <script src="https://cdn.bootcss.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
        <script src="${contextPath}/static/js/jquery.scrollUp.min.js"></script>
        <script src="${contextPath}/static/js/editormd/editormd.min.js"></script>
        <!--回到頂部開始-->
        <script>
            $(document).ready(function() {
                $.scrollUp({
                    scrollName: 'scrollUp',
                    topDistance: '100',
                    topSpeed: 300,
                    animation: 'fade',
                    animationInSpeed: 200,
                    animationOutSpeed: 200,
                    scrollText: '',
                    activeOverlay: false
                });
            });
        </script>
        <a id="scrollUp" href="#top" title="" style="position: fixed; z-index: 222222222222; display: none;"></a>
        </body>
        <!--回到頂部結束-->
        </body>

        </html>