package IOTextFile.bai_tap.CopyFileText;

import java.io.*;

public class CopyFileText {
    public static void main(String[] args) throws IOException {
        InputStream inStream = null;
        OutputStream outStream = null;

        try {
            inStream = new FileInputStream(new File("D:\\C062G1-Nguyen_Quang_Nhat_Lanh\\CodeGym\\Module2\\modu\\src\\IOTextFile\\bai_tap\\CopyFileText\\file1"));
            outStream = new FileOutputStream(new File("D:\\C062G1-Nguyen_Quang_Nhat_Lanh\\CodeGym\\Module2\\modu\\src\\IOTextFile\\bai_tap\\CopyFileText\\file2"));

            int lenght;
            while ((lenght = inStream.read()) > 0){
                outStream.write(lenght);
            }
            System.out.println("File đã được sao chép thành công!");
        } catch (FileNotFoundException e) {
                e.printStackTrace();
        }finally {
            inStream.close();
            outStream.close();
        }
    }
}
