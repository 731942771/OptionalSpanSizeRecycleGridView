package com.cuiweiyou.cvuratiolibrary;

/**
 * Bean对象必须实现的接口。                                           <br/>
 * Bean中必须定义的属性：groupId、ratio、width、height。               <br/>
 * groupId是用来实现类似xpandListView组的效果，不分组时指定同一值即可     <br/>
 * ratio即屏幕宽的占比。                                              <br/>
 * width和height用来计算ratio。如图片自身宽高。                         <br/>
 *
 * Created by www.gaohaiyan.com on 2017/11/11,011.
 */
public interface ICVURatioBean {

    public int getRatio();
    public void setRatio(int ratio);

    public int getGroupId();
    public void setGroupId(int groupId);

    public int getWidth();
    public void setWidth(int width);

    public int getHeight();
    public void setHeight(int height);


}
