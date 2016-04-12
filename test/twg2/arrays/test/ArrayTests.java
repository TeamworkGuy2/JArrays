package twg2.arrays.test;

import java.util.Arrays;
import java.util.List;

import org.junit.Assert;
import org.junit.Test;

import twg2.arrays.ArrayUtil;
import checks.CheckTask;

/**
 * @author TeamworkGuy2
 * @since 2014-12-6
 */
public final class ArrayTests {

	public static final class ArraysOffsetData<T> {
		T ary1;
		int off1;
		T ary2;
		int off2;
		int len;

		public ArraysOffsetData(T ary1, int off1, T ary2, int off2, int len) {
			this.ary1 = ary1;
			this.off1 = off1;
			this.ary2 = ary2;
			this.off2 = off2;
			this.len = len;
		}

	}


	private static float[][] fVals1 = new float[][] { { 2, 5.5f, 3.4f }, { 0.25f, 0.50f, 0.75f }, { 0, -1, 1 }, {} };
	private static int[][] iVals1 = new int[][] { { 2, 3, 6 }, { 5, 10, 15 }, { 0, -1, 1 }, {} };


	@Test
	public final void arraySumsTest() {
		Float[] fSumExpect = new Float[] { 10.9f, 1.5f, 0f, 0f };
		Integer[] iSumExpect = new Integer[] { 11, 30, 0, 0 };

		CheckTask.assertTests(fVals1, fSumExpect, (fAry) -> ArrayUtil.sum(fAry));
		CheckTask.assertTests(iVals1, iSumExpect, (iAry) -> ArrayUtil.sum(iAry));
	}


	@Test
	public final void arrayAvgTest() {
		Float[] fSumExpect = new Float[] { 3.6333333f, 0.5f, 0f, Float.NaN };
		Float[] iSumExpect = new Float[] { 3.6666667f, 10f, 0f, Float.NaN };

		CheckTask.assertTests(fVals1, fSumExpect, (fAry) -> ArrayUtil.avg(fAry));
		CheckTask.assertTests(iVals1, iSumExpect, (iAry) -> ArrayUtil.avg(iAry));
	}


	@Test
	public void concatTest() {
		int[] res1 = ArrayUtil.concat(new int[] { 0 }, new int[] { 1, 1 }, new int[] { 2, 3, 5});
		Assert.assertArrayEquals(new int[] { 0, 1, 1, 2, 3, 5 }, res1);

		int[] res2 = ArrayUtil.concat(new int[] { 0, 2 }, new int[] { 1, 3 });
		Assert.assertArrayEquals(new int[] { 0, 2, 1, 3 }, res2);

		int[] res3 = ArrayUtil.concat(new int[] { }, new int[] { 1 }, 1/*dst off*/, 4/*dst len*/);
		Assert.assertArrayEquals(new int[] { 0, 1, 0, 0 }, res3);

		int[] res4 = ArrayUtil.concat(new int[] { 1, 0 }, 0, 1, new int[] { 1, 2, 3, 4 }, 1, 2, 1/*dst off*/, 4/*dst len*/);
		Assert.assertArrayEquals(new int[] { 0, 1, 2, 3 }, res4);

		int[] res5 = ArrayUtil.concat(new int[] { 1, 0 }, 0, 1, new int[] { 1, 2, 3, 4 }, 1, 2, new int[3], 0/*dst off*/);
		Assert.assertArrayEquals(new int[] { 1, 2, 3 }, res5);
	}


	@Test
	public void primitiveToWrapperTest() {
		int[][] inputs = {
				{ 1, 2, 3, 4, 5 },
				{ 5, 10 },
				{ -1, 0, 1 }
		};
		int[][] expected = {
				{ 3, 4, 5 },
				{ 5 },
				{ 0 }
		};
		int[] offset = {
				2,
				0,
				1
		};
		int[] len = {
				3,
				1,
				1
		};

		CheckTask.assertTests(inputs, expected, (data, idx) -> {
			Integer[] wrapped = ArrayUtil.primitiveToWrapper(data, offset[idx], len[idx], new Integer[data.length], offset[idx]);
			return ArrayUtil.wrapperToPrimitive(wrapped, offset[idx], len[idx], new int[len[idx]], 0);
		});
	}


	@Test
	public void genericEqualsTest() {
		List<ArraysOffsetData<int[]>> inputs = Arrays.asList(
				new ArraysOffsetData<>(new int[] { 1, 2, 3 }, 0, new int[] { 1, 2, 3 }, 0, 2),
				new ArraysOffsetData<>(new int[] { 1, 2, 3 }, 0, new int[] { 1, 2 }, 0, 2),
				new ArraysOffsetData<>(new int[] { 1, 2, 3 }, 2, new int[] { 1, 2 }, 2, 0),
				new ArraysOffsetData<>(new int[] { 1, 2, 3 }, 0, new int[] { 5, 5, 5 }, 1, 2),
				new ArraysOffsetData<>(new int[] { 1, 2, 3 }, 2, new int[] { 5, 5 }, 1, 1),
				new ArraysOffsetData<>(new int[] { 1, 2, 3 }, 1, new int[] { 0, 1, 2, 3, 4 }, 2, 2)
		);
		List<Boolean> expected = Arrays.asList(true, true, true, false, false, true);

		CheckTask.assertTests(inputs, expected, (data, idx) -> ArrayUtil.Generic.equals(data.ary1, data.off1, data.ary2, data.off2, data.len));
	}


	@Test
	public void mapTest() {
		Integer[] res1 = ArrayUtil.map(new Integer[] { 0, 1, 2, 3 }, (i) -> i * 2);
		Assert.assertArrayEquals(new Integer[] { 0, 2, 4, 6 }, res1);

		String[] res2 = ArrayUtil.map(new String[] { "a", "b", "z" }, (s) -> s.toUpperCase());
		Assert.assertArrayEquals(new String[] { "A", "B", "Z" }, res2);
	}

}
