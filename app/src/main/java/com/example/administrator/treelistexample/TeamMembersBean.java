package com.example.administrator.treelistexample;

import android.os.Parcel;
import android.os.Parcelable;

import java.util.List;

public class TeamMembersBean<T> implements Parcelable {


    /**
     *  * flag : 1
     *  * url : 1
     *  * array : [{"id":"3","parent_id":"2","user_login":"root","user_pass":"###347e7247ea6960c1de65251c59554299","user_nicename":"高级领导","user_email":"7325464@qq.com","user_url":"null","avatar":null,"sex":"0","birthday":"2000-01-01","signature":null,"last_login_ip":"171.37.17.225","last_login_time":"2018-03-08 17:02:42","create_time":"2016-11-18 11:09:12","user_activation_key":"f7c7a162b6682fe9c4130290dbab3871","user_status":"1","user_rank":"3","user_type":"2","position":"0","mobile":"18607897620","entry_date":null,"id_card":null,"place_origin":null,"nation":null,"address":null,"paesent_address":null,"degree_education":null,"graduation_school":null,"graduation_date":null,"political_outlook":null,"remark":null,"rank_name":"城区卫计委","child":null}]
     *  * msg : 有数据
     *  
     */


    private int flag;
    private int url;
    private String msg;
    private List<ArrayBean> array;


    protected TeamMembersBean(Parcel in) {
        flag = in.readInt();
        url = in.readInt();
        msg = in.readString();
    }


    public static final Creator<TeamMembersBean> CREATOR = new Creator<TeamMembersBean>() {
        @Override
        public TeamMembersBean createFromParcel(Parcel in) {
            return new TeamMembersBean(in);
        }


        @Override
        public TeamMembersBean[] newArray(int size) {
            return new TeamMembersBean[size];
        }
    };


    public int getFlag() {
        return flag;
    }


    public void setFlag(int flag) {
        this.flag = flag;
    }


    public int getUrl() {
        return url;
    }


    public void setUrl(int url) {
        this.url = url;
    }


    public String getMsg() {
        return msg;
    }


    public void setMsg(String msg) {
        this.msg = msg;
    }


    public List<ArrayBean> getArray() {
        return array;
    }


    public void setArray(List<ArrayBean> array) {
        this.array = array;
    }


    @Override
    public int describeContents() {
        return 0;
    }


    @Override
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeInt(flag);
        parcel.writeInt(url);
        parcel.writeString(msg);
    }


    public static class ArrayBean<T> implements Parcelable {


        /**
         *  * id : 3
         *  * parent_id : 2
         *  * user_login : root
         *  * user_pass : ###347e7247ea6960c1de65251c59554299
         *  * user_nicename : 高级领导
         *  * user_email : 7325464@qq.com
         *  * user_url : null
         *  * avatar : null
         *  * sex : 0
         *  * birthday : 2000-01-01
         *  * signature : null
         *  * last_login_ip : 171.37.17.225
         *  * last_login_time : 2018-03-08 17:02:42
         *  * create_time : 2016-11-18 11:09:12
         *  * user_activation_key : f7c7a162b6682fe9c4130290dbab3871
         *  * user_status : 1
         *  * user_rank : 3
         *  * user_type : 2
         *  * position : 0
         *  * mobile : 18607897620
         *  * entry_date : null
         *  * id_card : null
         *  * place_origin : null
         *  * nation : null
         *  * address : null
         *  * paesent_address : null
         *  * degree_education : null
         *  * graduation_school : null
         *  * graduation_date : null
         *  * political_outlook : null
         *  * remark : null
         *  * rank_name : 城区卫计委
         *  * child : null
         *  
         */


        private String id;
        private String parent_id;
        private String user_login;
        private String user_pass;
        private String user_nicename;
        private String user_email;
        private String user_url;
        private Object avatar;
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
        private Object entry_date;
        private Object id_card;
        private Object place_origin;
        private Object nation;
        private Object address;
        private Object paesent_address;
        private Object degree_education;
        private Object graduation_school;
        private Object graduation_date;
        private Object political_outlook;
        private Object remark;
        private String rank_name;
        private List<TeamMembersChildBean> child;


        protected ArrayBean(Parcel in) {
            id = in.readString();
            parent_id = in.readString();
            user_login = in.readString();
            user_pass = in.readString();
            user_nicename = in.readString();
            user_email = in.readString();
            user_url = in.readString();
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
            rank_name = in.readString();
            child = in.createTypedArrayList(TeamMembersChildBean.CREATOR);
        }


        public static final Creator<ArrayBean> CREATOR = new Creator<ArrayBean>() {
            @Override
            public ArrayBean createFromParcel(Parcel in) {
                return new ArrayBean(in);
            }


            @Override
            public ArrayBean[] newArray(int size) {
                return new ArrayBean[size];
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


        public Object getAvatar() {
            return avatar;
        }


        public void setAvatar(Object avatar) {
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


        public Object getEntry_date() {
            return entry_date;
        }


        public void setEntry_date(Object entry_date) {
            this.entry_date = entry_date;
        }


        public Object getId_card() {
            return id_card;
        }


        public void setId_card(Object id_card) {
            this.id_card = id_card;
        }


        public Object getPlace_origin() {
            return place_origin;
        }


        public void setPlace_origin(Object place_origin) {
            this.place_origin = place_origin;
        }


        public Object getNation() {
            return nation;
        }


        public void setNation(Object nation) {
            this.nation = nation;
        }


        public Object getAddress() {
            return address;
        }


        public void setAddress(Object address) {
            this.address = address;
        }


        public Object getPaesent_address() {
            return paesent_address;
        }


        public void setPaesent_address(Object paesent_address) {
            this.paesent_address = paesent_address;
        }


        public Object getDegree_education() {
            return degree_education;
        }


        public void setDegree_education(Object degree_education) {
            this.degree_education = degree_education;
        }


        public Object getGraduation_school() {
            return graduation_school;
        }


        public void setGraduation_school(Object graduation_school) {
            this.graduation_school = graduation_school;
        }


        public Object getGraduation_date() {
            return graduation_date;
        }


        public void setGraduation_date(Object graduation_date) {
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


        @Override
        public int describeContents() {
            return 0;
        }


        @Override
        public void writeToParcel(Parcel parcel, int i) {
            parcel.writeString(id);
            parcel.writeString(parent_id);
            parcel.writeString(user_login);
            parcel.writeString(user_pass);
            parcel.writeString(user_nicename);
            parcel.writeString(user_email);
            parcel.writeString(user_url);
            parcel.writeString(sex);
            parcel.writeString(birthday);
            parcel.writeString(last_login_ip);
            parcel.writeString(last_login_time);
            parcel.writeString(create_time);
            parcel.writeString(user_activation_key);
            parcel.writeString(user_status);
            parcel.writeString(user_rank);
            parcel.writeString(user_type);
            parcel.writeString(position);
            parcel.writeString(mobile);
            parcel.writeString(rank_name);
            parcel.writeTypedList(child);
        }
    }
}