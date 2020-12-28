package DfsBfs;

import java.util.ArrayList;
import java.util.Scanner;

public class DfsBfsQ16 {

	// p.341 ������ 20201220 ��ǯ
	
	//���� 3���� ����µ� ���������� �ִ��� �ǵ��� ������.
	//dfs �̿��ϸ� �ɰ� ����.
	//0 -  ��ĭ, 1 - ��, 2 - ���̷���
	// �� ������ ���Ƿ� ��������....?
	//-------------------------------
	
	// Ǯ�̹��: ����Ž�� + (dfs or bfs)
	// ���� ���� ������ ���� �� �ִ� ��� ����� ���� ã�´�.
	// ���� ���������� ���������� dfs�� bfs�� �̿��Ͽ� ã�´�.
	// ���������� �ִ밪�� ã�´�.
	//----------------------
	
	// ���� �� �� �ٽ� Ǯ��� 
	// 1. ���� ���� ���� ����� ���� count ������ ��͸� �̿��Ͽ� ���Ѵ�.
	// 2. count �� 3�� �Ǿ����� ��, ���� 3���� ���������� 
	// 3. ���̷����� ��Ʈ����(�ӽ÷� �迭�ϳ� �����) - dfs �̿�
	// 4. ���̷����� ��Ʈ�������� ���������� ����ϰ� �������� �ִ밪�� ���Ѵ�.
	
	//���� �˰Ե� return�� ���� : �ش� �޼ҵ� ���࿡ ���� ���� ���� ȣ���� ������ �����ް��� �Ҷ�
	// �� ���⼭�� �������� �ִ밪�� ���ϱ� ���� ������ �ִ밪�� return ���ش�.
	
	
	
	public static int n,m,result = 0;
	public static int array[][] = new int[8][8]; 
	public static int temp[][] = new int[8][8];
	
	public static int dx[] = {0,0,1,-1}; 
	public static int dy[] = {1,-1,0,0}; 
	
	//���̷��� ��Ʈ���� // �ǹ� : �Լ�ȣ���Ҷ� �̹� �������� ���ȴµ� ���⼭ �ǵ���??
	public static void virus(int x,int y) {
		
		for(int i = 0; i <4; i++) {
			int nx = x + dx[i];
			int ny = y + dy[i];
		
			if(nx >=0 && ny >=0 && nx <n && ny <m) {
				if(temp[nx][ny] == 0) {
					temp[nx][ny] =2;
					virus(nx,ny);
				}
			}
		}
	}
	
	//�������� ���ϱ�
	public static int getScore() {
		
		int count = 0;
		for(int i=0; i < n; i++) {
			for(int j = 0; j < m; j++) {
				if(temp[i][j] ==0) {
					count += 1;
				}
			}
		}
		
		return count;
	}
	
	public static void dfs(int count) {
		
		//��Ÿ�� �� ��������
		if(count == 3) {
			
			//���̷��� ��Ʈ���� ���� �ӽù迭 �����
			for(int i=0; i < n; i++) {
				for(int j = 0; j < m; j++) {
					temp[i][j] = array[i][j];
				}
			}
			
			// ���̷���  ��Ʈ����
			for(int i=0; i < n; i++) {
				for(int j = 0; j < m; j++) {
					if(temp[i][j] == 2) {
						virus(i,j);
					}
				}
			}
			
			//�������� �ִ밪 ���ϱ�
			result = Math.max(result,getScore());
			return;
		}//if
		
		
		
		// ���Ƿ� ��Ÿ�� �ֱ�
		for(int i = 0; i <n; i++) {
			for(int j = 0; j <m; j++) {
				if(array[i][j] == 0) {
					array[i][j]= 1;
					count += 1;
					dfs(count);
					array[i][j] = 0;
					count -= 1;
				} 
			}
		}
	}
	
	public static void main(String[] args) {
			
		Scanner sc = new Scanner(System.in);
		n = sc.nextInt();
		m = sc.nextInt();
		
		for(int i = 0; i <n; i++) {
			for(int j = 0; j <m; j++) {
				array[i][j] = sc.nextInt();	
			}
		}
		
		dfs(0);
		System.out.println(result);
	}
	
}
