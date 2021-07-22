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

import org.apache.maven.plugin.MojoExecutionException;

/**
 * Thrown to signal any problems during installation of a project or its artifacts.
 */
public class InstallException extends MojoExecutionException
{
    public InstallException( Object source, String shortMessage, String longMessage )
    {
        super( source, shortMessage, longMessage );
    }

    public InstallException( String message, Exception cause )
    {
        super( message, cause );
    }

    public InstallException( String message, Throwable cause )
    {
        super( message, cause );
    }

    public InstallException( String message )
    {
        super( message );
    }
}
