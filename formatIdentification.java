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

public class formatIdentification {
    public static void main(String[] args) {

    }

    /**
     * 絶対パスで渡されたディレクトリーないに存在するファイルの名前を返すメゾット
     * 
     * @param String dirPath
     * @return String型の配列でディレクトリー内のに存在するファイル名を返す
     */

    private static String[] outputFileName(String dirPath) {
        File[] discrimination = new File(new File("dirPath").getAbsolutePath()).listFiles();

        ArrayList<String> fileName = new ArrayList<>();

        for (File file : discrimination) {
            if (file.isFile()) {
                fileName.add(file.getName());
            }
        }

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

    private static Integer forkingPorint() {
        try {
            // モジュールのインスタンスか
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            Integer behavior = null;

            // 選択肢の表示
            System.out.println("1:¥t discriminationファイル内のファイル一覧を表示");
            System.out.println("3:¥t discriminationファイル内の全ファイルの書式を検証する。");
            System.out.println("2:¥t discriminationファイル内の単独ファイルの命名規則を検証する");
            System.out.println("処理を終了させるには exit と入力してください。");
            
            while (!(behavior.equals("exit"))) {

                // 入力された値によって処理を分岐
                switch (behavior) {
                    case 1:
                        System.out.println("ファイル一覧を表示します。");
                        break;
                    case 2:
                        System.out.println("単独ファイルの命名規則を検証します。");
                        break;
                    case 3:
                        System.out.println("全ファイルの書式を検証します。");
                        break;
                    default:
                        System.out.println("入力された値が不正です。");
                        break;
                }

                // 選択肢の表示
                System.out.println("1:¥t discriminationファイル内のファイル一覧を表示");
                System.out.println("3:¥t discriminationファイル内の全ファイルの書式を検証する。");
                System.out.println("2:¥t discriminationファイル内の単独ファイルの命名規則を検証する");
                System.out.println("処理を終了させるには exit と入力してください。");

                behavior = Integer.parseInt(br.readLine());

            }

        } catch (IOException e) {
            System.out.println("入力データに誤りがあります。");
            System.out.println(e);
        }
    }
}