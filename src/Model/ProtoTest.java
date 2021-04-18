package Model;

import Controller.InputManager;

import java.util.Scanner;

public class ProtoTest {

    public static void menu(){


        Scanner in = new Scanner(System.in);
        int testcase ;
        do {
            /*System.out.println("0 - I want to run my own test, given by me, on stdin");
            System.out.println("1 - Drill Layer and reach Sublime Material");
            System.out.println("2 - Mine Sublime Material");
            System.out.println("3 - Move Settler to Asteroid");
            System.out.println("4 - Move Settler to Teleport Gate");
            System.out.println("5 - Move Settler while being in SunStorm");
            System.out.println("6 - Place Sublime Material");
            System.out.println("7 - Settler Place Teleport Gate");
            System.out.println("8 - Build Base");
            System.out.println("9 - Build Robot");
            System.out.println("10 - Build Teleport Gate");
            System.out.println("11 - Drill Layer and not reach Core");
            System.out.println("12 - Drill Layer and reach empty Core");
            System.out.println("13 - Drill Layer and reach Normal Material");
            System.out.println("14 - Mine Normal Material");
            System.out.println("15 - Drill Layer and reach Radioactive Material");
            System.out.println("16 - Place Material but Asteroid is not empty or drilled through");
            System.out.println("17 - Mine Radioactive Material");
            System.out.println("18 - Place Normal Material");
            System.out.println("19 - Place Radioactive Material");
            System.out.println("20 - Mine but Core is empty");
            System.out.println("21 - Mine but inventory full");
            System.out.println("22 - Exit!");
*/

            System.out.println("\n? Which test case would you like to run?");

            testcase = in.nextInt();

            switch (testcase) {
                case 0:
                    InputManager.FromUserInput();
                    break;
                case 1:
                    InputManager.FromFileInput("1in");
                    break;
                case 2:
                    InputManager.FromFileInput("2in");
                    break;
                case 3:
                    InputManager.FromFileInput("3in");
                    break;
                case 4:
                    InputManager.FromFileInput("4in");
                    break;
                case 5:
                    InputManager.FromFileInput("5in");
                    break;
                case 6:
                    InputManager.FromFileInput("6in");
                    break;
                case 7:
                    InputManager.FromFileInput("7in");
                    break;
                case 8:
                    InputManager.FromFileInput("8in");
                    break;
                case 9:
                    InputManager.FromFileInput("9in");
                    break;
                case 10:
                    InputManager.FromFileInput("10in");
                    break;
                case 11:
                    InputManager.FromFileInput("11in");
                    break;
                case 12:
                    InputManager.FromFileInput("12in");
                    break;
                case 13:
                    InputManager.FromFileInput("13in");
                    break;
                case 14:
                    InputManager.FromFileInput("14in");
                    break;
                case 15:
                    InputManager.FromFileInput("15in");
                    break;
                case 16:
                    InputManager.FromFileInput("16in");
                    break;
                case 17:
                    InputManager.FromFileInput("17in");
                    break;
                case 18:
                    InputManager.FromFileInput("18in");
                    break;
                case 19:
                    InputManager.FromFileInput("19in");
                    break;
                case 20:
                    InputManager.FromFileInput("20in");
                    break;
                case 21:
                    InputManager.FromFileInput("21in");
                    break;
                case 22:
                    InputManager.FromFileInput("22in");
                    break;
                case 23:
                    InputManager.FromFileInput("23in");
                    break;
                case 24:
                    InputManager.FromFileInput("24in");
                    break;
                case 25:
                    InputManager.FromFileInput("25in");
                    break;
                case 26:
                    InputManager.FromFileInput("26in");
                    break;
                case 27:
                    InputManager.FromFileInput("27in");
                    break;
                case 28:
                    InputManager.FromFileInput("28in");
                    break;
                case 29:
                    InputManager.FromFileInput("29in");
                    break;
                case 30:
                    InputManager.FromFileInput("30in");
                    break;
                case 31:
                    InputManager.FromFileInput("31in");
                    break;
                case 32:
                    InputManager.FromFileInput("32in");
                    break;
                case 33:
                    InputManager.FromFileInput("33in");
                    break;
                case 34:
                    InputManager.FromFileInput("34in");
                    break;
                case 35:
                    InputManager.FromFileInput("35in");
                    break;
                case 36:
                    InputManager.FromFileInput("36in");
                    break;
                case 37:
                    break;
                default:
                    System.out.println("Invalid number!");
                    ProtoTest.menu();
                    break;
            }
        }while(testcase!=37);
        //Logger.getInstance().printReturnCommand();
    }


}