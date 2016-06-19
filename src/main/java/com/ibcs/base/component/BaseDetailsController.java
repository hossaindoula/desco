package com.ibcs.base.component;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by Dell on 6/11/2016.
 */
@Controller
@RequestMapping("/{entityDetailsName}")
public abstract class BaseDetailsController extends BaseController {
}
