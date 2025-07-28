package Training.Training_10;

/*
 * Java 연습 문제 10
 * - 세로 다이어그램 출력하기
 * - 사용자로부터 정수 3 개를 입력 받는다
 * - 입력 받은 정수만큼 세로로 다이어그램 출력하기
 *
 * Ex)
 * 정수 (3 개) 입력 : 3 1 5
 * *  *  *
 * *     *
 * *     *
 *       *
 *       *
 */

import java.util.Scanner;

/**
 * Training 10
 */
public class CT01Training_10 {
	/** 초기화 */
	public static void start(String[] args) {
		Scanner oScanner = new Scanner(System.in);
		System.out.print("정수 (3 개) 입력 : ");
		
		int nValA = oScanner.nextInt();
		int nValB = oScanner.nextInt();
		int nValC = oScanner.nextInt();
		
		int nVal_Max = (nValA >= nValB) ? nValA : nValB;
		nVal_Max = (nValC >= nVal_Max) ? nValC : nVal_Max;
		
		for(int i = 0; i < nVal_Max; ++i) {
			String oStrA = (i < nValA) ? "*" : " ";
			String oStrB = (i < nValB) ? "*" : " ";
			String oStrC = (i < nValC) ? "*" : " ";
			
			System.out.printf("%s %s %s\n", oStrA, oStrB, oStrC);
		}
	}
}
