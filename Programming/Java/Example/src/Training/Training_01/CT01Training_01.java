package Training.Training_01;

/*
 * Java 연습 문제 1
 * - ABC 출력하기
 * - 다양한 방법으로 ABC 출력하기 (+ 최소 4 가지 이상)
 */

/**
 * Training 1
 */
public class CT01Training_01 {
	/** 초기화 */
	public static void start(String[] args) {
		char chLetterA = 'A';
		char chLetterB = 'B';
		char chLetterC = 'C';
		
		String oStr = "ABC";
		
		System.out.print("ABC\n");
		System.out.printf("%s\n", oStr);
		System.out.printf("%c%c%c\n", 'A', 'B', 'C');
		System.out.printf("%c%c%c\n", chLetterA, chLetterB, chLetterC);
	}
}
