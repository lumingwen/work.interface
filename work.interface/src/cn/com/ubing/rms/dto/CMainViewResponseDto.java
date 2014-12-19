package cn.com.ubing.rms.dto;

import java.util.List;

import cn.com.ubing.common.dto.ResponseDto;
/**
 * c端主页接口响应dto
 *  
 * @author 邱全松 2014-11-17 上午10:37:54
 */
public class CMainViewResponseDto extends ResponseDto{
    private List<CMainFocusDto> focus;
    private CMainLastGoodsDto lastGoods;
    public List<CMainFocusDto> getFocus() {
        return focus;
    }
    public void setFocus(List<CMainFocusDto> focus) {
        this.focus = focus;
    }
    public CMainLastGoodsDto getLastGoods() {
        return lastGoods;
    }
    public void setLastGoods(CMainLastGoodsDto lastGoods) {
        this.lastGoods = lastGoods;
    }
    
}
