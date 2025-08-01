package Training.Training_19;

/*
 * Java 연습 문제 19
 * - 달팽이 형태로 초기화하기
 * - 크기를 입력 받은 후 해당 크기만큼 2 차원 배열을 생성한다
 * - 생성 된 배열을 반복문을 이용해서 1 부터 차례대로 달팽이 형태로 초기화한다
 *
 * Ex)
 * 크기 입력 : 5
 *
 * =====> 2 차원 배열 <=====
 *  1,  2,  3,  4,  5
 * 16, 17, 18, 19,  6
 * 15, 24, 25, 20,  7
 * 14, 23, 22, 21,  8
 * 13, 12, 11, 10,  9
 */

import java.util.Scanner;

/**
 * Training 19
 */
public class CT01Training_19 {
	/** 초기화 */
	public static void start(String[] args) {
		Scanner oScanner = new Scanner(System.in);
		
		System.out.print("크기 입력 : ");
		int nSize = oScanner.nextInt();
		
		int[][] oMatrix = new int[nSize][nSize];
		
		int i = 0;
		int j = -1;
		
		int nTimes = oMatrix.length;
		int nDirection = 1;
		
		int nVal = 0;
		int nVal_Max = oMatrix.length * oMatrix[0].length;
		
		while(nVal < nVal_Max) {
			for(int k = 0; k < nTimes; ++k) {
				j += nDirection;
				oMatrix[i][j] = ++nVal;
			}
			
			nTimes -= 1;
			
			for(int k = 0; k < nTimes; ++k) {
				i += nDirection;
				oMatrix[i][j] = ++nVal;
			}
			
			nDirection = -nDirection;
		}
		
		System.out.println("\n=====> 2 차원 배열 <=====");
		
		for(i = 0; i < oMatrix.length; ++i) {
			for(j = 0; j < oMatrix[i].length; ++j) {
				System.out.printf("%3d, ", oMatrix[i][j]);
			}
			
			System.out.println();
		}
	}
}
