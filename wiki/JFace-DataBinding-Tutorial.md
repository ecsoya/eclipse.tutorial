---
layout: page
title: JFace DataBinding Tutorial
wikiPageName: JFace-DataBinding-Tutorial
menu: wiki
---

数据绑定（Data Binding）在UI开发中是一个非常有用且高效的功能，JFace为SWT开发了DataBinding的功能。

### Eclipse DataBinding

首先，我们来认识一下Eclipse DataBinding的基本框架。Eclipse DataBinding是由`org.eclipse.core.databinding`，`org.eclipse.core.databinding.property`，`org.eclipse.core.databinding.beans`和`org.eclipse.core.databinding.observable`及相关的插件组成的。

		// Context
		DataBindingContext dbc = new DataBindingContext();

		// Model, bind from value.
		IObservableValue modelObservableValue = null;

		// Target, bind value to
		IObservableValue targetObservableValue = null;

		// Target to model strategy
		UpdateValueStrategy targetToModel = null;

		// Model to target strategy
		UpdateValueStrategy modelToTarget = null;

		// Do it.
		dbc.bindValue(targetObservableValue, modelObservableValue,
				targetToModel, modelToTarget);

因为DataBinding和主UI线程不是同一个，所以如果在一个Java Application执行DataBinding的话，一定要加上以下一段：

		final Realm realm = SWTObservables.getRealm(display);
		Realm.runWithDefault(realm, new Runnable() {

			public void run() {

				DataBindingContext context = new DataBindingContext(realm);
				// Your code here
				// context.bindValue(...);
			}
		});

如果是在一个Eclipse Plugin或RCP中的话就不用。

**综上所述**，我们在使用DataBinding的时候，真正需要关心的有以下两点：

1. **IObservableValue**：模型或UI的值（观察者模式）。
2. **UpdateValueStrategy**：模型到UI或者UI到模型的更新值的策略。

对于IObservaleValue，每一种不同的模型都会有不同的实现方式。

>
>对于Java Bean，在`org.eclipse.core.databinding.beans`插件中提供了很详细的实现方式，可以通过`BeansObservables`类取到。
>

对于UpdateValueStrategy，它里面包含三种信息：

1. **Validation**：验证，模型到UI，或是UI到模型值的正确性验证。
2. **Conversion**：转换器，数据类型转换。
3. **Automatic Processing**：当源数据改变时，使用哪种模式去更新目标？
	*  POLICY_NEVER：什么都不做。
	*  POLICY_ON_REQUEST：按需进行，通过识别调用的更新方法中的参数来选择更新。
	*  POLICY_CONVERT：除了validateBeforeSet(Object)，其它的通过识别调用的更新方法中的参数来选择更新。
	*  POLICY_UPDATE：每一次源数据的更改都自动会刷新到目标数据中去，这一项也是默认值。

>
>更新步骤如下：
>
>1. Validate after get - validateAfterGet(Object) 
>2. Conversion - convert(Object)
>3. Validate after conversion - validateAfterConvert(Object)
>4. Validate before set - validateBeforeSet(Object)
>5. Value set - doSet(IObservableValue, Object)
>

### JFace DataBinding

JFace DataBinding（org.eclipse.jface.databinding）主要实现了对SWT和JFace Viewers的各个属性的IObservaleValue的实现方法。可以参考**ViewersObservables**和**SWTObservables**两个类来看看。

我们通过一个简单的示例来看看：

首先，我们创建一个简单的SWT程序：

		Display display = new Display();
		Shell shell = new Shell(display);

		shell.setLayout(new GridLayout(2, false));

		Label label = new Label(shell, SWT.NONE);
		label.setText("Name: ");
		final Text text = new Text(shell, SWT.BORDER);
		text.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false));

		shell.setText("DataBinding Tutorial");
		shell.open();

		while (!shell.isDisposed()) {
			if (!display.readAndDispatch()) {
				display.sleep();
			}
		}

其次，我们创建一个简单的模型：

	public class Person {

		private String name;

		public Person(String name) {
			this.name = name;
		}

		public String getName() {
			return name;
		}

		public void setName(String name) {
			this.name = name;
		}
	}

DataBinding

		final Person person = new Person("Ecsoya");

		Realm.runWithDefault(SWTObservables.getRealm(display), new Runnable() {

			@Override
			public void run() {

				// Context
				DataBindingContext dbc = new DataBindingContext();

				// Model, bind from value.
				IObservableValue modelObservableValue = BeansObservables
						.observeValue(person, "name");

				// Target, bind value to
				IObservableValue targetObservableValue = SWTObservables
						.observeText(text, SWT.Modify);

				// Target to model strategy
				UpdateValueStrategy targetToModel = null;

				// Model to target strategy
				UpdateValueStrategy modelToTarget = null;

				// Do it.
				dbc.bindValue(targetObservableValue, modelObservableValue,
						targetToModel, modelToTarget);
			}
		});

### 参考资料
1. [JFace Data Binding/Tutorial](https://wiki.eclipse.org/JFace_Data_Binding/Tutorial)


***
[Back to Home]({{site.baseurl}}/eclipse.tutorial/wiki/) 上一篇：[JFace Dialogs Tutorial](http://ecsoya.github.io/eclipse.tutorial/wiki/JFace-Dialogs-Tutorial) 下一篇：[Plug-in Development Tutorial](http://ecsoya.github.io/eclipse.tutorial/wiki/Plug-in-Development-Tutorial)
