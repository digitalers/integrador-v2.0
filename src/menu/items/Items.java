package menu.items;

import java.util.Scanner;

import utils.CreateLines;

public abstract class Items {
    static Scanner scanner = new Scanner(System.in);

    public static int getItems(String title, Object... items) {

        System.out.println();
        CreateLines.createLineStart();
        System.out.println();
        System.out.println("* " + title);
        System.out.println();

        
        int pos = 0;

        for (Object elem: items) {
            pos++;
            System.out.println();
            System.out.printf("%d. %s", pos, elem);
        }
        
        System.out.println();
        System.out.println();
        System.out.println("0. Salir");

        CreateLines.createLineEnd();
        System.out.println();

        int selected = scanner.nextInt();
        
        return selected;
    }
}
