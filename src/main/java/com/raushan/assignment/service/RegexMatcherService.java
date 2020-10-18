package com.raushan.assignment.service;

import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.regex.PatternSyntaxException;

import org.springframework.stereotype.Service;

import com.raushan.assignment.exception.RegexBackTrackingException;
import com.raushan.assignment.model.HandleBacktrackRegexCharSeq;
import com.raushan.assignment.model.RegexMatcherRequest;
import com.raushan.assignment.model.RegexMatcherResponse;

@Service
public class RegexMatcherService {

	public static final int REGEX_CANCEL_TIME_MS = 2000;

	public RegexMatcherResponse matchRegex(RegexMatcherRequest regexMatcherRequest) {
		boolean error = false;
		String match = null;
		try {
			String text = regexMatcherRequest.getTextBody();
			String regex = regexMatcherRequest.getRegex();
			Pattern pattern = Pattern.compile(regex);
			HandleBacktrackRegexCharSeq charSeq = new HandleBacktrackRegexCharSeq(text, REGEX_CANCEL_TIME_MS, text,
					regex);
			Matcher matcher = pattern.matcher(charSeq);
			if (matcher.find()) {
				match = matcher.group(0);
				error = false;
			}
		} catch (PatternSyntaxException | RegexBackTrackingException exp) {
			error = true;
			match = null;
		}

		return new RegexMatcherResponse(match, error);
	}
}
