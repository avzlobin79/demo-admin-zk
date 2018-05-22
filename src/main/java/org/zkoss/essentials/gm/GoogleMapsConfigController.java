package org.zkoss.essentials.gm;


import org.zkoss.gmaps.Ginfo;
import org.zkoss.gmaps.Gmaps;
import org.zkoss.gmaps.Gmarker;
import org.zkoss.zk.ui.Component;
import org.zkoss.zk.ui.select.SelectorComposer;
import org.zkoss.zk.ui.select.annotation.Listen;
import org.zkoss.zk.ui.select.annotation.Wire;
import org.zkoss.zul.Doublebox;
import org.zkoss.zul.Intbox;
import org.zkoss.zul.Radio;

public class GoogleMapsConfigController extends SelectorComposer<Component> {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	
	
	@Wire
	private Gmaps gmaps;
	
	@Wire
	private Ginfo info;
	
	@Wire
	private Gmarker marker;
	
	@Wire
	private Doublebox latitude, longitude;
	
	@Wire
	private Intbox zoom;
	
	@Override
	public void doAfterCompose(Component comp) throws Exception {
		super.doAfterCompose(comp);
		//���������� ������� �������
		latitude.setValue(55.7535991);
		longitude.setValue(37.62255270000003);
		//gmaps.setLat(55.7535991);
		//gmaps.setLng(37.62255270000003);
	
		zoom.setValue(gmaps.getZoom());
	}
	
	
	
	
	@Listen("onChange = #latitude, #longitude" )
	public void onPositionChange() {
		gmaps.panTo(latitude.getValue(), longitude.getValue());
	}
	
	@Listen("onChange = #zoom" )
	public void onZoomChange() {
		gmaps.setZoom(zoom.getValue());
	}

	@Listen("onClick = #toggleInfo") 
	public void onToggleInfo() {
		if (info.isOpen()) {
			marker.setOpen(true);
			info.setOpen(false);
		} else {
			marker.setOpen(false);
			info.setOpen(true);
		}
	}	
	
	@Listen("onMapMove = #gmaps") 
	public void onMapMove() {
		latitude.setValue(gmaps.getLat());
	longitude.setValue(gmaps.getLng());
	}	

	@Listen("onMapZoom = #gmaps") 
	public void onMapZoom() {
		zoom.setValue(gmaps.getZoom());
	}	

}

