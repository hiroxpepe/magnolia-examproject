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

package org.examproject.blossom.component.content.paragraph;

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

import org.examproject.blossom.component.content.item.FiveColumnRowItem;
import org.examproject.blossom.component.content.item.FourColumnRowItem;
import org.examproject.blossom.component.content.item.OneColumnRowItem;
import org.examproject.blossom.component.content.item.SixColumnRowItem;
import org.examproject.blossom.component.content.item.ThreeColumnRowItem;
import org.examproject.blossom.component.content.item.TwoColumnRowItem;

/**
 * @author hiroxpepe
 */
@Controller
@Template(
    id="exmp-blossom:components/tableParagraph",
    title="Table Paragraph"
)
@TemplateDescription("the component of a paragraph with a table.")
public class TableParagraph {
    
    private static final Logger LOG = LoggerFactory.getLogger(
        TableParagraph.class
    );
    
    ///////////////////////////////////////////////////////////////////////////
    // the area class of the table.
    
    @Controller
    @Area(
        value="tableItem",
        title="Table Item"
    )
    @AvailableComponentClasses({
        OneColumnRowItem.class,
        TwoColumnRowItem.class,
        ThreeColumnRowItem.class,
        FourColumnRowItem.class,
        FiveColumnRowItem.class,
        SixColumnRowItem.class
    })
    public static class TableItem {
        
        @RequestMapping("/tableParagraph/item")
        public String render(
            ModelMap model,
            Node content
        ) throws RepositoryException {
            LOG.trace("called.");
            return "areas/table.jsp";
        }
        
        @TabFactory("Table")
        public void addDialog(TabBuilder tab) {
            tab.addCheckbox(
                "wide",
                "Wide",
                "set the check when if you need a wide table."
            ).setRequired(true);
            
            tab.addEdit(
                "caption",
                "Caption",
                "set the caption of the table when if you need."
            );
        }
        
    }
    
    ///////////////////////////////////////////////////////////////////////////
    // this class public methods.
    
    @RequestMapping("/tableParagraph") 
    public String render(
        ModelMap model,
        Node content
    ) throws RepositoryException {
        LOG.trace("called.");
        return "components/content/paragraph/tableParagraph.jsp";
    }
    
    @TabFactory("Table Paragraph")
    public void addDialog(TabBuilder tab) {
        tab.addHidden("display", "true");
        tab.addStatic("proceed with Save.");
    }
    
}