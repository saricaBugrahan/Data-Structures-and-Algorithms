//Description: This class is the where the main algorithm is written.
public class Program {
    public void program(String T)
    {
        LinkImpStack<Character> brackets = new LinkImpStack<Character>();
        LinkImpStack<Integer> indexCount = new LinkImpStack<Integer>();
        boolean isMatched = true;
        char[] textChars = {'(',')','{','}','[',']','0','1','2','3','4','5','6','7','8','9','+','-','*','/',' '};

            //Create nested loop for checking the every element in the text whether is matching with the textChars element or not.
            String text = T;

            for (int i =0; i<text.length();i++)
            {
                int count = 0;
                for(int j = 0;j<textChars.length;j++)
                {
                    if(text.charAt(i) == textChars[j])
                    {
                        count++;
                    }
                }
                //If it is 1 it should at least 1 match and it's true.
                //Others values will be the unmatched elements and print Invalid Parse.
                if(count != 1)
                {
                    System.out.println("Invalid Parse");
                    System.exit(0);
                }
                //To avoid the white spaces.
                text = text.trim();
                //Start pushing open brackets into the brackets stack.
                char ch = text.charAt(i);
                if(ch == '(' || ch == '['|| ch == '{')
                {
                    //Save the location and the opening brackets.
                    brackets.push(ch);
                    indexCount.push(i);
                }
                //To check whether brackets stack is empty or not because we are popping in the next step.
                if(brackets.isEmpty())
                {
                    if(ch == ')' || ch == '}'|| ch == ']')
                    {
                        char ch2 = brackets.pop();
                        //If its matched ch and ch2 then print it.
                        if((ch == ')' && ch2 == '(') || (ch == '}' && ch2 =='{') || (ch ==']' && ch2 == '['))
                        {
                            int temp = indexCount.pop();
                            System.out.print(temp+","+i+",");
                            for(int j = temp; j<=i; j++)
                            {
                                System.out.print(text.charAt(j));
                            }
                            System.out.println();
                        }
                        else{
                            isMatched = false;
                        }
                    }
                }
                //If brackets is empty and ch is closing bracket, then it is not in well form
                else{
                    if(ch == ')' || ch == '}' || ch == ']' )
                    {
                        isMatched = false;
                    }
                }
            }
            //If text loop is ended and brackets stack is not empty, then it is not in well form.
            if(brackets.isEmpty())
            {
                isMatched = false;
            }
            if(isMatched)
            {
                System.out.println("Given expression is well formed.");
            }
            else {
                System.out.println("Given expression is not well formed.");
            }
    }
}
