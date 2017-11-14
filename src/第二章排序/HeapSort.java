package 第二章排序;


import java.util.Arrays;

public class HeapSort {  
      
    /** 
     * 1.�������ѣ�����һƪ���ڶѵ����ȶ������ƣ���ԭʼ����������֯��һ�����ڶѵ�ӵ���ظ�ɾ�����Ԫ�ز��������ȶ��У� 
     * 2.�³����򣺸��ݹ�������Ĵ���ѣ������׽����е����Ԫ��ɾ����Ȼ��������С�������пճ���λ�á� 
     */  
	public void HeapAdjustDown(int []arr,int start,int end)  
	{  
	    int temp = arr[start];  //���浱ǰ�ڵ�  
	    int i = 2*start+1;      //�ýڵ�������������е�λ�����  
	    while(i<=end)  
	    {  
	        //�ҳ����Һ����������Ǹ�  
	        if(i+1<=end && arr[i+1]>arr[i])    
	            i++;  
	        //������϶ѵĶ��壬���õ���λ��  
	        if(arr[i]<=temp)   
	            break;  
	        //�����ӽڵ������ƶ����滻���丸�ڵ�  
	        arr[start] = arr[i];  
	        start = i;  
	        i = 2*start+1;  
	    }  
	    arr[start] = temp;  
	}
	public void sort(int []a){
		int len=a.length;
		//�����齨��Ϊ����  
		//��һ����Ҷ�ӽڵ��λ�����Ϊ(len-1)/2 
		//������һ�����ն˽ڵ���len/2-1��������Ϊ�������ж�������������󲻻����Ӱ�졣
		for(int i=len/2-1;i>=0;i--)  
		    HeapAdjustDown(a,i,len-1);
		for(int i=len-1;i>0;i--)  
		{  
		    //�Ѷ�Ԫ�غ����һ��Ԫ�ؽ���λ�ã�  
		    //��������һ��λ�ñ��������������  
		    //ÿ��ѭ�����ν��δ����ֵ�ڷŽ���ǰ��һ��λ�ã�  
		    //�����õ���˳����Ǵ�С����  
		    int temp = a[i];  
		    a[i] = a[0];  
		    a[0] = temp;  
		    //��arr[0...i-1]���µ���Ϊ����  
		    HeapAdjustDown(a,0,i-1);  
		} 
	}
    /*
    private static boolean less(Comparable v,Comparable w)  
    {  
        return v.compareTo(w) < 0;  
    }  
      
    private static void exch(Comparable[] v,int i, int j)  
    {  
        Comparable temp = v[i];  
        v[i] = v[j];  
        v[j] = temp;  
    }  
      
    public static void show(Comparable[] a)  
    {  
        for(int i = 1; i < a.length; i++)  
        {  
            System.out.print(a[i] + " ");  
        }  
        System.out.println();  
    }  
    */  
    public static void main(String[] args)  
    {  
       /* int N = 12;  
        Integer[] a = new Integer[N];  
        for(int i = 1; i <= N-1; i++)  
        {  
            a[i] = (int)(Math.random() * 10 + 1);  
        }*/
    	int[]a={123,21,324,56,32,1243,1,22,-23,4,0,1314};
        //show(a);  
        HeapSort hp=new HeapSort();
        hp.sort(a);
        System.out.println(Arrays.toString(a));
    }  
}
 