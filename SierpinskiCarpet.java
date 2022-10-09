import java.awt.*;
//The Sierpinski carpet is a fractal that is defined as follows: 
//The construction of the Sierpinski carpet begins with a square. 
//The square is cut into nine congruent subsquares in a 3-by-3 grid, with the central subsquare removed. 
//The same process is then applied recursively to the eight other subsquares.

public class SierpinskiCarpet {
    public static void main(String[] args) {
        DrawingPanel panel = new DrawingPanel(2500, 2500);
        Graphics g = panel.getGraphics();
        Point p1 = new Point(500, 400);
        Point p2 = new Point(701, 400);
        Point p3 = new Point(701, 601);
        Point p4 = new Point(500, 601);
        drawFigure(4, g, p1, p2, p3, p4);
    }

    public static void drawFigure(int level, Graphics g, Point p1, Point p2, Point p3, Point p4) {
        if (level == 1) {
            Polygon p = new Polygon();
            p.addPoint(p1.x, p1.y);
            p.addPoint(p2.x, p2.y);
            p.addPoint(p3.x, p3.y);
            p.addPoint(p4.x, p4.y);
            g.fillPolygon(p);
        }

        else {
            int L = findLengthOfBox(p1, p2);
            int firstX = findFirstX(p1, L);
            int secondX = findSecondX(p1, L);
            int thirdX = findThirdX(p2, L);
            int firstY = findFirstY(p1, L);
            int secondY = findSecondY(p1, L);
            int thirdY = findThirdY(p4, L);

            drawFigure(1, g, p1, p2, p3, p4);
            drawFigure(level - 1, g, new Point(firstX, firstY), new Point(firstX + L, firstY),
                    new Point(firstX + L, firstY + L), new Point(firstX, firstY + L));
            drawFigure(level - 1, g, new Point(secondX, firstY), new Point(secondX + L, firstY),
                    new Point(secondX + L, firstY + L), new Point(secondX, firstY + L));
            drawFigure(level - 1, g, new Point(thirdX, firstY), new Point(thirdX + L, firstY),
                    new Point(thirdX + L, firstY + L), new Point(thirdX, firstY + L));
            drawFigure(level - 1, g, new Point(firstX, secondY), new Point(firstX + L, secondY),
                    new Point(firstX + L, secondY + L), new Point(firstX, secondY + L));
            drawFigure(level - 1, g, new Point(thirdX, secondY), new Point(thirdX + L, secondY),
                    new Point(thirdX + L, secondY + L), new Point(thirdX, secondY + L));
            drawFigure(level - 1, g, new Point(firstX, thirdY), new Point(firstX + L, thirdY),
                    new Point(firstX + L, thirdY + L), new Point(firstX, thirdY + L));
            drawFigure(level - 1, g, new Point(secondX, thirdY), new Point(secondX + L, thirdY),
                    new Point(secondX + L, thirdY + L), new Point(secondX, thirdY + L));
            drawFigure(level - 1, g, new Point(thirdX, thirdY), new Point(thirdX + L, thirdY),
                    new Point(thirdX + L, thirdY + L), new Point(thirdX, thirdY + L));
        }
    }

    public static int findLengthOfBox(Point p1, Point p2) {
        return (p2.x - p1.x) / 3;
    }

    public static int findFirstX(Point p1, int L) {
        return p1.x - (L * 2);
    }

    public static int findSecondX(Point p1, int L) {
        return p1.x + L;
    }

    public static int findThirdX(Point p2, int L) {
        return p2.x + L;
    }

    public static int findFirstY(Point p1, int L) {
        return p1.y - (L * 2);
    }

    public static int findSecondY(Point p1, int L) {
        return p1.y + L;
    }

    public static int findThirdY(Point p4, int L) {
        return p4.y + L;
    }
}
