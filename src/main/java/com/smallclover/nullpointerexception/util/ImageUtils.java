package com.smallclover.nullpointerexception.util;

import com.drew.imaging.ImageMetadataReader;
import com.drew.imaging.ImageProcessingException;
import com.drew.metadata.Directory;
import com.drew.metadata.Metadata;
import com.drew.metadata.Tag;
import com.smallclover.nullpointerexception.model.Journey;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;


/**
 * @author Amadeus
 * @date 2020-02-01
 */
public class ImageUtils {

    public static void main(String[] args) throws ImageProcessingException, IOException {
        File jpegFile = new File("E:/upload/img/journey_test.jpg");
        Metadata metadata = ImageMetadataReader.readMetadata(jpegFile);
        for (Directory directory: metadata.getDirectories()){
            for (Tag tag:directory.getTags()){
                //格式化输出[directory.getName()] - tag.getTagName() = tag.getDescription()
                System.out.format("[%s] - %s = %s\n",
                        directory.getName(), tag.getTagName(), tag.getDescription());
            }
            if (directory.hasErrors()) {
                for (String error : directory.getErrors()) {
                    System.err.format("ERROR: %s", error);
                }
            }
        }
        // 抹除所有信息以防泄露
        BufferedImage image = ImageIO.read(jpegFile);
        ImageIO.write(image,"png",new File("E:/upload/img/journey_test_tmp.png"));
    }

    public static Journey getImageMetaData(String imageName){
        return null;
    }
}
