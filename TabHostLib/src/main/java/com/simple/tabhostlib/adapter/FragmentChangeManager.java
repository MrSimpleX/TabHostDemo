package com.simple.tabhostlib.adapter;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;

import java.util.ArrayList;

/**
 * @author MrSimpleZ
 * @version V1.0
 * @Title: TabHostDemo
 * @Package com.aidai.tabhostlib.adapter
 * @Description: Fragment切换适配器
 * @date 2018/1/22 14:06
 */
public class FragmentChangeManager {
		private FragmentManager mFragmentManager;
		private int mContainerViewId;
		/**
		 * Fragment切换数组
		 */
		private ArrayList<Fragment> mFragments;
		/**
		 * 当前选中的Tab
		 */
		private int mCurrentTab;

		public FragmentChangeManager(FragmentManager fm, int containerViewId, ArrayList<Fragment> fragments) {
				this.mFragmentManager = fm;
				this.mContainerViewId = containerViewId;
				this.mFragments = fragments;
				initFragments();
		}

		/**
		 * 初始化fragments
		 */
		private void initFragments() {
				int i = 0;
				for (Fragment fragment : mFragments) {
						if (!fragment.isAdded() || null == mFragmentManager.findFragmentByTag("" + i)) {
								mFragmentManager.beginTransaction().add(mContainerViewId, fragment, "" + i).hide(fragment).commit();
								i++;
						}
				}

				setFragments(0);
		}

		/**
		 * 界面切换控制
		 */
		public void setFragments(int index) {
				for (int i = 0; i < mFragments.size(); i++) {
						FragmentTransaction ft = mFragmentManager.beginTransaction();
						Fragment fragment = mFragments.get(i);
						if (i == index) {
								ft.show(fragment);
						} else {
								ft.hide(fragment);
						}
						ft.commit();
				}
				mCurrentTab = index;
		}

		public int getCurrentTab() {
				return mCurrentTab;
		}

		public Fragment getCurrentFragment() {
				return mFragments.get(mCurrentTab);
		}
}