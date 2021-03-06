/*******************************************************************************
 * Copyright (c) 2006 IBM Corporation and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *     IBM Corporation - Initial API and implementation
 *******************************************************************************/
package org.eclipse.wst.server.ui.internal.wizard.fragment;

import org.eclipse.swt.widgets.Composite;
import org.eclipse.wst.server.ui.internal.ImageResource;
import org.eclipse.wst.server.ui.internal.Messages;
import org.eclipse.wst.server.ui.internal.wizard.page.LicenseComposite;
import org.eclipse.wst.server.ui.wizard.WizardFragment;
import org.eclipse.wst.server.ui.wizard.IWizardHandle;
/**
 * 
 */
public class LicenseWizardFragment extends WizardFragment {
	public static final String LICENSE = "license";
	public static final String LICENSE_NONE = "none";
	public static final String LICENSE_UNKNOWN = "unknown";
	public static final String LICENSE_ACCEPT = "accept";
	public static final String LICENSE_SERVER = "license_server";

	protected LicenseComposite comp;

	public LicenseWizardFragment() {
		// do nothing
	}

	public void enter() {
		if (comp != null)
			comp.updateLicense();
	}

	public boolean hasComposite() {
		return true;
	}

	/* (non-Javadoc)
	 * @see org.eclipse.wst.server.ui.internal.task.WizardTask#getWizardPage()
	 */
	public Composite createComposite(Composite parent, IWizardHandle wizard) {
		comp = new LicenseComposite(parent, getTaskModel(), wizard);
		
		wizard.setTitle(Messages.wizLicenseTitle);
		wizard.setDescription(Messages.wizLicenseDescription);
		wizard.setImageDescriptor(ImageResource.getImageDescriptor(ImageResource.IMG_WIZBAN_NEW_SERVER));
		return comp;
	}

	public boolean isComplete() {
		try {
			Boolean b = (Boolean) getTaskModel().getObject(LicenseWizardFragment.LICENSE_ACCEPT);
			if (b != null && b.booleanValue())
				return true;
		} catch (Exception e) {
			// ignore
		}
		return false;
	}
}