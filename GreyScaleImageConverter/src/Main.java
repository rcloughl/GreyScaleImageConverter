import java.io.*;
import java.util.Scanner;
public class Main {
    public static void main(String[] args){
        // collect file name and scans it in
        String marker;
        int width;
        int height;
        int maxColor;
        Picture pic = null;
        try {
            //collects first input of filename given
            FileInputStream file = new FileInputStream((args[0]+".ppm"));
            Scanner in = new Scanner(file);
            //takes the first 3 lines of the file as that information is unique from the pixels
            if (in.hasNextLine()) {
                marker = in.next();
                width = Integer.parseInt(in.next());
                height = Integer.parseInt(in.next());
                maxColor = Integer.parseInt(in.next());
                //declaring a new picture object
                pic = new Picture(marker, width, height, maxColor);
                in.nextLine();
            }
            //takes every rgb value and attributes it to a pixel object and each pixel object to a spot on the 2d array in the picture object
            for (int h = 0; h < pic.getHeight(); h++) {
                for (int w = 0; w < pic.getWidth(); w++){
                    Pixel p = new Pixel();
                    int r = Integer.parseInt(in.next());
                    int g = Integer.parseInt(in.next());
                    int b = Integer.parseInt(in.next());
                    p.setPixel(r,g,b);
                    pic.setPixels(p,h,w);
                }
            }

            //finds the greyscale.ppm file and inputs the picture identifiers into it
            PrintWriter output = new PrintWriter("greyscale.ppm");
            output.println(pic.getIdentifier());
            output.println(pic.getHeight() + " " + pic.getWidth());
            output.println(pic.getMaxColor());
            //converts each pixel object in picture to greyscale and then writes the new pixel object into the greyscale.ppm
            for (int h = 0; h < pic.getHeight(); h++) {
                for (int w = 0; w < pic.getWidth(); w++){
                    Pixel p=pic.getPixel(h,w);
                    p.setGrey(p.getAverage());
                    pic.setPixels(p,h,w);
                    output.print(p);
                }
            }
            output.close();
            in.close();



        }
        catch (FileNotFoundException e) {
            System.out.println("File "+ args[0]+".ppm could not be found");
        }

    }
}
