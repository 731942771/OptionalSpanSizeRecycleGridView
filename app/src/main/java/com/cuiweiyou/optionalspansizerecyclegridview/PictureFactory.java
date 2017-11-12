package com.cuiweiyou.optionalspansizerecyclegridview;

import java.util.ArrayList;
import java.util.Random;

/**
 * 假数据制造器
 *
 * Created by www.gaohaiyan.com on 2017/11/11,011.
 */
public class PictureFactory {
    static Random r = new Random();

    public static ArrayList<PictureBean > getPictures(int count){
        ArrayList<PictureBean> list = new ArrayList<PictureBean>();
        for (int i = 0; i < count; i++) {
            PictureBean p = new PictureBean();
            p.setWidth(500 + r.nextInt(500));
            p.setHeight(500 + r.nextInt(500));
            p.setGroupId(1 + r.nextInt(8));     // 随机的分组

            list.add(p);
        }

        return list;
    }
}
