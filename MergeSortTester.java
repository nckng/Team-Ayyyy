//Team Ayyyy -- Jannie Li, Nick Ng, Shantanu Jha
//APCS2 pd9
//HW11 -- Wrapping It Up
//2016-03-11

/*======================================
  class MergeSortTester

  ALGORITHM:
 
  1. Break given array down recursively until it's definitely ordered 
     (has one element).
  2. Each recursive call will call the helper merge(), which will combine
     two ordered lists into a still-ordered larger one. Will build up
     ordered lists.
  3. Return full ordered list.

  BIG-OH CLASSIFICATION OF ALGORITHM:
  This function is O(nlogn). Splitting is constant, merging is linear, and 
  there are logn calls made since the list gets cut in half each time so if 
  there are logn linear calls made, then the total runtime would be O(nlogn).

  Mean execution times for dataset of size n:
  Batch size: <# of times each dataset size was run>
  n=1        time: 0
  n=10       time: 14000
  n=100      time: 110000
  n=1000     time: 1321000
  n=10000    time: 37522000
  n=100000   time: 33835000
  n=1000000  time: 226069000
  n=10000000 time: 2402073000
  
  n=20000000   time: 4461934000

  ANALYSIS:
  The time increases quickly at first then slows down a little.
  This change shows that it's not linear or logn, but also definitely
  not exponential, which confirms our decision that mergesort has
  the classification of O(n logn). If it were graphed, it looks 
  generally like the n logn graph.
  ======================================*/

public class MergeSortTester 
{
    /******************************
     * execution time analysis 
     *
     * <TIME DATA APPARATUS:>
     * Generate list of size given.
     * Set start time.
     * Call MergeSort's sort method.
     * Record end time.
     * Return the difference (end - start) for time.
     ******************************/

    public static long test(int a){
	int[] s = new int[a];
	for(; a > 0; a--){
	    s[a-1] = (int)(Math.random()*10000);
	}
	long st = System.nanoTime();
	MergeSort.sort(s);
	long et = System.nanoTime();
	return et-st;
    } 

    public static void main( String[] args ) 
    {
	System.out.println("\n\tEXECUTION TIME TESTING:\n");
	
	System.out.println("dummy case test(1)...");
	System.out.print(test(1));
	//first one is slower-- first contact w class MergeSort?
	//class construction?

	System.out.println("\n\tstart of official times:");

	System.out.println("\narray length 1:");
	System.out.println(test(1));

	System.out.println("\narray length 10:");
	System.out.println(test(10));

	System.out.println("\narray length 100:");
	System.out.println(test(100));

	System.out.println("\narray length 1000:");
	System.out.println(test(1000));

	System.out.println("\narray length 10000:");
	System.out.println(test(10000));

	System.out.println("\narray length 100000:");
	System.out.println(test(100000));

	System.out.println("\narray length 1000000:");
	System.out.println(test(1000000));

	System.out.println("\narray length 10000000:");
	System.out.println(test(10000000));

	System.out.println("\narray length 20000000:");
	System.out.println(test(20000000));

    }//end main

}//end class
