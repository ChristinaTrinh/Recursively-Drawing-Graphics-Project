import java.awt.*;

//SierpinskiTriangle is composed of infinitely many subtriangles
public class SierpinskiTriangle {
    public static void main(String[] args) {
        DrawingPanel panel = new DrawingPanel(1000, 1000);
        Graphics g = panel.getGraphics();
        Point p1 = new Point(320, 630);
        Point p2 = new Point(540, 200);
        Point p3 = new Point(760, 630);
        drawFigure(5, g, p1, p2, p3);
    }

    public static void drawFigure(int level, Graphics g, Point p1, Point p2, Point p3) {
        if (level == 1) {
            Polygon p = new Polygon();
            p.addPoint(p1.x, p1.y);
            p.addPoint(p2.x, p2.y);
            p.addPoint(p3.x, p3.y);
            g.fillPolygon(p);
        }

        else {
            // recursive case, split into 3 triangles
            Point p4 = midpoint(p1, p2);
            Point p5 = midpoint(p2, p3);
            Point p6 = midpoint(p1, p3);

            // recurse on 3 triangular areas
            drawFigure(level - 1, g, p1, p4, p6);
            drawFigure(level - 1, g, p4, p2, p5);
            drawFigure(level - 1, g, p6, p5, p3);
        }
    }

    public static Point midpoint(Point p1, Point p2) {
        return new Point((p1.x + p2.x) / 2, (p1.y + p2.y) / 2);
    }

}
