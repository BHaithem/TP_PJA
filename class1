package com.Dev_TP2;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Class1 {
    static int nbr;
    public static void main(String [] args) {
        System.out.println("Entrer le nombre d’objets à sérialiser");
        Scanner input = new Scanner( System.in );
        nbr = input.nextInt();
        List<Employee> employees = new ArrayList<>();
        String address,name;
        int number,SSN;
        int n = 0;
        while(nbr > 0) {
            System.out.println("Entrer les informations de ces objets");
            //Employee newEmployee = new Employee();
            System.out.println("Nom :");
            name = input.next();
            System.out.println("Address :");
            address = input.next();
            System.out.println("SSN :");
            SSN = input.nextInt();
            System.out.println("Number :");
            number = input.nextInt();
            employees.add(new Employee(name,address,SSN,number));
            try {
                FileOutputStream fileOut = new FileOutputStream("emp.dat",true);
                ObjectOutputStream out = new ObjectOutputStream(fileOut);
                out.writeObject(employees.get(n));
                out.close();
                fileOut.close();
            } catch(IOException i){
                    i.printStackTrace();
                }
            n++;
            nbr--;
        }
        System.out.print("Le résultat de la sérialisation doit se trouver dans un fichier emp.dat");
    }
}
