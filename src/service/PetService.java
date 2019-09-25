package service;

import dao.PetDao;
import model.Pet;
import service.impl.IPetService;

import java.util.List;

/**
 * @ClassName PetService
 * @Description TODO
 * @Author 郑思婷
 * @Date 2019/7/314:20
 * @Version 1.0
 **/
public class PetService implements IPetService {
    PetDao pdoi=new PetDao();
    @Override
    public void selectallpet() {
        List<Pet> list = pdoi.getAllPet();
        for (int i = 0; i < list.size(); i++) {
            System.out.println(list.get(i).getId()+"\t"+list.get(i).getName());
        }
    }

    @Override
    public Pet selectpet(int id) {
        Pet p;
        p=pdoi.getid(id);
        return p;
    }

    @Override
    public void selectstorepet(int id) {
        List<Pet> list = pdoi.getsomesPet(id);
        for (int i = 0; i < list.size(); i++) {
            System.out.println(list.get(i).getId() + "\t\t" + list.get(i).getName() + "\t\t\t" + list.get(i).getType()+"\t\t"+list.get(i).getMoney());
        }
    }

    @Override
    public void getallpet() {
        List<Pet> list = pdoi.getPet();

        for (int i = 0; i < list.size(); i++) {
            System.out.println(list.get(i).getId()+"\t\t"+list.get(i).getName()+"\t\t"+list.get(i).getType()+"\t\t"+list.get(i).getMoney());
        }
    }

    @Override
    public void selectnewpet() {
        List<Pet> list1 = pdoi.getnewPet();
        for (int i =0; i <list1.size(); i++) {
            if(list1.get(i).getId() >5){
                System.out.println(list1.get(i).getId()+"\t\t"+list1.get(i).getName()+"\t\t"+list1.get(i).getType()+"\t\t"+list1.get(i).getMoney());
            }
        }
    }

    @Override
    public void selectownerpet(int id) {
        List<Pet> list = pdoi.getsomePet(id);
        for (int i = 0; i < list.size(); i++) {
            System.out.println(list.get(i).getId()+"\t\t"+list.get(i).getName()+"\t\t"+list.get(i).getType()+"\t\t"+list.get(i).getMoney());
        }
    }

    @Override
    public void getnewpet(int id) {
        List<Pet> list = pdoi.getnewPet(id);
        for (int i = 0; i < list.size(); i++) {
            System.out.println(list.get(i).getId()+"\t\t"+list.get(i).getName()+"\t\t"+list.get(i).getType()+"\t\t"+list.get(i).getMoney());
        }
    }

    @Override
    public Pet getbuypet(int id) {
        Pet pet;
        pet=pdoi.getbuyPet(id);
        return pet;

    }

    @Override
    public Pet getsellpet(int id) {
        Pet pet;
        pet=pdoi.getselllPet(id);
        return pet;
    }
}
