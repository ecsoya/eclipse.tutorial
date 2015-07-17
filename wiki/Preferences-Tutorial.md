---
layout: page
title: Preferences Tutorial
wikiPageName: Preferences-Tutorial
menu: wiki
---

首选项（Preferences）是Eclipse中用来存储一些基本配置信息或设置的组件。

### Preference Dialog

通过系统菜单`Window -> Preferences`就可以打开Preference Dialog，在这里你可以看到所有的Eclipse插件设置的首选项。

![]({{site.baseurl}}/eclipse.tutorial/wiki/images/image_preference_overview_1.png)

如图：

![]({{site.baseurl}}/eclipse.tutorial/wiki/images/image_preference_overview.png)

你也可以通过以下代码，打开你想要的一些首选项的配置：

	PreferenceDialog dialog = PreferencesUtil.createPreferenceDialogOn(
  	shell,
  	//Show current page.
  	"org.ecsoya.eclipse.tutorial.preference.preferences.SamplePreferencePage",
  	//Filtered to show pages (null to show all)
  	new String[] {
    	"org.ecsoya.eclipse.tutorial.preference.preferences.SamplePreferencePage",
    	"org.ecsoya.eclipse.tutorial.preference.preferences.SamplePreferencePage2" },
  	null);

如图：

![]({{site.baseurl}}/eclipse.tutorial/wiki/images/image_preference_filtered.png)

在上述图中，你看到的每一页都是一个Preference Page。

### Preference Page

Preference Page是通过扩展扩展点`org.eclipse.ui.preferencePages`来实现的。

每一个Page都包含以下主要内容：

1. **id**：
2. **name**：
3. **category**：父节点Page的id。
4. **class**：实现org.eclipse.ui.IWorkbenchPreferencePage接口

通常情况下，我们可以通过实现以下两个抽象类来定义我们的Preference Page：

1. org.eclipse.jface.preference.PreferencePage

		public class SamplePreferencePage2 extends PreferencePage implements IWorkbenchPreferencePage {
    		public SamplePreferencePage2() {
        		setPreferenceStore(Activator.getDefault().getPreferenceStore());
    		}
    		public void init(IWorkbench workbench) {
    		}
    		protected Control createContents(Composite parent) {
        		Label label = new Label(parent, SWT.NONE);
        		label.setText("Page 2");
        		return label;
    		}
		}


2. org.eclipse.jface.preference.FieldEditorPreferencePage

		public class SamplePreferencePage extends FieldEditorPreferencePage implements IWorkbenchPreferencePage {
    		public SamplePreferencePage() {
        		super(GRID);
        		setPreferenceStore(Activator.getDefault().getPreferenceStore());
    		}
    		public void createFieldEditors() {
        		addField(new DirectoryFieldEditor(PreferenceConstants.P_PATH, "&Directory preference:", getFieldEditorParent()));
		        addField(new BooleanFieldEditor(PreferenceConstants.P_BOOLEAN, "&An example of a boolean preference",      getFieldEditorParent()));

		        addField(new RadioGroupFieldEditor(PreferenceConstants.P_CHOICE, "An example of a multiple-choice preference", 1,
                new String[][] { { "&Choice 1", "choice1" },
                { "C&hoice 2", "choice2" } }, getFieldEditorParent()));
		        addField(new StringFieldEditor(PreferenceConstants.P_STRING, "A &text preference:", getFieldEditorParent()));
		    }
		    public void init(IWorkbench workbench) {
		    }
		}

>FieldEditorPreferencePage的实现跟JFace中的FieldEditor是分不开的。FieldEditor是一组由Label和具体的控件组成的editor组件，有以下几种类型：
>
>1. BooleanFieldEditor 
>2. IntegerFieldEditor
>3. StringFieldEditor
>4. RadioGroupFieldEditor
>5. ColorFieldEditor
>6. FontFieldEditor
>7. DirectoryFieldEditor
>8. FileFieldEditor
>9. PathEditor
> 
 

定义Preference Page的时候，我们都要首先要设置一个Preference Store来存储和读取首选项值。

	setPreferenceStore(Activator.getDefault().getPreferenceStore());

### Preference Store

`org.eclipse.jface.preference.IPreferenceStore`是用来用来存储首选项值的一个接口，通常我们可以通过`Activator.getDefault().getPreferenceStore()`来取到我们当前插件的Preference Store的实例，其中，`Activator`指的是我们当前插件的入口类。

在Preference Store有两种类型的值：

* 一种是当前值，如果没有设置，则会返回默认值。
* 一种是默认值，由于默认的Eclipse Preference Store只存储一些基本类型，所以默认的默认值如下：
	* boolean = false
	* double = 0.0
	* float = 0.0f
	* int = 0
	* long = 0
	* String = ""

我们可以通过以下方法来读取或者设置首选项值：

	IPreferenceStore preferenceStore = Activator.getDefault().getPreferenceStore();
	//Get value from store
	boolean booleanValue = preferenceStore.getBoolean(PreferenceConstants.P_BOOLEAN);

	//Set new value to store
	preferenceStore.setValue(PreferenceConstants.P_BOOLEAN, false);

JFace还提供了一些方法，用来在Preference Store中存储`SWT RGB, FontData, Rectangle和Point`的方法，详细请参考`org.eclipse.jface.preference.PreferenceConverter`

	IPreferenceStore store = ...;
 	PreferenceConverter.setValue(store, "bg", new RGB(127,127,127));
 	...
 	RBG bgColor = PreferenceConverter.getValue(store, "bg");


### Preference Initializer
Preference Initializer主要用来设置一些首选项的默认值。

通常我们通过扩展点`org.eclipse.core.runtime.preferences -> initializer`来实现。

	public class PreferenceInitializer extends AbstractPreferenceInitializer {

		public void initializeDefaultPreferences() {
			IPreferenceStore store = Activator.getDefault().getPreferenceStore();
			store.setDefault(PreferenceConstants.P_BOOLEAN, true);
			store.setDefault(PreferenceConstants.P_CHOICE, "choice2");
			store.setDefault(PreferenceConstants.P_STRING, "Default value");
		}
	}

### Preference Listener

我们可以通过给Preference Store添加监听器来实时的追踪某个首选项的值的变化情况。

	Activator.getDefault().getPreferenceStore()
			.addPropertyChangeListener(new IPropertyChangeListener() {
				public void propertyChange(PropertyChangeEvent event) {
					if (PreferenceConstants.P_BOOLEAN.equals(event
							.getProperty())) {
						System.out.println("Changed");
					}
				}
			});


***
[Back to Home]({{site.baseurl}}/eclipse.tutorial/wiki/) 上一篇：[Action and Menus Tutorial](http://ecsoya.github.io/eclipse.tutorial/wiki/Action-and-Menus-Tutorial) 下一篇：[ExtensionPoint Tutorial](http://ecsoya.github.io/eclipse.tutorial/wiki/ExtensionPoint-Tutorial)
