package Training.Training_23;

/*
 * Java 연습 문제 23
 * - 행맨 게임 제작하기
 * - 정해진 단어 중 1 개를 랜덤하게 선택한다
 * - 선택한 단어를 구성하고 있는 문자의 일부만을 공개 후 사용자로부터 문자를 입력 받는다
 * - 입력 받은 문자가 단어에 존재 할 경우 해당 문자를 활성화한다 (+ 단, 대/소문자 구분 X)
 * - 모든 문자가 활성화 되면 게임을 종료한다
 *
 * Ex)
 * 정답 : Samsung
 *
 * _ _ m _ _ _ g
 * 문자 입력 : s
 *
 * S _ m s _ _ g
 * 문자 입력 : a
 *
 * S a m s _ _ g
 * 문자 입력 : n
 *
 * S a m s _ n g
 * 문자 입력 : u
 *
 * S a m s u n g
 * 프로그램을 종료합니다.
 */

import java.util.Random;
import java.util.Scanner;

/**
 * Training 23
 */
public class CT01Training_23 {
	/** 초기화 */
	public static void start(String[] args) {
		Scanner oScanner = new Scanner(System.in);
		String oAnswer = getAnswer();
		
		System.out.printf("정답 : %s\n\n", oAnswer);
		
		char[] oWord = new char[oAnswer.length()];
		setupWord(oWord, oAnswer);
		
		do {
			printWord(oWord);
			
			System.out.print("문자 입력 : ");
			char chLetter = oScanner.nextLine().charAt(0);
			
			for(int i = 0; i < oAnswer.length(); ++i) {
				char chLetter_Upper = Character.toUpperCase(chLetter);
				char chAnswer_Upper = Character.toUpperCase(oAnswer.charAt(i));
				
				// 문자가 동일 할 경우
				if(chLetter_Upper == chAnswer_Upper) {
					oWord[i] = oAnswer.charAt(i);
				}
			}
			
			System.out.println();
			
			// 문자를 모두 활성화 시켰을 경우
			if(isAnswer(oWord)) {
				break;
			}
		} while(true);
		
		printWord(oWord);
		System.out.println("프로그램을 종료합니다.");
	}
	
	/** 정답 여부를 검사한다 */
	private static boolean isAnswer(char[] a_oWord) {
		for(int i = 0; i < a_oWord.length; ++i) {
			// 비활성화 된 문자가 존재 할 경우
			if(a_oWord[i] == '_') {
				return false;
			}
		}
		
		return true;
	}
	
	/** 단어를 설정한다 */
	private static void setupWord(char[] a_oWord, String a_oAnswer) {
		Random oRandom = new Random();
		
		for(int i = 0; i < a_oWord.length; ++i) {
			a_oWord[i] = '_';
		}
		
		for(int i = 0; i < (int)(a_oAnswer.length() * 0.3f); ++i) {
			int nIdx = oRandom.nextInt(0, a_oAnswer.length());
			a_oWord[nIdx] = a_oAnswer.charAt(nIdx);
		}
	}
	
	/** 단어를 출력한다 */
	private static void printWord(char[] a_oWord) {
		for(int i = 0; i < a_oWord.length; ++i) {
			System.out.printf("%c ", a_oWord[i]);
		}
		
		System.out.println();
	}
	
	/** 정답을 반환한다 */
	private static String getAnswer() {
		Random oRandom = new Random();
		
		String[] oStrings = {
				"Apple",
				"Google",
				"Samsung",
				"Microsoft"
		};
		
		int nIdx = oRandom.nextInt(0, oStrings.length);
		return oStrings[nIdx];
	}
}
