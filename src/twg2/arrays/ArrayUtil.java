package twg2.arrays;

import java.util.Arrays;
import java.lang.reflect.Array;
import java.util.function.Function;

/** Methods for finding the index of a value in an array of values, concat arrays
 * together, reverse an array of values, and calculate the sum, average,
 * minimum, or maximum of a numeric array.
 * @author TeamworkGuy2
 * @since 2014-6-2
 */
@javax.annotation.Generated("StringTemplate")
public final class ArrayUtil {
	public static final byte[] EMPTY_BYTE_ARRAY = new byte[0];
	public static final short[] EMPTY_SHORT_ARRAY = new short[0];
	public static final char[] EMPTY_CHAR_ARRAY = new char[0];
	public static final int[] EMPTY_INT_ARRAY = new int[0];
	public static final long[] EMPTY_LONG_ARRAY = new long[0];
	public static final float[] EMPTY_FLOAT_ARRAY = new float[0];
	public static final double[] EMPTY_DOUBLE_ARRAY = new double[0];
	public static final String[] EMPTY_STRING_ARRAY = new String[0];
	public static final Object[] EMPTY_OBJECT_ARRAY = new Object[0];


	private ArrayUtil() { throw new AssertionError("cannot instantiate static class ArrayUtil"); }


	// start boolean array methods
	/** Convert a set of boolean values to an array
	 * @param values the set of values
	 * @return the array of values
	 */
	public static final boolean[] asArray(boolean... values) {
		return values;
	}


	/** Search for a matching boolean in an array of booleans
	 * @param ary the array of values to search
	 * @param value the value to search for
	 * @return the index of the matching value, or -1 if the {@code value} could not be found
	 */
	public static final int indexOf(boolean[] ary, boolean value) {
		return indexOf(ary, 0, ary.length, value);
	}


	/** Search for a matching boolean in an array of booleans
	 * @param ary the array of values to search
	 * @param off the offset into {@code ary} at which to start searching for values
	 * @param len the number of values to search for starting at {@code off} in {@code ary}
	 * @param value the value to search for
	 * @return the index of the matching value, or -1 if the {@code value} could not be found
	 */
	public static final int indexOf(boolean[] ary, int off, int len, boolean value) {
		for(int i = off, size = off + len; i < size; i++) {
			if(ary[i] == (value)) { return i; }
		}
		return -1;
	}



	/** Search for the last matching boolean in an array of booleans
	 * @param ary the array of values to search
	 * @param value the value to search for
	 * @return the index of the matching value, or -1 if the {@code value} could not be found
	 */
	public static final int lastIndexOf(boolean[] ary, boolean value) {
		return lastIndexOf(ary, 0, ary.length, value);
	}


	/** Search for the last matching boolean in an array of booleans
	 * @param ary the array of values to search
	 * @param off the offset into {@code ary} at which to stop searching for values
	 * @param len the number of values to search for starting at {@code off + len} in {@code ary}
	 * @param value the value to search for
	 * @return the index of the matching value, or -1 if the {@code value} could not be found
	 */
	public static final int lastIndexOf(boolean[] ary, int off, int len, boolean value) {
		for(int i = off + len - 1; i >= off; i--) {
			if(ary[i] == (value)) { return i; }
		}
		return -1;
	}



	/** Return an array containing a copy of all of the input arrays
	 * @param arys the input arrays, cannot be null, cannot contain null
	 * @return a new array containing a shallow copy of all the input arrays
	 */
	public static final boolean[] concat(boolean[]... arys) {
		int totalSize = 0;
		for(boolean[] ary : arys) {
			totalSize += ary.length;
		}

		boolean[] r = new boolean[totalSize];

		int offset = 0;
		for(boolean[] ary : arys) {
			System.arraycopy(ary, 0, r, offset, ary.length);
			offset += ary.length;
		}

		return r;
	}


	/** Return an array containing a copy of array {@code a} and {@code b}
	 * @param a the first array
	 * @param b the second array
	 * @return a new array containing a shallow copy of both arrays
	 */
	public static final boolean[] concat(boolean[] a, boolean[] b) {
		boolean[] r = Arrays.copyOf(a, a.length + b.length);
		System.arraycopy(b, 0, r, a.length, b.length);
		return r;
	}


	/** @see #concat(boolean[], int, int, boolean[], int, int, int, int)
	 */
	public static final boolean[] concat(boolean[] a, boolean[] b, int dstOff, int dstTotalLength) {
		return concat(a, 0, a.length, b, 0, b.length, dstOff, dstTotalLength);
	}


	/** Return a new array containing a copy of array {@code a} and {@code b}
	 * @param a the first array
	 * @param b the second array
	 * @param dstOff the offset into {@code dst} at which to append array {@code a} and {@code b}
	 * @param dstTotalLength the total length of the new array to return
	 * @return a new array containing a shallow copy of both arrays
	 */
	public static final boolean[] concat(boolean[] a, int offA, int lenA, boolean[] b, int offB, int lenB, int dstOff, int dstTotalLength) {
		boolean[] dst = new boolean[dstTotalLength];
		System.arraycopy(a, offA, dst, dstOff, lenA);
		System.arraycopy(b, offB, dst, dstOff + lenA, lenB);
		return dst;
	}


	/** @see #concat(boolean[], int, int, boolean[], int, int, boolean[], int)
	 */
	public static final boolean[] concat(boolean[] a, boolean[] b, boolean[] dst, int dstOff) {
		return concat(a, 0, a.length, b, 0, b.length, dst, dstOff);
	}


	/** Return an array containing a copy of array {@code a} and {@code b}
	 * @param a the first array
	 * @param b the second array
	 * @param dst the destination array to store the copied elements in
	 * @param dstOff the offset into {@code dst} at which to append array {@code a} and {@code b}
	 * @return a new array containing a shallow copy of both arrays
	 */
	public static final boolean[] concat(boolean[] a, int offA, int lenA, boolean[] b, int offB, int lenB, boolean[] dst, int dstOff) {
		System.arraycopy(a, offA, dst, dstOff, lenA);
		System.arraycopy(b, offB, dst, dstOff + lenA, lenB);
		return dst;
	}


	/** Create a string of values from a sub-array
	 * @param ary the array
	 * @param off the offset into {@code ary} at which to converting elements to strings
	 * @param len the number of elements from {@code ary} to convert to strings
	 * @return a string representation of a sub-array
	 */
	public static final String toString(boolean[] ary, int off, int len) {
		if(ary == null) {
			return "null";
		}

		int maxI = len - 1;

		if(maxI < 0) {
			return "[]";
		}

		StringBuilder strB = new StringBuilder();
		strB.append('[');
		for(int i = 0; i < maxI; i++) {
			strB.append(ary[off + i]);
			strB.append(',');
			strB.append(' ');
		}
		strB.append(ary[off + maxI]);
		strB.append(']');
		return strB.toString();		
	}


	/** Compare two sub-arrays for equality to one another
	 * @param a the first array to compare
	 * @param offA the offset into {@code a} at which to start comparing
	 * @param b the second array to compare
	 * @param offB the offset into {@code b} at which to start comparing
	 * @param len the number of elements from {@code a} to compare to elements from {@code b}
	 * @return true if {@code len} number of elements from {@code a} and {@code b} are equal, false
	 * if one or more elements are not equal
	 */
	public static final boolean equals(boolean[] a, int offA, boolean[] b, int offB, int len) {
		if(a == b) {
			return true;
		}
		if(a == null || b == null) {
			return false;
		}

		for(int i = 0; i < len; i++) {
			boolean objA = a[offA + i];
			boolean objB = b[offB + i];
			if(objA != objB) {
				return false;
			}
		}
		return true;		
	}


	/** Reverse an boolean array.<br>
	 * For example {@code ary=[0, 1, 2, 3]}, the result would be {@code ary=[3, 2, 1, 0]}.
	 * @param ary the array to reverse a portion of
	 */
	public static final boolean[] reverse(boolean[] ary) {
		return reverse(ary, 0, ary.length);
	}


	/** Reverse a subset of an boolean array.<br>
	 * For example {@code ary=[0, 1, 2, 3, 4, 5]} and {@code offset=2} and {@code length=3},
	 * the result would be {@code ary=[0, 1, 4, 3, 2, 5]}.
	 * @param ary the array to reverse a portion of
	 * @param offset the offset into the array at which to begin reversing the order of elements
	 * @param length the number of elements to reverse
	 */
	public static final boolean[] reverse(boolean[] ary, int offset, int length) {
		final int len = length/2;
		for(int i = 0; i < len; i++) {
			boolean temp = ary[offset + i];
			int i2 = offset + length - i - 1;
			ary[offset + i] = ary[i2];
			ary[i2] = temp;
		}
		return ary;
	}


	/** Check array not null and bounds.<br>
	 * @param ary the array to check
	 * @param off the offset being checked
	 * @param len the length being checked
	 * @return true if the bounds are valid, false if not
	 */
	public static final boolean checkBounds(boolean[] ary, int off, int len) {
		return ary != null && off > -1 && len > -1 && off + len <= ary.length;
	}


	/** Check array not null and bounds.<br>
	 * @param ary the array to check
	 * @param off the offset being checked
	 * @param len the length being checked
	 * @throws ArrayIndexOutOfBoundsException if the index is out of bounds
	 * @throws NullPointerException if ary is null
	 */
	public static final void checkBoundsThrows(boolean[] ary, int off, int len) {
		if(ary == null) {
			throw new NullPointerException("array cannot be null");
		}
		if(off < 0) {
			throw new ArrayIndexOutOfBoundsException("offset must be great than -1: " + off);
		}
		if(len < 0) {
			throw new ArrayIndexOutOfBoundsException("length must be great than -1: " + len);
		}
		if(off + len > ary.length) {
			throw new ArrayIndexOutOfBoundsException("array size=" + ary.length + ", off=" + off + ", len=" + len);
		}
	}


	/** Alias for {@link #primitiveToWrapper(boolean[], int, int, Boolean[], int)}
	 */
	public static final Boolean[] primitiveToWrapper(boolean[] srcAry) {
		return primitiveToWrapper(srcAry, 0, srcAry.length, new Boolean[srcAry.length], 0);
	}


	/**
	 * @param srcAry the source primitive type array
	 * @param srcOff the source index offset at which to start copying elements
	 * @param srcLen the number of source elements to copy
	 * @param dst the destination primitive wrapper type array to store the elements in
	 * @param dstOff the offset into the destination array at which to start storing the copied elements
	 * @return the {@code dst} array
	 */
	public static final Boolean[] primitiveToWrapper(boolean[] srcAry, int srcOff, int srcLen, Boolean[] dst, int dstOff) {
		for(int i = 0; i < srcLen; i++) {
			dst[dstOff + i] = srcAry[srcOff + i];
		}
		return dst;
	}


	/** Alias for {@link #wrapperToPrimitive(Boolean[], int, int, boolean[], int)}
	 */
	public static final boolean[] wrapperToPrimitive(Boolean[] srcAry) {
		return wrapperToPrimitive(srcAry, 0, srcAry.length, new boolean[srcAry.length], 0);
	}


	/**
	 * @param srcAry the source primitive wrapper type array
	 * @param srcOff the source index offset at which to start copying elements
	 * @param srcLen the number of source elements to copy
	 * @param dst the destination primitive type array to store the elements in
	 * @param dstOff the offset into the destination array at which to start storing the copied elements
	 * @return the {@code dst} array
	 */
	public static final boolean[] wrapperToPrimitive(Boolean[] srcAry, int srcOff, int srcLen, boolean[] dst, int dstOff) {
		for(int i = 0; i < srcLen; i++) {
			dst[dstOff + i] = srcAry[srcOff + i];
		}
		return dst;
	}
	// end boolean array methods


	// start byte array methods
	/** Convert a set of byte values to an array
	 * @param values the set of values
	 * @return the array of values
	 */
	public static final byte[] asArray(byte... values) {
		return values;
	}


	/** Search for a matching byte in an array of bytes
	 * @param ary the array of values to search
	 * @param value the value to search for
	 * @return the index of the matching value, or -1 if the {@code value} could not be found
	 */
	public static final int indexOf(byte[] ary, byte value) {
		return indexOf(ary, 0, ary.length, value);
	}


	/** Search for a matching byte in an array of bytes
	 * @param ary the array of values to search
	 * @param off the offset into {@code ary} at which to start searching for values
	 * @param len the number of values to search for starting at {@code off} in {@code ary}
	 * @param value the value to search for
	 * @return the index of the matching value, or -1 if the {@code value} could not be found
	 */
	public static final int indexOf(byte[] ary, int off, int len, byte value) {
		for(int i = off, size = off + len; i < size; i++) {
			if(ary[i] == (value)) { return i; }
		}
		return -1;
	}



	/** Search for the last matching byte in an array of bytes
	 * @param ary the array of values to search
	 * @param value the value to search for
	 * @return the index of the matching value, or -1 if the {@code value} could not be found
	 */
	public static final int lastIndexOf(byte[] ary, byte value) {
		return lastIndexOf(ary, 0, ary.length, value);
	}


	/** Search for the last matching byte in an array of bytes
	 * @param ary the array of values to search
	 * @param off the offset into {@code ary} at which to stop searching for values
	 * @param len the number of values to search for starting at {@code off + len} in {@code ary}
	 * @param value the value to search for
	 * @return the index of the matching value, or -1 if the {@code value} could not be found
	 */
	public static final int lastIndexOf(byte[] ary, int off, int len, byte value) {
		for(int i = off + len - 1; i >= off; i--) {
			if(ary[i] == (value)) { return i; }
		}
		return -1;
	}



	/** Return an array containing a copy of all of the input arrays
	 * @param arys the input arrays, cannot be null, cannot contain null
	 * @return a new array containing a shallow copy of all the input arrays
	 */
	public static final byte[] concat(byte[]... arys) {
		int totalSize = 0;
		for(byte[] ary : arys) {
			totalSize += ary.length;
		}

		byte[] r = new byte[totalSize];

		int offset = 0;
		for(byte[] ary : arys) {
			System.arraycopy(ary, 0, r, offset, ary.length);
			offset += ary.length;
		}

		return r;
	}


	/** Return an array containing a copy of array {@code a} and {@code b}
	 * @param a the first array
	 * @param b the second array
	 * @return a new array containing a shallow copy of both arrays
	 */
	public static final byte[] concat(byte[] a, byte[] b) {
		byte[] r = Arrays.copyOf(a, a.length + b.length);
		System.arraycopy(b, 0, r, a.length, b.length);
		return r;
	}


	/** @see #concat(byte[], int, int, byte[], int, int, int, int)
	 */
	public static final byte[] concat(byte[] a, byte[] b, int dstOff, int dstTotalLength) {
		return concat(a, 0, a.length, b, 0, b.length, dstOff, dstTotalLength);
	}


	/** Return a new array containing a copy of array {@code a} and {@code b}
	 * @param a the first array
	 * @param b the second array
	 * @param dstOff the offset into {@code dst} at which to append array {@code a} and {@code b}
	 * @param dstTotalLength the total length of the new array to return
	 * @return a new array containing a shallow copy of both arrays
	 */
	public static final byte[] concat(byte[] a, int offA, int lenA, byte[] b, int offB, int lenB, int dstOff, int dstTotalLength) {
		byte[] dst = new byte[dstTotalLength];
		System.arraycopy(a, offA, dst, dstOff, lenA);
		System.arraycopy(b, offB, dst, dstOff + lenA, lenB);
		return dst;
	}


	/** @see #concat(byte[], int, int, byte[], int, int, byte[], int)
	 */
	public static final byte[] concat(byte[] a, byte[] b, byte[] dst, int dstOff) {
		return concat(a, 0, a.length, b, 0, b.length, dst, dstOff);
	}


	/** Return an array containing a copy of array {@code a} and {@code b}
	 * @param a the first array
	 * @param b the second array
	 * @param dst the destination array to store the copied elements in
	 * @param dstOff the offset into {@code dst} at which to append array {@code a} and {@code b}
	 * @return a new array containing a shallow copy of both arrays
	 */
	public static final byte[] concat(byte[] a, int offA, int lenA, byte[] b, int offB, int lenB, byte[] dst, int dstOff) {
		System.arraycopy(a, offA, dst, dstOff, lenA);
		System.arraycopy(b, offB, dst, dstOff + lenA, lenB);
		return dst;
	}


	/** Create a string of values from a sub-array
	 * @param ary the array
	 * @param off the offset into {@code ary} at which to converting elements to strings
	 * @param len the number of elements from {@code ary} to convert to strings
	 * @return a string representation of a sub-array
	 */
	public static final String toString(byte[] ary, int off, int len) {
		if(ary == null) {
			return "null";
		}

		int maxI = len - 1;

		if(maxI < 0) {
			return "[]";
		}

		StringBuilder strB = new StringBuilder();
		strB.append('[');
		for(int i = 0; i < maxI; i++) {
			strB.append(ary[off + i]);
			strB.append(',');
			strB.append(' ');
		}
		strB.append(ary[off + maxI]);
		strB.append(']');
		return strB.toString();		
	}


	/** Compare two sub-arrays for equality to one another
	 * @param a the first array to compare
	 * @param offA the offset into {@code a} at which to start comparing
	 * @param b the second array to compare
	 * @param offB the offset into {@code b} at which to start comparing
	 * @param len the number of elements from {@code a} to compare to elements from {@code b}
	 * @return true if {@code len} number of elements from {@code a} and {@code b} are equal, false
	 * if one or more elements are not equal
	 */
	public static final boolean equals(byte[] a, int offA, byte[] b, int offB, int len) {
		if(a == b) {
			return true;
		}
		if(a == null || b == null) {
			return false;
		}

		for(int i = 0; i < len; i++) {
			byte objA = a[offA + i];
			byte objB = b[offB + i];
			if(objA != objB) {
				return false;
			}
		}
		return true;		
	}


	/** Reverse an byte array.<br>
	 * For example {@code ary=[0, 1, 2, 3]}, the result would be {@code ary=[3, 2, 1, 0]}.
	 * @param ary the array to reverse a portion of
	 */
	public static final byte[] reverse(byte[] ary) {
		return reverse(ary, 0, ary.length);
	}


	/** Reverse a subset of an byte array.<br>
	 * For example {@code ary=[0, 1, 2, 3, 4, 5]} and {@code offset=2} and {@code length=3},
	 * the result would be {@code ary=[0, 1, 4, 3, 2, 5]}.
	 * @param ary the array to reverse a portion of
	 * @param offset the offset into the array at which to begin reversing the order of elements
	 * @param length the number of elements to reverse
	 */
	public static final byte[] reverse(byte[] ary, int offset, int length) {
		final int len = length/2;
		for(int i = 0; i < len; i++) {
			byte temp = ary[offset + i];
			int i2 = offset + length - i - 1;
			ary[offset + i] = ary[i2];
			ary[i2] = temp;
		}
		return ary;
	}


	/** Check array not null and bounds.<br>
	 * @param ary the array to check
	 * @param off the offset being checked
	 * @param len the length being checked
	 * @return true if the bounds are valid, false if not
	 */
	public static final boolean checkBounds(byte[] ary, int off, int len) {
		return ary != null && off > -1 && len > -1 && off + len <= ary.length;
	}


	/** Check array not null and bounds.<br>
	 * @param ary the array to check
	 * @param off the offset being checked
	 * @param len the length being checked
	 * @throws ArrayIndexOutOfBoundsException if the index is out of bounds
	 * @throws NullPointerException if ary is null
	 */
	public static final void checkBoundsThrows(byte[] ary, int off, int len) {
		if(ary == null) {
			throw new NullPointerException("array cannot be null");
		}
		if(off < 0) {
			throw new ArrayIndexOutOfBoundsException("offset must be great than -1: " + off);
		}
		if(len < 0) {
			throw new ArrayIndexOutOfBoundsException("length must be great than -1: " + len);
		}
		if(off + len > ary.length) {
			throw new ArrayIndexOutOfBoundsException("array size=" + ary.length + ", off=" + off + ", len=" + len);
		}
	}


	/** Alias for {@link #primitiveToWrapper(byte[], int, int, Byte[], int)}
	 */
	public static final Byte[] primitiveToWrapper(byte[] srcAry) {
		return primitiveToWrapper(srcAry, 0, srcAry.length, new Byte[srcAry.length], 0);
	}


	/**
	 * @param srcAry the source primitive type array
	 * @param srcOff the source index offset at which to start copying elements
	 * @param srcLen the number of source elements to copy
	 * @param dst the destination primitive wrapper type array to store the elements in
	 * @param dstOff the offset into the destination array at which to start storing the copied elements
	 * @return the {@code dst} array
	 */
	public static final Byte[] primitiveToWrapper(byte[] srcAry, int srcOff, int srcLen, Byte[] dst, int dstOff) {
		for(int i = 0; i < srcLen; i++) {
			dst[dstOff + i] = srcAry[srcOff + i];
		}
		return dst;
	}


	/** Alias for {@link #wrapperToPrimitive(Byte[], int, int, byte[], int)}
	 */
	public static final byte[] wrapperToPrimitive(Byte[] srcAry) {
		return wrapperToPrimitive(srcAry, 0, srcAry.length, new byte[srcAry.length], 0);
	}


	/**
	 * @param srcAry the source primitive wrapper type array
	 * @param srcOff the source index offset at which to start copying elements
	 * @param srcLen the number of source elements to copy
	 * @param dst the destination primitive type array to store the elements in
	 * @param dstOff the offset into the destination array at which to start storing the copied elements
	 * @return the {@code dst} array
	 */
	public static final byte[] wrapperToPrimitive(Byte[] srcAry, int srcOff, int srcLen, byte[] dst, int dstOff) {
		for(int i = 0; i < srcLen; i++) {
			dst[dstOff + i] = srcAry[srcOff + i];
		}
		return dst;
	}


	/** Sum of an array
	 * @param ary the array of integers to sum
	 * @return the sum of all of the elements in the specified array
	 */
	public static final int sum(byte[] ary) {
		return sum(ary, 0, ary.length);
	}


	/** Sum of the subset of an array
	 * @param ary the array of bytes to sum
	 * @param offset the offset into the array at which to start summing values
	 * @param length the number of elements to sum from the array starting
	 * at {@code offset}
	 * @return the sum of the specified array subset
	 */
	public static final int sum(byte[] ary, int offset, int length) {
		int offLen = offset + length;
		int sum = (byte)0;
		for(int i = offset; i < offLen; i++) {
			sum += ary[i];
		}
		return sum;
	}


	/** The average of an array
	 * @param values the array of values to average
	 * @return the average of the array
	 */
	public static final float avg(byte[] values) {
		return avg(values, 0, values.length);
	}


	/** The average of a subset of an array
	 * @param values the array of values to average
	 * @param offset the offset into the array at which to start averaging values
	 * @param length the number of values to average from the array
	 * @return the average of the array subset specified
	 */
	public static final float avg(byte[] values, int offset, int length) {
		int total = 0;
		int offLen = offset + length;
		for(int i = offset; i < offLen; i++) {
			total += values[i];
		}
		return total/(float)length;
	}


	/** Get the minimum value in an array subset
	 * @param values the array to search
	 * @return the minimum value found in the array subset specified or {@link Byte#MAX_VALUE} if the array is empty (0 length)
	 */
	public static final byte min(byte[] values) {
		return min(values, 0, values.length);
	}


	/** Get the minimum value in an array subset
	 * @param values the array to search
	 * @param offset the offset into the array at which to start searching
	 * @param length the number of values to search
	 * @return the minimum value found in the array subset specified or {@link Byte#MAX_VALUE} if {@code length == 0}
	 */
	public static final byte min(byte[] values, int offset, int length) {
		byte min = Byte.MAX_VALUE;
		int offLen = offset + length;
		for(int i = offset; i < offLen; i++) {
			if(min > values[i]) { min = values[i]; }
		}
		return min;
	}


	/** Get the maximum value in an array subset
	 * @param values the array to search
	 * @return the minimum value found in the array subset specified or {@link Byte#MIN_VALUE} if the array is empty (0 length)
	 */
	public static final byte max(byte[] values) {
		return max(values, 0, values.length);
	}


	/** Get the maximum value in an array subset
	 * @param values the array to search
	 * @param offset the offset into the array at which to start searching
	 * @param length the number of values to search
	 * @return the minimum value found in the array subset specified or {@link Byte#MIN_VALUE} if the {@code length == 0}
	 */
	public static final byte max(byte[] values, int offset, int length) {
		byte max = Byte.MIN_VALUE;
		int offLen = offset + length;
		for(int i = offset; i < offLen; i++) {
			if(max < values[i]) { max = values[i]; }
		}
		return max;
	}
	// end byte array methods


	// start short array methods
	/** Convert a set of short values to an array
	 * @param values the set of values
	 * @return the array of values
	 */
	public static final short[] asArray(short... values) {
		return values;
	}


	/** Search for a matching short in an array of shorts
	 * @param ary the array of values to search
	 * @param value the value to search for
	 * @return the index of the matching value, or -1 if the {@code value} could not be found
	 */
	public static final int indexOf(short[] ary, short value) {
		return indexOf(ary, 0, ary.length, value);
	}


	/** Search for a matching short in an array of shorts
	 * @param ary the array of values to search
	 * @param off the offset into {@code ary} at which to start searching for values
	 * @param len the number of values to search for starting at {@code off} in {@code ary}
	 * @param value the value to search for
	 * @return the index of the matching value, or -1 if the {@code value} could not be found
	 */
	public static final int indexOf(short[] ary, int off, int len, short value) {
		for(int i = off, size = off + len; i < size; i++) {
			if(ary[i] == (value)) { return i; }
		}
		return -1;
	}



	/** Search for the last matching short in an array of shorts
	 * @param ary the array of values to search
	 * @param value the value to search for
	 * @return the index of the matching value, or -1 if the {@code value} could not be found
	 */
	public static final int lastIndexOf(short[] ary, short value) {
		return lastIndexOf(ary, 0, ary.length, value);
	}


	/** Search for the last matching short in an array of shorts
	 * @param ary the array of values to search
	 * @param off the offset into {@code ary} at which to stop searching for values
	 * @param len the number of values to search for starting at {@code off + len} in {@code ary}
	 * @param value the value to search for
	 * @return the index of the matching value, or -1 if the {@code value} could not be found
	 */
	public static final int lastIndexOf(short[] ary, int off, int len, short value) {
		for(int i = off + len - 1; i >= off; i--) {
			if(ary[i] == (value)) { return i; }
		}
		return -1;
	}



	/** Return an array containing a copy of all of the input arrays
	 * @param arys the input arrays, cannot be null, cannot contain null
	 * @return a new array containing a shallow copy of all the input arrays
	 */
	public static final short[] concat(short[]... arys) {
		int totalSize = 0;
		for(short[] ary : arys) {
			totalSize += ary.length;
		}

		short[] r = new short[totalSize];

		int offset = 0;
		for(short[] ary : arys) {
			System.arraycopy(ary, 0, r, offset, ary.length);
			offset += ary.length;
		}

		return r;
	}


	/** Return an array containing a copy of array {@code a} and {@code b}
	 * @param a the first array
	 * @param b the second array
	 * @return a new array containing a shallow copy of both arrays
	 */
	public static final short[] concat(short[] a, short[] b) {
		short[] r = Arrays.copyOf(a, a.length + b.length);
		System.arraycopy(b, 0, r, a.length, b.length);
		return r;
	}


	/** @see #concat(short[], int, int, short[], int, int, int, int)
	 */
	public static final short[] concat(short[] a, short[] b, int dstOff, int dstTotalLength) {
		return concat(a, 0, a.length, b, 0, b.length, dstOff, dstTotalLength);
	}


	/** Return a new array containing a copy of array {@code a} and {@code b}
	 * @param a the first array
	 * @param b the second array
	 * @param dstOff the offset into {@code dst} at which to append array {@code a} and {@code b}
	 * @param dstTotalLength the total length of the new array to return
	 * @return a new array containing a shallow copy of both arrays
	 */
	public static final short[] concat(short[] a, int offA, int lenA, short[] b, int offB, int lenB, int dstOff, int dstTotalLength) {
		short[] dst = new short[dstTotalLength];
		System.arraycopy(a, offA, dst, dstOff, lenA);
		System.arraycopy(b, offB, dst, dstOff + lenA, lenB);
		return dst;
	}


	/** @see #concat(short[], int, int, short[], int, int, short[], int)
	 */
	public static final short[] concat(short[] a, short[] b, short[] dst, int dstOff) {
		return concat(a, 0, a.length, b, 0, b.length, dst, dstOff);
	}


	/** Return an array containing a copy of array {@code a} and {@code b}
	 * @param a the first array
	 * @param b the second array
	 * @param dst the destination array to store the copied elements in
	 * @param dstOff the offset into {@code dst} at which to append array {@code a} and {@code b}
	 * @return a new array containing a shallow copy of both arrays
	 */
	public static final short[] concat(short[] a, int offA, int lenA, short[] b, int offB, int lenB, short[] dst, int dstOff) {
		System.arraycopy(a, offA, dst, dstOff, lenA);
		System.arraycopy(b, offB, dst, dstOff + lenA, lenB);
		return dst;
	}


	/** Create a string of values from a sub-array
	 * @param ary the array
	 * @param off the offset into {@code ary} at which to converting elements to strings
	 * @param len the number of elements from {@code ary} to convert to strings
	 * @return a string representation of a sub-array
	 */
	public static final String toString(short[] ary, int off, int len) {
		if(ary == null) {
			return "null";
		}

		int maxI = len - 1;

		if(maxI < 0) {
			return "[]";
		}

		StringBuilder strB = new StringBuilder();
		strB.append('[');
		for(int i = 0; i < maxI; i++) {
			strB.append(ary[off + i]);
			strB.append(',');
			strB.append(' ');
		}
		strB.append(ary[off + maxI]);
		strB.append(']');
		return strB.toString();		
	}


	/** Compare two sub-arrays for equality to one another
	 * @param a the first array to compare
	 * @param offA the offset into {@code a} at which to start comparing
	 * @param b the second array to compare
	 * @param offB the offset into {@code b} at which to start comparing
	 * @param len the number of elements from {@code a} to compare to elements from {@code b}
	 * @return true if {@code len} number of elements from {@code a} and {@code b} are equal, false
	 * if one or more elements are not equal
	 */
	public static final boolean equals(short[] a, int offA, short[] b, int offB, int len) {
		if(a == b) {
			return true;
		}
		if(a == null || b == null) {
			return false;
		}

		for(int i = 0; i < len; i++) {
			short objA = a[offA + i];
			short objB = b[offB + i];
			if(objA != objB) {
				return false;
			}
		}
		return true;		
	}


	/** Reverse an short array.<br>
	 * For example {@code ary=[0, 1, 2, 3]}, the result would be {@code ary=[3, 2, 1, 0]}.
	 * @param ary the array to reverse a portion of
	 */
	public static final short[] reverse(short[] ary) {
		return reverse(ary, 0, ary.length);
	}


	/** Reverse a subset of an short array.<br>
	 * For example {@code ary=[0, 1, 2, 3, 4, 5]} and {@code offset=2} and {@code length=3},
	 * the result would be {@code ary=[0, 1, 4, 3, 2, 5]}.
	 * @param ary the array to reverse a portion of
	 * @param offset the offset into the array at which to begin reversing the order of elements
	 * @param length the number of elements to reverse
	 */
	public static final short[] reverse(short[] ary, int offset, int length) {
		final int len = length/2;
		for(int i = 0; i < len; i++) {
			short temp = ary[offset + i];
			int i2 = offset + length - i - 1;
			ary[offset + i] = ary[i2];
			ary[i2] = temp;
		}
		return ary;
	}


	/** Check array not null and bounds.<br>
	 * @param ary the array to check
	 * @param off the offset being checked
	 * @param len the length being checked
	 * @return true if the bounds are valid, false if not
	 */
	public static final boolean checkBounds(short[] ary, int off, int len) {
		return ary != null && off > -1 && len > -1 && off + len <= ary.length;
	}


	/** Check array not null and bounds.<br>
	 * @param ary the array to check
	 * @param off the offset being checked
	 * @param len the length being checked
	 * @throws ArrayIndexOutOfBoundsException if the index is out of bounds
	 * @throws NullPointerException if ary is null
	 */
	public static final void checkBoundsThrows(short[] ary, int off, int len) {
		if(ary == null) {
			throw new NullPointerException("array cannot be null");
		}
		if(off < 0) {
			throw new ArrayIndexOutOfBoundsException("offset must be great than -1: " + off);
		}
		if(len < 0) {
			throw new ArrayIndexOutOfBoundsException("length must be great than -1: " + len);
		}
		if(off + len > ary.length) {
			throw new ArrayIndexOutOfBoundsException("array size=" + ary.length + ", off=" + off + ", len=" + len);
		}
	}


	/** Alias for {@link #primitiveToWrapper(short[], int, int, Short[], int)}
	 */
	public static final Short[] primitiveToWrapper(short[] srcAry) {
		return primitiveToWrapper(srcAry, 0, srcAry.length, new Short[srcAry.length], 0);
	}


	/**
	 * @param srcAry the source primitive type array
	 * @param srcOff the source index offset at which to start copying elements
	 * @param srcLen the number of source elements to copy
	 * @param dst the destination primitive wrapper type array to store the elements in
	 * @param dstOff the offset into the destination array at which to start storing the copied elements
	 * @return the {@code dst} array
	 */
	public static final Short[] primitiveToWrapper(short[] srcAry, int srcOff, int srcLen, Short[] dst, int dstOff) {
		for(int i = 0; i < srcLen; i++) {
			dst[dstOff + i] = srcAry[srcOff + i];
		}
		return dst;
	}


	/** Alias for {@link #wrapperToPrimitive(Short[], int, int, short[], int)}
	 */
	public static final short[] wrapperToPrimitive(Short[] srcAry) {
		return wrapperToPrimitive(srcAry, 0, srcAry.length, new short[srcAry.length], 0);
	}


	/**
	 * @param srcAry the source primitive wrapper type array
	 * @param srcOff the source index offset at which to start copying elements
	 * @param srcLen the number of source elements to copy
	 * @param dst the destination primitive type array to store the elements in
	 * @param dstOff the offset into the destination array at which to start storing the copied elements
	 * @return the {@code dst} array
	 */
	public static final short[] wrapperToPrimitive(Short[] srcAry, int srcOff, int srcLen, short[] dst, int dstOff) {
		for(int i = 0; i < srcLen; i++) {
			dst[dstOff + i] = srcAry[srcOff + i];
		}
		return dst;
	}


	/** Sum of an array
	 * @param ary the array of integers to sum
	 * @return the sum of all of the elements in the specified array
	 */
	public static final int sum(short[] ary) {
		return sum(ary, 0, ary.length);
	}


	/** Sum of the subset of an array
	 * @param ary the array of shorts to sum
	 * @param offset the offset into the array at which to start summing values
	 * @param length the number of elements to sum from the array starting
	 * at {@code offset}
	 * @return the sum of the specified array subset
	 */
	public static final int sum(short[] ary, int offset, int length) {
		int offLen = offset + length;
		int sum = (short)0;
		for(int i = offset; i < offLen; i++) {
			sum += ary[i];
		}
		return sum;
	}


	/** The average of an array
	 * @param values the array of values to average
	 * @return the average of the array
	 */
	public static final float avg(short[] values) {
		return avg(values, 0, values.length);
	}


	/** The average of a subset of an array
	 * @param values the array of values to average
	 * @param offset the offset into the array at which to start averaging values
	 * @param length the number of values to average from the array
	 * @return the average of the array subset specified
	 */
	public static final float avg(short[] values, int offset, int length) {
		int total = 0;
		int offLen = offset + length;
		for(int i = offset; i < offLen; i++) {
			total += values[i];
		}
		return total/(float)length;
	}


	/** Get the minimum value in an array subset
	 * @param values the array to search
	 * @return the minimum value found in the array subset specified or {@link Short#MAX_VALUE} if the array is empty (0 length)
	 */
	public static final short min(short[] values) {
		return min(values, 0, values.length);
	}


	/** Get the minimum value in an array subset
	 * @param values the array to search
	 * @param offset the offset into the array at which to start searching
	 * @param length the number of values to search
	 * @return the minimum value found in the array subset specified or {@link Short#MAX_VALUE} if {@code length == 0}
	 */
	public static final short min(short[] values, int offset, int length) {
		short min = Short.MAX_VALUE;
		int offLen = offset + length;
		for(int i = offset; i < offLen; i++) {
			if(min > values[i]) { min = values[i]; }
		}
		return min;
	}


	/** Get the maximum value in an array subset
	 * @param values the array to search
	 * @return the minimum value found in the array subset specified or {@link Short#MIN_VALUE} if the array is empty (0 length)
	 */
	public static final short max(short[] values) {
		return max(values, 0, values.length);
	}


	/** Get the maximum value in an array subset
	 * @param values the array to search
	 * @param offset the offset into the array at which to start searching
	 * @param length the number of values to search
	 * @return the minimum value found in the array subset specified or {@link Short#MIN_VALUE} if the {@code length == 0}
	 */
	public static final short max(short[] values, int offset, int length) {
		short max = Short.MIN_VALUE;
		int offLen = offset + length;
		for(int i = offset; i < offLen; i++) {
			if(max < values[i]) { max = values[i]; }
		}
		return max;
	}
	// end short array methods


	// start char array methods
	/** Convert a set of char values to an array
	 * @param values the set of values
	 * @return the array of values
	 */
	public static final char[] asArray(char... values) {
		return values;
	}


	/** Search for a matching char in an array of chars
	 * @param ary the array of values to search
	 * @param value the value to search for
	 * @return the index of the matching value, or -1 if the {@code value} could not be found
	 */
	public static final int indexOf(char[] ary, char value) {
		return indexOf(ary, 0, ary.length, value);
	}


	/** Search for a matching char in an array of chars
	 * @param ary the array of values to search
	 * @param off the offset into {@code ary} at which to start searching for values
	 * @param len the number of values to search for starting at {@code off} in {@code ary}
	 * @param value the value to search for
	 * @return the index of the matching value, or -1 if the {@code value} could not be found
	 */
	public static final int indexOf(char[] ary, int off, int len, char value) {
		for(int i = off, size = off + len; i < size; i++) {
			if(ary[i] == (value)) { return i; }
		}
		return -1;
	}



	/** Search for the last matching char in an array of chars
	 * @param ary the array of values to search
	 * @param value the value to search for
	 * @return the index of the matching value, or -1 if the {@code value} could not be found
	 */
	public static final int lastIndexOf(char[] ary, char value) {
		return lastIndexOf(ary, 0, ary.length, value);
	}


	/** Search for the last matching char in an array of chars
	 * @param ary the array of values to search
	 * @param off the offset into {@code ary} at which to stop searching for values
	 * @param len the number of values to search for starting at {@code off + len} in {@code ary}
	 * @param value the value to search for
	 * @return the index of the matching value, or -1 if the {@code value} could not be found
	 */
	public static final int lastIndexOf(char[] ary, int off, int len, char value) {
		for(int i = off + len - 1; i >= off; i--) {
			if(ary[i] == (value)) { return i; }
		}
		return -1;
	}



	/** Return an array containing a copy of all of the input arrays
	 * @param arys the input arrays, cannot be null, cannot contain null
	 * @return a new array containing a shallow copy of all the input arrays
	 */
	public static final char[] concat(char[]... arys) {
		int totalSize = 0;
		for(char[] ary : arys) {
			totalSize += ary.length;
		}

		char[] r = new char[totalSize];

		int offset = 0;
		for(char[] ary : arys) {
			System.arraycopy(ary, 0, r, offset, ary.length);
			offset += ary.length;
		}

		return r;
	}


	/** Return an array containing a copy of array {@code a} and {@code b}
	 * @param a the first array
	 * @param b the second array
	 * @return a new array containing a shallow copy of both arrays
	 */
	public static final char[] concat(char[] a, char[] b) {
		char[] r = Arrays.copyOf(a, a.length + b.length);
		System.arraycopy(b, 0, r, a.length, b.length);
		return r;
	}


	/** @see #concat(char[], int, int, char[], int, int, int, int)
	 */
	public static final char[] concat(char[] a, char[] b, int dstOff, int dstTotalLength) {
		return concat(a, 0, a.length, b, 0, b.length, dstOff, dstTotalLength);
	}


	/** Return a new array containing a copy of array {@code a} and {@code b}
	 * @param a the first array
	 * @param b the second array
	 * @param dstOff the offset into {@code dst} at which to append array {@code a} and {@code b}
	 * @param dstTotalLength the total length of the new array to return
	 * @return a new array containing a shallow copy of both arrays
	 */
	public static final char[] concat(char[] a, int offA, int lenA, char[] b, int offB, int lenB, int dstOff, int dstTotalLength) {
		char[] dst = new char[dstTotalLength];
		System.arraycopy(a, offA, dst, dstOff, lenA);
		System.arraycopy(b, offB, dst, dstOff + lenA, lenB);
		return dst;
	}


	/** @see #concat(char[], int, int, char[], int, int, char[], int)
	 */
	public static final char[] concat(char[] a, char[] b, char[] dst, int dstOff) {
		return concat(a, 0, a.length, b, 0, b.length, dst, dstOff);
	}


	/** Return an array containing a copy of array {@code a} and {@code b}
	 * @param a the first array
	 * @param b the second array
	 * @param dst the destination array to store the copied elements in
	 * @param dstOff the offset into {@code dst} at which to append array {@code a} and {@code b}
	 * @return a new array containing a shallow copy of both arrays
	 */
	public static final char[] concat(char[] a, int offA, int lenA, char[] b, int offB, int lenB, char[] dst, int dstOff) {
		System.arraycopy(a, offA, dst, dstOff, lenA);
		System.arraycopy(b, offB, dst, dstOff + lenA, lenB);
		return dst;
	}


	/** Create a string of values from a sub-array
	 * @param ary the array
	 * @param off the offset into {@code ary} at which to converting elements to strings
	 * @param len the number of elements from {@code ary} to convert to strings
	 * @return a string representation of a sub-array
	 */
	public static final String toString(char[] ary, int off, int len) {
		if(ary == null) {
			return "null";
		}

		int maxI = len - 1;

		if(maxI < 0) {
			return "[]";
		}

		StringBuilder strB = new StringBuilder();
		strB.append('[');
		for(int i = 0; i < maxI; i++) {
			strB.append(ary[off + i]);
			strB.append(',');
			strB.append(' ');
		}
		strB.append(ary[off + maxI]);
		strB.append(']');
		return strB.toString();		
	}


	/** Compare two sub-arrays for equality to one another
	 * @param a the first array to compare
	 * @param offA the offset into {@code a} at which to start comparing
	 * @param b the second array to compare
	 * @param offB the offset into {@code b} at which to start comparing
	 * @param len the number of elements from {@code a} to compare to elements from {@code b}
	 * @return true if {@code len} number of elements from {@code a} and {@code b} are equal, false
	 * if one or more elements are not equal
	 */
	public static final boolean equals(char[] a, int offA, char[] b, int offB, int len) {
		if(a == b) {
			return true;
		}
		if(a == null || b == null) {
			return false;
		}

		for(int i = 0; i < len; i++) {
			char objA = a[offA + i];
			char objB = b[offB + i];
			if(objA != objB) {
				return false;
			}
		}
		return true;		
	}


	/** Reverse an char array.<br>
	 * For example {@code ary=[0, 1, 2, 3]}, the result would be {@code ary=[3, 2, 1, 0]}.
	 * @param ary the array to reverse a portion of
	 */
	public static final char[] reverse(char[] ary) {
		return reverse(ary, 0, ary.length);
	}


	/** Reverse a subset of an char array.<br>
	 * For example {@code ary=[0, 1, 2, 3, 4, 5]} and {@code offset=2} and {@code length=3},
	 * the result would be {@code ary=[0, 1, 4, 3, 2, 5]}.
	 * @param ary the array to reverse a portion of
	 * @param offset the offset into the array at which to begin reversing the order of elements
	 * @param length the number of elements to reverse
	 */
	public static final char[] reverse(char[] ary, int offset, int length) {
		final int len = length/2;
		for(int i = 0; i < len; i++) {
			char temp = ary[offset + i];
			int i2 = offset + length - i - 1;
			ary[offset + i] = ary[i2];
			ary[i2] = temp;
		}
		return ary;
	}


	/** Check array not null and bounds.<br>
	 * @param ary the array to check
	 * @param off the offset being checked
	 * @param len the length being checked
	 * @return true if the bounds are valid, false if not
	 */
	public static final boolean checkBounds(char[] ary, int off, int len) {
		return ary != null && off > -1 && len > -1 && off + len <= ary.length;
	}


	/** Check array not null and bounds.<br>
	 * @param ary the array to check
	 * @param off the offset being checked
	 * @param len the length being checked
	 * @throws ArrayIndexOutOfBoundsException if the index is out of bounds
	 * @throws NullPointerException if ary is null
	 */
	public static final void checkBoundsThrows(char[] ary, int off, int len) {
		if(ary == null) {
			throw new NullPointerException("array cannot be null");
		}
		if(off < 0) {
			throw new ArrayIndexOutOfBoundsException("offset must be great than -1: " + off);
		}
		if(len < 0) {
			throw new ArrayIndexOutOfBoundsException("length must be great than -1: " + len);
		}
		if(off + len > ary.length) {
			throw new ArrayIndexOutOfBoundsException("array size=" + ary.length + ", off=" + off + ", len=" + len);
		}
	}


	/** Alias for {@link #primitiveToWrapper(char[], int, int, Character[], int)}
	 */
	public static final Character[] primitiveToWrapper(char[] srcAry) {
		return primitiveToWrapper(srcAry, 0, srcAry.length, new Character[srcAry.length], 0);
	}


	/**
	 * @param srcAry the source primitive type array
	 * @param srcOff the source index offset at which to start copying elements
	 * @param srcLen the number of source elements to copy
	 * @param dst the destination primitive wrapper type array to store the elements in
	 * @param dstOff the offset into the destination array at which to start storing the copied elements
	 * @return the {@code dst} array
	 */
	public static final Character[] primitiveToWrapper(char[] srcAry, int srcOff, int srcLen, Character[] dst, int dstOff) {
		for(int i = 0; i < srcLen; i++) {
			dst[dstOff + i] = srcAry[srcOff + i];
		}
		return dst;
	}


	/** Alias for {@link #wrapperToPrimitive(Character[], int, int, char[], int)}
	 */
	public static final char[] wrapperToPrimitive(Character[] srcAry) {
		return wrapperToPrimitive(srcAry, 0, srcAry.length, new char[srcAry.length], 0);
	}


	/**
	 * @param srcAry the source primitive wrapper type array
	 * @param srcOff the source index offset at which to start copying elements
	 * @param srcLen the number of source elements to copy
	 * @param dst the destination primitive type array to store the elements in
	 * @param dstOff the offset into the destination array at which to start storing the copied elements
	 * @return the {@code dst} array
	 */
	public static final char[] wrapperToPrimitive(Character[] srcAry, int srcOff, int srcLen, char[] dst, int dstOff) {
		for(int i = 0; i < srcLen; i++) {
			dst[dstOff + i] = srcAry[srcOff + i];
		}
		return dst;
	}


	/** Sum of an array
	 * @param ary the array of integers to sum
	 * @return the sum of all of the elements in the specified array
	 */
	public static final int sum(char[] ary) {
		return sum(ary, 0, ary.length);
	}


	/** Sum of the subset of an array
	 * @param ary the array of chars to sum
	 * @param offset the offset into the array at which to start summing values
	 * @param length the number of elements to sum from the array starting
	 * at {@code offset}
	 * @return the sum of the specified array subset
	 */
	public static final int sum(char[] ary, int offset, int length) {
		int offLen = offset + length;
		int sum = (char)0;
		for(int i = offset; i < offLen; i++) {
			sum += ary[i];
		}
		return sum;
	}


	/** The average of an array
	 * @param values the array of values to average
	 * @return the average of the array
	 */
	public static final float avg(char[] values) {
		return avg(values, 0, values.length);
	}


	/** The average of a subset of an array
	 * @param values the array of values to average
	 * @param offset the offset into the array at which to start averaging values
	 * @param length the number of values to average from the array
	 * @return the average of the array subset specified
	 */
	public static final float avg(char[] values, int offset, int length) {
		int total = 0;
		int offLen = offset + length;
		for(int i = offset; i < offLen; i++) {
			total += values[i];
		}
		return total/(float)length;
	}


	/** Get the minimum value in an array subset
	 * @param values the array to search
	 * @return the minimum value found in the array subset specified or {@link Character#MAX_VALUE} if the array is empty (0 length)
	 */
	public static final char min(char[] values) {
		return min(values, 0, values.length);
	}


	/** Get the minimum value in an array subset
	 * @param values the array to search
	 * @param offset the offset into the array at which to start searching
	 * @param length the number of values to search
	 * @return the minimum value found in the array subset specified or {@link Character#MAX_VALUE} if {@code length == 0}
	 */
	public static final char min(char[] values, int offset, int length) {
		char min = Character.MAX_VALUE;
		int offLen = offset + length;
		for(int i = offset; i < offLen; i++) {
			if(min > values[i]) { min = values[i]; }
		}
		return min;
	}


	/** Get the maximum value in an array subset
	 * @param values the array to search
	 * @return the minimum value found in the array subset specified or {@link Character#MIN_VALUE} if the array is empty (0 length)
	 */
	public static final char max(char[] values) {
		return max(values, 0, values.length);
	}


	/** Get the maximum value in an array subset
	 * @param values the array to search
	 * @param offset the offset into the array at which to start searching
	 * @param length the number of values to search
	 * @return the minimum value found in the array subset specified or {@link Character#MIN_VALUE} if the {@code length == 0}
	 */
	public static final char max(char[] values, int offset, int length) {
		char max = Character.MIN_VALUE;
		int offLen = offset + length;
		for(int i = offset; i < offLen; i++) {
			if(max < values[i]) { max = values[i]; }
		}
		return max;
	}
	// end char array methods


	// start int array methods
	/** Convert a set of int values to an array
	 * @param values the set of values
	 * @return the array of values
	 */
	public static final int[] asArray(int... values) {
		return values;
	}


	/** Search for a matching int in an array of ints
	 * @param ary the array of values to search
	 * @param value the value to search for
	 * @return the index of the matching value, or -1 if the {@code value} could not be found
	 */
	public static final int indexOf(int[] ary, int value) {
		return indexOf(ary, 0, ary.length, value);
	}


	/** Search for a matching int in an array of ints
	 * @param ary the array of values to search
	 * @param off the offset into {@code ary} at which to start searching for values
	 * @param len the number of values to search for starting at {@code off} in {@code ary}
	 * @param value the value to search for
	 * @return the index of the matching value, or -1 if the {@code value} could not be found
	 */
	public static final int indexOf(int[] ary, int off, int len, int value) {
		for(int i = off, size = off + len; i < size; i++) {
			if(ary[i] == (value)) { return i; }
		}
		return -1;
	}



	/** Search for the last matching int in an array of ints
	 * @param ary the array of values to search
	 * @param value the value to search for
	 * @return the index of the matching value, or -1 if the {@code value} could not be found
	 */
	public static final int lastIndexOf(int[] ary, int value) {
		return lastIndexOf(ary, 0, ary.length, value);
	}


	/** Search for the last matching int in an array of ints
	 * @param ary the array of values to search
	 * @param off the offset into {@code ary} at which to stop searching for values
	 * @param len the number of values to search for starting at {@code off + len} in {@code ary}
	 * @param value the value to search for
	 * @return the index of the matching value, or -1 if the {@code value} could not be found
	 */
	public static final int lastIndexOf(int[] ary, int off, int len, int value) {
		for(int i = off + len - 1; i >= off; i--) {
			if(ary[i] == (value)) { return i; }
		}
		return -1;
	}



	/** Return an array containing a copy of all of the input arrays
	 * @param arys the input arrays, cannot be null, cannot contain null
	 * @return a new array containing a shallow copy of all the input arrays
	 */
	public static final int[] concat(int[]... arys) {
		int totalSize = 0;
		for(int[] ary : arys) {
			totalSize += ary.length;
		}

		int[] r = new int[totalSize];

		int offset = 0;
		for(int[] ary : arys) {
			System.arraycopy(ary, 0, r, offset, ary.length);
			offset += ary.length;
		}

		return r;
	}


	/** Return an array containing a copy of array {@code a} and {@code b}
	 * @param a the first array
	 * @param b the second array
	 * @return a new array containing a shallow copy of both arrays
	 */
	public static final int[] concat(int[] a, int[] b) {
		int[] r = Arrays.copyOf(a, a.length + b.length);
		System.arraycopy(b, 0, r, a.length, b.length);
		return r;
	}


	/** @see #concat(int[], int, int, int[], int, int, int, int)
	 */
	public static final int[] concat(int[] a, int[] b, int dstOff, int dstTotalLength) {
		return concat(a, 0, a.length, b, 0, b.length, dstOff, dstTotalLength);
	}


	/** Return a new array containing a copy of array {@code a} and {@code b}
	 * @param a the first array
	 * @param b the second array
	 * @param dstOff the offset into {@code dst} at which to append array {@code a} and {@code b}
	 * @param dstTotalLength the total length of the new array to return
	 * @return a new array containing a shallow copy of both arrays
	 */
	public static final int[] concat(int[] a, int offA, int lenA, int[] b, int offB, int lenB, int dstOff, int dstTotalLength) {
		int[] dst = new int[dstTotalLength];
		System.arraycopy(a, offA, dst, dstOff, lenA);
		System.arraycopy(b, offB, dst, dstOff + lenA, lenB);
		return dst;
	}


	/** @see #concat(int[], int, int, int[], int, int, int[], int)
	 */
	public static final int[] concat(int[] a, int[] b, int[] dst, int dstOff) {
		return concat(a, 0, a.length, b, 0, b.length, dst, dstOff);
	}


	/** Return an array containing a copy of array {@code a} and {@code b}
	 * @param a the first array
	 * @param b the second array
	 * @param dst the destination array to store the copied elements in
	 * @param dstOff the offset into {@code dst} at which to append array {@code a} and {@code b}
	 * @return a new array containing a shallow copy of both arrays
	 */
	public static final int[] concat(int[] a, int offA, int lenA, int[] b, int offB, int lenB, int[] dst, int dstOff) {
		System.arraycopy(a, offA, dst, dstOff, lenA);
		System.arraycopy(b, offB, dst, dstOff + lenA, lenB);
		return dst;
	}


	/** Create a string of values from a sub-array
	 * @param ary the array
	 * @param off the offset into {@code ary} at which to converting elements to strings
	 * @param len the number of elements from {@code ary} to convert to strings
	 * @return a string representation of a sub-array
	 */
	public static final String toString(int[] ary, int off, int len) {
		if(ary == null) {
			return "null";
		}

		int maxI = len - 1;

		if(maxI < 0) {
			return "[]";
		}

		StringBuilder strB = new StringBuilder();
		strB.append('[');
		for(int i = 0; i < maxI; i++) {
			strB.append(ary[off + i]);
			strB.append(',');
			strB.append(' ');
		}
		strB.append(ary[off + maxI]);
		strB.append(']');
		return strB.toString();		
	}


	/** Compare two sub-arrays for equality to one another
	 * @param a the first array to compare
	 * @param offA the offset into {@code a} at which to start comparing
	 * @param b the second array to compare
	 * @param offB the offset into {@code b} at which to start comparing
	 * @param len the number of elements from {@code a} to compare to elements from {@code b}
	 * @return true if {@code len} number of elements from {@code a} and {@code b} are equal, false
	 * if one or more elements are not equal
	 */
	public static final boolean equals(int[] a, int offA, int[] b, int offB, int len) {
		if(a == b) {
			return true;
		}
		if(a == null || b == null) {
			return false;
		}

		for(int i = 0; i < len; i++) {
			int objA = a[offA + i];
			int objB = b[offB + i];
			if(objA != objB) {
				return false;
			}
		}
		return true;		
	}


	/** Reverse an int array.<br>
	 * For example {@code ary=[0, 1, 2, 3]}, the result would be {@code ary=[3, 2, 1, 0]}.
	 * @param ary the array to reverse a portion of
	 */
	public static final int[] reverse(int[] ary) {
		return reverse(ary, 0, ary.length);
	}


	/** Reverse a subset of an int array.<br>
	 * For example {@code ary=[0, 1, 2, 3, 4, 5]} and {@code offset=2} and {@code length=3},
	 * the result would be {@code ary=[0, 1, 4, 3, 2, 5]}.
	 * @param ary the array to reverse a portion of
	 * @param offset the offset into the array at which to begin reversing the order of elements
	 * @param length the number of elements to reverse
	 */
	public static final int[] reverse(int[] ary, int offset, int length) {
		final int len = length/2;
		for(int i = 0; i < len; i++) {
			int temp = ary[offset + i];
			int i2 = offset + length - i - 1;
			ary[offset + i] = ary[i2];
			ary[i2] = temp;
		}
		return ary;
	}


	/** Check array not null and bounds.<br>
	 * @param ary the array to check
	 * @param off the offset being checked
	 * @param len the length being checked
	 * @return true if the bounds are valid, false if not
	 */
	public static final boolean checkBounds(int[] ary, int off, int len) {
		return ary != null && off > -1 && len > -1 && off + len <= ary.length;
	}


	/** Check array not null and bounds.<br>
	 * @param ary the array to check
	 * @param off the offset being checked
	 * @param len the length being checked
	 * @throws ArrayIndexOutOfBoundsException if the index is out of bounds
	 * @throws NullPointerException if ary is null
	 */
	public static final void checkBoundsThrows(int[] ary, int off, int len) {
		if(ary == null) {
			throw new NullPointerException("array cannot be null");
		}
		if(off < 0) {
			throw new ArrayIndexOutOfBoundsException("offset must be great than -1: " + off);
		}
		if(len < 0) {
			throw new ArrayIndexOutOfBoundsException("length must be great than -1: " + len);
		}
		if(off + len > ary.length) {
			throw new ArrayIndexOutOfBoundsException("array size=" + ary.length + ", off=" + off + ", len=" + len);
		}
	}


	/** Alias for {@link #primitiveToWrapper(int[], int, int, Integer[], int)}
	 */
	public static final Integer[] primitiveToWrapper(int[] srcAry) {
		return primitiveToWrapper(srcAry, 0, srcAry.length, new Integer[srcAry.length], 0);
	}


	/**
	 * @param srcAry the source primitive type array
	 * @param srcOff the source index offset at which to start copying elements
	 * @param srcLen the number of source elements to copy
	 * @param dst the destination primitive wrapper type array to store the elements in
	 * @param dstOff the offset into the destination array at which to start storing the copied elements
	 * @return the {@code dst} array
	 */
	public static final Integer[] primitiveToWrapper(int[] srcAry, int srcOff, int srcLen, Integer[] dst, int dstOff) {
		for(int i = 0; i < srcLen; i++) {
			dst[dstOff + i] = srcAry[srcOff + i];
		}
		return dst;
	}


	/** Alias for {@link #wrapperToPrimitive(Integer[], int, int, int[], int)}
	 */
	public static final int[] wrapperToPrimitive(Integer[] srcAry) {
		return wrapperToPrimitive(srcAry, 0, srcAry.length, new int[srcAry.length], 0);
	}


	/**
	 * @param srcAry the source primitive wrapper type array
	 * @param srcOff the source index offset at which to start copying elements
	 * @param srcLen the number of source elements to copy
	 * @param dst the destination primitive type array to store the elements in
	 * @param dstOff the offset into the destination array at which to start storing the copied elements
	 * @return the {@code dst} array
	 */
	public static final int[] wrapperToPrimitive(Integer[] srcAry, int srcOff, int srcLen, int[] dst, int dstOff) {
		for(int i = 0; i < srcLen; i++) {
			dst[dstOff + i] = srcAry[srcOff + i];
		}
		return dst;
	}


	/** Sum of an array
	 * @param ary the array of integers to sum
	 * @return the sum of all of the elements in the specified array
	 */
	public static final int sum(int[] ary) {
		return sum(ary, 0, ary.length);
	}


	/** Sum of the subset of an array
	 * @param ary the array of ints to sum
	 * @param offset the offset into the array at which to start summing values
	 * @param length the number of elements to sum from the array starting
	 * at {@code offset}
	 * @return the sum of the specified array subset
	 */
	public static final int sum(int[] ary, int offset, int length) {
		int offLen = offset + length;
		int sum = 0;
		for(int i = offset; i < offLen; i++) {
			sum += ary[i];
		}
		return sum;
	}


	/** The average of an array
	 * @param values the array of values to average
	 * @return the average of the array
	 */
	public static final float avg(int[] values) {
		return avg(values, 0, values.length);
	}


	/** The average of a subset of an array
	 * @param values the array of values to average
	 * @param offset the offset into the array at which to start averaging values
	 * @param length the number of values to average from the array
	 * @return the average of the array subset specified
	 */
	public static final float avg(int[] values, int offset, int length) {
		int total = 0;
		int offLen = offset + length;
		for(int i = offset; i < offLen; i++) {
			total += values[i];
		}
		return total/(float)length;
	}


	/** Get the minimum value in an array subset
	 * @param values the array to search
	 * @return the minimum value found in the array subset specified or {@link Integer#MAX_VALUE} if the array is empty (0 length)
	 */
	public static final int min(int[] values) {
		return min(values, 0, values.length);
	}


	/** Get the minimum value in an array subset
	 * @param values the array to search
	 * @param offset the offset into the array at which to start searching
	 * @param length the number of values to search
	 * @return the minimum value found in the array subset specified or {@link Integer#MAX_VALUE} if {@code length == 0}
	 */
	public static final int min(int[] values, int offset, int length) {
		int min = Integer.MAX_VALUE;
		int offLen = offset + length;
		for(int i = offset; i < offLen; i++) {
			if(min > values[i]) { min = values[i]; }
		}
		return min;
	}


	/** Get the maximum value in an array subset
	 * @param values the array to search
	 * @return the minimum value found in the array subset specified or {@link Integer#MIN_VALUE} if the array is empty (0 length)
	 */
	public static final int max(int[] values) {
		return max(values, 0, values.length);
	}


	/** Get the maximum value in an array subset
	 * @param values the array to search
	 * @param offset the offset into the array at which to start searching
	 * @param length the number of values to search
	 * @return the minimum value found in the array subset specified or {@link Integer#MIN_VALUE} if the {@code length == 0}
	 */
	public static final int max(int[] values, int offset, int length) {
		int max = Integer.MIN_VALUE;
		int offLen = offset + length;
		for(int i = offset; i < offLen; i++) {
			if(max < values[i]) { max = values[i]; }
		}
		return max;
	}
	// end int array methods


	// start long array methods
	/** Convert a set of long values to an array
	 * @param values the set of values
	 * @return the array of values
	 */
	public static final long[] asArray(long... values) {
		return values;
	}


	/** Search for a matching long in an array of longs
	 * @param ary the array of values to search
	 * @param value the value to search for
	 * @return the index of the matching value, or -1 if the {@code value} could not be found
	 */
	public static final int indexOf(long[] ary, long value) {
		return indexOf(ary, 0, ary.length, value);
	}


	/** Search for a matching long in an array of longs
	 * @param ary the array of values to search
	 * @param off the offset into {@code ary} at which to start searching for values
	 * @param len the number of values to search for starting at {@code off} in {@code ary}
	 * @param value the value to search for
	 * @return the index of the matching value, or -1 if the {@code value} could not be found
	 */
	public static final int indexOf(long[] ary, int off, int len, long value) {
		for(int i = off, size = off + len; i < size; i++) {
			if(ary[i] == (value)) { return i; }
		}
		return -1;
	}



	/** Search for the last matching long in an array of longs
	 * @param ary the array of values to search
	 * @param value the value to search for
	 * @return the index of the matching value, or -1 if the {@code value} could not be found
	 */
	public static final int lastIndexOf(long[] ary, long value) {
		return lastIndexOf(ary, 0, ary.length, value);
	}


	/** Search for the last matching long in an array of longs
	 * @param ary the array of values to search
	 * @param off the offset into {@code ary} at which to stop searching for values
	 * @param len the number of values to search for starting at {@code off + len} in {@code ary}
	 * @param value the value to search for
	 * @return the index of the matching value, or -1 if the {@code value} could not be found
	 */
	public static final int lastIndexOf(long[] ary, int off, int len, long value) {
		for(int i = off + len - 1; i >= off; i--) {
			if(ary[i] == (value)) { return i; }
		}
		return -1;
	}



	/** Return an array containing a copy of all of the input arrays
	 * @param arys the input arrays, cannot be null, cannot contain null
	 * @return a new array containing a shallow copy of all the input arrays
	 */
	public static final long[] concat(long[]... arys) {
		int totalSize = 0;
		for(long[] ary : arys) {
			totalSize += ary.length;
		}

		long[] r = new long[totalSize];

		int offset = 0;
		for(long[] ary : arys) {
			System.arraycopy(ary, 0, r, offset, ary.length);
			offset += ary.length;
		}

		return r;
	}


	/** Return an array containing a copy of array {@code a} and {@code b}
	 * @param a the first array
	 * @param b the second array
	 * @return a new array containing a shallow copy of both arrays
	 */
	public static final long[] concat(long[] a, long[] b) {
		long[] r = Arrays.copyOf(a, a.length + b.length);
		System.arraycopy(b, 0, r, a.length, b.length);
		return r;
	}


	/** @see #concat(long[], int, int, long[], int, int, int, int)
	 */
	public static final long[] concat(long[] a, long[] b, int dstOff, int dstTotalLength) {
		return concat(a, 0, a.length, b, 0, b.length, dstOff, dstTotalLength);
	}


	/** Return a new array containing a copy of array {@code a} and {@code b}
	 * @param a the first array
	 * @param b the second array
	 * @param dstOff the offset into {@code dst} at which to append array {@code a} and {@code b}
	 * @param dstTotalLength the total length of the new array to return
	 * @return a new array containing a shallow copy of both arrays
	 */
	public static final long[] concat(long[] a, int offA, int lenA, long[] b, int offB, int lenB, int dstOff, int dstTotalLength) {
		long[] dst = new long[dstTotalLength];
		System.arraycopy(a, offA, dst, dstOff, lenA);
		System.arraycopy(b, offB, dst, dstOff + lenA, lenB);
		return dst;
	}


	/** @see #concat(long[], int, int, long[], int, int, long[], int)
	 */
	public static final long[] concat(long[] a, long[] b, long[] dst, int dstOff) {
		return concat(a, 0, a.length, b, 0, b.length, dst, dstOff);
	}


	/** Return an array containing a copy of array {@code a} and {@code b}
	 * @param a the first array
	 * @param b the second array
	 * @param dst the destination array to store the copied elements in
	 * @param dstOff the offset into {@code dst} at which to append array {@code a} and {@code b}
	 * @return a new array containing a shallow copy of both arrays
	 */
	public static final long[] concat(long[] a, int offA, int lenA, long[] b, int offB, int lenB, long[] dst, int dstOff) {
		System.arraycopy(a, offA, dst, dstOff, lenA);
		System.arraycopy(b, offB, dst, dstOff + lenA, lenB);
		return dst;
	}


	/** Create a string of values from a sub-array
	 * @param ary the array
	 * @param off the offset into {@code ary} at which to converting elements to strings
	 * @param len the number of elements from {@code ary} to convert to strings
	 * @return a string representation of a sub-array
	 */
	public static final String toString(long[] ary, int off, int len) {
		if(ary == null) {
			return "null";
		}

		int maxI = len - 1;

		if(maxI < 0) {
			return "[]";
		}

		StringBuilder strB = new StringBuilder();
		strB.append('[');
		for(int i = 0; i < maxI; i++) {
			strB.append(ary[off + i]);
			strB.append(',');
			strB.append(' ');
		}
		strB.append(ary[off + maxI]);
		strB.append(']');
		return strB.toString();		
	}


	/** Compare two sub-arrays for equality to one another
	 * @param a the first array to compare
	 * @param offA the offset into {@code a} at which to start comparing
	 * @param b the second array to compare
	 * @param offB the offset into {@code b} at which to start comparing
	 * @param len the number of elements from {@code a} to compare to elements from {@code b}
	 * @return true if {@code len} number of elements from {@code a} and {@code b} are equal, false
	 * if one or more elements are not equal
	 */
	public static final boolean equals(long[] a, int offA, long[] b, int offB, int len) {
		if(a == b) {
			return true;
		}
		if(a == null || b == null) {
			return false;
		}

		for(int i = 0; i < len; i++) {
			long objA = a[offA + i];
			long objB = b[offB + i];
			if(objA != objB) {
				return false;
			}
		}
		return true;		
	}


	/** Reverse an long array.<br>
	 * For example {@code ary=[0, 1, 2, 3]}, the result would be {@code ary=[3, 2, 1, 0]}.
	 * @param ary the array to reverse a portion of
	 */
	public static final long[] reverse(long[] ary) {
		return reverse(ary, 0, ary.length);
	}


	/** Reverse a subset of an long array.<br>
	 * For example {@code ary=[0, 1, 2, 3, 4, 5]} and {@code offset=2} and {@code length=3},
	 * the result would be {@code ary=[0, 1, 4, 3, 2, 5]}.
	 * @param ary the array to reverse a portion of
	 * @param offset the offset into the array at which to begin reversing the order of elements
	 * @param length the number of elements to reverse
	 */
	public static final long[] reverse(long[] ary, int offset, int length) {
		final int len = length/2;
		for(int i = 0; i < len; i++) {
			long temp = ary[offset + i];
			int i2 = offset + length - i - 1;
			ary[offset + i] = ary[i2];
			ary[i2] = temp;
		}
		return ary;
	}


	/** Check array not null and bounds.<br>
	 * @param ary the array to check
	 * @param off the offset being checked
	 * @param len the length being checked
	 * @return true if the bounds are valid, false if not
	 */
	public static final boolean checkBounds(long[] ary, int off, int len) {
		return ary != null && off > -1 && len > -1 && off + len <= ary.length;
	}


	/** Check array not null and bounds.<br>
	 * @param ary the array to check
	 * @param off the offset being checked
	 * @param len the length being checked
	 * @throws ArrayIndexOutOfBoundsException if the index is out of bounds
	 * @throws NullPointerException if ary is null
	 */
	public static final void checkBoundsThrows(long[] ary, int off, int len) {
		if(ary == null) {
			throw new NullPointerException("array cannot be null");
		}
		if(off < 0) {
			throw new ArrayIndexOutOfBoundsException("offset must be great than -1: " + off);
		}
		if(len < 0) {
			throw new ArrayIndexOutOfBoundsException("length must be great than -1: " + len);
		}
		if(off + len > ary.length) {
			throw new ArrayIndexOutOfBoundsException("array size=" + ary.length + ", off=" + off + ", len=" + len);
		}
	}


	/** Alias for {@link #primitiveToWrapper(long[], int, int, Long[], int)}
	 */
	public static final Long[] primitiveToWrapper(long[] srcAry) {
		return primitiveToWrapper(srcAry, 0, srcAry.length, new Long[srcAry.length], 0);
	}


	/**
	 * @param srcAry the source primitive type array
	 * @param srcOff the source index offset at which to start copying elements
	 * @param srcLen the number of source elements to copy
	 * @param dst the destination primitive wrapper type array to store the elements in
	 * @param dstOff the offset into the destination array at which to start storing the copied elements
	 * @return the {@code dst} array
	 */
	public static final Long[] primitiveToWrapper(long[] srcAry, int srcOff, int srcLen, Long[] dst, int dstOff) {
		for(int i = 0; i < srcLen; i++) {
			dst[dstOff + i] = srcAry[srcOff + i];
		}
		return dst;
	}


	/** Alias for {@link #wrapperToPrimitive(Long[], int, int, long[], int)}
	 */
	public static final long[] wrapperToPrimitive(Long[] srcAry) {
		return wrapperToPrimitive(srcAry, 0, srcAry.length, new long[srcAry.length], 0);
	}


	/**
	 * @param srcAry the source primitive wrapper type array
	 * @param srcOff the source index offset at which to start copying elements
	 * @param srcLen the number of source elements to copy
	 * @param dst the destination primitive type array to store the elements in
	 * @param dstOff the offset into the destination array at which to start storing the copied elements
	 * @return the {@code dst} array
	 */
	public static final long[] wrapperToPrimitive(Long[] srcAry, int srcOff, int srcLen, long[] dst, int dstOff) {
		for(int i = 0; i < srcLen; i++) {
			dst[dstOff + i] = srcAry[srcOff + i];
		}
		return dst;
	}


	/** Sum of an array
	 * @param ary the array of integers to sum
	 * @return the sum of all of the elements in the specified array
	 */
	public static final long sum(long[] ary) {
		return sum(ary, 0, ary.length);
	}


	/** Sum of the subset of an array
	 * @param ary the array of longs to sum
	 * @param offset the offset into the array at which to start summing values
	 * @param length the number of elements to sum from the array starting
	 * at {@code offset}
	 * @return the sum of the specified array subset
	 */
	public static final long sum(long[] ary, int offset, int length) {
		int offLen = offset + length;
		long sum = 0L;
		for(int i = offset; i < offLen; i++) {
			sum += ary[i];
		}
		return sum;
	}


	/** The average of an array
	 * @param values the array of values to average
	 * @return the average of the array
	 */
	public static final double avg(long[] values) {
		return avg(values, 0, values.length);
	}


	/** The average of a subset of an array
	 * @param values the array of values to average
	 * @param offset the offset into the array at which to start averaging values
	 * @param length the number of values to average from the array
	 * @return the average of the array subset specified
	 */
	public static final double avg(long[] values, int offset, int length) {
		long total = 0;
		int offLen = offset + length;
		for(int i = offset; i < offLen; i++) {
			total += values[i];
		}
		return total/(double)length;
	}


	/** Get the minimum value in an array subset
	 * @param values the array to search
	 * @return the minimum value found in the array subset specified or {@link Long#MAX_VALUE} if the array is empty (0 length)
	 */
	public static final long min(long[] values) {
		return min(values, 0, values.length);
	}


	/** Get the minimum value in an array subset
	 * @param values the array to search
	 * @param offset the offset into the array at which to start searching
	 * @param length the number of values to search
	 * @return the minimum value found in the array subset specified or {@link Long#MAX_VALUE} if {@code length == 0}
	 */
	public static final long min(long[] values, int offset, int length) {
		long min = Long.MAX_VALUE;
		int offLen = offset + length;
		for(int i = offset; i < offLen; i++) {
			if(min > values[i]) { min = values[i]; }
		}
		return min;
	}


	/** Get the maximum value in an array subset
	 * @param values the array to search
	 * @return the minimum value found in the array subset specified or {@link Long#MIN_VALUE} if the array is empty (0 length)
	 */
	public static final long max(long[] values) {
		return max(values, 0, values.length);
	}


	/** Get the maximum value in an array subset
	 * @param values the array to search
	 * @param offset the offset into the array at which to start searching
	 * @param length the number of values to search
	 * @return the minimum value found in the array subset specified or {@link Long#MIN_VALUE} if the {@code length == 0}
	 */
	public static final long max(long[] values, int offset, int length) {
		long max = Long.MIN_VALUE;
		int offLen = offset + length;
		for(int i = offset; i < offLen; i++) {
			if(max < values[i]) { max = values[i]; }
		}
		return max;
	}
	// end long array methods


	// start float array methods
	/** Convert a set of float values to an array
	 * @param values the set of values
	 * @return the array of values
	 */
	public static final float[] asArray(float... values) {
		return values;
	}


	/** Search for a matching float in an array of floats
	 * @param ary the array of values to search
	 * @param value the value to search for
	 * @return the index of the matching value, or -1 if the {@code value} could not be found
	 */
	public static final int indexOf(float[] ary, float value) {
		return indexOf(ary, 0, ary.length, value);
	}


	/** Search for a matching float in an array of floats
	 * @param ary the array of values to search
	 * @param off the offset into {@code ary} at which to start searching for values
	 * @param len the number of values to search for starting at {@code off} in {@code ary}
	 * @param value the value to search for
	 * @return the index of the matching value, or -1 if the {@code value} could not be found
	 */
	public static final int indexOf(float[] ary, int off, int len, float value) {
		for(int i = off, size = off + len; i < size; i++) {
			if(ary[i] == (value)) { return i; }
		}
		return -1;
	}



	/** Search for the last matching float in an array of floats
	 * @param ary the array of values to search
	 * @param value the value to search for
	 * @return the index of the matching value, or -1 if the {@code value} could not be found
	 */
	public static final int lastIndexOf(float[] ary, float value) {
		return lastIndexOf(ary, 0, ary.length, value);
	}


	/** Search for the last matching float in an array of floats
	 * @param ary the array of values to search
	 * @param off the offset into {@code ary} at which to stop searching for values
	 * @param len the number of values to search for starting at {@code off + len} in {@code ary}
	 * @param value the value to search for
	 * @return the index of the matching value, or -1 if the {@code value} could not be found
	 */
	public static final int lastIndexOf(float[] ary, int off, int len, float value) {
		for(int i = off + len - 1; i >= off; i--) {
			if(ary[i] == (value)) { return i; }
		}
		return -1;
	}



	/** Return an array containing a copy of all of the input arrays
	 * @param arys the input arrays, cannot be null, cannot contain null
	 * @return a new array containing a shallow copy of all the input arrays
	 */
	public static final float[] concat(float[]... arys) {
		int totalSize = 0;
		for(float[] ary : arys) {
			totalSize += ary.length;
		}

		float[] r = new float[totalSize];

		int offset = 0;
		for(float[] ary : arys) {
			System.arraycopy(ary, 0, r, offset, ary.length);
			offset += ary.length;
		}

		return r;
	}


	/** Return an array containing a copy of array {@code a} and {@code b}
	 * @param a the first array
	 * @param b the second array
	 * @return a new array containing a shallow copy of both arrays
	 */
	public static final float[] concat(float[] a, float[] b) {
		float[] r = Arrays.copyOf(a, a.length + b.length);
		System.arraycopy(b, 0, r, a.length, b.length);
		return r;
	}


	/** @see #concat(float[], int, int, float[], int, int, int, int)
	 */
	public static final float[] concat(float[] a, float[] b, int dstOff, int dstTotalLength) {
		return concat(a, 0, a.length, b, 0, b.length, dstOff, dstTotalLength);
	}


	/** Return a new array containing a copy of array {@code a} and {@code b}
	 * @param a the first array
	 * @param b the second array
	 * @param dstOff the offset into {@code dst} at which to append array {@code a} and {@code b}
	 * @param dstTotalLength the total length of the new array to return
	 * @return a new array containing a shallow copy of both arrays
	 */
	public static final float[] concat(float[] a, int offA, int lenA, float[] b, int offB, int lenB, int dstOff, int dstTotalLength) {
		float[] dst = new float[dstTotalLength];
		System.arraycopy(a, offA, dst, dstOff, lenA);
		System.arraycopy(b, offB, dst, dstOff + lenA, lenB);
		return dst;
	}


	/** @see #concat(float[], int, int, float[], int, int, float[], int)
	 */
	public static final float[] concat(float[] a, float[] b, float[] dst, int dstOff) {
		return concat(a, 0, a.length, b, 0, b.length, dst, dstOff);
	}


	/** Return an array containing a copy of array {@code a} and {@code b}
	 * @param a the first array
	 * @param b the second array
	 * @param dst the destination array to store the copied elements in
	 * @param dstOff the offset into {@code dst} at which to append array {@code a} and {@code b}
	 * @return a new array containing a shallow copy of both arrays
	 */
	public static final float[] concat(float[] a, int offA, int lenA, float[] b, int offB, int lenB, float[] dst, int dstOff) {
		System.arraycopy(a, offA, dst, dstOff, lenA);
		System.arraycopy(b, offB, dst, dstOff + lenA, lenB);
		return dst;
	}


	/** Create a string of values from a sub-array
	 * @param ary the array
	 * @param off the offset into {@code ary} at which to converting elements to strings
	 * @param len the number of elements from {@code ary} to convert to strings
	 * @return a string representation of a sub-array
	 */
	public static final String toString(float[] ary, int off, int len) {
		if(ary == null) {
			return "null";
		}

		int maxI = len - 1;

		if(maxI < 0) {
			return "[]";
		}

		StringBuilder strB = new StringBuilder();
		strB.append('[');
		for(int i = 0; i < maxI; i++) {
			strB.append(ary[off + i]);
			strB.append(',');
			strB.append(' ');
		}
		strB.append(ary[off + maxI]);
		strB.append(']');
		return strB.toString();		
	}


	/** Compare two sub-arrays for equality to one another
	 * @param a the first array to compare
	 * @param offA the offset into {@code a} at which to start comparing
	 * @param b the second array to compare
	 * @param offB the offset into {@code b} at which to start comparing
	 * @param len the number of elements from {@code a} to compare to elements from {@code b}
	 * @return true if {@code len} number of elements from {@code a} and {@code b} are equal, false
	 * if one or more elements are not equal
	 */
	public static final boolean equals(float[] a, int offA, float[] b, int offB, int len) {
		if(a == b) {
			return true;
		}
		if(a == null || b == null) {
			return false;
		}

		for(int i = 0; i < len; i++) {
			float objA = a[offA + i];
			float objB = b[offB + i];
			if(objA != objB) {
				return false;
			}
		}
		return true;		
	}


	/** Reverse an float array.<br>
	 * For example {@code ary=[0, 1, 2, 3]}, the result would be {@code ary=[3, 2, 1, 0]}.
	 * @param ary the array to reverse a portion of
	 */
	public static final float[] reverse(float[] ary) {
		return reverse(ary, 0, ary.length);
	}


	/** Reverse a subset of an float array.<br>
	 * For example {@code ary=[0, 1, 2, 3, 4, 5]} and {@code offset=2} and {@code length=3},
	 * the result would be {@code ary=[0, 1, 4, 3, 2, 5]}.
	 * @param ary the array to reverse a portion of
	 * @param offset the offset into the array at which to begin reversing the order of elements
	 * @param length the number of elements to reverse
	 */
	public static final float[] reverse(float[] ary, int offset, int length) {
		final int len = length/2;
		for(int i = 0; i < len; i++) {
			float temp = ary[offset + i];
			int i2 = offset + length - i - 1;
			ary[offset + i] = ary[i2];
			ary[i2] = temp;
		}
		return ary;
	}


	/** Check array not null and bounds.<br>
	 * @param ary the array to check
	 * @param off the offset being checked
	 * @param len the length being checked
	 * @return true if the bounds are valid, false if not
	 */
	public static final boolean checkBounds(float[] ary, int off, int len) {
		return ary != null && off > -1 && len > -1 && off + len <= ary.length;
	}


	/** Check array not null and bounds.<br>
	 * @param ary the array to check
	 * @param off the offset being checked
	 * @param len the length being checked
	 * @throws ArrayIndexOutOfBoundsException if the index is out of bounds
	 * @throws NullPointerException if ary is null
	 */
	public static final void checkBoundsThrows(float[] ary, int off, int len) {
		if(ary == null) {
			throw new NullPointerException("array cannot be null");
		}
		if(off < 0) {
			throw new ArrayIndexOutOfBoundsException("offset must be great than -1: " + off);
		}
		if(len < 0) {
			throw new ArrayIndexOutOfBoundsException("length must be great than -1: " + len);
		}
		if(off + len > ary.length) {
			throw new ArrayIndexOutOfBoundsException("array size=" + ary.length + ", off=" + off + ", len=" + len);
		}
	}


	/** Alias for {@link #primitiveToWrapper(float[], int, int, Float[], int)}
	 */
	public static final Float[] primitiveToWrapper(float[] srcAry) {
		return primitiveToWrapper(srcAry, 0, srcAry.length, new Float[srcAry.length], 0);
	}


	/**
	 * @param srcAry the source primitive type array
	 * @param srcOff the source index offset at which to start copying elements
	 * @param srcLen the number of source elements to copy
	 * @param dst the destination primitive wrapper type array to store the elements in
	 * @param dstOff the offset into the destination array at which to start storing the copied elements
	 * @return the {@code dst} array
	 */
	public static final Float[] primitiveToWrapper(float[] srcAry, int srcOff, int srcLen, Float[] dst, int dstOff) {
		for(int i = 0; i < srcLen; i++) {
			dst[dstOff + i] = srcAry[srcOff + i];
		}
		return dst;
	}


	/** Alias for {@link #wrapperToPrimitive(Float[], int, int, float[], int)}
	 */
	public static final float[] wrapperToPrimitive(Float[] srcAry) {
		return wrapperToPrimitive(srcAry, 0, srcAry.length, new float[srcAry.length], 0);
	}


	/**
	 * @param srcAry the source primitive wrapper type array
	 * @param srcOff the source index offset at which to start copying elements
	 * @param srcLen the number of source elements to copy
	 * @param dst the destination primitive type array to store the elements in
	 * @param dstOff the offset into the destination array at which to start storing the copied elements
	 * @return the {@code dst} array
	 */
	public static final float[] wrapperToPrimitive(Float[] srcAry, int srcOff, int srcLen, float[] dst, int dstOff) {
		for(int i = 0; i < srcLen; i++) {
			dst[dstOff + i] = srcAry[srcOff + i];
		}
		return dst;
	}


	/** Sum of an array
	 * @param ary the array of integers to sum
	 * @return the sum of all of the elements in the specified array
	 */
	public static final float sum(float[] ary) {
		return sum(ary, 0, ary.length);
	}


	/** Sum of the subset of an array
	 * @param ary the array of floats to sum
	 * @param offset the offset into the array at which to start summing values
	 * @param length the number of elements to sum from the array starting
	 * at {@code offset}
	 * @return the sum of the specified array subset
	 */
	public static final float sum(float[] ary, int offset, int length) {
		int offLen = offset + length;
		float sum = 0f;
		for(int i = offset; i < offLen; i++) {
			sum += ary[i];
		}
		return sum;
	}


	/** The average of an array
	 * @param values the array of values to average
	 * @return the average of the array
	 */
	public static final float avg(float[] values) {
		return avg(values, 0, values.length);
	}


	/** The average of a subset of an array
	 * @param values the array of values to average
	 * @param offset the offset into the array at which to start averaging values
	 * @param length the number of values to average from the array
	 * @return the average of the array subset specified
	 */
	public static final float avg(float[] values, int offset, int length) {
		float total = 0;
		int offLen = offset + length;
		for(int i = offset; i < offLen; i++) {
			total += values[i];
		}
		return total/(float)length;
	}


	/** Get the minimum value in an array subset
	 * @param values the array to search
	 * @return the minimum value found in the array subset specified or {@link Float#MAX_VALUE} if the array is empty (0 length)
	 */
	public static final float min(float[] values) {
		return min(values, 0, values.length);
	}


	/** Get the minimum value in an array subset
	 * @param values the array to search
	 * @param offset the offset into the array at which to start searching
	 * @param length the number of values to search
	 * @return the minimum value found in the array subset specified or {@link Float#MAX_VALUE} if {@code length == 0}
	 */
	public static final float min(float[] values, int offset, int length) {
		float min = Float.MAX_VALUE;
		int offLen = offset + length;
		for(int i = offset; i < offLen; i++) {
			if(min > values[i]) { min = values[i]; }
		}
		return min;
	}


	/** Get the maximum value in an array subset
	 * @param values the array to search
	 * @return the minimum value found in the array subset specified or {@link Float#MIN_VALUE} if the array is empty (0 length)
	 */
	public static final float max(float[] values) {
		return max(values, 0, values.length);
	}


	/** Get the maximum value in an array subset
	 * @param values the array to search
	 * @param offset the offset into the array at which to start searching
	 * @param length the number of values to search
	 * @return the minimum value found in the array subset specified or {@link Float#MIN_VALUE} if the {@code length == 0}
	 */
	public static final float max(float[] values, int offset, int length) {
		float max = Float.MIN_VALUE;
		int offLen = offset + length;
		for(int i = offset; i < offLen; i++) {
			if(max < values[i]) { max = values[i]; }
		}
		return max;
	}
	// end float array methods


	// start double array methods
	/** Convert a set of double values to an array
	 * @param values the set of values
	 * @return the array of values
	 */
	public static final double[] asArray(double... values) {
		return values;
	}


	/** Search for a matching double in an array of doubles
	 * @param ary the array of values to search
	 * @param value the value to search for
	 * @return the index of the matching value, or -1 if the {@code value} could not be found
	 */
	public static final int indexOf(double[] ary, double value) {
		return indexOf(ary, 0, ary.length, value);
	}


	/** Search for a matching double in an array of doubles
	 * @param ary the array of values to search
	 * @param off the offset into {@code ary} at which to start searching for values
	 * @param len the number of values to search for starting at {@code off} in {@code ary}
	 * @param value the value to search for
	 * @return the index of the matching value, or -1 if the {@code value} could not be found
	 */
	public static final int indexOf(double[] ary, int off, int len, double value) {
		for(int i = off, size = off + len; i < size; i++) {
			if(ary[i] == (value)) { return i; }
		}
		return -1;
	}



	/** Search for the last matching double in an array of doubles
	 * @param ary the array of values to search
	 * @param value the value to search for
	 * @return the index of the matching value, or -1 if the {@code value} could not be found
	 */
	public static final int lastIndexOf(double[] ary, double value) {
		return lastIndexOf(ary, 0, ary.length, value);
	}


	/** Search for the last matching double in an array of doubles
	 * @param ary the array of values to search
	 * @param off the offset into {@code ary} at which to stop searching for values
	 * @param len the number of values to search for starting at {@code off + len} in {@code ary}
	 * @param value the value to search for
	 * @return the index of the matching value, or -1 if the {@code value} could not be found
	 */
	public static final int lastIndexOf(double[] ary, int off, int len, double value) {
		for(int i = off + len - 1; i >= off; i--) {
			if(ary[i] == (value)) { return i; }
		}
		return -1;
	}



	/** Return an array containing a copy of all of the input arrays
	 * @param arys the input arrays, cannot be null, cannot contain null
	 * @return a new array containing a shallow copy of all the input arrays
	 */
	public static final double[] concat(double[]... arys) {
		int totalSize = 0;
		for(double[] ary : arys) {
			totalSize += ary.length;
		}

		double[] r = new double[totalSize];

		int offset = 0;
		for(double[] ary : arys) {
			System.arraycopy(ary, 0, r, offset, ary.length);
			offset += ary.length;
		}

		return r;
	}


	/** Return an array containing a copy of array {@code a} and {@code b}
	 * @param a the first array
	 * @param b the second array
	 * @return a new array containing a shallow copy of both arrays
	 */
	public static final double[] concat(double[] a, double[] b) {
		double[] r = Arrays.copyOf(a, a.length + b.length);
		System.arraycopy(b, 0, r, a.length, b.length);
		return r;
	}


	/** @see #concat(double[], int, int, double[], int, int, int, int)
	 */
	public static final double[] concat(double[] a, double[] b, int dstOff, int dstTotalLength) {
		return concat(a, 0, a.length, b, 0, b.length, dstOff, dstTotalLength);
	}


	/** Return a new array containing a copy of array {@code a} and {@code b}
	 * @param a the first array
	 * @param b the second array
	 * @param dstOff the offset into {@code dst} at which to append array {@code a} and {@code b}
	 * @param dstTotalLength the total length of the new array to return
	 * @return a new array containing a shallow copy of both arrays
	 */
	public static final double[] concat(double[] a, int offA, int lenA, double[] b, int offB, int lenB, int dstOff, int dstTotalLength) {
		double[] dst = new double[dstTotalLength];
		System.arraycopy(a, offA, dst, dstOff, lenA);
		System.arraycopy(b, offB, dst, dstOff + lenA, lenB);
		return dst;
	}


	/** @see #concat(double[], int, int, double[], int, int, double[], int)
	 */
	public static final double[] concat(double[] a, double[] b, double[] dst, int dstOff) {
		return concat(a, 0, a.length, b, 0, b.length, dst, dstOff);
	}


	/** Return an array containing a copy of array {@code a} and {@code b}
	 * @param a the first array
	 * @param b the second array
	 * @param dst the destination array to store the copied elements in
	 * @param dstOff the offset into {@code dst} at which to append array {@code a} and {@code b}
	 * @return a new array containing a shallow copy of both arrays
	 */
	public static final double[] concat(double[] a, int offA, int lenA, double[] b, int offB, int lenB, double[] dst, int dstOff) {
		System.arraycopy(a, offA, dst, dstOff, lenA);
		System.arraycopy(b, offB, dst, dstOff + lenA, lenB);
		return dst;
	}


	/** Create a string of values from a sub-array
	 * @param ary the array
	 * @param off the offset into {@code ary} at which to converting elements to strings
	 * @param len the number of elements from {@code ary} to convert to strings
	 * @return a string representation of a sub-array
	 */
	public static final String toString(double[] ary, int off, int len) {
		if(ary == null) {
			return "null";
		}

		int maxI = len - 1;

		if(maxI < 0) {
			return "[]";
		}

		StringBuilder strB = new StringBuilder();
		strB.append('[');
		for(int i = 0; i < maxI; i++) {
			strB.append(ary[off + i]);
			strB.append(',');
			strB.append(' ');
		}
		strB.append(ary[off + maxI]);
		strB.append(']');
		return strB.toString();		
	}


	/** Compare two sub-arrays for equality to one another
	 * @param a the first array to compare
	 * @param offA the offset into {@code a} at which to start comparing
	 * @param b the second array to compare
	 * @param offB the offset into {@code b} at which to start comparing
	 * @param len the number of elements from {@code a} to compare to elements from {@code b}
	 * @return true if {@code len} number of elements from {@code a} and {@code b} are equal, false
	 * if one or more elements are not equal
	 */
	public static final boolean equals(double[] a, int offA, double[] b, int offB, int len) {
		if(a == b) {
			return true;
		}
		if(a == null || b == null) {
			return false;
		}

		for(int i = 0; i < len; i++) {
			double objA = a[offA + i];
			double objB = b[offB + i];
			if(objA != objB) {
				return false;
			}
		}
		return true;		
	}


	/** Reverse an double array.<br>
	 * For example {@code ary=[0, 1, 2, 3]}, the result would be {@code ary=[3, 2, 1, 0]}.
	 * @param ary the array to reverse a portion of
	 */
	public static final double[] reverse(double[] ary) {
		return reverse(ary, 0, ary.length);
	}


	/** Reverse a subset of an double array.<br>
	 * For example {@code ary=[0, 1, 2, 3, 4, 5]} and {@code offset=2} and {@code length=3},
	 * the result would be {@code ary=[0, 1, 4, 3, 2, 5]}.
	 * @param ary the array to reverse a portion of
	 * @param offset the offset into the array at which to begin reversing the order of elements
	 * @param length the number of elements to reverse
	 */
	public static final double[] reverse(double[] ary, int offset, int length) {
		final int len = length/2;
		for(int i = 0; i < len; i++) {
			double temp = ary[offset + i];
			int i2 = offset + length - i - 1;
			ary[offset + i] = ary[i2];
			ary[i2] = temp;
		}
		return ary;
	}


	/** Check array not null and bounds.<br>
	 * @param ary the array to check
	 * @param off the offset being checked
	 * @param len the length being checked
	 * @return true if the bounds are valid, false if not
	 */
	public static final boolean checkBounds(double[] ary, int off, int len) {
		return ary != null && off > -1 && len > -1 && off + len <= ary.length;
	}


	/** Check array not null and bounds.<br>
	 * @param ary the array to check
	 * @param off the offset being checked
	 * @param len the length being checked
	 * @throws ArrayIndexOutOfBoundsException if the index is out of bounds
	 * @throws NullPointerException if ary is null
	 */
	public static final void checkBoundsThrows(double[] ary, int off, int len) {
		if(ary == null) {
			throw new NullPointerException("array cannot be null");
		}
		if(off < 0) {
			throw new ArrayIndexOutOfBoundsException("offset must be great than -1: " + off);
		}
		if(len < 0) {
			throw new ArrayIndexOutOfBoundsException("length must be great than -1: " + len);
		}
		if(off + len > ary.length) {
			throw new ArrayIndexOutOfBoundsException("array size=" + ary.length + ", off=" + off + ", len=" + len);
		}
	}


	/** Alias for {@link #primitiveToWrapper(double[], int, int, Double[], int)}
	 */
	public static final Double[] primitiveToWrapper(double[] srcAry) {
		return primitiveToWrapper(srcAry, 0, srcAry.length, new Double[srcAry.length], 0);
	}


	/**
	 * @param srcAry the source primitive type array
	 * @param srcOff the source index offset at which to start copying elements
	 * @param srcLen the number of source elements to copy
	 * @param dst the destination primitive wrapper type array to store the elements in
	 * @param dstOff the offset into the destination array at which to start storing the copied elements
	 * @return the {@code dst} array
	 */
	public static final Double[] primitiveToWrapper(double[] srcAry, int srcOff, int srcLen, Double[] dst, int dstOff) {
		for(int i = 0; i < srcLen; i++) {
			dst[dstOff + i] = srcAry[srcOff + i];
		}
		return dst;
	}


	/** Alias for {@link #wrapperToPrimitive(Double[], int, int, double[], int)}
	 */
	public static final double[] wrapperToPrimitive(Double[] srcAry) {
		return wrapperToPrimitive(srcAry, 0, srcAry.length, new double[srcAry.length], 0);
	}


	/**
	 * @param srcAry the source primitive wrapper type array
	 * @param srcOff the source index offset at which to start copying elements
	 * @param srcLen the number of source elements to copy
	 * @param dst the destination primitive type array to store the elements in
	 * @param dstOff the offset into the destination array at which to start storing the copied elements
	 * @return the {@code dst} array
	 */
	public static final double[] wrapperToPrimitive(Double[] srcAry, int srcOff, int srcLen, double[] dst, int dstOff) {
		for(int i = 0; i < srcLen; i++) {
			dst[dstOff + i] = srcAry[srcOff + i];
		}
		return dst;
	}


	/** Sum of an array
	 * @param ary the array of integers to sum
	 * @return the sum of all of the elements in the specified array
	 */
	public static final double sum(double[] ary) {
		return sum(ary, 0, ary.length);
	}


	/** Sum of the subset of an array
	 * @param ary the array of doubles to sum
	 * @param offset the offset into the array at which to start summing values
	 * @param length the number of elements to sum from the array starting
	 * at {@code offset}
	 * @return the sum of the specified array subset
	 */
	public static final double sum(double[] ary, int offset, int length) {
		int offLen = offset + length;
		double sum = 0;
		for(int i = offset; i < offLen; i++) {
			sum += ary[i];
		}
		return sum;
	}


	/** The average of an array
	 * @param values the array of values to average
	 * @return the average of the array
	 */
	public static final double avg(double[] values) {
		return avg(values, 0, values.length);
	}


	/** The average of a subset of an array
	 * @param values the array of values to average
	 * @param offset the offset into the array at which to start averaging values
	 * @param length the number of values to average from the array
	 * @return the average of the array subset specified
	 */
	public static final double avg(double[] values, int offset, int length) {
		double total = 0;
		int offLen = offset + length;
		for(int i = offset; i < offLen; i++) {
			total += values[i];
		}
		return total/(double)length;
	}


	/** Get the minimum value in an array subset
	 * @param values the array to search
	 * @return the minimum value found in the array subset specified or {@link Double#MAX_VALUE} if the array is empty (0 length)
	 */
	public static final double min(double[] values) {
		return min(values, 0, values.length);
	}


	/** Get the minimum value in an array subset
	 * @param values the array to search
	 * @param offset the offset into the array at which to start searching
	 * @param length the number of values to search
	 * @return the minimum value found in the array subset specified or {@link Double#MAX_VALUE} if {@code length == 0}
	 */
	public static final double min(double[] values, int offset, int length) {
		double min = Double.MAX_VALUE;
		int offLen = offset + length;
		for(int i = offset; i < offLen; i++) {
			if(min > values[i]) { min = values[i]; }
		}
		return min;
	}


	/** Get the maximum value in an array subset
	 * @param values the array to search
	 * @return the minimum value found in the array subset specified or {@link Double#MIN_VALUE} if the array is empty (0 length)
	 */
	public static final double max(double[] values) {
		return max(values, 0, values.length);
	}


	/** Get the maximum value in an array subset
	 * @param values the array to search
	 * @param offset the offset into the array at which to start searching
	 * @param length the number of values to search
	 * @return the minimum value found in the array subset specified or {@link Double#MIN_VALUE} if the {@code length == 0}
	 */
	public static final double max(double[] values, int offset, int length) {
		double max = Double.MIN_VALUE;
		int offLen = offset + length;
		for(int i = offset; i < offLen; i++) {
			if(max < values[i]) { max = values[i]; }
		}
		return max;
	}
	// end double array methods


	// start T array methods
	/** Convert a set of T values to an array
	 * @param values the set of values
	 * @return the array of values
	 */
	@SafeVarargs
	public static final <T> T[] asArray(T... values) {
		return values;
	}


	/** Search for a matching T in an array of Ts
	 * @param ary the array of values to search
	 * @param value the value to search for
	 * @return the index of the matching value, or -1 if the {@code value} could not be found
	 */
	public static final <T> int indexOf(T[] ary, T value) {
		return indexOf(ary, 0, ary.length, value);
	}


	/** Search for a matching T in an array of Ts
	 * @param ary the array of values to search
	 * @param off the offset into {@code ary} at which to start searching for values
	 * @param len the number of values to search for starting at {@code off} in {@code ary}
	 * @param value the value to search for
	 * @return the index of the matching value, or -1 if the {@code value} could not be found
	 */
	public static final <T> int indexOf(T[] ary, int off, int len, T value) {
		for(int i = off, size = off + len; i < size; i++) {
			if(ary[i].equals(value)) { return i; }
		}
		return -1;
	}


	/** @see #indexOf(Object[], int, int, Object)
	 */
	public static final <T> int indexOfRef(T[] ary, int off, int len, T value) {
		for(int i = off, size = off + len; i < size; i++) {
			if(ary[i] == value) { return i; }
		}
		return -1;
	}


	/** Search for the last matching T in an array of Ts
	 * @param ary the array of values to search
	 * @param value the value to search for
	 * @return the index of the matching value, or -1 if the {@code value} could not be found
	 */
	public static final <T> int lastIndexOf(T[] ary, T value) {
		return lastIndexOf(ary, 0, ary.length, value);
	}


	/** Search for the last matching T in an array of Ts
	 * @param ary the array of values to search
	 * @param off the offset into {@code ary} at which to stop searching for values
	 * @param len the number of values to search for starting at {@code off + len} in {@code ary}
	 * @param value the value to search for
	 * @return the index of the matching value, or -1 if the {@code value} could not be found
	 */
	public static final <T> int lastIndexOf(T[] ary, int off, int len, T value) {
		for(int i = off + len - 1; i >= off; i--) {
			if(ary[i].equals(value)) { return i; }
		}
		return -1;
	}


	/** @see #lastIndexOf(Object[], int, int, Object)
	 */
	public static final <T> int lastIndexOfRef(T[] ary, int off, int len, T value) {
		for(int i = off + len - 1; i >= off; i--) {
			if(ary[i] == value) { return i; }
		}
		return -1;
	}


	/** Return an array containing a copy of all of the input arrays
	 * @param arys the input arrays, cannot be null, cannot contain null
	 * @return a new array containing a shallow copy of all the input arrays
	 */
	@SafeVarargs
	public static final <T> T[] concat(T[]... arys) {
		int totalSize = 0;
		for(T[] ary : arys) {
			totalSize += ary.length;
		}

		@SuppressWarnings("unchecked")
		T[] r = (T[])new Object[totalSize];

		int offset = 0;
		for(T[] ary : arys) {
			System.arraycopy(ary, 0, r, offset, ary.length);
			offset += ary.length;
		}

		return r;
	}


	/** Return an array containing a copy of array {@code a} and {@code b}
	 * @param a the first array
	 * @param b the second array
	 * @return a new array containing a shallow copy of both arrays
	 */
	public static final <T> T[] concat(T[] a, T[] b) {
		T[] r = Arrays.copyOf(a, a.length + b.length);
		System.arraycopy(b, 0, r, a.length, b.length);
		return r;
	}


	/** @see #concat(Object[], int, int, Object[], int, int, int, int)
	 */
	public static final <T> T[] concat(T[] a, T[] b, int dstOff, int dstTotalLength) {
		return concat(a, 0, a.length, b, 0, b.length, dstOff, dstTotalLength);
	}


	/** Return a new array containing a copy of array {@code a} and {@code b}
	 * @param a the first array
	 * @param b the second array
	 * @param dstOff the offset into {@code dst} at which to append array {@code a} and {@code b}
	 * @param dstTotalLength the total length of the new array to return
	 * @return a new array containing a shallow copy of both arrays
	 */
	@SuppressWarnings("unchecked")
	public static final <T> T[] concat(T[] a, int offA, int lenA, T[] b, int offB, int lenB, int dstOff, int dstTotalLength) {
		Object[] dst = new Object[dstTotalLength];
		System.arraycopy(a, offA, dst, dstOff, lenA);
		System.arraycopy(b, offB, dst, dstOff + lenA, lenB);
		return (T[])dst;
	}


	/** @see #concat(Object[], int, int, Object[], int, int, Object[], int)
	 */
	public static final <T> T[] concat(T[] a, T[] b, T[] dst, int dstOff) {
		return concat(a, 0, a.length, b, 0, b.length, dst, dstOff);
	}


	/** Return an array containing a copy of array {@code a} and {@code b}
	 * @param a the first array
	 * @param b the second array
	 * @param dst the destination array to store the copied elements in
	 * @param dstOff the offset into {@code dst} at which to append array {@code a} and {@code b}
	 * @return a new array containing a shallow copy of both arrays
	 */
	public static final <T> T[] concat(T[] a, int offA, int lenA, T[] b, int offB, int lenB, T[] dst, int dstOff) {
		System.arraycopy(a, offA, dst, dstOff, lenA);
		System.arraycopy(b, offB, dst, dstOff + lenA, lenB);
		return dst;
	}


	/** Create a string of values from a sub-array
	 * @param ary the array
	 * @param off the offset into {@code ary} at which to converting elements to strings
	 * @param len the number of elements from {@code ary} to convert to strings
	 * @return a string representation of a sub-array
	 */
	public static final <T> String toString(T[] ary, int off, int len) {
		if(ary == null) {
			return "null";
		}

		int maxI = len - 1;

		if(maxI < 0) {
			return "[]";
		}

		StringBuilder strB = new StringBuilder();
		strB.append('[');
		for(int i = 0; i < maxI; i++) {
			strB.append(ary[off + i]);
			strB.append(',');
			strB.append(' ');
		}
		strB.append(ary[off + maxI]);
		strB.append(']');
		return strB.toString();		
	}


	/** Compare two sub-arrays for equality to one another
	 * @param a the first array to compare
	 * @param offA the offset into {@code a} at which to start comparing
	 * @param b the second array to compare
	 * @param offB the offset into {@code b} at which to start comparing
	 * @param len the number of elements from {@code a} to compare to elements from {@code b}
	 * @return true if {@code len} number of elements from {@code a} and {@code b} are equal, false
	 * if one or more elements are not equal
	 */
	public static final <T> boolean equals(T[] a, int offA, T[] b, int offB, int len) {
		if(a == b) {
			return true;
		}
		if(a == null || b == null) {
			return false;
		}

		for(int i = 0; i < len; i++) {
			T objA = a[offA + i];
			T objB = b[offB + i];
			if(!(objA == null ? objB == null : objA.equals(objB))) {
				return false;
			}
		}
		return true;		
	}


	/** Reverse an T array.<br>
	 * For example {@code ary=[0, 1, 2, 3]}, the result would be {@code ary=[3, 2, 1, 0]}.
	 * @param ary the array to reverse a portion of
	 */
	public static final <T> T[] reverse(T[] ary) {
		return reverse(ary, 0, ary.length);
	}


	/** Reverse a subset of an T array.<br>
	 * For example {@code ary=[0, 1, 2, 3, 4, 5]} and {@code offset=2} and {@code length=3},
	 * the result would be {@code ary=[0, 1, 4, 3, 2, 5]}.
	 * @param ary the array to reverse a portion of
	 * @param offset the offset into the array at which to begin reversing the order of elements
	 * @param length the number of elements to reverse
	 */
	public static final <T> T[] reverse(T[] ary, int offset, int length) {
		final int len = length/2;
		for(int i = 0; i < len; i++) {
			T temp = ary[offset + i];
			int i2 = offset + length - i - 1;
			ary[offset + i] = ary[i2];
			ary[i2] = temp;
		}
		return ary;
	}


	/** Check array not null and bounds.<br>
	 * @param ary the array to check
	 * @param off the offset being checked
	 * @param len the length being checked
	 * @return true if the bounds are valid, false if not
	 */
	public static final <T> boolean checkBounds(T[] ary, int off, int len) {
		return ary != null && off > -1 && len > -1 && off + len <= ary.length;
	}


	/** Check array not null and bounds.<br>
	 * @param ary the array to check
	 * @param off the offset being checked
	 * @param len the length being checked
	 * @throws ArrayIndexOutOfBoundsException if the index is out of bounds
	 * @throws NullPointerException if ary is null
	 */
	public static final <T> void checkBoundsThrows(T[] ary, int off, int len) {
		if(ary == null) {
			throw new NullPointerException("array cannot be null");
		}
		if(off < 0) {
			throw new ArrayIndexOutOfBoundsException("offset must be great than -1: " + off);
		}
		if(len < 0) {
			throw new ArrayIndexOutOfBoundsException("length must be great than -1: " + len);
		}
		if(off + len > ary.length) {
			throw new ArrayIndexOutOfBoundsException("array size=" + ary.length + ", off=" + off + ", len=" + len);
		}
	}
	// end T array methods



	// AND operations on primitive arrays
	/**
	 * @return a newly created array containing the ANDed results of {@code a} and {@code b}
	 * @see ArrayUtil#and(byte[], int, byte[], int, byte[], int, int) and()
	 */
	public static final byte[] and(byte[] a, byte[] b) {
		byte[] dst = new byte[a.length];
		and(a, 0, b, 0, dst, 0, dst.length);
		return dst;
	}


	/**
	 * @see ArrayUtil#and(byte[], int, byte[], int, byte[], int, int) and()
	 */
	public static final void and(byte[] a, byte[] b, byte[] dst, int length) {
		and(a, 0, b, 0, dst, 0, length);
	}


	/** AND {@code length} number of bytes from {@code a} with {@code b} using the syntax ({@code a[i] & b[i]})
	 * and store the result in {@code dst}
	 * @param a the first array
	 * @param offsetA the offset into the {@code a} array at which to start ANDing values
	 * @param b the second array
	 * @param offsetB the offset into the {@code b} array at which to start ANDing values
	 * @param dst the destination array to store the ANDed results in
	 * @param dstOffset the offset into the {@code dst} array at which to start storing the ANDed values
	 * @param length the number of values to read from {@code a} and {@code b} and store in {@code dst}
	 */
	public static final void and(byte[] a, int offsetA, byte[] b, int offsetB, byte[] dst, int dstOffset, int length) {
		for(int i = 0, aI = offsetA, bI = offsetB, dstI = dstOffset; i < length; i++, aI++, bI++, dstI++) {
			dst[dstI] = (byte)(a[aI] & b[bI]);
		}
	}
	// end AND


	// OR operations on primitive arrays
	/**
	 * @return a newly created array containing the ORed results of {@code a} and {@code b}
	 * @see ArrayUtil#or(byte[], int, byte[], int, byte[], int, int) or()
	 */
	public static final byte[] or(byte[] a, byte[] b) {
		byte[] dst = new byte[a.length];
		or(a, 0, b, 0, dst, 0, dst.length);
		return dst;
	}


	/**
	 * @see ArrayUtil#or(byte[], int, byte[], int, byte[], int, int) or()
	 */
	public static final void or(byte[] a, byte[] b, byte[] dst, int length) {
		or(a, 0, b, 0, dst, 0, length);
	}


	/** OR {@code length} number of bytes from {@code a} with {@code b} using the syntax ({@code a[i] | b[i]})
	 * and store the result in {@code dst}
	 * @param a the first array
	 * @param offsetA the offset into the {@code a} array at which to start ORing values
	 * @param b the second array
	 * @param offsetB the offset into the {@code b} array at which to start ORing values
	 * @param dst the destination array to store the ORed results in
	 * @param dstOffset the offset into the {@code dst} array at which to start storing the ORed values
	 * @param length the number of values to read from {@code a} and {@code b} and store in {@code dst}
	 */
	public static final void or(byte[] a, int offsetA, byte[] b, int offsetB, byte[] dst, int dstOffset, int length) {
		for(int i = 0, aI = offsetA, bI = offsetB, dstI = dstOffset; i < length; i++, aI++, bI++, dstI++) {
			dst[dstI] = (byte)(a[aI] | b[bI]);
		}
	}
	// end OR


	// XOR operations on primitive arrays
	/**
	 * @return a newly created array containing the XORed results of {@code a} and {@code b}
	 * @see ArrayUtil#xor(byte[], int, byte[], int, byte[], int, int) xor()
	 */
	public static final byte[] xor(byte[] a, byte[] b) {
		byte[] dst = new byte[a.length];
		xor(a, 0, b, 0, dst, 0, dst.length);
		return dst;
	}


	/**
	 * @see ArrayUtil#xor(byte[], int, byte[], int, byte[], int, int) xor()
	 */
	public static final void xor(byte[] a, byte[] b, byte[] dst, int length) {
		xor(a, 0, b, 0, dst, 0, length);
	}


	/** XOR {@code length} number of bytes from {@code a} with {@code b} using the syntax ({@code a[i] ^ b[i]})
	 * and store the result in {@code dst}
	 * @param a the first array
	 * @param offsetA the offset into the {@code a} array at which to start XORing values
	 * @param b the second array
	 * @param offsetB the offset into the {@code b} array at which to start XORing values
	 * @param dst the destination array to store the XORed results in
	 * @param dstOffset the offset into the {@code dst} array at which to start storing the XORed values
	 * @param length the number of values to read from {@code a} and {@code b} and store in {@code dst}
	 */
	public static final void xor(byte[] a, int offsetA, byte[] b, int offsetB, byte[] dst, int dstOffset, int length) {
		for(int i = 0, aI = offsetA, bI = offsetB, dstI = dstOffset; i < length; i++, aI++, bI++, dstI++) {
			dst[dstI] = (byte)(a[aI] ^ b[bI]);
		}
	}
	// end XOR


	/** Convert an array using a mapping function and store the resulting values.
	 * NOTE: Please provide the most specific 'dstCls' component type possible, else you will get a class cast exception at runtime if you try to cast/assign the array to a more specific type
	 * @param dstCls the component type of the destination array to create, this is '? super R' bound to support generics.  You can provide a concrete component type and get back an array of
	 * genericized component types based on the return type of the 'transformer' function.  To avoid runtime class cast exceptions, provide the most specific type you'll be accessing the array as.
	 * @see #map(Object[], int, int, Function, Object[], int)
	 */
	@SuppressWarnings("unchecked")
	public static final <E, R> R[] map(E[] srcAry, Class<? super R> dstCls, Function<E, R> transformer) {
		int size = srcAry.length;
		return map(srcAry, 0, size, transformer, (R[])Array.newInstance(dstCls, size), 0);
	}


	public static final <E, R> R[] map(E[] srcAry, Function<E, R> transformer, R[] dst) {
		return map(srcAry, 0, srcAry.length, transformer, dst, 0);
	}


	/** Convert an array using a mapping function and store the resulting values
	 * in a given destination array
	 * @param srcAry the input array to convert
	 * @param transformer the function to transform the input array values
	 * @param dst the destination array to store the transformed values in
	 * @return the input {@code dst} array filled with the transformed values
	 */
	public static final <E, R> R[] map(E[] srcAry, int srcOff, int srcLen, Function<E, R> transformer, R[] dst, int dstOff) {
		for(int i = 0; i < srcLen; i++) {
			R elem = transformer.apply(srcAry[srcOff + i]);
			dst[dstOff + i] = elem;
		}
		return dst;
	}


	public static final <T> T[] emptyArray() {
		@SuppressWarnings("unchecked")
		T[] ary = (T[])EMPTY_OBJECT_ARRAY;
		return ary;
	}




	public static final class Generic {

		/** Convert a primitive or object array to a string based on the array's component type
		 * @param ary the array to {@code toString()}, null returns {@code "null"}
		 * @return the string representation of {@code ary}
		 * @see Arrays#toString
		 */
		public static final String toString(Object ary) {
			Class<?> aryClazz = null;
			if(ary != null && (aryClazz = ary.getClass()).isArray()) {
				Class<?> componentType = aryClazz.getComponentType();
				if(componentType == Boolean.TYPE) { return Arrays.toString((boolean[])ary); }
				else if(componentType == Character.TYPE) { return Arrays.toString((char[])ary); }
				else if(componentType == Byte.TYPE) { return Arrays.toString((byte[])ary); }
				else if(componentType == Short.TYPE) { return Arrays.toString((short[])ary); }
				else if(componentType == Integer.TYPE) { return Arrays.toString((int[])ary); }
				else if(componentType == Long.TYPE) { return Arrays.toString((long[])ary); }
				else if(componentType == Float.TYPE) { return Arrays.toString((float[])ary); }
				else if(componentType == Double.TYPE) { return Arrays.toString((double[])ary); }
				return Arrays.toString((Object[])ary);
			}
			return ary != null ? ary.toString() : "null";
		}


		/** Check if two arrays are equal based on the each array's component type.
		 * Note: only equal component types are compared, i.e. an array of ints and an array of bytes always return false even thought they could contain equivalent data
		 * @param ary1 the first array to compare, nullable
		 * @param ary2 the second array to compare, nullable
		 * @return the true if the arrays are equal, false if not
		 * @see ArrayUtil#equals
		 */
		public static final boolean equals(Object ary1, int off1, Object ary2, int off2, int length) {
			if(ary1 == null || ary2 == null) { return false; }
			Class<?> cls1 = ary1.getClass();
			Class<?> cls2 = ary2.getClass();
			if(!cls1.isArray() || !cls2.isArray()) { return false; }

			Class<?> componentType = cls1.getComponentType();
			// we don't try to compare arrays that don't have the same element type
			if(componentType != cls2.getComponentType()) { return false; }

			if(componentType == Boolean.TYPE) {
				return ArrayUtil.equals((boolean[])ary1, off1, (boolean[])ary2, off2, length);
			}
			else if(componentType == Character.TYPE) {
				return ArrayUtil.equals((char[])ary1, off1, (char[])ary2, off2, length);
			}
			else if(componentType == Byte.TYPE) {
				return ArrayUtil.equals((byte[])ary1, off1, (byte[])ary2, off2, length);
			}
			else if(componentType == Short.TYPE) {
				return ArrayUtil.equals((short[])ary1, off1, (short[])ary2, off2, length);
			}
			else if(componentType == Integer.TYPE) {
				return ArrayUtil.equals((int[])ary1, off1, (int[])ary2, off2, length);
			}
			else if(componentType == Long.TYPE) {
				return ArrayUtil.equals((long[])ary1, off1, (long[])ary2, off2, length);
			}
			else if(componentType == Float.TYPE) {
				return ArrayUtil.equals((float[])ary1, off1, (float[])ary2, off2, length);
			}
			else if(componentType == Double.TYPE) {
				return ArrayUtil.equals((double[])ary1, off1, (double[])ary2, off2, length);
			}
			else {
				return ArrayUtil.equals((Object[])ary1, off1, (Object[])ary2, off2, length);
			}
		}

	}

}
