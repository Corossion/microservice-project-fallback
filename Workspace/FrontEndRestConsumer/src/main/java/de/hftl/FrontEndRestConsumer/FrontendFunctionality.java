package de.hftl.FrontEndRestConsumer;

public class FrontendFunctionality {
	
	public int functionalityTesting(int n) {
	      if(n <= 2) {
	    	  return 1;
	      } else {
	    	  return functionalityTesting(n - 1) + functionalityTesting(n - 2);
	      }  
	}
}
