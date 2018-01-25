package com.simple.tabhostdemo.common;

import com.simple.tabhostlib.entity.BaseTabHostEntity;

/**
 * @author MrSimpleZ
 * @version V1.0
 * @Title: TabHostDemo
 * @Package com.aidai.tabhostdemo.common
 * @Description: 普通imageview Demo
 * @date 2018/1/24 15:06
 */
public class CommonEntity implements BaseTabHostEntity {

		public CommonEntity(String title, int resSelect, int resUnSelect) {
			this.title = title;
			this.resSelect = resSelect;
			this.resUnSelect = resUnSelect;
		}

		private String title;
		private int resSelect;
		private int resUnSelect;

		public String getTitle() {
				return title;
		}

		public void setTitle(String title) {
				this.title = title;
		}

		public int getResSelect() {
				return resSelect;
		}

		public void setResSelect(int resSelect) {
				this.resSelect = resSelect;
		}

		public int getResUnSelect() {
				return resUnSelect;
		}

		public void setResUnSelect(int resUnSelect) {
				this.resUnSelect = resUnSelect;
		}

		@Override
		public String getTabTitle() {
				return title;
		}

		@Override
		public int getTabSelectedIcon() {
				return resSelect;
		}

		@Override
		public int getTabUnselectedIcon() {
				return resUnSelect;
		}
}
