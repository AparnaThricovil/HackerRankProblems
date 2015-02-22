/*
Challenge
Given a list of unsorted numbers, can you find the numbers that have the 
smallest absolute difference between them? If there are multiple pairs, 
find them all.

Input Format
There will be two lines of input:

    n - the size of the list
    array - the n numbers of the list

Output Format
Output the pairs of numbers with the smallest difference. If there are 
multiple pairs, output all of them in ascending order, all on the same 
line (consecutively) with just a single space between each pair of numbers. 
If there's a number which lies in two pair, print it two times 
*/
package sample.test;
import java.util.*;

public class ClosestNumbers {
	
	public static void main(String[] args){
		int[] a = new int[20];
		int countPairs=0;
		Scanner sc = new Scanner(System.in);
		System.out.println("enter the size of array");
		int n = sc.nextInt();
		for(int i=0;i<n;i++){
			System.out.println("Enter the values");
			a[i]=sc.nextInt();
		}
		int[][] b = new int[n][3];
		bubbleSort(a,n);
		for(int i=0;i<n;i++){
			/*
			 * When the program starts the difference between the first 
			 * two numbers is always considered smallest. So they are stored 
			 * in the new array. 
			 */
			if(i==0){
				b[0][0]=a[i]-a[i+1] >0?a[i]-a[i+1]:-1*(a[i]-a[i+1]);
				b[0][1]=a[i];
				b[0][2]=a[i+1];
				countPairs++;
			}
			else{
				/*
				 * If not, we check if the already stored pair is greater than the
				 * value we have in the array. If so, then we put the value in the 
				 * new array
				 */
				if(b[countPairs-1][0]>(a[i]-a[i+1] >0?a[i]-a[i+1]:-1*(a[i]-a[i+1]))){
					System.out.println("here");
					b[0][0]=a[i]-a[i+1] >0?a[i]-a[i+1]:a[i+1]-a[i];
					System.out.println("val is "+b[0][0]);
					b[0][1]=a[i];
					b[0][2]=a[i+1];
					//countPairs++;
				}
				/*
				 * We can also have more than 1 pair of numbers giving the same 
				 * absolute difference, so the following case takes care of that
				 * condition.
				 */
				else if(b[countPairs-1][0]==(a[i]-a[i+1] >0?a[i]-a[i+1]:-1*(a[i]-a[i+1]))){
					b[countPairs][0]=a[i]-a[i+1] >0?a[i]-a[i+1]:a[i+1]-a[i];
					b[countPairs][1]=a[i];
					b[countPairs][2]=a[i+1];
					countPairs++;
				}
				/*
				 * otherwise, we simply continue
				 */
				else
					continue;
			}
		}
		for(int i=0;i<countPairs;i++){
			System.out.println(""+b[i][1]+","+b[i][2]);
		}
	}
	//Sort the numbers before the counting the pairs
	public static void bubbleSort(int[] a,int n)
	{
		int temp=0;
		//n=a.length;
		for(int i=0;i<n;i++)
		{
			for(int j=0;j<n-1;j++)
			{
				if(j!=n && (a[j]>a[j+1]))
				{
					temp=a[j];
					a[j]=a[j+1];
					a[j+1]=temp;
				}
			}
			
		}
		for (int k=0;k<n;k++)
		{
			System.out.print(a[k]+":");
		}
		
	}
}
