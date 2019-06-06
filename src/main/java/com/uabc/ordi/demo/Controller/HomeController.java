package com.uabc.ordi.demo.Controller;

import com.uabc.ordi.demo.Constant.ViewConstants;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {

    @GetMapping("index")
    public String mostrarPrincipal(){
        return ViewConstants.INDEX;
    }
}

