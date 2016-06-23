package twg2.arrays.test;

import java.util.Arrays;

import org.junit.Assert;
import org.junit.Test;

import twg2.arrays.ArrayManager;

public class ArrayManagedTests {

	@Test
	public void expandTest1() {
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


	public void addRemoveTest1() {
		int[] ary = new int[] { };
		int size = 0;
		ary = ArrayManager.add(ary, size, 22);
		size++;
		ArrayManager.add(ary, size, 12);
		size++;
		ArrayManager.add(ary, size, 5);
		size++;
		ArrayManager.add(ary, size, 1);
		size++;

		ArrayManager.removeValue(ary, size, 5);
		size--;
		ArrayManager.removeIndex(ary, size, 2);
		size--;
		ArrayManager.removeUnordered(ary, size, 1);
		size--;

		Assert.assertArrayEquals(new int[] { 22 }, Arrays.copyOf(ary, size));
	}

}
