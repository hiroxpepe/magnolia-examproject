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

package org.examproject.blossom.component;

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

/**
 * one of the entry class with image upload and rich text input.
 * this has one child classes as a area class.
 * @author hiroxpepe
 */
@Controller
@Template(
    id="exmp-blossom:components/imageAndTextEntry",
    title="Image and Text Entry"
)
@TemplateDescription("the component of an image and text entry.")
public class ImageAndTextEntryComponent {
    
    private static final Logger LOG = LoggerFactory.getLogger(
        ImageAndTextEntryComponent.class
    );
    
    ///////////////////////////////////////////////////////////////////////////
    // the area class of the link.

    @Controller
    @Area(
        value="imageAndTextEntryLink",
        title="Link"
    )
    @AvailableComponentClasses({
        EntryLinkItemComponent.class
    })
    public static class LinkArea {

        @RequestMapping("/imageAndTextEntry/link")
        public String render(
            ModelMap model,
            Node content
        ) throws RepositoryException {
            
            return "areas/entryLink.jsp";
        }

        @TabFactory("Link")
        public void addDialog(TabBuilder tab) {
            tab.addStatic("there is no item to be set yet.");
        }

    }
    
    ///////////////////////////////////////////////////////////////////////////
    // this class public methods.
    
    @RequestMapping("/imageAndTextEntry")
    public String render(
        ModelMap model,
        Node content
    ) throws RepositoryException {
        LOG.debug("called.");
        
        // create the image path of this content.
        String nodePath = NodeUtil.getPathIfPossible(content);    
        Node image = content.getNode("image");
        String name = image.getName();
        String fileName = image.getProperty("fileName").getString();
        String extension = image.getProperty("extension").getString();
        String imagePath = nodePath + "/" + name +
            "/" + fileName + "." + extension;
        
        // put the image path to the model object.
        model.put(
            "imagePath",
            imagePath
        );
        
        return "components/imageAndTextEntry.jsp";
    }
    
    @TabFactory("Image and Text Entry")
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
        
        tab.addFile(
            "image",
            "Image",
            "the image should not be more than 320px x 240px."
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
    }
    
}
