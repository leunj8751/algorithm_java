package DfsBfs;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;



public class DfsBfsQ15 {

	//p.339 Ư�� �Ÿ��� ���� ã�� 20201220 ��ǯ
	
	// ���۳�� ���� �Ư�� �������� �Ÿ��� k�� ���ΰ��� ã��
	// bfs�� ����ϸ� ������ ����.
	// bfs �� q�� �̿�
	//------------------
	
	// �ִܰŸ��� ���� �ֱ� ���� d��� �迭�� �ʿ��ϴ�.
	
	
	
    public static ArrayList<ArrayList<Integer>> graph = new ArrayList<ArrayList<Integer>>();
    public static int[] d = new int[300001];
    
    public static void bfs(int start,int ds,int n) {
    	d[start] = 0; // ��ߵ��ñ����� �Ÿ��� 0
    	Queue<Integer> q = new LinkedList<Integer>();
    	q.offer(start);
    
    	
    	while(!q.isEmpty()) {
    		
    		int now = q.poll();
    		System.out.println("now :"+now);
    		for(int i = 0; i <graph.get(now).size(); i++) {
    			int y = graph.get(now).get(i);
    			if(d[y] == -1) {
    				d[y] = d[now] +1;
    				q.offer(y);
    			}
    			
    		}
    		
    	}
    	
    	boolean check = false;
    	for(int i = 1; i <= n; i++) {
    	
    		if(d[i]==ds) {
    			System.out.println(i);
    			check = true;
    		}
    	}
    	
    	if(check==false) {
    		System.out.println(-1);
    	}
    	
    }
	
	
	
	
public static void main(String[] args) {
	
	Scanner sc = new Scanner(System.in);
	
	int n = sc.nextInt(); //���� ����
	int m = sc.nextInt(); //���� ����
	int k = sc.nextInt(); // �Ÿ�����
	int x = sc.nextInt(); // ��� ������ ��ȣ
	
	
	for(int i = 0; i <= n; i++) {
		graph.add(new ArrayList<Integer>());
		d[i] = -1;
		
	}
	
	for(int i = 0; i < m; i++) {
		int a = sc.nextInt();
		int b = sc.nextInt();
		graph.get(a).add(b);
	}
	
	bfs(x,k,n);
	
	
	
	
}	
	
	
	
}
