package DfsBfs;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;



public class DfsBfsQ15 {

	//p.339 특정 거리의 도시 찾기 20201220 못풂
	
	// 시작노드 부터 어떤특정 노드까지의 거리가 k인 도로개수 찾기
	// bfs를 사용하면 좋을것 같다.
	// bfs 는 q를 이용
	//------------------
	
	// 최단거리의 값을 넣기 위해 d라는 배열이 필요하다.
	
	
	
    public static ArrayList<ArrayList<Integer>> graph = new ArrayList<ArrayList<Integer>>();
    public static int[] d = new int[300001];
    
    public static void bfs(int start,int ds,int n) {
    	d[start] = 0; // 출발도시까지의 거리는 0
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
	
	int n = sc.nextInt(); //도시 개수
	int m = sc.nextInt(); //도로 개수
	int k = sc.nextInt(); // 거리정보
	int x = sc.nextInt(); // 출발 도시의 번호
	
	
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
