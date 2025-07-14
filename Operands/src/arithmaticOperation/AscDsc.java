package arithmaticOperation;

public class AscDsc {
	int[] array = {2, 1, 4, 5, 8, 7};
	int length;
	
	public AscDsc() {
		this.length =array.length;
	}
	public void AscDsc() {
		
		for (int i=0; i<length-1; i++ ) {
			if (array[i] < array[i+1]) {
						System.out.println(array[i] + "Array is in ascending order!");
				
			} else System.out.println(array[i] + "Array is not in ascending order!");
		}
		
		//return false;
		
	}
	public void print() {
		for (int i=0; i<array.length; i++) { 
			System.out.print(array[i] + ", ");
	}
	System.out.println("");
		}
	public void getLength() {
		System.out.print(length);
	}
	
	public static void main (String[] args) {
		AscDsc ad = new AscDsc();
		
		
		ad.AscDsc();
		ad.print();
		ad.getLength();
	}
	
}
