package application;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import entities.Product;

public class App {
    public static void main(String[] args) throws Exception {

        
        String  path = "c:\\temp\\in.txt";

        List<Product> list = new ArrayList<Product>();

        try(BufferedReader br = new BufferedReader(new FileReader(path))) {//try with resources, não é necessário dar um .close() pois será fechado sozinho

            String line = br.readLine();//para ler de linha em linha
            line = br.readLine();
            while (line != null) {//enquanto a linha não estiver nula

                String[] vect = line.split(",");//split serve para recortar o String em partes com base no texto que você passar entre aspas nesse caso o vírgula
                String name = vect[0];
                Double price = Double.parseDouble(vect[1]);//para converter pois está como String
                Integer qte = Integer.parseInt(vect[2]);

                Product prod = new Product(name, price, qte);
                list.add(prod);

                line = br.readLine();
            }
            System.out.println("Products: ");
            for (Product p : list) {
                System.out.println(p);
            }

        } catch (IOException e) {
            System.out.println("Error: " + e.getMessage());    
        }
    }
}
