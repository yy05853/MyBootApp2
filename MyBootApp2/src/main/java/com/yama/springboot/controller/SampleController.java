package com.yama.springboot.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.yama.springboot.dao.SampleDao;

@Controller
public class SampleController {

    @Autowired
    SampleDao repository;

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public ModelAndView index(ModelAndView mav) {

    	mav.addObject("msg","商品の値段を入力してください");
    	mav.setViewName("index");
    	return mav;
    }

    @RequestMapping(value = "/", method = RequestMethod.POST)
    public ModelAndView send(
    		@RequestParam("text1")String str,
    		@RequestParam(value="check1",required=false)boolean check1,
    		ModelAndView mav) {


    	int price = Integer.parseInt(str);
    	int taxPrice;

    	if(check1) {
    		taxPrice = price * 108 / 100;
    	}else {
    		taxPrice = price * 110 / 100;
    	}

    	mav.addObject("msg", "税込" + taxPrice +"円です");
    	mav.setViewName("index");
    	return mav;

	}
}