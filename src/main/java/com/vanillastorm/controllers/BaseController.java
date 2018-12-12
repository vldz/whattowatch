package com.vanillastorm.controllers;

import javax.servlet.http.HttpServletRequest;
import java.util.Map;

public interface BaseController {
    String process (HttpServletRequest request, Map<String, Object> model);
}
