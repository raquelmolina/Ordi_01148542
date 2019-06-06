package com.uabc.ordi.demo.Controller;


import com.uabc.ordi.demo.Constant.ViewConstants;
import com.uabc.ordi.demo.Model.AnimalesModel;
import com.uabc.ordi.demo.Service.impl.AnimalesService;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.text.ParseException;

@Controller
@RequestMapping("/animales")
public class AnimalesController {

    @Autowired
    @Qualifier("animalesServiceImpl")
    private AnimalesService animalesService;

    private static final Log log = LogFactory.getLog(AnimalesController.class);


    @GetMapping("/cancel")
    public String cancel(){
        return "redirect:/animales/showAnimales";
    }

    @GetMapping("/index")
    public ModelAndView mostrarAnimales(){

        ModelAndView mav = new ModelAndView(ViewConstants.ANIMALES);
        mav.addObject("animales",animalesService.listAllAnimales());


        return mav;
    }

    @GetMapping("/form")
    public String redirectAnimalForm(Model model, @RequestParam(name = "idAnimal", required = false) String idAnimal) throws ParseException {
        AnimalesModel animalesModel = new AnimalesModel();
        if(!idAnimal.equals("none")) {
            animalesModel = animalesService.findAnimalesByIdAnimalesModel(idAnimal);
            System.out.println("MODELO : "+animalesModel);
        }

        model.addAttribute("animalesModel",animalesModel);
        return ViewConstants.ANIMALES_FORM;
    }


    @PostMapping("/addAnimales")
    public String addAnimal(@ModelAttribute(name = "animalesModel") AnimalesModel animalesModel, Model model) throws Exception{
        log.info("Method: addAnimales() -- Params: " + animalesModel.toString());
        if (animalesService.addAnimales(animalesModel) != null)
            model.addAttribute("result", 1);
        else
            model.addAttribute("result", 0);
        return "redirect:/animales/index";
    }




    @GetMapping("/remove")
    public ModelAndView removeAnimal(@RequestParam(name = "idAnimal", required = true) String idAnimal) throws ParseException{
        animalesService.removerAnimal(idAnimal);
        return mostrarAnimales();
    }





}
