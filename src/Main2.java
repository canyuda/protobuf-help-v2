import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Main2 {

    private static final String PATTERN = "import \"(.*)\";";
    private static final String TARGET_PROTO_NAME = "target.txt";
    private static final String SOURCE_SUFFIX = ".proto";

    private static String BASE_PARENT_ROOT = "protobuf-sub";

    private static String ABSOLUTE_PATH_FOR_BAT;
    private static String ABSOLUTE_PATH_FOR_PROTO;
    private static String ABSOLUTE_PATH_FOR_OUTER;

    private static final String FILE_SEPARATOR = System.getProperty("file.separator");

    public static void main(String[] args) throws IOException {
        if ((args[0] != null) && (args[0].length() > 0)) {
            BASE_PARENT_ROOT = args[0];
        }
        getAbsolutePath();

        Set<String> in = getTargetFileNames();
        System.out.println("Scanning " + in.size() + " File Paths Begins...");

        Set<String> out = new HashSet<>();
        for (String path : in) {
            File originFile = new File(ABSOLUTE_PATH_FOR_PROTO + path);

            Set<File> tempFileNameSet = new HashSet<>();

            fillTempFileNameSet(tempFileNameSet, originFile);

            out.addAll(getFileNames(tempFileNameSet));
            for (File file : tempFileNameSet) {
                out.addAll(analyseDependence(file));
            }
        }
        System.out.println("Scan Successful... " + out.size() + " File Need Generated...");

        compileSourceFile(out);
    }

    private static void getAbsolutePath() {
        File root = new File(System.getProperty("user.dir"));

        ABSOLUTE_PATH_FOR_PROTO = root.getAbsolutePath() + FILE_SEPARATOR + BASE_PARENT_ROOT + FILE_SEPARATOR;

        File f = new File(ABSOLUTE_PATH_FOR_PROTO);
        if (!f.exists()) {
            throw new RuntimeException("Dir for " + ABSOLUTE_PATH_FOR_PROTO + " not Found..." + "Please Check your Args and Dir...");
        }
        ABSOLUTE_PATH_FOR_BAT = root.getAbsolutePath() + FILE_SEPARATOR;
        ABSOLUTE_PATH_FOR_OUTER = root.getParentFile().getAbsolutePath() + FILE_SEPARATOR + "java" + FILE_SEPARATOR;

        System.out.println("Going to Scan Files under " + ABSOLUTE_PATH_FOR_PROTO);
        System.out.println("Your " + BASE_PARENT_ROOT + " is under " + ABSOLUTE_PATH_FOR_BAT);
        System.out.println("Outer File path is " + ABSOLUTE_PATH_FOR_OUTER);
    }

    private static Set<String> getTargetFileNames() throws IOException {
        Set<String> result = new HashSet<>();

        BufferedReader reader = null;
        try {
            reader = new BufferedReader(new FileReader(new File(ABSOLUTE_PATH_FOR_BAT + TARGET_PROTO_NAME)));
            String tempString;
            while ((tempString = reader.readLine()) != null) {
                if (tempString.length() > 0) {
                    result.add(tempString);
                }
            }
            reader.close();

            return result;
        } finally {
            if (reader != null) {
                try {
                    reader.close();
                } catch (IOException e1) {
                }
            }
        }
    }

    private static void fillTempFileNameSet(Set<File> tempSet, File file) {
        if (file.isFile()) {
            if (file.getName().endsWith(SOURCE_SUFFIX)) {
                tempSet.add(file);
            }
        } else {
            File[] files = file.listFiles();
            if (files != null) {
                for (File subFile : files) {
                    fillTempFileNameSet(tempSet, subFile);
                }
            }
        }
    }

    private static Set<String> getFileNames(Set<File> files) {
        Set<String> result = new HashSet<>();
        if (files != null) {
            for (File file : files) {
                result.add(getAbstractNameFromPath(file.getPath().replace('\\', '/')));
            }
        }
        return result;
    }

    private static String getAbstractNameFromPath(String path) {
        String[] array = path.split('/' + BASE_PARENT_ROOT + '/');
        return array[(array.length - 1)];
    }

    private static Set<String> analyseDependence(File file) throws IOException {
        Set<String> result = new HashSet<>();
        Pattern pattern = Pattern.compile(PATTERN);

        Boolean started = Boolean.FALSE;
        BufferedReader reader = null;
        try {
            reader = new BufferedReader(new FileReader(file));
            String tempString;
            while ((tempString = reader.readLine()) != null) {
                if (tempString.length() != 0) {
                    Matcher matcher = pattern.matcher(tempString.trim());
                    if (started) {
                        if (!matcher.find()) {
                            break;
                        }
                        if (result.add(matcher.group(1))) {
                            result.addAll(analyseDependence(new File(ABSOLUTE_PATH_FOR_PROTO + matcher.group(1))));
                        }
                    } else if (matcher.find()) {
                        if (result.add(matcher.group(1))) {
                            result.addAll(analyseDependence(new File(ABSOLUTE_PATH_FOR_PROTO + matcher.group(1))));
                        }
                        started = Boolean.TRUE;
                    }
                }
            }
            reader.close();

            return result;
        } finally {
            if (reader != null) {
                try {
                    reader.close();
                } catch (IOException ignored) {
                }
            }
        }
    }

    private static void compileSourceFile(Set<String> out) {
        for (String shortName : out) {
            try {
                Process ps = Runtime.getRuntime().exec(ABSOLUTE_PATH_FOR_PROTO + "protoc " + ABSOLUTE_PATH_FOR_PROTO + shortName + " --java_out=" + ABSOLUTE_PATH_FOR_OUTER + " --proto_path=" + ABSOLUTE_PATH_FOR_PROTO);

                InputStream in = ps.getErrorStream();
                BufferedReader tBufferedReader = new BufferedReader(new InputStreamReader(in));
                String sTempOneLine;
                while ((sTempOneLine = tBufferedReader.readLine()) != null) {
                    System.out.println(sTempOneLine + "\r\n");
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        System.out.println("Compile complete for All...");
    }
}

