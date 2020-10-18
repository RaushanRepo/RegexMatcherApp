package com.raushan.assignment.model;

public class RegexMatcherResponse {

	private String match;
	private boolean error;

	public RegexMatcherResponse() {
	}

	public RegexMatcherResponse(String match, boolean error) {
		this.match = match;
		this.error = error;
	}

	public String getMatch() {
		return match;
	}

	public void setMatch(String match) {
		this.match = match;
	}

	public boolean isError() {
		return error;
	}

	public void setError(boolean error) {
		this.error = error;
	}
}
