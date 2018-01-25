package com.simple.tabhostlib;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.simple.tabhostlib.adapter.BaseTabAdapter;
import com.simple.tabhostlib.entity.BaseTabHostEntity;

import java.util.List;

/**
 * @author MrSimpleZ
 * @version V1.0
 * @Title: TabHostDemo
 * @Package com.aidai.tabhostlib
 * @Description: (用一句话描述该文件做什么)
 * @date 2018/1/22 14:09
 */
public class DefaultTabAdapter extends BaseTabAdapter<BaseTabHostEntity> {

		private Context mContext;
		private View mContent;
		private TextView tvTitle;
		private ImageView ivIcon;
		private List<BaseTabHostEntity> mDatas;

		public DefaultTabAdapter(List<BaseTabHostEntity> datas, Context context) {
				super(datas);
				mDatas = datas;
				mContext = context;
		}

		@Override
		public View getView(View parent, int position) {
				BaseTabHostEntity entity = mDatas.get(position);
				mContent = LayoutInflater.from(mContext).inflate(R.layout.layout_host, null, false);
				tvTitle = mContent.findViewById(R.id.tv_tab_title);
				tvTitle.setText(entity.getTabTitle());
				ivIcon = mContent.findViewById(R.id.iv_tab_icon);
				ivIcon.setImageResource(entity.getTabUnselectedIcon());
				return mContent;
		}

		@Override
		public void notifyData(View v, boolean isSelect, int position) {
				TextView tvTitle = v.findViewById(R.id.tv_tab_title);
				ImageView ivIcon = v.findViewById(R.id.iv_tab_icon);
				BaseTabHostEntity entity = mDatas.get(position);
				if (isSelect) {
						tvTitle.setTextColor(mContent.getResources().getColor(android.R.color.holo_red_light));
						ivIcon.setImageResource(entity.getTabSelectedIcon());
				}else{
						tvTitle.setTextColor(mContent.getResources().getColor(android.R.color.black));
						ivIcon.setImageResource(entity.getTabUnselectedIcon());
				}
		}


}
