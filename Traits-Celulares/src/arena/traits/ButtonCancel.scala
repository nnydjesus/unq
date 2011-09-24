package arena.traits

import arena.Function
import org.uqbar.arena.widgets.{Button,  Panel}
import org.uqbar.arena.windows.Dialog
import tadp.blocbaster.entidades.Socio

trait ButtonCancel extends Dialog[Socio] {

	override def addActions(container:Panel)= {
		super.addActions(container);
		var button = new Button(container)
		button.setCaption("Cancelar")
			   .onClick(new Function(this.cancel));
	}
  
}