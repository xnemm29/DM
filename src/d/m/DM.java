/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package d.m;

import java.util.Scanner;

/**
 *
 * @author Student
 */
public class DM {

    //funkce na kontrolu délky 10
        public static boolean zkontrolujDelku (String a) {
            boolean pom = true;
            if (a.length() != 10) {
                System.out.println("Chyba: nezadal jsi 10 číslic");
                pom = false;
            }
            return pom; 
        }

    //převedení na pole longů s kontrolou, jsou-li to čísla    
        public static byte[] prevedNaPole (String a) {
            char [] poleCharu = a.toCharArray();
            byte [] aPole = new byte [11];
            aPole[10] = 1;  //délka pole je 10 + 11.člen nese info o kontrole
            for (int i=0; i<10; i++) {
                if (poleCharu[i]<'0' || poleCharu[i]>'9') {
                    System.out.println("Chyba: nezadal jsi 10 číslic");
                    aPole[10] = 0;
                    return aPole;
                } else {
                    aPole[i] = (byte) poleCharu[i];
                }
            }
            return aPole;
        }
    
    
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        String a;       //sem zadáme RČ
        boolean pom;
        byte [] aPole = new byte [11];
        
        Scanner sc = new Scanner(System.in);
        
        System.out.println("Zadej rodne cislo:");
        a = sc.nextLine();
        
        pom = zkontrolujDelku(a);
        if (pom == false){
            return;
        }
        
        aPole = prevedNaPole(a);
        if (aPole[10] == 0){
            return;
        }
        
        kontroladelitelnosti11();  //tato funkce zároveň provede i určení pohlaví
        
        
        
    }
    public static void kontroladelitelnosti11() {
        byte[] aPole = new byte[10];

        if ((aPole[0] + aPole[2] + aPole[4] + aPole[6] + aPole[8]) == (aPole[1] + aPole[3] + aPole[5] + aPole[7] + aPole[9])) {
            System.out.println("je to rodne cislo");
            muzZena ();
        } else {
            System.out.println("neni to rodne cislo");
        }
    }

    public static void muzZena() {
        byte[] aPole = new byte[10];

        if ((aPole[3] == 5) || (aPole[3] == 6)) {
            System.out.println("zena");
        }
        else if ((aPole[3] == 0) || (aPole[3] == 1)) {
            System.out.println("muz");
        }
        else {System.out.println("neplatne cislo");}
    }
}
