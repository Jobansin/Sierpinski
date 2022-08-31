import java.awt.*;
import javax.swing.*;

public class Sierpinski extends Canvas
{
    public int n;
    public int size;

    public void paint(Graphics g)
    {   if (n == 0)
        {
        int[] xs = {0, size/2, size};
        int[] ys = {size, size-calculateHeight(size), size};
        g.drawPolygon(xs, ys, 3);
        }
        if (n > 0)
        {
        int[] xs = {0, size/2, size};
        int[] ys = {size, size-calculateHeight(size), size};
        g.drawPolygon(xs, ys, 3);
        sierpinski(g, n, size/2, size, size/2);
        }
    }

    private void triangle(Graphics g, int x, int y, int l){

        int[] xs = {x, x-(l/2), x+(l/2)};
        int[] ys = {y, y-calculateHeight(l), y-calculateHeight(l)};
        g.drawPolygon(xs, ys, 3);
    }

    private void sierpinski(Graphics g, int n, int x, int y, int l){
        triangle(g, x, y, l);
        if(n > 1)
        {
            sierpinski(g, n-1, x-l/2, y, l/2);
            sierpinski(g, n-1, x, y-calculateHeight(l), l/2);
            sierpinski(g, n-1, x+l/2, y, l/2);
        }
    }
    private int calculateHeight(double l){
        return (int) (0.5 * Math.pow(3,0.5) * l);
    }

    public static void main(String[] args)
    {
        JFrame frame = new JFrame();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        Sierpinski drawing = new Sierpinski();
        drawing.n = Integer.parseInt(args[0]);
        drawing.size = 700;
        drawing.setSize(drawing.size, drawing.size);
        frame.add(drawing);
        frame.pack();
        frame.setVisible(true);
    }
}