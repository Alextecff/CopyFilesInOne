import java.io.*;

public class CopyFilesInOne {
    private File[] files;
    private File outFile;

    public CopyFilesInOne(File[] files, File outFile) {
        this.files = files;
        this.outFile = outFile;
    }

    public void copy(){

        if(outFile.exists()){
            outFile.delete();
        }

        for(int i = 0; i < files.length; i++){
            try(FileInputStream fis = new FileInputStream(files[i]);
                FileOutputStream fos = new FileOutputStream(outFile, true);) {
                byte[] buffer = new byte[1024];
                int r;
                do{
                    r = fis.read(buffer, 0, buffer.length);
                    if(r > 0){
                        fos.write(buffer, 0, r);
                    }
                }while (r > 0);
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
