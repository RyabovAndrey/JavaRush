package com.javarush.task.task16.task1631;

import com.javarush.task.task16.task1631.common.*;


public class ImageReaderFactory {
    public static ImageReader getImageReader(ImageTypes it) {
        ImageReader s = new BmpReader();
        if (it==ImageTypes.JPG || it==ImageTypes.BMP || it==ImageTypes.PNG) {
            if(it==ImageTypes.JPG) s=new JpgReader();
            if(it==ImageTypes.PNG) s=new PngReader();
        }
        else {
            throw new IllegalArgumentException("Неизвестный тип картинки");
        }
        return s;
    }
}
