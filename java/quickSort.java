import java.util.Arrays;
public class quickSort{
	
	public static void main(String[] args){
		int[] a={4,1,3,8,5};
		quick_Sort(a,0,4);
		System.out.println(Arrays.toString(a));
	}
	public static void quick_Sort(int[] a,int l,int r){
		if(l>=r)
			return;
		int left=l;
		int right=r;
		int temp = a[left];
		while(left<right){
			while(a[right]>=temp && left<right)
				right--;
			while(a[left]<=temp && left<right)
				left++;
			if(left<right){
				int b=a[left];
				a[left]=a[right];
				a[right]=b;
			}
			}
		a[l]=a[left];
		a[left]=temp;
		quick_Sort(a,l,left-1);
		quick_Sort(a,left+1,r);
		}
}