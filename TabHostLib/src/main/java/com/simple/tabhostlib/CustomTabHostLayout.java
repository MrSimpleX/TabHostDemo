package com.simple.tabhostlib;

import android.content.Context;
import android.os.Bundle;
import android.os.Parcelable;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.util.AttributeSet;
import android.view.Gravity;
import android.view.View;
import android.widget.LinearLayout;

import com.simple.tabhostlib.adapter.BaseTabAdapter;
import com.simple.tabhostlib.adapter.FragmentChangeManager;
import com.simple.tabhostlib.entity.BaseTabHostEntity;
import com.simple.tabhostlib.listener.OnTabSelectListener;

import java.util.ArrayList;
import java.util.List;

/**
 * @author MrSimpleZ
 * @version V1.0
 * @Title: TabHostDemo
 * @Package com.aidai.tabhostlib
 * @Description: 底部菜单栏
 * @date 2018/1/17 14:13
 */
public class CustomTabHostLayout extends LinearLayout {

		private List<BaseTabHostEntity> mTabHostList;
		private LinearLayout mTabHostLayout;
		private int mCurrentTab;
		private int mLastTab;
		private int mTabCount;
		private Context mContext;
		private FragmentChangeManager mFragmentChangeManager;
		private OnTabSelectListener mListener;
		private BaseTabAdapter mAdapter;

		public CustomTabHostLayout(Context context) {
				this(context, null, 0);
		}

		public CustomTabHostLayout(Context context, @Nullable AttributeSet attrs) {
				this(context, attrs, 0);
		}

		public CustomTabHostLayout(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
				super(context, attrs, defStyleAttr);
				//重写onDraw方法,需要调用这个方法来清除flag
				setWillNotDraw(false);
				setClipChildren(true);
				setClipToPadding(false);
				mContext = context;
				mTabHostLayout = new LinearLayout(context);
				LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(LayoutParams.MATCH_PARENT, LayoutParams.WRAP_CONTENT);
				params.gravity = Gravity.CENTER_VERTICAL;
				mTabHostLayout.setLayoutParams(params);
				addView(mTabHostLayout);
		}

		public void setTabData(List<BaseTabHostEntity> tabHosList) {
				if (tabHosList == null || tabHosList.size() == 0) {
						throw new IllegalStateException("TabEntitys can not be NULL or EMPTY !");
				}
				mTabHostList = tabHosList;
		}

		/**
		 * 懒人专用方法
		 *
		 * @param tabEntitys
		 * @param fa
		 * @param containerViewId
		 * @param fragments
		 */
		public void setTabData(List<BaseTabHostEntity> tabEntitys, FragmentActivity fa, int containerViewId, ArrayList<Fragment> fragments) {
				mFragmentChangeManager = new FragmentChangeManager(fa.getSupportFragmentManager(), containerViewId, fragments);
				DefaultTabAdapter adapter = new DefaultTabAdapter(tabEntitys, mContext);
				setTabData(tabEntitys);
				setAdapter(adapter);
		}

		/**
		 * 关联数据支持同时切换fragments
		 *
		 * @param tabEntitys
		 * @param fa
		 * @param containerViewId
		 * @param fragments
		 */
		public void setTabData(List<BaseTabHostEntity> tabEntitys, FragmentActivity fa, int containerViewId, ArrayList<Fragment> fragments, BaseTabAdapter adapter) {
				mFragmentChangeManager = new FragmentChangeManager(fa.getSupportFragmentManager(), containerViewId, fragments);
				setTabData(tabEntitys);
				setAdapter(adapter);
		}

		private void notifyDataSetChanged() {
				mTabHostLayout.removeAllViews();
				this.mTabCount = mTabHostList.size();
				if (null == mAdapter) {
						throw new RuntimeException("TabHostAdapter could not be NULL");
				}
				View tabView;
				for (int i = 0; i < mTabCount; i++) {
						tabView = mAdapter.getView(mTabHostLayout, i);
						tabView.setTag(i);
						addTab(i, tabView);
				}
				updateTabStyles();
		}

		private void updateTabStyles() {
				if (null == mAdapter) {
						throw new RuntimeException("TabHostAdapter could not be NULL");
				}
				for (int i = 0; i < mTabCount; i++) {
						mAdapter.notifyData(mTabHostLayout.getChildAt(i), i == mCurrentTab, i);
				}
		}

		/**
		 * 创建并添加tab
		 */
		private void addTab(final int position, View tabView) {
				if (null == mAdapter) {
						throw new RuntimeException("TabHostAdapter could not be NULL");
				}
				tabView.setOnClickListener(new OnClickListener() {
						@Override
						public void onClick(View v) {
								int position = (Integer) v.getTag();
								if (mCurrentTab != position) {
										setCurrentTab(position);
										if (mListener != null) {
												mListener.onTabSelect(position);
										}
								} else {
										if (mListener != null) {
												mListener.onTabReselect(position);
										}
								}
						}
				});

				//每一个Tab的布局参数
				LinearLayout.LayoutParams tabViewParam =
					new LinearLayout.LayoutParams(LayoutParams.WRAP_CONTENT, LinearLayout.LayoutParams.MATCH_PARENT, 1.0f);
				mTabHostLayout.addView(tabView, position, tabViewParam);
		}

		public void setCurrentTab(int currentTab) {
				mLastTab = this.mCurrentTab;
				this.mCurrentTab = currentTab;
				updateTabSelection(currentTab);
				if (mFragmentChangeManager != null) {
						mFragmentChangeManager.setFragments(currentTab);
				}
		}

		public int getCurrentTab() {
				return mCurrentTab;
		}

		private void updateTabSelection(int position) {
				if (null == mAdapter) {
						throw new RuntimeException("TabHostAdapter could not be NULL");
				}
				for (int i = 0; i < mTabCount; ++i) {
						final boolean isSelect = i == position;
						mAdapter.notifyData(mTabHostLayout.getChildAt(i), isSelect, i);
				}
		}

		@Override
		protected Parcelable onSaveInstanceState() {
				Bundle bundle = new Bundle();
				bundle.putParcelable("instanceState", super.onSaveInstanceState());
				bundle.putInt("mCurrentTab", mCurrentTab);
				return bundle;
		}

		@Override
		protected void onRestoreInstanceState(Parcelable state) {
				if (state instanceof Bundle) {
						Bundle bundle = (Bundle) state;
						mCurrentTab = bundle.getInt("mCurrentTab");
						state = bundle.getParcelable("instanceState");
						if (mCurrentTab != 0 && mTabHostLayout.getChildCount() > 0) {
								updateTabSelection(mCurrentTab);
						}
				}
				super.onRestoreInstanceState(state);
		}

		public void setAdapter(BaseTabAdapter adapter) {
				mAdapter = adapter;
				notifyDataSetChanged();
		}

		public void setOnTabSelectListener(OnTabSelectListener listener) {
				this.mListener = listener;
		}
}
