package com;

import com.model.Manufacturer;
import com.model.Phone;
import com.service.PhoneService;
import com.service.TabletService;
import com.service.TelevisionService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Scanner;


public class Main {

    private static final Logger LOGGER = LoggerFactory.getLogger(Main.class);
    private static final PhoneService PHONE_SERVICE = new PhoneService();
    private static final TabletService TABLET_SERVICE = new TabletService();
    private static final TelevisionService TELEVISION_SERVICE = new TelevisionService();

    public static void main(String[] args) {
        LOGGER.info("creation of telephones");
        System.out.println("Phone models:");
        PHONE_SERVICE.createAndSavePhones(5);
        PHONE_SERVICE.printAll();
        LOGGER.info("creation of tablets");
        System.out.println("Tablet models:");
        TABLET_SERVICE.createAndSaveTablet(5);
        TABLET_SERVICE.printAll();
        LOGGER.info("creation of televisions");
        System.out.println("Television models:");
        TELEVISION_SERVICE.createAndSaveTelevision(5);
        TELEVISION_SERVICE.printAll();

        Scanner scanner = new Scanner(System.in);
        String id = scanner.next();
        PHONE_SERVICE.deletePhoneById(id);
        LOGGER.info("delete phone");
        PHONE_SERVICE.printAll();

        String title = scanner.next();
        int count = scanner.nextInt();
        double price = scanner.nextDouble();
        String model = scanner.next();


        PHONE_SERVICE.updatePhone(new Phone(title,count,price,model,Manufacturer.APPLE));
        PHONE_SERVICE.printAll();
    }
}
