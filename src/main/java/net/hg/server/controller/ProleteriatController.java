package net.hg.server.controller;

import com.google.common.collect.Maps;
import org.springframework.social.facebook.api.Facebook;
import org.springframework.social.facebook.api.FacebookProfile;
import org.springframework.social.facebook.api.PagedList;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.inject.Inject;
import java.util.Map;

/**
 * Created by Joonhyeok Im on 14. 3. 29.
 */
@Controller
@RequestMapping("/login")
public class ProleteriatController {
    private Facebook facebook;

    @Inject
    public ProleteriatController(Facebook facebook) {
        this.facebook = facebook;
    }

    @RequestMapping(method = RequestMethod.GET)
    @ResponseBody
    public Map<String, Object> login() {
        Map<String, Object> result = Maps.newHashMap();
        if(!facebook.isAuthorized()) {
            result.put("result", "NOT AUTH...");
        } else {
            result.put("user", facebook.userOperations().getUserProfile());
            PagedList<FacebookProfile> friends = facebook.friendOperations().getFriendProfiles();
            result.put("friends", friends);
        }
        return result;
    }
}
