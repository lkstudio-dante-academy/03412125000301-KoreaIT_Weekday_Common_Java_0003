package Training.Training_29;

/*
 * Java 연습 문제 29
 * - 계좌 관리 프로그램 제작하기
 * - 계좌 정보는 계좌 번호, 잔액 이 존재한다
 * - 사용자로부터 메뉴를 입력 받아 계좌 개설, 입/출금 등을 처리한다
 * - 단, 계좌 번호는 1 ~ 9 사이의 수로 지정
 * - 계좌 번호는 중복 X
 * 
 * Ex)
 * =====> 메뉴 <======
 * 1. 계좌 개설
 * 2. 계좌 입금
 * 3. 계좌 출금
 * 4. 모든 계좌 출력
 * 5. 종료
 *
 * 선택 : 1
 * 계좌 번호 (1 ~ 9) 입력 : 2
 *
 * Case 1. 신규 계좌 일 경우
 * 초기 금액 입력 : 1000
 * 계좌 2 번이 개설 되었습니다.
 *
 * Case 2. 동일한 계좌 번호가 존재 할 경우
 * 계좌 2 번은 이미 존재하는 계좌 번호입니다.
 *
 * 선택 : 2
 * 계좌 번호 입력 : 2
 *
 * Case 1. 계좌 번호가 없을 경우
 * 계좌 2 번은 존재하지 않습니다.
 *
 * Case 2. 계좌가 존재 할 경우
 * 입금 금액 입력 : 500
 * 계좌 2 번에 500 을 입금했습니다.
 *
 * 선택 : 3
 * 계좌 번호 입력 : 2
 *
 * Case 1. 계좌 번호가 없을 경우
 * 계좌 2 번은 존재하지 않습니다.
 *
 * Case 2. 계좌가 존재 할 경우
 * 출금 금액 입력 (잔액 : 1500) : 1000
 *
 * Case 1. 출금이 가능 할 경우
 * 계좌 2 번에서 1000 을 출금했습니다.
 *
 * Case 2. 잔액이 부족 할 경우
 * 잔액이 부족합니다.
 */

import java.util.Scanner;

/**
 * Training 29
 */
public class CT01Training_29 {
	/** 초기화 */
	public static void start(String[] args) {
		Scanner oScanner = new Scanner(System.in);
		
		do {
			printMenu();
			int nMenu = oScanner.nextInt();
			
			// 종료 일 경우
			if(nMenu == MENU_EXIT) {
				break;
			}
			
			try {
			
			} catch(Exception oException) {
				System.out.println(oException.getMessage());
			}
		} while(true);
		
		System.out.println("프로그램을 종료합니다.");
	}
	
	/**
	 * 메뉴
	 */
	private static final int MENU_OPEN_ACCOUNT = 1;
	private static final int MENU_DEPOSIT = 2;
	private static final int MENU_WITHDRAW = 3;
	private static final int MENU_PRINT_ACCOUNTS_ALL = 4;
	private static final int MENU_EXIT = 5;
	
	/** 메뉴를 출력한다 */
	private static void printMenu() {
		System.out.println("=====> 메뉴 <=====");
		System.out.println("1. 계좌 개설");
		System.out.println("2. 입금");
		System.out.println("3. 출금");
		System.out.println("4. 모든 계좌 출력");
		System.out.println("5. 종료");
		
		System.out.print("\n선택 : ");
	}
	
	/** 계좌를 개설한다 */
	private static void openAccount() {
	
	}
	
	/** 입금한다 */
	private static void deposit() {
	
	}
	
	/** 출금한다 */
	private static void withdraw() {
	
	}
	
	/** 모든 계좌를 출력한다 */
	private static void printAccounts_All() {
		System.out.println("=====> 모든 계좌 정보 <=====");
		CManager_Account.getInst().showAccounts_All();
	}
}
