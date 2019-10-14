package com.yama.springboot.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.yama.springboot.entity.Sample;

public interface SampleDao extends JpaRepository <Sample, Integer> {

}