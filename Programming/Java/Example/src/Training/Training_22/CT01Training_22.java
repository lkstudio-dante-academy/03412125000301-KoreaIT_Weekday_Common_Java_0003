package Training.Training_22;

/*
 * Java 연습 문제 22
 * - 회문 여부 검사하기
 * - 사용자로부터 문자열을 입력 받은 해당 문자열이 회문인지 검사하는
 * 메서드를 구현한다 (+ 단, 대/소문자 구분 X)
 *
 * Ex)
 * 문자열 입력 : Level
 * 회문 여부 : true
 */

import java.util.Scanner;

/**
 * Training 22
 */
public class CT01Training_22 {
	/** 초기화 */
	public static void start(String[] args) {
		Scanner oScanner = new Scanner(System.in);
		
		System.out.print("문자열 입력 : ");
		String oStr = oScanner.nextLine();
		
		boolean bIsResult = isPalindrome(oStr);
		System.out.printf("회문 여부 : %s\n", bIsResult);
	}
	
	/** 회문 여부를 검사한다 */
	private static boolean isPalindrome(String a_oStr) {
		int nLeft = 0;
		int nRight = a_oStr.length() - 1;
		
		while(nLeft < nRight) {
			char chLetterA = a_oStr.charAt(nLeft);
			char chLetterB = a_oStr.charAt(nRight);
			
			// 문자가 다를 경우
			if(Character.toUpperCase(chLetterA) != Character.toUpperCase(chLetterB)) {
				return false;
			}
			
			nLeft += 1;
			nRight -= 1;
		}
		
		return true;
	}
}
