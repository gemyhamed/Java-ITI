
import java.awt.Graphics;
import java.awt.event.MouseEvent;

/**
 *
 * @author Gemy
 */
public class Rec extends Shape {

    public Rec(int x1, int y1, int x2, int y2) {
        this.x1 = x1;
        this.x2 = x2;
        this.y1 = y1;
        this.y2 = y2;
    }

    public Rec() {
    }

    ;
    

   @Override
    public void paint(Graphics g) {

        g.setColor(this.c1);
        if (this.flag) {
            g.fillRect(Math.min(x1, x2), Math.min(y1, y2), Math.abs(x2 - x1), Math.abs(y2 - y1));
        } else {
            g.drawRect(Math.min(x1, x2), Math.min(y1, y2), Math.abs(x2 - x1), Math.abs(y2 - y1));
        }
    }

    @Override
    public void mouseReleased(MouseEvent e) {
        x2 = e.getX();
        y2 = e.getY();
        Rec r1 = new Rec(x1, y1, x2, y2);
        r1.setC1(this.c1);
        r1.setFlag(this.flag);
        Shape.s1.add(r1);

    }

}
