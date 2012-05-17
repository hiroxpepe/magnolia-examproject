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
import info.magnolia.module.blossom.annotation.TabFactory;
import info.magnolia.module.blossom.annotation.Template;
import info.magnolia.module.blossom.annotation.TemplateDescription;
import info.magnolia.module.blossom.dialog.TabBuilder;

/**
 * one of the entry class with simple text input.
 * @author hiroxpepe
 */
@Controller
@Template(
    id="exmp-blossom:components/textEntry",
    title="Text Entry"
)
@TemplateDescription("the component of a text entry.")
public class TextEntryComponent {
    
    private static final Logger LOG = LoggerFactory.getLogger(
        TextEntryComponent.class
    );
    
    @RequestMapping("/textEntry") 
    public String render(
        ModelMap model,
        Node content
    ) throws RepositoryException {
        LOG.debug("called.");
        
        // a example of to get the Magnolia JCR data.
        Property property = content.getProperty("title");
        LOG.debug(property.getString());
        
        return "components/content/textEntry.jsp";
    }
    
    @TabFactory("Text Entry")
    public void addDialog(TabBuilder tab) {
        tab.addEdit(
            "title",
            "Title",
            "the title of the entry."
        ).setRequired(true); 
        
        tab.addTextArea(
            "content",
            "Content",
            "the content of the entry.",
            5
        ).setRequired(true);
    }
    
}