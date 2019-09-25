package model;

/**
 * @ClassName PetOwner
 * @Description TODO
 * @Author 郑思婷
 * @Date 2019/6/13  11:50
 * @Version 1.0
 **/
public class PetOwner {
    private int id;//主人id
    private String name;//主人名字
    private String password;//主人密码
    private int money;//主人的元宝

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
    public String getPassword() {
        return password;
    }
    public void setPassword(String password) {
        this.password = password;
    }
    public int getMoney() {
        return money;
    }
    public void setMoney(int money) {
        this.money = money;
    }

}
