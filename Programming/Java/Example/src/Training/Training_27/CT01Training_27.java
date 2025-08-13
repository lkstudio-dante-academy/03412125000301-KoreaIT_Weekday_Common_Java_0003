package Training.Training_27;

/*
 * Java 연습 문제 27
 * - 회원 관리 프로그램 제작하기
 * - 회원 정보는 이름, 전화 번호가 존재한다
 * - 사용자로부터 메뉴를 입력 받아 회원 추가, 제거 등을 처리한다
 * - 단, 회원 이름은 중복 X
 *
 * Ex)
 * =====> 메뉴 <=====
 * 1. 회원 추가
 * 2. 회원 제거
 * 3. 회원 검색
 * 4. 모든 회원 출력
 * 5. 종료
 *
 * 선택 : 1
 * 이름 입력 : 회원 A
 * 전화 번호 입력 : 1234
 *
 * Case 1. 신규 회원 일 경우
 * 회원 A 을(를) 추가했습니다.
 *
 * Case 2. 동일한 이름의 회원이 존재 할 경우
 * 회원 A 은(는) 이미 존재하는 회원입니다.
 *
 * 선택 : 2
 * 이름 입력 : 회원 A
 *
 * Case 1. 회원이 존재 할 경우
 * 회원 A 을(를) 제거했습니다.
 *
 * Case 2. 회원이 없을 경우
 * 회원 A 은(는) 존재하지 않습니다.
 *
 * 선택 : 5
 * 프로그램을 종료합니다.
 */

import java.util.Scanner;

/**
 * Training 27
 */
public class CT01Training_27 {
	/** 초기화 */
	public static void start(String[] args) {
		final int MENU_ADD_MEMBER = 1;
		final int MENU_REMOVE_MEMBER = 2;
		final int MENU_SEARCH_MEMBER = 3;
		final int MENU_PRINT_MEMBERS_ALL = 4;
		final int MENU_EXIT = 5;
		
		Scanner oScanner = new Scanner(System.in);
		CManager_Member oManager = new CManager_Member();
		
		do {
			printMenu();
			int nMenu = oScanner.nextInt();
			
			// 종료 일 경우
			if(nMenu == MENU_EXIT) {
				break;
			}
			
			switch(nMenu) {
				case MENU_ADD_MEMBER:
					addMember(oManager);
					break;
					
				case MENU_REMOVE_MEMBER:
					removeMember(oManager);
					break;
					
				case MENU_SEARCH_MEMBER:
					searchMember(oManager);
					break;
					
				case MENU_PRINT_MEMBERS_ALL:
					printMembers_All(oManager);
					break;
			}
			
			System.out.println();
		} while(true);
		
		System.out.println("프로그램을 종료합니다.");
	}
	
	/** 메뉴를 출력한다 */
	private static void printMenu() {
		System.out.println("=====> 메뉴 <=====");
		System.out.println("1. 회원 추가");
		System.out.println("2. 회원 제거");
		System.out.println("3. 회원 검색");
		System.out.println("4. 모든 회원 출력");
		System.out.println("5. 종료");
		
		System.out.print("\n선택 : ");
	}
	
	/** 회원을 추가한다 */
	private static void addMember(CManager_Member a_oManager) {
		Scanner oScanner = new Scanner(System.in);
		
		System.out.print("이름 입력 : ");
		String oName = oScanner.nextLine();
		
		System.out.print("전화 번호 입력 : ");
		String oPNumber = oScanner.nextLine();
		
		int nResult = a_oManager.findMember(oName);
		
		// 회원이 존재 할 경우
		if(nResult >= 0) {
			System.out.printf("%s 은(는) 이미 존재하는 회원입니다.\n", oName);
			return;
		}
		
		a_oManager.addMember(oName, oPNumber);
		System.out.printf("%s 을(를) 추가했습니다.\n", oName);
	}
	
	/** 회원을 제거한다 */
	private static void removeMember(CManager_Member a_oManager) {
		Scanner oScanner = new Scanner(System.in);
		
		System.out.print("이름 입력 : ");
		String oName = oScanner.nextLine();
		
		int nResult = a_oManager.findMember(oName);
		
		// 회원이 없을 경우
		if(nResult < 0) {
			System.out.printf("%s 은(는) 존재하지 않습니다.\n", oName);
			return;
		}
		
		a_oManager.removeMember(oName);
		System.out.printf("%s 을(를) 제거했습니다.\n", oName);
	}
	
	/** 회원을 검색한다 */
	private static void searchMember(CManager_Member a_oManager) {
		Scanner oScanner = new Scanner(System.in);
		
		System.out.print("이름 입력 : ");
		String oName = oScanner.nextLine();
		
		int nResult = a_oManager.findMember(oName);
		
		// 회원이 없을 경우
		if(nResult < 0) {
			System.out.printf("%s 은(는) 존재하지 않습니다.\n", oName);
			return;
		}
		
		System.out.println("=====> 회원 정보 <=====");
		a_oManager.searchMember(oName);
	}
	
	/** 모든 회원을 출력한다 */
	private static void printMembers_All(CManager_Member a_oManager) {
		System.out.println("=====> 모든 회원 정보 <=====");
		a_oManager.showMembers_All();
	}
}
