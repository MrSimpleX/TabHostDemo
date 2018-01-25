package com.simple.tabhostlib.listener;

/**
 * @author MrSimpleZ
 * @version V1.0
 * @Title: TabHostDemo
 * @Package com.aidai.tabhostlib.entity
 * @Description: 底部菜单栏回调
 * @date 2018/1/18 15:06
 */
public interface OnTabSelectListener {
    /**
     * Tab选中状态
     *
     * @param position
     */
    void onTabSelect(int position);

    /**
     * Tab再次点击
     *
     * @param position
     */
    void onTabReselect(int position);
}