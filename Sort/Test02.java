package Sort;

public class Test02 {

	// ��������
	// ���������̶�, �����͸� �տ������� �ϳ��� Ȯ���ؼ�
	// �����͸� ������ ��ġ�� �����ϴ� ��
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
	
		
		/* ���� �ۼ��� ������� 
		// �������� ���� 
		 int n = 10;
		 int[] arr = {7, 5, 9, 0, 3, 1, 6, 2, 4, 8};

	        for (int i = 1; i < n; i++) {
	            // �ε��� i���� 1���� �����ϸ� �ݺ��ϴ� ����
	            for (int j = i; j > 0; j--) {
	                // �� ĭ�� �������� �̵�
	                if (arr[j] < arr[j - 1]) {
	                    // ������(Swap)
	                    int temp = arr[j];
	                    arr[j] = arr[j - 1];
	                    arr[j - 1] = temp;
	                }
	                // �ڱ⺸�� ���� �����͸� ������ �� ��ġ���� ����
	                else break;
	            }
	        }

	        for(int i = 0; i < n; i++) {
	            System.out.print(arr[i] + " ");
	        }
		*/
		
		
	}
	
	
	
	
	
	
	
}
