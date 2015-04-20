package co.kr.godo.exam.SortNSuffle;

import java.util.Scanner;

public class SrotNSuffleMain {
    public static void main(String[] args) {
        String inputString = getSystemInputString();
        SortNSuffle sortNSuffle = new SortNSuffle();
        System.out.println(sortNSuffle.doing(inputString, new NumberCharacterShuffleStrategy()));
    }

	@SuppressWarnings("resource")
	public static String getSystemInputString() {
		Scanner scanInputString = new Scanner(System.in);
        System.out.println("String을 입력하세요 : ");
        String inputString = scanInputString.nextLine();
		return inputString;
	}
}
