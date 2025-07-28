package Training.Training_11;

/*
 * Java 연습 문제 11
 * - 구구단 출력하기
 * - 2 ~ 9 까지 구구단 결과를 출력한다
 * - 단, 한 라인에 최대 3 개의 구구단 동시에 출력되어야한다
 *
 * Ex)
 * 2 * 1 = 2	3 * 1 = 3	4 * 1 = 4
 * 2 * 2 = 4	3 * 2 = 6	4 * 2 = 8
 * 2 * 3 = 6	3 * 3 = 9	4 * 3 = 12
 * ...이하 생략
 *
 * 5 * 1 = 5	6 * 1 = 6	7 * 1 = 7
 * 5 * 2 = 10	6 * 2 = 12	7 * 2 = 14
 * 5 * 3 = 15	6 * 3 = 18	7 * 3 = 21
 * ...이하 생략
 *
 * 8 * 1 = 8	9 * 1 = 9
 * 8 * 2 = 16	9 * 2 = 18
 * 8 * 3 = 24	9 * 3 = 27
 * ...이하 생략
 */

import java.util.Scanner;

/**
 * Training 11
 */
public class CT01Training_11 {
	/** 초기화 */
	public static void start(String[] args) {
		Scanner oScanner = new Scanner(System.in);
		
		for(int i = 2; i < 10; i += 3) {
			for(int j = 1; j < 10; ++j) {
				for(int k = 0; k < 3; ++k) {
					// 구구단 출력이 불가능 할 경우
					if(k + i >= 10) {
						continue;
					}
					
					System.out.printf("%d * %d = %-4d", k + i, j, (k + i) * j);
				}
				
				System.out.println();
			}
			
			System.out.println();
		}
	}
}
