package Training.Training_33;

/*
 * Java 연습 문제 33
 * - 문자열 중복 여부 검사하기
 * - 사용자로부터 문자열을 입력 받아 문자열 내부에 존재하는 문자 중 중복 문자 존재 여부를 검사한다
 * - 단, 대/소문자 구분 X
 *
 * Ex)
 * 문자열 입력 : String
 * 중복 여부 : Fales
 *
 * 문자열 입력 : Level
 * 중복 여부 : True
 */

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

/**
 * Training 33
 */
public class CT01Training_33 {
	/** 초기화 */
	public static void start(String[] args) {
		Scanner oScanner = new Scanner(System.in);
		
		System.out.print("문자열 입력 : ");
		String oStr = oScanner.nextLine();
		
		boolean bIsDuplicate = isDuplicate(oStr);
		System.out.printf("중복 여부 : %s\n", bIsDuplicate);
	}
	
	/** 중복 여부를 검사한다 */
	private static boolean isDuplicate(String a_oStr) {
		Set<Character> oSetLetters = new HashSet<>();
		
		for(int i = 0; i < a_oStr.length(); ++i) {
			oSetLetters.add(Character.toLowerCase(a_oStr.charAt(i)));
		}
		
		return a_oStr.length() != oSetLetters.size();
	}
}
