package com.raushan.assignment.model;

public class RegexMatcherRequest {
	private String regex;
	private String textBody;

	public RegexMatcherRequest() {
	}

	public RegexMatcherRequest(String regex, String textBody) {
		this.regex = regex;
		this.textBody = textBody;
	}

	public String getRegex() {
		return regex;
	}

	public void setRegex(String regex) {
		this.regex = regex;
	}

	public String getTextBody() {
		return textBody;
	}

	public void setTextBody(String textBody) {
		this.textBody = textBody;
	}

}
