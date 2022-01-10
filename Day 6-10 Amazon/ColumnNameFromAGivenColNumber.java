public class ColumnNameFromAGivenColNumber {
    public static void main(String[] args) {
        System.out.println(colName(28));
    }

    static String colName (long n)
    {
        // your code here
        String res = ""; 
    
    	long temp;
    	while (n > 0)
    	{
    	    n--;
    		temp = n % 26;
    		res += (char)('A' + temp);
    		n /= 26;
    	}
    	int len = res.length ();
    	String ans = "";
    	for (int  i = len - 1; i >= 0; i--)
    	    ans += res.charAt (i);
    	return ans;
    }
}
