package com.simple.tabhostlib.entity;

import android.support.annotation.DrawableRes;

/**
 * @author MrSimpleZ
 * @version V1.0
 * @Title: TabHostDemo
 * @Package com.aidai.tabhostlib.entity
 * @Description: 底部菜单栏所需数据
 * @date 2018/1/18 15:06
 */
public interface BaseTabHostEntity {

		String getTabTitle();

		@DrawableRes
		int getTabSelectedIcon();

		@DrawableRes
		int getTabUnselectedIcon();
}
