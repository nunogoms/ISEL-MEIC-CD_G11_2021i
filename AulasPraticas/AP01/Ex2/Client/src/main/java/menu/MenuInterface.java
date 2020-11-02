package menu;

import java.util.ArrayList;
import java.util.Scanner;

public class MenuInterface {
    private final ArrayList<MenuObject> menuOptions = new ArrayList<>();
    /***
     *
     * @return the option picked by the user
     */
    public MenuInterface addMenuObject(String description, Runnable runnable){
        menuOptions.add(new MenuObject(description,runnable));
        return this;
    }

    public Runnable printAndGetRunnable() {
        Scanner scan = new Scanner(System.in);
        int option;
        try {
            do {
                System.out.println("\n######## MENU ##########");
                System.out.println("Options for gRPC Forum service:");

                for (int i = 0; i < menuOptions.size(); i++) {
                    System.out.println(i + menuOptions.get(i).getDescription());
                }

                System.out.println("..........");
                System.out.println("99: Exit");
                System.out.print("Enter an Option:\n");
                option = scan.nextInt();
                System.out.println();
            } while (!((option >= 0 && option < menuOptions.size()) || option == 99));
            if (option == 99) {
                return () -> {
                    System.out.println("Shutting down ...");
                    System.exit(0);
                };
            }
            return menuOptions.get(option).getRunnable();
        }catch (Exception e){

            return () -> System.out.println("Error executing operations!");
        }
    }
}
