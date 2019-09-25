package service;

import dao.PetStoreDao;
import model.Pet;
import model.PetOwner;
import model.PetStore;
import service.impl.IPetStoreService;

import java.util.List;

/**
 * @ClassName PetStore
 * @Description TODO
 * @Author 郑思婷
 * @Date 2019/7/314:03
 * @Version 1.0
 **/
public class PetStoreService implements IPetStoreService {
    PetStoreDao psdo=new PetStoreDao();
    @Override
    public void selectallstore() {
        List<PetStore> list2 = psdo.getAllStore();
        for (int i = 0; i < list2.size(); i++) {
            System.out.println(list2.get(i).getId()+"\t\t"+list2.get(i).getName());
        }
    }

    @Override
    public PetStore selectpet(int id) {
        PetStore ps;
        ps=psdo.getOneStore(id);
        return ps;
    }

    @Override
    public void newpet(Pet p) {
        psdo.breed(p);
    }

    @Override
    public PetStore storelogin(PetStore p) {
        PetStore po;
        po=psdo.login(p);
        return po;
    }
}
