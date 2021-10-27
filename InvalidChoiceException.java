package com.lms.library;

@SuppressWarnings("serial")
public class InvalidChoiceException extends RuntimeException {
	@Override
	public String toString()
	{
		return "Given Choice is Invalid.....enter the choice";
	}

}
