package com.uwen.ur.util;

import java.util.List;
import java.util.Map;

import jxl.biff.DisplayFormat;
import jxl.format.Alignment;
import jxl.format.Border;
import jxl.format.BorderLineStyle;
import jxl.format.Colour;
import jxl.format.VerticalAlignment;
import jxl.write.Label;
import jxl.write.WritableCellFormat;
import jxl.write.WritableFont;
import jxl.write.WritableSheet;
import jxl.write.WriteException;

public class ExcelExport {

	// 导出excel
	/*
	 * public static void getExcel() { HttpServletResponse response =
	 * this.getContext().getResponse(); WritableWorkbook book = null; try {
	 * response.reset(); response.setContentType("application/msexcel");
	 * response.addHeader("Content-Disposition", "attachment;filename="+new
	 * String("作者数量统计.xls".getBytes(),"ISO8859_1")); OutputStream os =
	 * response.getOutputStream(); book = getBook(os);
	 * 
	 * book.write(); os.flush();
	 * 
	 * } catch (Exception e) { e.printStackTrace(); } finally { try {
	 * book.close(); } catch (WriteException e) { e.printStackTrace(); } catch
	 * (IOException e) { e.printStackTrace(); } }
	 * 
	 * }
	 */

	

	/**
	 * getTotalData方法对应的excel的sheet
	 */
	public static WritableSheet mapToSheet1(Map map, String title,
			WritableSheet sheet) {
		List list = null;
		try {
			if (map.containsKey("rows")) {
				list = (List) map.get("rows");
				sheet.mergeCells(0, 0, 1, 0);
				sheet.addCell(new Label(0, 0, title, getTitleCellFormat()));
				sheet.addCell(new Label(0, 1, "统计项", getDataCellFormat(null)));
				sheet.addCell(new Label(1, 1, "结果", getDataCellFormat(null)));
				sheet.setColumnView(0, 50);
				sheet.setColumnView(1, 25);
				for (int i = 0; i < list.size(); i++) {
					Map rowMap = (Map) list.get(i);
					String name = "";
					String value = "";
					if (rowMap.containsKey("name")) {
						name = (String) rowMap.get("name");
					}

					if (rowMap.containsKey("value")) {
						value = (String) rowMap.get("value");
					}
					sheet.addCell(new Label(0, i + 2, name,
							getDataCellFormat(null)));
					sheet.addCell(new Label(1, i + 2, value,
							getDataCellFormat(null)));
				}

			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return sheet;
	}

	/**
	 * getRegAuthorGroupByDay和getRegAuthorGroupByMonth方法对应的excel的sheet
	 */
	public static WritableSheet mapToSheet2(Map map, String title,
			WritableSheet sheet) {
		try {
			List datasetList = (List) map.get("dataset");
			List categoryList = (List) ((Map) map.get("categories"))
					.get("category");
			sheet.mergeCells(0, 0, datasetList.size(), 0);
			// 将定义好的单元格添加到工作表中
			sheet.setColumnView(0, 25);
			sheet.addCell(new Label(0, 0, title, getTitleCellFormat()));
			sheet.addCell(new Label(0, 1, "日期", getDataCellFormat(null)));
			for (int k = 0; k < datasetList.size(); k++) {
				Label name = new Label(k + 1, 1, ((Map) datasetList.get(k))
						.get("seriesname").toString(), getDataCellFormat(null));
				sheet.setColumnView(k + 1, 25);
				sheet.addCell(name);
			}

			// 填充月份
			for (int i = 0; i < categoryList.size(); i++) {
				Map resultMap = (Map) categoryList.get(i);
				String labelValue = resultMap.get("label").toString();
				Label time = new Label(0, i + 2, labelValue,
						getDataCellFormat(null));
				sheet.addCell(time);
			}
			// 填充值
			for (int i = 0; i < datasetList.size(); i++) {
				Map resultMap = (Map) datasetList.get(i);
				List<Map> list = (List) resultMap.get("data");
				for (int j = 0; j < list.size(); j++) {
					Map mp = list.get(j);
					jxl.write.Number number = new jxl.write.Number(i + 1,
							j + 2, Integer.valueOf(mp.get("value").toString()),
							getDataCellFormat(null));
					sheet.addCell(number);
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		return sheet;
	}

	/**
	 * 得到数据表头格式
	 * 
	 * @return
	 */
	public static WritableCellFormat getTitleCellFormat() {
		WritableCellFormat wcf = null;
		try {
			// 字体样式
			WritableFont wf = new WritableFont(WritableFont.TIMES, 12,
					WritableFont.NO_BOLD, false);// 最后一个为是否italic
			wf.setColour(Colour.BLACK);
			wcf = new WritableCellFormat(wf);
			// 对齐方式
			wcf.setAlignment(Alignment.CENTRE);
			wcf.setVerticalAlignment(VerticalAlignment.CENTRE);
			// 边框
			wcf.setBorder(Border.ALL, BorderLineStyle.THIN);
			// 背景色
			wcf.setBackground(Colour.GREY_25_PERCENT);
		} catch (WriteException e) {
			e.printStackTrace();
		}
		return wcf;
	}

	/**
	 * 得到数据格式
	 * 
	 * @return
	 */
	public static WritableCellFormat getDataCellFormat(
			DisplayFormat DisplayFormat) {
		WritableCellFormat wcf = null;
		try {
			WritableFont wf = new WritableFont(WritableFont.TIMES, 10,
					WritableFont.NO_BOLD, false);// 最后一个为是否italic
			if (DisplayFormat != null) {
				wcf = new WritableCellFormat(wf, DisplayFormat);
			} else {
				wcf = new WritableCellFormat(wf);
			}
			// 对齐方式
			wcf.setAlignment(Alignment.CENTRE);
			wcf.setVerticalAlignment(VerticalAlignment.CENTRE);

			// 边框
			wcf.setBorder(Border.LEFT, BorderLineStyle.THIN);
			wcf.setBorder(Border.BOTTOM, BorderLineStyle.THIN);
			wcf.setBorder(Border.RIGHT, BorderLineStyle.THIN);
			// 背景色
			wcf.setBackground(Colour.WHITE);
			wcf.setWrap(true);// 自动换行
		} catch (WriteException e) {
			e.printStackTrace();
		}
		return wcf;
	}

}
