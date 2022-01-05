import java.util.Stack;

public class DecodeTheString {
    public static String decodedString(String str){
        // code here
        Stack<Integer> integerstack = new Stack<>();
        Stack<Character> stringstack = new Stack<>();
        String temp = "", result = "";
      
        for (int i = 0; i < str.length(); i++) {
            int count = 0;

            if (Character.isDigit(str.charAt(i))) {
                while (Character.isDigit(str.charAt(i))) {
                    count = count * 10 + str.charAt(i) - '0';
                    i++;
                }
                i--;
                integerstack.push(count);
            }
            else if (str.charAt(i) == ']') {
                temp = "";
                count = 0;
                if (!integerstack.isEmpty()) {
                    count = integerstack.peek();
                    integerstack.pop();
                }
                while (!stringstack.isEmpty() && stringstack.peek()!='[' ) {
                    temp = stringstack.peek() + temp;
                    stringstack.pop();
                }
                if (!stringstack.empty() && stringstack.peek() == '[')
                    stringstack.pop();
      
                for (int j = 0; j < count; j++)
                    result = result + temp;
      
                for (int j = 0; j < result.length(); j++)
                    stringstack.push(result.charAt(j));
      
                result = "";
            }
            else if (str.charAt(i) == '[') {
                if (Character.isDigit(str.charAt(i-1)))
                    stringstack.push(str.charAt(i));
                else {
                    stringstack.push(str.charAt(i));
                    integerstack.push(1);
                }
            }
            else
                stringstack.push(str.charAt(i));
        }
      
        // Pop all the element, make a string and return.
        while (!stringstack.isEmpty()) {
            result = stringstack.peek() + result;
            stringstack.pop();
        }
      
        return result;
    }

    public static void main(String[] args) {
        System.out.println(decodedString("3[b2[ca]]"));
    }
}
