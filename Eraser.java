
import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.MouseEvent;
import java.util.ArrayList;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author Gemy
 */
public class Eraser extends Shape {

    protected ArrayList<Shape> RecArr = new ArrayList<>();

    public Eraser(int x1, int y1, int x2, int y2) {
        this.x1 = x1;
        this.x2 = x2;
        this.y1 = y1;
        this.y2 = y2;

    }

    public Eraser() {
    }

    ;
    
    
    @Override
    public void paint(Graphics g) {

        for (int count = 0; count < RecArr.size(); count++) {
            g.setColor(Color.WHITE);
            g.fillRect(Math.min(RecArr.get(count).x1, RecArr.get(count).x2),
                    Math.min(RecArr.get(count).y1, RecArr.get(count).y2),
                    6,
                    8
            );
        }
    }

    @Override
    public void mouseDragged(MouseEvent e) {
        x2 = e.getX();
        y2 = e.getY();
        Rec l2 = new Rec(x1 + 5, y1 + 5, x2, y2);
        l2.setC1(Color.WHITE);
        RecArr.add(l2);
        x1 = x2;
        y1 = y2;

    }

    @Override
    public void mouseReleased(MouseEvent e) {
        Eraser e2 = new Eraser();
        e2.setC1(Color.WHITE);
        for (int i = 0; i < RecArr.size(); i++) {
            e2.RecArr.add(this.RecArr.get(i));
        }
        Shape.s1.add(e2);

    }

}
