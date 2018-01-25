package com.simple.tabhostdemo.frescoadapter;

import com.simple.tabhostlib.entity.BaseTabHostEntity;

/**
 * @author MrSimpleZ
 * @version V1.0
 * @Title: TabHostDemo
 * @Package com.aidai.tabhostdemo.frescoadapter
 * @Description: (用一句话描述该文件做什么)
 * @date 2018/1/24 15:16
 */
public class FrescoEntity implements BaseTabHostEntity {

		public FrescoEntity(String title, String resSelect, String resUnSelect) {
				this.title = title;
				this.mSelectIcon = resSelect;
				this.mUnSelectIcon = resUnSelect;
		}

		private String title;
		private String mUnSelectIcon;
		private String mSelectIcon;

		public String getTitle() {
				return title;
		}

		public void setTitle(String title) {
				this.title = title;
		}

		public String getUnSelectIcon() {
				return mUnSelectIcon;
		}

		public void setUnSelectIcon(String unSelectIcon) {
				mUnSelectIcon = unSelectIcon;
		}

		public String getSelectIcon() {
				return mSelectIcon;
		}

		public void setSelectIcon(String selectIcon) {
				mSelectIcon = selectIcon;
		}

		@Override
		public String getTabTitle() {
				return title;
		}

		@Override
		public int getTabSelectedIcon() {
				return 0;
		}

		@Override
		public int getTabUnselectedIcon() {
				return 0;
		}
}
