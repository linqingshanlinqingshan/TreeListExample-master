package com.example.administrator.treelistexample;

import java.util.ArrayList;
import java.util.List;

public class TreeNode<T, B> {


    /**
     *  * 传入的实体对象
     *  
     */
    public List<B> bean;
    /**
     *  * 设置开启 关闭的图片
     *  
     */
    public int iconExpand = -1, iconNoExpand = -1;


    private T id;
    /**
     *  * 根节点pId为0
     *  
     */
    private T pId;


    private String str1;
    private String iconUrl;
    private String patient_sn;
    private String str2;
    private String str3;
    private String str4;
    private List<String> patients_id_list;


    /**
     *  * 当前的级别
     *  
     */
    private int level;


    /**
     *  * 是否展开
     *  
     */
    private boolean isExpand = false;


    private int icon = -1;


    /**
     *  * 下一级的子Node
     *  
     */
    private List<TreeNode> children = new ArrayList<>();


    /**
     *  * 父Node
     *  
     */
    private TreeNode parent;
    /**
     *  * 是否被checked选中
     *  
     */
    private boolean isChecked;
    /**
     *  * 是否为新添加的
     *  
     */
    public boolean isNewAdd = true;


    public boolean isChecked() {
        return isChecked;
    }


    public void setChecked(boolean isChecked) {
        this.isChecked = isChecked;
    }


    public TreeNode() {
    }


    public TreeNode(T id, T pId, String str1) {
        super();
        this.id = id;
        this.pId = pId;
        this.str1 = str1;
    }


    public TreeNode(T id, T pId, String str1, String str2) {
        super();
        this.id = id;
        this.pId = pId;
        this.str1 = str1;
        this.str2 = str2;


    }


    public TreeNode(T id, T pId, String str1, String str2, String str3) {
        super();
        this.id = id;
        this.pId = pId;
        this.str1 = str1;
        this.str2 = str2;
        this.str3 = str3;


    }


    public TreeNode(T id, T pId, String str1, String str2, String str3, String str4) {
        super();
        this.id = id;
        this.pId = pId;
        this.str1 = str1;
        this.str2 = str2;
        this.str3 = str3;
        this.str4 = str4;


    }


    public TreeNode(T id, T pId, String str1, String str2, List<String> patients_id_list) {
        super();
        this.id = id;
        this.pId = pId;
        this.str1 = str1;
        this.str2 = str2;
        this.patients_id_list = patients_id_list;


    }


    public TreeNode(T id, T pId, String str1, List<B> bean, String patient_sn) {
        super();
        this.id = id;
        this.pId = pId;
        this.str1 = str1;
        this.bean = bean;
        this.patient_sn = patient_sn;
    }


    public TreeNode(List<B> bean) {
        super();
        this.bean = bean;
    }


    public TreeNode(T id, T pId, List<B> bean) {
        super();
        this.id = id;
        this.pId = pId;
        this.bean = bean;
    }


    public String getStr4() {
        return str4;
    }


    public void setStr4(String str4) {
        this.str4 = str4;
    }


    public String getStr1() {
        return str1;
    }


    public void setStr1(String str1) {
        this.str1 = str1;
    }


    public String getStr2() {
        return str2;
    }


    public void setStr2(String str2) {
        this.str2 = str2;
    }


    public String getStr3() {
        return str3;
    }


    public void setStr3(String str3) {
        this.str3 = str3;
    }


    public List<String> getPatients_id_list() {
        return patients_id_list;
    }


    public void setPatients_id_list(List<String> patients_id_list) {
        this.patients_id_list = patients_id_list;
    }


    public String getPatient_sn() {
        return patient_sn;
    }


    public void setPatient_sn(String patient_sn) {
        this.patient_sn = patient_sn;
    }


    public String getIconUrl() {
        return iconUrl;
    }


    public void setIconUrl(String iconUrl) {
        this.iconUrl = iconUrl;
    }


    public List<B> getBean() {
        return bean;
    }


    public int getIcon() {
        return icon;
    }


    public void setIcon(int icon) {
        this.icon = icon;
    }


    public T getId() {
        return id;
    }


    public void setId(T id) {
        this.id = id;
    }


    public T getpId() {
        return pId;
    }


    public void setpId(T pId) {
        this.pId = pId;
    }


    public void setLevel(int level) {
        this.level = level;
    }


    public boolean isExpand() {
        return isExpand;
    }


    public List<TreeNode> getChildren() {
        return children;
    }


    public void setChildren(List<TreeNode> children) {
        this.children = children;
    }


    public TreeNode getParent() {
        return parent;
    }


    public void setParent(TreeNode parent) {
        this.parent = parent;
    }


    /**
     *  * 是否为跟节点
     *  *
     *  * @return
     *  
     */
    public boolean isRoot() {
        return parent == null;
    }


    /**
     *  * 判断父节点是否展开
     *  *
     *  * @return
     *  
     */
    public boolean isParentExpand() {
        if (parent == null)
            return false;
        return parent.isExpand();
    }


    /**
     *  * 是否是叶子界点
     *  *
     *  * @return
     *  
     */
    public boolean isLeaf() {
        return children.size() == 0;
    }


    /**
     *  * 获取level
     *  
     */
    public int getLevel() {


        return parent == null ? 0 : parent.getLevel() + 1;
    }


    /**
     *  * 设置展开
     *  *
     *  * @param isExpand
     *  
     */
    public void setExpand(boolean isExpand) {
        this.isExpand = isExpand;
        if (!isExpand) {


            for (TreeNode treeNode : children) {
                treeNode.setExpand(isExpand);
            }
        }
    }
}