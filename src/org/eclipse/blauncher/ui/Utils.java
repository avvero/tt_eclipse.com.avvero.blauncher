package org.eclipse.blauncher.ui;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.eclipse.core.runtime.CoreException;
import org.eclipse.debug.core.DebugPlugin;
import org.eclipse.debug.core.ILaunchConfiguration;
import org.eclipse.debug.core.ILaunchConfigurationType;
import org.eclipse.debug.core.ILaunchManager;

public class Utils {
	
	/**
	 * 
	 * @param currentLaunchConfiguration
	 * @return
	 * @throws CoreException
	 */
	public static List<ILaunchConfiguration> getAvailableToRunLaunchConfigurations(ILaunchConfiguration currentLaunchConfiguration) throws CoreException {
		List<ILaunchConfiguration> result = new ArrayList<ILaunchConfiguration>();
		ILaunchManager launchManager = DebugPlugin.getDefault().getLaunchManager();
		ILaunchConfiguration[] list = launchManager.getLaunchConfigurations();
		for (ILaunchConfiguration conf : list) {
			if (!conf.getName().equals(currentLaunchConfiguration.getName())) {
				result.add(conf);
			}			
		}
		return result;		
	}
	
	public static List<ILaunchConfiguration> getAllLaunchConfigurations() throws CoreException {		
		ILaunchManager launchManager = DebugPlugin.getDefault().getLaunchManager();
		ILaunchConfiguration[] list = launchManager.getLaunchConfigurations();
		return Arrays.asList(list);		
	}	
}
