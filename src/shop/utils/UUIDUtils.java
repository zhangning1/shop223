package shop.utils;

import java.util.UUID;

/**
 * ��������ַ����Ĺ�����
 * @author zhangning
 *
 */

public class UUIDUtils {
	/**
	 * ���������ַ���
	 * @return
	 */
	public static String getUUID(){
		return UUID.randomUUID().toString().replace("-", "");
	}

}
