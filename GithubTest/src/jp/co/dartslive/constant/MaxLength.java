package jp.co.dartslive.constant;

public enum MaxLength {
	GROUP_NAME(200),
	COMMENT(1200),
	;

	private int maxLength;

	/**
	 * コンストラクタ
	 * @param maxLength
	 */
	private MaxLength(int maxLength){
		this.maxLength = maxLength;
	}

	/**
	 *
	 * @return
	 */
	public int getMaxLength(){
		return maxLength;
	}
}
