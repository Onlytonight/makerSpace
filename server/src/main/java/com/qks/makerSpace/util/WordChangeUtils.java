package com.qks.makerSpace.util;

import org.apache.poi.xwpf.usermodel.*;
import org.apache.tomcat.util.http.fileupload.FileUtils;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.DefaultResourceLoader;
import org.springframework.core.io.Resource;
import org.springframework.util.ResourceUtils;

import java.io.*;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class WordChangeUtils {



    public static void searchAndReplace(OutputStream outStream , Map<String, Object> map,int kind) {
        try {
//            File file = null;
//            if (kind == 1) {
//                Resource resource = new DefaultResourceLoader().getResource("classpath:META-INF/resources/template/output_document.docx");
//                file = resource.getFile();
//            } else {
//                ClassPathResource resource_2 = new ClassPathResource("template/station.docx");
//                file = resource_2.getFile();
//            }
//            InputStream inputStream = new FileInputStream(file);
            InputStream inputStream = new ClassPathResource("template/output_document.docx").getInputStream();
            XWPFDocument document = new XWPFDocument(inputStream);

            /**
             * 替换段落中的指定文字
             */
            Iterator<XWPFParagraph> itPara = document.getParagraphsIterator();
            String text;
            Set<String> set;
            XWPFParagraph paragraph;
            List<XWPFRun> run;
            String key;
            while (itPara.hasNext()) {
                paragraph = itPara.next();
                set = map.keySet();
                Iterator<String> iterator = set.iterator();
                while (iterator.hasNext()) {
                    key = iterator.next();
                    run = paragraph.getRuns();
                    for (int i = 0, runSie = run.size(); i < runSie; i++) {
                        text = run.get(i).getText(run.get(i).getTextPosition());
                        if (text != null && text.equals(key)) {
                            run.get(i).setText(String.valueOf(map.get(key)), 0);
                        }
                    }
                }
            }
                /**
                 * 替换表格中的指定文字
                 */
            Iterator<XWPFTable> itTable = document.getTablesIterator();
            while (itTable.hasNext()) {
                XWPFTable table = itTable.next();
                int count = table.getNumberOfRows();
                for (int i = 0; i < count; i++) {
                    XWPFTableRow row = table.getRow(i);
                    List<XWPFTableCell> cells = row.getTableCells();
                    for (XWPFTableCell cell : cells) {
                        for (Map.Entry<String, Object> e : map.entrySet()) {
                            if (cell.getText().equals(e.getKey())) {
                                cell.removeParagraph(0);
                                cell.setText(String.valueOf(e.getValue()));
                            }
                        }
                    }
                }
            }
            document.write(outStream);
            outStream.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}