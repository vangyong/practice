//package cn.segema.learn.util;
//
//import java.io.File;
//import java.io.FileInputStream;
//import java.io.FileOutputStream;
//import java.io.IOException;
//import java.io.UnsupportedEncodingException;
//import java.net.URLEncoder;
//import java.util.List;
//import java.util.Map;
//import java.util.Set;
//
//import javax.servlet.ServletOutputStream;
//import javax.servlet.http.HttpServletResponse;
//
//import org.apache.poi.ss.usermodel.Row;
//import org.apache.poi.ss.usermodel.Sheet;
//import org.apache.poi.xssf.streaming.SXSSFWorkbook;
//import org.codehaus.jackson.map.util.JSONPObject;
//import org.slf4j.Logger;
//import org.slf4j.LoggerFactory;
//import org.springframework.util.FileCopyUtils;
//
//import jxl.Workbook;
//import jxl.write.Label;
//import jxl.write.WritableSheet;
//import jxl.write.WritableWorkbook;
//import jxl.write.WriteException;
//
//
//public class ExcelWriter {
//    
//    private final static Logger logger = LoggerFactory.getLogger(ExcelWriter.class);
//
//    private static long exportCount;
//
//    /**
//     * @param response
//     * @param fileName 文件名称
//     * @param fieldMap key 字段名，value  字段中文名（excel表头）
//     * @param list  json 数据
//     * @throws IOException
//     */
//    public static void writeExcel(HttpServletResponse response, String fileName, Map<String, String> fieldMap,
//        List<JSONPObject> list) throws IOException {
//        fileName = fileName + ".xls";
//        response.setContentType("application/msexcel;charset=UTF-8");
//        response.setCharacterEncoding("UTF-8");
//        setFileDownloadHeader(response, fileName);
//        WritableWorkbook wbook = Workbook.createWorkbook(response.getOutputStream());
//        WritableSheet sheet = wbook.createSheet("数据", 0);
//        try {
//            // 填写表头
//            setSheetTitle(sheet, fieldMap);
//            // 填充数据
//            setSheetData(sheet, fieldMap, list);
//
//            wbook.write();
//        } catch (Exception e) {
//            logger.error(e.getMessage());
//        } finally {
//            try {
//                wbook.close();
//            } catch (IOException e) {
//                logger.error(e.getMessage());
//            } catch (WriteException e) {
//                logger.error(e.getMessage());
//            }
//        }
//    }
//
//    /**
//     * 将Excel写入临时文件
//     * @param wb
//     * @param fileName
//     */
//    public static void writeExcelToFile(SXSSFWorkbook wb, String filepath, String fileName) {
//        File dir = new File(filepath);
//        if (!dir.exists()) {
//            dir.mkdirs();
//        }
//        File file = new File(filepath + fileName);
//        if (!file.exists()) {
//            try {
//                file.createNewFile();
//            } catch (IOException e) {
//                e.printStackTrace();
//            }
//        }
//        try {
//            FileOutputStream fileOutputStream = new FileOutputStream(file);
//            wb.write(fileOutputStream);
//            fileOutputStream.close();
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//    }
//
//    /**
//     * @param response
//     * @param wb
//     */
//    public static void writeExcel(HttpServletResponse response, SXSSFWorkbook wb, String fileName) {
//        fileName = fileName + ".xlsx";
//        response.setContentType("application/msexcel;charset=UTF-8");
//        response.setCharacterEncoding("UTF-8");
//        setFileDownloadHeader(response, fileName);
//        ServletOutputStream outputStream = null;
//        try {
//            outputStream = response.getOutputStream();
//            wb.write(outputStream);
//            outputStream.flush();
//        } catch (Exception e) {
//            logger.error(e.getMessage());
//        }
//    }
//
//    /**
//     * @param response
//     */
//    public static void writeExcel(FileInputStream in, HttpServletResponse response, String fileName) {
//        fileName = fileName + ".xlsx";
//        response.setContentType("application/msexcel;charset=UTF-8");
//        response.setCharacterEncoding("UTF-8");
//        setFileDownloadHeader(response, fileName);
//        ServletOutputStream outputStream = null;
//        try {
//            FileCopyUtils.copy(in, response.getOutputStream());
//        } catch (Exception e) {
//            logger.error(e.getMessage());
//        }
//    }
//
//    private static void setSheetData(WritableSheet sheet, Map<String, String> fieldMap, List<JSONObject> list)
//        throws WriteException {
//        // 遍历并填充
//        int row = 1;
//        int i = 0;
//        Set<String> keySet = fieldMap.keySet();
//        for (JSONObject jo : list) {
//            i = 0;
//            for (String key : keySet) {
//                try {
//                    sheet.addCell(new Label(i, row, jo.getString(key)));
//                } catch (Exception e) {
//                    sheet.addCell(new Label(i, row, ""));
//                    logger.error(e.getMessage());
//                }
//                i++;
//            }
//            row++;
//        }
//    }
//
//    private static void setSheetTitle(WritableSheet sheet, Map<String, String> fieldMap) throws WriteException {
//        Set<Map.Entry<String, String>> entries = fieldMap.entrySet();
//        int i = 0;
//        for (Map.Entry<String, String> entry : entries) {
//            sheet.addCell(new Label(i, 0, entry.getValue()));
//            i++;
//        }
//    }
//
//    public static void setSheetData(Sheet sheet, Map<String, String> fieldMap, List<JsonRawString> list) {
//        // 遍历并填充
//        int rownum = sheet.getLastRowNum() + 1;
//        Set<String> keySet = fieldMap.keySet();
//        for (JsonRawString str : list) {
//            JSONObject jo = JSONObject.fromObject(str.toString());
//            Row row = sheet.createRow(rownum++);
//            setExportCount(++exportCount);
//            // logger.error("---" + getExportCount());
//            int i = 0;
//            for (String key : keySet) {
//                try {
//                    row.createCell(i).setCellValue(jo.getString(key));
//                } catch (Exception e) {
//                    row.createCell(i).setCellValue("");
//                    // logger.error(e.getMessage());
//                }
//                i++;
//            }
//        }
//    }
//
//    public static void setSheetData(Sheet sheet, Map<String, String> fieldMap, List<JSONObject> list, String... a) {
//        // 遍历并填充
//        int rownum = sheet.getLastRowNum() + 1;
//        Set<String> keySet = fieldMap.keySet();
//        for (JSONObject jo : list) {
//            Row row = sheet.createRow(rownum++);
//            setExportCount(++exportCount);
//            // logger.error("---" + getExportCount());
//            int i = 0;
//            for (String key : keySet) {
//                try {
//                    row.createCell(i).setCellValue(jo.getString(key));
//                } catch (Exception e) {
//                    row.createCell(i).setCellValue("");
//                    // logger.error(e.getMessage());
//                }
//                i++;
//            }
//        }
//    }
//
//    public static void setSheetData(Sheet sheet, Map<String, String> fieldMap, JSONObject jo) {
//        // 遍历并填充
//        int rownum = sheet.getLastRowNum() + 1;
//        Set<String> keySet = fieldMap.keySet();
//        Row row = sheet.createRow(rownum++);
//        setExportCount(++exportCount);
//        int i = 0;
//        for (String key : keySet) {
//            try {
//                row.createCell(i).setCellValue(jo.getString(key));
//            } catch (Exception e) {
//                row.createCell(i).setCellValue("");
//            }
//            i++;
//        }
//    }
//
//    public static void setSheetTitle(Sheet sheet, Map<String, String> fieldMap) {
//        Set<Map.Entry<String, String>> entries = fieldMap.entrySet();
//        int i = 0;
//        Row row = sheet.createRow(0);
//        for (Map.Entry<String, String> entry : entries) {
//            row.createCell(i++).setCellValue(entry.getValue());
//        }
//    }
//
//    public static void setFileDownloadHeader(HttpServletResponse response, String filename) {
//        String headerValue = "attachment;";
//        headerValue += " filename=\"" + encodeURIComponent(filename) + "\"";
//        // headerValue += " filename*=utf-8''" + encodeURIComponent(filename);
//        response.setHeader("Content-Disposition", headerValue);
//    }
//
//    /**
//     * <pre>
//     * 符合 RFC 3986 标准的“百分号URL编码”
//     * 在这个方法里，空格会被编码成%20，而不是+
//     * 和浏览器的encodeURIComponent行为一致
//     * </pre>
//     * @param value
//     * @return
//     */
//    public static String encodeURIComponent(String value) {
//        try {
//            return URLEncoder.encode(value, "UTF-8").replaceAll("\\+", "%20");
//        } catch (UnsupportedEncodingException e) {
//            e.printStackTrace();
//            return null;
//        }
//    }
//
//    public static long getExportCount() {
//        return exportCount;
//    }
//
//    public static void setExportCount(long exportCount) {
//        ExcelWriter.exportCount = exportCount;
//    }
//
//}
