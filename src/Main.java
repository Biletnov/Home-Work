import java.util.Arrays;

/* Реализовать сохранение данных в csv файл; Реализовать загрузку данных из csv файла. Файл читается целиком.
Структура csv файла:
Строка заголовок с набором столбцов
Набор строк с целочисленными значениями
Разделитель между столбцами - символ точка с запятой (;)

Для хранения данных использовать класс вида:
public class AppData {
   private String[] header;
   private int[][] data;
   // ...
}
Если выполняется save(AppData data), то старые данные в файле полностью перезаписываются.  */
public class Main {
    public static void main(String[] args) {
        
        //  запись в файл
        AppData data = new AppData();
        data.setHeader(new String[]{"Value1", "Value2", "Value3"});
        data.setData(new int[][]{{125, 130, 120}, {220, 123, 300}});
        FileManager file = new FileManager();
        String fileName = "Test.csv";
        file.save(data, fileName);
        
        // чтение из файла
        FileManager readFile = new FileManager();
        AppData loadedData = readFile.load(fileName);
        System.out.println(Arrays.toString(loadedData.getHeader()));
        for (int[] row : loadedData.getData()) {
            System.out.println(Arrays.toString(row));
        }
        
    }
}
