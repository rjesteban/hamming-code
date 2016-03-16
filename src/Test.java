
import java.util.Scanner;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author rj
 */
public class Test {
    public static void main(String[] args) {
        String code = "";
        String parity = "";
        
        Scanner sc = new Scanner(System.in);
        
        System.out.println("Construct or Check?");
        String choice = sc.nextLine();
        
        if (choice.equals("Construct")) {
            System.out.println("Input code:");
            code = sc.nextLine();
            System.out.println("Set parity:");
            parity = sc.nextLine();
            //CodeWord cwc = new CodeWord("1111000010101110", "even");
            CodeWord cwc = new CodeWord(code, parity);
            System.out.println(cwc.codeWord);
            System.out.println("Has errors? " + CodeWordChecker.hasErrors(cwc.codeWord, parity));
        } else {
            System.out.println("Input Code word:");
            String codeWord = sc.nextLine();
            System.out.println("Parity checker? (odd or even)");
            String _parity = sc.nextLine();
            System.out.println("Has errors? " + CodeWordChecker.hasErrors(codeWord, _parity));
            
        }
        
    }

}
