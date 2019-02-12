package com.example.administrator.treelistexample;

import android.os.Parcel;
import android.os.Parcelable;

import java.util.List;

public class TeamMembersChildBean<T> implements Parcelable {

    /**
     *      * id : 4
     *      * parent_id : 3
     *      * user_login : 732546400_qq_com
     *      * user_pass : ###347e7247ea6960c1de65251c59554299
     *      * user_nicename : 黄大锤
     *      * user_email : 732546400@qq.com
     *      * user_url : null
     *      * avatar : http://bh.nnmzkj.com/data/upload/avatar/59c329ddb7efe.jpg
     *      * sex : 0
     *      * birthday : 2000-01-01
     *      * signature : null
     *      * last_login_ip : 171.37.17.225
     *      * last_login_time : 2018-03-08 16:51:19
     *      * create_time : 2016-11-24 15:41:11
     *      * user_activation_key : null
     *      * user_status : 1
     *      * user_rank : 6
     *      * user_type : 2
     *      * position : 社区会主任
     *      * mobile : 18607897627
     *      * entry_date : 2010-08-08
     *      * id_card : 452122197808256545
     *      * place_origin : 广西
     *      * nation : 汉
     *      * address : 广西壮族自治区北海市合浦县某某村
     *      * paesent_address : 广西壮族自治区北海市合浦县某某村
     *      * degree_education : 大专
     *      * graduation_school : 广西机电职业技术学院
     *      * graduation_date : 2013-08
     *      * political_outlook : null
     *      * remark : null
     *      * rank_name : 社区会
     *      
     */


    private String id;
    private String parent_id;
    private String user_login;
    private String user_pass;
    private String user_nicename;
    private String user_email;
    private String user_url;
    private String avatar;
    private String sex;
    private String birthday;
    private Object signature;
    private String last_login_ip;
    private String last_login_time;
    private String create_time;
    private String user_activation_key;
    private String user_status;
    private String user_rank;
    private String user_type;
    private String position;
    private String mobile;
    private String entry_date;
    private String id_card;
    private String place_origin;
    private String nation;
    private String address;
    private String paesent_address;
    private String degree_education;
    private String graduation_school;
    private String graduation_date;
    private Object political_outlook;
    private Object remark;
    private String rank_name;


    private List<TeamMembersChildBean> child;


    protected TeamMembersChildBean(Parcel in) {
        id = in.readString();
        parent_id = in.readString();
        user_login = in.readString();
        user_pass = in.readString();
        user_nicename = in.readString();
        user_email = in.readString();
        user_url = in.readString();
        avatar = in.readString();
        sex = in.readString();
        birthday = in.readString();
        last_login_ip = in.readString();
        last_login_time = in.readString();
        create_time = in.readString();
        user_activation_key = in.readString();
        user_status = in.readString();
        user_rank = in.readString();
        user_type = in.readString();
        position = in.readString();
        mobile = in.readString();
        entry_date = in.readString();
        id_card = in.readString();
        place_origin = in.readString();
        nation = in.readString();
        address = in.readString();
        paesent_address = in.readString();
        degree_education = in.readString();
        graduation_school = in.readString();
        graduation_date = in.readString();
        rank_name = in.readString();
        child = in.createTypedArrayList(TeamMembersChildBean.CREATOR);
    }


    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(id);
        dest.writeString(parent_id);
        dest.writeString(user_login);
        dest.writeString(user_pass);
        dest.writeString(user_nicename);
        dest.writeString(user_email);
        dest.writeString(user_url);
        dest.writeString(avatar);
        dest.writeString(sex);
        dest.writeString(birthday);
        dest.writeString(last_login_ip);
        dest.writeString(last_login_time);
        dest.writeString(create_time);
        dest.writeString(user_activation_key);
        dest.writeString(user_status);
        dest.writeString(user_rank);
        dest.writeString(user_type);
        dest.writeString(position);
        dest.writeString(mobile);
        dest.writeString(entry_date);
        dest.writeString(id_card);
        dest.writeString(place_origin);
        dest.writeString(nation);
        dest.writeString(address);
        dest.writeString(paesent_address);
        dest.writeString(degree_education);
        dest.writeString(graduation_school);
        dest.writeString(graduation_date);
        dest.writeString(rank_name);
        dest.writeTypedList(child);
    }


    @Override
    public int describeContents() {
        return 0;
    }


    public static final Creator<TeamMembersChildBean> CREATOR = new Creator<TeamMembersChildBean>() {
        @Override
        public TeamMembersChildBean createFromParcel(Parcel in) {
            return new TeamMembersChildBean(in);
        }


        @Override
        public TeamMembersChildBean[] newArray(int size) {
            return new TeamMembersChildBean[size];
        }
    };


    public List<TeamMembersChildBean> getChild() {
        return child;
    }


    public void setChild(List<TeamMembersChildBean> child) {
        this.child = child;
    }


    public String getId() {
        return id;
    }


    public void setId(String id) {
        this.id = id;
    }


    public String getParent_id() {
        return parent_id;
    }


    public void setParent_id(String parent_id) {
        this.parent_id = parent_id;
    }


    public String getUser_login() {
        return user_login;
    }


    public void setUser_login(String user_login) {
        this.user_login = user_login;
    }


    public String getUser_pass() {
        return user_pass;
    }


    public void setUser_pass(String user_pass) {
        this.user_pass = user_pass;
    }


    public String getUser_nicename() {
        return user_nicename;
    }


    public void setUser_nicename(String user_nicename) {
        this.user_nicename = user_nicename;
    }


    public String getUser_email() {
        return user_email;
    }


    public void setUser_email(String user_email) {
        this.user_email = user_email;
    }


    public String getUser_url() {
        return user_url;
    }


    public void setUser_url(String user_url) {
        this.user_url = user_url;
    }


    public String getAvatar() {
        return avatar;
    }


    public void setAvatar(String avatar) {
        this.avatar = avatar;
    }


    public String getSex() {
        return sex;
    }


    public void setSex(String sex) {
        this.sex = sex;
    }


    public String getBirthday() {
        return birthday;
    }


    public void setBirthday(String birthday) {
        this.birthday = birthday;
    }


    public Object getSignature() {
        return signature;
    }


    public void setSignature(Object signature) {
        this.signature = signature;
    }


    public String getLast_login_ip() {
        return last_login_ip;
    }


    public void setLast_login_ip(String last_login_ip) {
        this.last_login_ip = last_login_ip;
    }


    public String getLast_login_time() {
        return last_login_time;
    }


    public void setLast_login_time(String last_login_time) {
        this.last_login_time = last_login_time;
    }


    public String getCreate_time() {
        return create_time;
    }


    public void setCreate_time(String create_time) {
        this.create_time = create_time;
    }


    public String getUser_activation_key() {
        return user_activation_key;
    }


    public void setUser_activation_key(String user_activation_key) {
        this.user_activation_key = user_activation_key;
    }


    public String getUser_status() {
        return user_status;
    }


    public void setUser_status(String user_status) {
        this.user_status = user_status;
    }


    public String getUser_rank() {
        return user_rank;
    }


    public void setUser_rank(String user_rank) {
        this.user_rank = user_rank;
    }


    public String getUser_type() {
        return user_type;
    }


    public void setUser_type(String user_type) {
        this.user_type = user_type;
    }


    public String getPosition() {
        return position;
    }


    public void setPosition(String position) {
        this.position = position;
    }


    public String getMobile() {
        return mobile;
    }


    public void setMobile(String mobile) {
        this.mobile = mobile;
    }


    public String getEntry_date() {
        return entry_date;
    }


    public void setEntry_date(String entry_date) {
        this.entry_date = entry_date;
    }


    public String getId_card() {
        return id_card;
    }


    public void setId_card(String id_card) {
        this.id_card = id_card;
    }


    public String getPlace_origin() {
        return place_origin;
    }


    public void setPlace_origin(String place_origin) {
        this.place_origin = place_origin;
    }


    public String getNation() {
        return nation;
    }


    public void setNation(String nation) {
        this.nation = nation;
    }


    public String getAddress() {
        return address;
    }


    public void setAddress(String address) {
        this.address = address;
    }


    public String getPaesent_address() {
        return paesent_address;
    }


    public void setPaesent_address(String paesent_address) {
        this.paesent_address = paesent_address;
    }


    public String getDegree_education() {
        return degree_education;
    }


    public void setDegree_education(String degree_education) {
        this.degree_education = degree_education;
    }


    public String getGraduation_school() {
        return graduation_school;
    }


    public void setGraduation_school(String graduation_school) {
        this.graduation_school = graduation_school;
    }


    public String getGraduation_date() {
        return graduation_date;
    }


    public void setGraduation_date(String graduation_date) {
        this.graduation_date = graduation_date;
    }


    public Object getPolitical_outlook() {
        return political_outlook;
    }


    public void setPolitical_outlook(Object political_outlook) {
        this.political_outlook = political_outlook;
    }


    public Object getRemark() {
        return remark;
    }


    public void setRemark(Object remark) {
        this.remark = remark;
    }


    public String getRank_name() {
        return rank_name;
    }


    public void setRank_name(String rank_name) {
        this.rank_name = rank_name;
    }
}