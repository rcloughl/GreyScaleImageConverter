public class Pixel {
    private int red;
    private int green;
    private int blue;

    //constructor for a pixel object
    public Pixel(){
        red=0;
        green=0;
        blue=0;
    }

    //sets the colors of each pixel
    public void setPixel(int r, int g, int b){
        this.red=r;
        this.green=g;
        this.blue=b;
    }

    //finds the average/grey value
    public int getAverage(){
        int average=(this.red+this.green+this.blue)/3;
        return average;
    }
    // sets grey to all three rgb values
    public void setGrey(int grey) {
        this.red = grey;
        this.green = grey;
        this.blue = grey;
    }

    //to make output into the file look cleaner
    public String toString(){
        return this.red+" "+this.green+" "+this.blue+" ";
    }

}
