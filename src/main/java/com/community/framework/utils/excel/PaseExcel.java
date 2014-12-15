package com.community.framework.utils.excel;

import com.community.app.module.bean.BusinessCharger;
import com.community.framework.utils.CommonUtils;

import org.apache.commons.beanutils.BeanUtils;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;

import java.util.ArrayList;
import java.util.List;

import static com.community.framework.utils.CommonUtils.getCellValue;
import static com.community.framework.utils.CommonUtils.getMergedRegionValue;
import static com.community.framework.utils.CommonUtils.isMergedRegion;

/**
 * Created by Administrator on 2014/7/16.
 */
public class PaseExcel {
    public List parse(String path, int sheet0, int rowfrom, int columnfrom, int columnto, String[] columns) throws Exception {
        List list = new ArrayList();
        int i = 0;
        int c = 0;
        try {
            Workbook workbook = CommonUtils.getWorkbook(path);
            Sheet sheet = workbook.getSheetAt(sheet0);
            
            for(Row row : sheet) {
                BusinessCharger obj = new BusinessCharger();
                /*List idxList = new ArrayList();
            	for(int idx = 0; idx<=6; idx++) {
            		idxList.add(idx);
            	}*/
                //从第几行开始解析
                if(i >= rowfrom) {
                    for (Cell cell : row) {
                        int columnnum = cell.getColumnIndex();
                        c = columnnum;
                       /* for(int idx=0;idx<idxList.size();idx++) {
                        	int idxValue = (Integer) idxList.get(idx);
                        	if(idxValue == columnnum) {
                        		idxList.remove(idx);
                        	}
                        }*/
                        int rownum = cell.getRowIndex();

                        //到第几列时解析结束
                        if(columnfrom <= columnnum && columnnum <= columnto && columnnum <= columns.length - 1 ) {
                            String cellvalue = "";
                            if(isMergedRegion(sheet, rownum , columnnum)) {
                                cellvalue = getMergedRegionValue(sheet, rownum , columnnum);
                            } else {
                                    cellvalue = getCellValue(cell);
                            }
                            BeanUtils.setProperty(obj, columns[columnnum], cellvalue);
                            //++c;
                        }
                    }
                    /*for(int idx=0;idx<idxList.size();idx++) {
                    	int idxValue = (Integer) idxList.get(idx);
                    	BeanUtils.setProperty(obj, columns[idxValue], "");
                    }*/
                    //c = 0;  //归零
                    list.add(obj);
                }
                i++;
            }
        } catch (Exception e) {
            throw new Exception("Excel导入第"+i+"行第"+c+"列失败，请检查Excel数据格式是否正确！");
        }
        return list;
    }
}
