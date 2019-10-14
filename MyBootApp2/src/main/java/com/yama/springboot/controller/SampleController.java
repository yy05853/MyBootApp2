package com.yama.springboot.controller;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.yama.springboot.dao.SampleDao;
import com.yama.springboot.entity.Sample;

@RestController
public class SampleController {

    @Autowired
    private SampleDao sampleDao;

    @RequestMapping(method = RequestMethod.GET)
    @Transactional
    public List<Sample> get() {
        return sampleDao.findAll();
    }
}