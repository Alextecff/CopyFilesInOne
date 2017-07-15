import java.io.File;
import java.io.FilenameFilter;
import java.io.IOException;

public class Main {
    public static void main(String[] args) {
        File folder = new File(".");
        File[] files = folder.listFiles(new FilenameFilter() {
            @Override
            public boolean accept(File dir, String name) {
                return name.endsWith(".txt");
            }
        });
        File outFile = new File("AllInOne");
        CopyFilesInOne copyTFIO = new CopyFilesInOne(files, outFile);
        copyTFIO.copy();

        for(File f : files){
            try {
                System.out.println(f.getCanonicalPath());
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
