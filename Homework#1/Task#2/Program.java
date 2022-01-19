//Description: This class is the where the main algorithm is written.


public class Program {
    public void fillQue(LinkImpQue que, String text) {
        //To fill the queue's with the proper indexes according to the isGoodString method.
        for (int i = 0; i < text.length(); i++) {
            if (isGoodString(text.substring(i)))
                que.enqueue(i);
        }
    }
    public boolean isGoodString(String T) {
        //Compare the engAlphabet with our text.
        //If it's 0 then you did not match any of the engAlphabet, then it's not a good String
        boolean isGoodStr = true;
        char [] textChars = T.toCharArray();
        char[] engAlphabet = {'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k', 'l', 'm', 'n', 'o', 'p', 'q', 'r', 's', 't', 'u', 'v', 'w', 'x', 'y', 'z'};
        for (int i = 0; i < engAlphabet.length; i++) {
            int count = 0;
            for (int j = 0; j < T.length(); j++) {
                if (engAlphabet[i] == textChars[j]) count++;
            }
            if (count == 0) {
                isGoodStr = false;
            }
        }
        return isGoodStr;
    }
    public void program(String text) {
            LinkImpQue<Integer> queOriginal = new LinkImpQue<Integer>();
            LinkImpQue<Integer> queReverse = new LinkImpQue<Integer>();
            int goodValue = 0;
            String reverse = "";
            String temp = text;
            //We are reversing the text to check the extra letters from back.
            for (int i = temp.length() - 1; i >= 0; i--) {
                reverse += temp.charAt(i);
            }
            //Filling the methods with the proper value
            fillQue(queOriginal, temp);
            fillQue(queReverse, reverse);
            //We need to assaing the size of queue because whenever we pop it's decreasing and it effects the loop wrongly.
            int queOriginalSize = queOriginal.size;
             int queReverseSize = queReverse.size;
            //At first we hold the beginning point and start deque from behind.
            //Then according to queues it's matching them.
            for (int i = 0; i < queOriginalSize; i++) {
                int a = queOriginal.dequeue();
                if (isGoodString(temp.substring(a))) {
                    //We need to refill because it's empty now.
                    if (i != queOriginalSize - 1)
                        fillQue(queReverse, reverse);
                    for (int j = 0; j < queReverseSize; j++) {
                        int ct = queReverse.dequeue();
                        if (isGoodString(reverse.substring(ct, reverse.length() - a))) {
                            goodValue++;
                        }
                    }
                }
            }
            System.out.println(goodValue);
    }
}
