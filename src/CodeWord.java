
import java.util.ArrayList;
import java.util.Arrays;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author rj
 */
public class CodeWord {

    ArrayList<Character> code;
    String codeWord;
    String parity;
    int r;

    public CodeWord(String code, String parity) {
        this.code = new ArrayList<Character>();

        for (int i = 0; i < code.length(); i++) {
            this.code.add(code.charAt(i));
        }

        double checkBitsCount = Math.log(code.length());
        checkBitsCount /= Math.log(2);
        this.r = (int) checkBitsCount;
        this.r++;
        this.codeWord = construct(parity);
    }

    public String construct(String parity) {
        this.parity = parity;
        int m = this.code.size();
        char[] codeWord = new char[m + this.r];
        int[] checkBitPos = new int[this.r];
        ArrayList<Character> temp = new ArrayList<Character>(code);

        for (int i = 0, j = 1, k = 0; i < codeWord.length; i++) {
            if (i == j - 1) {
                j *= 2;
                checkBitPos[k] = i;
                k++;
            } else {

                codeWord[i] = temp.remove(0);
            }
        }
        
        //get next parity bit
        for (int i = 0; i < checkBitPos.length; i++) {
            int count = 0;
            int skip = checkBitPos[i] + 1;
            //skip
            for (int j = skip - 1; j < codeWord.length; j += skip) {
                //check
                for (int k = 0; k < skip && j < codeWord.length; k++, j++ ) {
                    if (codeWord[j] == '1') {
                        count++;
                    }
                }
            }
            
            if(parity.equals("even")) {
                if (count % 2 == 1) 
                    codeWord[skip-1] = '1';
                else 
                    codeWord[skip-1] = '0';
            } else {
                if (count % 2 == 1) 
                    codeWord[skip-1] = '0';
                else 
                    codeWord[skip-1] = '1';
            }

        }

        return String.valueOf(codeWord);
    }
}
