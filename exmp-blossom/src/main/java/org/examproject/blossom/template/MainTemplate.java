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

package org.examproject.blossom.template;

import javax.jcr.Node;
import javax.jcr.Property;
import javax.jcr.RepositoryException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import info.magnolia.module.blossom.annotation.Area;
import info.magnolia.module.blossom.annotation.AvailableComponentClasses;
import info.magnolia.module.blossom.annotation.TabFactory;
import info.magnolia.module.blossom.annotation.Template;
import info.magnolia.module.blossom.dialog.TabBuilder;

import org.examproject.blossom.component.content.ImageAndTextEntry;
import org.examproject.blossom.component.content.MultipleParagraphEntry;
import org.examproject.blossom.component.content.RichTextEntry;
import org.examproject.blossom.component.content.TextEntry;
import org.examproject.blossom.component.menu.MenuLinkItem;
import org.examproject.blossom.component.sidebar.SidebarHeaderItem;
import org.examproject.blossom.component.sidebar.SidebarLinkItem;
import org.examproject.blossom.component.sidebar.SidebarTextItem;

/**
 * the main template class of the application.
 * this has five children classes as the area class.
 * 
 * @author hiroxpepe
 */
@Controller
@Template(
    id="exmp-blossom:pages/main",
    title="Main Template"
)
public class MainTemplate {
    
    private static final Logger LOG = LoggerFactory.getLogger(
        MainTemplate.class
    );
    
    ///////////////////////////////////////////////////////////////////////////
    // the area class of the menu.
    
    @Controller
    @Area("menu")
    @AvailableComponentClasses({
        MenuLinkItem.class
    })
    public static class Menu {
        
        @RequestMapping("/main/menu")
        public String render(
            ModelMap model, Node content
        ) throws RepositoryException {
            LOG.trace("called.");
            return "areas/menu.jsp";
        }
        
        @TabFactory("Menu")
        public void addDialog(TabBuilder tab) {
            tab.addStatic("there is no item to be set yet.");
        }

    }
    
    ///////////////////////////////////////////////////////////////////////////
    // the area class of the header.
    
    @Controller
    @Area("header")
    public static class Header {

        @RequestMapping("/main/header")
        public String render(
            ModelMap model,
            Node content
        ) throws RepositoryException {
            LOG.trace("called.");
            return "areas/header.jsp";
        }
        
        @TabFactory("Header")
        public void addDialog(TabBuilder tab) {          
            tab.addEdit(
                "title",
                "Title",
                "the title of the header."
            ).setRequired(true); 

            tab.addEdit(
                "subTitle",
                "Sub Title",
                "the subtitle of the header."
            );
        }
        
    }
    
    ///////////////////////////////////////////////////////////////////////////
    // the area class of the content.
    
    @Controller
    @Area("content")
    @AvailableComponentClasses({
        TextEntry.class,
        RichTextEntry.class,
        ImageAndTextEntry.class,
        MultipleParagraphEntry.class
    })
    public static class Content {
        
        @RequestMapping("/main/content")
        public String render(
            ModelMap model,
            Node content
        ) throws RepositoryException {
            LOG.trace("called.");
            return "areas/content.jsp";
        }

        @TabFactory("Content")
        public void addDialog(TabBuilder tab) {
            tab.addStatic("there is no item to be set yet.");
        }
        
    }
    
    ///////////////////////////////////////////////////////////////////////////
    // the area class of the sidebar.
    
    @Controller
    @Area("sidebar")
    @AvailableComponentClasses({
        SidebarHeaderItem.class,
        SidebarTextItem.class,
        SidebarLinkItem.class
    })
    public static class Sidebar {

        @RequestMapping("/main/sidebar")
        public String render(
            ModelMap model,
            Node content
        ) throws RepositoryException {
            LOG.trace("called.");
            return "areas/sidebar.jsp";
        }

        @TabFactory("Sidebar")
        public void addDialog(TabBuilder tab) {
            tab.addStatic("there is no item to be set yet.");
        }
        
    }
    
    ///////////////////////////////////////////////////////////////////////////
    // the area class of the footer.
    
    @Controller
    @Area("footer")
    public static class Footer {

        @RequestMapping("/main/footer")
        public String render(
            ModelMap model,
            Node content
        ) throws RepositoryException {
            LOG.trace("called.");
            return "areas/footer.jsp";
        }
        
        @TabFactory("Footer")
        public void addDialog(TabBuilder tab) {          
            tab.addEdit(
                "author",
                "Author",
                "the author of the footer."
            );
            tab.addEdit(
                "copyright",
                "Copyright",
                "the copyright of the footer."
            );
        }
        
    }
    
    ///////////////////////////////////////////////////////////////////////////
    // main template class public methods.
    
    @RequestMapping("/main")
    public String render(
        ModelMap model,
        Node content
    ) throws RepositoryException {
        LOG.trace("called.");
        return "pages/main.jsp";
    }
    
    @TabFactory("Web Site")
    public void addDialog(TabBuilder tab) {
        tab.addEdit(
            "title",
            "Title",
            "the titel of the web site."
        );
        tab.addEdit(
            "metaDescription",
            "Meta Description",
            "html meta description of the web site."
        );
        tab.addEdit(
            "metaKeywords",
            "Meta Keywords",
            "html meta keywords of the web site."
        );
    }
    
}