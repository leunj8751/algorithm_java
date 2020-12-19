package Implement;

import java.util.Scanner;


public class Implement09 {
	// 문자열 압축 p.323
	
	
	
	
	//내가 생각한 해결 방법 : 2020.12.15 못풀었음
	//1. 다이나믹 프로그램 처럼 정수 n 을 반으로 나눈 뒤 앞뒤의 값이 같은지 찾는다.
	//2. 나눈것을 또 반으로 나눠서 앞뒤 같은지 확인
	//3. 같으면 묶고 다르면 넘기고
	
	//답안예시 알고리즘 :
	//1. 1부터 n/2까지 반복문을 돌리면서 그 숫자 단위에 해당하는 글자가 반복되는지 확인한다.
	//2. 가장 짧게 압축되는 길이를 출력하면 됨.

    public static int solution(String s) {
        int answer = s.length();
        // 1개 단위(step)부터 압축 단위를 늘려가며 확인
        for (int step = 1; step < s.length() / 2 + 1; step++) {
            String compressed = "";
            String prev = s.substring(0, step); // 앞에서부터 step만큼의 문자열 추출
            int cnt = 1;
            // 단위(step) 크기만큼 증가시키며 이전 문자열과 비교
            for (int j = step; j < s.length(); j += step) {
                // 이전 상태와 동일하다면 압축 횟수(count) 증가
                String sub = "";
                for (int k = j; k < j + step; k++) {
                    if (k < s.length()) sub += s.charAt(k);
                }
                if (prev.equals(sub)) cnt += 1;
                // 다른 문자열이 나왔다면(더 이상 압축하지 못하는 경우라면)
                else {
                    compressed += (cnt >= 2)? cnt + prev : prev;
                    sub = "";
                    for (int k = j; k < j + step; k++) {
                        if (k < s.length()) sub += s.charAt(k);
                    }
                    prev = sub; // 다시 상태 초기화
                    cnt = 1;
                }
            }
            // 남아있는 문자열에 대해서 처리
            compressed += (cnt >= 2)? cnt + prev : prev;
            // 만들어지는 압축 문자열이 가장 짧은 것이 정답
            answer = Math.min(answer, compressed.length());
        }
        return answer;
    } 
        
        
        
 public static void main(String[] args) {
		
		 
		Scanner sc = new Scanner(System.in);
		String str = sc.nextLine();
		int answer= solution(str);
		System.out.println("result :"+answer);
	
	 
	 
}


}



