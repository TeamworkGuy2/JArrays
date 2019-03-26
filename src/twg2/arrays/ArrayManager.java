package twg2.arrays;

/**
 * @author TeamworkGuy2
 * @since 2015-9-10
 */
@javax.annotation.Generated("StringTemplate")
public final class ArrayManager {


	public static final class BooleanAry {
		public int size;
		public boolean[] data;
	}


	public static final class ByteAry {
		public int size;
		public byte[] data;
	}


	public static final class ShortAry {
		public int size;
		public short[] data;
	}


	public static final class CharAry {
		public int size;
		public char[] data;
	}


	public static final class IntAry {
		public int size;
		public int[] data;
	}


	public static final class LongAry {
		public int size;
		public long[] data;
	}


	public static final class FloatAry {
		public int size;
		public float[] data;
	}


	public static final class DoubleAry {
		public int size;
		public double[] data;
	}


	public static final class ObjectAry<T> {
		public int size;
		public T[] data;
	}




	// ==== boolean array manager functions ====

	/** Remove the {@code boolean} element at the specified index from the array and replace it with the last element from the array.
	 * This unordered/fast remove requires few operations versus a {@link #removeIndex(boolean[], int, int)} operation which shifts all subsequent elements down when an array element is removed.
	 * Collection Maintenance Reminders:
	 * <ul>
	 * <li>decrement size</li>
	 * <li>increment action count</li>
	 * </ul>
	 * @param ary the array of items to remove from
	 * @param size the current number of elements in {@code ary} containing data
	 * @param index the index between {@code [0, size - 1]} to remove
	 * @return the element found at the specified index
	 */
	public static final boolean removeUnordered(boolean[] ary, int size, int index) {
		//if(index >= size) {
		//	throw new ArrayIndexOutOfBoundsException(index + " of [0, " + size + "]");
		//}
		// Get the item to remove
		boolean item = ary[index];
		// Replace the item to remove with the last element from the array
		ary[index] = ary[size - 1];
		// Set the last element to null
		ary[size - 1] = false;
		return item;
	}


	/** Remove the {@code boolean} element at the specified index.<br>
	 * Collection Maintenance Reminders:
	 * <ul>
	 * <li>decrement size</li>
	 * <li>increment action count</li>
	 * </ul>
	 * @param index the index between {@code [0, size - 1]} to remove
	 * @return the char found at the specified index
	 * @throws ArrayIndexOutOfBoundsException if the index is outside the range {@code [0, size - 1]}
	 */
	public static final boolean removeIndex(boolean[] data, int size, int index) {
		//if(index < 0 || index >= size) {
		//	throw new ArrayIndexOutOfBoundsException(index + " of [0, " + size + ")");
		//}
		// Shift all elements above the remove element to fill the empty index
		// Get the item to remove
		boolean item = data[index];

		removeRange(data, size, index, 1);

		return item;
	}


	/** Remove a range of {@code boolean} elements from the array.<br>
	 * Collection Maintenance Reminders:
	 * <ul>
	 * <li>size minus len</li>
	 * <li>increment action count</li>
	 * </ul>
	 */
	public static final void removeRange(boolean[] data, int size, int off, int len) {
		//if(off < 0 || off + len > size) {
		//	throw new ArrayIndexOutOfBoundsException((off < 0 ? off : off + len) + " of [0, " + size + ")");
		//}
		// Shift all elements above the remove element to fill the empty index
		// Copy down the remaining upper half of the array if the item removed was not the last item in the array
		if(off + len < size) {
			System.arraycopy(data, off + len, data, off, size - (off + len));
		}
	}


	/** Remove the first matching {@code boolean} value from the array<br>
	 * Collection Maintenance Reminders:
	 * <ul>
	 * <li>decrement size</li>
	 * <li>increment action count</li>
	 * </ul>
	 * @param item the object to remove based on item.equals(get(i)) if item
	 * is not null, or get(i)==null if item is null, where i is [0, size()-1]
	 * @return true if the element was removed successfully, false otherwise
	 */
	public static final boolean removeValue(boolean[] data, int size, boolean item) {
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


	/** Add the specified item to the array.<br>
	 * Collection Maintenance Reminders:
	 * <ul>
	 * <li>increment size</li>
	 * <li>increment action count</li>
	 * </ul>
	 * @param ary the array of items to add to
	 * @param size the current number of elements in {@code ary} containing data (expand array when {@code size} reaches {@code ary.length}), start inserting at index {@code ary[size]}
	 * @param item the item to add to the array
	 */
	public static final boolean[] add(boolean[] ary, int size, boolean item) {
		// If the array is to small, expand it
		if(size + 1 > ary.length) {
			ary = expand(ary);
		}
		// Add the new item
		ary[size] = item;
		return ary;
	}


	/** Add the specified sub-array of items to the array.<br>
	 * Collection Maintenance Reminders:
	 * <ul>
	 * <li>increase size</li>
	 * <li>increment action count</li>
	 * </ul>
	 * @param ary the array of items to add to
	 * @param size the current number of elements in {@code ary} containing data (expand array when {@code size} reaches {@code ary.length}), start inserting at index {@code ary[size]}
	 * @param toAdd the items to add to the array
	 * @param off the index offset into {@code toAdd}
	 * @param len the number of items to add from {@code toAdd}
	 * @return the input {@code ary} or a new array if the input array required expanding to fit the new elements
	 */
	public static final boolean[] addAll(boolean[] ary, int size, boolean[] toAdd, int off, int len) {
		if(toAdd == null) {
			return ary;
		}

		// If the array is to small, expand it
		if(size + len > ary.length) {
			ary = expand(ary, size + len);
		}
		System.arraycopy(toAdd, off, ary, size, len);
		//size += len;

		return ary;
	}


	/** Clear the array (fill with {@code false}) and add the specified elements
	 * Collection Maintenance Reminders:
	 * <ul>
	 * <li>set size</li>
	 * <li>increment action count</li>
	 * </ul>
	 * @param ary the array of items to add to
	 * @param toAdd the items to add to the array
	 * @param off the index offset into {@code toAdd}
	 * @param len the number of items to add from {@code toAdd}
	 * @return the input {@code ary} or a new array if the input array required expanding to fit the new elements
	 */
	public static final boolean[] clearAndAddAll(boolean[] ary, boolean[] toAdd, int off, int len) {
		int sz = ary.length;
		if(toAdd == null) {
			// clear the array
			for(int i = 0; i < sz; i++) {
				ary[i] = false;
			}
			return ary;
		}

		// Clear elements past the last index that will be occupied by the new group of items
		for(int i = len; i < sz; i++) {
			ary[i] = false;
		}

		return addAll(ary, 0, toAdd, off, len);
	}


	/** Designed for use by code that manages arrays by hand.
	 * Note: expands array ~1.5x + 4 it's current size
	 */
	public static final boolean[] expand(boolean[] oldAry) {
		// Expand array size 1.5x + 4, +4 to prevent small arrays from constantly needing to resize
		boolean[] newAry = new boolean[oldAry.length + (oldAry.length >>> 1) + 4];
		System.arraycopy(oldAry, 0, newAry, 0, oldAry.length);
		return newAry;
	}


	/** Designed for use by code that manages arrays by hand
	 * Note: expands array ~1.5x + 4 it's current size, up to a maximum of {@code maxSize}
	 */
	public static final boolean[] expand(boolean[] oldAry, int maxSize) {
		// Expand array size 1.5x + 4, +4 to prevent small arrays from constantly needing to resize
		int newSize = Math.max(maxSize, oldAry.length + (oldAry.length >>> 1) + 4);
		boolean[] newAry = new boolean[newSize];
		System.arraycopy(oldAry, 0, newAry, 0, oldAry.length);
		return newAry;
	}


	// ==== byte array manager functions ====

	/** Remove the {@code byte} element at the specified index from the array and replace it with the last element from the array.
	 * This unordered/fast remove requires few operations versus a {@link #removeIndex(byte[], int, int)} operation which shifts all subsequent elements down when an array element is removed.
	 * Collection Maintenance Reminders:
	 * <ul>
	 * <li>decrement size</li>
	 * <li>increment action count</li>
	 * </ul>
	 * @param ary the array of items to remove from
	 * @param size the current number of elements in {@code ary} containing data
	 * @param index the index between {@code [0, size - 1]} to remove
	 * @return the element found at the specified index
	 */
	public static final byte removeUnordered(byte[] ary, int size, int index) {
		//if(index >= size) {
		//	throw new ArrayIndexOutOfBoundsException(index + " of [0, " + size + "]");
		//}
		// Get the item to remove
		byte item = ary[index];
		// Replace the item to remove with the last element from the array
		ary[index] = ary[size - 1];
		// Set the last element to null
		ary[size - 1] = (byte)0;
		return item;
	}


	/** Remove the {@code byte} element at the specified index.<br>
	 * Collection Maintenance Reminders:
	 * <ul>
	 * <li>decrement size</li>
	 * <li>increment action count</li>
	 * </ul>
	 * @param index the index between {@code [0, size - 1]} to remove
	 * @return the char found at the specified index
	 * @throws ArrayIndexOutOfBoundsException if the index is outside the range {@code [0, size - 1]}
	 */
	public static final byte removeIndex(byte[] data, int size, int index) {
		//if(index < 0 || index >= size) {
		//	throw new ArrayIndexOutOfBoundsException(index + " of [0, " + size + ")");
		//}
		// Shift all elements above the remove element to fill the empty index
		// Get the item to remove
		byte item = data[index];

		removeRange(data, size, index, 1);

		return item;
	}


	/** Remove a range of {@code byte} elements from the array.<br>
	 * Collection Maintenance Reminders:
	 * <ul>
	 * <li>size minus len</li>
	 * <li>increment action count</li>
	 * </ul>
	 */
	public static final void removeRange(byte[] data, int size, int off, int len) {
		//if(off < 0 || off + len > size) {
		//	throw new ArrayIndexOutOfBoundsException((off < 0 ? off : off + len) + " of [0, " + size + ")");
		//}
		// Shift all elements above the remove element to fill the empty index
		// Copy down the remaining upper half of the array if the item removed was not the last item in the array
		if(off + len < size) {
			System.arraycopy(data, off + len, data, off, size - (off + len));
		}
	}


	/** Remove the first matching {@code byte} value from the array<br>
	 * Collection Maintenance Reminders:
	 * <ul>
	 * <li>decrement size</li>
	 * <li>increment action count</li>
	 * </ul>
	 * @param item the object to remove based on item.equals(get(i)) if item
	 * is not null, or get(i)==null if item is null, where i is [0, size()-1]
	 * @return true if the element was removed successfully, false otherwise
	 */
	public static final boolean removeValue(byte[] data, int size, byte item) {
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


	/** Add the specified item to the array.<br>
	 * Collection Maintenance Reminders:
	 * <ul>
	 * <li>increment size</li>
	 * <li>increment action count</li>
	 * </ul>
	 * @param ary the array of items to add to
	 * @param size the current number of elements in {@code ary} containing data (expand array when {@code size} reaches {@code ary.length}), start inserting at index {@code ary[size]}
	 * @param item the item to add to the array
	 */
	public static final byte[] add(byte[] ary, int size, byte item) {
		// If the array is to small, expand it
		if(size + 1 > ary.length) {
			ary = expand(ary);
		}
		// Add the new item
		ary[size] = item;
		return ary;
	}


	/** Add the specified sub-array of items to the array.<br>
	 * Collection Maintenance Reminders:
	 * <ul>
	 * <li>increase size</li>
	 * <li>increment action count</li>
	 * </ul>
	 * @param ary the array of items to add to
	 * @param size the current number of elements in {@code ary} containing data (expand array when {@code size} reaches {@code ary.length}), start inserting at index {@code ary[size]}
	 * @param toAdd the items to add to the array
	 * @param off the index offset into {@code toAdd}
	 * @param len the number of items to add from {@code toAdd}
	 * @return the input {@code ary} or a new array if the input array required expanding to fit the new elements
	 */
	public static final byte[] addAll(byte[] ary, int size, byte[] toAdd, int off, int len) {
		if(toAdd == null) {
			return ary;
		}

		// If the array is to small, expand it
		if(size + len > ary.length) {
			ary = expand(ary, size + len);
		}
		System.arraycopy(toAdd, off, ary, size, len);
		//size += len;

		return ary;
	}


	/** Clear the array (fill with {@code (byte)0}) and add the specified elements
	 * Collection Maintenance Reminders:
	 * <ul>
	 * <li>set size</li>
	 * <li>increment action count</li>
	 * </ul>
	 * @param ary the array of items to add to
	 * @param toAdd the items to add to the array
	 * @param off the index offset into {@code toAdd}
	 * @param len the number of items to add from {@code toAdd}
	 * @return the input {@code ary} or a new array if the input array required expanding to fit the new elements
	 */
	public static final byte[] clearAndAddAll(byte[] ary, byte[] toAdd, int off, int len) {
		int sz = ary.length;
		if(toAdd == null) {
			// clear the array
			for(int i = 0; i < sz; i++) {
				ary[i] = (byte)0;
			}
			return ary;
		}

		// Clear elements past the last index that will be occupied by the new group of items
		for(int i = len; i < sz; i++) {
			ary[i] = (byte)0;
		}

		return addAll(ary, 0, toAdd, off, len);
	}


	/** Designed for use by code that manages arrays by hand.
	 * Note: expands array ~1.5x + 4 it's current size
	 */
	public static final byte[] expand(byte[] oldAry) {
		// Expand array size 1.5x + 4, +4 to prevent small arrays from constantly needing to resize
		byte[] newAry = new byte[oldAry.length + (oldAry.length >>> 1) + 4];
		System.arraycopy(oldAry, 0, newAry, 0, oldAry.length);
		return newAry;
	}


	/** Designed for use by code that manages arrays by hand
	 * Note: expands array ~1.5x + 4 it's current size, up to a maximum of {@code maxSize}
	 */
	public static final byte[] expand(byte[] oldAry, int maxSize) {
		// Expand array size 1.5x + 4, +4 to prevent small arrays from constantly needing to resize
		int newSize = Math.max(maxSize, oldAry.length + (oldAry.length >>> 1) + 4);
		byte[] newAry = new byte[newSize];
		System.arraycopy(oldAry, 0, newAry, 0, oldAry.length);
		return newAry;
	}


	// ==== short array manager functions ====

	/** Remove the {@code short} element at the specified index from the array and replace it with the last element from the array.
	 * This unordered/fast remove requires few operations versus a {@link #removeIndex(short[], int, int)} operation which shifts all subsequent elements down when an array element is removed.
	 * Collection Maintenance Reminders:
	 * <ul>
	 * <li>decrement size</li>
	 * <li>increment action count</li>
	 * </ul>
	 * @param ary the array of items to remove from
	 * @param size the current number of elements in {@code ary} containing data
	 * @param index the index between {@code [0, size - 1]} to remove
	 * @return the element found at the specified index
	 */
	public static final short removeUnordered(short[] ary, int size, int index) {
		//if(index >= size) {
		//	throw new ArrayIndexOutOfBoundsException(index + " of [0, " + size + "]");
		//}
		// Get the item to remove
		short item = ary[index];
		// Replace the item to remove with the last element from the array
		ary[index] = ary[size - 1];
		// Set the last element to null
		ary[size - 1] = (short)0;
		return item;
	}


	/** Remove the {@code short} element at the specified index.<br>
	 * Collection Maintenance Reminders:
	 * <ul>
	 * <li>decrement size</li>
	 * <li>increment action count</li>
	 * </ul>
	 * @param index the index between {@code [0, size - 1]} to remove
	 * @return the char found at the specified index
	 * @throws ArrayIndexOutOfBoundsException if the index is outside the range {@code [0, size - 1]}
	 */
	public static final short removeIndex(short[] data, int size, int index) {
		//if(index < 0 || index >= size) {
		//	throw new ArrayIndexOutOfBoundsException(index + " of [0, " + size + ")");
		//}
		// Shift all elements above the remove element to fill the empty index
		// Get the item to remove
		short item = data[index];

		removeRange(data, size, index, 1);

		return item;
	}


	/** Remove a range of {@code short} elements from the array.<br>
	 * Collection Maintenance Reminders:
	 * <ul>
	 * <li>size minus len</li>
	 * <li>increment action count</li>
	 * </ul>
	 */
	public static final void removeRange(short[] data, int size, int off, int len) {
		//if(off < 0 || off + len > size) {
		//	throw new ArrayIndexOutOfBoundsException((off < 0 ? off : off + len) + " of [0, " + size + ")");
		//}
		// Shift all elements above the remove element to fill the empty index
		// Copy down the remaining upper half of the array if the item removed was not the last item in the array
		if(off + len < size) {
			System.arraycopy(data, off + len, data, off, size - (off + len));
		}
	}


	/** Remove the first matching {@code short} value from the array<br>
	 * Collection Maintenance Reminders:
	 * <ul>
	 * <li>decrement size</li>
	 * <li>increment action count</li>
	 * </ul>
	 * @param item the object to remove based on item.equals(get(i)) if item
	 * is not null, or get(i)==null if item is null, where i is [0, size()-1]
	 * @return true if the element was removed successfully, false otherwise
	 */
	public static final boolean removeValue(short[] data, int size, short item) {
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


	/** Add the specified item to the array.<br>
	 * Collection Maintenance Reminders:
	 * <ul>
	 * <li>increment size</li>
	 * <li>increment action count</li>
	 * </ul>
	 * @param ary the array of items to add to
	 * @param size the current number of elements in {@code ary} containing data (expand array when {@code size} reaches {@code ary.length}), start inserting at index {@code ary[size]}
	 * @param item the item to add to the array
	 */
	public static final short[] add(short[] ary, int size, short item) {
		// If the array is to small, expand it
		if(size + 1 > ary.length) {
			ary = expand(ary);
		}
		// Add the new item
		ary[size] = item;
		return ary;
	}


	/** Add the specified sub-array of items to the array.<br>
	 * Collection Maintenance Reminders:
	 * <ul>
	 * <li>increase size</li>
	 * <li>increment action count</li>
	 * </ul>
	 * @param ary the array of items to add to
	 * @param size the current number of elements in {@code ary} containing data (expand array when {@code size} reaches {@code ary.length}), start inserting at index {@code ary[size]}
	 * @param toAdd the items to add to the array
	 * @param off the index offset into {@code toAdd}
	 * @param len the number of items to add from {@code toAdd}
	 * @return the input {@code ary} or a new array if the input array required expanding to fit the new elements
	 */
	public static final short[] addAll(short[] ary, int size, short[] toAdd, int off, int len) {
		if(toAdd == null) {
			return ary;
		}

		// If the array is to small, expand it
		if(size + len > ary.length) {
			ary = expand(ary, size + len);
		}
		System.arraycopy(toAdd, off, ary, size, len);
		//size += len;

		return ary;
	}


	/** Clear the array (fill with {@code (short)0}) and add the specified elements
	 * Collection Maintenance Reminders:
	 * <ul>
	 * <li>set size</li>
	 * <li>increment action count</li>
	 * </ul>
	 * @param ary the array of items to add to
	 * @param toAdd the items to add to the array
	 * @param off the index offset into {@code toAdd}
	 * @param len the number of items to add from {@code toAdd}
	 * @return the input {@code ary} or a new array if the input array required expanding to fit the new elements
	 */
	public static final short[] clearAndAddAll(short[] ary, short[] toAdd, int off, int len) {
		int sz = ary.length;
		if(toAdd == null) {
			// clear the array
			for(int i = 0; i < sz; i++) {
				ary[i] = (short)0;
			}
			return ary;
		}

		// Clear elements past the last index that will be occupied by the new group of items
		for(int i = len; i < sz; i++) {
			ary[i] = (short)0;
		}

		return addAll(ary, 0, toAdd, off, len);
	}


	/** Designed for use by code that manages arrays by hand.
	 * Note: expands array ~1.5x + 4 it's current size
	 */
	public static final short[] expand(short[] oldAry) {
		// Expand array size 1.5x + 4, +4 to prevent small arrays from constantly needing to resize
		short[] newAry = new short[oldAry.length + (oldAry.length >>> 1) + 4];
		System.arraycopy(oldAry, 0, newAry, 0, oldAry.length);
		return newAry;
	}


	/** Designed for use by code that manages arrays by hand
	 * Note: expands array ~1.5x + 4 it's current size, up to a maximum of {@code maxSize}
	 */
	public static final short[] expand(short[] oldAry, int maxSize) {
		// Expand array size 1.5x + 4, +4 to prevent small arrays from constantly needing to resize
		int newSize = Math.max(maxSize, oldAry.length + (oldAry.length >>> 1) + 4);
		short[] newAry = new short[newSize];
		System.arraycopy(oldAry, 0, newAry, 0, oldAry.length);
		return newAry;
	}


	// ==== char array manager functions ====

	/** Remove the {@code char} element at the specified index from the array and replace it with the last element from the array.
	 * This unordered/fast remove requires few operations versus a {@link #removeIndex(char[], int, int)} operation which shifts all subsequent elements down when an array element is removed.
	 * Collection Maintenance Reminders:
	 * <ul>
	 * <li>decrement size</li>
	 * <li>increment action count</li>
	 * </ul>
	 * @param ary the array of items to remove from
	 * @param size the current number of elements in {@code ary} containing data
	 * @param index the index between {@code [0, size - 1]} to remove
	 * @return the element found at the specified index
	 */
	public static final char removeUnordered(char[] ary, int size, int index) {
		//if(index >= size) {
		//	throw new ArrayIndexOutOfBoundsException(index + " of [0, " + size + "]");
		//}
		// Get the item to remove
		char item = ary[index];
		// Replace the item to remove with the last element from the array
		ary[index] = ary[size - 1];
		// Set the last element to null
		ary[size - 1] = (char)0;
		return item;
	}


	/** Remove the {@code char} element at the specified index.<br>
	 * Collection Maintenance Reminders:
	 * <ul>
	 * <li>decrement size</li>
	 * <li>increment action count</li>
	 * </ul>
	 * @param index the index between {@code [0, size - 1]} to remove
	 * @return the char found at the specified index
	 * @throws ArrayIndexOutOfBoundsException if the index is outside the range {@code [0, size - 1]}
	 */
	public static final char removeIndex(char[] data, int size, int index) {
		//if(index < 0 || index >= size) {
		//	throw new ArrayIndexOutOfBoundsException(index + " of [0, " + size + ")");
		//}
		// Shift all elements above the remove element to fill the empty index
		// Get the item to remove
		char item = data[index];

		removeRange(data, size, index, 1);

		return item;
	}


	/** Remove a range of {@code char} elements from the array.<br>
	 * Collection Maintenance Reminders:
	 * <ul>
	 * <li>size minus len</li>
	 * <li>increment action count</li>
	 * </ul>
	 */
	public static final void removeRange(char[] data, int size, int off, int len) {
		//if(off < 0 || off + len > size) {
		//	throw new ArrayIndexOutOfBoundsException((off < 0 ? off : off + len) + " of [0, " + size + ")");
		//}
		// Shift all elements above the remove element to fill the empty index
		// Copy down the remaining upper half of the array if the item removed was not the last item in the array
		if(off + len < size) {
			System.arraycopy(data, off + len, data, off, size - (off + len));
		}
	}


	/** Remove the first matching {@code char} value from the array<br>
	 * Collection Maintenance Reminders:
	 * <ul>
	 * <li>decrement size</li>
	 * <li>increment action count</li>
	 * </ul>
	 * @param item the object to remove based on item.equals(get(i)) if item
	 * is not null, or get(i)==null if item is null, where i is [0, size()-1]
	 * @return true if the element was removed successfully, false otherwise
	 */
	public static final boolean removeValue(char[] data, int size, char item) {
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


	/** Add the specified item to the array.<br>
	 * Collection Maintenance Reminders:
	 * <ul>
	 * <li>increment size</li>
	 * <li>increment action count</li>
	 * </ul>
	 * @param ary the array of items to add to
	 * @param size the current number of elements in {@code ary} containing data (expand array when {@code size} reaches {@code ary.length}), start inserting at index {@code ary[size]}
	 * @param item the item to add to the array
	 */
	public static final char[] add(char[] ary, int size, char item) {
		// If the array is to small, expand it
		if(size + 1 > ary.length) {
			ary = expand(ary);
		}
		// Add the new item
		ary[size] = item;
		return ary;
	}


	/** Add the specified sub-array of items to the array.<br>
	 * Collection Maintenance Reminders:
	 * <ul>
	 * <li>increase size</li>
	 * <li>increment action count</li>
	 * </ul>
	 * @param ary the array of items to add to
	 * @param size the current number of elements in {@code ary} containing data (expand array when {@code size} reaches {@code ary.length}), start inserting at index {@code ary[size]}
	 * @param toAdd the items to add to the array
	 * @param off the index offset into {@code toAdd}
	 * @param len the number of items to add from {@code toAdd}
	 * @return the input {@code ary} or a new array if the input array required expanding to fit the new elements
	 */
	public static final char[] addAll(char[] ary, int size, char[] toAdd, int off, int len) {
		if(toAdd == null) {
			return ary;
		}

		// If the array is to small, expand it
		if(size + len > ary.length) {
			ary = expand(ary, size + len);
		}
		System.arraycopy(toAdd, off, ary, size, len);
		//size += len;

		return ary;
	}


	/** Clear the array (fill with {@code (char)0}) and add the specified elements
	 * Collection Maintenance Reminders:
	 * <ul>
	 * <li>set size</li>
	 * <li>increment action count</li>
	 * </ul>
	 * @param ary the array of items to add to
	 * @param toAdd the items to add to the array
	 * @param off the index offset into {@code toAdd}
	 * @param len the number of items to add from {@code toAdd}
	 * @return the input {@code ary} or a new array if the input array required expanding to fit the new elements
	 */
	public static final char[] clearAndAddAll(char[] ary, char[] toAdd, int off, int len) {
		int sz = ary.length;
		if(toAdd == null) {
			// clear the array
			for(int i = 0; i < sz; i++) {
				ary[i] = (char)0;
			}
			return ary;
		}

		// Clear elements past the last index that will be occupied by the new group of items
		for(int i = len; i < sz; i++) {
			ary[i] = (char)0;
		}

		return addAll(ary, 0, toAdd, off, len);
	}


	/** Designed for use by code that manages arrays by hand.
	 * Note: expands array ~1.5x + 4 it's current size
	 */
	public static final char[] expand(char[] oldAry) {
		// Expand array size 1.5x + 4, +4 to prevent small arrays from constantly needing to resize
		char[] newAry = new char[oldAry.length + (oldAry.length >>> 1) + 4];
		System.arraycopy(oldAry, 0, newAry, 0, oldAry.length);
		return newAry;
	}


	/** Designed for use by code that manages arrays by hand
	 * Note: expands array ~1.5x + 4 it's current size, up to a maximum of {@code maxSize}
	 */
	public static final char[] expand(char[] oldAry, int maxSize) {
		// Expand array size 1.5x + 4, +4 to prevent small arrays from constantly needing to resize
		int newSize = Math.max(maxSize, oldAry.length + (oldAry.length >>> 1) + 4);
		char[] newAry = new char[newSize];
		System.arraycopy(oldAry, 0, newAry, 0, oldAry.length);
		return newAry;
	}


	// ==== int array manager functions ====

	/** Remove the {@code int} element at the specified index from the array and replace it with the last element from the array.
	 * This unordered/fast remove requires few operations versus a {@link #removeIndex(int[], int, int)} operation which shifts all subsequent elements down when an array element is removed.
	 * Collection Maintenance Reminders:
	 * <ul>
	 * <li>decrement size</li>
	 * <li>increment action count</li>
	 * </ul>
	 * @param ary the array of items to remove from
	 * @param size the current number of elements in {@code ary} containing data
	 * @param index the index between {@code [0, size - 1]} to remove
	 * @return the element found at the specified index
	 */
	public static final int removeUnordered(int[] ary, int size, int index) {
		//if(index >= size) {
		//	throw new ArrayIndexOutOfBoundsException(index + " of [0, " + size + "]");
		//}
		// Get the item to remove
		int item = ary[index];
		// Replace the item to remove with the last element from the array
		ary[index] = ary[size - 1];
		// Set the last element to null
		ary[size - 1] = 0;
		return item;
	}


	/** Remove the {@code int} element at the specified index.<br>
	 * Collection Maintenance Reminders:
	 * <ul>
	 * <li>decrement size</li>
	 * <li>increment action count</li>
	 * </ul>
	 * @param index the index between {@code [0, size - 1]} to remove
	 * @return the char found at the specified index
	 * @throws ArrayIndexOutOfBoundsException if the index is outside the range {@code [0, size - 1]}
	 */
	public static final int removeIndex(int[] data, int size, int index) {
		//if(index < 0 || index >= size) {
		//	throw new ArrayIndexOutOfBoundsException(index + " of [0, " + size + ")");
		//}
		// Shift all elements above the remove element to fill the empty index
		// Get the item to remove
		int item = data[index];

		removeRange(data, size, index, 1);

		return item;
	}


	/** Remove a range of {@code int} elements from the array.<br>
	 * Collection Maintenance Reminders:
	 * <ul>
	 * <li>size minus len</li>
	 * <li>increment action count</li>
	 * </ul>
	 */
	public static final void removeRange(int[] data, int size, int off, int len) {
		//if(off < 0 || off + len > size) {
		//	throw new ArrayIndexOutOfBoundsException((off < 0 ? off : off + len) + " of [0, " + size + ")");
		//}
		// Shift all elements above the remove element to fill the empty index
		// Copy down the remaining upper half of the array if the item removed was not the last item in the array
		if(off + len < size) {
			System.arraycopy(data, off + len, data, off, size - (off + len));
		}
	}


	/** Remove the first matching {@code int} value from the array<br>
	 * Collection Maintenance Reminders:
	 * <ul>
	 * <li>decrement size</li>
	 * <li>increment action count</li>
	 * </ul>
	 * @param item the object to remove based on item.equals(get(i)) if item
	 * is not null, or get(i)==null if item is null, where i is [0, size()-1]
	 * @return true if the element was removed successfully, false otherwise
	 */
	public static final boolean removeValue(int[] data, int size, int item) {
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


	/** Add the specified item to the array.<br>
	 * Collection Maintenance Reminders:
	 * <ul>
	 * <li>increment size</li>
	 * <li>increment action count</li>
	 * </ul>
	 * @param ary the array of items to add to
	 * @param size the current number of elements in {@code ary} containing data (expand array when {@code size} reaches {@code ary.length}), start inserting at index {@code ary[size]}
	 * @param item the item to add to the array
	 */
	public static final int[] add(int[] ary, int size, int item) {
		// If the array is to small, expand it
		if(size + 1 > ary.length) {
			ary = expand(ary);
		}
		// Add the new item
		ary[size] = item;
		return ary;
	}


	/** Add the specified sub-array of items to the array.<br>
	 * Collection Maintenance Reminders:
	 * <ul>
	 * <li>increase size</li>
	 * <li>increment action count</li>
	 * </ul>
	 * @param ary the array of items to add to
	 * @param size the current number of elements in {@code ary} containing data (expand array when {@code size} reaches {@code ary.length}), start inserting at index {@code ary[size]}
	 * @param toAdd the items to add to the array
	 * @param off the index offset into {@code toAdd}
	 * @param len the number of items to add from {@code toAdd}
	 * @return the input {@code ary} or a new array if the input array required expanding to fit the new elements
	 */
	public static final int[] addAll(int[] ary, int size, int[] toAdd, int off, int len) {
		if(toAdd == null) {
			return ary;
		}

		// If the array is to small, expand it
		if(size + len > ary.length) {
			ary = expand(ary, size + len);
		}
		System.arraycopy(toAdd, off, ary, size, len);
		//size += len;

		return ary;
	}


	/** Clear the array (fill with {@code 0}) and add the specified elements
	 * Collection Maintenance Reminders:
	 * <ul>
	 * <li>set size</li>
	 * <li>increment action count</li>
	 * </ul>
	 * @param ary the array of items to add to
	 * @param toAdd the items to add to the array
	 * @param off the index offset into {@code toAdd}
	 * @param len the number of items to add from {@code toAdd}
	 * @return the input {@code ary} or a new array if the input array required expanding to fit the new elements
	 */
	public static final int[] clearAndAddAll(int[] ary, int[] toAdd, int off, int len) {
		int sz = ary.length;
		if(toAdd == null) {
			// clear the array
			for(int i = 0; i < sz; i++) {
				ary[i] = 0;
			}
			return ary;
		}

		// Clear elements past the last index that will be occupied by the new group of items
		for(int i = len; i < sz; i++) {
			ary[i] = 0;
		}

		return addAll(ary, 0, toAdd, off, len);
	}


	/** Designed for use by code that manages arrays by hand.
	 * Note: expands array ~1.5x + 4 it's current size
	 */
	public static final int[] expand(int[] oldAry) {
		// Expand array size 1.5x + 4, +4 to prevent small arrays from constantly needing to resize
		int[] newAry = new int[oldAry.length + (oldAry.length >>> 1) + 4];
		System.arraycopy(oldAry, 0, newAry, 0, oldAry.length);
		return newAry;
	}


	/** Designed for use by code that manages arrays by hand
	 * Note: expands array ~1.5x + 4 it's current size, up to a maximum of {@code maxSize}
	 */
	public static final int[] expand(int[] oldAry, int maxSize) {
		// Expand array size 1.5x + 4, +4 to prevent small arrays from constantly needing to resize
		int newSize = Math.max(maxSize, oldAry.length + (oldAry.length >>> 1) + 4);
		int[] newAry = new int[newSize];
		System.arraycopy(oldAry, 0, newAry, 0, oldAry.length);
		return newAry;
	}


	// ==== long array manager functions ====

	/** Remove the {@code long} element at the specified index from the array and replace it with the last element from the array.
	 * This unordered/fast remove requires few operations versus a {@link #removeIndex(long[], int, int)} operation which shifts all subsequent elements down when an array element is removed.
	 * Collection Maintenance Reminders:
	 * <ul>
	 * <li>decrement size</li>
	 * <li>increment action count</li>
	 * </ul>
	 * @param ary the array of items to remove from
	 * @param size the current number of elements in {@code ary} containing data
	 * @param index the index between {@code [0, size - 1]} to remove
	 * @return the element found at the specified index
	 */
	public static final long removeUnordered(long[] ary, int size, int index) {
		//if(index >= size) {
		//	throw new ArrayIndexOutOfBoundsException(index + " of [0, " + size + "]");
		//}
		// Get the item to remove
		long item = ary[index];
		// Replace the item to remove with the last element from the array
		ary[index] = ary[size - 1];
		// Set the last element to null
		ary[size - 1] = 0L;
		return item;
	}


	/** Remove the {@code long} element at the specified index.<br>
	 * Collection Maintenance Reminders:
	 * <ul>
	 * <li>decrement size</li>
	 * <li>increment action count</li>
	 * </ul>
	 * @param index the index between {@code [0, size - 1]} to remove
	 * @return the char found at the specified index
	 * @throws ArrayIndexOutOfBoundsException if the index is outside the range {@code [0, size - 1]}
	 */
	public static final long removeIndex(long[] data, int size, int index) {
		//if(index < 0 || index >= size) {
		//	throw new ArrayIndexOutOfBoundsException(index + " of [0, " + size + ")");
		//}
		// Shift all elements above the remove element to fill the empty index
		// Get the item to remove
		long item = data[index];

		removeRange(data, size, index, 1);

		return item;
	}


	/** Remove a range of {@code long} elements from the array.<br>
	 * Collection Maintenance Reminders:
	 * <ul>
	 * <li>size minus len</li>
	 * <li>increment action count</li>
	 * </ul>
	 */
	public static final void removeRange(long[] data, int size, int off, int len) {
		//if(off < 0 || off + len > size) {
		//	throw new ArrayIndexOutOfBoundsException((off < 0 ? off : off + len) + " of [0, " + size + ")");
		//}
		// Shift all elements above the remove element to fill the empty index
		// Copy down the remaining upper half of the array if the item removed was not the last item in the array
		if(off + len < size) {
			System.arraycopy(data, off + len, data, off, size - (off + len));
		}
	}


	/** Remove the first matching {@code long} value from the array<br>
	 * Collection Maintenance Reminders:
	 * <ul>
	 * <li>decrement size</li>
	 * <li>increment action count</li>
	 * </ul>
	 * @param item the object to remove based on item.equals(get(i)) if item
	 * is not null, or get(i)==null if item is null, where i is [0, size()-1]
	 * @return true if the element was removed successfully, false otherwise
	 */
	public static final boolean removeValue(long[] data, int size, long item) {
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


	/** Add the specified item to the array.<br>
	 * Collection Maintenance Reminders:
	 * <ul>
	 * <li>increment size</li>
	 * <li>increment action count</li>
	 * </ul>
	 * @param ary the array of items to add to
	 * @param size the current number of elements in {@code ary} containing data (expand array when {@code size} reaches {@code ary.length}), start inserting at index {@code ary[size]}
	 * @param item the item to add to the array
	 */
	public static final long[] add(long[] ary, int size, long item) {
		// If the array is to small, expand it
		if(size + 1 > ary.length) {
			ary = expand(ary);
		}
		// Add the new item
		ary[size] = item;
		return ary;
	}


	/** Add the specified sub-array of items to the array.<br>
	 * Collection Maintenance Reminders:
	 * <ul>
	 * <li>increase size</li>
	 * <li>increment action count</li>
	 * </ul>
	 * @param ary the array of items to add to
	 * @param size the current number of elements in {@code ary} containing data (expand array when {@code size} reaches {@code ary.length}), start inserting at index {@code ary[size]}
	 * @param toAdd the items to add to the array
	 * @param off the index offset into {@code toAdd}
	 * @param len the number of items to add from {@code toAdd}
	 * @return the input {@code ary} or a new array if the input array required expanding to fit the new elements
	 */
	public static final long[] addAll(long[] ary, int size, long[] toAdd, int off, int len) {
		if(toAdd == null) {
			return ary;
		}

		// If the array is to small, expand it
		if(size + len > ary.length) {
			ary = expand(ary, size + len);
		}
		System.arraycopy(toAdd, off, ary, size, len);
		//size += len;

		return ary;
	}


	/** Clear the array (fill with {@code 0L}) and add the specified elements
	 * Collection Maintenance Reminders:
	 * <ul>
	 * <li>set size</li>
	 * <li>increment action count</li>
	 * </ul>
	 * @param ary the array of items to add to
	 * @param toAdd the items to add to the array
	 * @param off the index offset into {@code toAdd}
	 * @param len the number of items to add from {@code toAdd}
	 * @return the input {@code ary} or a new array if the input array required expanding to fit the new elements
	 */
	public static final long[] clearAndAddAll(long[] ary, long[] toAdd, int off, int len) {
		int sz = ary.length;
		if(toAdd == null) {
			// clear the array
			for(int i = 0; i < sz; i++) {
				ary[i] = 0L;
			}
			return ary;
		}

		// Clear elements past the last index that will be occupied by the new group of items
		for(int i = len; i < sz; i++) {
			ary[i] = 0L;
		}

		return addAll(ary, 0, toAdd, off, len);
	}


	/** Designed for use by code that manages arrays by hand.
	 * Note: expands array ~1.5x + 4 it's current size
	 */
	public static final long[] expand(long[] oldAry) {
		// Expand array size 1.5x + 4, +4 to prevent small arrays from constantly needing to resize
		long[] newAry = new long[oldAry.length + (oldAry.length >>> 1) + 4];
		System.arraycopy(oldAry, 0, newAry, 0, oldAry.length);
		return newAry;
	}


	/** Designed for use by code that manages arrays by hand
	 * Note: expands array ~1.5x + 4 it's current size, up to a maximum of {@code maxSize}
	 */
	public static final long[] expand(long[] oldAry, int maxSize) {
		// Expand array size 1.5x + 4, +4 to prevent small arrays from constantly needing to resize
		int newSize = Math.max(maxSize, oldAry.length + (oldAry.length >>> 1) + 4);
		long[] newAry = new long[newSize];
		System.arraycopy(oldAry, 0, newAry, 0, oldAry.length);
		return newAry;
	}


	// ==== float array manager functions ====

	/** Remove the {@code float} element at the specified index from the array and replace it with the last element from the array.
	 * This unordered/fast remove requires few operations versus a {@link #removeIndex(float[], int, int)} operation which shifts all subsequent elements down when an array element is removed.
	 * Collection Maintenance Reminders:
	 * <ul>
	 * <li>decrement size</li>
	 * <li>increment action count</li>
	 * </ul>
	 * @param ary the array of items to remove from
	 * @param size the current number of elements in {@code ary} containing data
	 * @param index the index between {@code [0, size - 1]} to remove
	 * @return the element found at the specified index
	 */
	public static final float removeUnordered(float[] ary, int size, int index) {
		//if(index >= size) {
		//	throw new ArrayIndexOutOfBoundsException(index + " of [0, " + size + "]");
		//}
		// Get the item to remove
		float item = ary[index];
		// Replace the item to remove with the last element from the array
		ary[index] = ary[size - 1];
		// Set the last element to null
		ary[size - 1] = 0f;
		return item;
	}


	/** Remove the {@code float} element at the specified index.<br>
	 * Collection Maintenance Reminders:
	 * <ul>
	 * <li>decrement size</li>
	 * <li>increment action count</li>
	 * </ul>
	 * @param index the index between {@code [0, size - 1]} to remove
	 * @return the char found at the specified index
	 * @throws ArrayIndexOutOfBoundsException if the index is outside the range {@code [0, size - 1]}
	 */
	public static final float removeIndex(float[] data, int size, int index) {
		//if(index < 0 || index >= size) {
		//	throw new ArrayIndexOutOfBoundsException(index + " of [0, " + size + ")");
		//}
		// Shift all elements above the remove element to fill the empty index
		// Get the item to remove
		float item = data[index];

		removeRange(data, size, index, 1);

		return item;
	}


	/** Remove a range of {@code float} elements from the array.<br>
	 * Collection Maintenance Reminders:
	 * <ul>
	 * <li>size minus len</li>
	 * <li>increment action count</li>
	 * </ul>
	 */
	public static final void removeRange(float[] data, int size, int off, int len) {
		//if(off < 0 || off + len > size) {
		//	throw new ArrayIndexOutOfBoundsException((off < 0 ? off : off + len) + " of [0, " + size + ")");
		//}
		// Shift all elements above the remove element to fill the empty index
		// Copy down the remaining upper half of the array if the item removed was not the last item in the array
		if(off + len < size) {
			System.arraycopy(data, off + len, data, off, size - (off + len));
		}
	}


	/** Remove the first matching {@code float} value from the array<br>
	 * Collection Maintenance Reminders:
	 * <ul>
	 * <li>decrement size</li>
	 * <li>increment action count</li>
	 * </ul>
	 * @param item the object to remove based on item.equals(get(i)) if item
	 * is not null, or get(i)==null if item is null, where i is [0, size()-1]
	 * @return true if the element was removed successfully, false otherwise
	 */
	public static final boolean removeValue(float[] data, int size, float item) {
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


	/** Add the specified item to the array.<br>
	 * Collection Maintenance Reminders:
	 * <ul>
	 * <li>increment size</li>
	 * <li>increment action count</li>
	 * </ul>
	 * @param ary the array of items to add to
	 * @param size the current number of elements in {@code ary} containing data (expand array when {@code size} reaches {@code ary.length}), start inserting at index {@code ary[size]}
	 * @param item the item to add to the array
	 */
	public static final float[] add(float[] ary, int size, float item) {
		// If the array is to small, expand it
		if(size + 1 > ary.length) {
			ary = expand(ary);
		}
		// Add the new item
		ary[size] = item;
		return ary;
	}


	/** Add the specified sub-array of items to the array.<br>
	 * Collection Maintenance Reminders:
	 * <ul>
	 * <li>increase size</li>
	 * <li>increment action count</li>
	 * </ul>
	 * @param ary the array of items to add to
	 * @param size the current number of elements in {@code ary} containing data (expand array when {@code size} reaches {@code ary.length}), start inserting at index {@code ary[size]}
	 * @param toAdd the items to add to the array
	 * @param off the index offset into {@code toAdd}
	 * @param len the number of items to add from {@code toAdd}
	 * @return the input {@code ary} or a new array if the input array required expanding to fit the new elements
	 */
	public static final float[] addAll(float[] ary, int size, float[] toAdd, int off, int len) {
		if(toAdd == null) {
			return ary;
		}

		// If the array is to small, expand it
		if(size + len > ary.length) {
			ary = expand(ary, size + len);
		}
		System.arraycopy(toAdd, off, ary, size, len);
		//size += len;

		return ary;
	}


	/** Clear the array (fill with {@code 0f}) and add the specified elements
	 * Collection Maintenance Reminders:
	 * <ul>
	 * <li>set size</li>
	 * <li>increment action count</li>
	 * </ul>
	 * @param ary the array of items to add to
	 * @param toAdd the items to add to the array
	 * @param off the index offset into {@code toAdd}
	 * @param len the number of items to add from {@code toAdd}
	 * @return the input {@code ary} or a new array if the input array required expanding to fit the new elements
	 */
	public static final float[] clearAndAddAll(float[] ary, float[] toAdd, int off, int len) {
		int sz = ary.length;
		if(toAdd == null) {
			// clear the array
			for(int i = 0; i < sz; i++) {
				ary[i] = 0f;
			}
			return ary;
		}

		// Clear elements past the last index that will be occupied by the new group of items
		for(int i = len; i < sz; i++) {
			ary[i] = 0f;
		}

		return addAll(ary, 0, toAdd, off, len);
	}


	/** Designed for use by code that manages arrays by hand.
	 * Note: expands array ~1.5x + 4 it's current size
	 */
	public static final float[] expand(float[] oldAry) {
		// Expand array size 1.5x + 4, +4 to prevent small arrays from constantly needing to resize
		float[] newAry = new float[oldAry.length + (oldAry.length >>> 1) + 4];
		System.arraycopy(oldAry, 0, newAry, 0, oldAry.length);
		return newAry;
	}


	/** Designed for use by code that manages arrays by hand
	 * Note: expands array ~1.5x + 4 it's current size, up to a maximum of {@code maxSize}
	 */
	public static final float[] expand(float[] oldAry, int maxSize) {
		// Expand array size 1.5x + 4, +4 to prevent small arrays from constantly needing to resize
		int newSize = Math.max(maxSize, oldAry.length + (oldAry.length >>> 1) + 4);
		float[] newAry = new float[newSize];
		System.arraycopy(oldAry, 0, newAry, 0, oldAry.length);
		return newAry;
	}


	// ==== double array manager functions ====

	/** Remove the {@code double} element at the specified index from the array and replace it with the last element from the array.
	 * This unordered/fast remove requires few operations versus a {@link #removeIndex(double[], int, int)} operation which shifts all subsequent elements down when an array element is removed.
	 * Collection Maintenance Reminders:
	 * <ul>
	 * <li>decrement size</li>
	 * <li>increment action count</li>
	 * </ul>
	 * @param ary the array of items to remove from
	 * @param size the current number of elements in {@code ary} containing data
	 * @param index the index between {@code [0, size - 1]} to remove
	 * @return the element found at the specified index
	 */
	public static final double removeUnordered(double[] ary, int size, int index) {
		//if(index >= size) {
		//	throw new ArrayIndexOutOfBoundsException(index + " of [0, " + size + "]");
		//}
		// Get the item to remove
		double item = ary[index];
		// Replace the item to remove with the last element from the array
		ary[index] = ary[size - 1];
		// Set the last element to null
		ary[size - 1] = 0;
		return item;
	}


	/** Remove the {@code double} element at the specified index.<br>
	 * Collection Maintenance Reminders:
	 * <ul>
	 * <li>decrement size</li>
	 * <li>increment action count</li>
	 * </ul>
	 * @param index the index between {@code [0, size - 1]} to remove
	 * @return the char found at the specified index
	 * @throws ArrayIndexOutOfBoundsException if the index is outside the range {@code [0, size - 1]}
	 */
	public static final double removeIndex(double[] data, int size, int index) {
		//if(index < 0 || index >= size) {
		//	throw new ArrayIndexOutOfBoundsException(index + " of [0, " + size + ")");
		//}
		// Shift all elements above the remove element to fill the empty index
		// Get the item to remove
		double item = data[index];

		removeRange(data, size, index, 1);

		return item;
	}


	/** Remove a range of {@code double} elements from the array.<br>
	 * Collection Maintenance Reminders:
	 * <ul>
	 * <li>size minus len</li>
	 * <li>increment action count</li>
	 * </ul>
	 */
	public static final void removeRange(double[] data, int size, int off, int len) {
		//if(off < 0 || off + len > size) {
		//	throw new ArrayIndexOutOfBoundsException((off < 0 ? off : off + len) + " of [0, " + size + ")");
		//}
		// Shift all elements above the remove element to fill the empty index
		// Copy down the remaining upper half of the array if the item removed was not the last item in the array
		if(off + len < size) {
			System.arraycopy(data, off + len, data, off, size - (off + len));
		}
	}


	/** Remove the first matching {@code double} value from the array<br>
	 * Collection Maintenance Reminders:
	 * <ul>
	 * <li>decrement size</li>
	 * <li>increment action count</li>
	 * </ul>
	 * @param item the object to remove based on item.equals(get(i)) if item
	 * is not null, or get(i)==null if item is null, where i is [0, size()-1]
	 * @return true if the element was removed successfully, false otherwise
	 */
	public static final boolean removeValue(double[] data, int size, double item) {
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


	/** Add the specified item to the array.<br>
	 * Collection Maintenance Reminders:
	 * <ul>
	 * <li>increment size</li>
	 * <li>increment action count</li>
	 * </ul>
	 * @param ary the array of items to add to
	 * @param size the current number of elements in {@code ary} containing data (expand array when {@code size} reaches {@code ary.length}), start inserting at index {@code ary[size]}
	 * @param item the item to add to the array
	 */
	public static final double[] add(double[] ary, int size, double item) {
		// If the array is to small, expand it
		if(size + 1 > ary.length) {
			ary = expand(ary);
		}
		// Add the new item
		ary[size] = item;
		return ary;
	}


	/** Add the specified sub-array of items to the array.<br>
	 * Collection Maintenance Reminders:
	 * <ul>
	 * <li>increase size</li>
	 * <li>increment action count</li>
	 * </ul>
	 * @param ary the array of items to add to
	 * @param size the current number of elements in {@code ary} containing data (expand array when {@code size} reaches {@code ary.length}), start inserting at index {@code ary[size]}
	 * @param toAdd the items to add to the array
	 * @param off the index offset into {@code toAdd}
	 * @param len the number of items to add from {@code toAdd}
	 * @return the input {@code ary} or a new array if the input array required expanding to fit the new elements
	 */
	public static final double[] addAll(double[] ary, int size, double[] toAdd, int off, int len) {
		if(toAdd == null) {
			return ary;
		}

		// If the array is to small, expand it
		if(size + len > ary.length) {
			ary = expand(ary, size + len);
		}
		System.arraycopy(toAdd, off, ary, size, len);
		//size += len;

		return ary;
	}


	/** Clear the array (fill with {@code 0}) and add the specified elements
	 * Collection Maintenance Reminders:
	 * <ul>
	 * <li>set size</li>
	 * <li>increment action count</li>
	 * </ul>
	 * @param ary the array of items to add to
	 * @param toAdd the items to add to the array
	 * @param off the index offset into {@code toAdd}
	 * @param len the number of items to add from {@code toAdd}
	 * @return the input {@code ary} or a new array if the input array required expanding to fit the new elements
	 */
	public static final double[] clearAndAddAll(double[] ary, double[] toAdd, int off, int len) {
		int sz = ary.length;
		if(toAdd == null) {
			// clear the array
			for(int i = 0; i < sz; i++) {
				ary[i] = 0;
			}
			return ary;
		}

		// Clear elements past the last index that will be occupied by the new group of items
		for(int i = len; i < sz; i++) {
			ary[i] = 0;
		}

		return addAll(ary, 0, toAdd, off, len);
	}


	/** Designed for use by code that manages arrays by hand.
	 * Note: expands array ~1.5x + 4 it's current size
	 */
	public static final double[] expand(double[] oldAry) {
		// Expand array size 1.5x + 4, +4 to prevent small arrays from constantly needing to resize
		double[] newAry = new double[oldAry.length + (oldAry.length >>> 1) + 4];
		System.arraycopy(oldAry, 0, newAry, 0, oldAry.length);
		return newAry;
	}


	/** Designed for use by code that manages arrays by hand
	 * Note: expands array ~1.5x + 4 it's current size, up to a maximum of {@code maxSize}
	 */
	public static final double[] expand(double[] oldAry, int maxSize) {
		// Expand array size 1.5x + 4, +4 to prevent small arrays from constantly needing to resize
		int newSize = Math.max(maxSize, oldAry.length + (oldAry.length >>> 1) + 4);
		double[] newAry = new double[newSize];
		System.arraycopy(oldAry, 0, newAry, 0, oldAry.length);
		return newAry;
	}


	// ==== Object array manager functions ====

	/** Remove the {@code T} element at the specified index from the array and replace it with the last element from the array.
	 * This unordered/fast remove requires few operations versus a {@link #removeIndex(T[], int, int)} operation which shifts all subsequent elements down when an array element is removed.
	 * Collection Maintenance Reminders:
	 * <ul>
	 * <li>decrement size</li>
	 * <li>increment action count</li>
	 * </ul>
	 * @param ary the array of items to remove from
	 * @param size the current number of elements in {@code ary} containing data
	 * @param index the index between {@code [0, size - 1]} to remove
	 * @return the element found at the specified index
	 */
	public static final <T> T removeUnordered(T[] ary, int size, int index) {
		//if(index >= size) {
		//	throw new ArrayIndexOutOfBoundsException(index + " of [0, " + size + "]");
		//}
		// Get the item to remove
		T item = ary[index];
		// Replace the item to remove with the last element from the array
		ary[index] = ary[size - 1];
		// Set the last element to null
		ary[size - 1] = null;
		return item;
	}


	/** Remove the {@code T} element at the specified index.<br>
	 * Collection Maintenance Reminders:
	 * <ul>
	 * <li>decrement size</li>
	 * <li>increment action count</li>
	 * </ul>
	 * @param index the index between {@code [0, size - 1]} to remove
	 * @return the char found at the specified index
	 * @throws ArrayIndexOutOfBoundsException if the index is outside the range {@code [0, size - 1]}
	 */
	public static final <T> T removeIndex(T[] data, int size, int index) {
		//if(index < 0 || index >= size) {
		//	throw new ArrayIndexOutOfBoundsException(index + " of [0, " + size + ")");
		//}
		// Shift all elements above the remove element to fill the empty index
		// Get the item to remove
		T item = data[index];

		removeRange(data, size, index, 1);

		return item;
	}


	/** Remove a range of {@code T} elements from the array.<br>
	 * Collection Maintenance Reminders:
	 * <ul>
	 * <li>size minus len</li>
	 * <li>increment action count</li>
	 * </ul>
	 */
	public static final <T> void removeRange(T[] data, int size, int off, int len) {
		//if(off < 0 || off + len > size) {
		//	throw new ArrayIndexOutOfBoundsException((off < 0 ? off : off + len) + " of [0, " + size + ")");
		//}
		// Shift all elements above the remove element to fill the empty index
		// Copy down the remaining upper half of the array if the item removed was not the last item in the array
		if(off + len < size) {
			System.arraycopy(data, off + len, data, off, size - (off + len));
		}
	}


	/** Remove the first matching {@code T} value from the array<br>
	 * Collection Maintenance Reminders:
	 * <ul>
	 * <li>decrement size</li>
	 * <li>increment action count</li>
	 * </ul>
	 * @param item the object to remove based on item.equals(get(i)) if item
	 * is not null, or get(i)==null if item is null, where i is [0, size()-1]
	 * @return true if the element was removed successfully, false otherwise
	 */
	public static final <T> boolean removeValue(T[] data, int size, T item) {
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


	/** Add the specified item to the array.<br>
	 * Collection Maintenance Reminders:
	 * <ul>
	 * <li>increment size</li>
	 * <li>increment action count</li>
	 * </ul>
	 * @param ary the array of items to add to
	 * @param size the current number of elements in {@code ary} containing data (expand array when {@code size} reaches {@code ary.length}), start inserting at index {@code ary[size]}
	 * @param item the item to add to the array
	 */
	public static final <T> T[] add(T[] ary, int size, T item) {
		// If the array is to small, expand it
		if(size + 1 > ary.length) {
			ary = expand(ary);
		}
		// Add the new item
		ary[size] = item;
		return ary;
	}


	/** Add the specified sub-array of items to the array.<br>
	 * Collection Maintenance Reminders:
	 * <ul>
	 * <li>increase size</li>
	 * <li>increment action count</li>
	 * </ul>
	 * @param ary the array of items to add to
	 * @param size the current number of elements in {@code ary} containing data (expand array when {@code size} reaches {@code ary.length}), start inserting at index {@code ary[size]}
	 * @param toAdd the items to add to the array
	 * @param off the index offset into {@code toAdd}
	 * @param len the number of items to add from {@code toAdd}
	 * @return the input {@code ary} or a new array if the input array required expanding to fit the new elements
	 */
	public static final <T> T[] addAll(T[] ary, int size, T[] toAdd, int off, int len) {
		if(toAdd == null) {
			return ary;
		}

		// If the array is to small, expand it
		if(size + len > ary.length) {
			ary = expand(ary, size + len);
		}
		System.arraycopy(toAdd, off, ary, size, len);
		//size += len;

		return ary;
	}


	/** Clear the array (fill with {@code null}) and add the specified elements
	 * Collection Maintenance Reminders:
	 * <ul>
	 * <li>set size</li>
	 * <li>increment action count</li>
	 * </ul>
	 * @param ary the array of items to add to
	 * @param toAdd the items to add to the array
	 * @param off the index offset into {@code toAdd}
	 * @param len the number of items to add from {@code toAdd}
	 * @return the input {@code ary} or a new array if the input array required expanding to fit the new elements
	 */
	public static final <T> T[] clearAndAddAll(T[] ary, T[] toAdd, int off, int len) {
		int sz = ary.length;
		if(toAdd == null) {
			// clear the array
			for(int i = 0; i < sz; i++) {
				ary[i] = null;
			}
			return ary;
		}

		// Clear elements past the last index that will be occupied by the new group of items
		for(int i = len; i < sz; i++) {
			ary[i] = null;
		}

		return addAll(ary, 0, toAdd, off, len);
	}


	/** Designed for use by code that manages arrays by hand.
	 * Note: expands array ~1.5x + 4 it's current size
	 */
	@SuppressWarnings("unchecked")
	public static final <T> T[] expand(T[] oldAry) {
		// Expand array size 1.5x + 4, +4 to prevent small arrays from constantly needing to resize
		Object[] newAry = new Object[oldAry.length + (oldAry.length >>> 1) + 4];
		System.arraycopy(oldAry, 0, newAry, 0, oldAry.length);
		return (T[])newAry;
	}


	/** Designed for use by code that manages arrays by hand
	 * Note: expands array ~1.5x + 4 it's current size, up to a maximum of {@code maxSize}
	 */
	@SuppressWarnings("unchecked")
	public static final <T> T[] expand(T[] oldAry, int maxSize) {
		// Expand array size 1.5x + 4, +4 to prevent small arrays from constantly needing to resize
		int newSize = Math.max(maxSize, oldAry.length + (oldAry.length >>> 1) + 4);
		Object[] newAry = new Object[newSize];
		System.arraycopy(oldAry, 0, newAry, 0, oldAry.length);
		return (T[])newAry;
	}

}