package Training.Training_03;

/*
 * Java 연습 문제 3
 * - 특정 자리 비트를 끄는 프로그램 제작하기
 * - 사용자로부터 정수를 입력 받아 해당 정수를 2 진수 형태로 출력한다
 * - 위치를 입력 받은 후 해당 위치에 있는 비트를 끄는 연산 추가하기
 * - 위치는 가장 오른쪽 비트를 0 으로 시작해서 왼쪽으로 갈 수록 1 씩 증가한다
 *
 * Ex)
 * 정수 입력 : 10
 * 2 진수 출력 (변환 전) : 1010
 *
 * 위치 입력 : 1
 * 2 진수 출력 (변환 후) : 1000
 */

import java.util.Scanner;

/**
 * Training 3
 */
public class CT01Training_03 {
	/** 초기화 */
	public static void start(String[] args) {
		Scanner oScanner = new Scanner(System.in);
		
		System.out.print("정수 입력 : ");
		int nVal = oScanner.nextInt();
		
		System.out.printf("2 진수 출력 (변환 전) : %s\n",
				Integer.toString(nVal, 2));
		
		System.out.print("\n위치 입력 : ");
		int nPos = oScanner.nextInt();
		
		int nResult = nVal & ~(1 << nPos);
		
		System.out.printf("2 진수 출력 (변환 후) : %s\n",
				Integer.toString(nResult, 2));
	}
}
