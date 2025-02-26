/*******************************************************************************
 * Copyright (c) 2011 SAP AG and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * https://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     SAP AG - initial API and implementation
 *******************************************************************************/

package org.eclipse.tycho.osgi.configuration;

import org.codehaus.plexus.component.annotations.Component;
import org.codehaus.plexus.component.annotations.Requirement;
import org.eclipse.sisu.equinox.embedder.EmbeddedEquinox;
import org.eclipse.sisu.equinox.embedder.EquinoxLifecycleListener;
import org.eclipse.tycho.locking.facade.FileLockService;

@Component(role = EquinoxLifecycleListener.class, hint = "FileLockServiceConfigurator")
public class FileLockServiceConfigurator implements EquinoxLifecycleListener {

    @Requirement
    private FileLockService fileLockService;

    /**
     * Registers the {@link FileLockService} plexus component as an OSGi service so it can be used
     * from OSGi too.
     */
    @Override
    public void afterFrameworkStarted(EmbeddedEquinox framework) {
        framework.registerService(FileLockService.class, fileLockService);
    }

}
