package com.cuiweiyou.cvuratiolibrary;

import android.support.v7.widget.GridLayoutManager;
import android.util.Log;

import java.util.ArrayList;

/**
 * GridLayoutManager使用的内部处理器，用于确认每个Item占多少列。 <br/>
 * 须要传入已经处理好的数据-明确了ratio、在某行的bean的集合。     <br/>
 *
 * Created by www.gaohaiyan.com on 2017/11/11,011.
 */
class CVURatioLoopup extends GridLayoutManager.SpanSizeLookup {

    private final ArrayList<? extends ICVURatioBean> ratios;

    public CVURatioLoopup(ArrayList<? extends ICVURatioBean> datas) {
        this.ratios = datas;
    }

    @Override
    public int getSpanSize(int position) {    // 这里直接取出计算好的占比
        ICVURatioBean p = ratios.get(position);
        Log.i("ard", "组：" + p.getGroupId() + "，比：" + p.getRatio());
        return p.getRatio();
    }
}


