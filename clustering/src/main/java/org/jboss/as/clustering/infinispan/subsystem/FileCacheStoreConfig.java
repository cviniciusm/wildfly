/*
 * JBoss, Home of Professional Open Source.
 * Copyright 2011, Red Hat, Inc., and individual contributors
 * as indicated by the @author tags. See the copyright.txt file in the
 * distribution for a full listing of individual contributors.
 *
 * This is free software; you can redistribute it and/or modify it
 * under the terms of the GNU Lesser General Public License as
 * published by the Free Software Foundation; either version 2.1 of
 * the License, or (at your option) any later version.
 *
 * This software is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE. See the GNU
 * Lesser General Public License for more details.
 *
 * You should have received a copy of the GNU Lesser General Public
 * License along with this software; if not, write to the Free
 * Software Foundation, Inc., 51 Franklin St, Fifth Floor, Boston, MA
 * 02110-1301 USA, or see the FSF site: http://www.fsf.org.
 */

package org.jboss.as.clustering.infinispan.subsystem;

import org.jboss.msc.inject.Injector;
import org.jboss.msc.value.InjectedValue;

/**
 * @author Paul Ferraro
 */
public class FileCacheStoreConfig extends org.infinispan.loaders.file.FileCacheStoreConfig {
    private static final long serialVersionUID = -4014773345198955321L;

    private final InjectedValue<String> relativeTo = new InjectedValue<String>();
    private String path;

    public Injector<String> getRelativeToInjector() {
        return relativeTo;
    }

    public void setPath(String path) {
        this.path = path;
    }

    @Override
    public String getLocation() {
        StringBuilder builder = new StringBuilder(this.relativeTo.getValue());
        if (this.path != null) {
            builder.append('/').append(this.path);
        }
        return builder.toString();
    }
}
