package Training.Training_21;

/*
 * Java 연습 문제 21
 * - 중복 숫자 검사하기
 * - 길이 5 배열을 생성 후 1 ~ 9 사이의 수로 랜덤하게 초기화한다
 * - 배열의 중복 된 값의 존재 여부를 검사하는 메서드 구현하기
 *
 * Ex)
 * =====> 배열 <=====
 * 1, 3, 9, 8, 3
 *
 * 중복 요소 존재 여부 : true
 */

import java.util.Random;

/**
 * Training 21
 */
public class CT01Training_21 {
	/** 초기화 */
	public static void start(String[] args) {
		Random oRandom = new Random();
		int[] oValues = new int[5];
		
		for(int i = 0; i < oValues.length; ++i) {
			oValues[i] = oRandom.nextInt(0, 20) + 1;
		}
		
		System.out.println("=====> 배열 <=====");
		
		for(int i = 0; i < oValues.length; ++i) {
			System.out.printf("%d, ", oValues[i]);
		}
		
		boolean bIsResult = isContains_DuplicateVal(oValues);
		System.out.printf("\n\n중복 요소 존재 여부 : %s\n", bIsResult);
	}
	
	/** 중복 값 포함 여부를 검사한다 */
	private static boolean isContains_DuplicateVal(int[] a_oValues) {
		for(int i = 0; i < a_oValues.length - 1; ++i) {
			for(int j = i + 1; j < a_oValues.length; ++j) {
				// 값이 중복 될 경우
				if(a_oValues[i] == a_oValues[j]) {
					return true;
				}
			}
		}
		
		return false;
	}
}
