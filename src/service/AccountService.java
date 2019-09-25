package service;

import dao.AccountDao;
import model.Accounts;
import model.Pet;
import service.impl.IAccountService;

import java.util.List;

/**
 * @ClassName AccountService
 * @Description TODO
 * @Author 郑思婷
 * @Date 2019/7/314:21
 * @Version 1.0
 **/
public class AccountService implements IAccountService {
    AccountDao ad=new AccountDao();
    @Override
    public void storesell(Pet pet) {
        ad.charge(pet);
    }

    @Override
    public void storebuy(Pet pet) {
        ad.charge2(pet);
    }

    @Override
    public void allbill() {
        List<Accounts> list =ad.bill();
        for (int i = 0; i < list.size(); i++) {
            System.out.println(list.get(i).getId()+"\t\t\t"+list.get(i).getDealtype()+"\t\t\t\t\t\t\t\t\t"+list.get(i).getDealtime());
        }
    }
}
