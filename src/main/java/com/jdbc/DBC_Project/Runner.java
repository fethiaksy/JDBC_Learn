package com.jdbc.DBC_Project;

import java.util.Scanner;

public class Runner {
    static  Record recordobj;
    static  Utilities utilities = new Utilities();
    static Scanner scan = new Scanner(System.in);
    static Scanner scanLN = new Scanner(System.in);

    public static void main(String[] args) throws InterruptedException {
        menu();

    }
    public static void menu() throws InterruptedException {
        System.out.println("\n-------------------------");
        System.out.println("1 - List Records\n2 - Delete Records\n3 - UpDate Recod\n4 - Add new Record\nX - Exit\n" +
                "-------------------------\nSeçiminiz : ");
        String secim = scan.next().toUpperCase();
        switch (secim) {
            case "1":
                listRecords();
                break;
             case "2":
                deleteRecord();
                break;
            case "3":
                updateRecord();
                break;
            case "4":
                addNewRecord();
                break;
            case "X":
                System.out.println("sistem çıkışınız yapılmıştır  ... ");
                break;
            default:
                System.out.println("hatalı giriş ");
                menu();
        }
    }

    private static void deleteRecord() throws InterruptedException {
        System.out.println("-----------------------\n Silinecek kayit id Giriniz : ");
        int silinecekId = scan.nextInt();
        boolean flag = false;
        for (int i = 0; i < utilities.listData().size(); i++) {
            if(silinecekId==utilities.listData().get(i).getId()){
                System.out.printf("%5d%20s%15s\n",utilities.listData().get(i).getId(),
                        utilities.listData().get(i).getIsim(),utilities.listData().get(i).getTel());
                System.out.println("Kayit silmeyi onayliyor musunuz ? (E:Evet) : ");
                String onay = scan.next();
                if(onay.equalsIgnoreCase("e")){
                    utilities.deleteData(silinecekId);
                    System.out.println("Silme islemi basariyla gerceklesti");
                    flag = true;
                    break;
                }else{
                    System.out.println("Silme islemi iptal edildi.");
                    flag = true;
                    break;
                }
            }
        }
        if (!flag){
            System.out.println("Silinecek id bulunamadi.");
        }
        menu();

    }

    private static void updateRecord() throws InterruptedException {
        System.out.println("------------------\nUpdate edilecek kayit id giriniz : ");
        recordobj = new Record();
        int updateID = scanLN.nextInt();
        boolean flag = false;
        for (int i = 0; i < utilities.listData().size(); i++) {
            if (updateID == utilities.listData().get(i).getId()){
                System.out.printf("%5d%20s%15s\n",utilities.listData().get(i).getId(),
                        utilities.listData().get(i).getIsim(),utilities.listData().get(i).getTel());
                System.out.println("Kayit yenilemeyi onayliyor musunuz ? (E:Evet) : ");
                String onay = scan.next();
                if (onay.equalsIgnoreCase("e")){
                    System.out.println("Guncellemek istemediginiz yere x koyunuz.");
                    scan.nextLine();
                    System.out.println("Yeni isim giriniz : ");
                    String yeniIsim = scan.nextLine();
                    System.out.println("Yeni telefon numarasi giriniz : ");
                    String yeniTel = scan.next();
                    if (yeniIsim.equalsIgnoreCase("x")){
                        yeniIsim = utilities.listData().get(i).getIsim();
                    }
                    recordobj.setIsim(yeniIsim);
                    if (yeniTel.equalsIgnoreCase("x")){
                        yeniTel = utilities.listData().get(i).getTel();
                    }
                    recordobj.setTel(yeniTel);
                    recordobj.setId(updateID);
                    utilities.updateData(recordobj);
                    System.out.println("Güncelleme basarili.");
                    flag = true;
                    break;
                }else {
                    System.out.println("Kayit yenileme islemi iptal edildi.");
                    flag = true;
                    break;
                }
            }

        }
        if (!flag){
            System.out.println("ID Bulunamadi");
        }
        menu();
    }

    private static void addNewRecord() throws InterruptedException {
        System.out.println("---------------------\nRecord Ekleme : ");
        recordobj = new Record();
        System.out.println("isim giriniz : ");
        String isim = scanLN.nextLine();
        System.out.println("Telefonunuzu giriniz : ");
        String tel = scan.next();
        recordobj.setIsim(isim);
        recordobj.setTel(tel);
        utilities.addData(recordobj);
        menu();
    }

    private static void listRecords() throws InterruptedException {
        if (utilities.listData().isEmpty()){
            System.out.println("Listelenecek kayit bulunamadi.");
            menu();
        }
        System.out.printf("%4S%20S%17S\n", "id", "isim soyisim", "telefon no");
        System.out.printf("%4S%20S%17S\n", "--", "------------", "------------");
        for (int i = 0; i < utilities.listData().size(); i++) {
            System.out.printf("%4d%20s%17s\n",utilities.listData().get(i).getId(),
                    utilities.listData().get(i).getIsim(),utilities.listData().get(i).getTel());
        }
        Thread.sleep(2000);
        menu();
    }

}
