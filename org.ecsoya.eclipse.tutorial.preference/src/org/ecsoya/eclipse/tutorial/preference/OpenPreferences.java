package org.ecsoya.eclipse.tutorial.preference;

import org.eclipse.core.commands.AbstractHandler;
import org.eclipse.core.commands.ExecutionEvent;
import org.eclipse.core.commands.ExecutionException;
import org.eclipse.core.commands.IHandler;
import org.eclipse.jface.preference.IPreferenceStore;
import org.eclipse.jface.preference.PreferenceDialog;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.ui.dialogs.PreferencesUtil;
import org.eclipse.ui.handlers.HandlerUtil;
import org.ecsoya.eclipse.tutorial.preference.preferences.PreferenceConstants;

public class OpenPreferences extends AbstractHandler implements IHandler {

	public Object execute(ExecutionEvent event) throws ExecutionException {
		Shell shell = HandlerUtil.getActiveShell(event);
		PreferenceDialog dialog = PreferencesUtil
				.createPreferenceDialogOn(
						shell,
						// Show current page.
						"org.ecsoya.eclipse.tutorial.preference.preferences.SamplePreferencePage",
						// Filtered to show pages (null to show all)
						new String[] {
								"org.ecsoya.eclipse.tutorial.preference.preferences.SamplePreferencePage",
								"org.ecsoya.eclipse.tutorial.preference.preferences.SamplePreferencePage2" },
						null);
		dialog.open();

		IPreferenceStore preferenceStore = Activator.getDefault()
				.getPreferenceStore();
		// Get value from store
		boolean booleanValue = preferenceStore
				.getBoolean(PreferenceConstants.P_BOOLEAN);
		// Set new value to store
		preferenceStore.setValue(PreferenceConstants.P_BOOLEAN, false);
		return null;
	}
}
