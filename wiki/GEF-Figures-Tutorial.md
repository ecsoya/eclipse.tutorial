---
layout: page
title: GEF Figures Tutorial
wikiPageName: GEF-Figures-Tutorial
menu: wiki
---

GEF Figures（Draw2d）是专门用来绘图的一个插件。可以简单的分为以下几类：

1. Figure
2. Shape
3. Connection
4. RotatableDecoration

### Figure

任意的图形，所有的东西都可以通过paint()方法来绘制。

### Shape

常见的几何图形，如：

* RectangleFigure
* Ellipse
* Triangle

示例：

	Figure figure = new Figure();
	figure.setLayoutManager(new XYLayout());
	RectangleFigure rect = new RectangleFigure();
	rect.setBackgroundColor(ColorConstants.blue);
	figure.add(rect, new Rectangle(5, 5, 50, 50));

	Ellipse ellipse = new Ellipse();
	ellipse.setBackgroundColor(ColorConstants.yellow);
	figure.add(ellipse, new Rectangle(65, 5, 50, 50));

	Triangle triangle = new Triangle();
	triangle.setOrientation(Triangle.HORIZONTAL);
	triangle.setBackgroundColor(ColorConstants.red);
	figure.add(triangle, new Rectangle(125, 5, 50, 50));

	triangle = new Triangle();
	triangle.setOrientation(Triangle.VERTICAL);
	triangle.setBackgroundColor(ColorConstants.red);
	figure.add(triangle, new Rectangle(185, 5, 50, 50));


![]({{site.baseurl}}/eclipse.tutorial/wiki/images/image_gef_draw2d_1.gif)

### Connection

连线，常见的绘值直线的PolylineConnection。

	Figure figure = new Figure();
	figure.setLayoutManager(new XYLayout());

	RectangleFigure r1 = new RectangleFigure();
	r1.setBackgroundColor(ColorConstants.blue);
	figure.add(r1, new Rectangle(5, 5, 50, 50));

	RectangleFigure r2 = new RectangleFigure();
	r2.setBackgroundColor(ColorConstants.green);
	figure.add(r2, new Rectangle(200, 5, 50, 50));

	PolylineConnection conn = new PolylineConnection();
	conn.setSourceAnchor(new ChopboxAnchor(r1));
	conn.setTargetAnchor(new ChopboxAnchor(r2));

	conn.setTargetDecoration(new PolylineDecoration());

	figure.add(conn);

![]({{site.baseurl}}/eclipse.tutorial/wiki/images/image_gef_draw2d_2.gif)


### RotatableDecoration

可旋转的装饰Figure，常见的如绘制连线两端的箭头，如PolygonDecoration和PolylineDecoration。

### 渐进色（Gradient）

一个在Draw2d Figure上画渐进色的示例：

	Figure figure = new Figure();
	figure.setLayoutManager(new XYLayout());

	Figure f = new Figure() {
		protected void paintFigure(Graphics graphics) {
			super.paintFigure(graphics);

			Rectangle rect = getBounds();

			// From white to red vertically.
			graphics.setForegroundColor(ColorConstants.white);
			graphics.setBackgroundColor(ColorConstants.red);
			graphics.fillGradient(new Rectangle(rect.x, rect.y, rect.width,
					rect.height / 2), true);

			// From white to lightGreen horizontally.
			graphics.setForegroundColor(ColorConstants.white);
			graphics.setBackgroundColor(ColorConstants.lightGreen);
			graphics.fillGradient(new Rectangle(rect.x, rect.y
					+ rect.height / 2, rect.width, rect.height / 2), false);
		}

	};
	f.setBorder(new LineBorder(ColorConstants.gray));
	figure.add(f, new Rectangle(10, 10, 100, 100));
  
![]({{site.baseurl}}/eclipse.tutorial/wiki/images/image_gef_draw2d_3.gif)  
 
### 其它相关
1. Border：绘制边框。
2. Rectangle：位置和大小。

### 示例
1. [Display a UML Diagram using Draw2D](http://www.eclipse.org/articles/Article-GEF-Draw2d/GEF-Draw2d.html)
2. [The Draw2d Examples - A Hidden Treasure](http://nyssen.blogspot.com/2010/12/draw2d-examples-hidden-treasure.html)
***
[Back to Home]({{site.baseurl}}/eclipse.tutorial/wiki/) 上一篇：[GEF EditParts Tutorial](http://ecsoya.github.io/eclipse.tutorial/wiki/GEF-EditParts-Tutorial) 下一篇：[GEF EditPolicies Tutorial](http://ecsoya.github.io/eclipse.tutorial/wiki/GEF-EditPolicies-Tutorial)
