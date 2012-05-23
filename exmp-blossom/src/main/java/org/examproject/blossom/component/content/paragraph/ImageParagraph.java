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
import info.magnolia.module.blossom.annotation.TabFactory;
import info.magnolia.module.blossom.annotation.Template;
import info.magnolia.module.blossom.annotation.TemplateDescription;
import info.magnolia.module.blossom.dialog.TabBuilder;

/**
 * @author hiroxpepe
 */
@Controller
@Template(
    id="exmp-blossom:components/imageParagraph",
    title="Image Paragraph"
)
@TemplateDescription("the component of a paragraph with an image.")
public class ImageParagraph {
    
    private static final Logger LOG = LoggerFactory.getLogger(
        ImageParagraph.class
    );
    
    ///////////////////////////////////////////////////////////////////////////
    // public methods
    
    @RequestMapping("/imageParagraph") 
    public String render(
        ModelMap model,
        Node content
    ) throws RepositoryException {
        LOG.trace("called.");
        return "components/content/paragraph/imageParagraph.jsp";
    }
    
    @TabFactory("Image Paragraph")
    public void addDialog(TabBuilder tab) {
        tab.addHidden(
            "display",
            "true"
        );
        
        tab.addLink(
            "imageLink",
            "Image Link URL",
            "the image url of the paragraph."
        ).setRequired(true);
        
        Map<String, String> options = new HashMap<String, String>();
        options.put("Left", "left");
        options.put("Right", "right");
        tab.addRadio(
            "imagePosition", 
            "Image Position", 
            options,
            "left"
        ).setRequired(true);
        
        tab.addEdit(
            "caption",
            "Caption",
            "set the caption of the image when if you need."
        );
    }
    
}
