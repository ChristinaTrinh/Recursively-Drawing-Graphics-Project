import java.awt.*;
// The Cantor set is a fractal that is defined by repeatedly removing the middle thirds of line segments

public class Cantor {
    public static void main(String[] args) {
        DrawingPanel panel = new DrawingPanel(1000, 1000);
        Graphics g = panel.getGraphics();
        Point p1 = new Point(20, 20);
        Point p2 = new Point(501, 20);
        drawFigure(5, g, p1, p2);
    }

    public static void drawFigure(int level, Graphics g, Point p1, Point p2) {
        if (level == 1)
            g.drawLine(p1.x, p1.y, p2.x, p2.y);
        else {
            g.drawLine(p1.x, p1.y, p2.x, p2.y);
            int L = computeLength(p1, p2);
            drawFigure(level - 1, g, new Point(p1.x, p1.y + 20), new Point(p1.x + L, p1.y + 20));
            drawFigure(level - 1, g, new Point(p2.x - L, p1.y + 20), new Point(p2.x, p1.y + 20));
        }
    }

    public static int computeLength(Point p1, Point p2) {
        return (p2.x - p1.x) / 3;
    }
}
