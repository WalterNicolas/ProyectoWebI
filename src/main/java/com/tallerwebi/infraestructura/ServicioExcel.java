package com.tallerwebi.infraestructura;
import com.tallerwebi.dominio.Ejercicio;
import com.tallerwebi.dominio.RutinaDiaria;
import com.tallerwebi.dominio.RutinaSemanal;
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.stereotype.Service;

import javax.servlet.ServletOutputStream;
import java.io.IOException;

@Service
public
class ServicioExcel {

    public void getRutinaExcel(RutinaSemanal rutinaSemanal, ServletOutputStream nombreExcel) {
        Workbook workbook = new XSSFWorkbook();
        Sheet sheet = workbook.createSheet("Rutina Semanal");

        // Estilo para el encabezado
        CellStyle headerCellStyle = workbook.createCellStyle();
        Font headerFont = workbook.createFont();
        headerFont.setBold(true);
        headerCellStyle.setFont(headerFont);

        int rowNum = 0;

        // Encabezados
        Row headerRow = sheet.createRow(rowNum++);
        Cell cell = headerRow.createCell(0);
        cell.setCellValue("Duración");
        cell.setCellStyle(headerCellStyle);

        cell = headerRow.createCell(1);
        cell.setCellValue("Ejercicio");
        cell.setCellStyle(headerCellStyle);

        cell = headerRow.createCell(2);
        cell.setCellValue("Descripción");
        cell.setCellStyle(headerCellStyle);


        // Datos
        int i = 1;
        for (RutinaDiaria rutinaDiaria : rutinaSemanal.getRutinaDiaria()) {
            Row row2 = sheet.createRow(rowNum++);
            row2.createCell(0).setCellValue("dia"+ i);
            i++;
            for (Ejercicio ejercicio : rutinaDiaria.getEjercicios()) {
                Row row = sheet.createRow(rowNum++);
                row.createCell(0).setCellValue(ejercicio.getDuracion() + "min");
                System.out.println(ejercicio.getDuracion());
                row.createCell(1).setCellValue(ejercicio.getNombre());
                System.out.println(ejercicio.getNombre());
                row.createCell(2).setCellValue(ejercicio.getDescripcion());
                System.out.println(ejercicio.getDescripcion());
            }
        }

        // Auto-ajustar columnas
        sheet.autoSizeColumn(0);
        sheet.autoSizeColumn(1);
        sheet.autoSizeColumn(2);

        try {
            workbook.write(nombreExcel);
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                workbook.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
