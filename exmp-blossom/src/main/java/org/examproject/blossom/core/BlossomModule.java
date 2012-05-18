/* 
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 * 
 *      http://www.apache.org/licenses/LICENSE-2.0
 * 
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package org.examproject.blossom.core;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import info.magnolia.module.ModuleLifecycle;
import info.magnolia.module.ModuleLifecycleContext;
import info.magnolia.module.blossom.module.BlossomModuleSupport;

/**
 * @author hiroxpepe
 */
public class BlossomModule extends BlossomModuleSupport implements ModuleLifecycle {

    private static final Logger LOG = LoggerFactory.getLogger(
        BlossomModule.class
    );
    
    @Override
    public void start(ModuleLifecycleContext moduleLifecycleContext) {
        LOG.info(this.getClass().getSimpleName() + " is starting");
                
        initRootWebApplicationContext(
            "/WEB-INF/spring/app-config.xml"
        );
        
        initBlossomDispatcherServlet(
            "blossom",
            "/WEB-INF/blossom/blossom-config.xml"
        );
    }

    @Override
    public void stop(ModuleLifecycleContext moduleLifecycleContext) {
        destroyDispatcherServlets();
        closeRootWebApplicationContext();
        
        LOG.info(this.getClass().getSimpleName() + " is stopping");
    } 

}


