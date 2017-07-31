package com.farmtracker.controller;

import java.io.IOException;
import java.util.List;
import java.util.logging.Logger;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.farmtracker.model.AnimalType;
import com.farmtracker.model.User;
import com.farmtracker.service.AnimalTypeService;

@Controller
public class AnimalTypeController {

	private static final Logger LOG = Logger.getLogger(AnimalTypeController.class.getName());
	
	@Autowired
	private AnimalTypeService animalTypeService;
	
	@RequestMapping(value = "/animalTypes")
    public ModelAndView listAnimalTypes(ModelAndView model) throws IOException {
        List<AnimalType> animalTypes=animalTypeService.getAnimalTypes();
        model.addObject("animalTypes",animalTypes);
        model.setViewName("animal_types");
        return model;
    }
	
	@RequestMapping(value = "/newAnimalType", method = RequestMethod.GET)
    public ModelAndView newAnimalType(ModelAndView model) {
        AnimalType type=new AnimalType();
        model.addObject("animalType",type);
        model.setViewName("animal_type_form");
        return model;
    }
	
	@RequestMapping(value = "/saveAnimalType", method = RequestMethod.POST)
    public ModelAndView saveAnimalType(@ModelAttribute AnimalType type,HttpServletRequest request) {
		type.setFarm(((User)request.getSession().getAttribute("LOGGEDIN_USER")).getFarm());
	        if(type.getKey() == null) {
	            animalTypeService.addAnimalType(type);
	        }
	         
	        else animalTypeService.updateAnimalType(type);

        return new ModelAndView("redirect:/animalTypes");
    }
	
	@RequestMapping(value = "/deleteAnimalType", method = RequestMethod.GET)
    public ModelAndView deleteAnimalType(HttpServletRequest request) {
        int key=Integer.parseInt(request.getParameter("key"));
        animalTypeService.deleteAnimalType(animalTypeService.getAnimalType(key));	
        return new ModelAndView("redirect:/animalTypes");
    }
	
	@RequestMapping(value = "/editAnimalType", method = RequestMethod.GET)
    public ModelAndView editAnimalType(HttpServletRequest request) {
        int key = Integer.parseInt(request.getParameter("key"));
        AnimalType type=animalTypeService.getAnimalType(key);
        ModelAndView model = new ModelAndView("animal_type_form");
        model.addObject("animalType", type);
 
        return model;
    }
	
}
