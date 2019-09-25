package model;

/**
 * @ClassName Pet
 * @Description TODO
 * @Author 郑思婷
 * @Date 2019/6/13  11:32
 * @Version 1.0
 **/
public class Pet {
    private int id;//宠物id
    private String name;//宠物名字
    private String type;//宠物类型
    private int health;//宠物健康值
    private int love;//宠物与主人亲密度
    private String birthday;//宠物出生日期
    private int ownerid;//宠物主人id；
    private int storeid;//宠物所属商店
    private int money;//宠物的价格

    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public String getType() {
        return type;
    }
    public void setType(String type) {
        this.type = type;
    }
    public int getHealth() {
        return health;
    }
    public void setHealth(int health) {
        this.health = health;
    }
    public int getLove() {
        return love;
    }
    public void setLove(int love) {
        this.love = love;
    }
    public String getBirthday() {
        return birthday;
    }
    public void setBirthday(String birthday) {
        this.birthday = birthday;
    }
    public int getOwnerid() {
        return ownerid;
    }
    public void setOwnerid(int ownerid) {
        this.ownerid = ownerid;
    }
    public int getStoreid() {
        return storeid;
    }
    public void setStoreid(int storeid) {
        this.storeid = storeid;
    }
    public int getMoney() { return money; }
    public void setMoney(int money) { this.money = money; }
}
