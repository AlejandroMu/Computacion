package TDD.TDDTest;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        System.out.println( "Hello World!" );
    }
    public static int add(String value) {
    	String values=parse(value);
    	if(values==null) {
    		throw new RuntimeException();
    	}
    	if(values.equals("")) {
    		return 0;
    	}
    	
    	String line[]=values.split(",");
    	if(line.length==1) {
    		try {
        		return Integer.parseInt(values);

			} catch (Exception e) {
	    		throw new RuntimeException();

			}
    	}
       	try {
       		int sum=0;
       		for (int i = 0; i < line.length; i++) {
        		sum+=Integer.parseInt(line[i]);

			}
        	
        	return sum;
		} catch (Exception e) {
    		throw new RuntimeException();

		}
    	
    }
	private static String parse(String value) {
		if(value==null) {
			return null; 
		}
		String part[]=value.split("\\n");
		if(part[0].length()!=3) {
			return null;
		}
		return null;
	}
}
