private static boolean less(Comparable v, Comparable w) {
	
	return (v.CompareTo(w) < 0)
}

private static void exch(Comparable[] a, int i, int j) {
	
	Comparable swap = a[i];

	a[i] = a[j];

	a[j] = swap;
}