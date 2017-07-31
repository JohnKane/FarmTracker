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

import com.farmtracker.model.Animal;
import com.farmtracker.model.AnimalType;
import com.farmtracker.model.Farm;
import com.farmtracker.model.User;
import com.farmtracker.service.AnimalService;
import com.farmtracker.service.AnimalTypeService;
import com.farmtracker.util.Util;

@Controller
public class AnimalController {

private static final Logger LOG = Logger.getLogger(AnimalController.class.getName());
	
	@Autowired
	private AnimalService animalService;
	
	@Autowired
	private AnimalTypeService animalTypeService;
	
	@RequestMapping(value = "/animals")
    public ModelAndView listAnimals(ModelAndView model,HttpServletRequest request) throws IOException {
        List<Animal> animals=animalService.getAnimals(((User)request.getSession().getAttribute(Util.LOGGED_IN_USER)).getFarm());
        model.addObject("animals",animals);
        model.setViewName("animals");
        return model;
    }
	
	@RequestMapping(value = "/newAnimal", method = RequestMethod.GET)
    public ModelAndView newAnimalType(ModelAndView model,HttpServletRequest request) {
        Animal animal=new Animal();
        model.addObject("animal",animal);
        model.addObject("animalTypes",getAnimalTypes(((User)request.getSession().getAttribute(Util.LOGGED_IN_USER)).getFarm()));
        model.addObject("animals",getAnimals(((User)request.getSession().getAttribute(Util.LOGGED_IN_USER)).getFarm()));
        model.setViewName("animal_form");
        return model;
    }
	
	@RequestMapping(value = "/saveAnimal", method = RequestMethod.POST)
    public ModelAndView saveAnimal(@ModelAttribute Animal animal,HttpServletRequest request) {
			if(!animal.getChildKeys().isEmpty()) {
				List<Animal> children=animalService.getAnimals(animal.getChildKeys());
				animal.setChildren(children);
			}
	        if(animal.getKey() == null) {
	            animalService.addAnimal(animal);
	        }
	        else animalService.updateAnimal(animal);

        return new ModelAndView("redirect:/animals");
    }
	
	@RequestMapping(value = "/deleteAnimal", method = RequestMethod.GET)
    public ModelAndView deleteAnimal(HttpServletRequest request) {
        int key=Integer.parseInt(request.getParameter("key"));
        animalService.deleteAnimal(animalService.getAnimal(key));	
        return new ModelAndView("redirect:/animals");
    }
	
	@RequestMapping(value = "/editAnimal", method = RequestMethod.GET)
    public ModelAndView editAnimal(HttpServletRequest request) {
        int key = Integer.parseInt(request.getParameter("key"));
        Animal animal=animalService.getAnimal(key);
        ModelAndView model = new ModelAndView("animal_form");
        model.addObject("animal",animal);
        model.addObject("animalTypes",getAnimalTypes(((User)request.getSession().getAttribute(Util.LOGGED_IN_USER)).getFarm()));
        model.addObject("animals",getAnimals(((User)request.getSession().getAttribute(Util.LOGGED_IN_USER)).getFarm()));
        return model;
    }
	
	private List<AnimalType> getAnimalTypes(Farm farm){
		return animalTypeService.getAnimalTypes(farm);
	}
	
	private List<Animal> getAnimals(Farm farm){
		return animalService.getAnimals(farm);
	}
}
