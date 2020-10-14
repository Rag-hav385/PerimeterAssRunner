import edu.duke.*;
import java.io.File;
/**
 * Write a description of PerimeterAssignmentRunner here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class PerimeterAssignmentRunner {
    
     public double getPerimeter (Shape s) {
        // Start with totalPerim = 0
        double totalPerim = 0.0;
        // Start wth prevPt = the last point 
        Point prevPt = s.getLastPoint();
        // For each point currPt in the shape,
        for (Point currPt : s.getPoints()) {
            // Find distance from prevPt point to currPt 
            double currDist = prevPt.distance(currPt);
            // Update totalPerim by currDist
            totalPerim = totalPerim + currDist;
            // Update prevPt to be currPt
            prevPt = currPt;
        }
        // totalPerim is the answer
        return totalPerim;
    }

    public int getNumPoints (Shape s) {
        // Put code here
        int num = 0 ;
        
        for (Point i : s.getPoints()){
            num = num + 1;
        }
            
        
        return num;
    }

    public double getAverageLength(Shape s) {
        // Put code here
        double num_points = getNumPoints(s);
        
        double sum = getPerimeter(s);
        
        double avg = sum / num_points;
        
        return avg;
    }

    public double getLargestSide(Shape s) {
        // Put code here
        double longestside = 0.0;
        
        Point prevPt = s.getLastPoint();
        
        for (Point currPt : s.getPoints()) {
             
            double currDist = prevPt.distance(currPt);
            
            if ( currDist > longestside ){
                longestside = currDist;
            }
            
            prevPt = currPt;
        }
        // totalPerim is the answer
        return longestside;
        
    }

    public double getLargestX(Shape s) {
        // Put code here
        return 0.0;
    }

    public double getLargestPerimeterMultipleFiles() {
        // Put code here
        DirectoryResource dr = new DirectoryResource();
        double max = 0;
        for (File f: dr.selectedFiles()){
            FileResource fr = new FileResource(f);
            Shape s = new Shape(fr);
            double perimeter = getPerimeter(s);
            if (max < perimeter){
                max = perimeter;
            }
        }
        
        return max;
    }

    public String getFileWithLargestPerimeter() {
        // Put code here
        DirectoryResource dr = new DirectoryResource();
        File temp = null;
        double maxperimeter = getLargestPerimeterMultipleFiles();
        for (File f : dr.selectedFiles()){
            FileResource fr = new FileResource(f);
            Shape s = new Shape(fr);
            double perimeter = getPerimeter(s);
            if ( perimeter == maxperimeter){
                temp = f;
            }
        }
            // replace this code
        return temp.getName();
    }

    public void testPerimeter () {
        FileResource fr = new FileResource();
        Shape s = new Shape(fr);
        double length = getPerimeter(s);
        System.out.println("perimeter = " + length);
    }
    
    public void testPerimeterMultipleFiles() {
        // Put code here
        double maxperimeter = 0;
        maxperimeter = getLargestPerimeterMultipleFiles();
        System.out.println("Maximum Perimeter : " + maxperimeter);

        
    }

    public void testFileWithLargestPerimeter() {
        // Put code here
        System.out.println("File Name : " + getFileWithLargestPerimeter());
        
        
    }

    // This method creates a triangle that you can use to test your other methods
    public void triangle(){
        Shape triangle = new Shape();
        triangle.addPoint(new Point(0,0));
        triangle.addPoint(new Point(6,0));
        triangle.addPoint(new Point(3,6));
        for (Point p : triangle.getPoints()){
            System.out.println(p);
        }
        double peri = getPerimeter(triangle);
        System.out.println("perimeter = "+peri);
    }

    // This method prints names of all files in a chosen folder that you can use to test your other methods
    public void printFileNames() {
        DirectoryResource dr = new DirectoryResource();
        for (File f : dr.selectedFiles()) {
            System.out.println(f);
        }
    }
    
    public void printlongestside(){
        FileResource fr = new FileResource();
        Shape s = new Shape(fr);
        double longestSide = getLargestSide(s);
        System.out.println("longest Side : " + longestSide);
    }
    
    public void testAvgOfSides(){
        FileResource fr = new FileResource();
        Shape s = new Shape(fr);
        double avg = getAverageLength(s);
        System.out.println("Average Length : " + avg );
    }

    public static void main (String[] args) {
        PerimeterAssignmentRunner pr = new PerimeterAssignmentRunner();
        pr.testPerimeter();
    }
}
