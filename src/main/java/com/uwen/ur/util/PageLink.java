package com.uwen.ur.util;

/**
 * @author benlong.hao
 * @date 2012-12-12 上午11:36:12
 */
public class PageLink {

    private String linkUrl =null;

    private int numPerPage = 10; // 页大小

    private int showPage = 5;	//显示的导航页数

    private int totalRows; // 总记录数

    private int totalPages; // 总页数

    private int currentPage; // 起始页

    private int startIndex; // 起始行数

    private int lastIndex; // 结束行数

    private boolean hasNext;  //是否有下一页

    private boolean hasPrev; //是否有上一页

    private String pageParameterName ="pageNum";

    private String baseUrl ="";

    /**
     * 构造函数
     * @param currentPage
     * @param totalRows
     */
    public PageLink(int currentPage, int totalRows) {
        this.init(this.numPerPage, currentPage, totalRows);
    }
    /**
     * 构造函数
     * @param currentPage
     * @param totalRows
     * @param numPerPage
     */
    public PageLink(int currentPage,int totalRows,int numPerPage)
    {
        this.init(numPerPage, currentPage, totalRows);
    }

    public PageLink(int currentPage,int totalRows,int numPerPage,String pageParameterName)
    {
        this.pageParameterName =pageParameterName;
        this.init(numPerPage, currentPage, totalRows);
    }
    public void setBaseUrl(String baseUrl) {
        this.baseUrl = baseUrl;
    }

    public String getBaseUrl() {

        String retUrl = baseUrl ;

        if(retUrl.indexOf("?")>=0)
        {
            retUrl +="&rowcnt=" + this.totalRows;
        }
        else
        {
            retUrl +="?rowcnt=" + this.totalRows;
        }

        return retUrl;
    }

    public String getCurrentUrl()
    {
        String retUrl = this.getBaseUrl();
        if(this.getCurrentPage()>0)
        {
            retUrl+="&"+this.getPageParameterName()+"="+this.getCurrentPage();
        }
        return retUrl;
    }
    /**
     * 获取链接导航
     * @return ？
     */
    public String getNav()
    {
        String strNav ="";
        String baseUrl = this.getBaseUrl();
        if(this.getTotalPages()>1)
        {
            //strNav ="<form action=\""+ this.baseUrl +"\"  method=\"post\">";
        }


        if(this.getHasPrev())
        {
            strNav +="<a href=\"" + baseUrl + "&"+this.getPageParameterName()+"=" + (this.getCurrentPage()-1 )+ "\">上一页</a> ";
        }

        if(this.getTotalPages()>1)
        {
            //strNav += this.getGoFormInput();
            strNav += " "+this.getPageNav();
            //strNav+= " </form>";
        }
        if(this.getHasNext())
        {
            strNav +="<a href=\"" + baseUrl + "&"+this.getPageParameterName()+"=" + (this.getCurrentPage() +1 )+ "\">下一页</a> ";
        }
        //strNav="<span>" + strNav+"</span>";

//        if(this.getTotalPages()>0)
//        {
//            strNav +="第" + this.getCurrentPage() + "页/共" + this.getTotalPages() + "页";
//        }
//        else
//        {
//            strNav +="无记录/共0页";
//        }
        return strNav;
    }
    public String getPageNav()
    {
        StringBuilder pageLink=new StringBuilder("");
        int from =0,to=0,showOffset=2;
        if(this.totalPages>1)
        {
            String baseUrl = this.getBaseUrl();
            if(this.showPage>this.getTotalPages())
            {
                from = 1;
                to = this.getTotalPages();
            }
            else
            {
                from = this.getCurrentPage() - showOffset;
                to = from + this.showPage -1;
                if(from<1)
                {
                    to = this.getCurrentPage() + 1 - from;
                    from =1;
                    if(to - from< this.showPage)
                    {
                        to = this.showPage;
                    }
                }
                else if(to >this.getTotalPages() )
                {
                    from = this.getTotalPages() - this.showPage + 1;
                    to = this.getTotalPages();
                }
            }

            if(this.getCurrentPage() - showOffset > 1 && this.getTotalPages() > this.showPage) {
                pageLink.append("<a ");
                pageLink.append("href=\"").append(baseUrl).append("&").append(this.getPageParameterName()).append("=1\"");
                pageLink.append( " class=\"first\">1 ...</a> ");
            }
            if(this.getCurrentPage() > 1) {
                pageLink.append( "<a ");
                pageLink.append( "href=\"").append(baseUrl).append("&").append(this.getPageParameterName()).append("=").append((this.getCurrentPage()-1)).append("\"");
                pageLink.append( " class=\"prev\">&lsaquo;&lsaquo;</a>");
            }
            for(int i = from; i <= to; i++) {
                if(i == this.getCurrentPage()) {
                    pageLink.append( "<strong>"+i+"</strong>");
                } else {
                    pageLink.append( "<a ");
                    pageLink.append( "href=\"").append(baseUrl).append("&").append(this.getPageParameterName()).append("=").append(i).append("\"");
                    pageLink.append( ">").append(i).append("</a>");
                }
            }
            if(this.getCurrentPage() < this.getTotalPages()) {
                pageLink.append( "<a ");
                pageLink.append( "href=\"").append(baseUrl).append("&").append(this.getPageParameterName()).append("=").append(this.getCurrentPage()+1).append("\"");
                pageLink.append( " class=\"next\">&rsaquo;&rsaquo;</a>");
            }
            if(to < this.getTotalPages()) {
                pageLink.append( "<a ");
                pageLink.append( "href=\"").append(baseUrl).append("&").append(this.getPageParameterName()).append("=").append(this.getTotalPages()).append("\"");
                pageLink.append( " class=\"last\">...").append(this.getTotalPages()).append("</a>");
            }
            //multipage = "<em>&nbsp;"+this.getTotalRows()+"&nbsp;</em>"+multipage;
        }
        return pageLink.toString();
    }


    /**
     * 初始化
     * @param numPerPage
     * @param currentPage
     * @param totalRows
     */
    private void init(int numPerPage,int currentPage,int totalRows)
    {
        this.setNumPerPage(numPerPage);
        this.setCurrentPage(currentPage);
        this.setTotalRows(totalRows);
        this.setTotalPages();
        this.setHasNext();
        this.setHasPrev();
        this.setStartIndex();
        this.setLastIndex();
    }
    public int getCurrentPage() {
        return currentPage;
    }

    public void setCurrentPage(int currentPage) {
        this.currentPage = currentPage;
    }

    public boolean getHasNext() {
        return hasNext;
    }

    public void setHasNext() {
        this.hasNext = this.currentPage < this.totalPages;
    }

    public boolean getHasPrev() {
        return hasPrev;
    }

    public void setHasPrev() {
        this.hasPrev = this.currentPage > 1;
    }

    public int getLastIndex() {
        return lastIndex;
    }

    public void setLastIndex() {
        this.lastIndex = this.currentPage * this.numPerPage;
        if(this.lastIndex>=this.totalRows)
        {
            this.lastIndex=this.totalRows;
        }
    }

    public int getNumPerPage() {
        return numPerPage;
    }

    public void setNumPerPage(int numPerPage) {
        this.numPerPage = numPerPage;
    }

    public int getStartIndex() {
        return startIndex;
    }

    public void setStartIndex() {
        this.startIndex = (currentPage - 1) * numPerPage+1;
    }

    public int getTotalPages() {
        return totalPages;
    }

    public void setTotalPages() {
        if (this.totalRows % numPerPage == 0) {
            this.totalPages = this.totalRows / numPerPage;
        } else {
            this.totalPages = (this.totalRows / numPerPage) + 1;
        }
        if(this.currentPage>this.totalPages )
        {
            if(this.totalPages>0)
            {
                this.currentPage=this.totalPages;
            }
            else
            {
                this.currentPage=1;
            }
        }
        if(this.currentPage<1)
        {
            this.currentPage=1;
        }
    }

    public int getTotalRows() {
        return totalRows;
    }

    public void setTotalRows(int totalRows) {
        this.totalRows = totalRows;
    }
    public void setTotalPages(int totalPages) {
        this.totalPages = totalPages;
    }

    public String getPageParameterName() {
        return pageParameterName;
    }

    public void setPageParameterName(String pageParameterName) {
        this.pageParameterName = pageParameterName;
    }
}
