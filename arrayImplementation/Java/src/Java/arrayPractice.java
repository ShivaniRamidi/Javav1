package Java;

public class arrayPractice {

		int[] array;
		int length;
		int capacity;
		
		public arrayPractice() {
		this.array = new int[this.capacity];
		this.length = 0;
		this.capacity = 2;
	}
		public arrayPractice(int initialCapacity) {
			if (initialCapacity <1) {
				this.capacity = 1;
			} else {
				this.capacity = initialCapacity;
			}
			this.length = 0;
			this.array = new int[this.capacity];
		}
		
		public int size() {
			return this.length;
		}
	
		public int getCapacity() {
			return this.capacity;
		}
		
		public boolean isEmpty() {
			return this.length == 0;
		}
		
		public int get(int index) {
			if (index < 0 || index >= this.length) {
				throw new IndexOutOfBoundsException("Index: " + index + ", Size : " + this.length);
			}
				return array[index];
			}
		
		public void set (int index, int value) {
			if(index <0 || index >= this.length) {
				throw new IndexOutOfBoundsException("Index: " + index + ", Size : " + this.length);
			}
			this.array[index] = value;
		}
		
		public void add (int element) {
			if (this.length == this.capacity ) {
				resize();
			}
			this.array[this.length] = element;
			this.length++;
		}
		
		public void insert(int index, int element) {
			if(index<0 || index >=this.length) {
				throw new IndexOutOfBoundsException("Index : " + index + ", Size : " + this.length);
			}
			if(index == this.length) {
				resize();
			}
			for (int i=this.length; i >index ; i--) {
				this.array[i] = this.array[i-1];
			}
			this.array[this.length] = element;
			this.length++;
		}
		
		public int removeAt(int index) {
			if (index<0 || index >=this.length) {
				throw new IndexOutOfBoundsException ("Index : " + index + ", Size : " + this.length);
			}
			int removeElement = this.array[index];
			
			for (int i =index; i < this.length -1; i++) {
				this.array[i] = this.array[i+1];
			}
			this.length--;
			return removeElement;
		}
		
		public void resize() {
			this.capacity = this.capacity *2;
			
			int[] newArray = new int[this.capacity];
			
			for (int i =0; i < this.length; i++) {
				newArray[i] = this.array[i];
			}
			
			this.array = newArray;
		}
		
		@Override
	    public String toString() {
	        if (this.length == 0) {
	            return "[]";
	        }

	        // Use a StringBuilder for efficient string concatenation.
	        StringBuilder sb = new StringBuilder();
	        sb.append("[");
	        for (int i = 0; i < this.length; i++) {
	            sb.append(this.array[i]);
	            if (i < this.length - 1) {
	                sb.append(", ");
	            }
	        }
	        sb.append("]");
	        return sb.toString();
	    }
		
	public static void main(String[] args) {
		
		arrayPractice arr = new arrayPractice();
		System.out.println(arr);
		System.out.println(arr.size());
		System.out.println(arr.getCapacity());
		System.out.println(arr.isEmpty());
		

        arr.add(10);
        System.out.println("Array: " + arr + ", Length: " + arr.size() + ", Capacity: " + arr.getCapacity());
	}
	

}
