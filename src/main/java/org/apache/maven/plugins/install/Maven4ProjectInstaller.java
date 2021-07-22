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

import org.apache.maven.project.ArtifactInstallerException;
import org.apache.maven.project.MavenProject;
import org.apache.maven.project.NoFileAssignedException;
import org.apache.maven.project.ProjectBuildingRequest;
import org.apache.maven.project.ProjectInstaller;
import org.eclipse.aether.installation.InstallationException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Implementation of the {@link ProjectInstallerBridge} that delegates to Maven 4.
 */
public class Maven4ProjectInstaller implements ProjectInstallerBridge
{
    private static final Logger LOGGER = LoggerFactory.getLogger( Maven4ProjectInstaller.class );

    private final ProjectInstaller delegate;

    public Maven4ProjectInstaller( final Object delegate )
    {
        this.delegate = (ProjectInstaller) delegate;
        LOGGER.info( "Using Plexus-provided implementation for Maven 4+" );
    }

    @Override
    public void install( final ProjectBuildingRequest projectBuildingRequest, final MavenProject project )
            throws InstallException
    {
        try
        {
            delegate.install( projectBuildingRequest, project );
        }
        catch ( InstallationException | NoFileAssignedException | ArtifactInstallerException e )
        {
            throw new InstallException( "Could not install project or its artifacts", e );
        }
    }
}
