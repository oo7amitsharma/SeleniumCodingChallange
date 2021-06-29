package com.search.testcases;

public class MeeshoInterview {
	
	
	
	public static void main(String args) {
		String s1 = "Mynameisamit";
		String s2 = "amit";
		checkEquals(s1, s2);
	
		
	}
	
	public static boolean checkEquals(String s1, String s2) {
		boolean flag = true;
		int k=0;
		for(int i=0; i<s2.length(); i++) {
			int j;
			for(j=k; i<s1.length(); j++) {
				if(s1.charAt(i)==s2.charAt(j)) {
					k=j;
					break;
				}
				else {
					flag = false;
					break;

				}
			}
		}
		
		return true;
		
	}

}




