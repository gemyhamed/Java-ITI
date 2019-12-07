
import java.awt.Graphics;
import java.awt.event.MouseEvent;

public class Pen extends Shape {

    public Pen(int x1, int y1, int x2, int y2) {
        this.x1 = x1;
        this.x2 = x2;
        this.y1 = y1;
        this.y2 = y2;

    }

    public Pen() {
    }

    ;
    
    

    @Override
    public void paint(Graphics g) {

        for (int count = 0; count < lineArr.size(); count++) {
            g.setColor(lineArr.get(count).getC1());
            g.drawLine(lineArr.get(count).x1, lineArr.get(count).y1, lineArr.get(count).x2, lineArr.get(count).y2);
        }
    }

    @Override
    public void mouseDragged(MouseEvent e) {
        x2 = e.getX();
        y2 = e.getY();
        Lines l2 = new Lines(x1, y1, x2, y2);
        l2.setC1(this.c1);
        lineArr.add(l2);
        x1 = x2;
        y1 = y2;

    }

    @Override
    public void mouseReleased(MouseEvent e) {
        Pen p1 = new Pen();
        p1.setC1(this.c1);
        for (int i = 0; i < lineArr.size(); i++) {
            p1.lineArr.add(this.lineArr.get(i));
        }
        Shape.s1.add(p1);

    }

}
