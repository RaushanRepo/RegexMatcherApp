package com.raushan.assignment.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.raushan.assignment.model.RegexMatcherRequest;
import com.raushan.assignment.model.RegexMatcherResponse;
import com.raushan.assignment.service.RegexMatcherService;

@RestController
@RequestMapping("/regex-matcher")
public class RegexMatcherController {

	@Autowired
	RegexMatcherService regexMatcherService;

	@PostMapping
	public RegexMatcherResponse matchRegex(@RequestBody RegexMatcherRequest regexMatcherRequest) {
		return regexMatcherService.matchRegex(regexMatcherRequest);
	}
}
