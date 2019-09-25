package service;

import dao.PetOwnerDao;
import model.Pet;
import model.PetOwner;
import model.PetStore;
import service.impl.IPetOwnerService;

import java.util.List;

/**
 * @ClassName PetOwnerService
 * @Description TODO
 * @Author 郑思婷
 * @Date 2019/7/314:09
 * @Version 1.0
 **/
public class PetOwnerService implements IPetOwnerService {
    PetOwnerDao podo=new PetOwnerDao();
    @Override
    public void selectallowner() {
        List<PetOwner> list1 = podo.getAllower();
        for (int i = 0; i < list1.size(); i++) {
            System.out.println(list1.get(i).getId()+"\t"+list1.get(i).getName());
        }
    }

    @Override
    public void buypet(Pet pet, PetOwner p, PetStore ps) {

        podo.buy(pet, p, ps);
}

    @Override
    public void sellpet(Pet pet, PetOwner p, PetStore ps) {
        podo.Sell(pet, p, ps);
    }

    @Override
    public PetOwner login(PetOwner p) {
        PetOwner po;
        po=podo.login(p);
        return po;
    }

    @Override
    public PetOwner selectowner(PetOwner p) {
        PetOwner po;
        po=podo.getone(p);
        return po;
    }

    @Override
    public PetOwner select(int id) {
        PetOwner po;
        po=podo.select(id);
        return po;
    }
}
