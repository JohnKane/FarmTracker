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

import com.farmtracker.model.Farm;
import com.farmtracker.service.FarmService;

@Controller
public class FarmController {

	private static final Logger LOG = Logger.getLogger(FarmController.class.getName());
	
	@Autowired
	private FarmService farmService;
	
	@RequestMapping(value = "/farms")
    public ModelAndView listFarms(ModelAndView model) throws IOException {
        List<Farm> farms=farmService.getFarms();
        model.addObject("farms",farms);
        model.setViewName("farms");
        return model;
    }
	
	@RequestMapping(value = "/newFarm", method = RequestMethod.GET)
    public ModelAndView newFarm(ModelAndView model) {
        Farm farm=new Farm();
        model.addObject("farm",farm);
        model.setViewName("farm_form");
        return model;
    }
	
	@RequestMapping(value = "/saveFarm", method = RequestMethod.POST)
    public ModelAndView saveFarm(@ModelAttribute Farm farm) {
        if(farm.getKey() == null) 
            farmService.addFarm(farm);
         
        else farmService.updateFarm(farm);

        return new ModelAndView("redirect:/farms");
    }
	
	@RequestMapping(value = "/deleteFarm", method = RequestMethod.GET)
    public ModelAndView deleteFarm(HttpServletRequest request) {
        int key=Integer.parseInt(request.getParameter("key"));
        farmService.deleteFarm(farmService.getFarm(key));	
        return new ModelAndView("redirect:/farms");
    }
	
	@RequestMapping(value = "/editFarm", method = RequestMethod.GET)
    public ModelAndView editFarm(HttpServletRequest request) {
        int key = Integer.parseInt(request.getParameter("key"));
        Farm farm=farmService.getFarm(key);
        ModelAndView model = new ModelAndView("farm_form");
        model.addObject("farm", farm);
 
        return model;
    }
	
}