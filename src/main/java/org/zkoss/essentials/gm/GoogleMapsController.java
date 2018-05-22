package org.zkoss.essentials.gm;
import org.zkoss.gmaps.Gmaps;
import org.zkoss.gmaps.Gmarker;
import org.zkoss.gmaps.LatLng;
import org.zkoss.gmaps.event.MapMouseEvent;
import org.zkoss.zk.ui.Component;
import org.zkoss.zk.ui.select.SelectorComposer;
import org.zkoss.zk.ui.select.annotation.Listen;
import org.zkoss.zk.ui.select.annotation.Wire;
import org.zkoss.zul.Radio;
 
public class GoogleMapsController extends SelectorComposer<Component>{
	@Wire
	private Gmaps gmaps;
	//@Wire
	//private Gmarker gm;
	
    /**
	 * 
	 */
	@Wire
	private Radio resource1;
	@Wire
	private Radio resource2;
	private String icons;
	private static final long serialVersionUID = 1L;

	@Listen("onClick = #resource1") 
	public void onResource1() {
		
		if (resource1.isSelected()) {icons="plus.png";}
		
		
	}
	@Listen("onClick = #resource2") 
	public void onResource2() {
		
		if (resource2.isSelected()) {icons="minus.png";}
		
		
	}
	
	@Listen("onMapClick = #gmaps")
    public void onMapClick(MapMouseEvent event) {
    
	Gmarker gmarker = event.getGmarker();
    LatLng latlng=event.getLatLng();
  Gmarker gm=new Gmarker();
    gm.setLat(latlng.getLatitude());
    gm.setLng(latlng.getLongitude());
    if (icons!=null)
    {gm.setIconImage(icons);
    gm.setContent("123");
   gm.setParent(gmaps);
   gmaps.setCenter(latlng.getLatitude(), latlng.getLongitude());
    
    }
   
   
        gm.setVisible(true);
        if(gmarker != null) {
            gmarker.setOpen(true);
        }
    }
}