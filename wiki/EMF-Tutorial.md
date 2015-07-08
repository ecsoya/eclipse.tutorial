---
layout: page
title: EMF Tutorial
wikiPageName: EMF-Tutorial
menu: wiki
---

Eclipse Modeling Framework(EMF)是eclipse中用来建模的一个插件，它支持将XMI类型的模型映射生成对应的Java模型。

### 元模型（ecore）

EMF支持将UML模型，XSD模型以及Annotated Java模型转换成EMF模型，但我们最常用的可能是直接定义Ecore模型。

#### Ecore模型基本概念：

* **EPackage**：包，它用来描述模型的分组。
	* **Name**：名称。
	* **Ns Prefix**:前缀，Namespace缩写，通常在模型加载和存储的时候使用。
	* **Ns URI**：模型对应的Namespace，通常在模型加载和存储的时候使用。
* **EClass**：类，它通常用来描述一个具体的模型。
	* 属性：
		* **Name**：模型的名称。
		* **Abstract**：模型是不是抽象的。
		* **Interface**：模型是不是接口。
	* **EAttribute**：属性，数据类型为EDataType类型。
	* **EReference**:引用，数据类型为EClass类型。
* **EEnum**：枚举，跟Java中枚举的概念类似。
	* **EEnumLiteral**：枚举中具体的条目。
* **EDataType**：数据类型，用来映射一些已有的Java类，通常在定义EAttribute的时候使用。
* **EAnnotation**：注解，通常包含一些string类型的key和value对。

#### Bounds

对于EAttribute和EReference来说，都可以定义Lower Bound和Upper Bound。

默认情况下Lower Bound为0，Upper Bound为1，表示“0..1”;
如果将Upper Bound设置为非1的整数，则表示“0..n”;
如果你想表示“0..*”，则可以将Upper Bound设置为“-1”。

#### Containment

对于EReference来说，Containment是一个非常重要的属性。

如果将Containment设置为true，则表示父模型中包含了当前EReference对应的所有的子模型（EReference的数据类型）。

如果将Containment设置为false，则表示这只是一般意义上的引用关系。

> 
> 1. “包含”和“引用”，在XML存储中，可能会理解的更加的直观，包含的话，所有的EReference对应的模型都会以Element的方式存储，而引用，只会创建一个Attribute，指定到模型的ID而已。
> 
> 2. 对于模型中的所有的元素来说，都要自上而下的被包含，否则在存储的时候就没法处理。
> 

#### Feature的属性

EAttribute和EReference统称为EStructuredFeature，在定义它们的时候，还有一些常见的属性：

* **changeable**：决定feature的值能不能被修改，也就是说会不会生成set方法。
* **derived**：决定feature的值是不是由其它的值计算出来的。
* **transient**：决定feature的值在序列化的时候是不是被忽略的，也就是说，如果此项设置为true，则此feature的值在保存的时候就会被忽略。
* **unsettable**：决定feature能不能被unset，同时生成代码的时候会生成isSet()和unset()方法。
* **volatile**：决定feature的存储是不是要自己来完成（所谓自己完成，是指模型按照属性的定义，调用默认的方法完成），默认为false，也就是自己完成，生成代码的时候也会生成EMF默认的代码；如果设置为true，则会按照手动的方式完成，通常情况下生成代码的时候会留空，你可以按需自行设计。通常情况下，这个属性是跟derived属性相关的。
* **ordered**：在（0..*）的属性中，决定里面的值的顺序要不要被保留。
* **unique**：在（0..*）的属性中，决定能不能添加重复的值。


### EMF模型（genmodel）

EMF模型是通过映射ecore模型产生的用来生成Java代码的模型，通常EMF模型的生成都是自动完成的，我们只是简单的说一下一些基本配置信息。

首先，EMF模型能够生成四种类型的代码：

* Core：模型的Java代码。
* Edit：支持模型编辑的Java代码。
* Editor：支持模型编辑的编辑器的Java代码。
* Test：支持模型测试的Java代码。

#### 常用属性配置

1. Base Package：生成Java代码使得基础包名。
2. Resource Type：模型存储的类型：None，Basic，XML和XMI。


### 参考资料

1. [FeatureMap](http://ecsoya.github.io/eclipse/2015/07/03/emf-featuremaps.html)
2. [Eclipse Modeling Framework](http://www.eclipse.org/modeling/emf/)

***
[Back to Home]({{site.baseurl}}/eclipse.tutorial/wiki/)