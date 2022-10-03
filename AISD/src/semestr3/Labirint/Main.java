package semestr3.Labirint;
import javax.swing.*;
import java.awt.*;
import java.util.Scanner;

public class Main {
    public static int[][] map1 = {
            {1,1,1,1,1,1,1,1,1,1,1,1,1},
            {1,1,1,0,0,0,0,0,0,0,0,0,1},
            {1,0,0,0,0,0,0,0,1,1,1,0,1},
            {1,0,1,1,1,1,0,0,1,0,1,0,1},
            {1,0,1,0,0,1,1,1,1,0,0,0,1},
            {1,0,1,0,0,0,0,0,0,0,1,0,1},
            {1,0,1,0,0,1,1,1,0,0,1,0,1},
            {1,0,1,0,0,1,0,0,0,0,1,0,1},
            {1,0,1,1,1,1,0,1,1,1,1,0,1},
            {1,0,0,0,0,0,0,0,0,0,0,0,1},
            {1,1,1,1,1,1,0,0,1,1,1,1,1}
    };
    public static int[][] map2 = {
            {1,1,1,1,1,1,1,1,1,1,1,1,1},
            {1,1,1,0,1,0,0,0,0,0,0,0,1},
            {1,0,0,0,1,0,1,0,0,0,0,0,1},
            {1,0,1,0,1,0,1,0,0,1,1,1,1},
            {1,0,1,0,0,0,1,0,0,0,0,0,1},
            {1,0,1,0,0,0,1,0,0,1,0,0,1},
            {1,0,1,1,1,1,1,1,1,1,0,0,1},
            {1,0,0,0,1,0,0,0,0,0,0,0,1},
            {1,0,0,0,1,0,0,0,1,0,0,0,1},
            {1,0,0,0,1,0,0,0,1,0,0,1,1},
            {1,1,1,1,1,1,0,0,1,1,1,1,1}
    };
    public static int[][] map3 = {
            {1,1,1,1,1,1,1,1,1,1,1,1,1},
            {1,1,1,0,0,0,0,0,0,0,0,0,1},
            {1,0,0,0,0,0,1,0,1,0,1,0,1},
            {1,0,0,0,0,1,0,1,0,0,1,0,1},
            {1,0,0,0,1,0,0,1,1,1,1,0,1},
            {1,1,0,1,0,0,0,0,0,0,0,0,1},
            {1,1,0,0,1,0,0,1,1,1,1,1,1},
            {1,0,0,0,1,0,0,1,0,0,0,0,1},
            {1,0,0,0,1,0,0,0,0,0,0,0,1},
            {1,0,0,0,0,1,1,0,0,0,0,0,1},
            {1,1,1,1,1,1,0,0,1,1,1,1,1}
    };

    public static int[][] map_way = new int[11][13];
    public static int[][] route;
    public static final int a=13;
    public static final int b=11;
    public static int ind = 0;
    public static int X , Y, moves;
    public static int XS , YS , XE1 = 6 , YE1 = 10, XE2 = 2, YE2 = 2 ;

    public static int path(int[][] arr){
        if (Y < b - 1 && (arr[Y][X] - arr[Y + 1][X] == 1)) {
            route[ind][0] = Y;
            route[ind][1]= X;
            ind++;
            ++Y;
            return 0;
        }
        if (Y > 0 && (arr[Y][X] - arr[Y - 1][X] == 1)) {
            route[ind][0] = Y;
            route[ind][1]= X;
            ind++;
            --Y;
            return 0;
        }
        if (X < a-1 && (arr[Y][X] - arr[Y][X+1] == 1)) {
            route[ind][0] = Y;
            route[ind][1]= X;
            ind++;
            ++X;
            return 0;
        }
        if (X > 0 && (arr[Y][X] - arr[Y][X-1] == 1)) {
            route[ind][0] = Y;
            route[ind][1]= X;
            ind++;
            --X;
            return 0;
        }
        return 0;
    }

    public static void Print(int[][] array,int a, int b){
        for(int i=0; i<a; i++){
            for (int j=0; j<b; j++)
                System.out.printf("%2d\t", array[j][i]);
            System.out.println();
        }
    }

    public static void fill(int[][] map_way, int [][] map, int XE, int YE){
        map_way[YS][XS] = 1;
        int m = 1;
        do {
            ++m;
            for ( int i = 0; i < a; i++) {
                for (int j = 0; j < b; j++) {
                    if (map_way[j][i] == m - 1) {
                        if (i < a - 1 && map_way[j][i+1] == 0 && map[j][i+1] == 0) {
                            map_way[j][i+1] = m;
                        }
                        if (i > 0 && map_way[j][i-1] == 0 && map[j][i-1] == 0) {
                            map_way[j][i-1] = m;
                        }
                        if (j < b -1 && map_way[j+1][i] == 0 && map[j+1][i] == 0) {
                            map_way[j+1][i] = m;
                        }
                        if (j > 0 && map_way[j-1][i] == 0 && map[j-1][i] == 0) {
                            map_way[j-1][i] = m;
                        }
                    }
                }
            }
        } while ((map_way[YE][XE] <= 0));
        moves = m-1;
    }

    public static void main(String[] args)  {

        System.out.println("Choose a colour that you see around: "+"\n"+"1:Black"+"\n"+"2:Silver"+"\n"+"3:Green");
        Scanner in = new Scanner(System.in);
        int s = in.nextInt();

        JFrame frame = new JFrame();
        frame.setTitle("Labirint");
        frame.setSize(new Dimension(300, 400));
        frame.setLocationRelativeTo((null));
        frame.setLayout(new GridLayout());
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        switch (s) {
            case (1): {
                System.out.println("Choose where are you: " + "\n" + "1:room" + "\n" + "2:koridor");
                int t = in.nextInt();
                switch (t) {
                    case (1): {
                        System.out.println("Choose room: " + "\n" + "1:kitchen" + "\n" + "2:bedroom" + "\n" + "3:between rooms");
                        int k = in.nextInt();
                        switch (k) {
                            case (1): {
                                XS = 3;
                                YS = 6;
                            } break;
                            case (2): {
                                XS = 9;
                                YS = 7;
                            } break;
                            case (3): {
                                XS = 6;
                                YS = 5;
                            } break;
                        }
                    } break;
                    case (2): {
                        System.out.println("Choose koridor: " + "\n" + "1:near kitchen" + "\n" + "2:near bedroom" + "\n" + "3:near lift");
                        int k = in.nextInt();
                        switch (k) {
                            case (1): {
                                XS = 1;
                                YS = 6;
                            } break;
                            case (2): {
                                XS = 11;
                                YS = 6;
                            } break;
                            case (3): {
                                XS = 6;
                                YS = 3;
                            } break;
                        }
                    } break;
                }

                fill(map_way, map1, XE1, YE1);
                route = new int[moves][2];

                X = XE1;
                Y = YE1;
                do {
                    path(map_way);
                } while (X != XS || Y != YS);

                //Print(map_way, a, b);
                //Print(route, moves, 2);
                GraphicPanel graphicPanel1 = new GraphicPanel(map1, route, 1, XS, YS);
                frame.add(graphicPanel1);
                frame.setVisible(true);

            } break;
            case (2): {
                System.out.println("Choose where are you: " + "\n" + "1:room" + "\n" + "2:koridor");
                int t = in.nextInt();
                switch (t) {
                    case (1): {
                        System.out.println("Choose room: " + "\n" + "1:laboratory" + "\n" + "2:control point");
                        int k = in.nextInt();
                        switch (k) {
                            case (1): {
                                XS = 3;
                                YS = 9;
                            } break;
                            case (2): {
                                XS = 7;
                                YS = 9;
                            } break;
                        }
                    } break;
                    case (2): {
                        System.out.println("Choose koridor: " + "\n" + "1:near laboratory" + "\n" + "2:between laboratory and control point"
                                + "\n" + "3:near control point" + "\n" + "4:near walls and none rooms");
                        int k = in.nextInt();
                        switch (k) {
                            case (1): {
                                XS = 1;
                                YS = 5;
                            } break;
                            case (2): {
                                XS = 4;
                                YS = 5;
                            } break;
                            case (3): {
                                XS = 7;
                                YS = 5;
                            } break;
                            case (4): {
                                XS = 11;
                                YS = 1;
                            } break;
                        }
                    } break;
                }
                fill(map_way, map2, XE2, YE2);
                route = new int[moves][2];

                X = XE2;
                Y = YE2;
                do {
                    path(map_way);
                } while (X != XS || Y != YS);

                //Print(map_way, a, b);
                //Print(route, moves, 2);
                GraphicPanel graphicPanel1 = new GraphicPanel(map2, route, 2, XS, YS);
                frame.add(graphicPanel1);
                frame.setVisible(true);
            } break;
            case (3): {
                System.out.println("Choose where are you: " + "\n" + "1:room" + "\n" + "2:koridor");
                int t = in.nextInt();
                switch (t) {
                    case (1): {
                        System.out.println("Choose room: " + "\n" + "1:Sklad" + "\n" + "2:Isolator"+ "\n" + "3:Medical");
                        int k = in.nextInt();
                        switch (k) {
                            case (1): {
                                XS = 2;
                                YS = 9;
                            } break;
                            case (2): {
                                XS = 11;
                                YS = 9;
                            } break;
                            case (3): {
                                XS = 5;
                                YS = 6;
                            } break;
                        }
                    } break;
                    case (2): {
                        System.out.println("Choose koridor: " + "\n" + "1:near sklad" + "\n" + "2:near medical"
                                + "\n" + "3:near isolator");
                        int k = in.nextInt();
                        switch (k) {
                            case (1): {
                                XS = 3;
                                YS = 4;
                            } break;
                            case (2): {
                                XS = 8;
                                YS = 3;
                            } break;
                            case (3): {
                                XS = 11;
                                YS = 4;
                            } break;
                        }
                    } break;
                }
                fill(map_way, map3, XE2, YE2);
                route = new int[moves][2];

                X = XE2;
                Y = YE2;
                do {
                    path(map_way);
                } while (X != XS || Y != YS);

                //Print(map_way, a, b);
                //Print(route, moves, 2);
                GraphicPanel graphicPanel1 = new GraphicPanel(map3, route, 3, XS, YS);
                frame.add(graphicPanel1);
                frame.setVisible(true);
            } break;
        }
    }
}


