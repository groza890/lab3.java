package ex2;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintStream;
import java.time.LocalDate;
import java.util.List;
import java.util.Scanner;
public class Produs {
    private final String denumire;
    private final double pret;
    private int cantitate;
    private final LocalDate data_expirarii;
    private static double incasari = 0;
    public Produs(String denumire, double pret, int cantitate, LocalDate data_expirarii) {
        this.denumire = denumire;
        this.pret = pret;
        this.cantitate = cantitate;
        this.data_expirarii = data_expirarii;
    }
    public String getDenumire() { return denumire; }
    public double getPret() { return pret; }
    public int getCantitate() { return cantitate; }
    public LocalDate getData_expirarii() { return data_expirarii; }
    public void setCantitate(int cantitate) { this.cantitate = cantitate; }
    @Override
    public String toString() {
        return "denumire: " + denumire + "; " +
                "pret: " + pret + "; " +
                "cantitate: " + cantitate + "; " +
                "data_expirarii: " + data_expirarii;
    }
    //metoda citire din fisier csv
    public static List<Produs> citireFisier(List<Produs> listaProduse) throws FileNotFoundException {
        Scanner input = new Scanner(new File("src/main/java/ex2/produse.csv"));
        String denumire_aux;
        double pret_aux;
        int cantitate_aux;
        LocalDate data_expirarii_aux;
        while (input.hasNextLine()) {
            String[] data = input.nextLine().split(",");
            denumire_aux = data[0];
            pret_aux = Double.parseDouble(data[1]);
            cantitate_aux = Integer.parseInt(data[2]);
            data_expirarii_aux = LocalDate.parse(data[3]);
            listaProduse.add(new Produs(denumire_aux, pret_aux, cantitate_aux, data_expirarii_aux));
        }
        return listaProduse;
    }
    public static void salvareFisier_cantitateMaiMica(List<Produs> listaProduse, int cantitate_min) throws FileNotFoundException {
        PrintStream flux_out = new PrintStream("src/main/java/ex2/produse_out.txt");
        for(Produs produs : listaProduse) {
            if(produs.getCantitate() < cantitate_min) {
                flux_out.println(produs.toString());
            }
        }
    }
    public static void vanzareProdus(List<Produs> listaProduse) {
        Scanner scanner = new Scanner(System.in);
        String denumire_aux;
        int cantitate_aux;
        int ok = 0;
        System.out.print("Introduceti denumirea: ");
        denumire_aux = scanner.nextLine();
        for(Produs produs : listaProduse) {
            if(produs.getDenumire().equals(denumire_aux)) {
                System.out.print("Introduceti cantitatea: ");
                cantitate_aux = scanner.nextInt();
                if(cantitate_aux > produs.getCantitate()) {
                    System.out.println("Stoc insuficient!");
                }
                else {
                    produs.setCantitate(produs.getCantitate() - cantitate_aux);
                    incasari += cantitate_aux*produs.getPret();
                    System.out.println("Produs vandut. Cantitate ramasa: " + produs.getCantitate());
                    System.out.println("Incasari: " + incasari);
                    System.out.println();
                    ok = 1;
                    if(produs.getCantitate()==0){
                        listaProduse.remove(produs);
                        break;
                    }
                }
            }
        }
        if(ok == 0) {
            System.out.println("Produsul nu exista.");
        }
    }
}
