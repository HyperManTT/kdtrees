import java.util.ArrayList;
import java.util.Iterator;
import java.util.NoSuchElementException;

public class PointSET
{
    private SET<Point2D> pointSet;
    private ArrayList<Point2D> al;
    public PointSET()
    {
        pointSet = new SET<Point2D>();
    }
    
    public boolean isEmpty()
    {
        return pointSet.isEmpty();
    }
    
    public int size()
    {
        return pointSet.size();
    }
    
    public void insert(Point2D p)
    {
        pointSet.add(p);
    }
    
    
    public boolean contains(Point2D p)
    {
       return pointSet.contains(p); 
    }
    
    public void draw()
    {
        for (Point2D pt : pointSet)
        {
            pt.draw();
        }
    }
    
    public Iterable<Point2D> range(RectHV rect)
    {
        al = new ArrayList<Point2D>();
        for (Point2D pt : pointSet)
        {
            if (rect.contains(pt))
            {
                al.add(pt);
            }
        }
        return al;
        /*return new Iterable<Point2D>()
        {
            @Override
            public Iterator<Point2D> iterator()
            {
                return new Iterator<Point2D>()
                {
                    private int position;
                    @Override
                    public boolean hasNext()
                    {
                        return position != al.size();
                    }
                    @Override
                    public Iterable<Point2D> next()
                    {
                        if (!hasNext()) throw new NoSuchElementExeption();
                        return al.get(position++);
                    }
                    
                    public remove()
                    {
                    }
                };
            }
        };*/
    }
    
    
    public Point2D nearest(Point2D p)
    {
        Point2D nearestPoint = null;
        double nearestDistance = 100000;
        for (Point2D pt : pointSet)
        {
            if (p.equals(pt))
            {
                continue;
            }
            double distanceCalc = p.distanceSquaredTo(pt);
            if (distanceCalc < nearestDistance)
            {
                nearestPoint = pt;
                nearestDistance = distanceCalc;
            }
        }
        return nearestPoint;
    }
    
    public static void main(String args[])
    {
        PointSET p = new PointSET();
        StdDraw.show(0);
        StdDraw.clear();
        StdDraw.setPenColor(StdDraw.BLACK);
        StdDraw.setPenRadius(.01);
    }
    
}