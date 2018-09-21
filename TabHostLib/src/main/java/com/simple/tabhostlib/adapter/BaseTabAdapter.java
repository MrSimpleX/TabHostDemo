package com.simple.tabhostlib.adapter;

import android.database.DataSetObservable;
import android.database.DataSetObserver;
import android.view.View;

import java.util.List;

/**
 * @author MrSimpleZ
 * @version V1.0
 * @Title: TabHostDemo
 * @Package com.aidai.tabhostlib.adapter
 * @Description: 抽象的基础Tab适配器
 * @date 2018/1/22 14:06
 */
public abstract class BaseTabAdapter<T> {

		private OnDataChangedListener mOnDataChangedListener;

		private List<T> mHostDatas;

		public BaseTabAdapter(List<T> datas) {
				mHostDatas = datas;
		}

		public int getCount() {
				return mHostDatas == null ? 0 : mHostDatas.size();
		}

		public T getItem(int position) {
				return mHostDatas.get(position);
		}

		/**
		 * 获取ItemView
		 *
		 * @param parent
		 * @param position
		 * @return ItemView
		 */
		public abstract View getView(View parent, int position);

		/**
		 * 更新选中的Item
		 *
		 * @param v        选中的ItemView
		 * @param isSelect 是否选中
		 * @param position 第几条数据
		 */
		public abstract void notifyData(View v, boolean isSelect, int position);

		public interface OnDataChangedListener {
				void onChanged();
		}

		public void setOnDataChangedListener(OnDataChangedListener listener) {
				mOnDataChangedListener = listener;
		}

		public void notifyDataChanged() {
				mOnDataChangedListener.onChanged();
		}

}
