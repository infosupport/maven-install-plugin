package org.apache.maven.plugins.install;

/*
 * Licensed to the Apache Software Foundation (ASF) under one
 * or more contributor license agreements.  See the NOTICE file
 * distributed with this work for additional information
 * regarding copyright ownership.  The ASF licenses this file
 * to you under the Apache License, Version 2.0 (the
 * "License"); you may not use this file except in compliance
 * with the License.  You may obtain a copy of the License at
 *
 *  http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing,
 * software distributed under the License is distributed on an
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
 * KIND, either express or implied.  See the License for the
 * specific language governing permissions and limitations
 * under the License.
 */

import org.apache.maven.plugins.install.compat3.Maven3ProjectInstaller;
import org.apache.maven.project.MavenProject;
import org.apache.maven.project.ProjectBuildingRequest;
import org.codehaus.plexus.PlexusContainer;
import org.codehaus.plexus.component.repository.exception.ComponentLookupException;
import org.eclipse.aether.RepositorySystem;

/**
 * Decouples the Mojos in this plugin from the underlying implementation - be it provided by Maven 4 or shipped with
 * the plugin for Maven 3.1+.
 */
public interface ProjectInstallerBridge
{
    // TODO Add JavaDoc
    void install( final ProjectBuildingRequest projectBuildingRequest, final MavenProject project )
            throws InstallException;

    /**
     * Finds the best available implementation for installing artifacts.
     * @param container The Plexus container.
     * @return An implementation of this interface; never <pre>null</pre>.
     */
    static ProjectInstallerBridge findImplementation( final PlexusContainer container )
    {
        // This component is introduced in Maven 4. If the plugin runs in Maven 4, we can delegate.
        final String componentName = "org.apache.maven.project.ProjectInstaller";
        try
        {
            final Object mavenProjectInstaller = container.lookup( componentName );
            return new Maven4ProjectInstaller( mavenProjectInstaller );
        }
        catch ( final ComponentLookupException e )
        {
            // Deliberately ignored, we fall back to plan B.
        }

        try
        {
            final RepositorySystem repositorySystem = container.lookup( RepositorySystem.class );
            return new Maven3ProjectInstaller( repositorySystem );
        }
        catch ( final ComponentLookupException e )
        {
            throw new IllegalStateException( "Could not locate RepositorySystem necessary for installing artifacts" );
        }
    }
}
