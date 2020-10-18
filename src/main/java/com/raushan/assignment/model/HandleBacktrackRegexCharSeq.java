package com.raushan.assignment.model;

import com.raushan.assignment.exception.RegexBackTrackingException;

public class HandleBacktrackRegexCharSeq implements CharSequence {

	private final CharSequence subSequenceChar;

	private final long timeoutInterval;

	private final long regexCancelTime;

	private final String text;

	private final String regex;

	public HandleBacktrackRegexCharSeq(CharSequence subSequenceChar, long timeoutInterval, String text, String regex) {
		this.subSequenceChar = subSequenceChar;
		this.timeoutInterval = timeoutInterval;
		this.text = text;
		this.regex = regex;
		this.regexCancelTime = System.currentTimeMillis() + timeoutInterval;
		;
	}

	@Override
	public char charAt(int index) {
		if (System.currentTimeMillis() > this.regexCancelTime) {
			throw new RegexBackTrackingException("Runaway regex encountered taking longer than the defined time");
		}

		return subSequenceChar.charAt(index);
	}

	@Override
	public int length() {
		return subSequenceChar.length();
	}

	@Override
	public CharSequence subSequence(int start, int end) {
		return new HandleBacktrackRegexCharSeq(subSequenceChar.subSequence(start, end), timeoutInterval, text, regex);
	}

	@Override
	public String toString() {
		return subSequenceChar.toString();
	}
}
