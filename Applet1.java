
import java.applet.Applet;
import java.awt.Button;
import java.awt.Color;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.MouseEvent;
import java.awt.Checkbox;
import java.awt.Image;
import java.awt.*;
import java.applet.*;

/**
 *
 * @author Gemy
 */
public class Applet1 extends Applet implements MouseListener, MouseMotionListener {

    //Buttons
    Button recbt = new Button("Rec");
    Button penbt = new Button("Pen");
    Button linbt = new Button("Line");
    Button ovbt = new Button("Oval");
    Checkbox flbt = new Checkbox("Fill");
    Button ersbt = new Button("Erase");
    Button blubt = new Button("Blue");
    Button rdbt = new Button("Red");
    Button grbt = new Button("Green");
    Button udbt = new Button("Undo");
    Button clbt = new Button("Clear All");
    Button rebt = new Button("redo");
    Button loadbt = new Button("Load Image");

    int count = 0;
    Shape obj;
    Image img;
    private Image i;
    private Graphics g2;
    protected boolean fillflag = false;
    protected boolean redoflag = false;
    protected boolean imgflag = false;

    Color currentColor = Color.BLACK;

    @Override
    public void init() {

        addMouseListener(this);
        addMouseMotionListener(this);

        recbt.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                obj = new Rec();
                Shape.destroydelete();

            }
        });
        add(recbt);

        penbt.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                obj = new Pen();
                Shape.destroydelete();
            }
        });
        add(penbt);

        linbt.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                obj = new Lines();
                Shape.destroydelete();
            }
        });
        add(linbt);
        ovbt.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                obj = new Oval();
                Shape.destroydelete();
            }
        });
        add(ovbt);

        flbt.addItemListener(new ItemListener() {
            @Override
            public void itemStateChanged(ItemEvent e) {

                if (fillflag) {
                    fillflag = false;
                } else {
                    fillflag = true;
                }

            }
        });

        add(flbt);
        ersbt.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                obj = new Eraser();
                Shape.destroydelete();

            }
        });
        add(ersbt);
        blubt.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                currentColor = Color.BLUE;
            }
        });
		blubt.setBackground(Color.BLUE);
        add(blubt);
        rdbt.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                currentColor = Color.RED;
            }
        });
		rdbt.setBackground(Color.RED);
        add(rdbt);
        grbt.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                currentColor = Color.GREEN;
            }
        });
		grbt.setBackground(Color.GREEN);
        add(grbt);

        udbt.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (obj != null) {
                    Shape.removeItem();
                    obj = new Shape();
                    repaint();
                }
            }
        });
        add(udbt);

        clbt.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (obj != null) {
                    Shape.destroyList();
                    Shape.destroydelete();
                    img = null;
                    repaint();
                    obj = null;
                }
            }
        });
        add(clbt);
        rebt.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (obj != null && Shape.deletedlist.size() > 0) {
                    redoflag = true;
                    repaint();
                }
            }
        });
        add(rebt);
        loadbt.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                imgflag = true;
                obj = new Shape();
                img = getImage(getDocumentBase(), "ITI.png");
                repaint();

            }
        }
        );
        add(loadbt);

    }

    @Override
    public void paint(Graphics g) {
        for (int i = 0; i < Shape.s1.size(); i++) {
            Shape.s1.get(i).paint(g);
        }
        for (int i = 0; i < Shape.dragList.size(); i++) {
            Shape.dragList.get(i).paint(g);
        }

        if (redoflag) {
            Shape.deletedlist.get(Shape.deletedlist.size() - 1).paint(g);
            redoflag = false;
            Shape.resetundo();
        }
        if (imgflag) {
            g.drawImage(img, 100, 100, this);

        }
    }

    @Override
    public void mouseClicked(MouseEvent e) {
    }

    @Override
    public void mousePressed(MouseEvent e) {
        if (obj != null) {
            obj.setC1(currentColor);
            obj.setFlag(fillflag);
            obj.mousePressed(e);

        }
    }

    @Override
    public void mouseReleased(MouseEvent e) {
        if (obj != null) {
            Shape.removeItemDragList();
            obj.mouseReleased(e);
            repaint();
        }
    }

    @Override
    public void mouseEntered(MouseEvent e) {

    }

    @Override
    public void mouseExited(MouseEvent e) {

    }

    @Override
    public void mouseDragged(MouseEvent e) {
        if (obj != null) {
            Shape.removeItemDragList();
            obj.mouseDragged(e);
            Shape.addarrayDragList(obj);
            repaint();
        }
    }

    @Override
    public void mouseMoved(MouseEvent e) {

    }

    public void update(Graphics g) {
        if (i == null) {
            i = createImage(this.getSize().width, this.getSize().height);

            g2 = i.getGraphics();
        }

        g2.setColor(getBackground());
        g2.fillRect(0, 0, this.getSize().width, this.getSize().height);

        g2.setColor(getForeground());
        paint(g2);
        g.drawImage(i, 0, 0, null);

    }

}
