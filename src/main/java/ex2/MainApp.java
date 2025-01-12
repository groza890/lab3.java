package ex2;

import java.io.FileNotFoundException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
public class MainApp {
    public static void main(String[] args) throws FileNotFoundException {
        List<Produs> listaProduse = new ArrayList<Produs>();
        Scanner scanner = new Scanner(System.in);
        listaProduse = Produs.citireFisier(listaProduse);
        LocalDate today = LocalDate.now();
        double pret_min;
        int cantitate_min;
        int opt;
        do{
            System.out.println("0. Iesire");
            System.out.println("1. Afisarea produselor");
            System.out.println("2. Afisarea produselor expirate");
            System.out.println("3. Vanzare produs");
            System.out.println("4. Afisarea produselor cu pretul minim");
            System.out.println("5. Salvarea in fisier a produselor cu cantitate mai mica decat cea dorita");
            System.out.print("Optiunea dvs: ");
            opt = scanner.nextInt();
            switch(opt){
                case 0:
                    break;
                case 1:
                    for(Produs prod : listaProduse){
                        System.out.println(prod.toString());
                    }
                    break;
                case 2:
                    for(Produs prod : listaProduse){
                        if(prod.getData_expirarii().isBefore(today)){
                            System.out.println(prod.toString());
                        }
                    }
                    break;
                case 3:
                    Produs.vanzareProdus(listaProduse);
                    break;
                case 4:
                    pret_min = Double.MAX_VALUE;
                    for(Produs prod : listaProduse){
                        if(prod.getPret()< pret_min)
                            pret_min = prod.getPret();
                    }
                    for(Produs prod : listaProduse){
                        if(prod.getPret()==pret_min)
                            System.out.println(prod.toString());
                    }
                    break;
                case 5:
                    System.out.print("Introduceti cantitatea: ");
                    cantitate_min = scanner.nextInt();
                    Produs.salvareFisier_cantitateMaiMica(listaProduse, cantitate_min);
                    break;
                default:
                    System.out.println("Optiune invalida.");
                    break;
            }
        } while(opt!=0);
    }
}
