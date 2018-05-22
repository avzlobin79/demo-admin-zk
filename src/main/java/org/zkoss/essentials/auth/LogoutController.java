/* 
	Description:
		ZK Essentials
	History:
		Created by dennis

Copyright (C) 2012 Potix Corporation. All Rights Reserved.
*/
package org.zkoss.essentials.auth;



import org.zkoss.essentials.services.AuthenticationService;
import org.zkoss.essentials.services.IAuthenticationService;
import org.zkoss.zk.ui.Component;
import org.zkoss.zk.ui.Executions;
import org.zkoss.zk.ui.select.SelectorComposer;
import org.zkoss.zk.ui.select.annotation.Listen;

public class LogoutController extends SelectorComposer<Component> {
	private static final long serialVersionUID = 1L;
	
	//services
	IAuthenticationService authService = new AuthenticationService();
	
	@Listen("onClick=#logout")
	public void doLogout(){
		authService.logout();		
		Executions.sendRedirect("/auth/");
	}
}
