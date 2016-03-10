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
  This function is O(nlogn). Splitting is constant, merging is linear, and there are logn calls made since the list gets cut in half each time so if there are logn linear calls made, then the total runtime would be O(nlogn).

  Mean execution times for dataset of size n:
  Batch size: <# of times each dataset size was run>
  n=1       time: 
  n=10      time: 
  n=100     time: 
  ...
  n=<huge>  time: 

  ANALYSIS:
  <INSERT YOUR RESULTS ANALYSIS HERE>
  ======================================*/

public class MergeSortTester 
{

    public static long test(int a){
	int[] s = new int[a];
	for(; a>0; a--){
	    s[a] = (int)(Math.random()*10000);
	}
	long st = System.nanoTime();
	MergeSort.sort(s);
	long et = System.nanoTime();
	return et-st;
    } 
    /******************************
     * execution time analysis 
     * <INSERT YOUR DESCRIPTION HERE OF 
     *  YOUR APPARATUS FOR GENERATING EXECUTION 
     *  TIME DATA...>
     ******************************/
    public static void main( String[] args ) 
    {
	System.out.println(test(1));
	System.out.println(test(10));
	System.out.println(test(100));
	System.out.println(test(1000));
    }//end main

}//end class
