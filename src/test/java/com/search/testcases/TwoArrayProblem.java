package com.search.testcases;

import java.util.HashSet;
import java.util.Set;

public class TwoArrayProblem {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
	int[] firstArr =	{1,2,3,4,5};
	int[] secondArr =	{2,3,4,9,6,10};
	Set<Integer> set = new HashSet<Integer>();
	for(int i=0; i<secondArr.length; i++) {
		set.add(secondArr[i]);
	}
	for(int i=0; i<firstArr.length; i++) {
		boolean status =set.add(firstArr[i]);
		if(status==false) {
			System.out.println("Intersection Elements :"+firstArr[i]);
	  }
	}
  }
}
