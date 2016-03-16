
import java.util.ArrayList;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author rj
 */
public class CodeWordChecker {
    
    public static boolean hasErrors(String codeWord, String parity) {
        int r = (int)(Math.log(codeWord.length())/Math.log(2)) + 1;
        int[] checkBitPos = new int[r];
        checkBitPos[0] = 0;
        
        for (int i = 1, j = 1; i < checkBitPos.length; i++) {
            checkBitPos[i] = (j*=2) - 1;
        }
        
                //get next parity bit
        for (int i = 0; i < checkBitPos.length; i++) {
            int count = 0;
            int skip = checkBitPos[i] + 1;
            //skip
            for (int j = skip - 1; j < codeWord.length(); j += skip) {
                //check
                for (int k = 0; k < skip && j < codeWord.length(); k++, j++ ) {
                    if (codeWord.charAt(j) == '1') {
                        count++;
                    }
                }
            }
            
            if(parity.equals("even")) {
                if (count % 2 == 1) 
                    return true;
            } else {
                if (count % 2 == 0) 
                    return true;
            }
        }
        return false;
    }
    
    
}
