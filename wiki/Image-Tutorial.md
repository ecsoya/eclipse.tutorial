---
layout: page
title: Image Tutorial
wikiPageName: Image-Tutorial
menu: wiki
---

### Image
1. 系统图片

		Display.getSystemImage(int); // SWT.ICON_*;

2. 绝对路径

		Image image = new Image(device, fileName); // absolute path of image.

3. InputStream

		InputStream inputStream = class.getResourceAsStream(name);
        Image image = new Image(device, inputStream);

4. 绘制图片
		
		Image image = new Image(display, 300, 200);
		GC gc = new GC(image);
		gc.setBackground(display.getSystemColor(SWT.COLOR_CYAN));
		gc.setForeground(display.getSystemColor(SWT.COLOR_RED));
		gc.drawRectangle(44, 28, 200, 100);
		gc.fillRectangle(45, 29, 199, 99);
		gc.drawString("Hello SWT", 120, 68);
		gc.dispose();

### ImageData

ImageData是用来描述图片的二进制信息的类，通常在加载和保存的时候会用到。

### ImageLoader

ImageLoader通常用来加载和保存图片。

支持的图片格式有：

* BMP (Windows or OS/2 Bitmap)
* ICO (Windows Icon)
* JPEG
* GIF
* PNG
* TIFF

用途：

1. 加载或保存支持格式的单一图片。
2. 加载或保存高位彩色图片（GIF/ICO/TIFF）。
3. 加载或保存GIF动画图片。
4. 加载交错的GIF/PNG图片。
5. 加载JPEG图片。

		Display display = new Display();
		Font font = new Font(display, "Comic Sans MS", 24, SWT.BOLD);
		Image image = new Image(display, 87, 48);
		GC gc = new GC(image);
		gc.setBackground(display.getSystemColor(SWT.COLOR_WHITE));
		gc.fillRectangle(image.getBounds());
		gc.setFont(font);
		gc.setForeground(display.getSystemColor(SWT.COLOR_RED));
		gc.drawString("S", 3, 0);
		gc.setForeground(display.getSystemColor(SWT.COLOR_GREEN));
		gc.drawString("W", 25, 0);
		gc.setForeground(display.getSystemColor(SWT.COLOR_BLUE));
		gc.drawString("T", 62, 0);
		gc.dispose();

		ImageLoader loader = new ImageLoader();
		loader.data = new ImageData[] {image.getImageData()};
		loader.save("swt.png", SWT.IMAGE_PNG);

		image.dispose();
		font.dispose();
		display.dispose();

		
### 参考资料
1. [Image snippets](http://www.eclipse.org/swt/snippets/#image)
2. [SWT Examples: GraphicsExample, ImageAnalyzer](http://www.eclipse.org/swt/examples.php)
3. [SWT Example: ImageAnalyzer](http://www.eclipse.org/swt/examples.php)  

***
[Back to Home]({{site.baseurl}}/eclipse.tutorial/wiki/) 上一篇：[Font Tutorial](http://ecsoya.github.io/eclipse.tutorial/wiki/Font-Tutorial) 下一篇：[JFace Tutorial](http://ecsoya.github.io/eclipse.tutorial/wiki/JFace-Tutorial)
