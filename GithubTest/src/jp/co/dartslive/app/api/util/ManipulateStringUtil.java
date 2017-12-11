package jp.co.dartslive.app.api.util;

/**
 * パラメータチェック
 * @author mazaki
 *
 */
public class ManipulateStringUtil {

	/**
	 * パラメータのバイト数チェック
	 *
	 * @param param
	 * @param maxLenth
	 */
	public static boolean isViewScaleCount(String param, int maxLength){

		final int HANKAKU_KANA_START_CODE = 0xFF61;
		final int HANKAKU_KANA_END_CODE = 0xFF9F;
		final int HANKAKU_EISUJI_END_CODE = 0x007E;
		final int HANKAKU_KIGOU_EN = 0x00A5;
		final int HANKAKU_KIGOU_CHIRUDA = 0x203E;

		//バイト数
		int scaleCount = 0;
		//パラメータ文字数
		int charCount = param.length();

		//パラメータの文字数分、ループ
		for(int i = 0; i < charCount; i++){

			//パラメータのi番目の文字取得
			char character = param.charAt(i);

			//i番目の文字のバイト数を求める
			if ( character >= HANKAKU_KANA_START_CODE && character <= HANKAKU_KANA_END_CODE ){
				scaleCount += 1;
				continue;
			}
			if ( character <= HANKAKU_EISUJI_END_CODE ){
				scaleCount += 1;
				continue;
			}
			if ( character == HANKAKU_KIGOU_EN || character == HANKAKU_KIGOU_CHIRUDA ){
				scaleCount += 1;
				continue;
			}

			scaleCount += 2;
		}

		//パラメータのバイト数チェック
		if (maxLength < scaleCount) {
			//最大バイト数を超える場合
			return false;
		}

		//最大バイト数内の場合
		return true;
	}

	/**
	 * 文字コード(UTF-8)チェック
	 *
	 * @param param
	 * @return
	 */
	public static boolean isValidUTF8(String param) {

		//サロゲートペア文字チェック
		if (param.length() != param.codePointCount(0, param.length())) {
			//サロゲートペア文字が含まれる場合
			return false;
		}

		//サロゲートペア文字が含まれない場合
		return true;
	}

	/**
	 * 文字列の前後にある全角半角スペースを取り除きます
	 *
	 * @param param
	 * @return
	 */
	public static String trimSpace(String param) {

	    int st = 0;
	    int len = param.length();
	    char[] val = param.toCharArray();

	    //文字列の前の全角半角スペース位置
	    while ((st < len) && ((val[st] <= '\u0020') || (val[st] == '\u3000'))) {
	        st++;
	    }

	    //文字列の後ろの全角半角スペース位置
	    while ((st < len) && ((val[len - 1] <= '\u0020') || (val[len - 1] == '\u3000'))) {
	        len--;
	    }

	    //文字列の前後にスペースがある場合、substringして返却
	    return ((st > 0) || (len < param.length())) ? param.substring(st, len) : param;
	}

}