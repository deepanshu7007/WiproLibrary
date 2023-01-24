package SearchModule;

import java.util.Scanner;

public class InsertNumber {
public static int[] insertNumbers(int n)
{
	int i =0,val=0,j=0;
	boolean flag=false;
	int nums[] = new int[n];
	Scanner s = new Scanner(System.in);
	while(i<nums.length)
	{
		val = s.nextInt();
		j=0;
		while(j<nums.length)
		{
			if(nums[j]==val) {
				flag=true;
				break;
			}
			else
			{
				flag = false;
			}
		j++;
		}
		if(flag == false)
		{
			nums[i]=val;
			i++;
		}
	}
	return nums;
}
public static void main(String... args)
{
	int arr[] = insertNumbers(5);
	for(int i=0;i<arr.length;i++)
	System.out.println(arr[i]);	
}
}
