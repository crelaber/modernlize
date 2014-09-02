package com.uwen.ur.common;

public class NormalDatagrid {
    private int total;
    private int state = 200;
    private String message;
    private Object footer;
    public NormalDatagrid(){}
    
    public Object getFooter() {
		return footer;
	}

	public void setFooter(Object footer) {
		this.footer = footer;
	}

	public NormalDatagrid(int total, Object rows) {
        super();
        this.total = total;
        this.rows = rows;
    }
    
    public NormalDatagrid(int total, Object rows, int state, String message) {
        super();
        this.total = total;
        this.rows = rows;
        this.state = state;
        this.message = message;
    }
    
    public NormalDatagrid(int total, Object rows,Object footer, int state, String message) {
        super();
        this.total = total;
        this.rows = rows;
        this.footer=footer;
        this.state = state;
        this.message = message;
    }
    
    public NormalDatagrid(int total, Object rows,Object footer) {
        super();
        this.total = total;
        this.rows = rows;
        this.footer=footer;
    }
    
    private Object rows;

    public int getTotal() {
        return total;
    }

    public void setTotal(int total) {
        this.total = total;
    }

    public Object getRows() {
        return rows;
    }

    public void setRows(Object rows) {
        this.rows = rows;
    }

	public int getState() {
		return state;
	}

	public void setState(int state) {
		this.state = state;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

}
