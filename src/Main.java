import jdk.jfr.Percentage;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        int n,m;
        Scanner s = new Scanner(System.in);
        System.out.println("Enter the number of rows:");
        n = s.nextInt();
        System.out.println("Enter the number of seats in each row:");
        m = s.nextInt();
        char[][] cinema = new char[n][m];
        for(int i = 0; i < n; i++)
            for(int j = 0; j < m; j++)
                cinema[i][j] = 'S';
        int choice ;
        while (true){
            System.out.println("1. Show the seats\n2. Buy a ticket\n3. Statistics\n0. Exit");
            choice  = s.nextInt();
            if(choice == 0)
                break;
            if(choice == 1){
                showCinema(n,m,cinema);
            }
            else if (choice == 2){
                bookTickets(n,m,cinema);
            }
            else{
                showStatistics(n,m,cinema);
            }
        }

    }

    static void showStatistics(int n, int m, char[][] cinema) {
        int counter = 0, seats = 0;
        for(int i = 0; i < n; i++)
        {
            for(int j = 0; j < m; j++)
            {
                if(cinema[i][j] == 'B')
                {
                    counter+=(i < n / 2 ? 10 : 8);
                    seats++;
                }
            }
        }
        //((n/2*m * 10) + (n - n/2)*m * 8)
        System.out.format("Number of purchased tickets: %d %nPercentage: %.2f%c %nCurrent income: %c%d %nTotal income %c%d%n",
                seats,(float)seats/(n*m) * 100.0,'%','$',counter,'$',((n/2*m * 10) + (n - n/2)*m * 8));
    }

    static void bookTickets(int n, int m, char[][] cinema)
    {
        int nch,mch;
        Scanner s = new Scanner(System.in);
        int price;
        do {
            System.out.println("Enter a row number:");
            nch = s.nextInt();
            System.out.println("Enter a seat number in that row:");
            mch = s.nextInt();
        }
        while (!checkInput(n,m,nch,mch));

        while (cinema[nch-1][mch-1] == 'B') {
            System.out.println("That ticket has already been purchased!");
            System.out.println("Enter a row number:");
            nch = s.nextInt();
            System.out.println("Enter a seat number in that row:");
            mch = s.nextInt();
        }
        price = (m * n < 60 || nch <= n / 2) ? 10 : 8;
        System.out.println("Ticket price: $" + price);
        cinema[nch - 1][mch - 1] = 'B';
    }

    static void showCinema(int n, int m, char[][] cinema){
        System.out.print("Cinema:\n  ");
        for (int i = 0; i < m; i++)
            System.out.print(i + 1 + " ");
        System.out.print('\n');
        for(int i = 0; i < n; i++)
        {
            System.out.print(i + 1 + " ");
            for(int j = 0; j < m; j++)
            {
                System.out.print(cinema[i][j] + " ");
            }
            System.out.print("\n");
        }
    }

    static boolean checkInput(int n, int m, int nch, int mch){
        if(n >= nch && m >= mch){
            return true;
        }
        else{
            System.out.println("Wrong input!");
            return false;
        }
    }
}
