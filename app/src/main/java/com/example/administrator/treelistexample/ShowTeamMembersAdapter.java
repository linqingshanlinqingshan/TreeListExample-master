package com.example.administrator.treelistexample;

import android.content.Context;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;

import java.util.List;

public class ShowTeamMembersAdapter extends BaseTreeListAdapter {


    private final String TAG = "==SimpleTreeAdapter";


    public ShowTeamMembersAdapter(ListView mTree, Context context, List<TreeNode> datas, int defaultExpandLevel, int iconExpand, int iconNoExpand) {
        super(mTree, context, datas, defaultExpandLevel, iconExpand, iconNoExpand);
    }


    public ShowTeamMembersAdapter(ListView mTree, Context context, List<TreeNode> datas,
                                  int defaultExpandLevel) {
        super(mTree, context, datas, defaultExpandLevel);
    }


    @Override
    public View getConvertView(final TreeNode treeNode, final int position, View convertView, ViewGroup parent) {
        final ViewHolder viewHolder;
        if (convertView == null) {
            convertView = mInflater.inflate(R.layout.show_name_list_item, parent, false);


            viewHolder = new ViewHolder();
            viewHolder.cb_select_tree = convertView
                    .findViewById(R.id.cb_select_tree);//左选，全选
            viewHolder.tv_treenode_label = convertView
                    .findViewById(R.id.tv_treenode_label); //标题
            viewHolder.iv_touch_icon = convertView.findViewById(R.id.iv_touch_icon);//箭头


//------------------------------ 展示患者时
            viewHolder.iv_head_icon = convertView.findViewById(R.id.iv_head_icon);//头像
            viewHolder.cb_select_icon = convertView.findViewById(R.id.cb_select_icon);//单选，选择患者
//------------------------------


            convertView.setTag(viewHolder);


        } else {
            viewHolder = (ViewHolder) convertView.getTag();
        }


        convertView.setPadding(treeNode.getLevel() * 30, 3, 3, 3);


        if (treeNode.getStr4().equals("0")) {


            viewHolder.tv_treenode_label.setText(treeNode.getStr1() + " (" + treeNode.getStr2() + ")");//名字 + 职务


            Glide.with(mContext).load(treeNode.getStr3())
                    .centerCrop()
                    .error(R.mipmap.icon_default)
                    .placeholder(R.mipmap.icon_default)
                    .dontAnimate()
                    .transform(new GlideCircleTransform(mContext))
                    .diskCacheStrategy(DiskCacheStrategy.NONE) //设置缓存
                    .into(viewHolder.iv_head_icon);


            Log.d(TAG, "----> HelpPerson = " + treeNode.getStr3());


            viewHolder.iv_head_icon.setVisibility(View.VISIBLE);//帮扶头像


        } else {


            viewHolder.tv_treenode_label.setText(treeNode.getStr1() + " (" + treeNode.getStr2() + ")");//名字 + 职务
            viewHolder.iv_head_icon.setVisibility(View.GONE);//帮扶头像


        }


        if (treeNode.getIcon() == -1 && treeNode.getStr4().equals("0")) {//展示最后一级帮扶人员时


            viewHolder.iv_touch_icon.setVisibility(View.GONE);//右，箭头
            viewHolder.iv_head_icon.setVisibility(View.VISIBLE);//最后一级帮扶人员头像


        } else if (treeNode.getIcon() == -1 && !treeNode.getStr4().equals("0")) {


            viewHolder.iv_touch_icon.setVisibility(View.GONE);//右，箭头
            viewHolder.iv_head_icon.setVisibility(View.GONE);//帮扶头像


            viewHolder.iv_touch_icon.setImageResource(treeNode.getIcon());
        } else if (treeNode.getIcon() != -1 && !treeNode.getStr4().equals("0")) {


            viewHolder.iv_touch_icon.setVisibility(View.VISIBLE);//右，箭头
            viewHolder.iv_head_icon.setVisibility(View.GONE);//帮扶头像


            viewHolder.iv_touch_icon.setImageResource(treeNode.getIcon());
        }


        return convertView;
    }


    public static class ViewHolder {
        public ImageView iv_touch_icon;
        public CheckBox cb_select_tree;
        public TextView tv_treenode_label;
        public ImageView iv_head_icon;//头像
        public CheckBox cb_select_icon;//单选，选择患者
    }


}