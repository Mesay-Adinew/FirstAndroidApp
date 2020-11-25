package com.example.myapplication

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.widget.Button
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import org.apache.poi.ss.usermodel.IndexedColors
import org.apache.poi.xssf.usermodel.XSSFWorkbook
import java.io.FileOutputStream
import java.util.*

class Execel : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_execel)
        val create = findViewById<Button>(R.id.create)
        create.setOnClickListener {
            datasheet()


        }
    }

    fun datasheet() {
        val COLUMNs = arrayOf<String>("Id", "Name", "Address", "Age")
        val customers = Arrays.asList(
            arrayOf("1", "Jack Smith", "Massachusetts", 23),
            arrayOf("2", "Adam Johnson", "New York", 27),
            arrayOf("3", "Katherin Carter", "Washington DC", 26),
            arrayOf("4", "Jack London", "Nevada", 33),
            arrayOf("5", "Jason Bourne", "California", 36)
        )

        val workbook = XSSFWorkbook()
        val createHelper = workbook.getCreationHelper()

        val sheet = workbook.createSheet("Customers")

        val headerFont = workbook.createFont()
        headerFont.setBold(true)
        headerFont.setColor(IndexedColors.BLUE.getIndex())

        val headerCellStyle = workbook.createCellStyle()
        headerCellStyle.setFont(headerFont)

        // Row for Header
        val headerRow = sheet.createRow(0)

        // Header
        for (col in COLUMNs.indices) {
            val cell = headerRow.createCell(col)
            cell.setCellValue(COLUMNs[col])
            cell.setCellStyle(headerCellStyle)
        }

        // CellStyle for Age
        val ageCellStyle = workbook.createCellStyle()
        ageCellStyle.setDataFormat(createHelper.createDataFormat().getFormat("#"))

        var rowIdx = 1
        for (customer in customers) {
            val row = sheet.createRow(rowIdx++)
            row.createCell(0).setCellValue(customer[1].toString())
            row.createCell(1).setCellValue(customer[2].toString())
            row.createCell(2).setCellValue(customer[3].toString())
            val ageCell = row.createCell(3)
            ageCell.setCellValue(customer[4].toString())
            ageCell.setCellStyle(ageCellStyle)
        }

        val fileOut = FileOutputStream("customers.xlsx")
        workbook.write(fileOut)
        fileOut.close()
        workbook.close()

    }


}
