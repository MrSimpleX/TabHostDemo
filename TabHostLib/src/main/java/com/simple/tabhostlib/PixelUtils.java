package com.simple.tabhostlib;

import android.content.Context;

/**
 * @author MrSimpleZ
 * @version V1.0
 * @Title: TabHostDemo
 * @Package com.aidai.tabhostlib
 * @Description: 像素相关工具类
 * @date 2018/1/18 11:04
 */
public class PixelUtils {

		private PixelUtils(){
				throw new RuntimeException("not access create exception");
		}

		public static int dp2px(float dp, Context context) {
				final float scale = context.getResources().getDisplayMetrics().density;
				return (int) (dp * scale + 0.5f);
		}

		public static int sp2px(float sp, Context context) {
				final float scale = context.getResources().getDisplayMetrics().scaledDensity;
				return (int) (sp * scale + 0.5f);
		}
}
