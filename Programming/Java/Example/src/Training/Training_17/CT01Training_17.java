package Training.Training_17;

/*
 * Java 연습 문제 17
 * - 2 차원 배열 치환하기
 * - 5 x 5 2 차원 배열을 생성 후 1 ~ 15 사이의 수로 랜덤하게 초기화한다
 * - 사용자로부터 위치를 입력 받는다
 * - 입력 받은 위치를 기준으로 상/하/좌/우 에 존재하는 모든 1 자릿 수 요소를 -1 로 치환한다
 *
 * Ex)
 * =====> 배열 <=====
 *  1, 10,  5
 *  2,  4,  6
 * 12, 15,  4
 *
 * 위치 입력 (행, 열) : 2 0
 *
 * =====> 배열 - 치환 후 <=====
 * -1, 10,  5
 * -1,  4,  6
 * 12, 15, -1
 */

import java.util.Random;
import java.util.Scanner;

/**
 * Training 17
 */
public class CT01Training_17 {
	/** 초기화 */
	public static void start(String[] args) {
		Random oRandom = new Random();
		Scanner oScanner = new Scanner(System.in);
		
		int[][] oMatrix = new int[5][5];
		
		for(int i = 0; i < oMatrix.length; ++i) {
			for(int j = 0; j < oMatrix[i].length; ++j) {
				int nVal = oRandom.nextInt(1, 16);
				oMatrix[i][j] = nVal;
			}
		}
		
		System.out.println("=====> 배열 <=====");
		
		for(int i = 0; i < oMatrix.length; ++i) {
			for(int j = 0; j < oMatrix[i].length; ++j) {
				System.out.printf("%2d, ", oMatrix[i][j]);
			}
			
			System.out.println();
		}
		
		System.out.print("\n위치 입력 (행, 열) : ");
		
		int nRow = oScanner.nextInt();
		int nCol = oScanner.nextInt();
		
		for(int i = 0; i < oMatrix[0].length; ++i) {
			// 치환이 불가능 할 경우
			if(oMatrix[nRow][i] >= 10) {
				continue;
			}
			
			oMatrix[nRow][i] = -1;
		}
		
		for(int i = 0; i < oMatrix.length; ++i) {
			// 치환이 불가능 할 경우
			if(oMatrix[i][nCol] >= 10) {
				continue;
			}
			
			oMatrix[i][nCol] = -1;
		}
		
		System.out.println("\n=====> 배열 - 치환 후 <=====");
		
		for(int i = 0; i < oMatrix.length; ++i) {
			for(int j = 0; j < oMatrix[i].length; ++j) {
				System.out.printf("%2d, ", oMatrix[i][j]);
			}
			
			System.out.println();
		}
	}
}
