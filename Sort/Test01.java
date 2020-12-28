package Sort;

public class Test01 {

	//선택정렬
	// 선택정렬이란, 가장 작은 데이터를 선택해서,
	// 정렬되지 않은 데이터 중에서 가장 앞쪽에 있는 데이터와 바꾸는것
	
	public static void main(String[] args) {

       
        int[] arr = {7, 5, 9, 0, 3, 1, 6, 2, 4, 8};

   
        for(int i = 0; i < arr.length; i++) {
        	int min_index = i;
        	for(int j = i+1; j < arr.length; j++) {
        		if (arr[j] <arr[min_index]) {
        			min_index = j; // 가장 작은 데이터의 인덱스
        			
        		}
        	
        		int temp = arr[i]; 
        		arr[i] = arr[min_index];
        		arr[min_index] = temp;
        		
        		
        	}
        	
       
        
        }
        	
        	
        for(int i = 0; i < arr.length; i ++) {
        	System.out.println(arr[i]);
        
        	
        }
        
        
    }
	
	
	
	
	
}
