package jp.co.dartslive.app.testapi.testutil;

import static org.junit.Assert.*;

import org.junit.Test;

import jp.co.dartslive.app.api.util.ManipulateStringUtil;
import jp.co.dartslive.constant.MaxLength;

public class ManipulateStringUtilTest {
	int groupNameMaxLength = MaxLength.GROUP_NAME.getMaxLength();

	/**
	 * 1桁
	 */
	@Test
	public void testIsViewScaleCount_01() {
		System.out.println("testIsViewScaleCount_01");
		String param = "1";
		assertTrue(ManipulateStringUtil.isViewScaleCount(param, groupNameMaxLength));
//		fail("まだ実装されていません");
	}
//
//	@Test
//	public void testIsValidUTF8() {
//		fail("まだ実装されていません");
//	}
//
//	@Test
//	public void testTrimSpace() {
//		fail("まだ実装されていません");
//	}

}
