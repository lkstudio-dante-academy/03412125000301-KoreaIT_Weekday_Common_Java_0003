package Training.Training_25;

/*
 * Java 연습 문제 25
 * - 10 진수 -> 2 진수 로 출력하기 (+ 재귀 호출 활용)
 * - 사용자로부터 정수를 입력 받아 해당 정수를 2 진수 형태로 출력한다
 *
 * Ex)
 * 정수 입력 : 10
 * 결과 : 1010
 */

import java.util.Scanner;

/**
 * Training 25
 */
public class CT01Training_25 {
	/** 초기화 */
	public static void start(String[] args) {
		Scanner oScanner = new Scanner(System.in);
		
		System.out.print("정수 입력 : ");
		int nVal = oScanner.nextInt();
		
		String oStr_Binary = convert_ToBinary(nVal);
		System.out.printf("결과 : %s\n", oStr_Binary);
	}
	
	/** 10 진수 -> 2 진수 로 변환한다 */
	private static String convert_ToBinary(int a_nVal) {
		// 재귀 호출이 불가능 할 경우
		if(a_nVal <= 0) {
			return "";
		}
		
		String oStr_Binary = convert_ToBinary(a_nVal / 2);
		return oStr_Binary + String.format("%d", a_nVal % 2);
	}
}
