package cn.segema.learn.interview.base;

import java.util.List;

public abstract class AbstractExcelExportService<T> {

	public void exportExcel() {
		setHeader();
		List<T> data = getData();
		setData(data);
		doExport();
	}

	void setHeader() {

	}

	void setData(List<T> data) {

	}

	void doExport() {

	}

	protected abstract List<T> getData();
}
