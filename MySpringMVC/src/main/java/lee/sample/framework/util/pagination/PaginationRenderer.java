package lee.sample.framework.util.pagination;

/**
 * PaginationRenderer.java
 * 
 * @author 실행환경 개발팀 함철
 * @since 2009.06.01
 * @version 1.0
 * @see
 *
 * <pre>
 * << 개정이력(Modification Information) >>
 *   
 *   수정일      수정자           수정내용
 *  -------    --------    ---------------------------
 *   2009.05.30  함철            최초 생성
 *
 * </pre>
 */
public interface PaginationRenderer {
	
	public String renderPagination(PaginationInfo paginationInfo,String jsFunction);
	
}
