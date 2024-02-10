package questionfour;

//Square.java
public class Square extends Rectangle {
 public Square() {
     super();
 }

 public Square(double side) {
     super(side, side);
 }

 public Square(double side, String color, boolean filled) {
     super(side, side, color, filled);
 }

 public double getSide() {
     return getWidth(); // Since width and length are always equal in a square
 }

 public void setSide(double side) {
     setWidth(side);
     setLength(side);
 }

 @Override
 public void setWidth(double width) {
     super.setWidth(width);
     super.setLength(width);
 }

 @Override
 public void setLength(double length) {
     super.setWidth(length);
     super.setLength(length);
 }

 @Override
 public String toString() {
     return "Square[" + super.toString() + ", side=" + getSide() + "]";
 }
}

