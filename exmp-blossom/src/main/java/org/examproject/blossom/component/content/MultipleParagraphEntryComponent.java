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

import java.util.HashMap;
import java.util.Map;
import javax.jcr.Node;
import javax.jcr.Property;
import javax.jcr.RepositoryException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import info.magnolia.jcr.util.NodeUtil;
import info.magnolia.module.blossom.annotation.Area;
import info.magnolia.module.blossom.annotation.AvailableComponentClasses;
import info.magnolia.module.blossom.annotation.TabFactory;
import info.magnolia.module.blossom.annotation.Template;
import info.magnolia.module.blossom.annotation.TemplateDescription;
import info.magnolia.module.blossom.dialog.TabBuilder;

import org.examproject.blossom.component.paragraph.ImageParagraphComponent;
import org.examproject.blossom.component.paragraph.ImageAndTextParagraphComponent;
import org.examproject.blossom.component.paragraph.LinkParagraphComponent;
import org.examproject.blossom.component.paragraph.PreTextParagraphComponent;
import org.examproject.blossom.component.paragraph.RichTextParagraphComponent;
import org.examproject.blossom.component.paragraph.TableParagraphComponent;
import org.examproject.blossom.component.paragraph.TextParagraphComponent;

/**
 * one of the entry class with text title.
 * this has one child classes as a area class.
 * @author hiroxpepe
 */
@Controller
@Template(
    id="exmp-blossom:components/multipleParagraphEntry",
    title="Multiple Entry"
)
@TemplateDescription("the component of a multiple entry.")
public class MultipleParagraphEntryComponent {
    
    private static final Logger LOG = LoggerFactory.getLogger(
        MultipleParagraphEntryComponent.class
    );
    
    ///////////////////////////////////////////////////////////////////////////
    // the area class of the paragraph.

    @Controller
    @Area(
        value="paragraph",
        title="Paragraph"
    )
    @AvailableComponentClasses({
        ImageParagraphComponent.class,
        ImageAndTextParagraphComponent.class,
        LinkParagraphComponent.class,
        PreTextParagraphComponent.class,
        RichTextParagraphComponent.class,
        TableParagraphComponent.class,
        TextParagraphComponent.class
    })
    public static class MultipleParagraphArea {

        @RequestMapping("/multipleParagraphEntry/paragraph")
        public String render(
            ModelMap model,
            Node content
        ) throws RepositoryException {
            
            return "areas/paragraph.jsp";
        }

        @TabFactory("Paragraph")
        public void addDialog(TabBuilder tab) {
            tab.addStatic("there is no item to be set yet.");
        }

    }
    
    ///////////////////////////////////////////////////////////////////////////
    // this class public methods.
    
    @RequestMapping("/multipleParagraphEntry")
    public String render(
        ModelMap model,
        Node content
    ) throws RepositoryException {
        LOG.debug("called.");
        
        return "components/content/multipleParagraphEntry.jsp";
    }
    
    @TabFactory("Multiple Paragraph Entry")
    public void addDialog(TabBuilder tab) {
        tab.addEdit(
            "title",
            "Title",
            "the title of the entry."
        ).setRequired(true);
    }
    
}