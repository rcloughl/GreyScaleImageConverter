public class Picture {

    private String identifier;
    private int width;
    private int height;
    private int maxColor;
    private Pixel[][] photo;

    //Set dimensions for the pic with other info
    public Picture(String identifier, int width, int height, int maxColor){
        this.identifier=identifier;
        this.width=width;
        this.height=height;
        this.maxColor=maxColor;
        this.photo=new Pixel[height][width];
    }

    //getters
    public int getHeight(){
        return this.height;
    }
    public int getWidth(){
        return this.width;
    }
    public String getIdentifier(){
        return this.identifier;
    }
    public int getMaxColor(){
        return this.maxColor;
    }
    public Pixel getPixel(int height, int width){
        return this.photo[height][width];
    }

    //setter
    public void setPixels(Pixel pix, int height, int width){
        this.photo[height][width]=pix;
    }

}
