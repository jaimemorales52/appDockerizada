package com.demo.docker.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.demo.docker.dao.DemoDao;
import com.demo.docker.model.DemoModel;
import com.demo.docker.service.DemoService;

@Service
public class DemoServiceImpl implements DemoService {

	@Autowired
	DemoDao demoDao;
	
	@Override
	public DemoModel generateChange(DemoModel demoModel) {
		// TODO Auto-generated method stub
		demoModel.setChange(demoModel.getText().toLowerCase());
		demoDao.saveDemoModel(demoModel);
		return demoModel;
	}

	@Override
	public List<DemoModel> getAllChanges() {
		// TODO Auto-generated method stub
		return demoDao.getAllChanges();
	}

}
