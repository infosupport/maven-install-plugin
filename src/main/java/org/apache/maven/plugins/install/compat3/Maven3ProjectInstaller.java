package org.apache.maven.plugins.install.compat3;

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

import org.apache.maven.plugins.install.InstallException;
import org.apache.maven.plugins.install.ProjectInstallerBridge;
import org.apache.maven.project.MavenProject;
import org.apache.maven.project.ProjectBuildingRequest;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Implementation of the {@link ProjectInstallerBridge} that works from Maven 3.1 onwards.
 */
public class Maven3ProjectInstaller implements ProjectInstallerBridge
{
    private static final Logger LOGGER = LoggerFactory.getLogger( Maven3ProjectInstaller.class );

    public Maven3ProjectInstaller()
    {
        LOGGER.info( "Using plugin-shipped implementation for Maven 3.1+" );
    }

    @Override
    public void install( final ProjectBuildingRequest projectBuildingRequest, final MavenProject project )
            throws InstallException
    {
        throw new InstallException( "Not yet implemented for Maven worse than 4" );
    }
}
