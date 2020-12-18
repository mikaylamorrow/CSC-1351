/*
Student Name: Mikayla Morrow
*/
package filesproject;
import java.util.Scanner;
import java.io.PrintWriter;
import java.io.FileNotFoundException;
import java.util.Random;
import java.io.File;

public class FilesProject {

    // This method gets input from user
    public static void main(String[] args) throws FileNotFoundException 
    {
        System.out.println("Please enter the number of files");
        Scanner in = new Scanner(System.in);
        int numFiles = in.nextInt();
         
        System.out.println("Please enter the file size");
        int sizefile = in.nextInt();
        populatefiles (numFiles, sizefile);
        calculateStat(numFiles, sizefile);
    }
    // This method generates the number of files
    public static void populatefiles(int n, int s) throws FileNotFoundException {    
        for (int i = 0; i<n; i++)
        {
            PrintWriter outfile = new PrintWriter("number_" + i + ".txt");
            Random rand = new Random();
            for (int j=0; j<5; j++)
            {
            outfile.println(rand.nextInt(9)+1);
            }
            outfile.close();
        }  
    }
    // This method generates the number of stats and gets the average
    public static void calculateStat(int n, int s) throws FileNotFoundException {
        
        PrintWriter outfile = new PrintWriter("Stats.txt");
        
        for (int i=0; i<n; i++)
        {
            Scanner in = new Scanner (new File("number_" + i + ".txt"));
            
            int sum = 0;
            while (in.hasNextInt()) {
            sum += in.nextInt();
            }
            
            
            float average = sum/s;
            
            outfile.printf("%s\t%d\t%.3f%n", "number_" +i+ ".txt", sum, average);
            
            }
        
        outfile.close();
    }
    
}
