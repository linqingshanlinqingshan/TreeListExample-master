package com.example.administrator.treelistexample;

import android.util.Log;

import java.util.ArrayList;
import java.util.List;

public class TreeHelper {


    /**
     *  * 传入node  返回排序后的Node
     *  *
     *  * @param datas
     *  * @param defaultExpandLevel
     *  * @return
     *  * @throws IllegalArgumentException
     *  * @throws IllegalAccessException
     *  
     */
    public static List<TreeNode> getSortedNodes(List<TreeNode> datas,
                                                int defaultExpandLevel) {
        List<TreeNode> result = new ArrayList<TreeNode>();
// 设置Node间父子关系
        List<TreeNode> treeNodes = convetData2Node(datas);
// 拿到根节点
        List<TreeNode> rootTreeNodes = getRootNodes(treeNodes);
// 排序以及设置Node间关系
        for (TreeNode treeNode : rootTreeNodes) {
            addNode(result, treeNode, defaultExpandLevel, 1);
        }
        return result;
    }


    /**
     *  * 过滤出所有可见的Node
     *  *
     *  * @param treeNodes
     *  * @return
     *  
     */
    public static List<TreeNode> filterVisibleNode(List<TreeNode> treeNodes) {
        List<TreeNode> result = new ArrayList<TreeNode>();


        for (TreeNode treeNode : treeNodes) {
// 如果为跟节点，或者上层目录为展开状态
            if (treeNode.isRoot() || treeNode.isParentExpand()) {
                setNodeIcon(treeNode);
                result.add(treeNode);
            }
        }
        return result;
    }


    /**
     *  * 设置Node间，父子关系;让每两个节点都比较一次，即可设置其中的关系
     *  
     */
    private static List<TreeNode> convetData2Node(List<TreeNode> treeNodes) {


        for (int i = 0; i < treeNodes.size(); i++) {
            TreeNode n = treeNodes.get(i);
            for (int j = i + 1; j < treeNodes.size(); j++) {
                TreeNode m = treeNodes.get(j);
                if (m.getpId() instanceof String) {
                    if (m.getpId().equals(n.getId())) {
                        n.getChildren().add(m);
                        m.setParent(n);
                    } else if (m.getId().equals(n.getpId())) {
                        m.getChildren().add(n);
                        n.setParent(m);
                    }
                } else {
                    if (m.getpId() == n.getId()) {
                        n.getChildren().add(m);
                        m.setParent(n);
                    } else if (m.getId() == n.getpId()) {
                        m.getChildren().add(n);
                        n.setParent(m);
                    }
                }
            }
        }
        return treeNodes;
    }


    public static List<TreeNode> getRootNodes(List<TreeNode> treeNodes) {
        List<TreeNode> root = new ArrayList<TreeNode>();
        for (TreeNode treeNode : treeNodes) {
            if (treeNode.isRoot())
                root.add(treeNode);
        }
        return root;
    }


    /**
     *  * 把一个节点上的所有的内容都挂上去
     *  
     */
    private static <T, B> void addNode(List<TreeNode> treeNodes, TreeNode<T, B> treeNode,
                                       int defaultExpandLeval, int currentLevel) {
        treeNodes.add(treeNode);


        if (treeNode.isNewAdd && defaultExpandLeval >= currentLevel) {
            treeNode.setExpand(true);
        }


        if (treeNode.isLeaf())
            return;
        for (int i = 0; i < treeNode.getChildren().size(); i++) {


            TreeNode treeNode1 = treeNode.getChildren().get(i);
            String name = treeNode1.getStr1();
            Log.d("==TreeHelper name ", "-----> name = " + name);


            addNode(treeNodes, treeNode.getChildren().get(i), defaultExpandLeval,
                    currentLevel + 1);
        }
    }


    /**
     *  * 设置节点的图标
     *  *
     *  * @param treeNode
     *  
     */
    private static void setNodeIcon(TreeNode treeNode) {
        if (treeNode.getChildren().size() > 0 && treeNode.isExpand()) {
            treeNode.setIcon(treeNode.iconExpand);
        } else if (treeNode.getChildren().size() > 0 && !treeNode.isExpand()) {
            treeNode.setIcon(treeNode.iconNoExpand);
        } else {
            treeNode.setIcon(-1);
        }
    }


}