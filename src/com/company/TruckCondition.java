package com.company;

import java.util.Random;

public class TruckCondition {
   public static void changeDriver(Avtobaza avtobaza, Driver driver) {
      if (avtobaza.getStatus().equals("BASE")) {
         avtobaza.setDriver(driver.getName());
         avtobaza.setDriver(driver.getName());
      } else if (avtobaza.getStatus().equals("ROUTE")) {
         System.out.println("Водитель уже в пути.");
      } else {
         System.out.println("Нельзя сменить водителя.");
      }
   }

   public static void startDriving(Avtobaza avtobaza) {
      if (avtobaza.getStatus().equals("BASE")) {
         if (avtobaza.getName() != null) {
            avtobaza.setStatus("ROUTE");
            System.out.println("Успешно вышли на маршрут.");
         } else {
            System.out.println("Нет свободных водителей");
         }
      } else if (avtobaza.getStatus().equals("ROUTE")) {
         System.out.println("Водитель уже в пути.");
      } else {
         Random random = new Random();
         int rand = random.nextInt(2);
         if (rand == 0) {
            avtobaza.setStatus("ROUTE");
            System.out.println("Твоя машина уже в пути.");
         } else {
            avtobaza.setStatus("BASE");
            System.out.println("Твоя машина в базе.");
         }
      }
   }

   public static void startRepair(Avtobaza avtobaza) {
      if (avtobaza.getStatus().equals("BASE")) {
         avtobaza.setStatus("REPAIR");
         System.out.println("Сломалась, отправили на ремонт.");
      } else if (avtobaza.getStatus().equals("ROUTE")) {
         avtobaza.setStatus("REPAIR");
      } else {
         System.out.println("Твоя машина в ремонте.");
      }
   }
}


