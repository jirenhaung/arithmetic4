package 第二章排序;

public class Shell {
	public static void sort(Comparable[] a){
		int N=a.length;
		int h=1;
		while(h<N/3) h=3*h+1;
		while(h>=1){
			for(int i=h;i<N;i++){
				Comparable currentElemet=a[i];
				int k;
				for(k=i-h;k>=0&&less(currentElemet, a[k]);k-=h)
					a[k+h]=a[k];
				a[k+h]=currentElemet;
			}
			h=h/3;
		}
	}
	private static boolean less(Comparable v,Comparable w){
		return v.compareTo(w)<0;
	}
	private static void exch(Comparable[] a,int i,int j){
		Comparable tComparable=a[i];
		a[i]=a[j];
		a[j]=tComparable;
	}
	public static boolean isSorted(Comparable[] a){
		for(int i=0;i<a.length;i++)
			if(less(a[i], a[i-1])) return false;
		return true;
	}
	/*public static void main(String[] args) {
		Integer[] a={3,2,14,5,67,8};
		sort(a);
		for(int i=0;i<a.length;i++)
			System.out.print(a[i]+" ");
	}*/
}
