/**
 * 作成日: 2023年9月30日
 * 作成者: 村山航輔
 * 内容:
 * 課題提出用のフォーマットが正しいか検証するプログラム
 */

//各種クラスのインポート
import java.util.ArrayList;
import java.io.File;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.io.FileNotFoundException;
import java.io.FileReader;

public class formatIdentification {
    public static void main(String[] args) {
        String[] tmp;
        File dirPath = new File("dirPath");
        Integer processing = forkingPorint();

        while(!(processing.equals(4))){
            switch(processing){
                case 0:
                    return;
                case 1:
                    // ファイル一覧を表示
                    tmp = outputDirPath(dirPath.getAbsolutePath());
                    for(String file : tmp){
                        System.out.println(file);
                    }
                    break;
                case 2:
                    // 単独ファイルの命名規則を検証
                    tmp = outputFileName(dirPath.getAbsolutePath());
                    switch(tmp.length){
                        case 0:
                            System.out.println("ファイルが存在しません。");
                            break;
                        case 1:
                            try(BufferedReader csvFile = new BufferedReader(new FileReader("./csvFile"))){
                                String[] csvData = (csvFile.readLine()).split(",");
                                for(String data : csvData){
                                    if(tmp[0].equals(data)){
                                        System.out.println("ファイル名が正しいです。");
                                    }else{
                                        System.out.println("ファイルの命名規則にふさわしくない文字が使われています。");
                                    }
                                }
                            }catch(IOException e){
                                System.out.println("csvファイルが存在しません。");
                            };
                            break;
                        default:
                            System.out.println("ファイルが複数存在します。");
                            break;
                    }
                    break;
                case 3:
                    // 全ファイルの書式を検証
                    try(BufferedReader csvFile = new BufferedReader(new FileReader("./csvFile"))){
                        String[] csvDate = (csvFile.readLine()).split(",");
                        ArrayList<String> dirList = new ArrayList<>();
                        ArrayList<String> fileList = new ArrayList<>();

                        dirList.add(dirPath.getAbsolutePath());

                        for(String date : fileList){

                        }

                        }catch(IOException e){
                            System.out.println("csvファイルが存在しません。");
                        };
                    break;
                default:
                    System.out.println(processing);
                    break;
            }
                processing = forkingPorint();
        }
    }

    // OK
    
    /**
     * 絶対パスで渡されたディレクトリーないに存在するファイルの名前を返すメゾット
     * 
     * @param String dirPath
     * @return String型の配列でディレクトリー内のに存在するファイル名を返す
     */

    private static String[] outputdirName(String dirPath) {
        File[] discrimination = new File(dirPath).listFiles();

        // 引数として渡されたディレクトリー内にあるフォルダーのみを識別する。
        ArrayList<String> fileName = new ArrayList<>();
        for (File file : discrimination) {
            if (file.isFile()) {
                fileName.add(file.getName());
            }
        }

        //可変配列に入っているデータを配列に変換
        String returnDate[] = new String[fileName.size()];
        for (int i = 0; i < fileName.size(); i++) {
            returnDate[i] = fileName.get(i);
        }

        return returnDate;

    }

    /**
     * 絶対パスで渡したディレクトリー内に存在するディレクトリーのパスを取得するメソッド <br>
     * ディレクトリー内にディレクトリーが存在しない場合はnullを返す
     * 
     * @param String dirPath
     * @return String型の配列でディレクトリー内のディレクトリーパスを返す
     */

    private static String[] outputDirPath(String Path) {
        File[] discrimination = new File(new File("dirPath").getAbsolutePath()).listFiles();

        ArrayList<String> dirPath = new ArrayList<>();
        for (File file : discrimination) {
            if (file.isDirectory()) {
                dirPath.add(file.getAbsolutePath());
            }
        }

        String returnDate[] = new String[dirPath.size()];
        for (int i = 0; i < dirPath.size(); i++) {
            returnDate[i] = dirPath.get(i);
        }

        return returnDate;

    }

    /**
     * 本プログラムの分岐の項目を表示し、入力された値を返すメソッド
     * 
     * @param String コンソールの入力受付
     * @return Integer 分岐で入力された値
     */

    private static Integer forkingPorint(){

        String behavior = null;
        int returnDate = 0;

        try{
        // モジュールのインスタンスか
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // 選択肢の表示
        System.out.println("1: discriminationファイル内のファイル一覧を表示");
        System.out.println("2: discriminationファイル内の単独ファイルの命名規則を検証する");
        System.out.println("3: discriminationファイル内の全ファイルの書式を検証する。");
        System.out.println("処理を終了させるには exit と入力してください。");
        behavior = br.readLine();

        if (!((behavior).equals("exit"))) {

            // 入力された値によって処理を分岐
            switch (behavior) {
                case "1":
                    System.out.println("ファイル一覧を表示します。");
                    returnDate = 1;
                    break;
                case "2":
                    System.out.println("単独ファイルの命名規則を検証します。");
                    returnDate = 2;
                    break;
                case "3":
                    System.out.println("全ファイルの書式を検証します。");
                    returnDate = 3;
                    break;
                default:
                    returnDate = 4;
                    throw new IOException();
            }

        } else {
            System.out.println("処理を終了します。");
            returnDate = 0;
        }
        }catch(IOException e){
            System.out.println("入力エラーが発生しました。");
            return returnDate;
        }

        return returnDate;

    }
}