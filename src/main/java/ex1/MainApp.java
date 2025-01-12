package ex1;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class MainApp {
    public static void main(String[] args) throws FileNotFoundException {
        List<Parabola> listaParabole = new ArrayList<Parabola>();
        Scanner scanner = new Scanner(new File("src/main/java/ex1/parabola_in.txt"));
        int a, b, c;
        while (scanner.hasNextLine()) {
            a = scanner.nextInt();
            b = scanner.nextInt();
            c = scanner.nextInt();
            listaParabole.add(new Parabola(a, b, c));
        }
        scanner.close();

        for (Parabola parabola : listaParabole) {
            System.out.println(listaParabole.indexOf(parabola) +". " + parabola.toString());
        }

        Scanner scanner1 = new Scanner(System.in);
        int opt;

        int index1, index2;
        do {
            System.out.println("0. Iesire");
            System.out.println("1. Mijlocul si lungimea segmentului prin metoda statica");
            System.out.println("2. Mijlocul si lungimea segmentului prin metoda normala");
            System.out.print("Optiunea dvs: ");
            opt = scanner1.nextInt();

            switch (opt) {
                case 0:
                    break;
                case 1:
                    System.out.print("Introduceti indexul parabolei 1: ");
                    index1 = scanner1.nextInt();
                    System.out.print("Introduceti indexul Parabolei 2: ");
                    index2 = scanner1.nextInt();

                    System.out.print("Mijlocul: ");
                    System.out.println(Arrays.toString(Parabola.mijlocDistantaVarfuri_static(listaParabole.get(index1), listaParabole.get(index2))));
                    System.out.print("Lungimea: ");
                    System.out.println(Parabola.distantaVarfuri_static(listaParabole.get(index1), listaParabole.get(index2)));
                    System.out.println();

                    break;
                case 2:
                    System.out.print("Introduceti indexul parabolei 1: ");
                    index1 = scanner1.nextInt();
                    System.out.print("Introduceti indexul parabolei 2: ");
                    index2 = scanner1.nextInt();

                    System.out.print("Mijlocul: ");
                    System.out.println(Arrays.toString(listaParabole.get(index1).mijlocDistantaVarfuri(listaParabole.get(index2))));
                    System.out.print("Lungimea: ");
                    System.out.println(listaParabole.get(index1).distantaVarfuri(listaParabole.get(index2)));
                    System.out.println();

                    break;
                default:
                    System.out.println("Invalid option\n");
                    break;

            }
        } while (opt != 0);
        scanner1.close();
    }
}
