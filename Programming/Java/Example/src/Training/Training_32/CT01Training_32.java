package Training.Training_32;

/*
 * Java 연습 문제 32
 * - 사칙 연산 계산하기
 * - 사용자로부터 수식을 입력 받아 해당 수식을 계산해서 결과를 출력하기
 *
 * Ex)
 * 수식 입력 : (2 + 2) * 2
 * 결과 : 8
 */

import java.util.Scanner;
import java.util.Stack;

/**
 * Training 32
 */
public class CT01Training_32 {
	/** 초기화 */
	public static void start(String[] args) {
		Scanner oScanner = new Scanner(System.in);
		
		System.out.print("수식 입력 : ");
		String oInfix = oScanner.nextLine();
		
		String oPostfix = infix_ToPostfix(oInfix);
		System.out.printf("중위 -> 후위 표기법 : %s\n", oPostfix);
		
		double dblResult = getResult_Calc(oPostfix);
		System.out.printf("\n결과 : %f\n", dblResult);
	}
	
	/**
	 * 상수
	 */
	private static String DIGITS = "0123456789.";
	private static String OPERATORS = "+-*/()";
	
	/** 우선 순위를 반환한다 */
	private static int getPriority(String a_oToken, boolean a_bIsPush) {
		return switch(a_oToken) {
			case "+", "-" -> 2;
			case "*", "/" -> 1;
			default -> (a_bIsPush && a_oToken.equals("(")) ? 0 : 3;
		};
	}
	
	/** 토큰을 반환한다 */
	private static String getToken(String a_oExpression, int a_nIdx_Start) {
		StringBuilder oStrBuilder = new StringBuilder();
		
		for(int i = a_nIdx_Start; i < a_oExpression.length(); ++i) {
			oStrBuilder.append(a_oExpression.charAt(i));
			
			boolean bIsDigit = i + 1 < a_oExpression.length();
			bIsDigit = bIsDigit && DIGITS.contains(String.format("%c", a_oExpression.charAt(i)));
			bIsDigit = bIsDigit && DIGITS.contains(String.format("%c", a_oExpression.charAt(i + 1)));
			
			// 숫자가 아닐 경우
			if(!bIsDigit) {
				break;
			}
		}
		
		return oStrBuilder.toString();
	}
	
	/** 수식 결과를 반환한다 */
	private static double getResult_Calc(String a_oPostfix) {
		Stack<Double> oStackOperands = new Stack<>();
		int nIdx = 0;
		
		while(nIdx < a_oPostfix.length()) {
			String oToken = getToken(a_oPostfix, nIdx);
			nIdx += oToken.length();
			
			// 공백 일 경우
			if(Character.isWhitespace(oToken.charAt(0))) {
				continue;
			}
			
			// 피연산자 일 경우
			if(!OPERATORS.contains(oToken)) {
				double dblOperand = Double.parseDouble(oToken);
				oStackOperands.push(dblOperand);
				
				continue;
			}
			
			double dblRhs = oStackOperands.pop();
			double dblLhs = oStackOperands.pop();
			
			double dblResult = switch(oToken) {
				case "+" -> dblLhs + dblRhs;
				case "-" -> dblLhs - dblRhs;
				case "*" -> dblLhs * dblRhs;
				case "/" -> dblLhs / dblRhs;
				default -> 0.0;
			};
			
			oStackOperands.push(dblResult);
		}
		
		return oStackOperands.pop();
	}
	
	/** 중위 -> 후위 표기법으로 변환한다 */
	private static String infix_ToPostfix(String a_oInfix) {
		StringBuilder oStrBuilder = new StringBuilder();
		Stack<String> oStackOperators = new Stack<>();
		
		int nIdx = 0;
		
		while(nIdx < a_oInfix.length()) {
			String oToken = getToken(a_oInfix, nIdx);
			nIdx += oToken.length();
			
			// 공백 일 경우
			if(Character.isWhitespace(oToken.charAt(0))) {
				continue;
			}
			
			// 피연산자 일 경우
			if(!OPERATORS.contains(oToken)) {
				oStrBuilder.append(String.format("%s ", oToken));
				continue;
			}
			
			// ) 일 경우
			if(oToken.equals(")")) {
				while(!oStackOperators.empty()) {
					String oOperator = oStackOperators.pop();
					
					// ( 일 경우
					if(oOperator.equals("(")) {
						break;
					}
					
					oStrBuilder.append(oOperator);
				}
				
				continue;
			}
			
			int nPriority_Token = getPriority(oToken, true);
			
			while(!oStackOperators.empty()) {
				String oOperator = oStackOperators.peek();
				int nPriority_Operator = getPriority(oOperator, false);
				
				// 토큰의 우선 순위가 높을 경우
				if(nPriority_Token < nPriority_Operator) {
					break;
				}
				
				oStrBuilder.append(oStackOperators.pop());
			}
			
			oStackOperators.push(oToken);
		}
		
		while(!oStackOperators.empty()) {
			oStrBuilder.append(oStackOperators.pop());
		}
		
		return oStrBuilder.toString();
	}
}
