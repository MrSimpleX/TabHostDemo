package com.simple.tabhostdemo;

import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.FrameLayout;

import com.simple.tabhostdemo.common.CommonEntity;
import com.simple.tabhostdemo.frescoadapter.FrescoAdapter;
import com.simple.tabhostdemo.frescoadapter.FrescoEntity;
import com.simple.tabhostlib.CustomTabHostLayout;
import com.simple.tabhostlib.entity.BaseTabHostEntity;
import com.facebook.drawee.backends.pipeline.Fresco;

import java.util.ArrayList;
import java.util.List;


/**
 * @author MrSimpleZ
 */
public class MainActivity extends AppCompatActivity {

		private CustomTabHostLayout mTabLayout;
		private CustomTabHostLayout mTabLayoutFresco;
		private FrameLayout mContent;
		private String[] mTitleList = {"我的", "个人", "系统", "首页"};
		private List<BaseTabHostEntity> mTabHostEntity = new ArrayList<>();
		private List<FrescoEntity> mFrescoTabHostEntity = new ArrayList<>();
		private ArrayList<Fragment> mFragmentArrayList = new ArrayList<>();
		private ArrayList<Fragment> mFrescioArrayList = new ArrayList<>();

		@Override
		protected void onCreate(Bundle savedInstanceState) {
				super.onCreate(savedInstanceState);
				setContentView(R.layout.activity_main);

				mTabLayout = findViewById(R.id.ctl_hose);
				mContent = findViewById(R.id.fl_content);
				mTabLayoutFresco = findViewById(R.id.ctl_fresco);

				Fresco.initialize(this);

				for(int i = 0; i < mTitleList.length; i++){
						mTabHostEntity.add(new CommonEntity(mTitleList[i], R.mipmap.ic_launcher_round, R.mipmap.ic_launcher));
						mFragmentArrayList.add(ContentFragment.create(mTitleList[i]));
				}

				for(int i = 0; i < mTitleList.length; i++){
						mFrescoTabHostEntity.add(new FrescoEntity(mTitleList[i],
							"http://pic36.photophoto.cn/20150715/0007020080742327_b.jpg",
							"http://img.zcool.cn/community/0171ae5683dccf32f8759f04b29bf9.jpg"));
						mFrescioArrayList.add(ContentFragment.create(mTitleList[i]));
				}

//				mTabLayout.setTabData(mTabHostEntity, this, R.id.fl_content, mFragmentArrayList);
//				mTabLayout.setCurrentTab(0);
				mTabLayoutFresco.setTabData(mTabHostEntity, this, R.id.fl_content, mFragmentArrayList, new FrescoAdapter(mFrescoTabHostEntity, this));
				mTabLayoutFresco.setCurrentTab(0);
		}

		@Override
		protected void onResume() {
				super.onResume();
		}
}
