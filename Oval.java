
import java.awt.Graphics;
import java.awt.event.MouseEvent;

public class Oval extends Shape {

    public Oval(int x1, int y1, int x2, int y2) {
        this.x1 = x1;
        this.x2 = x2;
        this.y1 = y1;
        this.y2 = y2;

    }

    public Oval() {
    }

    ;
    
    




    
    @Override
    public void paint(Graphics g) {
        g.setColor(this.c1);
        if (this.flag) {
            g.fillOval(Math.min(x1, x2), Math.min(y1, y2), Math.abs(x2 - x1), Math.abs(y2 - y1));
        } else {
            g.drawOval(Math.min(x1, x2), Math.min(y1, y2), Math.abs(x2 - x1), Math.abs(y2 - y1));
        }
    }

    @Override
    public void mouseReleased(MouseEvent e) {
        x2 = e.getX();
        y2 = e.getY();
        Oval o2 = new Oval(x1, y1, x2, y2);
        o2.setC1(this.c1);
        o2.setFlag(flag);
        s1.add(o2);
    }

}
