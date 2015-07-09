---
layout: page
title: GEF EditPolicies Tutorial
wikiPageName: GEF-EditPolicies-Tutorial
menu: wiki
---

EditPolicy是用来分发EditPart中的编辑操作的一组接口。它的主要功能有以下一些：

1. 创建编辑EditPart所需的Command。
2. 管理编辑EditPart时用到的Feedback。
3. 组织或重定向一些请求到另外的EditPart或是EditPolicy中去，比如一个Resize的Request，会被当前的EditPolicy重定向到去取父EditPart对应的Resize Children Request。

### 常用的EditPolicy
1. **ComponentEditPolicy**：通常用来提供删除命令（Command）。
2. **ConnectionEndpointPolicy**：但连线被选中时，在连线的两端会显示两个Selection Handle，并能够指引用户做一些改变源点或终点的操作（Reconnect）。
3. **BendpointEditPolicy**：显示、编辑连线的拐点的EditPolicy。
4. **ConnectionEditPolicy**：一般情况下，用来返回连线的删除命令。
5. **ContainerEditPolicy**：容器EditPolicy，一般提供添加（Add）、新建（create）和移除（orphan）命令。
6. **DirectEditPolicy**：提供在EditPart上直接编辑的命令。
7. **GraphicalNodeEditPolicy**：提供创建节点之间连线命令的EditPolicy。
8. **LayoutEditPolicy**：提供在图形中创建子元素命令的EditPolicy。
9. **PrimaryDrag Policy**：提供移动或改变大小的命令的EditPolicy，常在LayoutEditPolicy中被设置。

### EditPolicy常用方法

1. boolean understandsRequest(Request request)：一般情况下，工具在调用command之前，会进行EditPolicy验证。
2. EditPart getTargetEditPart(Request request)：和上一步的验证类似，看此EditPolicy有没有重定向。
3. void showXXXFeedback(Request request)：显示feedback。
4. void eraseXXXFeedback(Request request)：擦除feedback，如果显示了，一定要擦掉。
5. Command getCommand(Request request)：取得最终的Command。


***
[Back to Home]({{site.baseurl}}/eclipse.tutorial/wiki/)  上一篇：[GEF Figures Tutorial](http://ecsoya.github.io/eclipse.tutorial/wiki/GEF-Figures-Tutorial)