package Training.Training_07;

/*
 * Java 연습 문제 7
 * - 업/다운 게임 제작하기
 * - 1 ~ 99 사이의 수 중 하나를 랜덤하게 선택한다
 * - 사용자로부터 정수를 입력 받아 정답 여부를 검사한다
 * - 정답이 아닐 정답을 유추 할 수 있게 가이드 메세지 출력
 * - 정답 일 경우 프로그램을 종료한다
 *
 * Ex)
 * 정답 : 45
 *
 * 정수 입력 : 40
 * 정답은 40 보다 큽니다.
 *
 * 정수 입력 : 60
 * 정답은 60 보다 작습니다.
 *
 * 정수 입력 : 45
 * 프로그램을 종료합니다.
 */

import java.util.Random;
import java.util.Scanner;

/**
 * Training 7
 */
public class CT01Training_07 {
	/** 초기화 */
	public static void start(String[] args) {
		Random oRandom = new Random();
		Scanner oScanner = new Scanner(System.in);
		
		int nAnswer = oRandom.nextInt(1, 100);
		System.out.printf("정답 : %d\n\n", nAnswer);
		
		int nVal = 0;
		
		do {
			System.out.print("정수 입력 : ");
			nVal = oScanner.nextInt();
			
			// 정답 일 경우
			if(nVal == nAnswer) {
				continue;
			}
			
			String oMsg = (nVal <= nAnswer) ? "큽니다." : "작습니다.";
			System.out.printf("정답은 %d 보다 %s\n\n", nVal, oMsg);
		} while(nVal != nAnswer);
		
		System.out.println("프로그램을 종료합니다.");
	}
}
