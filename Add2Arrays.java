/*
  given two arrays of digits, add them and put result in a third array
  example
  [1,4,0,9] +
    [2,4,5]
============
[1,6,5,4]

Note thst given arrays could be of arbirary size
*/
import java.util.HashMap;
import java.util.Scanner;
import java.util.Stack;
import java.util.List;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Vector;
import java.util.Arrays;
import java.util.Set;
import java.util.HashSet;
import java.util.TreeSet;



public  class Add2Arrays
{
    private static  void addRest(int reminder, int arrC[], int arr[], int cIndex, int index, String arrayName)
    {
	System.out.println("         addrest from array:" + arrayName);
	if (index < 0)
	    {		
		arrC[cIndex] = reminder;
		return;
	    }
	for (int i = index; i>=0; i --)
	    {
		System.out.println("index:" + index + " i:" + i + "arr:" + arr[i]);
		int num = arr[i] + reminder;
		reminder = num / 10;
		num = num % 10;
		arrC[cIndex--] = num;
	    }
    }
    public static int[] add2Arrays(int arrA[], int arrB[])
    {
	int aLen = arrA.length;
	if (aLen == 0)
	    return arrB;
	
	int bLen = arrB.length;
	if (arrB.length == 0)
	    return arrA;
	
	int cLen = ((aLen > bLen) ? aLen:bLen) + 1;	
	
	int arrC[] = new int[cLen];
	
	int aIndex = aLen  -1;
	int bIndex = bLen  -1;
	int cIndex = cLen  -1;	

	int rem = 0;
	while (aIndex >=0  && bIndex >=0 )
	    {
		System.out.println(" aIndex:" +  aIndex + " bIndex:" +  bIndex  + " cIndex:" +  cIndex);
		int num = 0;

		num = arrA[aIndex--] + arrB[bIndex--] + rem;
		rem = num / 10;
		num = num % 10;
		arrC[cIndex--] = num;
		if ( aIndex  < 0  )
		    {
			System.out.println("+++++++ aIndex:" +  aIndex + " bIndex:" +  bIndex  + " cIndex:" +  cIndex);
			addRest(rem,arrC, arrB, cIndex, bIndex, "arrayB");
			return arrC;
		    }
		if ( bIndex  < 0  )
		    {
			System.out.println("====== aIndex:" +  aIndex + " bIndex:" +  bIndex  + " cIndex:" +  cIndex);
			addRest(rem,arrC, arrA, cIndex, aIndex, "arrayA");
			return arrC;
		    }
	    }	
	return arrC;
    }


    private static void printArray(int arr[])
    {
	for (int i=0; i< arr.length; i++)
	    System.out.print(arr[i] + ", ");

	System.out.println();
    }
   

    public static void main(String[] args) 
    {
	int arr1[]={7,5,1,3,4};
	int arr2[]={9,3,0,4,2,9,8,7};
	int arr[] = add2Arrays(arr1,arr2);
	
	printArray(arr1);
	printArray(arr2);
	printArray(arr);
	 
    }
	
}