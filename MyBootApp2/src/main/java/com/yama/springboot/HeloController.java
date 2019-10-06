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
		mav.addObject("msg","本日の学習時間を記入してください");
		return mav;
	}

	@RequestMapping(value="/", method=RequestMethod.POST)
	public ModelAndView send(@RequestParam("text1")String str,
			                  @RequestParam("text2")String str2,
			                  @RequestParam("text3")String str3,
			                  @RequestParam("text4")String str4,
			                  ModelAndView mav) {


		int start = Integer.parseInt(str3.substring(0,2)) * 60 + Integer.parseInt(str3.substring(3,5));
		int end = Integer.parseInt(str4.substring(0,2)) * 60 + Integer.parseInt(str4.substring(3,5));

		int rest1 = (end - start) / 60;
		int rest2 = (end - start) % 60;

		mav.addObject("msg","本日は" + str + "から" + str2 + "まで学習しました。休憩時間は" + rest1 + "時間" + rest2 + "分です。");
		mav.addObject("value",str);
		mav.addObject("value2",str2);
		mav.addObject("value3",str3);
		mav.addObject("value4",str4);
		mav.setViewName("index");
		return mav;
	}

}