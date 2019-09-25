package model;

/**
 * @ClassName PetStore
 * @Description TODO
 * @Author 郑思婷
 * @Date 2019/6/13  15:33
 * @Version 1.0
 **/
public class PetStore {
    private int id;//宠物商店id
    private String name;//宠物商店名字
    private String password;//宠物商店密码
    private int balance;//宠物商店结余

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
    public int getBalance() {
        return balance;
    }
    public void setBalance(int balance) {
        this.balance = balance;
    }

}
