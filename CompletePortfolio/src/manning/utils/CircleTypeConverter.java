package manning.utils;

import java.util.Map;

import org.apache.struts2.util.StrutsTypeConverter;

import com.opensymphony.xwork2.util.TypeConversionException;



public class CircleTypeConverter extends StrutsTypeConverter {

	
	public Object convertFromString(Map context, String[] values, Class toClass) {
		
		
		/* 
		 * For this simple converter, we assume that only one value was passed in. 
		 * Thus, we take only the first element in the array of parameter values.
		 */
		String userString = values[0];
		Circle newCircle = parseCircle ( userString );
		return newCircle;
	}

	
	public String convertToString(Map context, Object o) {
		
		Circle circle = (Circle) o;
		String userString = "C:r" + circle.getRadius(); 
		
		return userString;
	}
	
	private Circle parseCircle( String userString ) throws TypeConversionException {
		Circle circle = null;
		
		int radiusIndex = userString.indexOf('r') + 1;
		System.out.println("userString = " + userString);
		
		/* Unsophisticted syntax checking.  Make sure that our circle string
		 * at least begins with a 'C:'.
		 */
		if (!userString.startsWith( "C:r")  )
			throw new TypeConversionException ( "Invalid Syntax");
		
		int radius;
		try {
			radius = Integer.parseInt( userString.substring( radiusIndex ) );
		}catch ( NumberFormatException e ) {
			throw new TypeConversionException ( "Invalid Integer Value for Radius"); }
		
				
		circle = new Circle();
		circle.setRadius( radius );
 		
		return circle;
	}

}
