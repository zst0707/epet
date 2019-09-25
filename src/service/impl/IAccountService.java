package service.impl;

import model.Pet;

public interface IAccountService {
    public void storesell(Pet pet);
    public void storebuy(Pet pet);
    public void allbill();
}
