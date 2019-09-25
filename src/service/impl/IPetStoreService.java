package service.impl;

import model.Pet;
import model.PetStore;

public interface IPetStoreService {
    public void selectallstore();
    public PetStore selectpet(int id);
    public void newpet(Pet p);
    public PetStore storelogin(PetStore p);
}
