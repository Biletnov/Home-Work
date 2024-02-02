import java.io.*;

public class FileManager {
    public void save(AppData data, String fileName) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(fileName))) {
            
            String headerLine = String.join(";", data.getHeader());
            writer.write(headerLine);
            writer.newLine();
            
            for (int[] row : data.getData()) {
                String dataLine = "";
                for (int value : row) {
                    dataLine += value + ";";
                }
                writer.write(dataLine);
                writer.newLine();
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
    
    public AppData load(String fileName) {
        AppData data = new AppData();
        try (BufferedReader reader = new BufferedReader(new FileReader(fileName))) {
            
            String headerLine = reader.readLine();
            String[] header = headerLine.split(";");
            data.setHeader(header);
            
            String line;
            int rowIndex = 0;
            while ((line = reader.readLine()) != null) {
                String[] parts = line.split(";");
                int[] row = new int[parts.length];
                for (int i = 0; i < parts.length; i++) {
                    row[i] = Integer.parseInt(parts[i]);
                }
                data.getData()[rowIndex] = row;
                rowIndex++;
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return data;
    }
}
