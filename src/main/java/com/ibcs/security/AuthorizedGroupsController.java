package com.ibcs.security;

import com.ibcs.security.view.form.AuthorizedGroupsValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by Dell on 6/18/2016.
 */

@Controller
@RequestMapping("/authorizedGroups")
public class AuthorizedGroupsController {

    @Autowired
    private AuthorizedGroupsValidator authorizedGroupsValidator;
}
