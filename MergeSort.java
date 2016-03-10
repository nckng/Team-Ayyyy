//Jannie Li
//APCS2 pd9
//HW09 -- Mergers and Acquisitions
//2016-03-07

/*======================================
  class MergeSort
  Implements mergesort on array of ints.

  Summary of Algorithm: 
  1. Break given array down recursively until it's definitely ordered 
     (has one element).
  2. Each recursive call will call the helper merge(), which will combine
     two ordered lists into a still-ordered larger one. Will build up
     ordered lists.
  3. Return full ordered list.
  ======================================*/

public class MergeSort {

   /******************************************************
     * int[] merge(int[],int[]) 
     * Merges two input arrays
     * Precond:  Input arrays are sorted in ascending order
     * Postcond: Input arrays unchanged, and 
     * output array sorted in ascending order.
     ******************************************************/
    private static int[] merge( int[] a, int[] b ) 
    {
	//go along each array, adding to ret the smallest value
	
	int[] ret = new int[a.length + b.length];
	int indexA = 0; //keeps track of index of a
	int indexB = 0; //keeps track of index of b
	
	for (int i = 0; i < ret.length; i++) {
	    if (indexA < a.length && indexB < b.length) {
		if (a[indexA] < b[indexB]) {
		    ret[i] = a[indexA];
		    indexA++;
		}
		else {
		    ret[i] = b[indexB];
		    indexB++;
		}
	    }

	    else if (indexA < a.length) { //if there are still #s in a
		ret[i] = a[indexA];
		indexA++;
	    }

	    else if (indexB < b.length) { //if there are still #s in b
		ret[i] = b[indexB];
		indexB++;
	    }
	}
	
	return ret;
	
    }//end merge()


    /******************************************************
     * int[] sort(int[]) 
     * Sorts input array using mergesort algorithm
     * Returns sorted version of input array (ascending)
     ******************************************************/
    public static int[] sort( int[] arr ) 
    {
	if (arr.length == 1)
	    return arr;

	int splitA = arr.length / 2; //split length appropriately
	int splitB = splitA;
	if (arr.length % 2 == 1) //if odd, make one bigger to include all #s
	    splitB++;
		
	int[] a = new int[splitA];
	int[] b = new int[splitB];

	//copy arrays
	for (int i = 0; i < splitA; i++) {
	    a[i] = arr[i];
	}
	for (int i = 0; i < splitB; i++) {
	    b[i] = arr[i + splitA];
	}

	//recursive call-- sort will get size down to 1 and the list
	//will build up through merge
	return merge( sort(a) , sort(b) );

    }//end sort()



    //-------------------HELPERS-------------------------
    //tester function for exploring how arrays are passed
    //usage: print array, mess(array), print array. Whaddayasee?
    public static void mess( int[] a ) {
	for( int i = 0 ; i<a.length; i++ )
	    a[i] = 0;
    }

    //helper method for displaying an array
    public static void printArray( int[] a ) {
	System.out.print("[");
	for( int i : a )
	    System.out.print( i + ",");
	System.out.println("]");
    }
    //---------------------------------------------------


    //main method for testing
    public static void main( String [] args ) {

	
	int[] arr0 = {0};
	int[] arr1 = {1};
	int[] arr2 = {1,2};
	int[] arr3 = {3,4};
	int[] arr4 = {1,2,3,4};
	int[] arr5 = {4,3,2,1};
	int[] arr6 = {9,42,17,63,0,512,23};
	int[] arr7 = {9,42,17,63,0,9,512,23,9};

	System.out.println("\nTesting mess-with-array method...");
	printArray( arr3 );
	mess(arr3);
	printArray( arr3 );

	System.out.println("\nMerging arr1 and arr0: ");
	printArray( merge(arr1,arr0) );

	System.out.println("\nMerging arr4 and arr6: ");
	printArray( merge(arr4,arr6) );

	System.out.println("\nSorting arr4-7...");
	printArray( sort( arr4 ) );
	printArray( sort( arr5 ) );
	printArray( sort( arr6 ) );
	printArray( sort( arr7 ) );
	/*~~~~~~~~~~~~~~ Ye Olde Tester Bar ~~~~~~~~~~~~~~
	  ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~*/
    }//end main()

}//end class MergeSort
