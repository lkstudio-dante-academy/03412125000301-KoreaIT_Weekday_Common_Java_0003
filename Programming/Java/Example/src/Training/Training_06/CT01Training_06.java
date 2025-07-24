package Training.Training_06;

/*
 * Java 연습 문제 6
 * - 합계/평균 출력하기
 * - 사용자로부터 정수를 입력 받은 후 해당 점수가 0 이상이라면 값을 누적한다
 * - 입력 받은 정수가 0 이하 일 경우 입력 받는 것을 종료하고
 * 합계와 평균을 출력한다 (+ 즉, 1 이상의 수가 입력 되면 계속 수를 입력 받는다)
 *
 * Ex)
 * 1 번째 정수 입력 : 1
 * 2 번째 정수 입력 : 2
 * 3 번째 정수 입력 : 3
 * 4 번째 정수 입력 : 0
 *
 * =====> 결과 <=====
 * 합계 : 6
 * 평균 : 2
 */

import java.util.Scanner;

/**
 * Training 6
 */
public class CT01Training_06 {
	/** 초기화 */
	public static void start(String[] args) {
		Scanner oScanner = new Scanner(System.in);
		
		int nVal = 0;
		int nVal_Sum = 0;
		
		int nNumValues = 0;
		
		do {
			System.out.printf("%d 번째 정수 입력 : ", nNumValues + 1);
			nVal = oScanner.nextInt();
			
			// 값이 유효 할 경우
			if(nVal > 0) {
				nVal_Sum += nVal;
				nNumValues += 1;
			}
		} while(nVal > 0);
		
		float fAverage = nVal_Sum / (float)nNumValues;
		
		System.out.println("\n=====> 결과 <=====");
		System.out.printf("합계 : %d\n", nVal_Sum);
		System.out.printf("평균 : %f\n", fAverage);
	}
}
