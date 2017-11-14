package 第二章排序;

public class Quick {
	public static void sort(Comparable[] a){
		sort(a,0,a.length-1);
	}
	private static void sort(Comparable[] a,int lo,int hi){
		if(hi<=lo) return;
		//在排序小数组时切换到插入排序，10可以换成5~15之间的任意值。
		//if(hi<=lo+10){ insertion.sort(a); return;}
		int j=partition(a,lo,hi);
		sort(a, lo, j-1);
		sort(a, j+1, hi);
	}
	private static int partition(Comparable[] a,int lo,int hi){
		int i=lo,j=hi+1;
		Comparable v=a[lo];
		while(true)
		{
			while(less(a[++i],v)) if(i==hi) break;
			while(less(v,a[--j])) ;//if(j==lo) break;因为切分元素就是a[lo],他不可能比自己小。
			if(i>=j) break;
			exch(a,i,j);
		}
		exch(a,lo,j);
		return j;
	}
	private static boolean less(Comparable v,Comparable w){
		return v.compareTo(w)<0;
	}
	private static void exch(Comparable[] a,int i,int j){
		Comparable tComparable=a[i];
		a[i]=a[j];
		a[j]=tComparable;
	}
}
