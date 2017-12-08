package com.example.demo2.library;

import fj.data.List;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.view.document.AbstractXlsView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import java.util.Map;

@Component("displayAllBooks")
public class ShowBooksExcel extends AbstractXlsView {

    @Override
    protected void buildExcelDocument(Map<String, Object> model,
                                      Workbook workbook,
                                      HttpServletRequest request,
                                      HttpServletResponse response) throws Exception {
        List<Book> books = (List<Book>) model.get("books");
        Sheet sheet = workbook.createSheet();
        books.zipIndex().foreachDoEffect(pair -> {
            Book book = pair._1();
            int idx = pair._2();
            Row r = sheet.createRow(idx);
            Cell c1 = r.createCell(0);
            c1.setCellValue(book.getTitle());
            Cell c2 = r.createCell(1);
            c2.setCellValue(book.getAuthor());
            Cell c3 = r.createCell(2);
            c3.setCellValue(book.getPrice());
        });

    }
}
