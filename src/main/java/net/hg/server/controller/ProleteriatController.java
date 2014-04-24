package net.hg.server.controller;

import java.util.Map;

import javax.inject.Inject;

import org.springframework.social.facebook.api.Facebook;
import org.springframework.social.facebook.api.FacebookProfile;
import org.springframework.social.facebook.api.PagedList;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.google.common.collect.Maps;

/**
 * Created by Joonhyeok Im on 14. 3. 29.
 */
@Controller
@RequestMapping("/connect")
public class ProleteriatController {
    private Facebook facebook;

    @Inject
    public ProleteriatController(Facebook facebook) {
        this.facebook = facebook;
    }

    @RequestMapping(method = RequestMethod.GET, value="/connect/{status}")
    @ResponseBody
    public Map<String, Object> getFriendsList(@PathVariable("status") String status) {
    	System.out.println(status);
    	System.out.println("Getting facebook friends list");	// TODO delete this code
    	
        Map<String, Object> result = Maps.newHashMap();
        result.put("isAuthorized", facebook.isAuthorized());
        if(!facebook.isAuthorized()) {
            result.put("message", "Not Authorized.");
        } else {
        	result.put("user", facebook.userOperations().getUserProfile());
            PagedList<FacebookProfile> friends = facebook.friendOperations().getFriendProfiles();
            result.put("friends", friends);
            result.put("message", "You are successfully logged in.");
        }
        return result;
    }
}