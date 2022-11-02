import java.util.ArrayList;
import java.util.List;
import models.Vulnerability;

public class Quick {
    
	/**
	 * This method sort the input ArrayList using quick sort algorithm.
	 * @param input the ArrayList of Objects.
	 * @return sorted ArrayList of Objects.
	 */
	public List<Vulnerability> quicksort(List<Vulnerability> input){
		
		if(input.size() <= 1){
			return input;
		}
		
		int middle = (int) Math.ceil((double)input.size() / 2);
		Vulnerability pivot = input.get(middle);

		List<Vulnerability> less = new ArrayList<Vulnerability>();
		List<Vulnerability> greater = new ArrayList<Vulnerability>();
		
		for (int i = 0; i < input.size(); i++) {
            int res = input.get(i).compareTo(pivot);
			if(res == -1){
				if(i == middle){
					continue;
				}
				less.add(input.get(i));
			}
			else{
				greater.add(input.get(i));
			}
		}
		
		return concatenate(quicksort(less), pivot, quicksort(greater));
	}
	
	/**
	 * Join the less array, pivot integer, and greater array
	 * to single array.
	 * @param less Object ArrayList with values less than pivot.
	 * @param pivot the pivot Object.
	 * @param greater Object ArrayList with values greater than pivot.
	 * @return the Object ArrayList after join.
	 */
	private List<Vulnerability> concatenate(List<Vulnerability> less, Vulnerability pivot, List<Vulnerability> greater){
		
		List<Vulnerability> list = new ArrayList<Vulnerability>();
		
		for (int i = 0; i < less.size(); i++) {
			list.add(less.get(i));
		}
		
		list.add(pivot);
		
		for (int i = 0; i < greater.size(); i++) {
			list.add(greater.get(i));
		}
		
		return list;
	}
}