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

package org.examproject.blossom.component.content.item;

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
 * @author hiroxpepe
 */
@Controller
@Template(
    id="exmp-blossom:components/sixColumnRowItem",
    title="Six Columns Row Item"
)
@TemplateDescription("the component of a six columns row item.")
public class SixColumnRowItem {
    
    private static final Logger LOG = LoggerFactory.getLogger(
        SixColumnRowItem.class
    );
    
    ///////////////////////////////////////////////////////////////////////////
    // public methods
    
    @RequestMapping("/sixColumnRowItem") 
    public String render(
        ModelMap model,
        Node content
    ) throws RepositoryException {
        LOG.trace("called.");
        return "components/content/item/sixColumnRowItem.jsp";
    }
    
    @TabFactory("Six Columns Row Item")
    public void addDialog(TabBuilder tab) {
        tab.addEdit(
            "firstValue",
            "First Value",
            "the text value of the first column."
        );
        tab.addEdit(
            "secondValue",
            "Second Value",
            "the text value of the second column."
        );
        tab.addEdit(
            "thirdValue",
            "Third Value",
            "the text value of the third column."
        );
        tab.addEdit(
            "fourthValue",
            "Fourth Value",
            "the text value of the fourth column."
        );
        tab.addEdit(
            "fifthValue",
            "Fifth Value",
            "the text value of the fifth column."
        );
        tab.addEdit(
            "sixthValue",
            "Sixth Value",
            "the text value of the sixth column."
        );
        tab.addCheckbox(
            "header",
            "Header",
            "set the check when if you need a header of the table."
        ).setRequired(true);
    }
    
}