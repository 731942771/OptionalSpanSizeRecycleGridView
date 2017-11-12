package com.cuiweiyou.optionalspansizerecyclegridview;

import java.util.Comparator;

/**
 * 将一组的“分到一起”，即一组的bean连续排列
 *
 * Created by www.gaohaiyan.com on 2017/11/11,011.
 */
public class PictureCompartor implements Comparator<PictureBean> {

    @Override
    public int compare(PictureBean o, PictureBean t1) {
        if(o.getGroupId() != t1.getGroupId())
            return o.getGroupId() > t1.getGroupId() ? 1 : -1;

        return 0;
    }

}
