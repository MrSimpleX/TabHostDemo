package com.simple.tabhostdemo.frescoadapter;

import android.content.Context;
import android.net.Uri;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.TextView;
import com.simple.tabhostdemo.R;
import com.simple.tabhostlib.adapter.BaseTabAdapter;
import com.facebook.drawee.view.SimpleDraweeView;

import java.util.List;

/**
 * @author MrSimpleZ
 * @version V1.0
 * @Title: TabHostDemo
 * @Package com.aidai.tabhostdemo.frescoadapter
 * @Description: (用一句话描述该文件做什么)
 * @date 2018/1/24 15:18
 */
public class FrescoAdapter extends BaseTabAdapter<FrescoEntity>{

		private Context mContext;
		private List<FrescoEntity> mDatas;

		public FrescoAdapter(List<FrescoEntity> datas, Context context) {
				super(datas);
				mContext = context;
				mDatas = datas;
		}

		@Override
		public View getView(View parent, int position) {
				FrescoEntity frescoEntity = mDatas.get(position);
				View mContent = LayoutInflater.from(mContext).inflate(R.layout.layout_fresco_tab, null, false);
				TextView tvTitle = mContent.findViewById(R.id.tv_tab_title);
				tvTitle.setText(frescoEntity.getTabTitle());
				SimpleDraweeView ivIcon = (SimpleDraweeView)mContent.findViewById(R.id.iv_tab_icon);
				ivIcon.setImageURI(Uri.parse(frescoEntity.getUnSelectIcon()));
				return mContent;
		}

		@Override
		public void notifyData(View v, boolean isSelect, int position) {
				FrescoEntity frescoEntity = mDatas.get(position);
				TextView tvTitle = v.findViewById(R.id.tv_tab_title);
				SimpleDraweeView ivIcon = (SimpleDraweeView)v.findViewById(R.id.iv_tab_icon);
				if(isSelect){
						tvTitle.setTextColor(mContext.getResources().getColor(android.R.color.holo_red_light));
						ivIcon.setImageURI(Uri.parse(frescoEntity.getSelectIcon()));
				}else{
						tvTitle.setTextColor(mContext.getResources().getColor(android.R.color.black));
						ivIcon.setImageURI(Uri.parse(frescoEntity.getUnSelectIcon()));
				}
		}
}
