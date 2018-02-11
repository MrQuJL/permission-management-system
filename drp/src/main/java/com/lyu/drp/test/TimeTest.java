package com.lyu.drp.test;

import java.sql.Timestamp;

import org.junit.Test;

/**
 * 类名称: 测试时间
 * 类描述: 测试时间
 * 全限定性类名: com.lyu.drp.test.TimeTest
 * @author 曲健磊
 * @date 2018年2月11日 下午11:27:33
 * @version V1.0
 */
public class TimeTest {
	
	@Test
	public void testDateTime() {
		
		Timestamp t = new Timestamp(System.currentTimeMillis());
		
		System.out.println(t);
		
	}
	
	
}
