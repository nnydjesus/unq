package arena

import org.uqbar.arena.actions.MessageSend
import org.uqbar.arena.widgets.Button
import org.uqbar.arena.widgets.Panel
import org.uqbar.arena.windows.WindowOwner
import org.uqbar.commons.model.Home
import tadp.blocbaster.entidades.Socio

import org.uqbar.arena.windows.WindowOwner;

class EditSocio(owner:WindowOwner, socio:Socio) extends AbstractSocio(owner, socio) {
	
	override def executeTask() = getHome().update(getModel());
	
}