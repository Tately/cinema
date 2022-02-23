package Btmina;
import java.util.Scanner;

public class Cinema {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the number of rows:");
        int a = sc.nextInt();
        System.out.println("Enter the number of seats in each row:");
        int b = sc.nextInt();
        boolean big;
        boolean active = true;
        String[][] arr = new String[a + 1][b + 1];
        for (int i = 0; i <= a; i++) {
            for (int j = 0; j <= b; j++) {
                if (i == 0 && j == 0) {
                    arr[i][j] = " ";
                } else if (i == 0) {
                    arr[i][j] = String.valueOf(j);
                } else if (j == 0) {
                    arr[i][0] = String.valueOf(i);
                } else {
                    arr[i][j] = "S";
                }
            }
        }
        if (a * b <= 60) {
            big = false;
        } else {
            big = true;
        }
        while (active) {
            System.out.println("1. Show the seats \n2. Buy a ticket \n0. Exit");
            int choice = sc.nextInt();
            if(choice == 0){
                active = false;
                return;
            }
            if (choice == 1) {
                System.out.println();
                cinema(arr);
            } else if (choice == 2) {
                System.out.println("Enter a row number:");
                int row = sc.nextInt();
                System.out.println("Enter a seat number in that row:");
                int line = sc.nextInt();
                arr[row][line] = "B";
                price(a, row, big);
            }
        }
        sc.close();
    }
    public static void cinema (String[][]arri){
        System.out.println("Cinema:");
        System.out.println();
        for (int i = 0; i < arri.length; i++) {
            for (int j = 0; j < arri[i].length; j++) {
                System.out.print(arri[i][j] + " ");
            }
            System.out.println();
        }

    }

    public static void price(int a, int row, boolean big) {
        if(big){
            if((a / 2) >= row)
                System.out.println("Ticket price: $10");
            else
                System.out.println("Ticket price: $8");
        }
        else{
            System.out.println("Ticket price: $10");

        }

    }
}
