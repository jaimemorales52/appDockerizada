package com.demo.docker.controller;

import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.demo.docker.model.DemoModel;
import com.demo.docker.service.DemoService;

@RestController
public class DemoController {

	Logger log = Logger.getLogger(DemoController.class);

	@Autowired
	private DemoService demoService;

	@RequestMapping(method = RequestMethod.GET, value = "/healthCheck")
	public String healthCheck() {
		return "OK";
	}

	@RequestMapping(method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE, value = "/generateChange")
	public @ResponseBody @ResponseStatus(code = HttpStatus.OK) ResponseEntity<DemoModel> generateChange(
			@RequestBody DemoModel demoModel) {

		log.debug("generateChange - The generateChange method has started ");

		return new ResponseEntity<>(demoService.generateChange(demoModel), HttpStatus.OK);
	}

	@RequestMapping(method = RequestMethod.GET, value = "/getAllChanges")
	public @ResponseBody @ResponseStatus(code = HttpStatus.OK) ResponseEntity<List<DemoModel>> getAllChanges() {

		log.debug("generateChange - The generateChange method has started ");

		return new ResponseEntity<>(demoService.getAllChanges(), HttpStatus.OK);
	}

}
