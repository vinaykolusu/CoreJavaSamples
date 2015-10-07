package com.vinaykolusu.corejava.sample.gitCoreJavaSample;

import org.apache.log4j.Logger;



public class StringUnescapingCharaters {

	private static final Logger logger = Logger.getLogger(StringUnescapingCharaters.class);
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		String strSampleString = "&lt;span class=\"arrowleft\"&gt;&amp;#8592;&lt;/span&gt; ";
		
		logger.info("Sample Str Before unescaping ");
		logger.info(strSampleString);
		strSampleString = StringUnescapingCharaters.unescape(strSampleString);
		logger.info("After unescaping");
		logger.info(strSampleString);
		
		
		
	}

	public static String unescape(final String text) {
	    StringBuilder result = new StringBuilder(text.length());
	    int i = 0;
	    int n = text.length();
	    while (i < n) {
	        char charAt = text.charAt(i);
	        if (charAt != '&') {
	            result.append(charAt);
	            i++;
	        } else {
	            if (text.startsWith("&amp;", i)) {
	                result.append('&');
	                i += 5;
	            } else if (text.startsWith("&apos;", i)) {
	                result.append('\'');
	                i += 6;
	            } else if (text.startsWith("&quot;", i)) {
	                result.append('"');
	                i += 6;
	            } else if (text.startsWith("&lt;", i)) {
	                result.append('<');
	                i += 4;
	            } else if (text.startsWith("&gt;", i)) {
	                result.append('>');
	                i += 4;
	            } else i++;
	        }
	    }
	    return result.toString();
	}
	
	
	
}
