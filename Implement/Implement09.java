package Implement;

import java.util.Scanner;


public class Implement09 {
	// ���ڿ� ���� p.323
	
	
	
	
	//���� ������ �ذ� ��� : 2020.12.15 ��Ǯ����
	//1. ���̳��� ���α׷� ó�� ���� n �� ������ ���� �� �յ��� ���� ������ ã�´�.
	//2. �������� �� ������ ������ �յ� ������ Ȯ��
	//3. ������ ���� �ٸ��� �ѱ��
	
	//��ȿ��� �˰��� :
	//1. 1���� n/2���� �ݺ����� �����鼭 �� ���� ������ �ش��ϴ� ���ڰ� �ݺ��Ǵ��� Ȯ���Ѵ�.
	//2. ���� ª�� ����Ǵ� ���̸� ����ϸ� ��.

    public static int solution(String s) {
        int answer = s.length();
        // 1�� ����(step)���� ���� ������ �÷����� Ȯ��
        for (int step = 1; step < s.length() / 2 + 1; step++) {
            String compressed = "";
            String prev = s.substring(0, step); // �տ������� step��ŭ�� ���ڿ� ����
            int cnt = 1;
            // ����(step) ũ�⸸ŭ ������Ű�� ���� ���ڿ��� ��
            for (int j = step; j < s.length(); j += step) {
                // ���� ���¿� �����ϴٸ� ���� Ƚ��(count) ����
                String sub = "";
                for (int k = j; k < j + step; k++) {
                    if (k < s.length()) sub += s.charAt(k);
                }
                if (prev.equals(sub)) cnt += 1;
                // �ٸ� ���ڿ��� ���Դٸ�(�� �̻� �������� ���ϴ� �����)
                else {
                    compressed += (cnt >= 2)? cnt + prev : prev;
                    sub = "";
                    for (int k = j; k < j + step; k++) {
                        if (k < s.length()) sub += s.charAt(k);
                    }
                    prev = sub; // �ٽ� ���� �ʱ�ȭ
                    cnt = 1;
                }
            }
            // �����ִ� ���ڿ��� ���ؼ� ó��
            compressed += (cnt >= 2)? cnt + prev : prev;
            // ��������� ���� ���ڿ��� ���� ª�� ���� ����
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



