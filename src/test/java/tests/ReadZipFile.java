package tests;

import com.codeborne.pdftest.PDF;
import com.codeborne.xlstest.XLS;
import com.opencsv.CSVReader;
import org.junit.jupiter.api.Test;

import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.List;
import java.util.zip.ZipEntry;
import java.util.zip.ZipInputStream;

import static org.assertj.core.api.Assertions.assertThat;

public class ReadZipFile {

    ClassLoader cl = ReadZipFile.class.getClassLoader();

    @Test
    void homeWork() throws Exception {
        try (
                InputStream resource = cl.getResourceAsStream("z.zip");
                ZipInputStream zip = new ZipInputStream(resource);
        ) {
            ZipEntry entry;
            while((entry = zip.getNextEntry()) != null) {
                if (entry.getName().equals("1.pdf")) {
                    PDF content = new PDF(zip);
                    assertThat(content.text).contains("11 ff");
                } else if (entry.getName().equals("2.csv")) {
                    CSVReader reader = new CSVReader(new InputStreamReader(zip));
                    List<String[]> content = reader.readAll();
                    assertThat(content.get(0)[0]).contains("ляля");
                } else if (entry.getName().equals("3.xlsx")) {
                    XLS content = new XLS(zip);
                    assertThat(content.excel.getSheetAt(0).getRow(1).getCell(0).
                            getStringCellValue()).contains("вв");
                }
            }
        }
    }
}
