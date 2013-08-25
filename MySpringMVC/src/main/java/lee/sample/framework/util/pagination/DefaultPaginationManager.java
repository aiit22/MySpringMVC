package lee.sample.framework.util.pagination;

import java.util.Map;


/**
 * @Class Name : DefaultPaginationManager.java
 * <pre> 인터페이스 PaginationManager 기본 구현 클래스.
 * PaginationRenderer의 구현체를 빈설정 파일을 참조하여 반환한다. 
 * </pre>
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

public class DefaultPaginationManager implements PaginationManager{
	
	private Map<String, PaginationRenderer> rendererType;
	
	/**
	 * Set PaginationRenderer 구현 클래스
	 * @param rendererType - PaginationRenderer 구현 클래스 집합 Map.
	 */
	public void setRendererType(Map<String, PaginationRenderer> rendererType) {
		this.rendererType = rendererType;
	}
	
	/**
	 * 
	 * @param type - tag의 파라미터 값.
	 */
	public PaginationRenderer getRendererType(String type) {
		
		return (rendererType!=null && rendererType.containsKey(type)) ? (PaginationRenderer) rendererType.get(type):new DefaultPaginationRenderer();		
	}	
	
}