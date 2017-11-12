package com.cuiweiyou.cvuratiolibrary;

import java.util.ArrayList;

/**
 * 占比计算工具<br/>
 * 根据Bean的width和height计算出每个bean的ratio，                                           <br/>
 * 然后根据既定的屏幕列数spans计算每行能显示多少bean。                                         <br/>
 * 计算过程：如果多个bean的ratio超过spans，那么超出的bean会“进入下一行”，未进入下一行的均分列数。   <br/>
 * 新的groupId在另起一行                                                                   <br/>
 *
 * Created by www.gaohaiyan.com on 2017/11/11,011.
 */
public class CVURatioUtil {
    private static int spans = 1;
    private static int currentGroupId;

    public static void ratio(int columns, ArrayList<? extends ICVURatioBean> ps) {
        spans = columns;

        currentGroupId = ps.get(0).getGroupId();

        for (int i = 0; i < ps.size(); i++) {
            ICVURatioBean b = ps.get(i);
            int r = getRatio(b);

            b.setRatio(r);
        }

        average(ps);
    }

    /**
     * 按照既定的列数spans将bean划分到“行”
     * @param ps
     */
    private static void average(ArrayList<? extends ICVURatioBean> ps) {

        ArrayList<ICVURatioBean> tmp = new  ArrayList<ICVURatioBean>();  // 缓存
        for (int i = 0; i < ps.size(); i++) {
            ICVURatioBean p = ps.get(i);

            // 如果这不是第一个元素
            if(tmp.size() > 0){
                int ratio_count = p.getRatio();

                for (int j = 0; j < tmp.size(); j++) {                  // 取出缓存的占比累加之
                    int ratio_pre = tmp.get(j).getRatio();
                    ratio_count += ratio_pre;
                }

                if(ratio_count > spans || currentGroupId != p.getGroupId()){             // 如果目标占比大于列数
                    currentGroupId = p.getGroupId();

                    averageTmp(tmp);    // 均化缓存的元素的占比

                    tmp.clear();        // 清理缓存
                    tmp.add(p);
                } else {                             // 如果目标占比未达到列数，缓存之
                    tmp.add(p);
                }
            }
            // 如果是第一个元素，直接缓存
            else {
                tmp.add(p);
            }

            if(i == ps.size() - 1)
                averageTmp(tmp);
        }
    }

    /**
     * 将“行”内剩余列数均分给“行”内的bean的ratio
     * @param tmp
     */
    private static void averageTmp(ArrayList<ICVURatioBean> tmp) {

        if( 1 == tmp.size()){  // 只有1个占比为1的元素时，占满目标列数
            ICVURatioBean p = tmp.get(0);

            p.setRatio(spans);

            return;
        }

        int ratio_count = 0;
        for (int i = 0; i < tmp.size(); i++) {  // 统计占的总列数
            ratio_count += tmp.get(i).getRatio();
        }

        if(spans == ratio_count)                 // 和列数相同时，已经平均化了
            return;

        int smallerIndex = 0;
        for (int i = 1; i < tmp.size(); i++) {
            int rSmall = tmp.get(smallerIndex).getRatio();
            int rCurrent = tmp.get(i).getRatio();
            if(rCurrent < rSmall)
                smallerIndex = i;
        }

        ICVURatioBean bb = tmp.get(smallerIndex);
        int orb = bb.getRatio();

        bb.setRatio(spans - ratio_count + orb);
    }

    /**
     * 计算bean 的初始ratio
     * @param b
     * @return
     */
    private static int getRatio(ICVURatioBean b) {
        float bw = 1.0f * b.getWidth();
        float bh = 1.0f * b.getHeight();
        float bs = bw / bh;

        if (bs > spans) {
            return spans;
        }

        int ratio = 1;
        float tmp = 0;

        for (int i = spans; i > 0; i--) {
            float t = (spans - 0.75f) / i;
            if (bs > tmp && bs < t) {
                ratio += spans - i;
                break;
            }

            tmp = t;
        }

        return ratio;
    }
}



