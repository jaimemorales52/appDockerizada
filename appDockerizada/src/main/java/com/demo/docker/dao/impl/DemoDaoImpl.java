package com.demo.docker.dao.impl;

import java.util.List;

import org.springframework.data.mongodb.core.MongoOperations;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Repository;

import com.demo.docker.dao.DemoDao;
import com.demo.docker.model.DemoModel;

@Repository
public class DemoDaoImpl implements DemoDao {

	private MongoOperations mongoOps;

	public DemoDaoImpl(MongoOperations mongoOps) {
		this.mongoOps = mongoOps;
	}

	@Override
	public Boolean saveDemoModel(DemoModel demoModel) {
		this.mongoOps.save(demoModel);
		return true;
	}

	@Override
	public List<DemoModel> getAllChanges() {
		// TODO Auto-generated method stub
		Query query = new Query();
		return mongoOps.find(query, DemoModel.class);
	}

}
