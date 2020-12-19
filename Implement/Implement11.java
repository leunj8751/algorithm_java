package Implement;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

class Position{
	
	 private int x;
	 private int y;

	    public Position(int x, int y) {
	        this.x = x;
	        this.y = y;
	    }

	    public int getX() {
	        return this.x;
	    }

	    public int getY() {
	        return this.y;
	    }
	
	
	
}


class Node{
	
	private int time;
	private char direction;
	
	public Node(int time,char direction) {
		this.time = time;
		this.direction = direction;
		
	}
	
	public int getTime() {
		
		return this.time;
	}
	
	public char getDirection() {
		
		return this.direction;
	}
	
	
	
	
}



public class Implement11 {

	//해결방법 찾기 :
	// 첫 시작은 오른쪽으로 향한다는 조건이 있다.
	// 그러므로 먼저 방향을 전환해야 하는지를 찾은 다음 해당정보가 없으면 오른쪽으로 직진
	// 이동한곳에 사과가 있는지 찾은다음
	// 사과가 있으면 뱀의 길이 +1
	
	//-----------------문제 풀이 후
	// 필요한 변수 : time, index(방향전환할), direction
	// 뱀의 이동을 표현하기 위해 q를 사용하여
	// 이동했을때 offer하고 사과를 먹지 않았을때 poll을 이용하여 제일 끝의 값을 뺀후
	//arr[][] =0 을 이용하여 꼬리를 삭제 해준다.
	// 배열에 담기 위해 position 클래스와 node 클래스를 만듬.
	
	
	
	
	
	
	public static int n,k,l;
	public static int arr[][] = new int[101][101]; // 사과정보
	public static ArrayList<Node> info = new ArrayList<Node>();
	
									//동,남,서,북
	 public static int dx[] = {0, 1, 0, -1};
	 public static int dy[] = {1, 0, -1, 0};
	
	
	public static int turn(int direction, char c) {
	
		if(c == 'L') {// 왼쪽
			   if(direction == 0 ) {
				   direction += 3;
			   }else {
				   direction = direction -1;
			   }
			
		}else { //오른쪽
			direction = (direction +1) %4;
			
			
		}
		
		return direction;
		
		
	}
	
	
	
	
	
	public static int simulation() {
		
		Queue<Position> q = new LinkedList<>();

		int x = 1;
		int y = 1; 
		arr[x][y] = 2; // 뱀의 위치는 2로 표시  
		q.offer(new Position(x,y)); // 꼬리에 xy 두기 
		int direction = 0; //처음에는 동쪽을 보고 있음 
		int time = 0;
		int index = 0;
	
		while(true) {
			int nx = x + dx[direction];
			int ny = y + dy[direction];
			
			
			if(nx >= 1 && nx <=n  && ny >=1 && ny <= n && arr[nx][ny] !=2) {
				
				arr[nx][ny] = 2; // 뱀이 벽에 부딪히거나 자기 몸이랑 부딪히지 않으면 앞으로 이동
				q.offer(new Position(nx,ny));
				
				
				if (arr[nx][ny] !=1) { // 사과가 없다면 꼬리자르기
					Position prev = q.poll();
					arr[prev.getX()][prev.getY()] = 0;
				}
				
				
			}else { // 벽이나 몸이랑 부딪혔을 때
				time += 1;
				break;
			}
			x = nx;
			y = ny;
			time += 1;
			//회전하기
			if(index < l && time == info.get(index).getTime()) {
				direction = turn(direction,info.get(index).getDirection());
				index += 1;
				
			}
			
			
		}
		
		return time;
	}
	
	
	
	
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		n = sc.nextInt();
		k = sc.nextInt();
		
		for(int i = 0; i < k; i++) {
			
			int x = sc.nextInt();
			int y = sc.nextInt();
			
			arr[x][y] =1; //사과 위치 넣기
		}
	
		l = sc.nextInt();
		
		for(int i = 0; i < l; i++) {
			int x = sc.nextInt();
			char c = sc.nextLine().charAt(0);
			System.out.println("c:"+c);
			info.add((new Node(x,c)));
			
		}
		
	
		
		System.out.println(simulation());
		
		
		
		
	}


}

