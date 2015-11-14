package com.social.manager.controller.app;

import javax.inject.Inject;

import org.springframework.social.connect.ConnectionFactoryLocator;
import org.springframework.social.connect.ConnectionRepository;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/connect")
public class ConnectController extends org.springframework.social.connect.web.ConnectController {
	
    @Inject
    public ConnectController(ConnectionFactoryLocator connectionFactoryLocator, ConnectionRepository connectionRepository) {
        super(connectionFactoryLocator, connectionRepository);
    }

    @Override
    protected String connectedView(String providerId) {
    	if(providerId.equals("facebook"))
    		return "redirect:/facebook";
    	else if(providerId.equals("twitter"))
    		return "redirect:/twitter";
    	else
    		return "redirect:/linkedin";
    }
    
    /*@Override
    protected String connectView(String providerId) {
    	return "redirect:/facebook";
    }*/

}
