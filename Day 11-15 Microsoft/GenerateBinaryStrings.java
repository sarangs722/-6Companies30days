import java.util.ArrayList;

public class GenerateBinaryStrings {
    public static ArrayList<String> generate(int N)
    {
        ArrayList<String> al = new ArrayList<String>();
        for(int i=1; i<=N; i++){
            String binary = Integer.toBinaryString(i);
            al.add(binary);
        }
        return al;
    }

    public static void main(String[] args) {
        System.out.println(generate(5));
    }
}
