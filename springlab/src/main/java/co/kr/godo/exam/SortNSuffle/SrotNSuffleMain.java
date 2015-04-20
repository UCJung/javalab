package co.kr.godo.exam.SortNSuffle;

import java.util.Scanner;

public class SrotNSuffleMain {
    public static void main(String[] args) {
        // input string by system io
        Scanner scanInputString = new Scanner(System.in);
        System.out.println("String을 입력하세요 : ");
        String inputString = scanInputString.nextLine();
        SortNSuffle sortNSuffle = new SortNSuffle();
        
        String result = sortNSuffle.doing(inputString, new NumberCharacterShuffleStrategy());
        System.out.println(result);
    }
}
