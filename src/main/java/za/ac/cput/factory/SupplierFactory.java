package za.ac.cput.factory;

/*
IRepository.java
Author: Shuaib Allie (217148867)
Date: 1 April 2022
 */

import za.ac.cput.domain.Supplier;

public class SupplierFactory {
    public static Supplier createSupplier(String suppID, String suppPhysAddress, String suppEmail, String suppPhone, String suppName){
        Supplier supplier = new Supplier.Builder().setSuppName(suppName)
                .setSuppPhysAddress(suppPhysAddress)
                .setSupEmail(suppEmail)
                .setSuppID(suppID)
                .setSupPhone(suppPhone)
                .build();
        return supplier;
    }
}

