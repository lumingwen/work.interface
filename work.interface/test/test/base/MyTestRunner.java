package test.base;

import java.io.FileNotFoundException;

import org.junit.internal.runners.InitializationError;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.util.Log4jConfigurer;

public class MyTestRunner extends SpringJUnit4ClassRunner {
    
    static {
	    try {
	      Log4jConfigurer.initLogging( "classpath:log4j.properties" );
	    }
	    catch( FileNotFoundException ex ) {
	      System.err.println( "Cannot Initialize log4j" );
	    }
	  }

	  public MyTestRunner( Class<?> clazz ) throws InitializationError, org.junit.runners.model.InitializationError {
	    super( clazz );
	  }

}
