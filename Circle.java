/**
  * Circle.java - a simple Circle class
  */
  public class Circle   
  {
      private int red;      // color of circle
      private int green;
      private int blue;
      private Point origin; // origin of circle
      private double radius; // radius
   
      public Circle(final Point org, final double rad)
      {
          red = 0; green = 0; blue = 0;  // black
          origin = new Point(org.getX(), org.getY());
          radius = rad;
      }
   
      public int getB()
      {
          return blue;
      }
   
      public int getG()
      {
          return green;
      }
   
      public int getR()
      {
          return red;
      }
   
      public void setRGB(int r, int g, int b)
      {
         // Simplification: doesn't check for valid values
         red = r; green = g; blue = b;
      }
   
      public double getRadius()
      {
          return radius;
      }
   
      public void setRadius(double r)
      {
          radius = r;
      }
   
      public Point getOrigin()
      {
          return origin;
      }
      
      public void setOrigin(Point org)
      {
          origin.setPoint(org.getX(), org.getY());
      }
  }
 