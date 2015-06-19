package org.ecsoya.eclipse.tutorial.preference;

import org.eclipse.core.runtime.preferences.IEclipsePreferences;
import org.eclipse.core.runtime.preferences.PreferenceModifyListener;

public class PreferenceModifyListener1 extends PreferenceModifyListener {

	public IEclipsePreferences preApply(IEclipsePreferences node) {
		return super.preApply(node);
	}
}
