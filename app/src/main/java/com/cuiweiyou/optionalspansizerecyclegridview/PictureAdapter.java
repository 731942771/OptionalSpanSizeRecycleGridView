package com.cuiweiyou.optionalspansizerecyclegridview;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * 普通Adapter
 * Created by www.gaohaiyan.com on 2017/11/11,011.
 */
public class PictureAdapter extends RecyclerView.Adapter<PictureAdapter.PictureHolder> {

    private ArrayList<PictureBean> datas;

    public PictureAdapter(ArrayList<PictureBean> datas) {
        this.datas = datas;
    }

    public void flushDatas(ArrayList<PictureBean> list){
        datas = new ArrayList<PictureBean>();
        datas.addAll(list);
    }

    @Override
    public PictureHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = View.inflate(parent.getContext(), R.layout.item_rv, null);
        return new PictureHolder(v);
    }

    @Override
    public void onBindViewHolder(PictureHolder holder, int position) {
        PictureBean p = datas.get(position);
        int width = p.getWidth();
        int height = p.getHeight();
        int ratio = p.getRatio();
        holder.mTxt.setText("\n宽：" + width + "，高：" + height + "\n占比：" + ratio);

        if(position == 0) {
            holder.mGroup.setVisibility(View.VISIBLE);
            holder.mGroup.setText("组：" + p.getGroupId());
        } else {
            int pgid = datas.get(--position).getGroupId();
            int cgid = p.getGroupId();
            if(pgid != cgid){
                holder.mGroup.setVisibility(View.VISIBLE);
                holder.mGroup.setText("组：" + p.getGroupId());
            } else {
                holder.mGroup.setVisibility(View.INVISIBLE);
            }
        }
    }

    @Override
    public int getItemCount() {
        return datas.size();
    }

    class PictureHolder extends RecyclerView.ViewHolder{

        private final TextView mTxt;
        private final TextView mGroup;

        public PictureHolder(View v) {
            super(v);

            mTxt = v.findViewById(R.id.txt);
            mGroup = v.findViewById(R.id.group);
        }
    }
}



