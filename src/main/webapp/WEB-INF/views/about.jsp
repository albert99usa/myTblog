<%@ page language="java" pageEncoding="UTF-8" %>
<jsp:include page="inc/header.jsp"></jsp:include>
<div class='container main'>
    <div class="col-md-9">
        <ul class='breadcrumb'>
            <li><a href='${contextPath}/'>主頁</a><span class='divider'></span></li>
            <li class='active'>關於</li>
        </ul>
        <div class='panel'>
            <div class='inner'>
                <div class="topic_content">
                    <div class="markdown-text"><h3>關於Spring框架</h3>
                        <p>Spring是一個開源框架，Spring是於2003 年興起的一個羽量級的Java 開發框架，由Rod Johnson創建。簡單來說，Spring是一個分層的JavaSE/EEfull-stack(一站式) 羽量級開源框架。</p>
                        <p>輕量——從大小與開銷兩方面而言Spring都是輕量的。完整的Spring框架可以在一個大小只有1MB多的JAR檔裡發佈。並且Spring所需的處理開銷也是微不足道的。此外，Spring是非侵入式的：典型地，Spring應用中的物件不依賴於Spring的特定類。</p>
                        <p>控制反轉——Spring通過一種稱作控制反轉（IoC）的技術促進了低耦合。當應用了IoC，一個物件依賴的其它物件會通過被動的方式傳遞進來，而不是這個物件自己創建或者查找依賴物件。你可以認為IoC與JNDI相反——不是物件從容器中查找依賴，而是容器在物件初始化時不等物件請求就主動將依賴傳遞給它。</p>
                        <p>面向切面——Spring提供了面向切面程式設計的豐富支援，允許通過分離應用的業務邏輯與系統級服務（例如審計（auditing）和事務（transaction）管理）進行內聚性的開發。應用物件只實現它們應該做的——完成業務邏輯——僅此而已。它們並不負責（甚至是意識）其它的系統級關注點，例如日誌或事務支援。</p>
                        <p>容器——Spring包含並管理應用物件的配置和生命週期，在這個意義上它是一種容器，你可以配置你的每個bean如何被創建——基於一個可配置原型（prototype），你的bean可以創建一個單獨的實例或者每次需要時都生成一個新的實例——以及它們是如何相互關聯的。然而，Spring不應該被混同于傳統的重量級的EJB容器，它們經常是龐大與笨重的，難以使用。</p>
                        <p>框架——Spring可以將簡單的元件配置、組合成為複雜的應用。在Spring中，應用物件被聲明式地組合，典型地是在一個XML檔裡。Spring也提供了很多基礎功能（事務管理、持久化框架組成等等），將應用邏輯的開發留給了你。</p>

                        <h3>MVC</h3>
                        <p>MVC——Spring的作用是整合，但不僅僅限於整合，Spring 框架可以被看做是一個企業解決方案級別的框架。用戶端發送請求，伺服器控制器（由DispatcherServlet實現的)完成請求的轉發，控制器調用一個用於映射的類HandlerMapping，該類用於將請求映射到對應的處理器來處理請求。HandlerMapping 將請求映射到對應的處理器Controller（相當於Action）在Spring 當中如果寫一些處理器元件，一般實現Controller 介面，在Controller 中就可以調用一些Service 或DAO 來進行資料操作 ModelAndView 用於存放從DAO 中取出的資料，還可以存放回應視圖的一些資料。 如果想將處理結果返回給用戶，那麼在Spring 框架中還提供一個視圖元件ViewResolver，該元件根據Controller 返回的標示，找到對應的視圖，將回應response 返回給用戶。</p>
                    </div>
                </div>
            </div>
        </div>
    </div>
    <jsp:include page="inc/sidebar.jsp"></jsp:include>
</div>
<jsp:include page="inc/footer.jsp"></jsp:include>

