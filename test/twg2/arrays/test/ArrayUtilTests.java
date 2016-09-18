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
public final class ArrayUtilTests {

	public static final class SubArrays<T> {
		T ary1;
		int off1;
		T ary2;
		int off2;
		int len;

		public SubArrays(T ary1, int off1, T ary2, int off2, int len) {
			this.ary1 = ary1;
			this.off1 = off1;
			this.ary2 = ary2;
			this.off2 = off2;
			this.len = len;
		}

	}


	private static float[][] fVals1 = new float[][] {
		{ 2, 5.5f, 3.4f },
		{ 0.25f, 0.50f, 0.75f },
		{ 0, -1, 1 },
		{}
	};
	private static int[][] iVals1 = new int[][] {
		{ 2, 3, 6 },
		{ 5, 10, 15 },
		{ 0, -1, 1 },
		{}
	};


	@Test
	public final void avgTest() {
		Float[] fAvgExpect = new Float[] { 3.6333333f, 0.5f, 0f, Float.NaN };
		Float[] iAvgExpect = new Float[] { 3.6666667f, 10f, 0f, Float.NaN };

		CheckTask.assertTests(fVals1, fAvgExpect, (fAry) -> ArrayUtil.avg(fAry));
		CheckTask.assertTests(iVals1, iAvgExpect, (iAry) -> ArrayUtil.avg(iAry));
	}


	@Test
	public final void maxTest() {
		Float[] fMaxExpect = new Float[] { 5.5f, 0.75f, 1f, Float.MIN_VALUE };
		Integer[] iMaxExpect = new Integer[] { 6, 15, 1, Integer.MIN_VALUE };

		CheckTask.assertTests(fVals1, fMaxExpect, (fAry) -> ArrayUtil.max(fAry));
		CheckTask.assertTests(iVals1, iMaxExpect, (iAry) -> ArrayUtil.max(iAry));
	}


	@Test
	public final void minTest() {
		Float[] fMinExpect = new Float[] { 2f, 0.25f, -1f, Float.MAX_VALUE };
		Integer[] iMinExpect = new Integer[] { 2, 5, -1, Integer.MAX_VALUE };

		CheckTask.assertTests(fVals1, fMinExpect, (fAry) -> ArrayUtil.min(fAry));
		CheckTask.assertTests(iVals1, iMinExpect, (iAry) -> ArrayUtil.min(iAry));
	}


	@Test
	public final void sumTest() {
		Float[] fSumExpect = new Float[] { 10.9f, 1.5f, 0f, 0f };
		Integer[] iSumExpect = new Integer[] { 11, 30, 0, 0 };

		CheckTask.assertTests(fVals1, fSumExpect, (fAry) -> ArrayUtil.sum(fAry));
		CheckTask.assertTests(iVals1, iSumExpect, (iAry) -> ArrayUtil.sum(iAry));
	}


	@Test
	public void concatTest() {
		int[] res1 = ArrayUtil.concat(ints(0), ints(1, 1), ints(2, 3, 5));
		Assert.assertArrayEquals(ints(0, 1, 1, 2, 3, 5), res1);

		int[] res2 = ArrayUtil.concat(ints(0, 2), ints(1, 3));
		Assert.assertArrayEquals(ints(0, 2, 1, 3), res2);

		int[] res3 = ArrayUtil.concat(new int[] { }, ints(1), 1/*dst off*/, 4/*dst len*/);
		Assert.assertArrayEquals(ints(0, 1, 0, 0), res3);

		int[] res4 = ArrayUtil.concat(ints(1, 0), 0, 1/*src 1 off & len*/, ints(1, 2, 3, 4), 1, 2/*src 2 off & len*/, 1/*dst off*/, 4/*dst len*/);
		Assert.assertArrayEquals(ints(0, 1, 2, 3), res4);

		int[] res5 = ArrayUtil.concat(ints(1, 0), 0, 1/*src 1 off & len*/, ints(1, 2, 3, 4), 1, 2/*src 2 off & len*/, new int[3], 0/*dst off*/);
		Assert.assertArrayEquals(ints(1, 2, 3), res5);
	}


	@Test
	public void genericEqualsTest() {
		List<SubArrays<int[]>> inputs = Arrays.asList(
				new SubArrays<>(ints(1, 2, 3), 0, ints(1, 2, 3), 0, 2),
				new SubArrays<>(ints(1, 2, 3), 0, ints(1, 2), 0, 2),
				new SubArrays<>(ints(1, 2, 3), 2, ints(1, 2), 2, 0),
				new SubArrays<>(ints(1, 2, 3), 0, ints(5, 5, 5), 1, 2),
				new SubArrays<>(ints(1, 2, 3), 2, ints(5, 5), 1, 1),
				new SubArrays<>(ints(1, 2, 3), 1, ints(0, 1, 2, 3, 4), 2, 2)
		);
		List<Boolean> expected = Arrays.asList(true, true, true, false, false, true);

		CheckTask.assertTests(inputs, expected, (data, idx) -> ArrayUtil.Generic.equals(data.ary1, data.off1, data.ary2, data.off2, data.len));
	}


	@Test
	public void mapTest() {
		String[] res1 = ArrayUtil.map(new Integer[] { 0, 1, 2, 3 }, String.class, (i) -> "+" + (i * 2));
		Assert.assertArrayEquals(new String[] { "+0", "+2", "+4", "+6" }, res1);

		String[] res2 = ArrayUtil.map(new String[] { "a", "b", "z" }, String.class, (s) -> s.toUpperCase());
		Assert.assertArrayEquals(new String[] { "A", "B", "Z" }, res2);
	}


	@Test
	public void orTest() {
		List<SubArrays<byte[]>> inputs = Arrays.asList(
				new SubArrays<>(bytes(2, 5, 16, 32), 0, bytes(4, 5, 17, 80), 0, 4),
				new SubArrays<>(bytes(0, 1, 7, 10), 1, bytes(0, 0, 2, 8, 12), 2, 3)
		);
		List<byte[]> expected = Arrays.asList(
				bytes(6, 5, 17, 112),
				bytes(3, 15, 14)
		);

		CheckTask.assertTests(inputs, expected, (data, idx) -> {
			byte[] dst = new byte[data.len];
			ArrayUtil.or(data.ary1, data.off1, data.ary2, data.off2, dst, 0, data.len);
			return dst;
		});
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

		CheckTask.assertTests(inputs, expected, (data, i) -> {
			Integer[] wrapped = ArrayUtil.primitiveToWrapper(data, offset[i], len[i], new Integer[data.length], offset[i]);
			return ArrayUtil.wrapperToPrimitive(wrapped, offset[i], len[i], new int[len[i]], 0);
		});
	}


	@Test
	public final void reverseTest() {
		Assert.assertArrayEquals(new byte[0], ArrayUtil.reverse(new byte[0]));
		Assert.assertArrayEquals(ints(10), ArrayUtil.reverse(ints(10)));
		Assert.assertArrayEquals(ints(20, 15, 10), ArrayUtil.reverse(ints(10, 15, 20)));

		Assert.assertArrayEquals(ints(15, 10), ArrayUtil.reverse(ints(10, 15), 0, 2));

		Assert.assertArrayEquals(ints(15, 10, 20), ArrayUtil.reverse(ints(10, 15, 20), 0, 2));
		Assert.assertArrayEquals(ints(10, 20, 15), ArrayUtil.reverse(ints(10, 15, 20), 1, 2));
		Assert.assertArrayEquals(ints(20, 15, 10), ArrayUtil.reverse(ints(10, 15, 20), 0, 3));

		Assert.assertArrayEquals(ints(1, 2, 3, 4, 5), ArrayUtil.reverse(ints(1, 2, 3, 4, 5), 1, 1));
		Assert.assertArrayEquals(ints(1, 3, 2, 4, 5), ArrayUtil.reverse(ints(1, 2, 3, 4, 5), 1, 2));
		Assert.assertArrayEquals(ints(1, 4, 3, 2, 5), ArrayUtil.reverse(ints(1, 2, 3, 4, 5), 1, 3));
		Assert.assertArrayEquals(ints(1, 5, 4, 3, 2), ArrayUtil.reverse(ints(1, 2, 3, 4, 5), 1, 4));
		CheckTask.assertException(() -> ArrayUtil.reverse(ints(1, 2, 3, 4, 5), 1, 5));
	}


	@Test
	public void xorTest() {
		List<SubArrays<byte[]>> inputs = Arrays.asList(
				new SubArrays<>(bytes(2, 5, 16, 32), 0, bytes(4, 5, 17, 80), 0, 4),
				new SubArrays<>(bytes(0, 1, 7, 10), 1, bytes(0, 0, 2, 8, 12), 2, 3)
		);
		List<byte[]> expected = Arrays.asList(
				bytes(6, 0, 1, 112),
				bytes(3, 15, 6)
		);

		CheckTask.assertTests(inputs, expected, (data, idx) -> {
			byte[] dst = new byte[data.len];
			ArrayUtil.xor(data.ary1, data.off1, data.ary2, data.off2, dst, 0, data.len);
			return dst;
		});
	}


	private static byte[] bytes(int... bytes) {
		byte[] b = new byte[bytes.length];
		for(int i = 0, size = bytes.length; i < size; i++) {
			if(bytes[i] > 127 || bytes[i] < -128) {
				throw new IllegalArgumentException("argument out of range, byte[" + i + "] = " + bytes[i] + " is not a byte between -128 and 127");
			}
			b[i] = (byte)bytes[i];
		}
		return b;
	}


	private static int[] ints(int... ints) {
		return ints;
	}

}
