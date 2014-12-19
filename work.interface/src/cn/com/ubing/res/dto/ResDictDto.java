package cn.com.ubing.res.dto;

public class ResDictDto {
    /**
     * 主键
     */
    private String id;
    /**
     * 中文名
     */
    private String cname;

    /**
     * 英文名
     */
    private String ename;
    /**
     * 拼音首字母
     */
    private String pyszm;
    /**
     * 状态
     */
    private String status;
    /**
     * 是否热门
     */
    private String hotStatus;
    /**
     * 拼音首字母简拼
     */
    private String shortPy;

    private String type;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getCname() {
        return cname;
    }

    public void setCname(String cname) {
        this.cname = cname;
    }

    public String getEname() {
        return ename;
    }

    public void setEname(String ename) {
        this.ename = ename;
    }

    public String getPyszm() {
        return pyszm;
    }

    public void setPyszm(String pyszm) {
        this.pyszm = pyszm;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getHotStatus() {
        return hotStatus;
    }

    public void setHotStatus(String hotStatus) {
        this.hotStatus = hotStatus;
    }

    public String getShortPy() {
        return shortPy;
    }

    public void setShortPy(String shortPy) {
        this.shortPy = shortPy;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
}
