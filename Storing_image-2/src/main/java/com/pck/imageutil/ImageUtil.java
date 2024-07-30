package com.pck.imageutil;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.util.Base64;

public class ImageUtil 
{
	public static String encodeImageToBase64(File image) throws IOException {
        byte[] fileContent = Files.readAllBytes(image.toPath());
        return Base64.getEncoder().encodeToString(fileContent);
    }

    public static byte[] decodeBase64ToImage(String base64Image) {
        return Base64.getDecoder().decode(base64Image);
    }

}
