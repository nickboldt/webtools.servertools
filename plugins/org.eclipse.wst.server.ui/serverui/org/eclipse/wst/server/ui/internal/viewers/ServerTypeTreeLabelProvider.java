/*******************************************************************************
 * Copyright (c) 2003, 2006 IBM Corporation and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     IBM Corporation - Initial API and implementation
 *******************************************************************************/
package org.eclipse.wst.server.ui.internal.viewers;

import org.eclipse.wst.server.core.IServerType;
import org.eclipse.wst.server.ui.internal.ImageResource;
import org.eclipse.jface.viewers.ILabelDecorator;
import org.eclipse.swt.graphics.Image;
/**
 * Server type label provider.
 */
public class ServerTypeTreeLabelProvider extends AbstractTreeLabelProvider {
	/**
	 * ServerTypeTreeLabelProvider constructor comment.
	 */
	public ServerTypeTreeLabelProvider() {
		super();
	}

	/**
	 * ServerTypeTreeLabelProvider constructor comment.
	 * 
	 * @param decorator a label decorator, or null if no decorator is required
	 */
	public ServerTypeTreeLabelProvider(ILabelDecorator decorator) {
		super(decorator);
	}

	/**
	 * 
	 */
	protected Image getImageImpl(Object element) {
		IServerType type = (IServerType) element;
		return ImageResource.getImage(type.getId());
	}

	/**
	 * 
	 */
	protected String getTextImpl(Object element) {
		IServerType type = (IServerType) element;
		return notNull(type.getName());
	}
}