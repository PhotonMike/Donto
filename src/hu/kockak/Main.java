package hu.kockak;

import java.io.IOException;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        KotlinMain kotlin = new KotlinMain();
        kotlin.main();
        Scanner konzol = new Scanner(System.in);
        String bemenet = konzol.nextLine();
        int[] számok = new int[10000];
        int g = 0;
        String akt = "";
        int vege = 0;
        for (int i = 0;i<bemenet.length();i++)
        {
            if (i+2>=bemenet.length())
            { }
            else if (bemenet.substring(i,i+2).equals(", "))
            {
                számok[g] = Integer.valueOf(akt);
                g++;
                akt = "";
                i += 2;
            }
            akt += bemenet.substring(i, i+1);
        }
        számok[g] = Integer.valueOf(akt);
        int akthely;
        int elözöhely=0;
        int robot_benz = 300;
        for (int i = 0; i < g + 1; i++)
        {
            if (számok[i] % 30 == 0)
            { akthely = 7; }
            else if (számok[i] % 15 == 0)
            { akthely = 4; }
            else if (számok[i] % 10 == 0)
            { akthely = 13; }
            else if (számok[i] % 6 == 0)
            { akthely = 10; }
            else if (számok[i] % 2 == 0)
            { akthely = 8; }
            else if (számok[i] % 3 == 0)
            { akthely = 0; }
            else if (számok[i] % 5 == 0)
            { akthely = 2; }
            else
            { akthely = 5; }
            if (robot_benz-((Math.abs(akthely - elözöhely) * 5) + 1)>=(Math.abs(akthely-(-1))*6))
            {
                vege += (Math.abs(akthely - elözöhely) * 5) + 1;
                robot_benz -= (Math.abs(akthely - elözöhely) * 5) + 1;
                elözöhely = akthely;
            }
            else
            {
                vege += (Math.abs(akthely - (-1))) * 6;
                elözöhely = 6;
                i--;
                robot_benz = 300;
            }
        }
        System.out.println(vege);
        try {
            System.in.read();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
