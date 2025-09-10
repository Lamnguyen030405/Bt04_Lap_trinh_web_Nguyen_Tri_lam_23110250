package vn.iotstar.utils;

import java.io.File;
import java.io.IOException;

import jakarta.servlet.http.Part;

public class UploadUtils {

    public static String processUploadFile(Part part, String uploadDir) throws IOException {
        if (part == null || part.getSize() == 0) return null;

        String fileName = System.currentTimeMillis() + "_" + extractFileName(part);
        File dir = new File(uploadDir);
        if (!dir.exists()) dir.mkdirs();

        part.write(uploadDir + File.separator + fileName);

        return new File(uploadDir).getName() + "/" + fileName;
    }

    private static String extractFileName(Part part) {
        String contentDisp = part.getHeader("content-disposition");
        for (String token : contentDisp.split(";")) {
            if (token.trim().startsWith("filename")) {
                return token.substring(token.indexOf("=") + 2, token.length() - 1).replace("\\", "/");
            }
        }
        return null;
    }
}
