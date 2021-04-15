package Model;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.regex.Pattern;

/**
 * @author Bakonyi Klaudia
 * @author Bihari Bence
 * @author Nagy David
 * @author Toth Balazs
 * @author Wagner Reka
 */

public class Main {
    /**
     * Jelenleg a Test nevu tesztosztalyunk segitsegevel ellenorizzuk modellunk helyesseget.
     */

    public static ArrayList<Material> materials = new ArrayList<>();
    public static ArrayList<Asteroid> asteroids=new ArrayList<>();
    public static ArrayList<TeleportGate> teleportgates = new ArrayList<>();
    public static ArrayList<Settler> settlers=new ArrayList<>();
    public static ArrayList<Robot> robots=new ArrayList<>();
    public static ArrayList<UFO> ufos= new ArrayList<>();

    String regex = "\\W*((?i)createmap(?-i))\\W*\\s(\\d+\\s){5}\\d+";
    static String materialregex = "[013]|2\\s[012]";
    static String asteroidregex ="0\\s\\d\\s\\d\\s0|\\d\\s(\\d,)*\\d\\s[01]\\s\\d{1,2}\\s1\\s\\d\n";
    static String asteroidregex2 ="0\\s\\d\\s\\d\\s0|\\d\\s(\\d,)*\\d\\s[01]\\s\\d{1,2}\\s1\\s\\d ||\\d\\s(\\d,)*\\d\\s[01]\\s\\d{1,2}";
    String tgregex ="\\d\\s[01]\\s\\d\\s[01]\\s[01]";
    String settlerregex ="\\d\\s\\d\\s(\\d,)*\\d\\s[0123]\\s\\d|\\d\\s0\\s0";
    String robotregex ="\\d";
    String uforegex ="\\d\\s0|\\d\\s\\d\\s(\\d,)*\\d\n";


    public static void main(String[] args)  {

        Scanner in = new Scanner(System.in);
        String[] input={};
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));


        String[] cmd={};
        String line;
        int[] ObjCounts = {0,0,0,0,0,0}; //Material, Asteroid, TG, Settler, Robot, Ufo
        try {

            line=reader.readLine();
            cmd=line.split(" ");
            for(int i=1; i<7;i++){
                ObjCounts[i-1]=Integer.parseInt(cmd[i]);
            }
            listaz(ObjCounts);
            //System.out.println(reader.readLine());


            for(int i=0; i<6;i++){
                for(int j=0; j<ObjCounts[i];j++){
                    String temp=reader.readLine();

                    System.out.println("apad"+temp);
                    letrehoz(i,temp);

                }
            }

//            for(int i=0;i<ObjCounts[0];i++){
//                System.out.println("helo material");
//                String temp=reader.readLine();
//                if(Pattern.matches(materialregex,temp)){
//                    System.out.println("material"+temp);
//                }
//            }
//            for(int i=0;i<ObjCounts[1];i++){
//                System.out.println("helo asteroid");
//                String temp=reader.readLine();
//                System.out.println(temp);
//                if(Pattern.matches(asteroidregex, temp)){
//                    System.out.println("asteroid"+temp);
//                }
//            }
//            for(int i=0;i<ObjCounts[2];i++){
//                System.out.println("helo tg");
//                String temp=reader.readLine();
//                if(Pattern.matches(tgregex,temp)){
//                    System.out.println("tg"+temp);
//                }
//            }
//            for(int i=0;i<ObjCounts[3];i++){
//                System.out.println("helo settler");
//                String temp=reader.readLine();
//                System.out.println(temp);
//                if(Pattern.matches(settlerregex,temp)){
//                    System.out.println("settkler"+temp);
//                }
//            }
//            for(int i=0;i<ObjCounts[4];i++){
//                System.out.println("helo robot");
//                String temp=reader.readLine();
//                if(Pattern.matches(robotregex,temp)){
//                    System.out.println("robot"+temp);
//                }
//            }
//            for(int i=0;i<ObjCounts[5];i++){
//                System.out.println("helo ufo");
//                String temp=reader.readLine();
//                if(Pattern.matches(uforegex,temp)){
//                    System.out.println("ufo"+temp);
//                }
//            }
//            reader.close();
        } catch (IOException e) {
            e.printStackTrace();
        }


       // System.out.println(input[0]);
       // System.out.println(input[1]);
        //System.out.println(input[2]);

       // int[] ObjCounts = {0,0,0,0,0,0}; //Material, Asteroid, TG, Settler, Robot, Ufo






//
//        int sum =0;
//        //System.out.println(Pattern.matches("\\W*((?i)createmap(?-i))\\W*\\s(\\d+\\s){5}\\d+","createmap 1 2 3 4 5 6"));
//        System.out.println(Pattern.matches(regex,input));
//        if(Pattern.matches(regex,input)){
//            String[] cmd=input.split(" ");
//            for(int i=1; i<cmd.length;i++){
//                System.out.println(cmd[i]);
//                ObjCounts[i-1]=Integer.parseInt(cmd[i]);
//                sum+=ObjCounts[i-1];
//            }
//
//            System.out.println(sum);
//            for(int i=0; i<ObjCounts.length;i++){
//                System.out.println(ObjCounts[i]);
//            }
//
//        }
//




        //Test t = new Test();
        //t.menu();               //teszt menu meghivasa

        for(int i=0; i<Main.materials.size();i++){
            System.out.println(materials.get(i).name);
        }


    }

    public static void letrehoz(int what, String params ){
        switch (what){
            case 0:
                if(Pattern.matches(materialregex,params)){
                    createMaterial(params);
                    System.out.println(Main.materials.get(0).name);
                    break;
                    }
            case 1:
                if(Pattern.matches(asteroidregex,params)){
                    createAsteroid1(params);
                }else if(Pattern.matches(asteroidregex2,params))
                    createAsteroid2(params);
            case 2:
            case 3:
            case 4:
            case 5:
        }

    }

    public static void createMaterial(String params){
        String[] input = params.split("\t");
        Material normal = new Material();
        RadioactiveMaterial radmat = new RadioactiveMaterial();
        SublimableMaterial submat= new SublimableMaterial();
        NormalMaterialName normalMaterialName;
        RadioactiveMaterialName radioactiveMaterialName;
        SublimableMaterialName sublimableMaterialName;
        //todo regex ellenörzés
        switch (Integer.parseInt(input[0])){
            case 0:
                Main.materials.add(normal);
                normalMaterialName = NormalMaterialName.IRON;
                Main.materials.get(Main.materials.size()-1).setName(normalMaterialName);
                break;
            case 1:
                Main.materials.add(normal);
                normalMaterialName = NormalMaterialName.COAL;
                Main.materials.get(Main.materials.size()-1).setName(normalMaterialName);
                break;
            case 2:
                Main.materials.add(radmat);
                radioactiveMaterialName = RadioactiveMaterialName.URAN;
                Main.materials.get(Main.materials.size()-1).setName(RadioactiveMaterialName.URAN);
                //Main.materials.get(Main.materials.size()-1).setExposure(input[1]);
                  //TODO itt kell még a params paraméterből kiolvasni az exposure értéket
                break;
            case 3:
                Main.materials.add(submat);
                sublimableMaterialName = SublimableMaterialName.ICEWATER;
                Main.materials.get(Main.materials.size()-1).setName(sublimableMaterialName);
                break;
        }
    }

    public static void createAsteroid1(String params){

    }
    public static void createAsteroid2(String params){

    }









    public static void listaz(int[]anyad){
        for(int i=0; i<anyad.length;i++){
            System.out.println( anyad[i]);
        }

    }
    public static int osszead(int[]anyad){
        int sum=0;
        for(int i=0;i<anyad.length;i++){
            sum+=anyad[i];
        }
        return sum;
    }

    public  void InitWhat(int what, String string){
        switch (what){
            case 1 : //material
                break;
            case 4:
                settlers.add(new Settler());


        }
    }

    //anyad
    //neked is





}
