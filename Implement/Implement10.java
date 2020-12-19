package Implement;

import java.util.Scanner;

public class Implement10 {
		
		//p.325
		// �̵�, ȸ���� ��� �����ؾ� ���� ���� �𸣰ڴ�..
		//------------------
		//�ذ� ���̵��� ���� Ž��
		//���� �ڹ��� ����Ʈ�� ũ�⸦ 3�� �����ϱ�
		// ���� ����Ʈ�� ���� ������ Ž���ؼ� ��簪�� 1�̶�� �ڹ��谡 �´°�.
	
		
		public static int m;
		public static int n;
	
		
		
		
	 // 2���� ����Ʈ 90�� ȸ���ϱ�
    public static int[][] rotateMatrixBy90Degree(int[][] a) {
        int n = a.length;
        int m = a[0].length;
        int[][] result = new int[n][m]; // ��� ����Ʈ
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                result[j][n - i - 1] = a[i][j];
            }
        }
        return result;
    }

    // �ڹ����� �߰� �κ��� ��� 1���� Ȯ��
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
        // �ڹ����� ũ�⸦ ������ 3��� ��ȯ
        int[][] newLock = new int[n * 3][n * 3];
        // ���ο� �ڹ����� �߾� �κп� ������ �ڹ��� �ֱ�
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                newLock[i + n][j + n] = lock[i][j];
            }
        }

        // 4���� ���⿡ ���ؼ� Ȯ��
        for (int rotation = 0; rotation < 4; rotation++) {
            key = rotateMatrixBy90Degree(key); // ���� ȸ��
            for (int x = 0; x < n * 2; x++) {
                for (int y = 0; y < n * 2; y++) {
                    // �ڹ��迡 ���踦 ���� �ֱ�
                    for (int i = 0; i < m; i++) {
                        for (int j = 0; j < m; j++) {
                            newLock[x + i][y + j] += key[i][j];
                            System.out.println("x : " +x+" y :"+y+" i :"+i+" j :"+j);
                        }
                    }
                    // ���ο� �ڹ��迡 ���谡 ��Ȯ�� ��� �´��� �˻�
                    if (check(newLock)) return true;
                    // �ڹ��迡�� ���踦 �ٽ� ����
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
