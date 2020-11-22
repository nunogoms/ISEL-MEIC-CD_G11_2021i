package ui;

import java.util.ArrayList;
import java.util.Scanner;

public class MenuInterface {
    private final ArrayList<MenuObject> menuOptions = new ArrayList<MenuObject>();
    public static boolean isShuttingDown = false;
    private int exitNumber = 99;

    /***
     *
     * @return the option picked by the user
     */
    public MenuInterface addMenuObject(String description, Runnable runnable) {
        MenuObject menuObject = new MenuObject(description, runnable);
        menuOptions.add(menuObject);
        return this;
    }
    public MenuInterface addQuitEntry(Runnable runnable) {

        Runnable exitRunnable = () -> {
            System.out.println("\nShutting down ...\n");
            runnable.run();
            isShuttingDown = true;
        };

        String description = "\n..........\n" + exitNumber +" : Exit";

        MenuObject menuObject = new MenuObject(description, exitRunnable);
        menuOptions.add(menuObject);
        return this;
    }

    public Runnable printAndGetRunnable() {
        Scanner scan = new Scanner(System.in);
        int option;
        do {
            System.out.println("\n######## MENU ##########");
            System.out.println("Options for CNText service:");

            for (int i = 0; i < menuOptions.size(); i++) {
                if(i == menuOptions.size()-1) System.out.println(menuOptions.get(i).getDescription());
                else System.out.println(i + menuOptions.get(i).getDescription());
            }
            System.out.print("Enter an Option:\n");
            option = scan.nextInt();
            System.out.println();
        } while (!((option >= 0 && option < menuOptions.size()) || option == 99));
        if (option == exitNumber) {
            return () -> {
                menuOptions.get(menuOptions.size()-1).getRunnable().run();
            };
        }

        return menuOptions.get(option).getRunnable();
    }
}
