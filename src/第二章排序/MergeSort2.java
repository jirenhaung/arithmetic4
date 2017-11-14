package 第二章排序;

public class MergeSort2 {
	private static Comparable[] aux;//辅助数组
	public static void sort(Comparable[] a){
		int N=a.length;
		aux=new Comparable[N];
		for(int sz=1;sz<N;sz=sz+sz)
			for(int lo=0;lo<N-sz;lo+=sz+sz)
				merge(a, lo, lo+sz-1, Math.min(lo+sz+sz-1, N-1));
		
	}
	/*private static void sort(Comparable[] a,int lo,int hi){
		if(hi<=lo) return;//退出递归条件
		int mid=lo+(hi-lo)/2;
		sort(a,lo,mid);//左边数组排序
		sort(a, mid+1, hi);//右边数组排序
		merge(a,lo,mid,hi);//左右进行归并
	}*/
	//归并函数
	private static void merge(Comparable[] a,int lo,int mid,int hi){
		int i=lo,j=mid+1;
		for(int k=lo;k<=hi;k++)
			aux[k]=a[k];//将要进行归并的部分数组放入辅助数组里。
		for(int k=lo;k<=hi;k++){
			if(i>mid) a[k]=aux[j++];//如果左边的游标超过中位数，就把辅助数组中右边的数依次加入到原数组里并右边游标加一
			else if(j>hi) a[k]=aux[i++];//如果右边边的游标超过右边界数，就把左边的数依次加入到原数组里并左边游标加一
			else if(less(aux[j],aux[i])) a[k]=aux[j++];//如果右边的数比左边的小，把右边的数移到原数组里并右边游标加一
			else a[k]=aux[i++];//如果右边的数比左边的大，把左边的数移到原数组里并左边游标加一
		}
		
	}
	//比较两个元素大小
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
