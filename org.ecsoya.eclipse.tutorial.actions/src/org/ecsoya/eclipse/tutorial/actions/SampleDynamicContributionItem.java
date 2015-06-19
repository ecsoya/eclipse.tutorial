package org.ecsoya.eclipse.tutorial.actions;

import org.eclipse.jface.action.ContributionItem;
import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.CoolBar;
import org.eclipse.swt.widgets.Menu;
import org.eclipse.swt.widgets.ToolBar;
import org.eclipse.swt.widgets.ToolItem;
import org.eclipse.ui.ISharedImages;
import org.eclipse.ui.PlatformUI;
import org.eclipse.ui.menus.IWorkbenchContribution;
import org.eclipse.ui.services.IServiceLocator;

public class SampleDynamicContributionItem extends ContributionItem implements
		IWorkbenchContribution {

	public SampleDynamicContributionItem() {
		super();
	}

	public SampleDynamicContributionItem(String id) {
		super(id);
	}

	public boolean isDynamic() {
		return true;
	}

	public void fill(ToolBar parent, int index) {
		ToolItem item = new ToolItem(parent, SWT.CHECK);
		item.setImage(PlatformUI.getWorkbench().getSharedImages()
				.getImage(ISharedImages.IMG_LCL_LINKTO_HELP));
		item.setToolTipText("Ecsoya dymanic toolbar contribution");
		item.setWidth(30);
	}

	@Override
	public void fill(Menu menu, int index) {
		super.fill(menu, index);
	}

	@Override
	public void fill(Composite parent) {
		super.fill(parent);
	}

	@Override
	public void fill(CoolBar parent, int index) {
		super.fill(parent, index);
	}

	@Override
	public void update() {
		super.update();
	}

	@Override
	public void update(String id) {
		super.update(id);
	}

	@Override
	public void initialize(IServiceLocator serviceLocator) {
		System.out.println();
	}
}
