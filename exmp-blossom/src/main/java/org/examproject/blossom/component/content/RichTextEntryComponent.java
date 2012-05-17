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

package org.examproject.blossom.component.content;

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
import info.magnolia.module.blossom.annotation.TemplateDescription;
import info.magnolia.module.blossom.dialog.TabBuilder;

import org.examproject.blossom.component.item.EntryLinkItemComponent;

/**
 * one of the entry class with rich text input.
 * this has one child classes as a area class.
 * @author hiroxpepe
 */
@Controller
@Template(
    id="exmp-blossom:components/richTextEntry",
    title="Rich Text Entry"
)
@TemplateDescription("the component of a rich text entry.")
public class RichTextEntryComponent {
    
    private static final Logger LOG = LoggerFactory.getLogger(
        RichTextEntryComponent.class
    );
    
    ///////////////////////////////////////////////////////////////////////////
    // the area class of the link.

    @Controller
    @Area(
        value="richTextEntryLink",
        title="Link"
    )
    @AvailableComponentClasses({
        EntryLinkItemComponent.class
    })
    public static class LinkArea {

        @RequestMapping("/richTextEntry/link")
        public String render(
            ModelMap model,
            Node content
        ) throws RepositoryException {
            
            return "areas/link.jsp";
        }

        @TabFactory("Link")
        public void addDialog(TabBuilder tab) {
            tab.addStatic("there is no item to be set yet.");
        }

    }
    
    ///////////////////////////////////////////////////////////////////////////
    // this class public methods.
    
    @RequestMapping("/richTextEntry") 
    public String render(
        ModelMap model,
        Node content
    ) throws RepositoryException {
        LOG.debug("called.");
        
        return "components/content/richTextEntry.jsp";
    }
    
    @TabFactory("Rich Text Entry")
    public void addDialog(TabBuilder tab) {
        tab.addEdit(
            "title",
            "Title",
            "the title of the entry."
        ).setRequired(true); 
        
        tab.addFckEditor(
            "content",
            "Content",
            "the content of the entry."
        ).setRequired(true);
    }
    
}
