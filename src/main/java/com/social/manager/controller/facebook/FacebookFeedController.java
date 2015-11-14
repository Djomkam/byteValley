package com.social.manager.controller.facebook;

import java.io.StringWriter;
import java.util.ArrayList;

import javax.inject.Inject;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

import org.springframework.social.facebook.api.Facebook;
import org.springframework.social.facebook.api.PagedList;
import org.springframework.social.facebook.api.Post;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.w3c.dom.Document;

import com.api.AlchemyAPI;

@Controller
@RequestMapping("/facebook/feed")
public class FacebookFeedController {

    private Facebook facebook;
    private AlchemyAPI alchemyObj;
    private Document doc;
    
    @Inject
    public FacebookFeedController(Facebook facebook) {
        this.facebook = facebook;
    }

    private class ModifiedPost{
    	private Post post;
    	private String postSentiment;
    	
    	public ModifiedPost(Post post, String postSentiment){
    		this.setPost(post);
    		this.setPostSentiment(postSentiment);
    	}

		@SuppressWarnings("unused")
		public Post getPost() {
			return post;
		}

		public void setPost(Post post) {
			this.post = post;
		}

		@SuppressWarnings("unused")
		public String getPostSentiment() {
			return postSentiment;
		}

		public void setPostSentiment(String postSentiment) {
			this.postSentiment = postSentiment;
		}
    }
    
    @RequestMapping(method=RequestMethod.GET)
    public String feedFacebook(Model model) {
        if (!facebook.isAuthorized()) {
            return "redirect:/connect/facebook";
        }

        model.addAttribute(facebook.userOperations().getUserProfile());
        PagedList<Post> homeFeed = facebook.feedOperations().getHomeFeed();
        ArrayList<ModifiedPost> modifiedHomeFeed = new ArrayList<ModifiedPost>();
        
        try{
        	// Create an AlchemyAPI object.
        	this.alchemyObj = AlchemyAPI.GetInstanceFromString("b10c9f7b22f1dd09dd5c2909472c97258b480a08");

        }
        catch(Exception e){
        	e.printStackTrace();
        }
        
        String currentSentiment = "";
        
        for(Post post : homeFeed){
        	try{
	        	// Extract sentiment for a text string.
	            this.doc = this.alchemyObj.TextGetTextSentiment(post.getMessage());
	            currentSentiment = getStringFromDocument(this.doc);
	            currentSentiment = currentSentiment.split("<type>")[1].split("</type>")[0];
        	}
        	catch(Exception e){
        		currentSentiment = "undefined";
        	}
        	modifiedHomeFeed.add(new ModifiedPost(post, currentSentiment));       	
        }
        
        model.addAttribute("feed", modifiedHomeFeed);

        return "facebook/feed";
    }

    // utility method
    private static String getStringFromDocument(Document doc) {
        try {
            DOMSource domSource = new DOMSource(doc);
            StringWriter writer = new StringWriter();
            StreamResult result = new StreamResult(writer);

            TransformerFactory tf = TransformerFactory.newInstance();
            Transformer transformer = tf.newTransformer();
            transformer.transform(domSource, result);

            return writer.toString();
        } catch (TransformerException ex) {
            ex.printStackTrace();
            return null;
        }
    }
}
