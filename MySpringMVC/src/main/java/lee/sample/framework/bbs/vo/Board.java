package lee.sample.framework.bbs.vo;

import java.io.Serializable;

public class Board implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 7727528724291872634L;
	
	int bbsId;
	String bbsTitle;
	String bbsContent;
	String bbsFile;
	
	public int getBbsId() {
		return bbsId;
	}
	public void setBbsId(int bbsId) {
		this.bbsId = bbsId;
	}
	public String getBbsTitle() {
		return bbsTitle;
	}
	public void setBbsTitle(String bbsTitle) {
		this.bbsTitle = bbsTitle;
	}
	public String getBbsContent() {
		return bbsContent;
	}
	public void setBbsContent(String bbsContent) {
		this.bbsContent = bbsContent;
	}
	public String getBbsFile() {
		return bbsFile;
	}
	public void setBbsFile(String bbsFile) {
		this.bbsFile = bbsFile;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	
	@Override
	public String toString() {
		return "Board [bbsId=" + bbsId + ", bbsTitle=" + bbsTitle
				+ ", bbsContent=" + bbsContent + ", bbsFile=" + bbsFile + "]";
	}
}
