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

///////////////////////////////////////////////////////////////////////////////
/**
 * a global object for namespace.
 *
 * @author hiroxpepe
 */
var exmp = {};
exmp.mgnl = {};
exmp.mgnl.core = {};

///////////////////////////////////////////////////////////////////////////////
/**
 * an entry class of the application.
 * 
 * @author hiroxpepe
 */
exmp.mgnl.core.Application = function(sender) {
    $(document).ready(function() {
        sender.init();
    })
}

///////////////////////////////////////////////////////////////////////////////
/**
 * a controller class of the application.
 * 
 * @author hiroxpepe
 */
exmp.mgnl.core.Controller = window; {

    ///////////////////////////////////////////////////////////////////////////
    // public methods

    /**
     * the initialization method of the Controller class.
     * this method should be called.
     */
    exmp.mgnl.core.Controller.init = function() {
        
        var controller = exmp.mgnl.core.Controller;    
        controller._initializeComponent();
    }

    ///////////////////////////////////////////////////////////////////////////
    // event handler methods


    ///////////////////////////////////////////////////////////////////////////
    // private methods
    
    /**
     * an event handler that called when
     * the div of tirle is clicked.
     */
    exmp.mgnl.core.Controller._headerTitleDivOnClick = function() {
        $("div.container")
            .toggleClass(
                "wide", 300
            );
    }

    /**
     * initialize a component of the view class.
     */
    exmp.mgnl.core.Controller._initializeComponent = function() {
        
        var controller = exmp.mgnl.core.Controller;
        
        // calls for the initialization methods.
        
        $("span.header-title").click(function() {
            controller._headerTitleDivOnClick();
        });
    }
}

///////////////////////////////////////////////////////////////////////////////
/**
 * called the main entry.
 * 
 * @author hiroxpepe
 */
new exmp.mgnl.core.Application(
    this
);