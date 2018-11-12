/**
 * importing files.
 */
import java.util.Scanner;
/**
 * solution class.
 */
 public class Solution{
 	public static void main(String[] args) {
 		Scanner sc = new Scanner(System.in);
 		LSD lsd = new LSD();
 		int n = Integer.parseInt(sc.nextLine());
 	    String[] arr = new String[n];

 		for(int i=0;i<n;i++){
 			arr[i]= sc.nextLine();
 		}
 	    int len = arr[1].length();

 		lsd.sort(arr,len);
 	}
 }