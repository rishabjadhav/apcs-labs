import java.awt.Color;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.Random;

import javax.imageio.ImageIO;
import javax.swing.JFileChooser;
import javax.swing.UIManager;

/**
 * A class that represents a picture made up of a rectangle of {@link Pixel}s
 */
public class Picture {

    /** The 2D array of pixels that comprise this picture */
	private Pixel[][] pixels;

    /**
     * Creates a Picture from an image file in the "images" directory
     * @param picture The name of the file to load
     */
    public Picture(String picture) {
        File file = new File("./images/"+picture);
        BufferedImage image;
        if (!file.exists()) throw new RuntimeException("No picture at the location "+file.getPath()+"!");
        try {
            image = ImageIO.read(file);
        } catch (IOException e) {
            throw new RuntimeException(e.getMessage());
        }
        pixels = new Pixel[image.getHeight()][image.getWidth()];
        for (int y = 0; y<pixels.length; y++) {
            for (int x = 0; x<pixels[y].length; x++) {
                int rgb = image.getRGB(x, y);
                /*
                 * For the curious - BufferedImage saves an image's RGB info into a hexadecimal integer
                 * The below extracts the individual values using bit-shifting and bit-wise ANDing with all 1's
                 */
                pixels[y][x] = new Pixel((rgb>>16)&0xff, (rgb>>8)&0xff, rgb&0xff);
            }
        }
    }

    /**
     * Creates a solid-color Picture of a given color, width, and height
     * @param red The red value of the color
     * @param green The green value of the color
     * @param blue The blue value of the color
     * @param height The height of the Picture
     * @param width The width of the Picture
     */
    public Picture(int red, int green, int blue, int height, int width) {
        pixels = new Pixel[height][width];
        for (int y = 0; y<pixels.length; y++) {
            for (int x = 0; x<pixels[y].length; x++) {
                pixels[y][x] = new Pixel(red, green, blue);
            }
        }
    }

    /**
     * Creates a solid white Picture of a given width and height
     * @param color The {@link Color} of the Picture
     * @param height The height of the Picture
     * @param width The width of the Picture
     */
    public Picture(int height, int width) {
        this(Color.WHITE, height, width);
    }

    /**
     * Creates a solid-color Picture of a given color, width, and height
     * @param color The {@link Color} of the Picture
     * @param width The width of the Picture
     * @param height The height of the Picture
     */
    public Picture(Color color, int height, int width) {
        this(color.getRed(), color.getGreen(), color.getBlue(), height, width);
    }

    /**
     * Creates a Picture based off of an existing {@link Pixel} 2D array
     * @param pixels A rectangular 2D array of {@link Pixel}s. Must be at least 1x1
     */
    public Picture(Pixel[][] pixels) {
        if (pixels.length==0 || pixels[0].length==0) throw new RuntimeException("Can't have an empty image!");
        int width = pixels[0].length;
        for (int i = 0; i<pixels.length; i++) if (pixels[i].length!=width)
            throw new RuntimeException("Pictures must be rectangles. pixels[0].length!=pixels["+i+"].length!");
        this.pixels = new Pixel[pixels.length][width];
        for (int i = 0; i<pixels.length; i++) {
            for (int j = 0; j<pixels[i].length; j++) {
                this.pixels[i][j] = new Pixel(pixels[i][j].getColor());
            }
        }
    }

    /**
     * Creates a Picture based off of an existing Picture
     * @param picture The Picture to copy
     */
    public Picture(Picture picture) {
        this(picture.pixels);
    }

    /**
     * Gets the width of the Picture
     * @return The width of the Picture
     */
    public int getWidth() {
        return pixels[0].length;
    }

    /**
     * Gets the height of the Picture
     * @return The height of the Picture
     */
    public int getHeight() {
        return pixels.length;
    }

    /**
     * Gets the {@link Pixel} at a given coordinate
     * @param x The x location of the {@link Pixel}
     * @param y The y location of the {@link Pixel}
     * @return The {@link Pixel} at the given location
     */
    public Pixel getPixel(int x, int y) {
        if (x>=getWidth() || y>=getHeight() || x<0 || y<0) throw new RuntimeException("No pixel at ("+x+", "+y+")");
        return pixels[y][x];
    }

    /**
     * Sets the {@link Pixel} at a given coordinate
     * @param x The x location of the {@link Pixel}
     * @param y The y location of the {@link Pixel}
     * @param pixel The new {@link Pixel}
     */
    public void setPixel(int x, int y, Pixel pixel) {
        if (x>=getWidth() || y>=getHeight() || x<0 || y<0) throw new RuntimeException("No pixel at ("+x+", "+y+")");
        if (pixel==null) throw new NullPointerException("Pixel is null"); //guard is required because pixel's value isn't used in this method
        pixels[y][x] = pixel;
    }

    /**
     * Opens a {@link PictureViewer} to view this Picture
     * @return the {@link PictureViewer} viewing the Picture
     */
    public PictureViewer view() {
        return new PictureViewer(this);
    }

	/**
	 * Save the image on disk as a JPEG
	 * Call programmatically on a Picture object, it will prompt you to choose a save location
	 * In the save dialogue window, specify the file AND extension (e.g. "lilies.jpg")
	 * Extension must be .jpg as ImageIO is expecting to write a jpeg
	 */
	public void save()
	{
		try {
	        UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
	    } 
		catch(Exception e) {
	        e.printStackTrace();
	    }
		
		BufferedImage image = new BufferedImage(this.pixels[0].length, this.pixels.length, BufferedImage.TYPE_INT_RGB);

		for (int r = 0; r < this.pixels.length; r++)
			for (int c = 0; c < this.pixels[0].length; c++)
				image.setRGB(c, r, this.pixels[r][c].getColor().getRGB());

		//user's Desktop will be default directory location
		JFileChooser chooser = new JFileChooser(System.getProperty("user.home") + "/Desktop");

		chooser.setDialogTitle("Select picture save location / file name");

		File file = null;

		int choice = chooser.showSaveDialog(null);

		if (choice == JFileChooser.APPROVE_OPTION)
			file = chooser.getSelectedFile();

		//append extension if user didn't read save instructions
		if (!file.getName().endsWith(".jpg") && !file.getName().endsWith(".JPG") && !file.getName().endsWith(".jpeg") && !file.getName().endsWith(".JPEG"))
			file = new File(file.getAbsolutePath() + ".jpg");
		
		try {
			ImageIO.write(image, "jpg", file);
			System.out.println("File created at " + file.getAbsolutePath());
		}
		catch (IOException e) {
			System.out.println("Can't write to location: " + file.toString());
		}
		catch (NullPointerException|IllegalArgumentException e) {
			System.out.println("Invalid directory choice");
		}
	}


    /********************************************************
     *************** STUDENT METHODS BELOW ******************
     ********************************************************/

    /** remove all blue tint from a picture */
    public void zeroBlue()
    {
    	for (int i = 0; i < pixels.length; i++) {
         for (int j = 0; j < pixels[i].length; j++) {
            pixels[i][j].setBlue(0);
         }
      }
    }
    
    /** remove all blue tint from a picture */
    public void makeItBlack()
    {
    	for (int i = 0; i < pixels.length; i++) {
         for (int j = 0; j < pixels[i].length; j++) {
            pixels[i][j].setRed(0);
            pixels[i][j].setBlue(0);
            pixels[i][j].setGreen(0);
            
         }
      }
    }

    /** remove everything BUT blue tint from a picture */
    public void keepOnlyBlue()
    {
    	for (int i = 0; i < pixels.length; i++) {
            for (int j = 0; j < pixels[i].length; j++) {
               pixels[i][j].setRed(0);
               pixels[i][j].setGreen(0);
               
            }
         }
    }

    /** invert a picture's colors */
    public void negate()
    {
    	for (int i = 0; i < pixels.length; i++) {
            for (int j = 0; j < pixels[i].length; j++) {
               pixels[i][j].setRed(255-pixels[i][j].getRed());
               pixels[i][j].setBlue(255-pixels[i][j].getBlue());
               pixels[i][j].setGreen(255-pixels[i][j].getGreen());
               
            }
         }
    }

    /** simulate the over-exposure of a picture in film processing */
    public void solarize(int threshold)
    {
    	for (int i = 0; i < pixels.length; i++) {
            for (int j = 0; j < pixels[i].length; j++) {
            	
            	if(pixels[i][j].getRed() < threshold) {
            		pixels[i][j].setRed(255-pixels[i][j].getRed());
            	}
               
            	if(pixels[i][j].getBlue() < threshold) {
                    pixels[i][j].setBlue(255-pixels[i][j].getBlue());
            	}
            	
                if(pixels[i][j].getGreen() < threshold) {
                    pixels[i][j].setGreen(255-pixels[i][j].getGreen());
                }
            }
         }
               
     }
  

    /** convert an image to grayscale */
    public void grayscale()
    {
    	for (int i = 0; i < pixels.length; i++) {
            for (int j = 0; j < pixels[i].length; j++) {
            	int sum = pixels[i][j].getRed() + pixels[i][j].getBlue() + pixels[i][j].getGreen();
            	int average = sum/3;
            
               pixels[i][j].setRed(average);
               pixels[i][j].setBlue(average);
               pixels[i][j].setGreen(average);
            }
         }
    }

	/** change the tint of the picture by the supplied coefficients */
	public void tint(double red, double blue, double green)
	{
    	for (int i = 0; i < pixels.length; i++) {
            for (int j = 0; j < pixels[i].length; j++) {
            	double dRed = pixels[i][j].getRed() * red;
            	int iRed = (int) dRed;
            	if (iRed > 255) {
            		iRed = 255;
            	}
            	
            	double dBlue = pixels[i][j].getBlue() * blue;
            	int iBlue = (int) dBlue;
            	if (iBlue > 255) {
            		iBlue = 255;
            	}
            	
            	double dGreen = pixels[i][j].getGreen() * green;
            	int iGreen = (int) dGreen;
            	if (iGreen > 255) {
            		iGreen = 255;
            	}
            	
               pixels[i][j].setRed(iRed);
               pixels[i][j].setBlue(iBlue);
               pixels[i][j].setGreen(iGreen);
               
            }
    	}
	}
	
	/** reduces the number of colors in an image to create a "graphic poster" effect */
	public void posterize(int span)
	{
		for (int r = 0; r < pixels.length; r++) 
        {
            for (int c = 0; c < pixels[r].length; c++) 
            {
            	Pixel p = null;
            	p = pixels[r][c];
            	int redPosterize = Math.abs(p.getRed() / span) * span;
        		int greenPosterize = Math.abs(p.getGreen() / span) * span;
        		int bluePosterize = Math.abs(p.getBlue() / span) * span;

        		p.setColor(redPosterize, greenPosterize, bluePosterize);
            }
		
        }
		
	}

    /** mirror an image about a vertical midline, left to right */
    public void mirrorVertical()
    {
		Pixel leftPixel  = null;
		Pixel rightPixel = null;

		int width = pixels[0].length;
		

		for (int r = 0; r < pixels.length; r++)
		{
			for (int c = 0; c < width / 2; c++)
			{
				leftPixel  = pixels[r][c];
				rightPixel = pixels[r][(width - 1) - c];

				rightPixel.setColor(leftPixel.getColor());
			}
		}
    }

    /** mirror about a vertical midline, right to left */
    //use different logic
    public void mirrorRightToLeft()
    {
    	Pixel leftPixel  = null;
		Pixel rightPixel = null;

		int width = pixels[0].length;
		

		for (int r = 0; r < pixels.length; r++)
		{
			for (int c = width - 1; c > width / 2; c--)
			{
				rightPixel = pixels[r][c];
				leftPixel = pixels[r][(width - 1) - c];

				leftPixel.setColor(rightPixel.getColor());
			}
		}
    }

    /** mirror about a horizontal midline, top to bottom */
    //same as vertical but change the values
    public void mirrorHorizontal()
    {
    	Pixel topPixel  = null;
		Pixel bottomPixel = null;
		
		int length = pixels.length;
		
		for (int r = 0; r < length / 2; r++)
		{
			for (int c = 0; c < pixels[r].length; c++)
			{
				topPixel = pixels[r][c];
				bottomPixel = pixels[(length - 1) - r][c];

				bottomPixel.setColor(topPixel.getColor());
			}
		}

    }

    /** flip an image upside down about its bottom edge */
    //replace horizontal flips and change the values
    public void verticalFlip()
    {
    	int length = pixels.length;
		int width = pixels[0].length;
		Pixel temp[][] = new Pixel[length][width];
		
		for (int r = 0; r < length; r++)
		{
			for (int c = 0; c < width; c++)
			{
				temp[(length - 1) - r][c] = pixels[r][c];
			}
		}
		pixels = temp;
    }

    /** fix roof on Greek temple */
    //just use the previous method
    public void fixRoof()
    {
        Pixel leftPixel  = null;
        Pixel rightPixel = null;

        int width = pixels[0].length;

        for (int r = 0; r < pixels.length/4; r++)
        {
            for (int c = 0; c < width / 2; c++)
            {
                leftPixel  = pixels[r][c];
                rightPixel = pixels[r][(width - 1) - c];

                rightPixel.setColor(leftPixel.getColor());
            }
        }
    }

    /** detect and mark edges in an image */
    public void edgeDetection(int dist)
    {
        Pixel p = null;
        int x = 0; 
        int y = 0; 
        for (int i = 0; i < pixels.length; i++) 
        {
            for (int j = 0; j < pixels[i].length; j++) 
            {
                p = pixels[i][j];

                if (i < pixels.length - 1)
                {
                    x = i + 1;
                }
                if (j < pixels[i].length - 1)
                {
                    y = j + 1;
                }

                Color newColor = new Color(255, 255, 255);;
                
                //BOTTOM
                int red = pixels[x][j].getRed();
                int green = pixels[x][j].getGreen();
                int blue = pixels[x][j].getBlue();
                Color bottomColor = new Color(red, green, blue);
                if ((int)(p.colorDistance(bottomColor)) > dist)
                {
                	newColor = new Color(0, 0, 0);

                }

                //RIGHT
                red = pixels[i][y].getRed();
                green = pixels[i][y].getGreen();
                blue = pixels[i][y].getBlue();
                Color rightColor = new Color(red, green, blue);
                if ((int)(p.colorDistance(rightColor)) > dist)
                {

                	newColor = new Color(0, 0, 0);

                }
                p.setColor(newColor);
            }
        }

    }

    /** copy another picture's pixels into this picture, if a color is within dist of param Color */
    public void chromakey(Picture other, Color color, int dist)
    {
        Pixel p = null; 
        for (int x = 0; x < pixels.length; x++) 
        {
            for (int y = 0; y < pixels[x].length; y++) 
            {
                p = pixels[x][y];

                if ((int)(p.colorDistance(color)) < dist)
                {
                    pixels[x][y]=other.pixels[x][y];
                }

            }
        }

    }

    /** steganography encode (hide the message in msg in this picture) */
    public void encode(Picture msg)
    {
    	for (int r = 0; r < this.pixels.length; r++)
        {
            for (int c = 0; c < pixels[r].length; c++)
            {
                if (pixels[r][c].getRed() % 2 != 0)
                {
                	pixels[r][c].setRed(pixels[r][c].getRed() - 1);
                }
         
            }
        }
    	
    	for (int r = 0; r < pixels.length; r++)
        {
            for (int c = 0; c < pixels[r].length; c++)
            {
            	Pixel msgPixel = msg.getPixel(c, r);
            	if ((int)(msgPixel.colorDistance(Color.BLACK)) < 50)
            	{
            		pixels[r][c].setRed(pixels[r][c].getRed() + 1);
            	}
            }
        }
    }
        

    /** steganography decode (return a new Picture containing the message hidden in this picture) */
    public Picture decode()
    {        

        Pixel msg1 = null;
        for (int i = 0; i < pixels.length; i++)
        {
            for (int r = 0; r < pixels[i].length;r++)
            {
                msg1 = pixels[i][r];
                int red = pixels[i][r].getRed();
                int green = pixels[i][r].getGreen();
                int blue = pixels[i][r].getBlue();
                if (red % 2 != 0 )
                {
                    red = 0;
                    green = 0;
                    blue = 0;
                }
                else
                {
                    red = 255;
                    blue = 255;
                    green = 255;
                }
                Color c = new Color(red,green,blue);
                msg1.setColor(c);

            }
        }

        Picture msg= new Picture(pixels);
        return msg;
    }

    /** perform a simple blur using the colors of neighboring pixels */
    //done by averaging color value for surrounding pixels
    //take RGB values for right, top, bottom, and left pixels
    //define, assign, average, set
    public Picture simpleBlur()
    {
        Pixel p = null;

        int red, redRight, redLeft, redBottom, redTop, redAvg;
        int green, greenRight, greenTop, greenBottom, greenLeft, greenAvg;
        int blue, blueRight, blueTop, blueBottom, blueLeft, blueAvg;
       
        for (int r = 0; r < pixels.length; r++)
        {
            for (int c = 0; c < pixels[r].length; c++)
            {
                redBottom = 0;
                greenBottom = 0;
                blueBottom = 0;
                
                redRight = 0;
                greenRight = 0;
                blueRight = 0;
                
                redLeft = 0;
                greenLeft = 0;
                blueLeft = 0;
                
                redTop = 0;
                greenTop = 0;
                blueTop = 0;
                
                //TOP
                if (r > 0 && r < pixels.length - 1)
                {
                    redTop = pixels[r + 1][c].getRed();
                    greenTop = pixels[r + 1][c].getGreen();
                    blueTop = pixels[r + 1][c].getBlue();
                }
                
                //BOTTOM
                if (r < pixels.length - 1 && r > 0)
                {
                    redBottom = pixels[r - 1][c].getRed();
                    greenBottom = pixels[r - 1][c].getGreen();
                    blueBottom = pixels[r - 1][c].getBlue();
                }
               
                //RIGHT
                if (c < pixels[r].length - 1 && c > 0)
                { 
                    redRight = pixels[r][c + 1].getRed();
                    greenRight = pixels[r][c + 1].getGreen();
                    blueRight = pixels[r][c + 1].getBlue();
                }
                
                //LEFT
                if (c > 0 && c < pixels[r].length - 1)
                { 
                    redLeft = pixels[r][c - 1].getRed();
                    greenLeft = pixels[r][c - 1].getGreen();
                    blueLeft = pixels[r][c - 1].getBlue();
                }
                
                red = pixels[r][c].getRed();
                green = pixels[r][c].getGreen();
                blue = pixels[r][c].getBlue();
                redAvg = (red + redRight + redTop + redBottom + redLeft) / 5;
                greenAvg = (green + greenRight + greenTop + greenBottom + greenLeft) / 5;
                blueAvg = (blue + blueRight + blueTop + blueBottom + blueLeft) / 5;
                
                Color e = new Color(redAvg, greenAvg, blueAvg);
                p = pixels[r][c];
                p.setColor(e);

            }
        }
        Picture msg = new Picture(pixels);

        return msg;
    }

    /** perform a blur using the colors of pixels within radius of current pixel */
    public Picture blur(int radius)
    {
    	
    	for (int r = 0; r < pixels.length; r++)
        {
            for (int c = 0; c < pixels[r].length; c++)
            {
		    	int red = 0, green = 0, blue = 0;
		    	int i = 0;
		    	
		    	for(int r1 = r - radius; r1 <= r + radius; r1++)
		    	{
		    		for(int c1 = c - radius; c1 <= c + radius; c1++)
		    		{
		    			if(r1 < 0 || c1 < 0 || r1 > pixels.length - 1 || c1 > pixels[r].length - 1)
		    			{
		    				continue;
		    			}
		    			
		    			i++;
		    			red += pixels[r1][c1].getRed();
		    			green += pixels[r1][c1].getGreen();
		    			blue += pixels[r1][c1].getBlue();
		    		}
		    	}
		    	
		    	int redAvg = red / i;
		    	int greenAvg = green / i;
		    	int blueAvg = blue / i;
		    	Color e = new Color(redAvg, greenAvg, blueAvg);
		    	pixels[r][c].setColor(e);
            }
        }
    	
    	Picture msg = new Picture(pixels);

        return msg;
    }
    
    	
    public Picture glassFilter(int dist)
    {
    	for (int r = 0; r < pixels.length; r++)
        {
            for (int c = 0; c < pixels[r].length; c++)
            {
            	
            	int rRand = this.Random(r - dist, r + dist);
            	int cRand = this.Random(c - dist, c + dist);
            	
            	
            	if(rRand < 0) {rRand = 0;}
            	if (rRand >= pixels.length) {rRand = pixels.length - 1;}
            	
            	if(cRand < 0) {cRand = 0;}
            	if (cRand >= pixels[r].length) {cRand = pixels[r].length - 1;}
            	
            	pixels[r][c].setColor(pixels[rRand][cRand].getColor());
            }
            
        }
    		Picture msg = new Picture(pixels);
    		return msg;
    }
    
    public int Random(int low, int high)
    {
    	Random r = new Random();
    	int result = r.nextInt(high - low) + low;
    	
    	return result;
    }
}