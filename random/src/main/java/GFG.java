// Java Program to Demonstrate Type Annotation

// Importing required classes
import java.lang.annotation.ElementType;
import java.lang.annotation.Target;

// Using target annotation to annotate a type
@Target(ElementType.TYPE_USE)

// Declaring a simple type annotation
@interface TypeAnnoDemo{

}

// Main class
public class GFG {

    // Main driver method
    public static void main(String[] args) {

        // Annotating the type of string
        @TypeAnnoDemo String string = "I am annotated with a type annotation";
        System.out.println(string);
        abc();
    }

    // Annotating return type of function
    static @TypeAnnoDemo int abc() {

        System.out.println("This function's return type is annotated");

        return 0;
    }
}
