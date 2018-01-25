# TabHostDemo
可动态配置样式的底部菜单控件

参考了Flyco大神的Tab控件，在CommonTabLayout 的基础上拓展了一下，用适配器将Tab栏的页面和底部菜单解耦，可以动态设置图标拓展，不仅仅局限于ImageView

# 使用方式
首先，引入库
``` java
compile 'com.simple:TabHostLib:1.0.0'
```
实现BaseTabHostEntity接口

添加Fragment，与Tab内容列表
``` java
private ArrayList<Fragment> mFragmentArrayList = new ArrayList<>();

for(int i = 0; i < mTitleList.length; i++){
	mTabHostEntity.add(new CommonEntity(mTitleList[i], R.mipmap.ic_launcher_round, R.mipmap.ic_launcher));
	mFragmentArrayList.add(ContentFragment.create(mTitleList[i]));
}
```
最后设置数据到CustomTabHostLayout
``` java
mTabLayout.setTabData(mTabHostEntity, this, R.id.fl_content, mFragmentArrayList);
```
# Thanks
[FlycoTabLayout](https://github.com/H07000223/FlycoTabLayout) 

