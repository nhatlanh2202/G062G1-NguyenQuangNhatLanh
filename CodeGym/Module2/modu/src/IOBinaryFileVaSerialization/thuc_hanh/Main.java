package IOBinaryFileVaSerialization.thuc_hanh;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.StandardCopyOption;
import java.util.Scanner;

public class Main {
    private static void copyFileUsingJava7Files(File source, File dest) throws IOException {
        Files.copy(source.toPath(), dest.toPath(), StandardCopyOption.REPLACE_EXISTING);
    }

    private static void copyFileUsingStream(File source, File dest) throws IOException {
        InputStream in = null;
        OutputStream out = null;
        try {
            in = new FileInputStream(source);
            out = new FileOutputStream(dest);
            byte[] buffer = new byte[1024];
            int length;
            while ((length = in.read(buffer)) > 0){
                out.write(buffer,0,length);
            }
        }finally {
            in.close();
            out.close();
        }
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.println("Enter source file: ");
        // "D:\\C062G1-NguyenQuangNhatLanh\\src\\IOBinaryFileVaSerialization\\thuc_hanh\\source"
        String sourcePath = in.nextLine();

        System.out.println("Enter destination file: ");
        // "D:\\C062G1-NguyenQuangNhatLanh\\src\\IOBinaryFileVaSerialization\\thuc_hanh\\dest"

        String desPath = in.nextLine();


        File sourceFile = new File(sourcePath);
        File desFile = new File(desPath);

        try {
            copyFileUsingJava7Files(sourceFile,desFile);
            System.out.println("Copy completed");
        } catch (IOException e) {
            e.printStackTrace();
            System.out.println("Can't copy that file");
            System.out.println(e.getMessage());
        }
    }
}
