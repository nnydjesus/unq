package arena.traits

import arena.Function
import org.uqbar.arena.widgets.{Button,  Panel}
import org.uqbar.arena.windows.Dialog
import tadp.blocbaster.entidades.Socio


trait ButtonAcept extends Dialog[Socio] {

	override def addActions(container:Panel)= {
	  super.addActions(container);
		var button = new Button(container) with AsDefaultButton with DisableOnErrorButton ;
		button.setCaption("Aceptar")
			  .onClick(new Function(this.accept));
//			.onClick(new MessageSend(this, "accept"));
//		.onClick(new Function(() => println("Mira como te meneo")));
	}
  
}