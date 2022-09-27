package week2;

import java.util.Scanner;

public class Gameboard_Class1 {
    int gameboard[];
    int hits,attempts,keys,miss;
    int total_keys =4;

    public Gameboard_Class1()
    {
        gameboard = new int[16];
        attempts=4;
        hits = 0;
        miss = 0;

        set_keys();
    }

    void set_keys()
    {
        gameboard[3] = 1;
        gameboard[6] = 1;
        gameboard[15] = 1;
        gameboard[11] = 1;
    }

    public void clickbox()
    {
        while(hits<total_keys && attempts>0)
        {
            if(hits<total_keys)
            {
                Scanner sc= new Scanner(System.in);
                System.out.print("Enter the position of the box : ");
                int i= sc.nextInt();

                if(i<16)
                {
                    if(gameboard[i]==1)
                    {
                        hits++;
                        System.out.println("It's a HIT");
                        int hits_left = total_keys - hits;
                        if(hits_left != 0)
                        {
                            System.out.println("SUCCESS! "+ hits + " done. " + hits_left + " more to go\n");
                        }
                        else
                        {
                            System.out.println("Yayyy! You've won the game\n");
                        }
                        gameboard[i] = 2;
                    }

                    else if(gameboard[i]==2)
                    {
                        System.out.println("OOPPSS! It seems you've opened this box");
                        System.out.println("Please try another box \n");
                    }

                    else
                    {
                        attempts--;
                        miss++;
                        gameboard[i]=2;
                        System.out.println("It's a MISS");
                        if(attempts!=0)
                        {
                            System.out.println("You've only " + attempts + " chances left\n");
                        }

                        else
                        {
                            System.out.println("OOPSS! You've lost the game");
                            System.out.println("BETTER LUCK NEXT TIME");
                        }
                    }
                }

                else
                {
                    System.out.println("This box doesn't even exist\n");
                }
            }

            else{
                System.out.println("It's not working");
            }
        }
    }
}
