package Training.Training_24;

/*
 * Java 연습 문제 24
 * - 행렬 곱셈 구현하기
 * - 사용자로부터 행렬 A 와 행렬 B 의 크기를 입력 받는다
 * - 입력 받은 크기로 행렬 A 와 행렬 B 를 생성 후 1 ~ 99 사이의 수로 랜덤하게 초기화한다
 * - 초기화가 완료 된 행렬의 곱셈 결과를 출력한다
 * - 단, 곱셈이 불가능 할 경우 곱셈이 불가능하다는 메세지를 출력한다
 *
 * Ex)
 * 행렬 A 크기 입력 (행, 열) : 3 3
 * 행렬 B 크기 입력 (행, 열) : 3 3
 *
 * =====> 행렬 - A <=====
 * 1, 2, 3
 * 4, 5, 6
 * 7, 8, 9
 *
 * =====> 행렬 - B <=====
 * 10, 20, 30
 * 40, 50, 60
 * 70, 80, 90
 *
 * Case 1. 곱셈이 가능 할 경우
 * =====> 결과 <=====
 *
 * Case 2. 곱셈이 불가능 할 경우
 * 행렬 A 와 행렬 B 는 곱셈이 불가능합니다.
 */

import java.util.Random;
import java.util.Scanner;

/**
 * Training 24
 */
public class CT01Training_24 {
	/** 초기화 */
	public static void start(String[] args) {
		Scanner oScanner = new Scanner(System.in);
		
		System.out.print("행렬 A 크기 입력 (행, 열) : ");
		int nNumRowsA = oScanner.nextInt();
		int nNumColsA = oScanner.nextInt();
		
		System.out.print("행렬 B 크기 입력 (행, 열) : ");
		int nNumRowsB = oScanner.nextInt();
		int nNumColsB = oScanner.nextInt();
		
		int[][] oMatrixA = new int[nNumRowsA][nNumColsA];
		int[][] oMatrixB = new int[nNumRowsB][nNumColsB];
		
		setupMatrix(oMatrixA);
		setupMatrix(oMatrixB);
		
		System.out.println("\n=====> 행렬 - A <=====");
		printMatrix(oMatrixA);
		
		System.out.println("\n=====> 행렬 - B <=====");
		printMatrix(oMatrixB);
		
		// 곱셈이 불가능 할 경우
		if(nNumColsA != nNumRowsB) {
			System.out.println("\n행렬 A 와 행렬 B 는 곱셈이 불가능합니다.");
			return;
		}
		
		int[][] oResult = new int[nNumRowsA][nNumColsB];
		
		for(int i = 0; i < nNumRowsA; ++i) {
			for(int j = 0; j < nNumColsB; ++j) {
				for(int k = 0; k < nNumRowsB; ++k) {
					int nValA = oMatrixA[i][k];
					int nValB = oMatrixB[k][j];
					
					oResult[i][j] += nValA * nValB;
				}
			}
		}
		
		System.out.println("\n=====> 결과 <=====");
		printMatrix(oResult);
	}
	
	/** 행렬을 설정한다 */
	private static void setupMatrix(int[][] a_oMatrix) {
		Random oRandom = new Random();
		
		for(int i = 0; i < a_oMatrix.length; ++i) {
			for(int j = 0; j < a_oMatrix[i].length; ++j) {
				a_oMatrix[i][j] = oRandom.nextInt(0, 99) + 1;
			}
		}
	}
	
	/** 행렬을 출력한다 */
	private static void printMatrix(int[][] a_oMatrix) {
		for(int i = 0; i < a_oMatrix.length; ++i) {
			for(int j = 0; j < a_oMatrix[i].length; ++j) {
				System.out.printf("%5d, ", a_oMatrix[i][j]);
			}
			
			System.out.println();
		}
	}
}
