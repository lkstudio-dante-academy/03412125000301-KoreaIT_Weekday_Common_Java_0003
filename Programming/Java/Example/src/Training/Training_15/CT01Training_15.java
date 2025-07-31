package Training.Training_15;

/*
 * Java 연습 문제 15
 * - 배열 반전 시키기
 * - 길이 10 배열을 생성 후 1 부터 차례대로 초기화한다
 * - 배열을 반전 시킨 후 반전 결과를 출력한다 (+ 단, 추가 배열 사용 X)
 *
 * Ex)
 * =====> 배열 <=====
 * 1, 2, 3, 4, 5, 6, 7, 8, 9, 10
 *
 * =====> 배열 - 반전 후 <=====
 * 10, 9, 8, 7, 6, 5, 4, 3, 2, 1
 */

/**
 * Training 15
 */
public class CT01Training_15 {
	/** 초기화 */
	public static void start(String[] args) {
		int[] oValues = {
				1, 2, 3, 4, 5, 6, 7, 8, 9, 10
		};
		
		System.out.println("=====> 배열 <=====");
		
		for(int nVal : oValues) {
			System.out.printf("%d, ", nVal);
		}
		
		int nLeft = 0;
		int nRight = oValues.length - 1;
		
		while(nLeft < nRight) {
			int nTemp = oValues[nLeft];
			oValues[nLeft] = oValues[nRight];
			oValues[nRight] = nTemp;
			
			nLeft += 1;
			nRight -= 1;
		}
		
		System.out.println("\n\n=====> 배열 - 반전 후 <=====");
		
		for(int nVal : oValues) {
			System.out.printf("%d, ", nVal);
		}
		
		System.out.println();
	}
}
