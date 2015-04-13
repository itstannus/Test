public class CareerCup {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
      CharSequence[] cs = new CharSequence[3];
      cs[0] = new String("(([]([]))");
      cs[1] = new String("([)]");
      cs[2] = new String("()(([]))([()])");
      for (int i = 0; i < 3; i++) {
          System.out.print("Checking sequence " + Integer.toString(i) + "...\n");
      if (! CheckBracketConsistency.Validate(cs[i]))      
          System.out.println("The input sequence is invalid. Might have left some paranthesis open.");
      else
          System.out.println("The input sequence is valid.");
      }
    }
    
}