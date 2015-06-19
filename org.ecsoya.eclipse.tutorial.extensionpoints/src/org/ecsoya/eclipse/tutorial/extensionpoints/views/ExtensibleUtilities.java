package org.ecsoya.eclipse.tutorial.extensionpoints.views;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IConfigurationElement;
import org.eclipse.core.runtime.Platform;

public class ExtensibleUtilities {

	public static IViewItemProvider[] getViewItemProviders() {
		IConfigurationElement[] elements = Platform
				.getExtensionRegistry()
				.getConfigurationElementsFor(
						"org.ecsoya.eclipse.tutorial.extensionpoints.viewItemProvider");
		List<IViewItemProvider> providers = new ArrayList<IViewItemProvider>();
		for (IConfigurationElement elt : elements) {
			try {
				IViewItemProvider p = (IViewItemProvider) elt
						.createExecutableExtension("class");
				providers.add(p);
			} catch (CoreException e) {
				e.printStackTrace();
			}
		}
		return providers.toArray(new IViewItemProvider[providers.size()]);
	}
}
