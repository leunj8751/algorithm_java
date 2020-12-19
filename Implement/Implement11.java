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

	//�ذ��� ã�� :
	// ù ������ ���������� ���Ѵٴ� ������ �ִ�.
	// �׷��Ƿ� ���� ������ ��ȯ�ؾ� �ϴ����� ã�� ���� �ش������� ������ ���������� ����
	// �̵��Ѱ��� ����� �ִ��� ã������
	// ����� ������ ���� ���� +1
	
	//-----------------���� Ǯ�� ��
	// �ʿ��� ���� : time, index(������ȯ��), direction
	// ���� �̵��� ǥ���ϱ� ���� q�� ����Ͽ�
	// �̵������� offer�ϰ� ����� ���� �ʾ����� poll�� �̿��Ͽ� ���� ���� ���� ����
	//arr[][] =0 �� �̿��Ͽ� ������ ���� ���ش�.
	// �迭�� ��� ���� position Ŭ������ node Ŭ������ ����.
	
	
	
	
	
	
	public static int n,k,l;
	public static int arr[][] = new int[101][101]; // �������
	public static ArrayList<Node> info = new ArrayList<Node>();
	
									//��,��,��,��
	 public static int dx[] = {0, 1, 0, -1};
	 public static int dy[] = {1, 0, -1, 0};
	
	
	public static int turn(int direction, char c) {
	
		if(c == 'L') {// ����
			   if(direction == 0 ) {
				   direction += 3;
			   }else {
				   direction = direction -1;
			   }
			
		}else { //������
			direction = (direction +1) %4;
			
			
		}
		
		return direction;
		
		
	}
	
	
	
	
	
	public static int simulation() {
		
		Queue<Position> q = new LinkedList<>();

		int x = 1;
		int y = 1; 
		arr[x][y] = 2; // ���� ��ġ�� 2�� ǥ��  
		q.offer(new Position(x,y)); // ������ xy �α� 
		int direction = 0; //ó������ ������ ���� ���� 
		int time = 0;
		int index = 0;
	
		while(true) {
			int nx = x + dx[direction];
			int ny = y + dy[direction];
			
			
			if(nx >= 1 && nx <=n  && ny >=1 && ny <= n && arr[nx][ny] !=2) {
				
				arr[nx][ny] = 2; // ���� ���� �ε����ų� �ڱ� ���̶� �ε����� ������ ������ �̵�
				q.offer(new Position(nx,ny));
				
				
				if (arr[nx][ny] !=1) { // ����� ���ٸ� �����ڸ���
					Position prev = q.poll();
					arr[prev.getX()][prev.getY()] = 0;
				}
				
				
			}else { // ���̳� ���̶� �ε����� ��
				time += 1;
				break;
			}
			x = nx;
			y = ny;
			time += 1;
			//ȸ���ϱ�
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
			
			arr[x][y] =1; //��� ��ġ �ֱ�
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

