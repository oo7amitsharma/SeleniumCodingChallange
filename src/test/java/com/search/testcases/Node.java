package com.search.testcases;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Stack;

public class Node {
	
	Node node;
	int data;
	static boolean valid = false;
	
	public static void main(String args[]) {
//		List<Integer> list = new ArrayList();
//		list.add(3);
		
		boolean valid =isValid();
		if(valid) {
			System.out.println("Expression is Valid");
		}
		else {
			System.out.println("Expression is Invalid");
		}
	}
	
	public static boolean isValid() {
	
	String exp = "[()]{}{[()()]()}";
	Stack<Character> sac = new Stack<>();
	
	for(int i=0; i<exp.length(); i++) {
		if((exp.charAt(i)=='[') || (exp.charAt(i)=='{') || (exp.charAt(i)=='(')) {
			sac.push(exp.charAt(i));
		}
		else {
			if(exp.charAt(i)==']' && sac.peek()=='[') {
				sac.pop();
			}
			if(exp.charAt(i)=='}' && sac.peek()=='{') {
				sac.pop();
			}
			if(exp.charAt(i)==')' && sac.peek()=='(') {
				sac.pop();
			}
		}
		
	}
	valid =sac.isEmpty();
	
	return valid;

	}
	
	

}
