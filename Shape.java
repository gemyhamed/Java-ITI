
import java.awt.Color;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.awt.Graphics;

/**
 *
 * @author Gemy
 */
class Shape {

    protected int x1, y1, x2, y2;
    protected static ArrayList<Shape> s1 = new ArrayList<Shape>();
    protected ArrayList<Shape> lineArr = new ArrayList<Shape>();
    protected static ArrayList<Shape> dragList = new ArrayList<>();
    protected static ArrayList<Shape> deletedlist = new ArrayList<>();
    protected Color c1;
    protected boolean flag;

    public int getX1() {
        return x1;
    }

    public void setX1(int x1) {
        this.x1 = x1;
    }

    public int getY1() {
        return y1;
    }

    public void setY1(int y1) {
        this.y1 = y1;
    }

    public boolean isFlag() {
        return flag;
    }

    public void setFlag(boolean flag) {
        this.flag = flag;
    }

    public Color getC1() {
        return c1;
    }

    public void setC1(Color c1) {
        this.c1 = c1;
    }

    public void init() {

    }

    public void paint(Graphics g) {

    }

    public void mousePressed(MouseEvent e) {
        x1 = e.getX();
        y1 = e.getY();
        x2 = e.getX();
        y2 = e.getY();

    }

    public void mouseClicked(MouseEvent e) {
    }

    public void mouseDragged(MouseEvent e) {
        x2 = e.getX();
        y2 = e.getY();
    }
	
    public void mouseReleased(MouseEvent e) {
    }

    public static void removeItem() {
        if (s1.size() > 0) {
            deletedlist.add(s1.get(s1.size() - 1));
            s1.remove(s1.size() - 1);
        }

    }

    public static void destroyList() {
        s1.removeAll(s1);

    }

    public static void addarrayDragList(Shape s) {
        dragList.add(s);
    }

    public static void removeItemDragList() {
        if (!dragList.isEmpty()) {
            dragList.remove(dragList.size() - 1);
        }

    }

    public static void resetundo() {
        Shape.s1.add(Shape.deletedlist.get(Shape.deletedlist.size() - 1));
        Shape.deletedlist.remove(Shape.deletedlist.size() - 1);
    }

    public static void destroydelete() {
        deletedlist.removeAll(deletedlist);

    }
}
