package Implement;

import java.util.Scanner;

public class Implement10 {
		
		//p.325
		// 이동, 회전을 어떻게 구현해야 할지 전혀 모르겠다..
		//------------------
		//해결 아이디어는 완전 탐색
		//먼저 자물쇠 리스트의 크기를 3배 변경하기
		// 열쇠 리스트를 왼쪽 위부터 탐색해서 모든값이 1이라면 자물쇠가 맞는것.
	
		
		public static int m;
		public static int n;
	
		
		
		
	 // 2차원 리스트 90도 회전하기
    public static int[][] rotateMatrixBy90Degree(int[][] a) {
        int n = a.length;
        int m = a[0].length;
        int[][] result = new int[n][m]; // 결과 리스트
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                result[j][n - i - 1] = a[i][j];
            }
        }
        return result;
    }

    // 자물쇠의 중간 부분이 모두 1인지 확인
    public static boolean check(int[][] newLock) {
        int lockLength = newLock.length / 3;
        for (int i = lockLength; i < lockLength * 2; i++) {
            for (int j = lockLength; j < lockLength * 2; j++) {
                if (newLock[i][j] != 1) {
                    return false;
                }
            }
        }
        return true;
    }

    public static boolean  solution(int[][] key, int[][] lock) {
        int n = lock.length;
        int m = key.length;
        System.out.println("n :"+n);
        System.out.println("m :"+m);
        // 자물쇠의 크기를 기존의 3배로 변환
        int[][] newLock = new int[n * 3][n * 3];
        // 새로운 자물쇠의 중앙 부분에 기존의 자물쇠 넣기
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                newLock[i + n][j + n] = lock[i][j];
            }
        }

        // 4가지 방향에 대해서 확인
        for (int rotation = 0; rotation < 4; rotation++) {
            key = rotateMatrixBy90Degree(key); // 열쇠 회전
            for (int x = 0; x < n * 2; x++) {
                for (int y = 0; y < n * 2; y++) {
                    // 자물쇠에 열쇠를 끼워 넣기
                    for (int i = 0; i < m; i++) {
                        for (int j = 0; j < m; j++) {
                            newLock[x + i][y + j] += key[i][j];
                            System.out.println("x : " +x+" y :"+y+" i :"+i+" j :"+j);
                        }
                    }
                    // 새로운 자물쇠에 열쇠가 정확히 들어 맞는지 검사
                    if (check(newLock)) return true;
                    // 자물쇠에서 열쇠를 다시 빼기
                    for (int i = 0; i < m; i++) {
                        for (int j = 0; j < m; j++) {
                            newLock[x + i][y + j] -= key[i][j];
                        }
                    }
                }
            }
        }
        return false;
    }
public static void main(String[] args) {
	    	
	   Scanner sc = new Scanner(System.in);
	   m = sc.nextInt(); // key
	   int key[][] = new int[m][m];
	
	   
	   for(int i = 0; i < m; i++) {
		   for(int j =0; j <m; j++) {
			    key[i][j] = sc.nextInt();
		   }
	   }
	   for(int i = 0; i < m; i++) {
		   for(int j =0; j <m; j++) {
			   System.out.print(key[i][j]);
		   }
	   }
	   
	   n = sc.nextInt(); // lock
	   int lock[][] = new int[n][n];
	   for(int i = 0; i < n; i++) {
		   for(int j =0; j <n; j++) {
			    lock[i][j] = sc.nextInt();
		   }
	   }
	   for(int i = 0; i < n; i++) {
		   for(int j =0; j <n; j++) {
			   System.out.print(lock[i][j]);
		   }
	   }
	   
	System.out.println(solution(key, lock));
}
	    
}
