package service.impl;

import model.Pet;
import model.PetOwner;
import model.PetStore;

public interface IPetOwnerService {
    public void selectallowner();
    public void buypet(Pet pet, PetOwner p, PetStore ps);
    public void sellpet(Pet pet, PetOwner p, PetStore ps);
    public PetOwner login(PetOwner p);
    public PetOwner selectowner(PetOwner p);
    public PetOwner select(int id);
}
