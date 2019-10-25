
public class Sort {
   
    //插入排序
    static void insertSort(int[] a) {
        if(a.length == 1) return;
        for (int i = 1; i < a.length; i++) {
            int temp = a[i],j = i-1;
            for (; j>=0; j--) {
                if(a[j] > temp ) {
                    a[j+1] = a[j];
                }else {
                    break;
                }
            }
            a[j+1] = temp;
        }
    }
    //希尔排序
    static void shellSort(int[] a) {
        int len = a.length;
        if(len == 1) return;
        int gap = len /2;
        while(gap > 0) {
            for (int i = gap; i <len ; i++) {
                int temp = a[i],j = i-gap;
                while(j >=0 && a[j] > temp) {
                    a[j+gap] = a[j];
                    j = j-gap;
                }
                a[j+gap] =temp;
            }
            gap = gap/2;
        }
    }



    /*
    归并排序，下面主要为从底而上和，从顶而下的方法
     */
    static void mergeSort(int a[]) {
        for (int i = 1; i <a.length ; i= i*2) {
            for (int j = 0; j*i-1 < a.length; j = j+2*i) {
                merge(a,j,j+i-1,Math.min(j+2*i-1,a.length-1));
            }
        }
    }
    static void mergeSort1(int a[],int l,int r) {
        int len = a.length;
        if(l >= r)return;
        int mid = l+(r-l) / 2;  //这里选择mid,需要注意，不是加1，而是左边界
        mergeSort1(a,l,mid);
        mergeSort1(a,mid+1,r);
        merge(a,l,mid,r);
    }
    static void merge(int a[],int left,int mid,int right) {
        if(mid > right) return;
        int[] temp = new int[right-left+1];
        int l =left,m = mid+1,r = right,i=0;
        while(l <= mid && m <= right) {
            temp[i++] = a[l] <= a[m] ? a[l++] : a[m++];
        }
        while(l <= mid) {
            temp[i++] = a[l++];
        }
        while(m <= right) {
            temp[i++] = a[m++];
        }
        for (int j = 0; j < temp.length; j++) {
            a[left+j] = temp[j];
        }
    }

    /*
    堆排序注意几点：
    1、调整的时候注意方法
    2、从第一个非叶节点开始构建堆
     */
    static void heapSort(int[] a) {
        int len = a.length;
        for (int i = len/2-1; i >=0; i--) {
            sift(a,i,len-1);
        }
      for(int i=len-1;i>0;i--) {
          int temp = a[0];
          a[0] = a[i];
          a[i] = temp;
          sift(a,0,i-1);
       }
    }
    static void sift(int[] a,int low,int high) {
        int l = low * 2+1;
        int temp = a[low];
        while(l<=high) {
            if(l+1 <= high && a[l+1] > a[l]){
                l++;
            }
            if(a[l] > temp) {
                a[low] = a[l];
                low = l;
                l = l*2+1;
            }else break;
        }
        a[low] = temp;
    }
//下面为快速排序的优化
   /*
解决基准选择问题：
1、通过随机选择优化（和第一个交换）
2、三数取中，一般为第一个，中间的和最后的，可以较好的解决有序基准选择问题

解决大量重复，选择基准没意义：
1、通过聚合，每次分割完，将相同的元素聚集。
2、通过设置栈高度，一旦递归深度大于阈值，转化为其他排序，比如堆排序。

优化小数据量：
1、数据量较小使用插入排序
*/
}
