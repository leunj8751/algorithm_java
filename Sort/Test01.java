package Sort;

public class Test01 {

	//��������
	// ���������̶�, ���� ���� �����͸� �����ؼ�,
	// ���ĵ��� ���� ������ �߿��� ���� ���ʿ� �ִ� �����Ϳ� �ٲٴ°�
	
	public static void main(String[] args) {

       
        int[] arr = {7, 5, 9, 0, 3, 1, 6, 2, 4, 8};

   
        for(int i = 0; i < arr.length; i++) {
        	int min_index = i;
        	for(int j = i+1; j < arr.length; j++) {
        		if (arr[j] <arr[min_index]) {
        			min_index = j; // ���� ���� �������� �ε���
        			
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
