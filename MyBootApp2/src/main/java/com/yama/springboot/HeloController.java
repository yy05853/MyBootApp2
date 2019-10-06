package com.yama.springboot;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class HeloController {

	@RequestMapping(value="/", method=RequestMethod.GET)
	public ModelAndView index(ModelAndView mav) {
		mav.setViewName("index");
		mav.addObject("msg","本日の出退勤時刻を記入してください");
		return mav;
	}

	@RequestMapping(value="/", method=RequestMethod.POST)
	public ModelAndView send(@RequestParam("text1")String str,@RequestParam("text2")String str2, ModelAndView mav) {
		mav.addObject("msg","本日は" + str + "から" + str2 + "まで勤務しました");
		mav.addObject("value",str);
		mav.addObject("value2",str2);
		mav.setViewName("index");
		return mav;
	}

}