package model;

/**
 * @ClassName Accounts
 * @Description TODO
 * @Author 郑思婷
 * @Date 2019/6/14 11:31
 * @Version 1.0
 **/
public class Accounts {
    private int id;//账单id
    private int dealtype;//交易类型（1、商店卖给宠物主人2、宠物主人卖给商店）
    private int petid;//宠物id
    private int sellerid;//卖家id
    private int buyerid;//买家id
    private int price;//交易价格
    private String dealtime;//交易时间

    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
    public int getDealtype() {
        return dealtype;
    }
    public void setDealtype(int dealtype) {
        this.dealtype = dealtype;
    }
    public int getPetid() {
        return petid;
    }
    public void setPetid(int petid) {
        this.petid = petid;
    }
    public int getSellerid() {
        return sellerid;
    }
    public void setSellerid(int sellerid) {
        this.sellerid = sellerid;
    }
    public int getBuyerid() {
        return buyerid;
    }
    public void setBuyerid(int buyerid) {
        this.buyerid = buyerid;
    }
    public int getPrice() {
        return price;
    }
    public void setPrice(int price) {
        this.price = price;
    }
    public String getDealtime() {
        return dealtime;
    }
    public void setDealtime(String dealtime) {
        this.dealtime = dealtime;
    }


}
