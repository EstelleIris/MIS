package com.control;

import com.dao.AddDao;
import com.model.Teacher;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.poifs.filesystem.POIFSFileSystem;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;
import java.io.*;
import java.util.ArrayList;
import java.util.List;

@WebServlet("/importTeacherServlet")
@MultipartConfig(location = "D:\\exercise\\IdeaProjects\\healthcode\\src\\main\\webapp\\temp\\", fileSizeThreshold = 1024 * 100)
//非常重要，必须使用。使用该注解告诉容器该servlet能够处理multipart/form-data的请求
//使用该注解HttpServlet对象才可以得到表单数据的各部分
public class ImportTeacherServlet extends HttpServlet {
    private String getFilename(Part part) {
        String fileName = null;
        // 返回上传的文件部分的content-disposition请求头的值
        String header = part.getHeader("content-disposition");
        // 返回不带路径的文件名
        fileName = header.substring(header.lastIndexOf("=") + 2,
                header.length() - 1);
        return fileName;
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        AddDao dao = new AddDao();
        ArrayList<Teacher> teacherList = new ArrayList<Teacher>();
        String importMessage = null;
        Part p = request.getPart("fileName");
        String desPath = "D:\\exercise\\IdeaProjects\\MIS\\src\\main\\webapp\\temp\\";
        File f = new File(desPath);
        if (!f.exists()) {  // 若目录不存在，则创建目录
            f.mkdirs();
        }
        String fileName = getFilename(p);   // 得到文件名,例如 作业4.doc
        p.write(desPath + fileName);     // 将上传的文件写入磁盘
        if (fileName.endsWith(".txt")) {
            BufferedReader br = new BufferedReader(new InputStreamReader(p.getInputStream(), "UTF-8"));
            String str = "";
            int count = 0;
            while ((str = br.readLine()) != null) {
                if ((count++) != 0) {
                    String s[] = str.split("\t");
                    Teacher teacher = new Teacher();
                    teacher.setNo(s[0]);
                    teacher.setName(s[1]);
                    teacher.setSex(s[2]);
                    teacher.setAge(Integer.parseInt(s[3]));
                    teacher.setTitle(s[4]);
                    teacher.setPhone(s[5]);
                    teacherList.add(teacher);
                }
            }
        } else if (fileName.endsWith(".xlsx") || fileName.endsWith(".xls")) {
            List<Teacher> list = parseExcel(desPath + fileName);
            for (int i = 0; i < list.size(); i++) {
                Teacher teacher = new Teacher();
                teacher.setNo(list.get(i).getNo());
                teacher.setName(list.get(i).getName());
                teacher.setSex(list.get(i).getSex());
                teacher.setAge(list.get(i).getAge());
                teacher.setTitle(list.get(i).getTitle());
                teacher.setPhone(list.get(i).getPhone());
                teacherList.add(teacher);
            }
        }
        boolean success = dao.addTeacherList(teacherList);
        if (success) {
            importMessage = "<li>导入成功！</li>";
        } else {
            importMessage = "<li>导入失败！</li>";
        }
        request.setAttribute("importMessage", importMessage);
        RequestDispatcher rd = request.getRequestDispatcher("/import.jsp?type=teacher");
        rd.forward(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request, response);
    }

    // 解析Excel,读取内容,path Excel路径
    public static List<Teacher> parseExcel(String path) {
        List<Teacher> list = new ArrayList<Teacher>();
        File file = null;
        InputStream input = null;
        if (path != null && path.length() > 7) {
            // 判断文件是否是Excel(2003、2007)
            String suffix = path.substring(path.lastIndexOf("."), path.length());
            file = new File(path);
            try {
                input = new FileInputStream(file);
            } catch (FileNotFoundException e) {
                System.out.println("未找到指定的文件！");
            }
            // Excel2003
            if (".xls".equals(suffix)) {
                POIFSFileSystem fileSystem = null;
                // 工作簿
                HSSFWorkbook workBook = null;
                try {
                    fileSystem = new POIFSFileSystem(input);
                    workBook = new HSSFWorkbook(fileSystem);
                } catch (IOException e) {
                    e.printStackTrace();
                }
                // 获取第一个工作簿
                HSSFSheet sheet = workBook.getSheetAt(0);
                list = getContent((Sheet) sheet);
                // Excel2007
            } else if (".xlsx".equals(suffix)) {
                XSSFWorkbook workBook = null;
                try {
                    workBook = new XSSFWorkbook(input);
                } catch (IOException e) {
                    e.printStackTrace();
                }
                // 获取第一个工作簿
                XSSFSheet sheet = workBook.getSheetAt(0);
                list = getContent(sheet);
            }
        } else {
            System.out.println("非法的文件路径!");
        }
        return list;
    }

    // 获取Excel内容
    public static List<Teacher> getContent(Sheet sheet) {
        List<Teacher> list = new ArrayList<Teacher>();
        // Excel数据总行数
        int rowCount = sheet.getPhysicalNumberOfRows();
        // 遍历数据行，略过标题行，从第二行开始
        for (int i = 1; i < rowCount; i++) {
            Teacher teacher = new Teacher();
            Row row = sheet.getRow(i);
            int cellCount = row.getPhysicalNumberOfCells();
            // 遍历行单元格
            for (int j = 0; j < cellCount; j++) {
                Cell cell = row.getCell(j);
                cell.setCellType(Cell.CELL_TYPE_STRING);
                switch (j) {
                    case 0:
                        // 根据cell中的类型来输出数据
                        teacher.setNo(cell.getStringCellValue());
                        break;
                    case 1:
                        teacher.setName(cell.getStringCellValue());
                        break;
                    case 2:
                        teacher.setSex(cell.getStringCellValue());
                        break;
                    case 3:
                        teacher.setAge(Integer.parseInt(cell.getStringCellValue()));
                        break;
                    case 4:
                        teacher.setTitle(cell.getStringCellValue());
                        break;
                    case 5:
                        teacher.setPhone(cell.getStringCellValue());
                        break;
                }
            }
            list.add(teacher);
        }
        return list;
    }

}
