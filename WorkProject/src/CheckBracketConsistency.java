import java.util.Stack;

public class CheckBracketConsistency {
    public static boolean Validate(CharStream cs)  {
        Stack<Character> stack = new Stack<Character>();
        Integer position = 0;
        Character expected = 0;
        while (cs.hasNext()) {            
            switch (cs.next()) {
                case '(':
                    stack.push(')');
                    break;
                case ')':
                    expected = stack.pop();
                    if (expected.compareTo(')') != 0) {
                        System.out.print("Expected " + expected.toString() + " at index " + position.toString() + ".");
                        return false;
                    }                       
                    break;
                case '[':
                    stack.push(']');
                    break;
                case ']':
                    expected = stack.pop();
                    if (expected.compareTo(']') != 0) {
                        System.out.print("Expected " + expected.toString() + " at index " + position.toString() + ".");
                        return false;
                    }                       
                    break;
                default:
                    // Unknown character
                    return false;
            }
            position++;
        }        
        return stack.empty();
    }   
    
    public boolean isValid(CharStream in) {
        return isValidImpl(in, 0, 0);
    }

    public boolean isValidImpl(CharStream in, int parenthesesIndex, int bracketsIndex)
    {
    	if (!in.hasNext())
    		return parenthesesIndex == 0 && bracketsIndex == 0;
    	
    	if (parenthesesIndex < 0 || bracketsIndex < 0)
    		return false;

    	char ch = in.next();

    	if (ch == '(') return isValidImpl(in, parenthesesIndex+1, bracketsIndex);
    	if (ch == ')') return isValidImpl(in, parenthesesIndex-1, bracketsIndex);
    	if (ch == '[') return isValidImpl(in, parenthesesIndex, bracketsIndex+1);
    	if (ch == ']') return isValidImpl(in, parenthesesIndex, bracketsIndex-1);
    	
    	return isValidImpl(in, parenthesesIndex, bracketsIndex);
    }
}
