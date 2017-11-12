package com.cuiweiyou.cvuratiolibrary;

import android.content.Context;
import android.support.v7.widget.GridLayoutManager;

import java.util.ArrayList;

/**
 * 指定了列数占比控制器SpanSizeLookup的布局管理器
 *
 * Created by www.gaohaiyan.com on 2017/11/11,011.
 */
public class CVURatioLayoutManager extends GridLayoutManager {

    public CVURatioLayoutManager(Context context, int spanCount, ArrayList<? extends ICVURatioBean> datas) {
        super(context, spanCount);

        CVURatioLoopup loopup = new CVURatioLoopup(datas);
        this.setSpanSizeLookup(loopup);
    }

    public void updateRatio(ArrayList<? extends ICVURatioBean> datas) {
        CVURatioLoopup loopup = new CVURatioLoopup(datas);
        this.setSpanSizeLookup(loopup);
    }
}
