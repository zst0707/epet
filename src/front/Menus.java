package front;

import model.Pet;
import model.PetOwner;
import model.PetStore;
import service.AccountService;
import service.PetOwnerService;
import service.PetService;
import service.PetStoreService;

import java.util.List;
import java.util.Scanner;

/**
 * @ClassName Menus
 * @Description TODO
 * @Author 郑思婷
 * @Date 2019/7/311:28
 * @Version 1.0
 **/
public class Menus {
    Scanner in = new Scanner(System.in);
    /**
     * 启动方法
     */
    public void  Start(){
        //宠物实现类对象
        PetService ps=new PetService();
        //宠物主人实现类对象
        PetOwnerService pos=new PetOwnerService();
        //宠物商店类对象
        PetStoreService pss=new PetStoreService();
        System.out.println("宠物店启动");
        System.out.println("浅肤色的女精灵醒来，所有宠物从MySQL中醒来");
        System.out.println("----------------------------------------");
        System.out.println("序号\t宠物名称");
        ps.selectallpet();
        System.out.println("----------------------------------------");
        System.out.println("所有宠物主人从MySQL中醒来");
        System.out.println("-----------------------------------------");
        System.out.println("序号\t主人姓名");
        pos.selectallowner();
        System.out.println("------------------------------------------");
        System.out.println("所有宠物商店从MySQL中醒来");
        System.out.println("------------------------------------------");
        System.out.println("序号\t宠物商店名称");
       pss.selectallstore();
    }

    /**
     * 登录
     */
    public boolean login(int num){
        //宠物主人实现类对象
        PetOwnerService pos = new PetOwnerService();
        //宠物商店实现类对象
        PetStoreService pss = new PetStoreService();
        //宠物主人实体类对象
        PetOwner p = new PetOwner();
        //宠物商店实体类对象
        PetStore pt = new PetStore();
        switch (num) {
            case 1:
                System.out.println("请先登录，请您输入主人的名字");
                String name = in.next();
                System.out.println("请您输入主人的密码");
                String key = in.next();
                PetOwner po = new PetOwner();
                po.setName(name);
                po.setPassword(key);
                p=pos.selectowner(po);
                if (pos.login(p) != null) {
                    System.out.println("------恭喜您成功登录------");
                    System.out.println("名字：" + pos.login(p).getName());
                    System.out.println("元宝数：" + pos.login(p).getMoney());
                    System.out.println("登录成功，您可以购买和卖出宠物，如果您想购买宠物请输入1，如果想卖出宠物请输入2");
                    boolean time= true;
                    while(time)
                    {
                        p=pos.selectowner(po);
                        System.out.println("1、购买宠物\n2、卖出宠物\n3、退出");
                        int zhuid = p.getId();
                        int num1 = in.nextInt();
                        switch (num1) {
                            case 1:
                                buy(num, zhuid, name, key);
                                break;
                            case 2:
                                sell(num, zhuid, name, key);
                                break;
                            case 3:
                                time = false;
                                break;
                            default:
                                System.out.println("请规范输入：");
                                break;
                        }
                    }

                }
                else {
                    System.out.println("登录失败");
                    login(num);
                }
                break;
            case 2:
                System.out.println("请先登录，请输入商铺的ID");
                int id1 = Integer.parseInt(in.next());
                System.out.println("请输入商铺密码");
                String key1 = in.next();
                pt.setId(id1);
                pt.setPassword(key1);
                if (pss.storelogin(pt) != null) {
                    System.out.println("-----恭喜您成功登录-----");
                    System.out.println("名字：" + pss.storelogin(pt).getName());
                    System.out.println("余额：" + pss.storelogin(pt).getBalance());
                    boolean time1=true;

                    while (time1) {
                        System.out.println("————请选择————\n1、查询原有宠物信息\n2、查询新培育宠物信息\n3、培育新宠物\n4、查看台账\n5、退出");
                        System.out.println("———————————");
                        int cho = in.nextInt();
                        switch (cho) {
                            case 1:
                                PetService ps = new PetService();
                                System.out.println("序号\t宠物名称\t类型\t元宝数");
                                ps.selectownerpet(id1);
                                break;
                            case 2:
                                PetService p1 = new PetService();
                                System.out.println("序号\t宠物名称\t类型\t元宝数");
                                p1.getnewpet(id1);
                                break;
                            case 3:
                                System.out.println("请输入宠物ID：");
                                Scanner ac = new Scanner(System.in);
                                String newid = ac.next();
                                System.out.println("请输入宠物名字：");
                                String newname = in.next();
                                System.out.println("请输入宠物品种：");
                                String newtype = in.next();
                                System.out.println("请输入宠物所属商店ID：");
                                String newstore = in.next();
                                System.out.println("请输入宠物的健康值(1-5)：");
                                String newhealth = in.next();
                                System.out.println("请输入宠物的亲密度(1-100)：");
                                String newlove = in.next();
                                System.out.println("请输入宠物的出生日期：");
                                String newbirthday = in.next();
                                System.out.println("请输入宠物的价格(即元宝数)：");
                                String newmoney=in.next();
                                Pet pet = new Pet();
                                pet.setName(newname);
                                pet.setType(newtype);
                                pet.setId(Integer.parseInt(newid));
                                pet.setStoreid(Integer.parseInt(newstore));
                                pet.setBirthday(newbirthday);
                                pet.setHealth(Integer.parseInt(newhealth));
                                pet.setLove(Integer.parseInt(newlove));
                                pet.setMoney(Integer.parseInt(newmoney));
                                pss.newpet(pet);
                                break;
                            case 4:
                                AccountService as = new AccountService();
                                System.out.println("宠物ID\t交易类型(1为主人卖给商店；2为商店卖给主人)\t交易时间");
                                as.allbill();
                                break;
                            case 5:
                                time1=false;
                                break;
                        }
                    }
                } else {
                    System.out.println("登录失败");
                    login(num);
                }
                break;
            case 3:
                return false;
        }
        return true;

    }


    /**
     * 主人购买宠物
     */
    public void buy(int num ,int zhuid,String name,String password){
        //宠物主人实体类对象
        PetOwner po = new PetOwner();
        //宠物商店实体类对象
        PetStore pt = new PetStore();
        //宠物实现类对象
        PetService pdoi = new PetService();
        //宠物主人实现类对象
        PetOwnerService podo = new PetOwnerService();
        //宠物商店实现类对象
        PetStoreService psdo = new PetStoreService();
        //宠物对象
        Pet pet = new Pet();
        switch(num){
            case 1:
                System.out.println("---请输入选择的购买范围：只输入选择项的序号---");
                System.out.println("1、购买库存宠物\n2、购买新培育宠物");
                int num1 = in.nextInt();
                switch(num1){
                        case 1:
                            System.out.println("---以下是库存宠物---");
                            System.out.println("序号\t宠物名称\t类型\t元宝数");
                            pdoi.getallpet();
                            break;
                        case 2:
                            System.out.println("---以下是新培育宠物---");
                            System.out.println("序号\t宠物名称\t类型\t元宝数");
                            pdoi.selectnewpet();
                            break;
                        case 3:break;
                        default:
                            buy(num,zhuid,name,password);
                            break;
                    }
                    System.out.println("---请选择要购买哪一个宠物，并输入选择项的序号---");
                    int num2 = in.nextInt();
                    System.out.println("您账户所剩元宝数：");
                    pet=pdoi.getbuypet(num2);
                    po=podo.select(zhuid);
                    pt.setBalance(psdo.selectpet(pdoi.selectpet(num2).getStoreid()).getBalance());//为宠物商店余额赋值
                    pt.setId(pdoi.selectpet(num2).getStoreid());//为宠物商店id赋值
                    podo.buypet(pet, po, pt);
                    System.out.println("台账正确插入一条信息");
                    break;
            case 2:
                break;
            default:
                break;
        }
    }


    /**
     * 主人卖宠物
     */
    public void sell(int num,int zhuid,String name,String password){
        //宠物主人实体类对象
        PetOwner po = new PetOwner();
        //宠物商店实体类对象
        PetStore pt = new PetStore();
        //宠物实现类对象
        PetService pdoi = new PetService();
        //宠物主人实现类对象
        PetOwnerService podo = new PetOwnerService();
        //宠物商店实现类对象
        PetStoreService psdo = new PetStoreService();
        //宠物对象
        Pet pet = new Pet();
        System.out.println("我的宠物列表");
        System.out.println("序号\t宠物名称\t\t类型\t元宝数");
        pdoi.selectstorepet(zhuid);
        System.out.println("---请选择要销售的宠物编号---");
        int sellid = in.nextInt();
        System.out.println("---您要卖出的宠物信息如下---");
        System.out.println("宠物的名字叫："+pdoi.selectpet(sellid).getName()+"\t"+"宠物的类别是："+pdoi.selectpet(sellid).getType());
        System.out.println("确认是否卖出：是Y\t否F");
        String choose = in.next();
        if(choose.equals("y")){
            pet=pdoi.getsellpet(sellid);
            po.setId(pdoi.selectpet(sellid).getOwnerid());//给宠物主人id赋值
            po.setName(name);
            po.setPassword(password);
            po.setMoney(podo.selectowner(po).getMoney());//给主人元宝数赋值
            System.out.println("---下面是现有宠物店，请选择您要卖给的买家序号---");
            System.out.println("序号\t宠物商店名字");
            psdo.selectallstore();
            int cho = in.nextInt();
            pt.setBalance(psdo.selectpet(cho).getBalance());//为宠物商店余额赋值
            pt.setId(cho);//为宠物商店id赋值
            pet.setOwnerid(zhuid);//为主人id赋值
            pet.setStoreid(pdoi.selectpet(sellid).getStoreid());//为商店id赋值
            podo.sellpet(pet, po, pt);
            System.out.println("台账正确插入一条信息");

        }else{
            System.out.println("再见");
        }
    }

}

