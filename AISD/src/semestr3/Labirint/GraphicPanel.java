package semestr3.Labirint;

import javax.swing.*;
import java.awt.*;

public class GraphicPanel extends JPanel {
    private int dots;
    private int[][] route;
    private int n;
    private int XS;
    private int YS;

    public GraphicPanel (){
    }
    public GraphicPanel (int [][] map1, int[][] route, int i, int XS, int YS){
        this.n = i;
        this.dots = route.length;
        this.route = route;
        this.XS = XS;
        this.YS = YS;
    }

    @Override
    public void paintComponent(Graphics g){
        Graphics2D g2 = (Graphics2D) g;
        switch (n) {
            case (1): {
                g.setColor(Color.black);
                g.drawString("1 floor", 10,60);

                g2.setStroke(new BasicStroke(10));
                Shape rect = new Rectangle(50, 50, 12*10,10*10);
                g2.setPaint(Color.lightGray);
                g2.fill(rect);
                ((Graphics2D) g).draw(rect);
                g2.setPaint(Color.black);
                ((Graphics2D) g).draw(rect);

                ((Graphics2D) g).draw(rect);
                rect = new Rectangle(50, 50, 2*10, 1*10);
                g2.setPaint(Color.darkGray);
                g2.fill(rect);
                ((Graphics2D) g).draw(rect);
                g.setColor(Color.white);
                g.drawString("Lift", 50 +5,50+1*10);

                rect = new Rectangle(50+2*10, 50+3*10, 3*10, 5*10);
                g2.setPaint(Color.pink);
                g2.fill(rect);
                ((Graphics2D) g).draw(rect);
                g2.setPaint(Color.black);
                ((Graphics2D) g).draw(rect);
                g.drawLine(50+5*10, 50+4*10, 50+8*10, 50+4*10);
                g.drawLine(50+5*10, 50+6*10, 50+7*10, 50+6*10);
                g2.setPaint(Color.pink);
                g.drawLine(50+5*10, 50+5*10, 50+5*10, 50+5*10);
                g.setColor(Color.black);
                g.drawString("K", 82,100);

                rect = new Rectangle(50+8*10, 50+2*10, 2*10, 6*10);
                g2.setPaint(Color.orange);
                g2.fill(rect);
                ((Graphics2D) g).draw(rect);
                g2.setPaint(Color.black);
                ((Graphics2D) g).draw(rect);
                g.drawLine(50+7*10, 50+8*10, 50+8*10, 50+8*10);
                g.setColor(Color.black);
                g.drawString("C", 135,90);

                g2.setPaint(Color.orange);
                g.drawLine(50+8*10, 50+5*10, 50+8*10, 50+7*10);
                g.drawLine(50+7*10, 50+7*10, 50+7*10, 50+7*10);
                g.drawLine(50+10*10, 50+4*10, 50+10*10, 50+4*10);

                g2.setPaint(Color.white);
                g.drawLine(50+6*10, 50+10*10, 50+7*10, 50+10*10);
                g2.setStroke(new BasicStroke(3));
                g2.setPaint(Color.black);
                g.drawLine(50+5*10+4, 50+4*10, 50+5*10+4, 50+6*10);
                g.drawLine(50+7*10-3, 50+6*10, 50+7*10-3, 50+8*10);
                g.drawLine(50+7*10+3, 50+4*10, 50+7*10+3, 50+6*10);
                g.drawLine(50+10*10+3, 50+3*10, 50+10*10+3, 50+5*10);
            };
            break;
            case (2): {
                g.setColor(Color.black);
                g.drawString("2 floor", 10,60);

                g2.setStroke(new BasicStroke(10));
                Shape rect = new Rectangle(50, 50, 12*10,10*10);
                g2.setPaint(Color.lightGray);
                g2.fill(rect);
                ((Graphics2D) g).draw(rect);
                g2.setPaint(Color.black);
                rect = new Rectangle(50, 50, 12*10,10*10);
                g2.setStroke(new BasicStroke(10));
                ((Graphics2D) g).draw(rect);
                rect = new Rectangle(50, 50, 2*10, 1*10);
                g2.setPaint(Color.darkGray);
                g2.fill(rect);
                ((Graphics2D) g).draw(rect);
                g.setColor(Color.white);
                g.drawString("Lift", 50 +5,50+1*10);

                g2.setPaint(Color.cyan);
                rect = new Rectangle(50 + 1*10, 50 + 7*10, 2*10, 2*10);
                g2.fill(rect);
                ((Graphics2D) g).draw(rect);
                g.setColor(Color.black);
                g.drawString("L", 70,140);

                g2.setPaint(Color.YELLOW);
                rect = new Rectangle(50 + 5*10, 50 + 7*10, 6*10, 2*10);
                g2.fill(rect);
                ((Graphics2D) g).draw(rect);
                rect = new Rectangle(50 +9*10, 50 + 4*10, 2*10, 2*10);
                g2.fill(rect);
                ((Graphics2D) g).draw(rect);
                g.setColor(Color.black);
                g.drawString("PY", 100,140);

                g2.setPaint(Color.black);
                g.drawLine(50+4*10, 50+1*10, 50+4*10, 50+3*10);
                g.drawLine(50+2*10, 50+3*10, 50+2*10, 50+5*10);
                g.drawLine(50+2*10, 50+6*10, 50+9*10, 50+6*10);
                g.drawLine(50+6*10, 50+2*10, 50+6*10, 50+5*10);
                g.drawLine(50+9*10, 50+5*10, 50+9*10, 50+5*10);
                g.drawLine(50+9*10, 50+3*10, 50+11*10, 50+3*10);
                g.drawLine(50+4*10, 50+7*10, 50+4*10, 50+9*10);
                g.drawLine(50+8*10, 50+8*10, 50+8*10, 50+9*10);

                g2.setStroke(new BasicStroke(4));
                g2.setPaint(Color.black);
                g.drawLine(50+0*10, 50+6*10+3, 50+2*10, 50+6*10+3);
                g.drawLine(50+9*10-3, 50+3*10, 50+9*10-3, 50+5*10);
            };
            break;
            case (3): {
                g.setColor(Color.black);
                g.drawString("3 floor", 10,60);

                g2.setStroke(new BasicStroke(10));
                Shape rect = new Rectangle(50, 50, 12*10,10*10);
                g2.setPaint(Color.LIGHT_GRAY);
                g2.fill(rect);
                ((Graphics2D) g).draw(rect);
                g2.setPaint(Color.black);
                rect = new Rectangle(50, 50, 12*10,10*10);
                ((Graphics2D) g).draw(rect);
                rect = new Rectangle(50, 50, 2*10, 1*10);
                g2.setPaint(Color.darkGray);
                g2.fill(rect);
                ((Graphics2D) g).draw(rect);
                g.setColor(Color.white);
                g.drawString("Lift", 50 +5,50+1*10);

                g2.setPaint(Color.MAGENTA);
                rect = new Rectangle(50+1*10-1, 50+6*10, 3*10+1,3*10);
                g2.fill(rect);
                ((Graphics2D) g).draw(rect);
                g.setColor(Color.black);
                g.drawString("C", 55,135);

                g2.setPaint(Color.pink);
                rect = new Rectangle(50+7*10, 50+7*10, 4*10,2*10);
                g2.fill(rect);
                ((Graphics2D) g).draw(rect);
                g.setColor(Color.black);
                g.drawString("Is", 135,130);

                g2.setPaint(Color.cyan);
                rect = new Rectangle(50+5*10, 50+3*10, 1*10,5*10);
                g2.fill(rect);
                ((Graphics2D) g).draw(rect);
                g.drawLine(50+4*10,50+5*10,50+9*10+5,50+5*10);
                g.setColor(Color.black);
                g.drawString("M", 95,125);

                g2.setPaint(Color.black);
                g.drawLine(50+1*10-1,50+5*10,50+1*10-1,50+6*10);
                g.drawLine(50+4*10,50+6*10,50+4*10,50+8*10);
                g.drawLine(50+5*10-2,50+9*10,50+6*10+4,50+9*10);
                g.drawLine(50+7*10,50+6*10,50+7*10,50+7*10);
                g.drawLine(50+7*10,50+6*10,50+11*10,50+6*10);
                g.drawLine(50+7*10,50+4*10,50+10*10,50+4*10);
                g.drawLine(50+10*10,50+2*10,50+10*10,50+4*10);
                g.drawLine(50+8*10,50+2*10,50+8*10,50+2*10);
                g.drawLine(50+7*10,50+3*10,50+7*10,50+3*10);
                g.drawLine(50+6*10,50+2*10,50+6*10,50+2*10);
                g.drawLine(50+5*10,50+3*10,50+5*10,50+3*10);
                g.drawLine(50+4*10,50+4*10,50+4*10,50+4*10);
                g.drawLine(50+3*10,50+5*10,50+3*10,50+5*10);

                g2.setStroke(new BasicStroke(3));
                g.drawLine(50+1*10, 50+5*10+4, 50+3*10, 50+5*10+4);
                g.drawLine(50+7*10-3, 50+7*10, 50+7*10-3, 50+8*10+6);
                g.drawLine(50+10*10, 50+4*10, 50+10*10, 50+6*10);
            };
            break;
        }
        g.setColor(Color.black);
        g.drawString("x", 50 + 10*XS,50+10*YS);
        g2.setStroke(new BasicStroke(3));
        g2.setColor(Color.red);
        for (int i = 0; i < dots; i++) {
            int x =  route[i][1]*10 + 50;
            int y =   route[i][0]*10 + 50;
            g2.drawLine(x,y,x,y);
        }
        if (n == 2 || n == 3) {
            g.setColor(Color.black);
            g.drawString("Then go down on elevator", 50,175);

            g.setColor(Color.black);
            g.drawString("1 floor", 10,210);

            g2.setStroke(new BasicStroke(10));
            Shape rect = new Rectangle(50, 200, 12*10,10*10);
            g2.setPaint(Color.lightGray);
            g2.fill(rect);
            ((Graphics2D) g).draw(rect);
            g2.setPaint(Color.black);
            ((Graphics2D) g).draw(rect);

            ((Graphics2D) g).draw(rect);
            rect = new Rectangle(50, 200, 2*10, 1*10);
            g2.setPaint(Color.darkGray);
            g2.fill(rect);
            ((Graphics2D) g).draw(rect);
            g.setColor(Color.white);
            g.drawString("Lift", 50 +5,200+1*10);

            rect = new Rectangle(50+2*10, 200+3*10, 3*10, 5*10);
            g2.setPaint(Color.pink);
            g2.fill(rect);
            ((Graphics2D) g).draw(rect);
            g2.setPaint(Color.black);
            ((Graphics2D) g).draw(rect);
            g.drawLine(50+5*10, 200+4*10, 50+8*10, 200+4*10);
            g.drawLine(50+5*10, 200+6*10, 50+7*10, 200+6*10);
            g2.setPaint(Color.pink);
            g.drawLine(50+5*10, 200+5*10, 50+5*10, 200+5*10);
            g.setColor(Color.black);
            g.drawString("K", 82,250);

            rect = new Rectangle(50+8*10, 200+2*10, 2*10, 6*10);
            g2.setPaint(Color.orange);
            g2.fill(rect);
            ((Graphics2D) g).draw(rect);
            g2.setPaint(Color.black);
            ((Graphics2D) g).draw(rect);
            g.drawLine(50+7*10, 200+8*10, 50+8*10, 200+8*10);

            g2.setPaint(Color.orange);
            g.drawLine(50+8*10, 200+5*10, 50+8*10, 200+7*10);
            g.drawLine(50+7*10, 200+7*10, 50+7*10, 200+7*10);
            g.drawLine(50+10*10, 200+4*10, 50+10*10, 200+4*10);
            g.setColor(Color.black);
            g.drawString("C", 135,240);

            g2.setPaint(Color.white);
            g.drawLine(50+6*10, 200+10*10, 50+7*10, 200+10*10);
            g2.setStroke(new BasicStroke(3));
            g2.setPaint(Color.black);
            g.drawLine(50+5*10+4, 200+4*10, 50+5*10+4, 200+6*10);
            g.drawLine(50+7*10-3, 200+6*10, 50+7*10-3, 200+8*10);
            g.drawLine(50+7*10+3, 200+4*10, 50+7*10+3, 200+6*10);
            g.drawLine(50+10*10+3, 200+3*10, 50+10*10+3, 200+5*10);

            g2.setStroke(new BasicStroke(3));
            g2.setColor(Color.red);
            for (int i = 2; i <= 8; i++) {
                int y =  i*10 + 200;
                int x = 50+1*10;
                g2.drawLine(x,y,x,y);
            }
            for (int i = 1; i <= 6; i++) {
                int x =  i*10 + 50;
                int y = 200+9*10;
                g2.drawLine(x,y,x,y);
            }
        }
    }
}
