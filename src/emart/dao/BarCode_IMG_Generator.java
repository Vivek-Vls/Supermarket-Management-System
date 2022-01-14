/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package emart.dao;

import java.awt.image.BufferedImage;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import org.krysalis.barcode4j.impl.code128.Code128Bean;
import org.krysalis.barcode4j.output.bitmap.BitmapCanvasProvider;

/**
 *
 * @author vivek
 */
public class BarCode_IMG_Generator {
    public static void createImage(String image_name,String mystring)
    {
        try
        {
            Code128Bean code128=new Code128Bean();
            code128.setHeight(15f);
            ByteArrayOutputStream baos= new ByteArrayOutputStream();
            BitmapCanvasProvider canvas =new BitmapCanvasProvider(baos,"image/x-png",300,BufferedImage.TYPE_BYTE_BINARY,false,0);
            code128.generateBarcode(canvas, mystring);
            canvas.finish();
            
            String userdir= System.getProperty("user.dir");
            File fp=new File(userdir+"\\Barcode\\");
            fp.mkdir();
            FileOutputStream fos =new FileOutputStream(userdir+"\\Barcode\\"+image_name);
            fos.write(baos.toByteArray());
            fos.flush();
            fos.close();
        }
        catch(Exception ex)
        {
            System.out.println("Exception in barcode generation"+ex.getMessage());
        }
    }
}
