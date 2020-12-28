package DfsBfs;

import java.util.ArrayList;
import java.util.Scanner;

public class DfsBfsQ16 {

	// p.341 연구소 20201220 못풂
	
	//벽을 3개만 세우는데 안정영역이 최댓값이 되도록 세워라.
	//dfs 이용하면 될것 같다.
	//0 -  빈칸, 1 - 벽, 2 - 바이러스
	// 벽 세개를 임의로 세워본다....?
	//-------------------------------
	
	// 풀이방법: 완전탐색 + (dfs or bfs)
	// 먼저 벽을 세개를 놓을 수 있는 모든 경우의 수를 찾는다.
	// 벽을 놓았을때의 안전영역을 dfs나 bfs를 이용하여 찾는다.
	// 안전영역의 최대값을 찾는다.
	//----------------------
	
	// 답지 본 후 다시 풀어보기 
	// 1. 벽을 세개 놓는 경우의 수를 count 변수와 재귀를 이용하여 구한다.
	// 2. count 가 3이 되었을때 즉, 벽이 3개가 세워졌을때 
	// 3. 바이러스를 퍼트린다(임시로 배열하나 만들기) - dfs 이용
	// 4. 바이러스를 퍼트렸을때의 안전영역을 계산하고 안전영역 최대값을 구한다.
	
	//새로 알게된 return의 쓰임 : 해당 메소드 실행에 따라 나온 값을 호출한 곳에서 돌려받고자 할때
	// ㄴ 여기서는 안전영역 최대값을 구하기 위해 현재의 최대값을 return 해준다.
	
	
	
	public static int n,m,result = 0;
	public static int array[][] = new int[8][8]; 
	public static int temp[][] = new int[8][8];
	
	public static int dx[] = {0,0,1,-1}; 
	public static int dy[] = {1,-1,0,0}; 
	
	//바이러스 퍼트리기 // 의문 : 함수호출할때 이미 이중포문 돌렸는데 여기서 또돌려??
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
	
	//안전영역 구하기
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
		
		//울타리 다 세웠으면
		if(count == 3) {
			
			//바이러스 퍼트리기 위해 임시배열 만들기
			for(int i=0; i < n; i++) {
				for(int j = 0; j < m; j++) {
					temp[i][j] = array[i][j];
				}
			}
			
			// 바이러스  퍼트리기
			for(int i=0; i < n; i++) {
				for(int j = 0; j < m; j++) {
					if(temp[i][j] == 2) {
						virus(i,j);
					}
				}
			}
			
			//안전영역 최대값 구하기
			result = Math.max(result,getScore());
			return;
		}//if
		
		
		
		// 임의로 울타리 넣기
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
