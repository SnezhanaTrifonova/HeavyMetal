package gym.heavymetal.service;

import gym.heavymetal.entity.SportsmanEntity;
import gym.heavymetal.repository.SportsmanRepository;
import lombok.RequiredArgsConstructor;
import org.apache.poi.ss.usermodel.BorderStyle;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFCellStyle;
import org.apache.poi.xssf.usermodel.XSSFFont;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.stereotype.Service;

import java.io.ByteArrayOutputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.List;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class SportsmanService {
    private final SportsmanRepository sportsmanRepository;

    public SportsmanEntity save(SportsmanEntity sportsman) {
        return sportsmanRepository.save(sportsman);
    }

    public List<SportsmanEntity> getAll() {
        return sportsmanRepository.findAll();
    }

    public SportsmanEntity getById(UUID id) {
        return sportsmanRepository.findById(id).orElse(null);
    }

    public UUID deleteById(UUID id) {
        sportsmanRepository.deleteById(id);
        return id;
    }

    public SportsmanEntity update(SportsmanEntity sportsman) {
        return save(sportsman);
    }

    public byte[] getAllInExcel() {
        List<SportsmanEntity> sportsmen = getAll();
        try (XSSFWorkbook workbook = new XSSFWorkbook(); ByteArrayOutputStream out = new ByteArrayOutputStream()) {
            XSSFSheet sheet = workbook.createSheet("Sportsmen");
            int rowNum = 0;


            XSSFCellStyle borderStyle = workbook.createCellStyle();
            borderStyle.setBorderTop(BorderStyle.THIN);
            borderStyle.setBorderBottom(BorderStyle.THIN);
            borderStyle.setBorderLeft(BorderStyle.THIN);
            borderStyle.setBorderRight(BorderStyle.THIN);

            XSSFCellStyle headerStyle = workbook.createCellStyle();
            XSSFFont font = workbook.createFont();
            font.setBold(true);
            headerStyle.setFont(font);

            Row headerRow = sheet.createRow(rowNum++);
            headerRow.createCell(0).setCellValue("ID");
            headerRow.createCell(1).setCellValue("Name");
            headerRow.createCell(2).setCellValue("Surname");
            headerRow.createCell(3).setCellValue("Barcode");

            for (Cell cell : headerRow) {
                cell.setCellStyle(headerStyle);
                cell.setCellStyle(borderStyle);
            }



            for (SportsmanEntity sportsman : sportsmen) {
                Row row = sheet.createRow(rowNum++);
                row.createCell(0).setCellValue(sportsman.getId().toString());
                row.createCell(1).setCellValue(sportsman.getName());
                row.createCell(2).setCellValue(sportsman.getSurname());
                row.createCell(3).setCellValue(sportsman.getBarcode());

                for (Cell cell : row) {
                    cell.setCellStyle(borderStyle);
                }
            }

//            for (Row row : sheet) {
//                for (Cell cell : row) {
//                    cell.setCellStyle(borderStyle);
//                }
//            }
            workbook.write(out);
            return out.toByteArray();
        } catch (IOException e) {
            e.printStackTrace();
            return new byte[0];
        }
    }
}
