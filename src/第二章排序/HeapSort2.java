package 第二章排序;

import java.util.Arrays;
public class HeapSort2 {
    /**
     * �����󶥶�
     */
    public static void adjustHeap(int[] a, int i, int len) {
        int temp, j;
        temp = a[i];
        for (j = 2 * i; j < len; j *= 2) {// �عؼ��ֽϴ�ĺ��ӽ������ɸѡ
            if (j < len && a[j] < a[j + 1])
                ++j; // jΪ�ؼ����нϴ��¼���±�
            if (temp >= a[j])
                break;
            a[i] = a[j];
            i = j;
        }
        a[i] = temp;
    }

    public static void heapSort(int[] a) {
        int i;
        for (i = a.length / 2 - 1; i >= 0; i--) {// ����һ���󶥶�
            adjustHeap(a, i, a.length - 1);
        }
        for (i = a.length - 1; i >= 0; i--) {// ���Ѷ���¼�͵�ǰδ�����������е����һ����¼����
            int temp = a[0];
            a[0] = a[i];
            a[i] = temp;
            adjustHeap(a, 0, i - 1);// ��a��ǰi-1����¼���µ���Ϊ�󶥶�
        }
    }

    public static void main(String[] args) {
        int a[] = { 10, 9, 8,11,1};
        heapSort(a);
        System.out.println(Arrays.toString(a));
    }
} 