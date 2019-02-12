package com.example.administrator.treelistexample;


import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ListView;

import com.google.gson.Gson;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * 参考网上的 demo 写的类
 */
public class MainActivity extends Activity implements OnTreeNodeClickListener, View.OnClickListener {

    String TAG = "==MainActivity";
    TreeNode treeNode;
    BaseTreeListAdapter mAdapter;

    List<String> idList;
    List<String> parent_idList;
    List<String> nameList;
    List<String> positionList;
    List<String> avatarList;
    List<String> user_rankList;
    List<TreeNode> mDatas;


    ListView mTree;
    Gson gson;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        gson = new Gson();

        mTree = findViewById(R.id.mTree);

        idList = new ArrayList<>();
        parent_idList = new ArrayList<>();
        nameList = new ArrayList<>();
        positionList = new ArrayList<>();
        avatarList = new ArrayList<>();
        user_rankList = new ArrayList<>();

        mDatas = new ArrayList<>();

        initData();


    }


    @Override
    public void onClick(TreeNode treeNode, int position) {


    }


    @Override
    public void onClick(View view) {


    }


    private void initData() {


        String s = ReadLocalFileUtils.readFile(this, "help.txt");


//是否是字符串， false 否
        boolean json = OtherUtil.isJson(s);
        if (!json) {
            return;
        }


        TeamMembersBean teamMembersBean = gson.fromJson(s, TeamMembersBean.class);


        if (teamMembersBean == null) {


        } else {
            int flag = teamMembersBean.getFlag();
            String msg = teamMembersBean.getMsg();
            if (flag == 0) {


            } else if (flag == 1) {
                List<TeamMembersBean.ArrayBean> array = teamMembersBean.getArray();
                if (array == null) {


                } else {
                    Log.d(TAG, "------> array.size() = " + array.size());


                    for (int i = 0; i < array.size(); i++) {
                        String avatar = (String) array.get(i).getAvatar();
                        String user_nicename = array.get(i).getUser_nicename();
                        String position = array.get(i).getPosition();
                        String id = array.get(i).getId();
                        String parent_id = array.get(i).getParent_id();
                        String user_rank = array.get(i).getUser_rank();


                        nameList.add(user_nicename);
                        positionList.add(position);
                        avatarList.add(avatar);
                        idList.add(id);
                        parent_idList.add(parent_id);
                        user_rankList.add(user_rank);


                        Log.d(TAG, "------> avatar = " + avatar);
                        Log.d(TAG, "------> user_nicename = " + user_nicename + " --- > i = " + i);
                        Log.d(TAG, "------> position = " + position);
                        Log.d(TAG, "------> id = " + id);
                        Log.d(TAG, "------> parent_id = " + parent_id);
                        Log.d(TAG, "------> user_rank = " + user_rank);


                        List<TeamMembersChildBean> child = array.get(i).getChild();
                        if (child == null) {


                        } else {
                            Log.d(TAG, "------> child.size() = " + child.size());
                            parseBean(child);


                        }
                    }


                    initAll();
                }
            }
        }
    }


    List<TeamMembersChildBean> childs;


    private void parseBean(List<TeamMembersChildBean> child) {


        if (child == null) {


        } else {
            for (int j = 0; j < child.size(); j++) {
                String user_nicename = child.get(j).getUser_nicename();
                String position = child.get(j).getPosition();
                String avatar = child.get(j).getAvatar();
                String id = child.get(j).getId();
                String parent_id = child.get(j).getParent_id();
                String user_rank = child.get(j).getUser_rank();


                nameList.add(user_nicename);
                positionList.add(position);
                avatarList.add(avatar);
                idList.add(id);
                parent_idList.add(parent_id);
                user_rankList.add(user_rank);


                Log.d(TAG, "------> avatar = " + avatar);
                Log.d(TAG, "------> user_nicename = " + user_nicename + " --- > j = " + j);
                Log.d(TAG, "------> position = " + position);
                Log.d(TAG, "------> id = " + id);
                Log.d(TAG, "------> parent_id = " + parent_id);
                Log.d(TAG, "------> user_rank = " + user_rank);


                childs = child.get(j).getChild();


            }


            if (childs == null) {
                Log.d(TAG, "----------> childs == null 结束");


            } else if (childs != null && childs.size() == 0) {
                Log.d(TAG, "----------> childs != null && childs.size() == 0 结束");


            } else if (childs.size() != 0) {
                parseBean(childs);
            }
        }
    }


    private void initAll() {


        if (mDatas != null) {
            mDatas.clear();
        }


        if (avatarList != null && nameList != null && user_rankList != null &&
                idList != null && parent_idList != null && positionList != null) {


            for (int i = 0; i < nameList.size(); i++) {


                Log.i(TAG, "----> parent_idList = " + parent_idList.get(i) + "  ----> idList = " + idList.get(i));


                treeNode = new TreeNode(idList.get(i), parent_idList.get(i), nameList.get(i),
                        positionList.get(i), avatarList.get(i), user_rankList.get(i));
                mDatas.add(treeNode);


            }
        }


//第一个参数  ListView
//第二个参数  上下文
//第三个参数  数据集
//第四个参数  默认展开层级数 0为不展开
//第五个参数  展开的图标
//第六个参数  闭合的图标


        Log.d(TAG, "-------> idList.size() = " + idList.size());


        mAdapter = new ShowTeamMembersAdapter(mTree, this,
                mDatas, 0, R.mipmap.down, R.mipmap.up);


        mAdapter.setOnTreeNodeClickListener(this);


        mTree.setAdapter(mAdapter);


        List<TreeNode> rootTreeNodes = TreeHelper.getRootNodes(mDatas);
        for (int k = 0; k < rootTreeNodes.size(); k++) {
            String name = rootTreeNodes.get(k).getStr1();
            Log.d(TAG, "-------> k = " + k + " -----> name = " + name);
        }


        for (int d = 0; d < mDatas.size(); d++) {
            String name = mDatas.get(d).getStr1();
            boolean leaf = mDatas.get(d).isLeaf();
            Log.d(TAG, "-------> d = " + d + " -----> name = " + name + " ----> leaf = " + leaf);


            if (leaf) {


                int level = mDatas.get(d).getLevel();
                Log.d(TAG, "-------> d = " + d +
                        " -----> name = " + name +
                        " ----> leaf = " + leaf +
                        " ----> level = " + level);


                TreeNode parent = mDatas.get(d).getParent();


                if (parent == null) {


                } else {
                    showLevel(parent);
                }


                return;
            }
        }
    }


    List<Integer> index = new ArrayList<>();


    /**
     *  * 找到最顶层的第一级
     *  *
     *  * @param parent_
     *  
     */

    private void showLevel(TreeNode parent_) {


        String name = parent_.getStr1();
        TreeNode parent = parent_.getParent();


        int level = parent_.getLevel();


        index.add(level);


        boolean leaf = parent_.isLeaf();


        Log.d(TAG, "-------> showLevel " +
                " -----> name = " + name +
                " ----> leaf = " + leaf +
                " ----> level = " + level);


        if (parent == null) {


            onClickListViewItem();


        } else {


            showLevel(parent);


        }
    }


    /**
     *  * 点击展开
     *  
     */
    private void onClickListViewItem() {
        if (index != null && index.size() != 0) {
            Collections.reverse(index);
            for (int s = 0; s < index.size(); s++) {
                int integer = index.get(s);
                Log.d(TAG, "----> index = " + integer);
                mAdapter.expandOrCollapse(integer);
                mAdapter.notifyDataSetChanged();
            }
        }
    }
}
