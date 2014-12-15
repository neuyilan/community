package com.community.framework.utils.excel;

import com.community.framework.utils.CommonUtils;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;

import static com.community.framework.utils.CommonUtils.*;

/**
 * Created by Administrator on 2014/7/16.
 * 检查Excel格式或数据是否符合要求
 */
public class CheckExcel {
    public String parse(String path, String filename, String filename2, int sheet0, int rowfrom, int columnfrom, int columnto) throws Exception {
        int i = 0; //行值
        int c = 0; //列值
        try {
            Workbook workbook = CommonUtils.getWorkbook(path);
            Sheet sheet = workbook.getSheetAt(sheet0);

            for(Row row : sheet) {
                //从第几行开始解析
                if(i >= rowfrom) {
                    int lastnum = row.getLastCellNum();
                    if(lastnum != 7) {
                        return getJSONString(false, "请检查Excel模板，正确模板为7列，您上传的模板为" + lastnum + "列。");
                    }
                    for(int m = 0; m < lastnum; m++) {
                        Cell cell = row.getCell(m);
                        if(m != 4) {
                            if(cell == null) {
                                return getJSONString(false, getMessage(i, m, "数据不能为空！"));
                            } else {
                                String value = getCellValue(cell).trim();
                                //判断手机号是否为数据并且是13位,第2列为手机号
                                if(m == 1 && !isMobileNO(value)) {
                                    return getJSONString(false, getMessage(i, m, "手机号格式不正确！"));
                                }
                                if(m == 6 && value.length() > 2000) {
                                    return getJSONString(false, getMessage(i, m, "您填写的通知内容超过了2000个字符！"));
                                }
                            }
                        }
                    }
                    c = 0;  //归零
                }
                i++;
            }
        } catch (Exception e) {
            throw new Exception("Excel导入第"+i+"行第"+c+"列失败，请检查Excel数据格式是否正确！");
        }
        return getJSONString(true, filename.concat("|").concat(filename2));
    }

    private String getMessage(int row, int column, String msg) {
        return "第"+(row+1)+"行,第"+(column+1)+"列，" + msg ;
    }
}