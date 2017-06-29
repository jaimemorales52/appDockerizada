package com.demo.docker.service;

import java.util.List;

import com.demo.docker.model.DemoModel;

public interface DemoService {
	
	DemoModel generateChange(DemoModel demoModel);
	
	List<DemoModel> getAllChanges();

}
