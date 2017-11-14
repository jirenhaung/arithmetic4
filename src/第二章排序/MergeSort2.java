package 第二章排序;

public class MergeSort2 {
	private static Comparable[] aux;//��������
	public static void sort(Comparable[] a){
		int N=a.length;
		aux=new Comparable[N];
		for(int sz=1;sz<N;sz=sz+sz)
			for(int lo=0;lo<N-sz;lo+=sz+sz)
				merge(a, lo, lo+sz-1, Math.min(lo+sz+sz-1, N-1));
		
	}
	/*private static void sort(Comparable[] a,int lo,int hi){
		if(hi<=lo) return;//�˳��ݹ�����
		int mid=lo+(hi-lo)/2;
		sort(a,lo,mid);//�����������
		sort(a, mid+1, hi);//�ұ���������
		merge(a,lo,mid,hi);//���ҽ��й鲢
	}*/
	//�鲢����
	private static void merge(Comparable[] a,int lo,int mid,int hi){
		int i=lo,j=mid+1;
		for(int k=lo;k<=hi;k++)
			aux[k]=a[k];//��Ҫ���й鲢�Ĳ���������븨�������
		for(int k=lo;k<=hi;k++){
			if(i>mid) a[k]=aux[j++];//�����ߵ��α곬����λ�����ͰѸ����������ұߵ������μ��뵽ԭ�����ﲢ�ұ��α��һ
			else if(j>hi) a[k]=aux[i++];//����ұ߱ߵ��α곬���ұ߽������Ͱ���ߵ������μ��뵽ԭ�����ﲢ����α��һ
			else if(less(aux[j],aux[i])) a[k]=aux[j++];//����ұߵ�������ߵ�С�����ұߵ����Ƶ�ԭ�����ﲢ�ұ��α��һ
			else a[k]=aux[i++];//����ұߵ�������ߵĴ󣬰���ߵ����Ƶ�ԭ�����ﲢ����α��һ
		}
		
	}
	//�Ƚ�����Ԫ�ش�С
	private static boolean less(Comparable v,Comparable w){
		return v.compareTo(w)<0;
	}
	/*public static void main(String[] args) {
		Integer[] a={3,2,14,5,67,8};
		sort(a);
		for(int i=0;i<a.length;i++)
			System.out.print(a[i]+" ");
	}*/
}
