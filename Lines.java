
import java.awt.Graphics;
import java.awt.event.MouseEvent;

public class Lines extends Shape {

    public Lines(int x1, int y1, int x2, int y2) {
        this.x1 = x1;
        this.x2 = x2;
        this.y1 = y1;
        this.y2 = y2;

    }

    public Lines() {
    }

    ;
    
   
    @Override
    public void paint(Graphics g) {

        g.setColor(this.c1);
        g.drawLine(x1, y1, x2, y2);

    }


    @Override
    public void mouseDragged(MouseEvent e) {
        x2 = e.getX();
        y2 = e.getY();

    }

    @Override
    public void mouseReleased(MouseEvent e) {
        Lines l2 = new Lines(x1, y1, x2, y2);
        l2.setC1(this.c1);
        Shape.s1.add(l2);
    }

}
