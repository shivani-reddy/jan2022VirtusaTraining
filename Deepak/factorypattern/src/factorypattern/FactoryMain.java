package factorypattern;

public class FactoryMain {

	public static void main(String[] args) {
		ShapeType shapeType = new ShapeType();

	      
	      Shape shape1 = shapeType.getShape("CIRCLE");
	      shape1.draw();

	      
	      Shape shape2 = shapeType.getShape("RECTANGLE");
	      shape2.draw();

	    
	      Shape shape3 = shapeType.getShape("SQUARE");
	      shape3.draw();

	}

}
