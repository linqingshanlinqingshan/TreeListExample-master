package com.example.administrator.treelistexample;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public abstract class BaseTreeListAdapter<T> extends BaseAdapter {


    String TAG = "==BaseTreeListAdapter";


    /**
     *  * 记录选中的 cb 总数
     *  
     */
    public static int numCB = 0;


    /**
     *  * 有多少患者
     *  
     */
    protected int patientsNum = 0;


    /**
     *  * 在PatientsNameListActivity调用,获取患者 id
     *  
     */
    protected Map<String, Boolean> cbMap = new LinkedHashMap<>();


    protected Context mContext;
    /**
     *  * 存储所有可见的Node
     *  
     */
    protected List<TreeNode> mTreeNodes = new ArrayList<>();
    protected LayoutInflater mInflater;


    /**
     *  * 存储所有的Node
     *  
     */
    protected List<TreeNode> mAllTreeNodes = new ArrayList<>();


    /**
     *  * 点击的回调接口
     *  
     */
    protected OnTreeNodeClickListener onTreeNodeClickListener;
    protected OnHelpToAllSelectClickListener onHelpToAllSelectClickListener;


    /**
     *  * 默认不展开
     *  
     */
    private int defaultExpandLevel = 0;
    /**
     *  * 展开与关闭的图片
     *  
     */
    private int iconExpand = -1, iconNoExpand = -1;


    //设置患者数目
    public void setPatientsNum(int patientsNum) {
        this.patientsNum = patientsNum;
    }


    public void setOnTreeNodeClickListener(
            OnTreeNodeClickListener onTreeNodeClickListener) {
        this.onTreeNodeClickListener = onTreeNodeClickListener;
    }


    public void setOnHelpToAllSelectClickListener(
            OnHelpToAllSelectClickListener onHelpToAllSelectClickListener) {
        this.onHelpToAllSelectClickListener = onHelpToAllSelectClickListener;
    }


    public BaseTreeListAdapter(ListView mTree, Context context, List<TreeNode> datas,
                               int defaultExpandLevel, int iconExpand, int iconNoExpand) {


        this.iconExpand = iconExpand;
        this.iconNoExpand = iconNoExpand;


        for (TreeNode treeNode : datas) {
            treeNode.getChildren().clear();
            treeNode.iconExpand = iconExpand;
            treeNode.iconNoExpand = iconNoExpand;
        }


        this.defaultExpandLevel = defaultExpandLevel;
        mContext = context;
/**
  * 对所有的Node进行排序
  */
        mAllTreeNodes = TreeHelper.getSortedNodes(datas, defaultExpandLevel);
/**
  * 过滤出可见的Node
  */
        mTreeNodes = TreeHelper.filterVisibleNode(mAllTreeNodes);
        mInflater = LayoutInflater.from(context);
/**
  * 设置节点点击时，可以展开以及关闭；并且将ItemClick事件继续往外公布
  */
        mTree.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view,
                                    int position, long id) {
                expandOrCollapse(position);


                Log.d(TAG, "----> position = " + position);


                if (onTreeNodeClickListener != null) {
                    onTreeNodeClickListener.onClick(mTreeNodes.get(position),
                            position);
                }
            }
        });
    }


    /**
     *  * @param mTree
     *  * @param context
     *  * @param datas
     *  * @param defaultExpandLevel 默认展开几级树
     *  
     */
    public BaseTreeListAdapter(ListView mTree, Context context, List<TreeNode> datas,
                               int defaultExpandLevel) {
        this(mTree, context, datas, defaultExpandLevel, -1, -1);
    }


    /**
     *  * 清除掉之前数据并刷新  重新添加
     *  *
     *  * @param mlists
     *  * @param defaultExpandLevel 默认展开几级列表
     *  
     */
    public void addDataAll(List<TreeNode> mlists, int defaultExpandLevel) {
        mAllTreeNodes.clear();
        addData(-1, mlists, defaultExpandLevel);
    }


    /**
     *  * 在指定位置添加数据并刷新 可指定刷新后显示层级
     *  *
     *  * @param index
     *  * @param mlists
     *  * @param defaultExpandLevel 默认展开几级列表
     *  
     */
    public void addData(int index, List<TreeNode> mlists, int defaultExpandLevel) {
        this.defaultExpandLevel = defaultExpandLevel;
        notifyData(index, mlists);
    }


    /**
     *  * 在指定位置添加数据并刷新
     *  *
     *  * @param index
     *  * @param mlists
     *  
     */
    public void addData(int index, List<TreeNode> mlists) {
        notifyData(index, mlists);
    }


    /**
     *  * 添加数据并刷新
     *  *
     *  * @param mlists
     *  
     */
    public void addData(List<TreeNode> mlists) {
        addData(mlists, defaultExpandLevel);
    }


    /**
     *  * 添加数据并刷新 可指定刷新后显示层级
     *  *
     *  * @param mlists
     *  * @param defaultExpandLevel
     *  
     */
    public void addData(List<TreeNode> mlists, int defaultExpandLevel) {
        this.defaultExpandLevel = defaultExpandLevel;
        notifyData(-1, mlists);
    }


    /**
     *  * 添加数据并刷新
     *  *
     *  * @param treeNode
     *  
     */
    public void addData(TreeNode treeNode) {
        addData(treeNode, defaultExpandLevel);
    }


    /**
     *  * 添加数据并刷新 可指定刷新后显示层级
     *  *
     *  * @param treeNode
     *  * @param defaultExpandLevel
     *  
     */
    public void addData(TreeNode treeNode, int defaultExpandLevel) {
        List<TreeNode> treeNodes = new ArrayList<>();
        treeNodes.add(treeNode);
        this.defaultExpandLevel = defaultExpandLevel;
        notifyData(-1, treeNodes);
    }


    /**
     *  * 刷新数据
     *  *
     *  * @param index
     *  * @param mListTreeNodes
     *  
     */
    private void notifyData(int index, List<TreeNode> mListTreeNodes) {
        for (int i = 0; i < mListTreeNodes.size(); i++) {
            TreeNode treeNode = mListTreeNodes.get(i);
            treeNode.getChildren().clear();
            treeNode.iconExpand = iconExpand;
            treeNode.iconNoExpand = iconNoExpand;
        }
        for (int i = 0; i < mAllTreeNodes.size(); i++) {
            TreeNode treeNode = mAllTreeNodes.get(i);
            treeNode.getChildren().clear();
            treeNode.isNewAdd = false;
        }
        if (index != -1) {
            mAllTreeNodes.addAll(index, mListTreeNodes);
        } else {
            mAllTreeNodes.addAll(mListTreeNodes);
        }
/**
      * 对所有的Node进行排序
      */
        mAllTreeNodes = TreeHelper.getSortedNodes(mAllTreeNodes, defaultExpandLevel);
/**
  * 过滤出可见的Node
  */
        mTreeNodes = TreeHelper.filterVisibleNode(mAllTreeNodes);
//刷新数据
        notifyDataSetChanged();
    }


    /**
     *  * 获取排序后所有节点
     *  *
     *  * @return
     *  
     */
    public List<TreeNode> getAllNodes() {
        if (mAllTreeNodes == null)
            mAllTreeNodes = new ArrayList<TreeNode>();
        return mAllTreeNodes;
    }


    /**
     *  * 相应ListView的点击事件 展开或关闭某节点
     *  *
     *  * @param position
     *  
     */
    public void expandOrCollapse(int position) {
        TreeNode n = mTreeNodes.get(position);


        if (n != null) {// 排除传入参数错误异常
            if (!n.isLeaf()) {
                n.setExpand(!n.isExpand());
                mTreeNodes = TreeHelper.filterVisibleNode(mAllTreeNodes);
                notifyDataSetChanged();// 刷新视图
            }
        }
    }


    @Override
    public int getCount() {
        return mTreeNodes.size();
    }


    @Override
    public Object getItem(int position) {
        return mTreeNodes.get(position);
    }


    @Override
    public long getItemId(int position) {
        return position;
    }


    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        TreeNode treeNode = mTreeNodes.get(position);
        convertView = getConvertView(treeNode, position, convertView, parent);
// 设置内边距
        convertView.setPadding(treeNode.getLevel() * 30, 3, 3, 3);
        return convertView;
    }


    /**
     *  * 设置多选
     *  *
     *  * @param treeNode
     *  * @param checked
     *  
     */
    public void setChecked(final TreeNode treeNode, boolean checked) {
        treeNode.setChecked(checked);
        setChildChecked(treeNode, checked);
        if (treeNode.getParent() != null)
            setNodeParentChecked(treeNode.getParent(), checked);
        notifyDataSetChanged();
    }


    /**
     *  * 设置是否选中
     *  *
     *  * @param treeNode
     *  * @param checked
     *  
     */
    public <T, B> void setChildChecked(TreeNode<T, B> treeNode, boolean checked) {
        if (!treeNode.isLeaf()) {
            treeNode.setChecked(checked);
            for (TreeNode childrenTreeNode : treeNode.getChildren()) {
                setChildChecked(childrenTreeNode, checked);
            }
        } else {
            treeNode.setChecked(checked);
        }
    }


    private void setNodeParentChecked(TreeNode treeNode, boolean checked) {
        if (checked) {
            treeNode.setChecked(checked);
            if (treeNode.getParent() != null)
                setNodeParentChecked(treeNode.getParent(), checked);
        } else {
            List<TreeNode> childrens = treeNode.getChildren();
            boolean isChecked = false;
            for (TreeNode children : childrens) {
                if (children.isChecked()) {
                    isChecked = true;
                }
            }
//如果所有自节点都没有被选中 父节点也不选中
            if (!isChecked) {
                treeNode.setChecked(checked);
            }
            if (treeNode.getParent() != null)
                setNodeParentChecked(treeNode.getParent(), checked);
        }
    }


    public abstract View getConvertView(TreeNode treeNode, int position,
                                        View convertView, ViewGroup parent);


    //在PatientsNameListActivity调用，获取选中的 患者 id -- boolean
    public Map<String, Boolean> getSelectPatientsNumMap() {
        return cbMap;
    }
}
