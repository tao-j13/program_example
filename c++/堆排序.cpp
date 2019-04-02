void adjust(int a[], int i, int j) //i为开始索引，j为最大索性
{
	int temp = a[i];
	int k = i * 2 + 1;
	while (k<=j)
	{
		if (k+1 <=j && a[k] < a[k+1])
			k++;
		if (a[i] < a[k])
		{
			a[i] = a[k];
			i = k;
			k = 2 * i + 1;
		}
		else
			break;
	}
	a[i] = temp;
}
void HeapSort(int a[], int length) //length为长度
{
	for (int i = length/2-1; i >=0; --i)
	{
		adjust(a, i, length-1);
	}
	for (int j = length-1; j > 0; --j)
	{
		int temp = a[j];
		a[j] = a[0];
		a[0] = temp;
		adjust(a, 0, j-1);
	}
}
