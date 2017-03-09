/*
 * DO NOT ALTER OR REMOVE COPYRIGHT NOTICES OR THIS HEADER.
 *
 * Copyright (c) 2013 Oracle and/or its affiliates. All rights reserved.
 *
 * The contents of this file are subject to the terms of either the GNU
 * General Public License Version 2 only ("GPL") or the Common Development
 * and Distribution License("CDDL") (collectively, the "License").  You
 * may not use this file except in compliance with the License.  You can
 * obtain a copy of the License at
 * https://glassfish.dev.java.net/public/CDDL+GPL_1_1.html
 * or packager/legal/LICENSE.txt.  See the License for the specific
 * language governing permissions and limitations under the License.
 *
 * When distributing the software, include this License Header Notice in each
 * file and include the License file at packager/legal/LICENSE.txt.
 *
 * GPL Classpath Exception:
 * Oracle designates this particular file as subject to the "Classpath"
 * exception as provided by Oracle in the GPL Version 2 section of the License
 * file that accompanied this code.
 *
 * Modifications:
 * If applicable, add the following below the License Header, with the fields
 * enclosed by brackets [] replaced by your own identifying information:
 * "Portions Copyright [year] [name of copyright owner]"
 *
 * Contributor(s):
 * If you wish your version of this file to be governed by only the CDDL or
 * only the GPL Version 2, indicate your decision by adding "[Contributor]
 * elects to include this software in this distribution under the [CDDL or GPL
 * Version 2] license."  If you don't indicate a single choice of license, a
 * recipient has the option to distribute your version of this file under
 * either the CDDL, the GPL Version 2 or to extend the choice of license to
 * its licensees as provided above.  However, if you add GPL Version 2 code
 * and therefore, elected the GPL Version 2 license, then the option applies
 * only if the new code is made subject to such option by the copyright
 * holder.
 */
package org.glassfish.movieplex7.rest;

import java.util.Set;
import javax.ws.rs.core.Application;

/**
 * @author Arun Gupta
 */
@javax.ws.rs.ApplicationPath("webresources")
public class ApplicationConfig extends Application {

    @Override
    public Set<Class<?>> getClasses() {
        Set<Class<?>> resources = new java.util.HashSet<Class<?>>();
        addRestResourceClasses(resources);
        return resources;
    }

    /**
     * Do not modify addRestResourceClasses() method.
     * It is automatically re-generated by NetBeans REST support to populate
     * given list with all resources defined in the project.
     */
    private void addRestResourceClasses(Set<Class<?>> resources) {
        resources.add(org.glassfish.movieplex7.json.MovieReader.class);
        resources.add(org.glassfish.movieplex7.json.MovieWriter.class);
        resources.add(org.glassfish.movieplex7.rest.MovieFacadeREST.class);
        resources.add(org.glassfish.movieplex7.rest.SalesFacadeREST.class);
        resources.add(org.glassfish.movieplex7.rest.ShowTimingFacadeREST.class);
        resources.add(org.glassfish.movieplex7.rest.TheaterFacadeREST.class);
        resources.add(org.glassfish.movieplex7.rest.TimeslotFacadeREST.class);
    }

//    @Override
//    public Set<Class<?>> getClasses() {
//        return getRestResourceClasses();
//    }

//    /**
//     * Do not modify this method. It is automatically generated by NetBeans REST support.
//     */
//    private Set<Class<?>> getRestResourceClasses() {
//        Set<Class<?>> resources = new java.util.HashSet<>();
//        resources.add(org.glassfish.movieplex7.MovieSessionBean.class);
//        try {
//            Class<?> jacksonProvider = Class.forName("org.codehaus.jackson.jaxrs.JacksonJsonProvider");
//            resources.add(jacksonProvider);
//        } catch (ClassNotFoundException ex) {
//            java.util.logging.Logger.getLogger(getClass().getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        }
//        return resources;
//    }
    
}
