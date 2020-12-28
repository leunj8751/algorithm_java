package Sort;

public class Test02 {

	// 삽입정렬
	// 삽입정렬이란, 데이터를 앞에서부터 하나씩 확인해서
	// 데이터를 적절한 위치에 삽입하는 것
	public static void main(String[] args) {
		
		
		
		int[] arr = {7, 5, 9, 0, 3, 1, 6, 2, 4, 8};
		
		for(int i = 1; i < arr.length; i++) {
			for(int j =0; j<i; j++) {
				if(arr[i] < arr[j]) {
				
					int temp = arr[i];
					arr[i] = arr[j];
					arr[j] = temp;
				}
				
			}
			
		}
		
		for(int i = 0; i < arr.length; i++) {
			System.out.println(arr[i]);
		}
	
		
		/* 내가 작성한 삽입장렬 
		// 삽입정렬 예시 
		 int n = 10;
		 int[] arr = {7, 5, 9, 0, 3, 1, 6, 2, 4, 8};

	        for (int i = 1; i < n; i++) {
	            // 인덱스 i부터 1까지 감소하며 반복하는 문법
	            for (int j = i; j > 0; j--) {
	                // 한 칸씩 왼쪽으로 이동
	                if (arr[j] < arr[j - 1]) {
	                    // 스와프(Swap)
	                    int temp = arr[j];
	                    arr[j] = arr[j - 1];
	                    arr[j - 1] = temp;
	                }
	                // 자기보다 작은 데이터를 만나면 그 위치에서 멈춤
	                else break;
	            }
	        }

	        for(int i = 0; i < n; i++) {
	            System.out.print(arr[i] + " ");
	        }
		*/
		
		
	}
	
	
	
	
	
	
	
}
