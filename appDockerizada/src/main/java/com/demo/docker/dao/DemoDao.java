package com.demo.docker.dao;

import java.util.List;

import com.demo.docker.model.DemoModel;

public interface DemoDao {

	public Boolean saveDemoModel(DemoModel demoModel);
	
	public List<DemoModel> getAllChanges();
}
