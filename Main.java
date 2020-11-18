
import java.util.Scanner;
//Complete this program that the user will be able to choose the quadrilateral it wants to calculate its perimeter and area

class Main {
  public static void main(String[] args) {
    //Declare a char to store the chosen quadrilateral
        System.out.println("This is program is to calculate the perimeter and area of any selected quadrilateral");
        System.out.println("");
        System.out.println("Input P for parallelogram, input T for trapezoid, input A for rectangle, input S for square and input R for rhombus");
        Scanner scan = new Scanner(System.in);
        char quad = scan.next().charAt(0); 

    //using a switch check what the user selected and use it to calculate the perimeter and area of the desired quadrilateral
    switch (quad) {
      case 'P': //this should be in the parallelogram case
          System.out.println("This program calculates the area and perimeter of the parallelogram.");
          System.out.println("Input the base of your Parallelogram");
          float pBase = scan.nextFloat();
          System.out.println("Input the height of your Parallelogram");
          float pHeight = scan.nextFloat();
          Parallelogram p = new Parallelogram(pBase, pHeight);
          
          Quadrilateral q = p;

        
          System.out.println("Input the dimension of the first pair of your Parallelogram");
          q.setLength(scan.nextFloat());
          System.out.println("Input the second pair of your Parallelogram");
          q.setBreadth(scan.nextFloat());
          
          System.out.printf("The area of the parallelogram with base %.2f and height %.2f is %.2f", pBase, pHeight, p.Area());

          System.out.println("");
          System.out.printf("The perimeter of the parallelogram with First Pair: %.2f and SecondPair: %.2f is %.2f", q.getLength(), q.getBreadth(), q.calculatePerimeter());
          System.out.println("");
          System.out.println("");
          System.out.println("");
          break;

        case 'T': 
          //this should be in the Trapezoid case
          System.out.println("Calculation for a Trapezoid");
          System.out.println("Input first side");
          float a = scan.nextFloat();
          System.out.println("Input second side");
          float b = scan.nextFloat();
          System.out.println("Input third side");
          float c = scan.nextFloat();
          System.out.println("Input fourth side");
          float d = scan.nextFloat();
          Trapezoid t = new Trapezoid(a, b, c, d);
          System.out.printf("The perimeter of the Trapezoid with First Side: %.2f, Second Side: %.2f, Third Side: %.2f, and Fourth Side: %.2f is %.2f", a, b, c, d, t.calculatePerimeter()); 
          break;

          case 'A':
            //The rectangle case
                System.out.println("This program calculates the area and perimeter of the Rectangle.");
                System.out.println("Input the Length of your rectangle");
                float rLength = scan.nextFloat();
                System.out.println("Input the breadth of your rectangle");
                float rbreadth = scan.nextFloat(); 

                Rectangle r = new Rectangle(rLength, rbreadth);

                System.out.printf("The area of the rectangle with base %.2f and height %.2f is %.2f", rbreadth, rLength, r.Area());

                System.out.println("");
                System.out.printf("The perimeter of the rectangle with First Pair: %.2f and SecondPair: %.2f is %.2f", rLength, rbreadth, r.calculatePerimeter());

                break;

            case 'S':
            //The Square Class
            System.out.println("This program calculates the area and perimeter of the Square.");
                System.out.println("Input the Length of your Square");
                float sLength = scan.nextFloat();
                
                Square s = new Square(sLength);

                System.out.printf("The area of the Square with length %.2f is %.2f", sLength, s.Area());

                System.out.println("");
                System.out.printf("The perimeter of the Square with length %.2f is %.2f", sLength, s.calculatePerimeter());

                break;

             case 'R':
             //The Rhombus Class
             System.out.println("This program calculates the area and perimeter of the Rhombus ");
             System.out.println("Input the diagonals of your rhombus");
             float rhoLength = scan.nextFloat();

            Rhombus rho = new Rhombus(rhoLength);

            System.out.printf("The area of the Rhombus with diagonal 1 of %.2f and diagonal 2 of %.2f is %.2f", rhoLength, rhoLength, rho.Area());
            System.out.println("");

            System.out.printf("The perimeter of the Rhombus with length %.2f is %.2f", rhoLength, rho.calculatePerimeter());

            break;

            default: 
            System.out.println("Your selected choice doesn't exist!");
    }

  }
}

//Create class for Rhombus
class Rhombus extends Quadrilateral{
    
    private float length;
   
    public Rhombus (float l) {
   
        if (l <= 0){
            System.out.println("You cannot have a negative or zero length. Therfore height returns to default which is 1");
            length = 1;
        }

        else
            length = l;
    }
    public float calculatePerimeter(){
        return 4*length;
    }
    public float Area(){

        return ((length*length) / 2);

    }
    
}


//Create class for square
class Square extends Quadrilateral{
    private float length;
      
    public Square (float l) {

        if (l <= 0){
            System.out.println("You cannot have a negative or zero length. Therfore length returns to default which is 1");
            length = 1;
        } else {
            length = l;
        }

    }
    public float Area(){ 

            return (length * length);
    }
    public float calculatePerimeter(){

         return (length+length+length+length);
 
    }
     
}


//create class for Rectangle
class Rectangle extends Quadrilateral{
    private float length;
    private float breadth;
   
    public Rectangle (float l, float b) {

        if (b <= 0){
            System.out.println("You cannot have a negative or zero base. Therfore base returns to default which is 1");
            breadth = 1;
        }
        else{
            breadth = b;
        }
           
        if (l <= 0){
            System.out.println("You cannot have a negative or zero height. Therfore height returns to default which is 1");
            length = 1;
        }
        else
            length = l;
    }
    public float calculatePerimeter(){
        return 2*(length+breadth);
    }
    public float Area(){
        return breadth * length;
    }

}

class Trapezoid extends Quadrilateral{
  private float side1;
  private float side2;
  private float side3;
  private float side4;
  public Trapezoid (float a, float b, float c, float d){
    side1 = a;
    side2 = b;
    side3 = c;
   
    side4 = d;
  }

  public float calculatePerimeter(){
    return side1+side2+side3+side4;
  }
}

class Parallelogram extends Quadrilateral{
  private float base;
  private float height;
  public Parallelogram (float b, float h){
    if (b <= 0){
      System.out.println("You cannot have a negative or zero base. Therfore base returns to default which is 1");
      base = 1;
    }
    else
      base = b;
    if (h <= 0){
      System.out.println("You cannot have a negative or zero height. Therfore height returns to default which is 1");
      height = 1;
    }
    else
      height = h;
  }
  public float Area(){
    return base*height;
  }

}

class Quadrilateral { 
  private float length;
  private float breadth;

  public void setLength(float l){
    length = l;
  }

  public float getLength(){
    return length;
  }

  public void setBreadth(float b){
    breadth = b;
  }

  public float getBreadth(){
    return breadth;
  }

  public float calculatePerimeter(){
    return 2*(length+breadth);
  }
}