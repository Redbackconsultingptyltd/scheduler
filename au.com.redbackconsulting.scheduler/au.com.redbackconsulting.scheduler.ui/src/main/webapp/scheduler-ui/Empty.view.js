sap.ui.jsview("schdeuler-ui.Empty", {

	/** Specifies the Controller belonging to this View. 
	* In the case that it is not implemented, or that "null" is returned, this View does not have a Controller.
	* @memberOf scheduler-ui.Empty
	*/ 
	getControllerName : function() {
		return "schdeuler-ui.Empty";
	},

	/** Is initially called once after the Controller has been instantiated. It is the place where the UI is constructed. 
	* Since the Controller is given to this method, its event handlers can be attached right away. 
	* @memberOf scheduler-ui.Empty
	*/ 
	createContent : function(oController) {
 		return new sap.m.Page({
			title: "Empty",
			content: [],
			footer: new sap.m.Bar({
				id: this.createId("master-footer")
				})
		});
	}

});