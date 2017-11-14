package 第二章排序;

public class Quick3way {
	public static void sort(Comparable[] a,int lo,int hi)
	{
		if(hi<=lo)return;
		int lt=lo,i=lo+1,gt=hi;
		Comparable v=a[lo];
		while(i<=gt)
		{
			int cmp=a[i].compareTo(v);
			if(cmp<0)exch(a, lt++, i++);
			else if(cmp>0)exch(a, i, gt--);
			else
				i++;
		}
		sort(a, lo, lt-1);
		sort(a, gt+1, hi);
	}
	private static void exch(Comparable[] a,int i,int j){
		Comparable tComparable=a[i];
		a[i]=a[j];
		a[j]=tComparable;
	}
}
