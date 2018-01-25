package com.simple.tabhostdemo;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

/**
 * @author MrSimpleZ
 * @version V1.0
 * @Title: TabHostDemo
 * @Package com.aidai.tabhostdemo
 * @Description: (用一句话描述该文件做什么)
 * @date 2018/1/17 14:27
 */
public class ContentFragment extends Fragment{

		private TextView mTvContent;
		private String mContent;

		public static ContentFragment create(String content){
				ContentFragment fragment = new ContentFragment();
				Bundle bundle = new Bundle();
				bundle.putString("CONTENT", content);
				fragment.setArguments(bundle);
				return fragment;
		}

		@Override
		public void onAttach(Context context) {
				super.onAttach(context);
		}

		@Override
		public void onCreate(@Nullable Bundle savedInstanceState) {
				super.onCreate(savedInstanceState);
				Bundle bundle = getArguments();

				if(null != bundle){
						mContent = bundle.getString("CONTENT") == null ? "" : bundle.getString("CONTENT");
				}
		}

		@Nullable
		@Override
		public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
				View v = inflater.inflate(R.layout.content_fragment, container,false);
				return v;
		}

		@Override
		public void onActivityCreated(@Nullable Bundle savedInstanceState) {
				super.onActivityCreated(savedInstanceState);
		}

		@Override
		public void onStart() {
				super.onStart();
		}

		@Override
		public void onResume() {
				super.onResume();
		}

		@Override
		public void onPause() {
				super.onPause();
		}

		@Override
		public void onStop() {
				super.onStop();
		}

		@Override
		public void onDestroyView() {
				super.onDestroyView();
		}

		@Override
		public void onDestroy() {
				super.onDestroy();
		}

		@Override
		public void onDetach() {
				super.onDetach();
		}

		@Override
		public void onHiddenChanged(boolean hidden) {
				super.onHiddenChanged(hidden);
				if(!hidden){

				}
		}

		@Override
		public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
				super.onViewCreated(view, savedInstanceState);
				mTvContent = view.findViewById(R.id.tv_content);
				mTvContent.setText(mContent);
		}
}
