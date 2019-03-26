package twg2.arrays.test;

import java.util.Arrays;

import org.junit.Assert;
import org.junit.Test;

import twg2.arrays.ArrayManager;

public class ArrayManagerTests {

	@Test
	public void expandTest() {
		int[] ary = new int[] { 0, 1 };
		int size = ary.length;

		for(int i = size; i < 20; i++) {
			if(size + 1 > ary.length) {
				ary = ArrayManager.expand(ary);
			}
			ary[i] = ary[i - 2] + ary[i - 1];
			size++;
		}

		Assert.assertArrayEquals(new int[] { 0, 1, 1, 2, 3, 5, 8, 13, 21, 34, 55, 89, 144, 233, 377, 610, 987, 1597, 2584, 4181 }, Arrays.copyOf(ary, 20));
	}


	@Test
	public void addRemoveTest() {
		int[] ary = new int[] { };
		int size = 0;
		ary = ArrayManager.add(ary, size, 22);
		size++;
		ary = ArrayManager.add(ary, size, 12);
		size++;
		ary = ArrayManager.add(ary, size, 15);
		size++;
		ary = ArrayManager.add(ary, size, 11);
		size++;

		Assert.assertFalse(ArrayManager.removeValue(ary, size, 99));
		Assert.assertTrue(ArrayManager.removeValue(ary, size, 15));
		size--;
		Assert.assertEquals(11, ArrayManager.removeIndex(ary, size, 2));
		size--;
		Assert.assertEquals(12, ArrayManager.removeUnordered(ary, size, 1));
		size--;

		Assert.assertArrayEquals(new int[] { 22 }, Arrays.copyOf(ary, size));
	}


	@Test
	public void addAllTest() {
		int[] ary = new int[] { };
		int size = 0;
		ary = ArrayManager.addAll(ary, size, new int[] { 0, 1, 2, 99 }, 1, 2);
		size += 2;
		Assert.assertArrayEquals(new int[] { 1, 2 }, Arrays.copyOf(ary, size));
		ary = ArrayManager.addAll(ary, size, new int[] { 3, 4, 5, 6, 7, 8, 9, 10 }, 0, 8);
		size += 8;
		Assert.assertArrayEquals(new int[] { 1, 2, 3, 4, 5, 6, 7, 8, 9, 10 }, Arrays.copyOf(ary, size));

		Arrays.fill(ary, 0);
		ary = ArrayManager.addAll(ary, size, null, 0, 99);
		Assert.assertArrayEquals(new int[] { 0 }, Arrays.copyOf(ary, 1));

		ary = new int[] { 1, 2, 3, 0, 99 };
		size = 3;
		ary = ArrayManager.addAll(ary, size, new int[] { 4, 5, 6 }, 0, 3);
		size += 3;
		Assert.assertArrayEquals(new int[] { 1, 2, 3, 4, 5, 6 }, Arrays.copyOf(ary, size));

		ary = new int[] { 1, 2, 3 };
		size = 3;
		ary = ArrayManager.addAll(ary, 0, new int[] { 21, 42, 99 }, 0, 2);
		size = 2;
		Assert.assertArrayEquals(new int[] { 21, 42, 3 }, Arrays.copyOf(ary, 3));
	}


	@Test
	public void clearAndAddTest() {
		int[] ary = new int[] { };
		ary = ArrayManager.clearAndAddAll(ary, new int[] { 0, 3, 4, 5, 99 }, 1, 3);
		Assert.assertArrayEquals(new int[] { 3, 4, 5 }, Arrays.copyOf(ary, 3));

		ary = ArrayManager.clearAndAddAll(ary, null, 0, 99);
		Assert.assertArrayEquals(new int[] { 0, 0, 0 }, Arrays.copyOf(ary, 3));

		ary = new int[] { 1, 2, 0, 0, 0, 42 };
		ary = ArrayManager.clearAndAddAll(ary, new int[] { 3, 4, 99 }, 0, 2);
		Assert.assertArrayEquals(new int[] { 3, 4, 0, 0, 0, 0 }, Arrays.copyOf(ary, 6));

		ary = new int[] { 1, 2, 3 };
		ary = ArrayManager.clearAndAddAll(ary, new int[] { 4, 5, 6, 7 }, 0, 4);
		Assert.assertArrayEquals(new int[] { 4, 5, 6, 7 }, Arrays.copyOf(ary, 4));
	}

}
