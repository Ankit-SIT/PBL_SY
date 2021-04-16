abstract class Shape {
	private String color;
	private boolean filled;

	Shape(){
		color = "";
		filled = false;
	}

	Shape(String color, boolean filled){
		this.color = color;
		this.filled = filled;
	}

	public String getColor(){
		return this.color;
	}

	public void setColor(String color){
		this.color = color;
	}

	public boolean isFilled(){
		return this.filled;
	}

	public void setFilled(boolean filled){
		this.filled = filled;
	}

	abstract Double getArea();
	abstract Double getPerimeter();
	public String toString(){
		return "COLOR: " + this.color.toString() + "\nFILLED: " + this.filled;
	}
}

class Circle extends Shape {
	private Double radius;

	Circle(){
		this.radius = 0.0;
	}

	Circle(Double radius){
		this.radius = radius;
	}

	Circle(Double radius, String color, boolean filled){
		this.radius = radius;
		super.setColor(color);
		super.setFilled(filled);
	}

	public Double getRadius(){
		return this.radius;
	}

	public void setRadius(Double radius){
		this.radius = radius;
	}

	public Double getArea(){
		return Math.PI * radius * radius;
	}

	public Double getPerimeter(){
		return Math.PI * radius * 2;
	}

	public String toString(){
		return "RADIUS: " + radius.toString() + "\n" + super.toString();
	}
}

class Rectangle extends Shape {
	private Double width;
	private Double length;

	Rectangle(){
		this.width = 0.0;
		this.length = 0.0;
	}

	Rectangle(Double width, Double length){
		this.width = width;
		this.length = length;
	}

	Rectangle(Double width, Double length, String color, boolean filled){
		this.width = width;
		this.length = length;

		super.setColor(color);
		super.setFilled(filled);
	}

	public void setWidth(Double width){
		this.width = width;
	}
	
	public Double getWidth(){
		return this.width;
	}

	public void setLength(Double length){
		this.length = length;
	}

	public Double getLength(){
		return this.length;
	}

	public Double getArea(){
		return this.length * this.width;
	}

	public Double getPerimeter(){
		return 2 * (this.length + this.width);
	}

	public String toString(){
		return "LENGTH: " + this.length.toString() + "\nWIDTH: " + this.width.toString() + "\n" + super.toString();
	}
}

class Square extends Rectangle {
	Square(){
		super.setLength(0.0);
		super.setWidth(0.0);
	}

	Square(Double side){
		super.setLength(side);
		super.setWidth(side);
	}

	Square(Double side, String color, boolean filled){
		super.setLength(side);
		super.setWidth(side);

		super.setColor(color);
		super.setFilled(filled);
	}

	public void setSide(Double side){
		super.setLength(side);
		super.setWidth(side);
	}

	public Double getSide(){
		return super.getLength();
	}

	public void setWidth(Double side){
		super.setWidth(side);
	}

	public void setLength(Double side){
		super.setLength(side);
	}

	public String toString(){
		return "SIDE: " + super.getLength().toString() + "\nCOLOR: " + super.getColor().toString() +"\nFILLED: "+ super.isFilled();
	}
}

class Main {
	public static void main(String[] args){
		Circle circle = new Circle();
		Rectangle rectangle = new Rectangle();
		Square square = new Square();
		
		rectangle.setWidth(4.5);
		rectangle.setLength(10.0);
		rectangle.setColor("RED");
		rectangle.setFilled(true);

		System.out.println(circle.toString() + "\n");
		System.out.println(rectangle.toString() + "\n");
		System.out.println(square.toString() + "\n");
		
		System.out.println("\nAREA OF RECTANGLE: " + rectangle.getArea());
		System.out.println("PERIMETER OF RECTANGLE: " + rectangle.getPerimeter());
	}
}
