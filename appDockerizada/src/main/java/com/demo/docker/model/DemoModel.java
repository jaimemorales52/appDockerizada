package com.demo.docker.model;

import javax.validation.constraints.NotNull;


public class DemoModel {

	@NotNull
	private String text;

	private String change;

	public String getText() {
		return text;
	}

	public void setText(String text) {
		this.text = text;
	}

	public String getChange() {
		return change;
	}

	public void setChange(String change) {
		this.change = change;
	}

}
