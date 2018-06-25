package com.fai.tools.model;

public class CbdPostModel {

    public String sessionId;
    public int contentId;
    public String content;
    public String sourceCode;

    public static class Content {
        public int id; //":1,
        public String title; //":"" // string 标题  如果有高亮则关键词部分是<em>关键词</em>
        public String titleAttrStr; //":"" // string 标题  去除<em>标签，用于编辑器直接展示
        public String appUrl; //":""
        public String h5Url; //":"",
        public String coverImgUrl; //":"" // string 默认图
        public String introduction; //":"" // string 描述（类型为问答时，问题的答案）如果有高亮则关键词部分是<em>关键词</em>
        public String introductionAttrStr; //":"" // string 描述 去除<em>标签，用于编辑器直接展示
        public int type; //":int // 帖子类型 社区前台接口设计-APP 相关枚举 17、直播，19、短视频
        public String typeColor; //":string // 标签对应的色值
        public String typeName; //":string // 标签的名称
        public long commentCnt; //":"" // long 评论数
        public long pv; //":"" // long 浏览数
        public String liveReplayUrl; //":"" //string 直播回放地址
        public String videoSourceFileUrl; //":"" //string 视频地址
        public long praiseCnt; //":"" // long 点赞数
        public int childType; //":"" // int（子类型，目前用于直播 10预告 20直播中 40回放）
        public String time; //":"" // 时间（目前用于直播时间）
        public Tag[] tagList;
        public Poi[] poiList;

        public static class Tag {
            public long tagId;
            public String tagName; //":String// 标签名称  如果有高亮则关键词部分是<em>关键词</em>
            public String appUrl; //":"",
            public String h5Url; //":""
        }

        public static class Poi {
            public long poiId;
            public String poiName;
            public String appUrl;
            public String h5Url;
        }

        public static class User {
            public long userId;
            public String custIndentity;
            public String headImage;
            public String nickName;
        }
    }
}