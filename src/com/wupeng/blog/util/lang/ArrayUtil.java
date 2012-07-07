package com.wupeng.blog.util.lang;




public class ArrayUtil {
	/**lllllllllllllllllll
	 * 私有构造方法，防止类的实例化，因为工具类不需要实例化。
	 */
	private ArrayUtil() {
	}

	/**
	 * 得到初始化好的int数组。
	 * @param length 数组长度
	 * @return 初始化后的int数组，各个元素的值和其索引值相等。
	 * @since  0.5
	 */
	public static int[] getInitedIntArray(int length) {
		int[] indexes = new int[length];
		for (int i = 0; i < length; i++) {
			indexes[i] = i;
		}
		return indexes;
	}

	/**
	 * 得到初始化好的int数组。
	 * @param length 数组长度
	 * @param value 初始值
	 * @return 初始化后的int数组，各个元素的值都等于指定的value。
	 * @since  0.5
	 */
	public static int[] getInitedIntArray(int length, int value) {
		int[] indexes = new int[length];
		for (int i = 0; i < length; i++) {
			indexes[i] = value;
		}
		return indexes;
	}

	/**
	 * 得到初始化好的String数组。
	 * @param length 数组长度
	 * @param value 初始值
	 * @return 初始化后的String数组，各个元素的值都等于value。
	 * @since  0.5
	 */
	public static String[] getInitedStringArray(int length, String value) {
		String[] indexes = new String[length];
		for (int i = 0; i < length; i++) {
			indexes[i] = value;
		}
		return indexes;
	}


}