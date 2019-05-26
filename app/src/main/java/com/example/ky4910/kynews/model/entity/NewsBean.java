package com.example.ky4910.kynews.model.entity;

import java.util.List;

public class NewsBean {

    /**
     * code : 200
     * data : {"list":[{"aid":"MTEzMDc4NzE","title":"全球半导体板块表现抢眼：景气度回升 关注两事件","headpic":"http://cms-bucket.ws.126.net/2019/03/19/d149ff9b6747401f98329700bf7c0940.png","writer":"","source":"中国证券报","source_url":"http://money.163.com/19/0319/07/EAK5JEM9002580S6.html","reply_count":0,"click_count":0,"pub_time":1552924800},{"aid":"MTEzMDc4NzA","title":"能源股金融股提振 道指四连涨 英股创五个月新高","headpic":"http://cms-bucket.ws.126.net/2019/03/19/a0ce78da36db479fbce546a57610c7a1.png","writer":"","source":"华尔街见闻","source_url":"http://money.163.com/19/0319/07/EAK5R8GN00258152.html","reply_count":0,"click_count":0,"pub_time":1552950980}],"page":1,"psize":10,"count":10,"total":1327}
     * msg : success
     */

    private String code;
    private DataBean data;
    private String msg;

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public DataBean getData() {
        return data;
    }

    public void setData(DataBean data) {
        this.data = data;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public static class DataBean {
        /**
         * list : [{"aid":"MTEzMDc4NzE",
                    "title":"全球半导体板块表现抢眼：景气度回升 关注两事件",
                    "headpic":"http://cms-bucket.ws.126.net/2019/03/19/d149ff9b6747401f98329700bf7c0940.png",
                    "writer":"",
                    "source":"中国证券报",
                    "source_url":"http://money.163.com/19/0319/07/EAK5JEM9002580S6.html",
                    "reply_count":0,
                    "click_count":0,
                    "pub_time":1552924800}]
         * page : 1
         * psize : 10
         * count : 10
         * total : 1327
         */

        private int page;
        private int psize;
        private int count;
        private int total;
        private List<ListBean> list;

        public int getPage() {
            return page;
        }

        public void setPage(int page) {
            this.page = page;
        }

        public int getPsize() {
            return psize;
        }

        public void setPsize(int psize) {
            this.psize = psize;
        }

        public int getCount() {
            return count;
        }

        public void setCount(int count) {
            this.count = count;
        }

        public int getTotal() {
            return total;
        }

        public void setTotal(int total) {
            this.total = total;
        }

        public List<ListBean> getList() {
            return list;
        }

        public void setList(List<ListBean> list) {
            this.list = list;
        }

        public static class ListBean {
            /**
             * aid : MTEzMDc4NzE
             * title : 全球半导体板块表现抢眼：景气度回升 关注两事件
             * headpic : http://cms-bucket.ws.126.net/2019/03/19/d149ff9b6747401f98329700bf7c0940.png
             * writer :
             * source : 中国证券报
             * source_url : http://money.163.com/19/0319/07/EAK5JEM9002580S6.html
             * reply_count : 0
             * click_count : 0
             * pub_time : 1552924800
             */

            private String aid;
            private String title;
            private String headpic;
            private String writer;
            private String source;
            private String source_url;
            private int reply_count;
            private int click_count;
            private int pub_time;

            public String getAid() {
                return aid;
            }

            public void setAid(String aid) {
                this.aid = aid;
            }

            public String getTitle() {
                return title;
            }

            public void setTitle(String title) {
                this.title = title;
            }

            public String getHeadpic() {
                return headpic;
            }

            public void setHeadpic(String headpic) {
                this.headpic = headpic;
            }

            public String getWriter() {
                return writer;
            }

            public void setWriter(String writer) {
                this.writer = writer;
            }

            public String getSource() {
                return source;
            }

            public void setSource(String source) {
                this.source = source;
            }

            public String getSource_url() {
                return source_url;
            }

            public void setSource_url(String source_url) {
                this.source_url = source_url;
            }

            public int getReply_count() {
                return reply_count;
            }

            public void setReply_count(int reply_count) {
                this.reply_count = reply_count;
            }

            public int getClick_count() {
                return click_count;
            }

            public void setClick_count(int click_count) {
                this.click_count = click_count;
            }

            public int getPub_time() {
                return pub_time;
            }

            public void setPub_time(int pub_time) {
                this.pub_time = pub_time;
            }

            public ListBean(String aid, String title, String headpic, String writer, String source, String source_url, int reply_count, int click_count, int pub_time) {
                this.aid = aid;
                this.title = title;
                this.headpic = headpic;
                this.writer = writer;
                this.source = source;
                this.source_url = source_url;
                this.reply_count = reply_count;
                this.click_count = click_count;
                this.pub_time = pub_time;
            }
        }
    }
}
