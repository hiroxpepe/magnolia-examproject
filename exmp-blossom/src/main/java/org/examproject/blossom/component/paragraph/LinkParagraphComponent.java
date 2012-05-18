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

package org.examproject.blossom.component.paragraph;

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
 * @author hiroxpepe
 */
@Controller
@Template(
    id="exmp-blossom:components/linkParagraph",
    title="Link Paragraph"
)
@TemplateDescription("the component of a link paragraph.")
public class LinkParagraphComponent {
    
    private static final Logger LOG = LoggerFactory.getLogger(
        LinkParagraphComponent.class
    );
    
    ///////////////////////////////////////////////////////////////////////////
    // the area class of the link.

    @Controller
    @Area(
        value="paragraphLinkItem",
        title="Link Item"
    )
    @AvailableComponentClasses({
        EntryLinkItemComponent.class
    })
    public static class LinkParagraphItemArea {

        @RequestMapping("/linkParagraph/item")
        public String render(
            ModelMap model,
            Node content
        ) throws RepositoryException {
            
            return "areas/link.jsp";
        }

        @TabFactory("Link")
        public void addDialog(TabBuilder tab) {
            tab.addEdit(
                "caption",
                "Caption",
                "set the caption of the table when if you need."
            );
        }

    }
    
    ///////////////////////////////////////////////////////////////////////////
    // this class public methods.
    
    @RequestMapping("/linkParagraph") 
    public String render(
        ModelMap model,
        Node content
    ) throws RepositoryException {
        LOG.debug("called.");
        
        return "components/paragraph/linkParagraph.jsp";
    }
    
    @TabFactory("Link Paragraph")
    public void addDialog(TabBuilder tab) {
        tab.addStatic("to proceed with OK.");
    }
    
}