package Training.Training_14;

/*
 * Java 연습 문제 14
 * - 홀수/짝수 구분하기
 * - 사용자로부터 배열 길이를 입력받는다
 * - 입력 받은 길이만큼 배열을 생성 후 정수를 입력받는다
 * - 입력 받은 정수가 홀수 일 경우 배열의 왼쪽부터 값을 할당한다
 * - 입력 받은 정수가 짝수 일 경우 배열의 오른쪽부터 값을 할당한다
 *
 * Ex)
 * 크기 입력 : 5
 * 1 번째 정수 입력 : 1
 * 2 번째 정수 입력 : 2
 * 3 번째 정수 입력 : 3
 * 4 번째 정수 입력 : 4
 * 5 번째 정수 입력 : 5
 *
 * =====> 배열 <=====
 * 1, 3, 5, 4, 2
 */

import java.util.Scanner;

/**
 * Training 14
 */
public class CT01Training_14 {
	/** 초기화 */
	public static void start(String[] args) {
		Scanner oScanner = new Scanner(System.in);
		System.out.print("크기 입력 : ");
		
		int nSize = oScanner.nextInt();
		int[] oValues = new int[nSize];
		
		int nIdx_Odd = 0;
		int nIdx_Even = oValues.length - 1;
		
		for(int i = 0; i < oValues.length; ++i) {
			System.out.printf("%d 번째 정수 입력 : ", i + 1);
			int nVal = oScanner.nextInt();
			
			// 홀수 일 경우
			if(nVal % 2 != 0) {
				oValues[nIdx_Odd++] = nVal;
			} else {
				oValues[nIdx_Even--] = nVal;
			}
		}
		
		System.out.println("\n=====> 배열 <=====");
		
		for(int nVal : oValues) {
			System.out.printf("%d, ", nVal);
		}
		
		System.out.println();
	}
}
