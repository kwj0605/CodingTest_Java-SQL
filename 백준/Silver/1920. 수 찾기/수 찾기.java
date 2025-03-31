import java.util.*;

public class Main
{
	public static void main(String[] args) {
	    Scanner sc = new Scanner(System.in);
	    
	    int n = sc.nextInt();
	    int[] f = new int[n];
	    for(int i=0; i<n; i++) {
	        f[i] = sc.nextInt();
	    }
	    
	    int m = sc.nextInt();
	    int[] s = new int[m];
	    for(int i=0; i<m; i++) {
	        s[i] = sc.nextInt();
	    }
	    sc.close();
	    
	    Arrays.sort(f);
	    
	    for(int i=0; i<m; i++) {
	        int min = 0;
	        int max = n-1;
	        int mid;
	        boolean a = false;
	        while(min <= max) {
	            mid = (min+max)/2;
	            if(s[i]==f[mid]) {
	                a = true;
	                break;
	            } else if(s[i] < f[mid]) {
	                max = mid-1;
	            } else {
	                min = mid+1;
	            }
	        }
	        if(a) {
	            System.out.println(1);
	        } else {
	            System.out.println(0);
	        }
	    }
	}
}