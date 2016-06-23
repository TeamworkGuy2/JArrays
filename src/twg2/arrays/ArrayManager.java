package twg2.arrays;

/**
 * @author TeamworkGuy2
 * @since 2015-9-10
 */
@javax.annotation.Generated("StringTemplate")
public final class ArrayManager {


	public static final class Boolean {
		public int size;
		public boolean[] data;
	}


	public static final class Byte {
		public int size;
		public byte[] data;
	}


	public static final class Short {
		public int size;
		public short[] data;
	}


	public static final class Char {
		public int size;
		public char[] data;
	}


	public static final class Int {
		public int size;
		public int[] data;
	}


	public static final class Long {
		public int size;
		public long[] data;
	}


	public static final class Float {
		public int size;
		public float[] data;
	}


	public static final class Double {
		public int size;
		public double[] data;
	}




	// ==== boolean array manager functions ====

	/** Remove the element at the specified index from the array<br>
	 * Collection Reminder:
	 * <ul>
	 * <li>increment action count</li>
	 * <li>decrement size</li>
	 * </ul>
	 * @param index the index between {@code [0, size - 1]} to remove
	 * @return the element found at the specified index
	 */
	public static  boolean removeUnordered(boolean[] data, int size, int index) {
		//if(index >= size) {
		//	throw new ArrayIndexOutOfBoundsException(index + " of [0, " + size + "]");
		//}
		// Get the item to remove
		boolean item = data[index];
		// Replace the item to remove with the last element from our array
		data[index] = data[size - 1];
		// Set the last element to null
		data[size - 1] = false;
		return item;
	}


	/** Remove the char at the specified index<br>
	 * Collection Reminder:
	 * <ul>
	 * </ul>
	 * @param index the index between {@code [0, size - 1]} to remove
	 * @return the char found at the specified index
	 * @throws ArrayIndexOutOfBoundsException if the index is outside the range {@code [0, size - 1]}
	 */
	public static  boolean removeIndex(boolean[] data, int size, int index) {
		//if(index < 0 || index >= size) {
		//	throw new ArrayIndexOutOfBoundsException(index + " of [0, " + size + ")");
		//}
		// Shift all elements above the remove element to fill the empty index
		// Get the item to remove
		boolean item = data[index];

		removeRange(data, size, index, 1);

		return item;
	}


	/** Remove the element at the specified index from the array<br>
	 * Collection Reminder:
	 * <ul>
	 * <li>increment action count</li>
	 * <li>size minus len</li>
	 * </ul>
	 */
	public static  void removeRange(boolean[] data, int size, int off, int len) {
		//if(off < 0 || off + len > size) {
		//	throw new ArrayIndexOutOfBoundsException((off < 0 ? off : off + len) + " of [0, " + size + ")");
		//}
		// Shift all elements above the remove element to fill the empty index
		// Copy down the remaining upper half of the array if the item removed was not the last item in the array
		if(off + len < size) {
			System.arraycopy(data, off + len, data, off, size - (off + len));
		}
	}


	/** Remove the specified object from the array<br>
	 * Collection Reminder:
	 * <ul>
	 * </ul>
	 * @param item the object to remove based on item.equals(get(i)) if item
	 * is not null, or get(i)==null if item is null, where i is [0, size()-1]
	 * @return true if the element was removed successfully, false otherwise
	 */
	public static  boolean removeValue(boolean[] data, int size, boolean item) {
		// Search for the item to remove
		for(int i = 0; i < size; i++) {
			// If the item is found, remove it
			if(item == data[i]) {
				removeIndex(data, size, i);
				return true;
			}
		}
		return false;
	}


	/** Add the specified item to the array<br>
	 * Collection Reminder:
	 * <ul>
	 * <li>increment action count</li>
	 * <li>increment size</li>
	 * </ul>
	 * @param item the item to add to the array
	 */
	public static  boolean[] add(boolean[] data, int size, boolean item) {
		// If the array is to small, expand it
		if(size + 1 > data.length) {
			data = expand(data);
		}
		// Add the new item
		data[size] = item;
		return data;
	}


	/** Designed for use by code that manages arrays by hand.
	 * Note: expands array ~1.5x it's current size
	 */
	public static final boolean[] expand(boolean[] oldAry) {
		// Expand array size 1.5x + 4, +4 instead of +1 to prevent small arrays from constantly needed to resize
		boolean[] newAry = new boolean[oldAry.length + (oldAry.length >>> 1) + 4];
		System.arraycopy(oldAry, 0, newAry, 0, oldAry.length);
		return newAry;
	}


	/** Designed for use by code that manages arrays by hand
	 * Note: expands array ~1.5x it's current size, up to a maximum of {@code maxSize}
	 */
	public static final boolean[] expand(boolean[] oldAry, int maxSize) {
		// Expand array size 1.5x + 4, +4 instead of +1 to prevent small arrays from constantly needed to resize
		int newSize = Math.max(maxSize, oldAry.length + (oldAry.length >>> 1) + 4);
		boolean[] newAry = new boolean[newSize];
		System.arraycopy(oldAry, 0, newAry, 0, oldAry.length);
		return newAry;
	}


	// ==== byte array manager functions ====

	/** Remove the element at the specified index from the array<br>
	 * Collection Reminder:
	 * <ul>
	 * <li>increment action count</li>
	 * <li>decrement size</li>
	 * </ul>
	 * @param index the index between {@code [0, size - 1]} to remove
	 * @return the element found at the specified index
	 */
	public static  byte removeUnordered(byte[] data, int size, int index) {
		//if(index >= size) {
		//	throw new ArrayIndexOutOfBoundsException(index + " of [0, " + size + "]");
		//}
		// Get the item to remove
		byte item = data[index];
		// Replace the item to remove with the last element from our array
		data[index] = data[size - 1];
		// Set the last element to null
		data[size - 1] = (byte)0;
		return item;
	}


	/** Remove the char at the specified index<br>
	 * Collection Reminder:
	 * <ul>
	 * </ul>
	 * @param index the index between {@code [0, size - 1]} to remove
	 * @return the char found at the specified index
	 * @throws ArrayIndexOutOfBoundsException if the index is outside the range {@code [0, size - 1]}
	 */
	public static  byte removeIndex(byte[] data, int size, int index) {
		//if(index < 0 || index >= size) {
		//	throw new ArrayIndexOutOfBoundsException(index + " of [0, " + size + ")");
		//}
		// Shift all elements above the remove element to fill the empty index
		// Get the item to remove
		byte item = data[index];

		removeRange(data, size, index, 1);

		return item;
	}


	/** Remove the element at the specified index from the array<br>
	 * Collection Reminder:
	 * <ul>
	 * <li>increment action count</li>
	 * <li>size minus len</li>
	 * </ul>
	 */
	public static  void removeRange(byte[] data, int size, int off, int len) {
		//if(off < 0 || off + len > size) {
		//	throw new ArrayIndexOutOfBoundsException((off < 0 ? off : off + len) + " of [0, " + size + ")");
		//}
		// Shift all elements above the remove element to fill the empty index
		// Copy down the remaining upper half of the array if the item removed was not the last item in the array
		if(off + len < size) {
			System.arraycopy(data, off + len, data, off, size - (off + len));
		}
	}


	/** Remove the specified object from the array<br>
	 * Collection Reminder:
	 * <ul>
	 * </ul>
	 * @param item the object to remove based on item.equals(get(i)) if item
	 * is not null, or get(i)==null if item is null, where i is [0, size()-1]
	 * @return true if the element was removed successfully, false otherwise
	 */
	public static  boolean removeValue(byte[] data, int size, byte item) {
		// Search for the item to remove
		for(int i = 0; i < size; i++) {
			// If the item is found, remove it
			if(item == data[i]) {
				removeIndex(data, size, i);
				return true;
			}
		}
		return false;
	}


	/** Add the specified item to the array<br>
	 * Collection Reminder:
	 * <ul>
	 * <li>increment action count</li>
	 * <li>increment size</li>
	 * </ul>
	 * @param item the item to add to the array
	 */
	public static  byte[] add(byte[] data, int size, byte item) {
		// If the array is to small, expand it
		if(size + 1 > data.length) {
			data = expand(data);
		}
		// Add the new item
		data[size] = item;
		return data;
	}


	/** Designed for use by code that manages arrays by hand.
	 * Note: expands array ~1.5x it's current size
	 */
	public static final byte[] expand(byte[] oldAry) {
		// Expand array size 1.5x + 4, +4 instead of +1 to prevent small arrays from constantly needed to resize
		byte[] newAry = new byte[oldAry.length + (oldAry.length >>> 1) + 4];
		System.arraycopy(oldAry, 0, newAry, 0, oldAry.length);
		return newAry;
	}


	/** Designed for use by code that manages arrays by hand
	 * Note: expands array ~1.5x it's current size, up to a maximum of {@code maxSize}
	 */
	public static final byte[] expand(byte[] oldAry, int maxSize) {
		// Expand array size 1.5x + 4, +4 instead of +1 to prevent small arrays from constantly needed to resize
		int newSize = Math.max(maxSize, oldAry.length + (oldAry.length >>> 1) + 4);
		byte[] newAry = new byte[newSize];
		System.arraycopy(oldAry, 0, newAry, 0, oldAry.length);
		return newAry;
	}


	// ==== short array manager functions ====

	/** Remove the element at the specified index from the array<br>
	 * Collection Reminder:
	 * <ul>
	 * <li>increment action count</li>
	 * <li>decrement size</li>
	 * </ul>
	 * @param index the index between {@code [0, size - 1]} to remove
	 * @return the element found at the specified index
	 */
	public static  short removeUnordered(short[] data, int size, int index) {
		//if(index >= size) {
		//	throw new ArrayIndexOutOfBoundsException(index + " of [0, " + size + "]");
		//}
		// Get the item to remove
		short item = data[index];
		// Replace the item to remove with the last element from our array
		data[index] = data[size - 1];
		// Set the last element to null
		data[size - 1] = (short)0;
		return item;
	}


	/** Remove the char at the specified index<br>
	 * Collection Reminder:
	 * <ul>
	 * </ul>
	 * @param index the index between {@code [0, size - 1]} to remove
	 * @return the char found at the specified index
	 * @throws ArrayIndexOutOfBoundsException if the index is outside the range {@code [0, size - 1]}
	 */
	public static  short removeIndex(short[] data, int size, int index) {
		//if(index < 0 || index >= size) {
		//	throw new ArrayIndexOutOfBoundsException(index + " of [0, " + size + ")");
		//}
		// Shift all elements above the remove element to fill the empty index
		// Get the item to remove
		short item = data[index];

		removeRange(data, size, index, 1);

		return item;
	}


	/** Remove the element at the specified index from the array<br>
	 * Collection Reminder:
	 * <ul>
	 * <li>increment action count</li>
	 * <li>size minus len</li>
	 * </ul>
	 */
	public static  void removeRange(short[] data, int size, int off, int len) {
		//if(off < 0 || off + len > size) {
		//	throw new ArrayIndexOutOfBoundsException((off < 0 ? off : off + len) + " of [0, " + size + ")");
		//}
		// Shift all elements above the remove element to fill the empty index
		// Copy down the remaining upper half of the array if the item removed was not the last item in the array
		if(off + len < size) {
			System.arraycopy(data, off + len, data, off, size - (off + len));
		}
	}


	/** Remove the specified object from the array<br>
	 * Collection Reminder:
	 * <ul>
	 * </ul>
	 * @param item the object to remove based on item.equals(get(i)) if item
	 * is not null, or get(i)==null if item is null, where i is [0, size()-1]
	 * @return true if the element was removed successfully, false otherwise
	 */
	public static  boolean removeValue(short[] data, int size, short item) {
		// Search for the item to remove
		for(int i = 0; i < size; i++) {
			// If the item is found, remove it
			if(item == data[i]) {
				removeIndex(data, size, i);
				return true;
			}
		}
		return false;
	}


	/** Add the specified item to the array<br>
	 * Collection Reminder:
	 * <ul>
	 * <li>increment action count</li>
	 * <li>increment size</li>
	 * </ul>
	 * @param item the item to add to the array
	 */
	public static  short[] add(short[] data, int size, short item) {
		// If the array is to small, expand it
		if(size + 1 > data.length) {
			data = expand(data);
		}
		// Add the new item
		data[size] = item;
		return data;
	}


	/** Designed for use by code that manages arrays by hand.
	 * Note: expands array ~1.5x it's current size
	 */
	public static final short[] expand(short[] oldAry) {
		// Expand array size 1.5x + 4, +4 instead of +1 to prevent small arrays from constantly needed to resize
		short[] newAry = new short[oldAry.length + (oldAry.length >>> 1) + 4];
		System.arraycopy(oldAry, 0, newAry, 0, oldAry.length);
		return newAry;
	}


	/** Designed for use by code that manages arrays by hand
	 * Note: expands array ~1.5x it's current size, up to a maximum of {@code maxSize}
	 */
	public static final short[] expand(short[] oldAry, int maxSize) {
		// Expand array size 1.5x + 4, +4 instead of +1 to prevent small arrays from constantly needed to resize
		int newSize = Math.max(maxSize, oldAry.length + (oldAry.length >>> 1) + 4);
		short[] newAry = new short[newSize];
		System.arraycopy(oldAry, 0, newAry, 0, oldAry.length);
		return newAry;
	}


	// ==== char array manager functions ====

	/** Remove the element at the specified index from the array<br>
	 * Collection Reminder:
	 * <ul>
	 * <li>increment action count</li>
	 * <li>decrement size</li>
	 * </ul>
	 * @param index the index between {@code [0, size - 1]} to remove
	 * @return the element found at the specified index
	 */
	public static  char removeUnordered(char[] data, int size, int index) {
		//if(index >= size) {
		//	throw new ArrayIndexOutOfBoundsException(index + " of [0, " + size + "]");
		//}
		// Get the item to remove
		char item = data[index];
		// Replace the item to remove with the last element from our array
		data[index] = data[size - 1];
		// Set the last element to null
		data[size - 1] = (char)0;
		return item;
	}


	/** Remove the char at the specified index<br>
	 * Collection Reminder:
	 * <ul>
	 * </ul>
	 * @param index the index between {@code [0, size - 1]} to remove
	 * @return the char found at the specified index
	 * @throws ArrayIndexOutOfBoundsException if the index is outside the range {@code [0, size - 1]}
	 */
	public static  char removeIndex(char[] data, int size, int index) {
		//if(index < 0 || index >= size) {
		//	throw new ArrayIndexOutOfBoundsException(index + " of [0, " + size + ")");
		//}
		// Shift all elements above the remove element to fill the empty index
		// Get the item to remove
		char item = data[index];

		removeRange(data, size, index, 1);

		return item;
	}


	/** Remove the element at the specified index from the array<br>
	 * Collection Reminder:
	 * <ul>
	 * <li>increment action count</li>
	 * <li>size minus len</li>
	 * </ul>
	 */
	public static  void removeRange(char[] data, int size, int off, int len) {
		//if(off < 0 || off + len > size) {
		//	throw new ArrayIndexOutOfBoundsException((off < 0 ? off : off + len) + " of [0, " + size + ")");
		//}
		// Shift all elements above the remove element to fill the empty index
		// Copy down the remaining upper half of the array if the item removed was not the last item in the array
		if(off + len < size) {
			System.arraycopy(data, off + len, data, off, size - (off + len));
		}
	}


	/** Remove the specified object from the array<br>
	 * Collection Reminder:
	 * <ul>
	 * </ul>
	 * @param item the object to remove based on item.equals(get(i)) if item
	 * is not null, or get(i)==null if item is null, where i is [0, size()-1]
	 * @return true if the element was removed successfully, false otherwise
	 */
	public static  boolean removeValue(char[] data, int size, char item) {
		// Search for the item to remove
		for(int i = 0; i < size; i++) {
			// If the item is found, remove it
			if(item == data[i]) {
				removeIndex(data, size, i);
				return true;
			}
		}
		return false;
	}


	/** Add the specified item to the array<br>
	 * Collection Reminder:
	 * <ul>
	 * <li>increment action count</li>
	 * <li>increment size</li>
	 * </ul>
	 * @param item the item to add to the array
	 */
	public static  char[] add(char[] data, int size, char item) {
		// If the array is to small, expand it
		if(size + 1 > data.length) {
			data = expand(data);
		}
		// Add the new item
		data[size] = item;
		return data;
	}


	/** Designed for use by code that manages arrays by hand.
	 * Note: expands array ~1.5x it's current size
	 */
	public static final char[] expand(char[] oldAry) {
		// Expand array size 1.5x + 4, +4 instead of +1 to prevent small arrays from constantly needed to resize
		char[] newAry = new char[oldAry.length + (oldAry.length >>> 1) + 4];
		System.arraycopy(oldAry, 0, newAry, 0, oldAry.length);
		return newAry;
	}


	/** Designed for use by code that manages arrays by hand
	 * Note: expands array ~1.5x it's current size, up to a maximum of {@code maxSize}
	 */
	public static final char[] expand(char[] oldAry, int maxSize) {
		// Expand array size 1.5x + 4, +4 instead of +1 to prevent small arrays from constantly needed to resize
		int newSize = Math.max(maxSize, oldAry.length + (oldAry.length >>> 1) + 4);
		char[] newAry = new char[newSize];
		System.arraycopy(oldAry, 0, newAry, 0, oldAry.length);
		return newAry;
	}


	// ==== int array manager functions ====

	/** Remove the element at the specified index from the array<br>
	 * Collection Reminder:
	 * <ul>
	 * <li>increment action count</li>
	 * <li>decrement size</li>
	 * </ul>
	 * @param index the index between {@code [0, size - 1]} to remove
	 * @return the element found at the specified index
	 */
	public static  int removeUnordered(int[] data, int size, int index) {
		//if(index >= size) {
		//	throw new ArrayIndexOutOfBoundsException(index + " of [0, " + size + "]");
		//}
		// Get the item to remove
		int item = data[index];
		// Replace the item to remove with the last element from our array
		data[index] = data[size - 1];
		// Set the last element to null
		data[size - 1] = 0;
		return item;
	}


	/** Remove the char at the specified index<br>
	 * Collection Reminder:
	 * <ul>
	 * </ul>
	 * @param index the index between {@code [0, size - 1]} to remove
	 * @return the char found at the specified index
	 * @throws ArrayIndexOutOfBoundsException if the index is outside the range {@code [0, size - 1]}
	 */
	public static  int removeIndex(int[] data, int size, int index) {
		//if(index < 0 || index >= size) {
		//	throw new ArrayIndexOutOfBoundsException(index + " of [0, " + size + ")");
		//}
		// Shift all elements above the remove element to fill the empty index
		// Get the item to remove
		int item = data[index];

		removeRange(data, size, index, 1);

		return item;
	}


	/** Remove the element at the specified index from the array<br>
	 * Collection Reminder:
	 * <ul>
	 * <li>increment action count</li>
	 * <li>size minus len</li>
	 * </ul>
	 */
	public static  void removeRange(int[] data, int size, int off, int len) {
		//if(off < 0 || off + len > size) {
		//	throw new ArrayIndexOutOfBoundsException((off < 0 ? off : off + len) + " of [0, " + size + ")");
		//}
		// Shift all elements above the remove element to fill the empty index
		// Copy down the remaining upper half of the array if the item removed was not the last item in the array
		if(off + len < size) {
			System.arraycopy(data, off + len, data, off, size - (off + len));
		}
	}


	/** Remove the specified object from the array<br>
	 * Collection Reminder:
	 * <ul>
	 * </ul>
	 * @param item the object to remove based on item.equals(get(i)) if item
	 * is not null, or get(i)==null if item is null, where i is [0, size()-1]
	 * @return true if the element was removed successfully, false otherwise
	 */
	public static  boolean removeValue(int[] data, int size, int item) {
		// Search for the item to remove
		for(int i = 0; i < size; i++) {
			// If the item is found, remove it
			if(item == data[i]) {
				removeIndex(data, size, i);
				return true;
			}
		}
		return false;
	}


	/** Add the specified item to the array<br>
	 * Collection Reminder:
	 * <ul>
	 * <li>increment action count</li>
	 * <li>increment size</li>
	 * </ul>
	 * @param item the item to add to the array
	 */
	public static  int[] add(int[] data, int size, int item) {
		// If the array is to small, expand it
		if(size + 1 > data.length) {
			data = expand(data);
		}
		// Add the new item
		data[size] = item;
		return data;
	}


	/** Designed for use by code that manages arrays by hand.
	 * Note: expands array ~1.5x it's current size
	 */
	public static final int[] expand(int[] oldAry) {
		// Expand array size 1.5x + 4, +4 instead of +1 to prevent small arrays from constantly needed to resize
		int[] newAry = new int[oldAry.length + (oldAry.length >>> 1) + 4];
		System.arraycopy(oldAry, 0, newAry, 0, oldAry.length);
		return newAry;
	}


	/** Designed for use by code that manages arrays by hand
	 * Note: expands array ~1.5x it's current size, up to a maximum of {@code maxSize}
	 */
	public static final int[] expand(int[] oldAry, int maxSize) {
		// Expand array size 1.5x + 4, +4 instead of +1 to prevent small arrays from constantly needed to resize
		int newSize = Math.max(maxSize, oldAry.length + (oldAry.length >>> 1) + 4);
		int[] newAry = new int[newSize];
		System.arraycopy(oldAry, 0, newAry, 0, oldAry.length);
		return newAry;
	}


	// ==== long array manager functions ====

	/** Remove the element at the specified index from the array<br>
	 * Collection Reminder:
	 * <ul>
	 * <li>increment action count</li>
	 * <li>decrement size</li>
	 * </ul>
	 * @param index the index between {@code [0, size - 1]} to remove
	 * @return the element found at the specified index
	 */
	public static  long removeUnordered(long[] data, int size, int index) {
		//if(index >= size) {
		//	throw new ArrayIndexOutOfBoundsException(index + " of [0, " + size + "]");
		//}
		// Get the item to remove
		long item = data[index];
		// Replace the item to remove with the last element from our array
		data[index] = data[size - 1];
		// Set the last element to null
		data[size - 1] = 0L;
		return item;
	}


	/** Remove the char at the specified index<br>
	 * Collection Reminder:
	 * <ul>
	 * </ul>
	 * @param index the index between {@code [0, size - 1]} to remove
	 * @return the char found at the specified index
	 * @throws ArrayIndexOutOfBoundsException if the index is outside the range {@code [0, size - 1]}
	 */
	public static  long removeIndex(long[] data, int size, int index) {
		//if(index < 0 || index >= size) {
		//	throw new ArrayIndexOutOfBoundsException(index + " of [0, " + size + ")");
		//}
		// Shift all elements above the remove element to fill the empty index
		// Get the item to remove
		long item = data[index];

		removeRange(data, size, index, 1);

		return item;
	}


	/** Remove the element at the specified index from the array<br>
	 * Collection Reminder:
	 * <ul>
	 * <li>increment action count</li>
	 * <li>size minus len</li>
	 * </ul>
	 */
	public static  void removeRange(long[] data, int size, int off, int len) {
		//if(off < 0 || off + len > size) {
		//	throw new ArrayIndexOutOfBoundsException((off < 0 ? off : off + len) + " of [0, " + size + ")");
		//}
		// Shift all elements above the remove element to fill the empty index
		// Copy down the remaining upper half of the array if the item removed was not the last item in the array
		if(off + len < size) {
			System.arraycopy(data, off + len, data, off, size - (off + len));
		}
	}


	/** Remove the specified object from the array<br>
	 * Collection Reminder:
	 * <ul>
	 * </ul>
	 * @param item the object to remove based on item.equals(get(i)) if item
	 * is not null, or get(i)==null if item is null, where i is [0, size()-1]
	 * @return true if the element was removed successfully, false otherwise
	 */
	public static  boolean removeValue(long[] data, int size, long item) {
		// Search for the item to remove
		for(int i = 0; i < size; i++) {
			// If the item is found, remove it
			if(item == data[i]) {
				removeIndex(data, size, i);
				return true;
			}
		}
		return false;
	}


	/** Add the specified item to the array<br>
	 * Collection Reminder:
	 * <ul>
	 * <li>increment action count</li>
	 * <li>increment size</li>
	 * </ul>
	 * @param item the item to add to the array
	 */
	public static  long[] add(long[] data, int size, long item) {
		// If the array is to small, expand it
		if(size + 1 > data.length) {
			data = expand(data);
		}
		// Add the new item
		data[size] = item;
		return data;
	}


	/** Designed for use by code that manages arrays by hand.
	 * Note: expands array ~1.5x it's current size
	 */
	public static final long[] expand(long[] oldAry) {
		// Expand array size 1.5x + 4, +4 instead of +1 to prevent small arrays from constantly needed to resize
		long[] newAry = new long[oldAry.length + (oldAry.length >>> 1) + 4];
		System.arraycopy(oldAry, 0, newAry, 0, oldAry.length);
		return newAry;
	}


	/** Designed for use by code that manages arrays by hand
	 * Note: expands array ~1.5x it's current size, up to a maximum of {@code maxSize}
	 */
	public static final long[] expand(long[] oldAry, int maxSize) {
		// Expand array size 1.5x + 4, +4 instead of +1 to prevent small arrays from constantly needed to resize
		int newSize = Math.max(maxSize, oldAry.length + (oldAry.length >>> 1) + 4);
		long[] newAry = new long[newSize];
		System.arraycopy(oldAry, 0, newAry, 0, oldAry.length);
		return newAry;
	}


	// ==== float array manager functions ====

	/** Remove the element at the specified index from the array<br>
	 * Collection Reminder:
	 * <ul>
	 * <li>increment action count</li>
	 * <li>decrement size</li>
	 * </ul>
	 * @param index the index between {@code [0, size - 1]} to remove
	 * @return the element found at the specified index
	 */
	public static  float removeUnordered(float[] data, int size, int index) {
		//if(index >= size) {
		//	throw new ArrayIndexOutOfBoundsException(index + " of [0, " + size + "]");
		//}
		// Get the item to remove
		float item = data[index];
		// Replace the item to remove with the last element from our array
		data[index] = data[size - 1];
		// Set the last element to null
		data[size - 1] = 0f;
		return item;
	}


	/** Remove the char at the specified index<br>
	 * Collection Reminder:
	 * <ul>
	 * </ul>
	 * @param index the index between {@code [0, size - 1]} to remove
	 * @return the char found at the specified index
	 * @throws ArrayIndexOutOfBoundsException if the index is outside the range {@code [0, size - 1]}
	 */
	public static  float removeIndex(float[] data, int size, int index) {
		//if(index < 0 || index >= size) {
		//	throw new ArrayIndexOutOfBoundsException(index + " of [0, " + size + ")");
		//}
		// Shift all elements above the remove element to fill the empty index
		// Get the item to remove
		float item = data[index];

		removeRange(data, size, index, 1);

		return item;
	}


	/** Remove the element at the specified index from the array<br>
	 * Collection Reminder:
	 * <ul>
	 * <li>increment action count</li>
	 * <li>size minus len</li>
	 * </ul>
	 */
	public static  void removeRange(float[] data, int size, int off, int len) {
		//if(off < 0 || off + len > size) {
		//	throw new ArrayIndexOutOfBoundsException((off < 0 ? off : off + len) + " of [0, " + size + ")");
		//}
		// Shift all elements above the remove element to fill the empty index
		// Copy down the remaining upper half of the array if the item removed was not the last item in the array
		if(off + len < size) {
			System.arraycopy(data, off + len, data, off, size - (off + len));
		}
	}


	/** Remove the specified object from the array<br>
	 * Collection Reminder:
	 * <ul>
	 * </ul>
	 * @param item the object to remove based on item.equals(get(i)) if item
	 * is not null, or get(i)==null if item is null, where i is [0, size()-1]
	 * @return true if the element was removed successfully, false otherwise
	 */
	public static  boolean removeValue(float[] data, int size, float item) {
		// Search for the item to remove
		for(int i = 0; i < size; i++) {
			// If the item is found, remove it
			if(item == data[i]) {
				removeIndex(data, size, i);
				return true;
			}
		}
		return false;
	}


	/** Add the specified item to the array<br>
	 * Collection Reminder:
	 * <ul>
	 * <li>increment action count</li>
	 * <li>increment size</li>
	 * </ul>
	 * @param item the item to add to the array
	 */
	public static  float[] add(float[] data, int size, float item) {
		// If the array is to small, expand it
		if(size + 1 > data.length) {
			data = expand(data);
		}
		// Add the new item
		data[size] = item;
		return data;
	}


	/** Designed for use by code that manages arrays by hand.
	 * Note: expands array ~1.5x it's current size
	 */
	public static final float[] expand(float[] oldAry) {
		// Expand array size 1.5x + 4, +4 instead of +1 to prevent small arrays from constantly needed to resize
		float[] newAry = new float[oldAry.length + (oldAry.length >>> 1) + 4];
		System.arraycopy(oldAry, 0, newAry, 0, oldAry.length);
		return newAry;
	}


	/** Designed for use by code that manages arrays by hand
	 * Note: expands array ~1.5x it's current size, up to a maximum of {@code maxSize}
	 */
	public static final float[] expand(float[] oldAry, int maxSize) {
		// Expand array size 1.5x + 4, +4 instead of +1 to prevent small arrays from constantly needed to resize
		int newSize = Math.max(maxSize, oldAry.length + (oldAry.length >>> 1) + 4);
		float[] newAry = new float[newSize];
		System.arraycopy(oldAry, 0, newAry, 0, oldAry.length);
		return newAry;
	}


	// ==== double array manager functions ====

	/** Remove the element at the specified index from the array<br>
	 * Collection Reminder:
	 * <ul>
	 * <li>increment action count</li>
	 * <li>decrement size</li>
	 * </ul>
	 * @param index the index between {@code [0, size - 1]} to remove
	 * @return the element found at the specified index
	 */
	public static  double removeUnordered(double[] data, int size, int index) {
		//if(index >= size) {
		//	throw new ArrayIndexOutOfBoundsException(index + " of [0, " + size + "]");
		//}
		// Get the item to remove
		double item = data[index];
		// Replace the item to remove with the last element from our array
		data[index] = data[size - 1];
		// Set the last element to null
		data[size - 1] = 0;
		return item;
	}


	/** Remove the char at the specified index<br>
	 * Collection Reminder:
	 * <ul>
	 * </ul>
	 * @param index the index between {@code [0, size - 1]} to remove
	 * @return the char found at the specified index
	 * @throws ArrayIndexOutOfBoundsException if the index is outside the range {@code [0, size - 1]}
	 */
	public static  double removeIndex(double[] data, int size, int index) {
		//if(index < 0 || index >= size) {
		//	throw new ArrayIndexOutOfBoundsException(index + " of [0, " + size + ")");
		//}
		// Shift all elements above the remove element to fill the empty index
		// Get the item to remove
		double item = data[index];

		removeRange(data, size, index, 1);

		return item;
	}


	/** Remove the element at the specified index from the array<br>
	 * Collection Reminder:
	 * <ul>
	 * <li>increment action count</li>
	 * <li>size minus len</li>
	 * </ul>
	 */
	public static  void removeRange(double[] data, int size, int off, int len) {
		//if(off < 0 || off + len > size) {
		//	throw new ArrayIndexOutOfBoundsException((off < 0 ? off : off + len) + " of [0, " + size + ")");
		//}
		// Shift all elements above the remove element to fill the empty index
		// Copy down the remaining upper half of the array if the item removed was not the last item in the array
		if(off + len < size) {
			System.arraycopy(data, off + len, data, off, size - (off + len));
		}
	}


	/** Remove the specified object from the array<br>
	 * Collection Reminder:
	 * <ul>
	 * </ul>
	 * @param item the object to remove based on item.equals(get(i)) if item
	 * is not null, or get(i)==null if item is null, where i is [0, size()-1]
	 * @return true if the element was removed successfully, false otherwise
	 */
	public static  boolean removeValue(double[] data, int size, double item) {
		// Search for the item to remove
		for(int i = 0; i < size; i++) {
			// If the item is found, remove it
			if(item == data[i]) {
				removeIndex(data, size, i);
				return true;
			}
		}
		return false;
	}


	/** Add the specified item to the array<br>
	 * Collection Reminder:
	 * <ul>
	 * <li>increment action count</li>
	 * <li>increment size</li>
	 * </ul>
	 * @param item the item to add to the array
	 */
	public static  double[] add(double[] data, int size, double item) {
		// If the array is to small, expand it
		if(size + 1 > data.length) {
			data = expand(data);
		}
		// Add the new item
		data[size] = item;
		return data;
	}


	/** Designed for use by code that manages arrays by hand.
	 * Note: expands array ~1.5x it's current size
	 */
	public static final double[] expand(double[] oldAry) {
		// Expand array size 1.5x + 4, +4 instead of +1 to prevent small arrays from constantly needed to resize
		double[] newAry = new double[oldAry.length + (oldAry.length >>> 1) + 4];
		System.arraycopy(oldAry, 0, newAry, 0, oldAry.length);
		return newAry;
	}


	/** Designed for use by code that manages arrays by hand
	 * Note: expands array ~1.5x it's current size, up to a maximum of {@code maxSize}
	 */
	public static final double[] expand(double[] oldAry, int maxSize) {
		// Expand array size 1.5x + 4, +4 instead of +1 to prevent small arrays from constantly needed to resize
		int newSize = Math.max(maxSize, oldAry.length + (oldAry.length >>> 1) + 4);
		double[] newAry = new double[newSize];
		System.arraycopy(oldAry, 0, newAry, 0, oldAry.length);
		return newAry;
	}


	// ==== Object array manager functions ====

	/** Remove the element at the specified index from the array<br>
	 * Collection Reminder:
	 * <ul>
	 * <li>increment action count</li>
	 * <li>decrement size</li>
	 * </ul>
	 * @param index the index between {@code [0, size - 1]} to remove
	 * @return the element found at the specified index
	 */
	public static <T> T removeUnordered(T[] data, int size, int index) {
		//if(index >= size) {
		//	throw new ArrayIndexOutOfBoundsException(index + " of [0, " + size + "]");
		//}
		// Get the item to remove
		T item = data[index];
		// Replace the item to remove with the last element from our array
		data[index] = data[size - 1];
		// Set the last element to null
		data[size - 1] = null;
		return item;
	}


	/** Remove the char at the specified index<br>
	 * Collection Reminder:
	 * <ul>
	 * </ul>
	 * @param index the index between {@code [0, size - 1]} to remove
	 * @return the char found at the specified index
	 * @throws ArrayIndexOutOfBoundsException if the index is outside the range {@code [0, size - 1]}
	 */
	public static <T> T removeIndex(T[] data, int size, int index) {
		//if(index < 0 || index >= size) {
		//	throw new ArrayIndexOutOfBoundsException(index + " of [0, " + size + ")");
		//}
		// Shift all elements above the remove element to fill the empty index
		// Get the item to remove
		T item = data[index];

		removeRange(data, size, index, 1);

		return item;
	}


	/** Remove the element at the specified index from the array<br>
	 * Collection Reminder:
	 * <ul>
	 * <li>increment action count</li>
	 * <li>size minus len</li>
	 * </ul>
	 */
	public static <T> void removeRange(T[] data, int size, int off, int len) {
		//if(off < 0 || off + len > size) {
		//	throw new ArrayIndexOutOfBoundsException((off < 0 ? off : off + len) + " of [0, " + size + ")");
		//}
		// Shift all elements above the remove element to fill the empty index
		// Copy down the remaining upper half of the array if the item removed was not the last item in the array
		if(off + len < size) {
			System.arraycopy(data, off + len, data, off, size - (off + len));
		}
	}


	/** Remove the specified object from the array<br>
	 * Collection Reminder:
	 * <ul>
	 * </ul>
	 * @param item the object to remove based on item.equals(get(i)) if item
	 * is not null, or get(i)==null if item is null, where i is [0, size()-1]
	 * @return true if the element was removed successfully, false otherwise
	 */
	public static <T> boolean removeValue(T[] data, int size, T item) {
		// Search for the item to remove
		if(item != null) {
			for(int i = 0; i < size; i++) {
				// If the item is found, remove it
				if(item.equals(data[i])) {
					removeIndex(data, size, i);
					return true;
				}
			}
		}
		// Else if the item is null, search for a null item in our list
		else {
			for(int i = 0; i < size; i++) {
				// If the item is found, remove it
				if(data[i] == null) {
					removeIndex(data, size, i);
					return true;
				}
			}
		}
		return false;
	}


	/** Add the specified item to the array<br>
	 * Collection Reminder:
	 * <ul>
	 * <li>increment action count</li>
	 * <li>increment size</li>
	 * </ul>
	 * @param item the item to add to the array
	 */
	public static <T> T[] add(T[] data, int size, T item) {
		// If the array is to small, expand it
		if(size + 1 > data.length) {
			data = expand(data);
		}
		// Add the new item
		data[size] = item;
		return data;
	}


	/** Designed for use by code that manages arrays by hand.
	 * Note: expands array ~1.5x it's current size
	 */
	@SuppressWarnings("unchecked")
	public static final <T> T[] expand(T[] oldAry) {
		// Expand array size 1.5x + 4, +4 instead of +1 to prevent small arrays from constantly needed to resize
		Object[] newAry = new Object[oldAry.length + (oldAry.length >>> 1) + 4];
		System.arraycopy(oldAry, 0, newAry, 0, oldAry.length);
		return (T[])newAry;
	}


	/** Designed for use by code that manages arrays by hand
	 * Note: expands array ~1.5x it's current size, up to a maximum of {@code maxSize}
	 */
	@SuppressWarnings("unchecked")
	public static final <T> T[] expand(T[] oldAry, int maxSize) {
		// Expand array size 1.5x + 4, +4 instead of +1 to prevent small arrays from constantly needed to resize
		int newSize = Math.max(maxSize, oldAry.length + (oldAry.length >>> 1) + 4);
		Object[] newAry = new Object[newSize];
		System.arraycopy(oldAry, 0, newAry, 0, oldAry.length);
		return (T[])newAry;
	}

}