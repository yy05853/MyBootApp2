package com.yama.springboot.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.yama.springboot.dao.SampleDao;
import com.yama.springboot.entity.Sample;

@Controller
public class SampleController {

    @Autowired
    SampleDao repository;

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public ModelAndView index(
    		@ModelAttribute("formModel") Sample sample,
    		ModelAndView mav) {
    	mav.setViewName("index");
    	mav.addObject("msg","this is sample content.");
    	Iterable<Sample> list = repository.findAll();
    	mav.addObject("datalist",list);
    	return mav;
    }

    @RequestMapping(value = "/", method = RequestMethod.POST)
    @Transactional(readOnly=false)
    public ModelAndView form(
    		@ModelAttribute("formModel") Sample sample,
    		ModelAndView mav) {
    	repository.saveAndFlush(sample);
    	return new ModelAndView("redirect:/");

	}
}