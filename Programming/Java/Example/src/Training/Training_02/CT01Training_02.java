package Training.Training_02;

/*
 * Java 연습 문제 2
 * - 학점 계산 프로그램 제작하기
 * - 점수를 입력 받아 점수에 해당하는 학점 출력하기 (+ 단, F 는 세부 학점 출력 X)
 *
 * 세부 학점 범위
 * - 0 ~ 3 : -
 * - 4 ~ 6 : 0
 * - 7 ~ 9 : +
 *
 * Ex)
 * 점수 입력 : 95
 * A0 학점입니다.
 */

import java.util.Scanner;

/**
 * Training 2
 */
public class CT01Training_02 {
	/** 초기화 */
	public static void start(String[] args) {
		Scanner oScanner = new Scanner(System.in);
		
		System.out.print("점수 입력 : ");
		int nScore = oScanner.nextInt();
		
		String oGrade = "";
		String oGrade_Detail = "";
		
		// F 학점 일 경우
		if(nScore < 60) {
			oGrade = "F";
		} else {
			// A 학점 일 경우
			if(nScore >= 90) {
				oGrade = "A";
			}
			// B 학점 일 경우
			else if(nScore >= 80) {
				oGrade = "B";
			}
			// C 학점 일 경우
			else if(nScore >= 70) {
				oGrade = "C";
			}
			// D 학점일 경우
			else {
				oGrade = "D";
			}
			
			// + 학점 일 경우
			if(nScore >= 100 || nScore % 10 >= 7) {
				oGrade_Detail = "+";
			} else {
				oGrade_Detail = (nScore % 10 <= 3) ? "-" : "0";
			}
		}
		
		System.out.printf("%s%s 학점입니다.\n", oGrade, oGrade_Detail);
	}
}
