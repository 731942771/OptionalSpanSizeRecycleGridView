package com.cuiweiyou.optionalspansizerecyclegridview;

import com.cuiweiyou.cvuratiolibrary.ICVURatioBean;

/**
 * 实现了接口的bean
 *
 * Created by www.gaohaiyan.com on 2017/11/11,011.
 */
public class PictureBean implements ICVURatioBean {
    int ratio;
    int width;
    int height;
    int groupId;

    @Override
    public int getRatio() {
        return ratio;
    }

    @Override
    public void setRatio(int ratio) {
        this.ratio = ratio;
    }

    @Override
    public int getWidth() {
        return width;
    }

    @Override
    public void setWidth(int width) {
        this.width = width;
    }

    @Override
    public int getHeight() {
        return height;
    }

    @Override
    public void setHeight(int height) {
        this.height = height;
    }

    @Override
    public int getGroupId() {
        return groupId;
    }

    @Override
    public void setGroupId(int groupId) {
        this.groupId = groupId;
    }
}
