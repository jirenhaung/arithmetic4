package 第二章排序;


import java.util.Arrays;


public class FailHeapSort<Key extends Comparable<Key>> {
	private Key [] pq;
	private int N=0;//pq[0]û��ʹ�ã�
	public FailHeapSort(int maxN){
		pq=(Key[])new Comparable[maxN+1];
	}
	public boolean isEmpty(){
		return N==0;
	}
	public int size(){
		return N;
	}
	/*public void insert(Key v){
		if(N==pq.length)resize(2*pq.length);//������鲻�����ˣ���̬���������С
		pq[N]=v;
		swim(N++);//�ϸ�
	}
	/*public void sort(Key [] a){
		for(int i=0;i<a.length;i++){
			insert(a[i]);
		}
		for(int i=a.length-1;i>=0;i--){
			a[i]=delMax();
		}
	}
	/*public Key delMax(){
		Key max=pq[0];//�Ӹ��ڵ�õ����Ԫ��
		exch(1, N--);//�����һ���ڵ㽻��
		pq[N+1]=null;//��ֹ��������
		sink(0);//�ָ��ѵ�������
		if(N>0&&N==pq.length/4)resize(pq.length/2);//��̬�ı������С
		return max;
	}*/
	private boolean less(Key[]pq,int i,int j){
		return pq[i].compareTo(pq[j])<0;
	}
	private void exch(Key[]pq,int i,int j){
		Key t=pq[i];pq[i]=pq[j];pq[j]=t;
	}
	/*private void swim(int k){
		while(k>0&&less((k-1)/2, k)){
			exch((k-1)/2, k);
			k=(k-1)/2;
		}
	}*/
	private void sink(Key[]a,int k,int N){
		while(2*k<=N){
			int j=2*k;
			if(j<N&&less(a,j, j+1))j++;
			if(!less(a,k, j))break;
			exch(a,k, j);
			k=j;
		}
	}
	public  void sort(Key[]a){
		int N=a.length;
		for(int k=N/2;k>=1;k--)
			sink(a,k,N);
		while(N>1){
			exch(a, 1, N--);
			sink(a, 1, N);
		}
	}
	private void resize(int max){
		Key[] keys=(Key[]) new Comparable[max];
		for(int i=0;i<N;i++)
			keys[i]=pq[i];
		pq=keys;
	}
}
