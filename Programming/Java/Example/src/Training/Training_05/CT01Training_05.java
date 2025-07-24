package Training.Training_05;

/*
 * Java 연습 문제 5
 * - 세부 학점 계산하기 (+ switch ~ case 활용)
 * - 세부 사항은 연습 문제 2 번 참고
 */

import java.util.Scanner;

/**
 * Training 5
 */
public class CT01Training_05 {
	/** 초기화 */
	public static void start(String[] args) {
		Scanner oScanner = new Scanner(System.in);
		
		System.out.print("점수 입력 : ");
		int nScore = oScanner.nextInt();
		
		String oGrade = "";
		String oGrade_Detail = "";
		
		switch(nScore / 10) {
			case 9:
			case 10:
				oGrade = "A";
				break;
				
			case 8:
				oGrade = "B";
				break;
				
			case 7:
				oGrade = "C";
				break;
				
			case 6:
				oGrade = "D";
				break;
				
			default:
				oGrade = "F";
				break;
		}
		
		switch(nScore % 10) {
			case 0:
			case 1:
			case 2:
			case 3:
				oGrade_Detail = "-";
				break;
				
			case 4:
			case 5:
			case 6:
				oGrade_Detail = "0";
				break;
				
			default:
				oGrade_Detail = "+";
				break;
		}
		
		switch(nScore) {
			case 100:
				oGrade_Detail = "+";
				break;
		}
		
		switch(oGrade) {
			case "F":
				oGrade_Detail = "";
				break;
		}
		
		System.out.printf("%s%s 학점입니다.\n", oGrade, oGrade_Detail);
	}
}
